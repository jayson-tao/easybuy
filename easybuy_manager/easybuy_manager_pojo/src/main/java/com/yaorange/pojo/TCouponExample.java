package com.yaorange.pojo;

import java.util.ArrayList;
import java.util.List;

public class TCouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCouponExample() {
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

        public Criteria andValidateTimeIsNull() {
            addCriterion("validate_time is null");
            return (Criteria) this;
        }

        public Criteria andValidateTimeIsNotNull() {
            addCriterion("validate_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidateTimeEqualTo(Long value) {
            addCriterion("validate_time =", value, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeNotEqualTo(Long value) {
            addCriterion("validate_time <>", value, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeGreaterThan(Long value) {
            addCriterion("validate_time >", value, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("validate_time >=", value, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeLessThan(Long value) {
            addCriterion("validate_time <", value, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeLessThanOrEqualTo(Long value) {
            addCriterion("validate_time <=", value, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeIn(List<Long> values) {
            addCriterion("validate_time in", values, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeNotIn(List<Long> values) {
            addCriterion("validate_time not in", values, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeBetween(Long value1, Long value2) {
            addCriterion("validate_time between", value1, value2, "validateTime");
            return (Criteria) this;
        }

        public Criteria andValidateTimeNotBetween(Long value1, Long value2) {
            addCriterion("validate_time not between", value1, value2, "validateTime");
            return (Criteria) this;
        }

        public Criteria andScopeRulesIsNull() {
            addCriterion("scope_rules is null");
            return (Criteria) this;
        }

        public Criteria andScopeRulesIsNotNull() {
            addCriterion("scope_rules is not null");
            return (Criteria) this;
        }

        public Criteria andScopeRulesEqualTo(Long value) {
            addCriterion("scope_rules =", value, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesNotEqualTo(Long value) {
            addCriterion("scope_rules <>", value, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesGreaterThan(Long value) {
            addCriterion("scope_rules >", value, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesGreaterThanOrEqualTo(Long value) {
            addCriterion("scope_rules >=", value, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesLessThan(Long value) {
            addCriterion("scope_rules <", value, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesLessThanOrEqualTo(Long value) {
            addCriterion("scope_rules <=", value, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesIn(List<Long> values) {
            addCriterion("scope_rules in", values, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesNotIn(List<Long> values) {
            addCriterion("scope_rules not in", values, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesBetween(Long value1, Long value2) {
            addCriterion("scope_rules between", value1, value2, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andScopeRulesNotBetween(Long value1, Long value2) {
            addCriterion("scope_rules not between", value1, value2, "scopeRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesIsNull() {
            addCriterion("promotion_rules is null");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesIsNotNull() {
            addCriterion("promotion_rules is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesEqualTo(Long value) {
            addCriterion("promotion_rules =", value, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesNotEqualTo(Long value) {
            addCriterion("promotion_rules <>", value, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesGreaterThan(Long value) {
            addCriterion("promotion_rules >", value, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesGreaterThanOrEqualTo(Long value) {
            addCriterion("promotion_rules >=", value, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesLessThan(Long value) {
            addCriterion("promotion_rules <", value, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesLessThanOrEqualTo(Long value) {
            addCriterion("promotion_rules <=", value, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesIn(List<Long> values) {
            addCriterion("promotion_rules in", values, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesNotIn(List<Long> values) {
            addCriterion("promotion_rules not in", values, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesBetween(Long value1, Long value2) {
            addCriterion("promotion_rules between", value1, value2, "promotionRules");
            return (Criteria) this;
        }

        public Criteria andPromotionRulesNotBetween(Long value1, Long value2) {
            addCriterion("promotion_rules not between", value1, value2, "promotionRules");
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