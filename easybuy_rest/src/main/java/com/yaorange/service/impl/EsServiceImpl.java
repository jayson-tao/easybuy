package com.yaorange.service.impl;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yaorange.query.ProductQuery;
import com.yaorange.service.EsService;
import com.yaorange.util.Page;

@Service
public class EsServiceImpl implements EsService {
	@Value("${ES_ADDRESS}")
	private String ES_ADDRESS;
	@Value("${ES_PORT}")
	private int ES_PORT;
	@Value("${ES_INDEX}")
	private String ES_INDEX;
	@Value("${ES_TYPE}")
	private String ES_TYPE;

	@Value("${ES_ALL_FIELD}")
	public String ES_ALL_FIELD;
	@Value("${PRODUCT_STATE}")
	public String PRODUCT_STATE;
	@Value("${PRODUCT_BRAND}")
	public String PRODUCT_BRAND;
	@Value("${PRODUCT_TYPE}")
	public String PRODUCT_TYPE;
	@Value("${PRODUCT_MAX_PRICE}")
	public String PRODUCT_MAX_PRICE;
	@Value("${PRODUCT_MIN_PRICE}")
	public String PRODUCT_MIN_PRICE;
	@Value("${PRODUCT_SALE_COUNT}")
	public String PRODUCT_SALE_COUNT;
	@Value("${PRODUCT_VIEW_COUNT}")
	public String PRODUCT_VIEW_COUNT;
	@Value("${PRODUCT_ONSALE_TIME}")
	public String PRODUCT_ONSALE_TIME;
	@Value("${PRODUCT_COMMENT_COUNT}")
	public String PRODUCT_COMMENT_COUNT;

	public TransportClient getClient() {
		TransportClient client = null;
		try {
			Settings settings = Settings.builder().put("client.transport.sniff", true).build();
			InetAddress byName = InetAddress.getByName(ES_ADDRESS);
			TransportAddress transportAddress = new TransportAddress(byName, ES_PORT);
			client = new PreBuiltTransportClient(settings).addTransportAddress(transportAddress);
		} catch (Exception e) {
		}
		return client;
	}

	@Override
	public Page<Map<String, Object>> queryFromEs(ProductQuery query) {
		SearchRequestBuilder searchBuilder = getClient().prepareSearch(ES_INDEX).setTypes(ES_TYPE);
		// 设置查询类型
		searchBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
		// 搜索语句
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		List<QueryBuilder> must = boolQuery.must();
		// 搜索关键字
		String keyword = query.getKeyword();
		if (StringUtils.isNotEmpty(keyword)) {
			must.add(QueryBuilders.matchQuery(ES_ALL_FIELD, keyword));
		}

		List<QueryBuilder> filter = boolQuery.filter();
		// 如果品牌不为空
		if (query.getBrand() != null) {
			filter.add(QueryBuilders.termQuery(PRODUCT_BRAND, query.getBrand()));
		}
		// 如果类目不为空
		if (query.getProductType() != null) {
			filter.add(QueryBuilders.termQuery(PRODUCT_TYPE, query.getProductType()));
		}

		searchBuilder.setQuery(boolQuery);

		String sortByWhat = query.getSort();
		String order = query.getOrder();
		SortOrder sortOrder = SortOrder.DESC;
		// 如果是升序
		if ("asc".equals(order)) {
			sortOrder = SortOrder.ASC;
		}
		// 综合
		if ("zh".equals(sortByWhat)) {
		}
		// 销量
		else if ("xl".equals(sortByWhat)) {
			searchBuilder.addSort(PRODUCT_SALE_COUNT, sortOrder);
		}
		// 新品
		if ("xp".equals(sortByWhat)) {
			searchBuilder.addSort(PRODUCT_ONSALE_TIME, sortOrder);
		}
		// 评论
		if ("pl".equals(sortByWhat)) {
			searchBuilder.addSort(PRODUCT_COMMENT_COUNT, sortOrder);
		}
		// 价格
		if ("jg".equals(sortByWhat)) {
			if (sortOrder == SortOrder.DESC) {
				searchBuilder.addSort(PRODUCT_MAX_PRICE, sortOrder);
			} else {
				searchBuilder.addSort(PRODUCT_MIN_PRICE, sortOrder);
			}
		}
		// 人气
		if ("rq".equals(sortByWhat)) {
			searchBuilder.addSort(PRODUCT_VIEW_COUNT, sortOrder);
		}

		// 设置分页
		searchBuilder.setFrom(query.getStart()).setSize(query.getRows()).setExplain(false);
		SearchResponse response = searchBuilder.get();
		SearchHits hits = response.getHits();
		// 获取总共条数
		int totalHits = (int) hits.getTotalHits();
		// 获取搜索到的商品
		List<Map<String, Object>> resources = new ArrayList<>();
		SearchHit[] hitDocs = hits.getHits();
		for (SearchHit searchHit : hitDocs) {
			Map<String, Object> resource = searchHit.getSourceAsMap();
			resources.add(resource);
		}

		Page<Map<String, Object>> page = new Page<>();
		page.setTotal(totalHits);
		page.setRows(resources);
		return page;
	}
	@Override
	public void saveDataToEsBulk(List<Map<String, Object>> dataList) {
		BulkRequestBuilder prepareBulk = getClient().prepareBulk();
		for (Map<String, Object> data : dataList) {
			long id = (long) data.get("id");
			IndexRequest indexRequest = new IndexRequest(ES_INDEX, ES_TYPE, id + "").source(data);
			UpdateRequest request = new UpdateRequest(ES_INDEX, ES_TYPE, id + "").doc(data).upsert(indexRequest);
			prepareBulk.add(request);
		}
		BulkResponse bulkResponse = prepareBulk.get();
		if (bulkResponse.hasFailures()) {
			System.out.println("批量添加失败");
		}
	}

	public long deleteFromEsBulk(Long[] ids) {
		BulkByScrollResponse response = DeleteByQueryAction.INSTANCE
				.newRequestBuilder(getClient())
				.filter(QueryBuilders.termsQuery("id", ids))
				.source(ES_INDEX).get();
		return response.getDeleted();
	}

	@Override
	public void saveDataToEs(String id, String json) {
		// TODO Auto-generated method stub
		
	}

}
