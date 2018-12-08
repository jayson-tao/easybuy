package com.yaorange.pojo;

import java.util.ArrayList;
import java.util.List;

public class TOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSsoIdIsNull() {
            addCriterion("sso_id is null");
            return (Criteria) this;
        }

        public Criteria andSsoIdIsNotNull() {
            addCriterion("sso_id is not null");
            return (Criteria) this;
        }

        public Criteria andSsoIdEqualTo(Long value) {
            addCriterion("sso_id =", value, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdNotEqualTo(Long value) {
            addCriterion("sso_id <>", value, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdGreaterThan(Long value) {
            addCriterion("sso_id >", value, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sso_id >=", value, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdLessThan(Long value) {
            addCriterion("sso_id <", value, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdLessThanOrEqualTo(Long value) {
            addCriterion("sso_id <=", value, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdIn(List<Long> values) {
            addCriterion("sso_id in", values, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdNotIn(List<Long> values) {
            addCriterion("sso_id not in", values, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdBetween(Long value1, Long value2) {
            addCriterion("sso_id between", value1, value2, "ssoId");
            return (Criteria) this;
        }

        public Criteria andSsoIdNotBetween(Long value1, Long value2) {
            addCriterion("sso_id not between", value1, value2, "ssoId");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Long value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Long value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Long value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Long value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Long value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Long> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Long> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Long value1, Long value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Long value1, Long value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andLeavewordIsNull() {
            addCriterion("leaveword is null");
            return (Criteria) this;
        }

        public Criteria andLeavewordIsNotNull() {
            addCriterion("leaveword is not null");
            return (Criteria) this;
        }

        public Criteria andLeavewordEqualTo(String value) {
            addCriterion("leaveword =", value, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordNotEqualTo(String value) {
            addCriterion("leaveword <>", value, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordGreaterThan(String value) {
            addCriterion("leaveword >", value, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordGreaterThanOrEqualTo(String value) {
            addCriterion("leaveword >=", value, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordLessThan(String value) {
            addCriterion("leaveword <", value, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordLessThanOrEqualTo(String value) {
            addCriterion("leaveword <=", value, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordLike(String value) {
            addCriterion("leaveword like", value, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordNotLike(String value) {
            addCriterion("leaveword not like", value, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordIn(List<String> values) {
            addCriterion("leaveword in", values, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordNotIn(List<String> values) {
            addCriterion("leaveword not in", values, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordBetween(String value1, String value2) {
            addCriterion("leaveword between", value1, value2, "leaveword");
            return (Criteria) this;
        }

        public Criteria andLeavewordNotBetween(String value1, String value2) {
            addCriterion("leaveword not between", value1, value2, "leaveword");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeIsNull() {
            addCriterion("carriage_fee is null");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeIsNotNull() {
            addCriterion("carriage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeEqualTo(Integer value) {
            addCriterion("carriage_fee =", value, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeNotEqualTo(Integer value) {
            addCriterion("carriage_fee <>", value, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeGreaterThan(Integer value) {
            addCriterion("carriage_fee >", value, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("carriage_fee >=", value, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeLessThan(Integer value) {
            addCriterion("carriage_fee <", value, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeLessThanOrEqualTo(Integer value) {
            addCriterion("carriage_fee <=", value, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeIn(List<Integer> values) {
            addCriterion("carriage_fee in", values, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeNotIn(List<Integer> values) {
            addCriterion("carriage_fee not in", values, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeBetween(Integer value1, Integer value2) {
            addCriterion("carriage_fee between", value1, value2, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andCarriageFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("carriage_fee not between", value1, value2, "carriageFee");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(Integer value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(Integer value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(Integer value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(Integer value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<Integer> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<Integer> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(Integer value1, Integer value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNull() {
            addCriterion("discount_money is null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNotNull() {
            addCriterion("discount_money is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyEqualTo(String value) {
            addCriterion("discount_money =", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotEqualTo(String value) {
            addCriterion("discount_money <>", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThan(String value) {
            addCriterion("discount_money >", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("discount_money >=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThan(String value) {
            addCriterion("discount_money <", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThanOrEqualTo(String value) {
            addCriterion("discount_money <=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLike(String value) {
            addCriterion("discount_money like", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotLike(String value) {
            addCriterion("discount_money not like", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIn(List<String> values) {
            addCriterion("discount_money in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotIn(List<String> values) {
            addCriterion("discount_money not in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyBetween(String value1, String value2) {
            addCriterion("discount_money between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotBetween(String value1, String value2) {
            addCriterion("discount_money not between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIsNull() {
            addCriterion("real_money is null");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIsNotNull() {
            addCriterion("real_money is not null");
            return (Criteria) this;
        }

        public Criteria andRealMoneyEqualTo(Integer value) {
            addCriterion("real_money =", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotEqualTo(Integer value) {
            addCriterion("real_money <>", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyGreaterThan(Integer value) {
            addCriterion("real_money >", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_money >=", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyLessThan(Integer value) {
            addCriterion("real_money <", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("real_money <=", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIn(List<Integer> values) {
            addCriterion("real_money in", values, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotIn(List<Integer> values) {
            addCriterion("real_money not in", values, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyBetween(Integer value1, Integer value2) {
            addCriterion("real_money between", value1, value2, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("real_money not between", value1, value2, "realMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNull() {
            addCriterion("pay_money is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(Integer value) {
            addCriterion("pay_money =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(Integer value) {
            addCriterion("pay_money <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(Integer value) {
            addCriterion("pay_money >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_money >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(Integer value) {
            addCriterion("pay_money <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("pay_money <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<Integer> values) {
            addCriterion("pay_money in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<Integer> values) {
            addCriterion("pay_money not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(Integer value1, Integer value2) {
            addCriterion("pay_money between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_money not between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNull() {
            addCriterion("pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNotNull() {
            addCriterion("pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelEqualTo(Byte value) {
            addCriterion("pay_channel =", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotEqualTo(Byte value) {
            addCriterion("pay_channel <>", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThan(Byte value) {
            addCriterion("pay_channel >", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_channel >=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThan(Byte value) {
            addCriterion("pay_channel <", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThanOrEqualTo(Byte value) {
            addCriterion("pay_channel <=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelIn(List<Byte> values) {
            addCriterion("pay_channel in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotIn(List<Byte> values) {
            addCriterion("pay_channel not in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelBetween(Byte value1, Byte value2) {
            addCriterion("pay_channel between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_channel not between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Long value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Long value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Long value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Long value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Long value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Long> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Long> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Long value1, Long value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Long value1, Long value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Long value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Long value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Long value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Long value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Long> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Long> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Long value1, Long value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyIsNull() {
            addCriterion("coupon_money is null");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyIsNotNull() {
            addCriterion("coupon_money is not null");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyEqualTo(Integer value) {
            addCriterion("coupon_money =", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotEqualTo(Integer value) {
            addCriterion("coupon_money <>", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyGreaterThan(Integer value) {
            addCriterion("coupon_money >", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_money >=", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyLessThan(Integer value) {
            addCriterion("coupon_money <", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_money <=", value, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyIn(List<Integer> values) {
            addCriterion("coupon_money in", values, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotIn(List<Integer> values) {
            addCriterion("coupon_money not in", values, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyBetween(Integer value1, Integer value2) {
            addCriterion("coupon_money between", value1, value2, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_money not between", value1, value2, "couponMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIsNull() {
            addCriterion("promotion_id is null");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIsNotNull() {
            addCriterion("promotion_id is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionIdEqualTo(Long value) {
            addCriterion("promotion_id =", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotEqualTo(Long value) {
            addCriterion("promotion_id <>", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdGreaterThan(Long value) {
            addCriterion("promotion_id >", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("promotion_id >=", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdLessThan(Long value) {
            addCriterion("promotion_id <", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdLessThanOrEqualTo(Long value) {
            addCriterion("promotion_id <=", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIn(List<Long> values) {
            addCriterion("promotion_id in", values, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotIn(List<Long> values) {
            addCriterion("promotion_id not in", values, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdBetween(Long value1, Long value2) {
            addCriterion("promotion_id between", value1, value2, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotBetween(Long value1, Long value2) {
            addCriterion("promotion_id not between", value1, value2, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyIsNull() {
            addCriterion("promotion_money is null");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyIsNotNull() {
            addCriterion("promotion_money is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyEqualTo(Integer value) {
            addCriterion("promotion_money =", value, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyNotEqualTo(Integer value) {
            addCriterion("promotion_money <>", value, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyGreaterThan(Integer value) {
            addCriterion("promotion_money >", value, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_money >=", value, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyLessThan(Integer value) {
            addCriterion("promotion_money <", value, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_money <=", value, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyIn(List<Integer> values) {
            addCriterion("promotion_money in", values, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyNotIn(List<Integer> values) {
            addCriterion("promotion_money not in", values, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyBetween(Integer value1, Integer value2) {
            addCriterion("promotion_money between", value1, value2, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_money not between", value1, value2, "promotionMoney");
            return (Criteria) this;
        }

        public Criteria andOrderFromIsNull() {
            addCriterion("order_from is null");
            return (Criteria) this;
        }

        public Criteria andOrderFromIsNotNull() {
            addCriterion("order_from is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFromEqualTo(Byte value) {
            addCriterion("order_from =", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotEqualTo(Byte value) {
            addCriterion("order_from <>", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromGreaterThan(Byte value) {
            addCriterion("order_from >", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_from >=", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromLessThan(Byte value) {
            addCriterion("order_from <", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromLessThanOrEqualTo(Byte value) {
            addCriterion("order_from <=", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromIn(List<Byte> values) {
            addCriterion("order_from in", values, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotIn(List<Byte> values) {
            addCriterion("order_from not in", values, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromBetween(Byte value1, Byte value2) {
            addCriterion("order_from between", value1, value2, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotBetween(Byte value1, Byte value2) {
            addCriterion("order_from not between", value1, value2, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIsNull() {
            addCriterion("finished_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIsNotNull() {
            addCriterion("finished_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeEqualTo(Long value) {
            addCriterion("finished_time =", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotEqualTo(Long value) {
            addCriterion("finished_time <>", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeGreaterThan(Long value) {
            addCriterion("finished_time >", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("finished_time >=", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeLessThan(Long value) {
            addCriterion("finished_time <", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeLessThanOrEqualTo(Long value) {
            addCriterion("finished_time <=", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIn(List<Long> values) {
            addCriterion("finished_time in", values, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotIn(List<Long> values) {
            addCriterion("finished_time not in", values, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeBetween(Long value1, Long value2) {
            addCriterion("finished_time between", value1, value2, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotBetween(Long value1, Long value2) {
            addCriterion("finished_time not between", value1, value2, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(Byte value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(Byte value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(Byte value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(Byte value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<Byte> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<Byte> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(Byte value1, Byte value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Long value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Long value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Long value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Long value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Long value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Long> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Long> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Long value1, Long value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Long value1, Long value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andShipStoreIsNull() {
            addCriterion("ship_store is null");
            return (Criteria) this;
        }

        public Criteria andShipStoreIsNotNull() {
            addCriterion("ship_store is not null");
            return (Criteria) this;
        }

        public Criteria andShipStoreEqualTo(Long value) {
            addCriterion("ship_store =", value, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreNotEqualTo(Long value) {
            addCriterion("ship_store <>", value, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreGreaterThan(Long value) {
            addCriterion("ship_store >", value, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreGreaterThanOrEqualTo(Long value) {
            addCriterion("ship_store >=", value, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreLessThan(Long value) {
            addCriterion("ship_store <", value, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreLessThanOrEqualTo(Long value) {
            addCriterion("ship_store <=", value, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreIn(List<Long> values) {
            addCriterion("ship_store in", values, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreNotIn(List<Long> values) {
            addCriterion("ship_store not in", values, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreBetween(Long value1, Long value2) {
            addCriterion("ship_store between", value1, value2, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipStoreNotBetween(Long value1, Long value2) {
            addCriterion("ship_store not between", value1, value2, "shipStore");
            return (Criteria) this;
        }

        public Criteria andShipSnIsNull() {
            addCriterion("ship_sn is null");
            return (Criteria) this;
        }

        public Criteria andShipSnIsNotNull() {
            addCriterion("ship_sn is not null");
            return (Criteria) this;
        }

        public Criteria andShipSnEqualTo(String value) {
            addCriterion("ship_sn =", value, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnNotEqualTo(String value) {
            addCriterion("ship_sn <>", value, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnGreaterThan(String value) {
            addCriterion("ship_sn >", value, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnGreaterThanOrEqualTo(String value) {
            addCriterion("ship_sn >=", value, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnLessThan(String value) {
            addCriterion("ship_sn <", value, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnLessThanOrEqualTo(String value) {
            addCriterion("ship_sn <=", value, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnLike(String value) {
            addCriterion("ship_sn like", value, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnNotLike(String value) {
            addCriterion("ship_sn not like", value, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnIn(List<String> values) {
            addCriterion("ship_sn in", values, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnNotIn(List<String> values) {
            addCriterion("ship_sn not in", values, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnBetween(String value1, String value2) {
            addCriterion("ship_sn between", value1, value2, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipSnNotBetween(String value1, String value2) {
            addCriterion("ship_sn not between", value1, value2, "shipSn");
            return (Criteria) this;
        }

        public Criteria andShipTimeIsNull() {
            addCriterion("ship_time is null");
            return (Criteria) this;
        }

        public Criteria andShipTimeIsNotNull() {
            addCriterion("ship_time is not null");
            return (Criteria) this;
        }

        public Criteria andShipTimeEqualTo(String value) {
            addCriterion("ship_time =", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotEqualTo(String value) {
            addCriterion("ship_time <>", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeGreaterThan(String value) {
            addCriterion("ship_time >", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ship_time >=", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeLessThan(String value) {
            addCriterion("ship_time <", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeLessThanOrEqualTo(String value) {
            addCriterion("ship_time <=", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeLike(String value) {
            addCriterion("ship_time like", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotLike(String value) {
            addCriterion("ship_time not like", value, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeIn(List<String> values) {
            addCriterion("ship_time in", values, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotIn(List<String> values) {
            addCriterion("ship_time not in", values, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeBetween(String value1, String value2) {
            addCriterion("ship_time between", value1, value2, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipTimeNotBetween(String value1, String value2) {
            addCriterion("ship_time not between", value1, value2, "shipTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeIsNull() {
            addCriterion("ship_send_time is null");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeIsNotNull() {
            addCriterion("ship_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeEqualTo(Long value) {
            addCriterion("ship_send_time =", value, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeNotEqualTo(Long value) {
            addCriterion("ship_send_time <>", value, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeGreaterThan(Long value) {
            addCriterion("ship_send_time >", value, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("ship_send_time >=", value, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeLessThan(Long value) {
            addCriterion("ship_send_time <", value, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeLessThanOrEqualTo(Long value) {
            addCriterion("ship_send_time <=", value, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeIn(List<Long> values) {
            addCriterion("ship_send_time in", values, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeNotIn(List<Long> values) {
            addCriterion("ship_send_time not in", values, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeBetween(Long value1, Long value2) {
            addCriterion("ship_send_time between", value1, value2, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andShipSendTimeNotBetween(Long value1, Long value2) {
            addCriterion("ship_send_time not between", value1, value2, "shipSendTime");
            return (Criteria) this;
        }

        public Criteria andDigestIsNull() {
            addCriterion("digest is null");
            return (Criteria) this;
        }

        public Criteria andDigestIsNotNull() {
            addCriterion("digest is not null");
            return (Criteria) this;
        }

        public Criteria andDigestEqualTo(String value) {
            addCriterion("digest =", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotEqualTo(String value) {
            addCriterion("digest <>", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThan(String value) {
            addCriterion("digest >", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThanOrEqualTo(String value) {
            addCriterion("digest >=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThan(String value) {
            addCriterion("digest <", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThanOrEqualTo(String value) {
            addCriterion("digest <=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLike(String value) {
            addCriterion("digest like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotLike(String value) {
            addCriterion("digest not like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestIn(List<String> values) {
            addCriterion("digest in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotIn(List<String> values) {
            addCriterion("digest not in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestBetween(String value1, String value2) {
            addCriterion("digest between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotBetween(String value1, String value2) {
            addCriterion("digest not between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateIsNull() {
            addCriterion("sale_return_state is null");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateIsNotNull() {
            addCriterion("sale_return_state is not null");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateEqualTo(Byte value) {
            addCriterion("sale_return_state =", value, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateNotEqualTo(Byte value) {
            addCriterion("sale_return_state <>", value, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateGreaterThan(Byte value) {
            addCriterion("sale_return_state >", value, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("sale_return_state >=", value, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateLessThan(Byte value) {
            addCriterion("sale_return_state <", value, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateLessThanOrEqualTo(Byte value) {
            addCriterion("sale_return_state <=", value, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateIn(List<Byte> values) {
            addCriterion("sale_return_state in", values, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateNotIn(List<Byte> values) {
            addCriterion("sale_return_state not in", values, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateBetween(Byte value1, Byte value2) {
            addCriterion("sale_return_state between", value1, value2, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andSaleReturnStateNotBetween(Byte value1, Byte value2) {
            addCriterion("sale_return_state not between", value1, value2, "saleReturnState");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnIsNull() {
            addCriterion("return_order_sn is null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnIsNotNull() {
            addCriterion("return_order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnEqualTo(String value) {
            addCriterion("return_order_sn =", value, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnNotEqualTo(String value) {
            addCriterion("return_order_sn <>", value, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnGreaterThan(String value) {
            addCriterion("return_order_sn >", value, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("return_order_sn >=", value, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnLessThan(String value) {
            addCriterion("return_order_sn <", value, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnLessThanOrEqualTo(String value) {
            addCriterion("return_order_sn <=", value, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnLike(String value) {
            addCriterion("return_order_sn like", value, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnNotLike(String value) {
            addCriterion("return_order_sn not like", value, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnIn(List<String> values) {
            addCriterion("return_order_sn in", values, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnNotIn(List<String> values) {
            addCriterion("return_order_sn not in", values, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnBetween(String value1, String value2) {
            addCriterion("return_order_sn between", value1, value2, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andReturnOrderSnNotBetween(String value1, String value2) {
            addCriterion("return_order_sn not between", value1, value2, "returnOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnIsNull() {
            addCriterion("change_order_sn is null");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnIsNotNull() {
            addCriterion("change_order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnEqualTo(String value) {
            addCriterion("change_order_sn =", value, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnNotEqualTo(String value) {
            addCriterion("change_order_sn <>", value, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnGreaterThan(String value) {
            addCriterion("change_order_sn >", value, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("change_order_sn >=", value, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnLessThan(String value) {
            addCriterion("change_order_sn <", value, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnLessThanOrEqualTo(String value) {
            addCriterion("change_order_sn <=", value, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnLike(String value) {
            addCriterion("change_order_sn like", value, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnNotLike(String value) {
            addCriterion("change_order_sn not like", value, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnIn(List<String> values) {
            addCriterion("change_order_sn in", values, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnNotIn(List<String> values) {
            addCriterion("change_order_sn not in", values, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnBetween(String value1, String value2) {
            addCriterion("change_order_sn between", value1, value2, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andChangeOrderSnNotBetween(String value1, String value2) {
            addCriterion("change_order_sn not between", value1, value2, "changeOrderSn");
            return (Criteria) this;
        }

        public Criteria andNeedBillIsNull() {
            addCriterion("need_bill is null");
            return (Criteria) this;
        }

        public Criteria andNeedBillIsNotNull() {
            addCriterion("need_bill is not null");
            return (Criteria) this;
        }

        public Criteria andNeedBillEqualTo(Byte value) {
            addCriterion("need_bill =", value, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillNotEqualTo(Byte value) {
            addCriterion("need_bill <>", value, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillGreaterThan(Byte value) {
            addCriterion("need_bill >", value, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillGreaterThanOrEqualTo(Byte value) {
            addCriterion("need_bill >=", value, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillLessThan(Byte value) {
            addCriterion("need_bill <", value, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillLessThanOrEqualTo(Byte value) {
            addCriterion("need_bill <=", value, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillIn(List<Byte> values) {
            addCriterion("need_bill in", values, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillNotIn(List<Byte> values) {
            addCriterion("need_bill not in", values, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillBetween(Byte value1, Byte value2) {
            addCriterion("need_bill between", value1, value2, "needBill");
            return (Criteria) this;
        }

        public Criteria andNeedBillNotBetween(Byte value1, Byte value2) {
            addCriterion("need_bill not between", value1, value2, "needBill");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeIsNull() {
            addCriterion("last_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeIsNotNull() {
            addCriterion("last_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeEqualTo(Long value) {
            addCriterion("last_pay_time =", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeNotEqualTo(Long value) {
            addCriterion("last_pay_time <>", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeGreaterThan(Long value) {
            addCriterion("last_pay_time >", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_pay_time >=", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeLessThan(Long value) {
            addCriterion("last_pay_time <", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeLessThanOrEqualTo(Long value) {
            addCriterion("last_pay_time <=", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeIn(List<Long> values) {
            addCriterion("last_pay_time in", values, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeNotIn(List<Long> values) {
            addCriterion("last_pay_time not in", values, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeBetween(Long value1, Long value2) {
            addCriterion("last_pay_time between", value1, value2, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeNotBetween(Long value1, Long value2) {
            addCriterion("last_pay_time not between", value1, value2, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeIsNull() {
            addCriterion("last_confirm_ship_time is null");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeIsNotNull() {
            addCriterion("last_confirm_ship_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeEqualTo(Long value) {
            addCriterion("last_confirm_ship_time =", value, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeNotEqualTo(Long value) {
            addCriterion("last_confirm_ship_time <>", value, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeGreaterThan(Long value) {
            addCriterion("last_confirm_ship_time >", value, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_confirm_ship_time >=", value, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeLessThan(Long value) {
            addCriterion("last_confirm_ship_time <", value, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeLessThanOrEqualTo(Long value) {
            addCriterion("last_confirm_ship_time <=", value, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeIn(List<Long> values) {
            addCriterion("last_confirm_ship_time in", values, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeNotIn(List<Long> values) {
            addCriterion("last_confirm_ship_time not in", values, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeBetween(Long value1, Long value2) {
            addCriterion("last_confirm_ship_time between", value1, value2, "lastConfirmShipTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmShipTimeNotBetween(Long value1, Long value2) {
            addCriterion("last_confirm_ship_time not between", value1, value2, "lastConfirmShipTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}