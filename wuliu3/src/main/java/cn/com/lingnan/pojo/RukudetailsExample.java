package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.List;

public class RukudetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RukudetailsExample() {
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

        public Criteria andWorkorderIdIsNull() {
            addCriterion("workorder_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdIsNotNull() {
            addCriterion("workorder_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdEqualTo(String value) {
            addCriterion("workorder_id =", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotEqualTo(String value) {
            addCriterion("workorder_id <>", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdGreaterThan(String value) {
            addCriterion("workorder_id >", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_id >=", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdLessThan(String value) {
            addCriterion("workorder_id <", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdLessThanOrEqualTo(String value) {
            addCriterion("workorder_id <=", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdLike(String value) {
            addCriterion("workorder_id like", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotLike(String value) {
            addCriterion("workorder_id not like", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdIn(List<String> values) {
            addCriterion("workorder_id in", values, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotIn(List<String> values) {
            addCriterion("workorder_id not in", values, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdBetween(String value1, String value2) {
            addCriterion("workorder_id between", value1, value2, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotBetween(String value1, String value2) {
            addCriterion("workorder_id not between", value1, value2, "workorderId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdIsNull() {
            addCriterion("rukubill_id is null");
            return (Criteria) this;
        }

        public Criteria andRukubillIdIsNotNull() {
            addCriterion("rukubill_id is not null");
            return (Criteria) this;
        }

        public Criteria andRukubillIdEqualTo(String value) {
            addCriterion("rukubill_id =", value, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdNotEqualTo(String value) {
            addCriterion("rukubill_id <>", value, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdGreaterThan(String value) {
            addCriterion("rukubill_id >", value, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdGreaterThanOrEqualTo(String value) {
            addCriterion("rukubill_id >=", value, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdLessThan(String value) {
            addCriterion("rukubill_id <", value, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdLessThanOrEqualTo(String value) {
            addCriterion("rukubill_id <=", value, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdLike(String value) {
            addCriterion("rukubill_id like", value, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdNotLike(String value) {
            addCriterion("rukubill_id not like", value, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdIn(List<String> values) {
            addCriterion("rukubill_id in", values, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdNotIn(List<String> values) {
            addCriterion("rukubill_id not in", values, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdBetween(String value1, String value2) {
            addCriterion("rukubill_id between", value1, value2, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andRukubillIdNotBetween(String value1, String value2) {
            addCriterion("rukubill_id not between", value1, value2, "rukubillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdIsNull() {
            addCriterion("combinebill_id is null");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdIsNotNull() {
            addCriterion("combinebill_id is not null");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdEqualTo(String value) {
            addCriterion("combinebill_id =", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdNotEqualTo(String value) {
            addCriterion("combinebill_id <>", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdGreaterThan(String value) {
            addCriterion("combinebill_id >", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdGreaterThanOrEqualTo(String value) {
            addCriterion("combinebill_id >=", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdLessThan(String value) {
            addCriterion("combinebill_id <", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdLessThanOrEqualTo(String value) {
            addCriterion("combinebill_id <=", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdLike(String value) {
            addCriterion("combinebill_id like", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdNotLike(String value) {
            addCriterion("combinebill_id not like", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdIn(List<String> values) {
            addCriterion("combinebill_id in", values, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdNotIn(List<String> values) {
            addCriterion("combinebill_id not in", values, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdBetween(String value1, String value2) {
            addCriterion("combinebill_id between", value1, value2, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombineorderIdNotBetween(String value1, String value2) {
            addCriterion("combinebill_id not between", value1, value2, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andChukubillIdIsNull() {
            addCriterion("chukubill_id is null");
            return (Criteria) this;
        }

        public Criteria andChukubillIdIsNotNull() {
            addCriterion("chukubill_id is not null");
            return (Criteria) this;
        }

        public Criteria andChukubillIdEqualTo(String value) {
            addCriterion("chukubill_id =", value, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdNotEqualTo(String value) {
            addCriterion("chukubill_id <>", value, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdGreaterThan(String value) {
            addCriterion("chukubill_id >", value, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdGreaterThanOrEqualTo(String value) {
            addCriterion("chukubill_id >=", value, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdLessThan(String value) {
            addCriterion("chukubill_id <", value, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdLessThanOrEqualTo(String value) {
            addCriterion("chukubill_id <=", value, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdLike(String value) {
            addCriterion("chukubill_id like", value, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdNotLike(String value) {
            addCriterion("chukubill_id not like", value, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdIn(List<String> values) {
            addCriterion("chukubill_id in", values, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdNotIn(List<String> values) {
            addCriterion("chukubill_id not in", values, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdBetween(String value1, String value2) {
            addCriterion("chukubill_id between", value1, value2, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andChukubillIdNotBetween(String value1, String value2) {
            addCriterion("chukubill_id not between", value1, value2, "chukubillId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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