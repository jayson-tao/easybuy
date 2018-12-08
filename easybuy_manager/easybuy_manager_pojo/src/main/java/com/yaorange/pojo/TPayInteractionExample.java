package com.yaorange.pojo;

import java.util.ArrayList;
import java.util.List;

public class TPayInteractionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPayInteractionExample() {
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

        public Criteria andUnionPaySnIsNull() {
            addCriterion("union_pay_sn is null");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnIsNotNull() {
            addCriterion("union_pay_sn is not null");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnEqualTo(String value) {
            addCriterion("union_pay_sn =", value, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnNotEqualTo(String value) {
            addCriterion("union_pay_sn <>", value, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnGreaterThan(String value) {
            addCriterion("union_pay_sn >", value, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnGreaterThanOrEqualTo(String value) {
            addCriterion("union_pay_sn >=", value, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnLessThan(String value) {
            addCriterion("union_pay_sn <", value, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnLessThanOrEqualTo(String value) {
            addCriterion("union_pay_sn <=", value, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnLike(String value) {
            addCriterion("union_pay_sn like", value, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnNotLike(String value) {
            addCriterion("union_pay_sn not like", value, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnIn(List<String> values) {
            addCriterion("union_pay_sn in", values, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnNotIn(List<String> values) {
            addCriterion("union_pay_sn not in", values, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnBetween(String value1, String value2) {
            addCriterion("union_pay_sn between", value1, value2, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andUnionPaySnNotBetween(String value1, String value2) {
            addCriterion("union_pay_sn not between", value1, value2, "unionPaySn");
            return (Criteria) this;
        }

        public Criteria andPayBillIdIsNull() {
            addCriterion("pay_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andPayBillIdIsNotNull() {
            addCriterion("pay_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayBillIdEqualTo(Long value) {
            addCriterion("pay_bill_id =", value, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdNotEqualTo(Long value) {
            addCriterion("pay_bill_id <>", value, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdGreaterThan(Long value) {
            addCriterion("pay_bill_id >", value, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_bill_id >=", value, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdLessThan(Long value) {
            addCriterion("pay_bill_id <", value, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_bill_id <=", value, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdIn(List<Long> values) {
            addCriterion("pay_bill_id in", values, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdNotIn(List<Long> values) {
            addCriterion("pay_bill_id not in", values, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdBetween(Long value1, Long value2) {
            addCriterion("pay_bill_id between", value1, value2, "payBillId");
            return (Criteria) this;
        }

        public Criteria andPayBillIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_bill_id not between", value1, value2, "payBillId");
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

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Integer value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Integer value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Integer value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Integer value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Integer> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Integer> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Integer value1, Integer value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andReturnSeqIsNull() {
            addCriterion("return_seq is null");
            return (Criteria) this;
        }

        public Criteria andReturnSeqIsNotNull() {
            addCriterion("return_seq is not null");
            return (Criteria) this;
        }

        public Criteria andReturnSeqEqualTo(String value) {
            addCriterion("return_seq =", value, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqNotEqualTo(String value) {
            addCriterion("return_seq <>", value, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqGreaterThan(String value) {
            addCriterion("return_seq >", value, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqGreaterThanOrEqualTo(String value) {
            addCriterion("return_seq >=", value, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqLessThan(String value) {
            addCriterion("return_seq <", value, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqLessThanOrEqualTo(String value) {
            addCriterion("return_seq <=", value, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqLike(String value) {
            addCriterion("return_seq like", value, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqNotLike(String value) {
            addCriterion("return_seq not like", value, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqIn(List<String> values) {
            addCriterion("return_seq in", values, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqNotIn(List<String> values) {
            addCriterion("return_seq not in", values, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqBetween(String value1, String value2) {
            addCriterion("return_seq between", value1, value2, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnSeqNotBetween(String value1, String value2) {
            addCriterion("return_seq not between", value1, value2, "returnSeq");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyIsNull() {
            addCriterion("return_money is null");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyIsNotNull() {
            addCriterion("return_money is not null");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyEqualTo(Integer value) {
            addCriterion("return_money =", value, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyNotEqualTo(Integer value) {
            addCriterion("return_money <>", value, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyGreaterThan(Integer value) {
            addCriterion("return_money >", value, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_money >=", value, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyLessThan(Integer value) {
            addCriterion("return_money <", value, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("return_money <=", value, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyIn(List<Integer> values) {
            addCriterion("return_money in", values, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyNotIn(List<Integer> values) {
            addCriterion("return_money not in", values, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyBetween(Integer value1, Integer value2) {
            addCriterion("return_money between", value1, value2, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andReturnMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("return_money not between", value1, value2, "returnMoney");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNull() {
            addCriterion("notify_time is null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNotNull() {
            addCriterion("notify_time is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeEqualTo(Long value) {
            addCriterion("notify_time =", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotEqualTo(Long value) {
            addCriterion("notify_time <>", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThan(Long value) {
            addCriterion("notify_time >", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("notify_time >=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThan(Long value) {
            addCriterion("notify_time <", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThanOrEqualTo(Long value) {
            addCriterion("notify_time <=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIn(List<Long> values) {
            addCriterion("notify_time in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotIn(List<Long> values) {
            addCriterion("notify_time not in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeBetween(Long value1, Long value2) {
            addCriterion("notify_time between", value1, value2, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotBetween(Long value1, Long value2) {
            addCriterion("notify_time not between", value1, value2, "notifyTime");
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

        public Criteria andReactionDataIsNull() {
            addCriterion("reaction_data is null");
            return (Criteria) this;
        }

        public Criteria andReactionDataIsNotNull() {
            addCriterion("reaction_data is not null");
            return (Criteria) this;
        }

        public Criteria andReactionDataEqualTo(String value) {
            addCriterion("reaction_data =", value, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataNotEqualTo(String value) {
            addCriterion("reaction_data <>", value, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataGreaterThan(String value) {
            addCriterion("reaction_data >", value, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataGreaterThanOrEqualTo(String value) {
            addCriterion("reaction_data >=", value, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataLessThan(String value) {
            addCriterion("reaction_data <", value, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataLessThanOrEqualTo(String value) {
            addCriterion("reaction_data <=", value, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataLike(String value) {
            addCriterion("reaction_data like", value, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataNotLike(String value) {
            addCriterion("reaction_data not like", value, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataIn(List<String> values) {
            addCriterion("reaction_data in", values, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataNotIn(List<String> values) {
            addCriterion("reaction_data not in", values, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataBetween(String value1, String value2) {
            addCriterion("reaction_data between", value1, value2, "reactionData");
            return (Criteria) this;
        }

        public Criteria andReactionDataNotBetween(String value1, String value2) {
            addCriterion("reaction_data not between", value1, value2, "reactionData");
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