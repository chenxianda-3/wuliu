package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FendanbillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FendanbillExample() {
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

        public Criteria andTransfercenterIsNull() {
            addCriterion("transfercenter is null");
            return (Criteria) this;
        }

        public Criteria andTransfercenterIsNotNull() {
            addCriterion("transfercenter is not null");
            return (Criteria) this;
        }

        public Criteria andTransfercenterEqualTo(String value) {
            addCriterion("transfercenter =", value, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterNotEqualTo(String value) {
            addCriterion("transfercenter <>", value, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterGreaterThan(String value) {
            addCriterion("transfercenter >", value, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterGreaterThanOrEqualTo(String value) {
            addCriterion("transfercenter >=", value, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterLessThan(String value) {
            addCriterion("transfercenter <", value, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterLessThanOrEqualTo(String value) {
            addCriterion("transfercenter <=", value, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterLike(String value) {
            addCriterion("transfercenter like", value, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterNotLike(String value) {
            addCriterion("transfercenter not like", value, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterIn(List<String> values) {
            addCriterion("transfercenter in", values, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterNotIn(List<String> values) {
            addCriterion("transfercenter not in", values, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterBetween(String value1, String value2) {
            addCriterion("transfercenter between", value1, value2, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andTransfercenterNotBetween(String value1, String value2) {
            addCriterion("transfercenter not between", value1, value2, "transfercenter");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdIsNull() {
            addCriterion("deliveryunit_id is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdIsNotNull() {
            addCriterion("deliveryunit_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdEqualTo(String value) {
            addCriterion("deliveryunit_id =", value, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdNotEqualTo(String value) {
            addCriterion("deliveryunit_id <>", value, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdGreaterThan(String value) {
            addCriterion("deliveryunit_id >", value, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryunit_id >=", value, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdLessThan(String value) {
            addCriterion("deliveryunit_id <", value, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdLessThanOrEqualTo(String value) {
            addCriterion("deliveryunit_id <=", value, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdLike(String value) {
            addCriterion("deliveryunit_id like", value, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdNotLike(String value) {
            addCriterion("deliveryunit_id not like", value, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdIn(List<String> values) {
            addCriterion("deliveryunit_id in", values, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdNotIn(List<String> values) {
            addCriterion("deliveryunit_id not in", values, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdBetween(String value1, String value2) {
            addCriterion("deliveryunit_id between", value1, value2, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andDeliveryunitIdNotBetween(String value1, String value2) {
            addCriterion("deliveryunit_id not between", value1, value2, "deliveryunitId");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNull() {
            addCriterion("timelimit is null");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNotNull() {
            addCriterion("timelimit is not null");
            return (Criteria) this;
        }

        public Criteria andTimelimitEqualTo(Integer value) {
            addCriterion("timelimit =", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotEqualTo(Integer value) {
            addCriterion("timelimit <>", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThan(Integer value) {
            addCriterion("timelimit >", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("timelimit >=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThan(Integer value) {
            addCriterion("timelimit <", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThanOrEqualTo(Integer value) {
            addCriterion("timelimit <=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitIn(List<Integer> values) {
            addCriterion("timelimit in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotIn(List<Integer> values) {
            addCriterion("timelimit not in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitBetween(Integer value1, Integer value2) {
            addCriterion("timelimit between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotBetween(Integer value1, Integer value2) {
            addCriterion("timelimit not between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andInpiciIsNull() {
            addCriterion("inpici is null");
            return (Criteria) this;
        }

        public Criteria andInpiciIsNotNull() {
            addCriterion("inpici is not null");
            return (Criteria) this;
        }

        public Criteria andInpiciEqualTo(String value) {
            addCriterion("inpici =", value, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciNotEqualTo(String value) {
            addCriterion("inpici <>", value, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciGreaterThan(String value) {
            addCriterion("inpici >", value, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciGreaterThanOrEqualTo(String value) {
            addCriterion("inpici >=", value, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciLessThan(String value) {
            addCriterion("inpici <", value, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciLessThanOrEqualTo(String value) {
            addCriterion("inpici <=", value, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciLike(String value) {
            addCriterion("inpici like", value, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciNotLike(String value) {
            addCriterion("inpici not like", value, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciIn(List<String> values) {
            addCriterion("inpici in", values, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciNotIn(List<String> values) {
            addCriterion("inpici not in", values, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciBetween(String value1, String value2) {
            addCriterion("inpici between", value1, value2, "inpici");
            return (Criteria) this;
        }

        public Criteria andInpiciNotBetween(String value1, String value2) {
            addCriterion("inpici not between", value1, value2, "inpici");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andFendantimeIsNull() {
            addCriterion("fendantime is null");
            return (Criteria) this;
        }

        public Criteria andFendantimeIsNotNull() {
            addCriterion("fendantime is not null");
            return (Criteria) this;
        }

        public Criteria andFendantimeEqualTo(Date value) {
            addCriterion("fendantime =", value, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeNotEqualTo(Date value) {
            addCriterion("fendantime <>", value, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeGreaterThan(Date value) {
            addCriterion("fendantime >", value, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fendantime >=", value, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeLessThan(Date value) {
            addCriterion("fendantime <", value, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeLessThanOrEqualTo(Date value) {
            addCriterion("fendantime <=", value, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeIn(List<Date> values) {
            addCriterion("fendantime in", values, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeNotIn(List<Date> values) {
            addCriterion("fendantime not in", values, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeBetween(Date value1, Date value2) {
            addCriterion("fendantime between", value1, value2, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendantimeNotBetween(Date value1, Date value2) {
            addCriterion("fendantime not between", value1, value2, "fendantime");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleIsNull() {
            addCriterion("fendanpeople is null");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleIsNotNull() {
            addCriterion("fendanpeople is not null");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleEqualTo(String value) {
            addCriterion("fendanpeople =", value, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleNotEqualTo(String value) {
            addCriterion("fendanpeople <>", value, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleGreaterThan(String value) {
            addCriterion("fendanpeople >", value, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleGreaterThanOrEqualTo(String value) {
            addCriterion("fendanpeople >=", value, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleLessThan(String value) {
            addCriterion("fendanpeople <", value, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleLessThanOrEqualTo(String value) {
            addCriterion("fendanpeople <=", value, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleLike(String value) {
            addCriterion("fendanpeople like", value, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleNotLike(String value) {
            addCriterion("fendanpeople not like", value, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleIn(List<String> values) {
            addCriterion("fendanpeople in", values, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleNotIn(List<String> values) {
            addCriterion("fendanpeople not in", values, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleBetween(String value1, String value2) {
            addCriterion("fendanpeople between", value1, value2, "fendanpeople");
            return (Criteria) this;
        }

        public Criteria andFendanpeopleNotBetween(String value1, String value2) {
            addCriterion("fendanpeople not between", value1, value2, "fendanpeople");
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