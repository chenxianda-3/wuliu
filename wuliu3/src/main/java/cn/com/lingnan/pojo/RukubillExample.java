package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RukubillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RukubillExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeIsNull() {
            addCriterion("jiehuotime is null");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeIsNotNull() {
            addCriterion("jiehuotime is not null");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeEqualTo(Date value) {
            addCriterion("jiehuotime =", value, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeNotEqualTo(Date value) {
            addCriterion("jiehuotime <>", value, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeGreaterThan(Date value) {
            addCriterion("jiehuotime >", value, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jiehuotime >=", value, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeLessThan(Date value) {
            addCriterion("jiehuotime <", value, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeLessThanOrEqualTo(Date value) {
            addCriterion("jiehuotime <=", value, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeIn(List<Date> values) {
            addCriterion("jiehuotime in", values, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeNotIn(List<Date> values) {
            addCriterion("jiehuotime not in", values, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeBetween(Date value1, Date value2) {
            addCriterion("jiehuotime between", value1, value2, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuotimeNotBetween(Date value1, Date value2) {
            addCriterion("jiehuotime not between", value1, value2, "jiehuotime");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleIsNull() {
            addCriterion("jiehuopeople is null");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleIsNotNull() {
            addCriterion("jiehuopeople is not null");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleEqualTo(String value) {
            addCriterion("jiehuopeople =", value, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleNotEqualTo(String value) {
            addCriterion("jiehuopeople <>", value, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleGreaterThan(String value) {
            addCriterion("jiehuopeople >", value, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleGreaterThanOrEqualTo(String value) {
            addCriterion("jiehuopeople >=", value, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleLessThan(String value) {
            addCriterion("jiehuopeople <", value, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleLessThanOrEqualTo(String value) {
            addCriterion("jiehuopeople <=", value, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleLike(String value) {
            addCriterion("jiehuopeople like", value, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleNotLike(String value) {
            addCriterion("jiehuopeople not like", value, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleIn(List<String> values) {
            addCriterion("jiehuopeople in", values, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleNotIn(List<String> values) {
            addCriterion("jiehuopeople not in", values, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleBetween(String value1, String value2) {
            addCriterion("jiehuopeople between", value1, value2, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuopeopleNotBetween(String value1, String value2) {
            addCriterion("jiehuopeople not between", value1, value2, "jiehuopeople");
            return (Criteria) this;
        }

        public Criteria andJiehuostationIsNull() {
            addCriterion("jiehuostation is null");
            return (Criteria) this;
        }

        public Criteria andJiehuostationIsNotNull() {
            addCriterion("jiehuostation is not null");
            return (Criteria) this;
        }

        public Criteria andJiehuostationEqualTo(String value) {
            addCriterion("jiehuostation =", value, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationNotEqualTo(String value) {
            addCriterion("jiehuostation <>", value, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationGreaterThan(String value) {
            addCriterion("jiehuostation >", value, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationGreaterThanOrEqualTo(String value) {
            addCriterion("jiehuostation >=", value, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationLessThan(String value) {
            addCriterion("jiehuostation <", value, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationLessThanOrEqualTo(String value) {
            addCriterion("jiehuostation <=", value, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationLike(String value) {
            addCriterion("jiehuostation like", value, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationNotLike(String value) {
            addCriterion("jiehuostation not like", value, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationIn(List<String> values) {
            addCriterion("jiehuostation in", values, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationNotIn(List<String> values) {
            addCriterion("jiehuostation not in", values, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationBetween(String value1, String value2) {
            addCriterion("jiehuostation between", value1, value2, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andJiehuostationNotBetween(String value1, String value2) {
            addCriterion("jiehuostation not between", value1, value2, "jiehuostation");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleIsNull() {
            addCriterion("fahuopeople is null");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleIsNotNull() {
            addCriterion("fahuopeople is not null");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleEqualTo(String value) {
            addCriterion("fahuopeople =", value, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleNotEqualTo(String value) {
            addCriterion("fahuopeople <>", value, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleGreaterThan(String value) {
            addCriterion("fahuopeople >", value, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleGreaterThanOrEqualTo(String value) {
            addCriterion("fahuopeople >=", value, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleLessThan(String value) {
            addCriterion("fahuopeople <", value, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleLessThanOrEqualTo(String value) {
            addCriterion("fahuopeople <=", value, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleLike(String value) {
            addCriterion("fahuopeople like", value, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleNotLike(String value) {
            addCriterion("fahuopeople not like", value, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleIn(List<String> values) {
            addCriterion("fahuopeople in", values, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleNotIn(List<String> values) {
            addCriterion("fahuopeople not in", values, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleBetween(String value1, String value2) {
            addCriterion("fahuopeople between", value1, value2, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuopeopleNotBetween(String value1, String value2) {
            addCriterion("fahuopeople not between", value1, value2, "fahuopeople");
            return (Criteria) this;
        }

        public Criteria andFahuostationIsNull() {
            addCriterion("fahuostation is null");
            return (Criteria) this;
        }

        public Criteria andFahuostationIsNotNull() {
            addCriterion("fahuostation is not null");
            return (Criteria) this;
        }

        public Criteria andFahuostationEqualTo(String value) {
            addCriterion("fahuostation =", value, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationNotEqualTo(String value) {
            addCriterion("fahuostation <>", value, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationGreaterThan(String value) {
            addCriterion("fahuostation >", value, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationGreaterThanOrEqualTo(String value) {
            addCriterion("fahuostation >=", value, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationLessThan(String value) {
            addCriterion("fahuostation <", value, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationLessThanOrEqualTo(String value) {
            addCriterion("fahuostation <=", value, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationLike(String value) {
            addCriterion("fahuostation like", value, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationNotLike(String value) {
            addCriterion("fahuostation not like", value, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationIn(List<String> values) {
            addCriterion("fahuostation in", values, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationNotIn(List<String> values) {
            addCriterion("fahuostation not in", values, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationBetween(String value1, String value2) {
            addCriterion("fahuostation between", value1, value2, "fahuostation");
            return (Criteria) this;
        }

        public Criteria andFahuostationNotBetween(String value1, String value2) {
            addCriterion("fahuostation not between", value1, value2, "fahuostation");
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