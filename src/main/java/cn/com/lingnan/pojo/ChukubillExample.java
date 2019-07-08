package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChukubillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChukubillExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLineresourceIsNull() {
            addCriterion("lineresource is null");
            return (Criteria) this;
        }

        public Criteria andLineresourceIsNotNull() {
            addCriterion("lineresource is not null");
            return (Criteria) this;
        }

        public Criteria andLineresourceEqualTo(String value) {
            addCriterion("lineresource =", value, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceNotEqualTo(String value) {
            addCriterion("lineresource <>", value, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceGreaterThan(String value) {
            addCriterion("lineresource >", value, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceGreaterThanOrEqualTo(String value) {
            addCriterion("lineresource >=", value, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceLessThan(String value) {
            addCriterion("lineresource <", value, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceLessThanOrEqualTo(String value) {
            addCriterion("lineresource <=", value, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceLike(String value) {
            addCriterion("lineresource like", value, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceNotLike(String value) {
            addCriterion("lineresource not like", value, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceIn(List<String> values) {
            addCriterion("lineresource in", values, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceNotIn(List<String> values) {
            addCriterion("lineresource not in", values, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceBetween(String value1, String value2) {
            addCriterion("lineresource between", value1, value2, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLineresourceNotBetween(String value1, String value2) {
            addCriterion("lineresource not between", value1, value2, "lineresource");
            return (Criteria) this;
        }

        public Criteria andLinedirectionIsNull() {
            addCriterion("linedirection is null");
            return (Criteria) this;
        }

        public Criteria andLinedirectionIsNotNull() {
            addCriterion("linedirection is not null");
            return (Criteria) this;
        }

        public Criteria andLinedirectionEqualTo(String value) {
            addCriterion("linedirection =", value, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionNotEqualTo(String value) {
            addCriterion("linedirection <>", value, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionGreaterThan(String value) {
            addCriterion("linedirection >", value, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionGreaterThanOrEqualTo(String value) {
            addCriterion("linedirection >=", value, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionLessThan(String value) {
            addCriterion("linedirection <", value, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionLessThanOrEqualTo(String value) {
            addCriterion("linedirection <=", value, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionLike(String value) {
            addCriterion("linedirection like", value, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionNotLike(String value) {
            addCriterion("linedirection not like", value, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionIn(List<String> values) {
            addCriterion("linedirection in", values, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionNotIn(List<String> values) {
            addCriterion("linedirection not in", values, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionBetween(String value1, String value2) {
            addCriterion("linedirection between", value1, value2, "linedirection");
            return (Criteria) this;
        }

        public Criteria andLinedirectionNotBetween(String value1, String value2) {
            addCriterion("linedirection not between", value1, value2, "linedirection");
            return (Criteria) this;
        }

        public Criteria andTransportwayIsNull() {
            addCriterion("transportway is null");
            return (Criteria) this;
        }

        public Criteria andTransportwayIsNotNull() {
            addCriterion("transportway is not null");
            return (Criteria) this;
        }

        public Criteria andTransportwayEqualTo(String value) {
            addCriterion("transportway =", value, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayNotEqualTo(String value) {
            addCriterion("transportway <>", value, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayGreaterThan(String value) {
            addCriterion("transportway >", value, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayGreaterThanOrEqualTo(String value) {
            addCriterion("transportway >=", value, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayLessThan(String value) {
            addCriterion("transportway <", value, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayLessThanOrEqualTo(String value) {
            addCriterion("transportway <=", value, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayLike(String value) {
            addCriterion("transportway like", value, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayNotLike(String value) {
            addCriterion("transportway not like", value, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayIn(List<String> values) {
            addCriterion("transportway in", values, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayNotIn(List<String> values) {
            addCriterion("transportway not in", values, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayBetween(String value1, String value2) {
            addCriterion("transportway between", value1, value2, "transportway");
            return (Criteria) this;
        }

        public Criteria andTransportwayNotBetween(String value1, String value2) {
            addCriterion("transportway not between", value1, value2, "transportway");
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

        public Criteria andJiaohuopeopleIsNull() {
            addCriterion("jiaohuopeople is null");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleIsNotNull() {
            addCriterion("jiaohuopeople is not null");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleEqualTo(String value) {
            addCriterion("jiaohuopeople =", value, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleNotEqualTo(String value) {
            addCriterion("jiaohuopeople <>", value, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleGreaterThan(String value) {
            addCriterion("jiaohuopeople >", value, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleGreaterThanOrEqualTo(String value) {
            addCriterion("jiaohuopeople >=", value, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleLessThan(String value) {
            addCriterion("jiaohuopeople <", value, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleLessThanOrEqualTo(String value) {
            addCriterion("jiaohuopeople <=", value, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleLike(String value) {
            addCriterion("jiaohuopeople like", value, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleNotLike(String value) {
            addCriterion("jiaohuopeople not like", value, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleIn(List<String> values) {
            addCriterion("jiaohuopeople in", values, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleNotIn(List<String> values) {
            addCriterion("jiaohuopeople not in", values, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleBetween(String value1, String value2) {
            addCriterion("jiaohuopeople between", value1, value2, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuopeopleNotBetween(String value1, String value2) {
            addCriterion("jiaohuopeople not between", value1, value2, "jiaohuopeople");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeIsNull() {
            addCriterion("jiaohuotime is null");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeIsNotNull() {
            addCriterion("jiaohuotime is not null");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeEqualTo(Date value) {
            addCriterion("jiaohuotime =", value, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeNotEqualTo(Date value) {
            addCriterion("jiaohuotime <>", value, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeGreaterThan(Date value) {
            addCriterion("jiaohuotime >", value, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jiaohuotime >=", value, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeLessThan(Date value) {
            addCriterion("jiaohuotime <", value, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeLessThanOrEqualTo(Date value) {
            addCriterion("jiaohuotime <=", value, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeIn(List<Date> values) {
            addCriterion("jiaohuotime in", values, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeNotIn(List<Date> values) {
            addCriterion("jiaohuotime not in", values, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeBetween(Date value1, Date value2) {
            addCriterion("jiaohuotime between", value1, value2, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuotimeNotBetween(Date value1, Date value2) {
            addCriterion("jiaohuotime not between", value1, value2, "jiaohuotime");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationIsNull() {
            addCriterion("jiaohuostation is null");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationIsNotNull() {
            addCriterion("jiaohuostation is not null");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationEqualTo(String value) {
            addCriterion("jiaohuostation =", value, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationNotEqualTo(String value) {
            addCriterion("jiaohuostation <>", value, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationGreaterThan(String value) {
            addCriterion("jiaohuostation >", value, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationGreaterThanOrEqualTo(String value) {
            addCriterion("jiaohuostation >=", value, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationLessThan(String value) {
            addCriterion("jiaohuostation <", value, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationLessThanOrEqualTo(String value) {
            addCriterion("jiaohuostation <=", value, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationLike(String value) {
            addCriterion("jiaohuostation like", value, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationNotLike(String value) {
            addCriterion("jiaohuostation not like", value, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationIn(List<String> values) {
            addCriterion("jiaohuostation in", values, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationNotIn(List<String> values) {
            addCriterion("jiaohuostation not in", values, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationBetween(String value1, String value2) {
            addCriterion("jiaohuostation between", value1, value2, "jiaohuostation");
            return (Criteria) this;
        }

        public Criteria andJiaohuostationNotBetween(String value1, String value2) {
            addCriterion("jiaohuostation not between", value1, value2, "jiaohuostation");
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