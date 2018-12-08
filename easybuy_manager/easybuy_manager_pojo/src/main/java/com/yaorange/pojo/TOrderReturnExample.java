package com.yaorange.pojo;

import java.util.ArrayList;
import java.util.List;

public class TOrderReturnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderReturnExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andReturnSnIsNull() {
            addCriterion("return_sn is null");
            return (Criteria) this;
        }

        public Criteria andReturnSnIsNotNull() {
            addCriterion("return_sn is not null");
            return (Criteria) this;
        }

        public Criteria andReturnSnEqualTo(String value) {
            addCriterion("return_sn =", value, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnNotEqualTo(String value) {
            addCriterion("return_sn <>", value, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnGreaterThan(String value) {
            addCriterion("return_sn >", value, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnGreaterThanOrEqualTo(String value) {
            addCriterion("return_sn >=", value, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnLessThan(String value) {
            addCriterion("return_sn <", value, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnLessThanOrEqualTo(String value) {
            addCriterion("return_sn <=", value, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnLike(String value) {
            addCriterion("return_sn like", value, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnNotLike(String value) {
            addCriterion("return_sn not like", value, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnIn(List<String> values) {
            addCriterion("return_sn in", values, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnNotIn(List<String> values) {
            addCriterion("return_sn not in", values, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnBetween(String value1, String value2) {
            addCriterion("return_sn between", value1, value2, "returnSn");
            return (Criteria) this;
        }

        public Criteria andReturnSnNotBetween(String value1, String value2) {
            addCriterion("return_sn not between", value1, value2, "returnSn");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Long value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Long value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Long value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Long value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Long value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Long> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Long> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Long value1, Long value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Long value1, Long value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
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

        public Criteria andReturnPayMoneyIsNull() {
            addCriterion("return_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyIsNotNull() {
            addCriterion("return_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyEqualTo(Integer value) {
            addCriterion("return_pay_money =", value, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyNotEqualTo(Integer value) {
            addCriterion("return_pay_money <>", value, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyGreaterThan(Integer value) {
            addCriterion("return_pay_money >", value, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_pay_money >=", value, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyLessThan(Integer value) {
            addCriterion("return_pay_money <", value, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("return_pay_money <=", value, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyIn(List<Integer> values) {
            addCriterion("return_pay_money in", values, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyNotIn(List<Integer> values) {
            addCriterion("return_pay_money not in", values, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyBetween(Integer value1, Integer value2) {
            addCriterion("return_pay_money between", value1, value2, "returnPayMoney");
            return (Criteria) this;
        }

        public Criteria andReturnPayMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("return_pay_money not between", value1, value2, "returnPayMoney");
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

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
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

        public Criteria andReturnShipStoreIsNull() {
            addCriterion("return_ship_store is null");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreIsNotNull() {
            addCriterion("return_ship_store is not null");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreEqualTo(Long value) {
            addCriterion("return_ship_store =", value, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreNotEqualTo(Long value) {
            addCriterion("return_ship_store <>", value, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreGreaterThan(Long value) {
            addCriterion("return_ship_store >", value, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreGreaterThanOrEqualTo(Long value) {
            addCriterion("return_ship_store >=", value, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreLessThan(Long value) {
            addCriterion("return_ship_store <", value, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreLessThanOrEqualTo(Long value) {
            addCriterion("return_ship_store <=", value, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreIn(List<Long> values) {
            addCriterion("return_ship_store in", values, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreNotIn(List<Long> values) {
            addCriterion("return_ship_store not in", values, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreBetween(Long value1, Long value2) {
            addCriterion("return_ship_store between", value1, value2, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipStoreNotBetween(Long value1, Long value2) {
            addCriterion("return_ship_store not between", value1, value2, "returnShipStore");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnIsNull() {
            addCriterion("return_ship_sn is null");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnIsNotNull() {
            addCriterion("return_ship_sn is not null");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnEqualTo(String value) {
            addCriterion("return_ship_sn =", value, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnNotEqualTo(String value) {
            addCriterion("return_ship_sn <>", value, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnGreaterThan(String value) {
            addCriterion("return_ship_sn >", value, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnGreaterThanOrEqualTo(String value) {
            addCriterion("return_ship_sn >=", value, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnLessThan(String value) {
            addCriterion("return_ship_sn <", value, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnLessThanOrEqualTo(String value) {
            addCriterion("return_ship_sn <=", value, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnLike(String value) {
            addCriterion("return_ship_sn like", value, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnNotLike(String value) {
            addCriterion("return_ship_sn not like", value, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnIn(List<String> values) {
            addCriterion("return_ship_sn in", values, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnNotIn(List<String> values) {
            addCriterion("return_ship_sn not in", values, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnBetween(String value1, String value2) {
            addCriterion("return_ship_sn between", value1, value2, "returnShipSn");
            return (Criteria) this;
        }

        public Criteria andReturnShipSnNotBetween(String value1, String value2) {
            addCriterion("return_ship_sn not between", value1, value2, "returnShipSn");
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