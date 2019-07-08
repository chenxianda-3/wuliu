package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QianshoubillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QianshoubillExample() {
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

        public Criteria andDeliveryunitIsNull() {
            addCriterion("deliveryunit is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIsNotNull() {
            addCriterion("deliveryunit is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitEqualTo(String value) {
            addCriterion("deliveryunit =", value, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitNotEqualTo(String value) {
            addCriterion("deliveryunit <>", value, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitGreaterThan(String value) {
            addCriterion("deliveryunit >", value, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryunit >=", value, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitLessThan(String value) {
            addCriterion("deliveryunit <", value, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitLessThanOrEqualTo(String value) {
            addCriterion("deliveryunit <=", value, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitLike(String value) {
            addCriterion("deliveryunit like", value, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitNotLike(String value) {
            addCriterion("deliveryunit not like", value, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIn(List<String> values) {
            addCriterion("deliveryunit in", values, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitNotIn(List<String> values) {
            addCriterion("deliveryunit not in", values, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitBetween(String value1, String value2) {
            addCriterion("deliveryunit between", value1, value2, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitNotBetween(String value1, String value2) {
            addCriterion("deliveryunit not between", value1, value2, "deliveryunit");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleIsNull() {
            addCriterion("qianshoupeople is null");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleIsNotNull() {
            addCriterion("qianshoupeople is not null");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleEqualTo(String value) {
            addCriterion("qianshoupeople =", value, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleNotEqualTo(String value) {
            addCriterion("qianshoupeople <>", value, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleGreaterThan(String value) {
            addCriterion("qianshoupeople >", value, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleGreaterThanOrEqualTo(String value) {
            addCriterion("qianshoupeople >=", value, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleLessThan(String value) {
            addCriterion("qianshoupeople <", value, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleLessThanOrEqualTo(String value) {
            addCriterion("qianshoupeople <=", value, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleLike(String value) {
            addCriterion("qianshoupeople like", value, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleNotLike(String value) {
            addCriterion("qianshoupeople not like", value, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleIn(List<String> values) {
            addCriterion("qianshoupeople in", values, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleNotIn(List<String> values) {
            addCriterion("qianshoupeople not in", values, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleBetween(String value1, String value2) {
            addCriterion("qianshoupeople between", value1, value2, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andQianshoupeopleNotBetween(String value1, String value2) {
            addCriterion("qianshoupeople not between", value1, value2, "qianshoupeople");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(String value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(String value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(String value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(String value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(String value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLike(String value) {
            addCriterion("staff_id like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotLike(String value) {
            addCriterion("staff_id not like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<String> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<String> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(String value1, String value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(String value1, String value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffnameIsNull() {
            addCriterion("staffname is null");
            return (Criteria) this;
        }

        public Criteria andStaffnameIsNotNull() {
            addCriterion("staffname is not null");
            return (Criteria) this;
        }

        public Criteria andStaffnameEqualTo(String value) {
            addCriterion("staffname =", value, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameNotEqualTo(String value) {
            addCriterion("staffname <>", value, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameGreaterThan(String value) {
            addCriterion("staffname >", value, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameGreaterThanOrEqualTo(String value) {
            addCriterion("staffname >=", value, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameLessThan(String value) {
            addCriterion("staffname <", value, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameLessThanOrEqualTo(String value) {
            addCriterion("staffname <=", value, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameLike(String value) {
            addCriterion("staffname like", value, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameNotLike(String value) {
            addCriterion("staffname not like", value, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameIn(List<String> values) {
            addCriterion("staffname in", values, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameNotIn(List<String> values) {
            addCriterion("staffname not in", values, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameBetween(String value1, String value2) {
            addCriterion("staffname between", value1, value2, "staffname");
            return (Criteria) this;
        }

        public Criteria andStaffnameNotBetween(String value1, String value2) {
            addCriterion("staffname not between", value1, value2, "staffname");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeIsNull() {
            addCriterion("qianshoutime is null");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeIsNotNull() {
            addCriterion("qianshoutime is not null");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeEqualTo(Date value) {
            addCriterion("qianshoutime =", value, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeNotEqualTo(Date value) {
            addCriterion("qianshoutime <>", value, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeGreaterThan(Date value) {
            addCriterion("qianshoutime >", value, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeGreaterThanOrEqualTo(Date value) {
            addCriterion("qianshoutime >=", value, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeLessThan(Date value) {
            addCriterion("qianshoutime <", value, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeLessThanOrEqualTo(Date value) {
            addCriterion("qianshoutime <=", value, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeIn(List<Date> values) {
            addCriterion("qianshoutime in", values, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeNotIn(List<Date> values) {
            addCriterion("qianshoutime not in", values, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeBetween(Date value1, Date value2) {
            addCriterion("qianshoutime between", value1, value2, "qianshoutime");
            return (Criteria) this;
        }

        public Criteria andQianshoutimeNotBetween(Date value1, Date value2) {
            addCriterion("qianshoutime not between", value1, value2, "qianshoutime");
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