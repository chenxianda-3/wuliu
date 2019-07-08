package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.List;

public class SubareaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubareaExample() {
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

        public Criteria andDecidedzoneIdIsNull() {
            addCriterion("decidedzone_id is null");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdIsNotNull() {
            addCriterion("decidedzone_id is not null");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdEqualTo(String value) {
            addCriterion("decidedzone_id =", value, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdNotEqualTo(String value) {
            addCriterion("decidedzone_id <>", value, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdGreaterThan(String value) {
            addCriterion("decidedzone_id >", value, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdGreaterThanOrEqualTo(String value) {
            addCriterion("decidedzone_id >=", value, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdLessThan(String value) {
            addCriterion("decidedzone_id <", value, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdLessThanOrEqualTo(String value) {
            addCriterion("decidedzone_id <=", value, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdLike(String value) {
            addCriterion("decidedzone_id like", value, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdNotLike(String value) {
            addCriterion("decidedzone_id not like", value, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdIn(List<String> values) {
            addCriterion("decidedzone_id in", values, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdNotIn(List<String> values) {
            addCriterion("decidedzone_id not in", values, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdBetween(String value1, String value2) {
            addCriterion("decidedzone_id between", value1, value2, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andDecidedzoneIdNotBetween(String value1, String value2) {
            addCriterion("decidedzone_id not between", value1, value2, "decidedzoneId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("region_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("region_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(String value) {
            addCriterion("region_id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(String value) {
            addCriterion("region_id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(String value) {
            addCriterion("region_id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(String value) {
            addCriterion("region_id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(String value) {
            addCriterion("region_id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(String value) {
            addCriterion("region_id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLike(String value) {
            addCriterion("region_id like", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotLike(String value) {
            addCriterion("region_id not like", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<String> values) {
            addCriterion("region_id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<String> values) {
            addCriterion("region_id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(String value1, String value2) {
            addCriterion("region_id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(String value1, String value2) {
            addCriterion("region_id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andAddresskeyIsNull() {
            addCriterion("addresskey is null");
            return (Criteria) this;
        }

        public Criteria andAddresskeyIsNotNull() {
            addCriterion("addresskey is not null");
            return (Criteria) this;
        }

        public Criteria andAddresskeyEqualTo(String value) {
            addCriterion("addresskey =", value, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyNotEqualTo(String value) {
            addCriterion("addresskey <>", value, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyGreaterThan(String value) {
            addCriterion("addresskey >", value, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyGreaterThanOrEqualTo(String value) {
            addCriterion("addresskey >=", value, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyLessThan(String value) {
            addCriterion("addresskey <", value, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyLessThanOrEqualTo(String value) {
            addCriterion("addresskey <=", value, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyLike(String value) {
            addCriterion("addresskey like", value, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyNotLike(String value) {
            addCriterion("addresskey not like", value, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyIn(List<String> values) {
            addCriterion("addresskey in", values, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyNotIn(List<String> values) {
            addCriterion("addresskey not in", values, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyBetween(String value1, String value2) {
            addCriterion("addresskey between", value1, value2, "addresskey");
            return (Criteria) this;
        }

        public Criteria andAddresskeyNotBetween(String value1, String value2) {
            addCriterion("addresskey not between", value1, value2, "addresskey");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andStartnumIsNull() {
            addCriterion("startnum is null");
            return (Criteria) this;
        }

        public Criteria andStartnumIsNotNull() {
            addCriterion("startnum is not null");
            return (Criteria) this;
        }

        public Criteria andStartnumEqualTo(String value) {
            addCriterion("startnum =", value, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumNotEqualTo(String value) {
            addCriterion("startnum <>", value, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumGreaterThan(String value) {
            addCriterion("startnum >", value, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumGreaterThanOrEqualTo(String value) {
            addCriterion("startnum >=", value, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumLessThan(String value) {
            addCriterion("startnum <", value, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumLessThanOrEqualTo(String value) {
            addCriterion("startnum <=", value, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumLike(String value) {
            addCriterion("startnum like", value, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumNotLike(String value) {
            addCriterion("startnum not like", value, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumIn(List<String> values) {
            addCriterion("startnum in", values, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumNotIn(List<String> values) {
            addCriterion("startnum not in", values, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumBetween(String value1, String value2) {
            addCriterion("startnum between", value1, value2, "startnum");
            return (Criteria) this;
        }

        public Criteria andStartnumNotBetween(String value1, String value2) {
            addCriterion("startnum not between", value1, value2, "startnum");
            return (Criteria) this;
        }

        public Criteria andEndnumIsNull() {
            addCriterion("endnum is null");
            return (Criteria) this;
        }

        public Criteria andEndnumIsNotNull() {
            addCriterion("endnum is not null");
            return (Criteria) this;
        }

        public Criteria andEndnumEqualTo(String value) {
            addCriterion("endnum =", value, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumNotEqualTo(String value) {
            addCriterion("endnum <>", value, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumGreaterThan(String value) {
            addCriterion("endnum >", value, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumGreaterThanOrEqualTo(String value) {
            addCriterion("endnum >=", value, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumLessThan(String value) {
            addCriterion("endnum <", value, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumLessThanOrEqualTo(String value) {
            addCriterion("endnum <=", value, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumLike(String value) {
            addCriterion("endnum like", value, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumNotLike(String value) {
            addCriterion("endnum not like", value, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumIn(List<String> values) {
            addCriterion("endnum in", values, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumNotIn(List<String> values) {
            addCriterion("endnum not in", values, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumBetween(String value1, String value2) {
            addCriterion("endnum between", value1, value2, "endnum");
            return (Criteria) this;
        }

        public Criteria andEndnumNotBetween(String value1, String value2) {
            addCriterion("endnum not between", value1, value2, "endnum");
            return (Criteria) this;
        }

        public Criteria andSingleIsNull() {
            addCriterion("single is null");
            return (Criteria) this;
        }

        public Criteria andSingleIsNotNull() {
            addCriterion("single is not null");
            return (Criteria) this;
        }

        public Criteria andSingleEqualTo(String value) {
            addCriterion("single =", value, "single");
            return (Criteria) this;
        }

        public Criteria andSingleNotEqualTo(String value) {
            addCriterion("single <>", value, "single");
            return (Criteria) this;
        }

        public Criteria andSingleGreaterThan(String value) {
            addCriterion("single >", value, "single");
            return (Criteria) this;
        }

        public Criteria andSingleGreaterThanOrEqualTo(String value) {
            addCriterion("single >=", value, "single");
            return (Criteria) this;
        }

        public Criteria andSingleLessThan(String value) {
            addCriterion("single <", value, "single");
            return (Criteria) this;
        }

        public Criteria andSingleLessThanOrEqualTo(String value) {
            addCriterion("single <=", value, "single");
            return (Criteria) this;
        }

        public Criteria andSingleLike(String value) {
            addCriterion("single like", value, "single");
            return (Criteria) this;
        }

        public Criteria andSingleNotLike(String value) {
            addCriterion("single not like", value, "single");
            return (Criteria) this;
        }

        public Criteria andSingleIn(List<String> values) {
            addCriterion("single in", values, "single");
            return (Criteria) this;
        }

        public Criteria andSingleNotIn(List<String> values) {
            addCriterion("single not in", values, "single");
            return (Criteria) this;
        }

        public Criteria andSingleBetween(String value1, String value2) {
            addCriterion("single between", value1, value2, "single");
            return (Criteria) this;
        }

        public Criteria andSingleNotBetween(String value1, String value2) {
            addCriterion("single not between", value1, value2, "single");
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