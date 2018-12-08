package com.yaorange.pojo;

import java.util.ArrayList;
import java.util.List;

public class TProductViewPropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TProductViewPropertyExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdIsNull() {
            addCriterion("property_key_id is null");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdIsNotNull() {
            addCriterion("property_key_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdEqualTo(Long value) {
            addCriterion("property_key_id =", value, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdNotEqualTo(Long value) {
            addCriterion("property_key_id <>", value, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdGreaterThan(Long value) {
            addCriterion("property_key_id >", value, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("property_key_id >=", value, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdLessThan(Long value) {
            addCriterion("property_key_id <", value, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdLessThanOrEqualTo(Long value) {
            addCriterion("property_key_id <=", value, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdIn(List<Long> values) {
            addCriterion("property_key_id in", values, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdNotIn(List<Long> values) {
            addCriterion("property_key_id not in", values, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdBetween(Long value1, Long value2) {
            addCriterion("property_key_id between", value1, value2, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIdNotBetween(Long value1, Long value2) {
            addCriterion("property_key_id not between", value1, value2, "propertyKeyId");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIsNull() {
            addCriterion("property_key is null");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIsNotNull() {
            addCriterion("property_key is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyEqualTo(String value) {
            addCriterion("property_key =", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyNotEqualTo(String value) {
            addCriterion("property_key <>", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyGreaterThan(String value) {
            addCriterion("property_key >", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyGreaterThanOrEqualTo(String value) {
            addCriterion("property_key >=", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyLessThan(String value) {
            addCriterion("property_key <", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyLessThanOrEqualTo(String value) {
            addCriterion("property_key <=", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyLike(String value) {
            addCriterion("property_key like", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyNotLike(String value) {
            addCriterion("property_key not like", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIn(List<String> values) {
            addCriterion("property_key in", values, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyNotIn(List<String> values) {
            addCriterion("property_key not in", values, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyBetween(String value1, String value2) {
            addCriterion("property_key between", value1, value2, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyNotBetween(String value1, String value2) {
            addCriterion("property_key not between", value1, value2, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIsNull() {
            addCriterion("property_value_id is null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIsNotNull() {
            addCriterion("property_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdEqualTo(Long value) {
            addCriterion("property_value_id =", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotEqualTo(Long value) {
            addCriterion("property_value_id <>", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdGreaterThan(Long value) {
            addCriterion("property_value_id >", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("property_value_id >=", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdLessThan(Long value) {
            addCriterion("property_value_id <", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdLessThanOrEqualTo(Long value) {
            addCriterion("property_value_id <=", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIn(List<Long> values) {
            addCriterion("property_value_id in", values, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotIn(List<Long> values) {
            addCriterion("property_value_id not in", values, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdBetween(Long value1, Long value2) {
            addCriterion("property_value_id between", value1, value2, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotBetween(Long value1, Long value2) {
            addCriterion("property_value_id not between", value1, value2, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIsNull() {
            addCriterion("property_value is null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIsNotNull() {
            addCriterion("property_value is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueEqualTo(String value) {
            addCriterion("property_value =", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueNotEqualTo(String value) {
            addCriterion("property_value <>", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueGreaterThan(String value) {
            addCriterion("property_value >", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueGreaterThanOrEqualTo(String value) {
            addCriterion("property_value >=", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueLessThan(String value) {
            addCriterion("property_value <", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueLessThanOrEqualTo(String value) {
            addCriterion("property_value <=", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueLike(String value) {
            addCriterion("property_value like", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueNotLike(String value) {
            addCriterion("property_value not like", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIn(List<String> values) {
            addCriterion("property_value in", values, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueNotIn(List<String> values) {
            addCriterion("property_value not in", values, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueBetween(String value1, String value2) {
            addCriterion("property_value between", value1, value2, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueNotBetween(String value1, String value2) {
            addCriterion("property_value not between", value1, value2, "propertyValue");
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