package com.yaorange.service.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yaorange.service.EsService;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

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
    public void saveDataToEs(String id, String json) {
        try {
            IndexRequest indexRequest = new IndexRequest(ES_INDEX, ES_TYPE, id).source(json);
            UpdateRequest request = new UpdateRequest(ES_INDEX, ES_TYPE, id).doc(json).upsert(indexRequest);
            ActionFuture<UpdateResponse> update = getClient().update(request);
            UpdateResponse updateResponse = update.get();
        } catch (Exception e) {

        }

    }

    @Override
    public void saveDataToEsBulk(List<Map<String, Object>> list) throws IOException {
        TransportClient client = getClient();
        BulkRequestBuilder prepareBulk = client.prepareBulk();
        for (Map<String, Object> data : list) {
            prepareBulk.add(client.prepareIndex(ES_INDEX, ES_TYPE, data.get("id") + "")
                    .setSource(data)
            );
        }
        BulkResponse bulkResponse = prepareBulk.get();
        if (bulkResponse.hasFailures()) {
            System.out.println("批量添加失败");
        }
    }

    /**
     * 批量删除-es
     *
     * @param ids
     * @return
     */
    @Override
    public long deleteFromEsBulk(List<Long> ids) {
        // DeleteResponse response = client.prepareDelete("twitter", "_doc", "1").get();
        TransportClient client = getClient();
        BulkRequestBuilder prepareBulk = client.prepareBulk();
        for (Long id : ids) {
            DeleteRequestBuilder response = client.prepareDelete(ES_INDEX, ES_TYPE, id + "");
            prepareBulk.add(response);
        }
        BulkResponse bulkResponse = prepareBulk.get();
        if (bulkResponse.hasFailures()) {
            System.out.println("批量添加失败");
        }
        return 0;
    }

}
