package com.yaorange.pojo;

import java.util.ArrayList;
import java.util.List;

public class TSeckillResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSeckillResultExample() {
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

        public Criteria andSeckillSkuIdIsNull() {
            addCriterion("seckill_sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdIsNotNull() {
            addCriterion("seckill_sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdEqualTo(Long value) {
            addCriterion("seckill_sku_id =", value, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdNotEqualTo(Long value) {
            addCriterion("seckill_sku_id <>", value, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdGreaterThan(Long value) {
            addCriterion("seckill_sku_id >", value, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("seckill_sku_id >=", value, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdLessThan(Long value) {
            addCriterion("seckill_sku_id <", value, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("seckill_sku_id <=", value, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdIn(List<Long> values) {
            addCriterion("seckill_sku_id in", values, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdNotIn(List<Long> values) {
            addCriterion("seckill_sku_id not in", values, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdBetween(Long value1, Long value2) {
            addCriterion("seckill_sku_id between", value1, value2, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andSeckillSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("seckill_sku_id not between", value1, value2, "seckillSkuId");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNull() {
            addCriterion("total_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("total_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(Integer value) {
            addCriterion("total_count =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(Integer value) {
            addCriterion("total_count <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(Integer value) {
            addCriterion("total_count >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_count >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(Integer value) {
            addCriterion("total_count <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_count <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<Integer> values) {
            addCriterion("total_count in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<Integer> values) {
            addCriterion("total_count not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(Integer value1, Integer value2) {
            addCriterion("total_count between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_count not between", value1, value2, "totalCount");
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

        public Criteria andLastConfirmTimeIsNull() {
            addCriterion("last_confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeIsNotNull() {
            addCriterion("last_confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeEqualTo(Long value) {
            addCriterion("last_confirm_time =", value, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeNotEqualTo(Long value) {
            addCriterion("last_confirm_time <>", value, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeGreaterThan(Long value) {
            addCriterion("last_confirm_time >", value, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_confirm_time >=", value, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeLessThan(Long value) {
            addCriterion("last_confirm_time <", value, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeLessThanOrEqualTo(Long value) {
            addCriterion("last_confirm_time <=", value, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeIn(List<Long> values) {
            addCriterion("last_confirm_time in", values, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeNotIn(List<Long> values) {
            addCriterion("last_confirm_time not in", values, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeBetween(Long value1, Long value2) {
            addCriterion("last_confirm_time between", value1, value2, "lastConfirmTime");
            return (Criteria) this;
        }

        public Criteria andLastConfirmTimeNotBetween(Long value1, Long value2) {
            addCriterion("last_confirm_time not between", value1, value2, "lastConfirmTime");
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