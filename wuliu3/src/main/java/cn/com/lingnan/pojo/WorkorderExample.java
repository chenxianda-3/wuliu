package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSendernameIsNull() {
            addCriterion("sendername is null");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNotNull() {
            addCriterion("sendername is not null");
            return (Criteria) this;
        }

        public Criteria andSendernameEqualTo(String value) {
            addCriterion("sendername =", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotEqualTo(String value) {
            addCriterion("sendername <>", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThan(String value) {
            addCriterion("sendername >", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThanOrEqualTo(String value) {
            addCriterion("sendername >=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThan(String value) {
            addCriterion("sendername <", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThanOrEqualTo(String value) {
            addCriterion("sendername <=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLike(String value) {
            addCriterion("sendername like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotLike(String value) {
            addCriterion("sendername not like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameIn(List<String> values) {
            addCriterion("sendername in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotIn(List<String> values) {
            addCriterion("sendername not in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameBetween(String value1, String value2) {
            addCriterion("sendername between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotBetween(String value1, String value2) {
            addCriterion("sendername not between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIsNull() {
            addCriterion("senderphone is null");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIsNotNull() {
            addCriterion("senderphone is not null");
            return (Criteria) this;
        }

        public Criteria andSenderphoneEqualTo(String value) {
            addCriterion("senderphone =", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotEqualTo(String value) {
            addCriterion("senderphone <>", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneGreaterThan(String value) {
            addCriterion("senderphone >", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneGreaterThanOrEqualTo(String value) {
            addCriterion("senderphone >=", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLessThan(String value) {
            addCriterion("senderphone <", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLessThanOrEqualTo(String value) {
            addCriterion("senderphone <=", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLike(String value) {
            addCriterion("senderphone like", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotLike(String value) {
            addCriterion("senderphone not like", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIn(List<String> values) {
            addCriterion("senderphone in", values, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotIn(List<String> values) {
            addCriterion("senderphone not in", values, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneBetween(String value1, String value2) {
            addCriterion("senderphone between", value1, value2, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotBetween(String value1, String value2) {
            addCriterion("senderphone not between", value1, value2, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderaddrIsNull() {
            addCriterion("senderaddr is null");
            return (Criteria) this;
        }

        public Criteria andSenderaddrIsNotNull() {
            addCriterion("senderaddr is not null");
            return (Criteria) this;
        }

        public Criteria andSenderaddrEqualTo(String value) {
            addCriterion("senderaddr =", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrNotEqualTo(String value) {
            addCriterion("senderaddr <>", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrGreaterThan(String value) {
            addCriterion("senderaddr >", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrGreaterThanOrEqualTo(String value) {
            addCriterion("senderaddr >=", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrLessThan(String value) {
            addCriterion("senderaddr <", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrLessThanOrEqualTo(String value) {
            addCriterion("senderaddr <=", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrLike(String value) {
            addCriterion("senderaddr like", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrNotLike(String value) {
            addCriterion("senderaddr not like", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrIn(List<String> values) {
            addCriterion("senderaddr in", values, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrNotIn(List<String> values) {
            addCriterion("senderaddr not in", values, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrBetween(String value1, String value2) {
            addCriterion("senderaddr between", value1, value2, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrNotBetween(String value1, String value2) {
            addCriterion("senderaddr not between", value1, value2, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNull() {
            addCriterion("receivername is null");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNotNull() {
            addCriterion("receivername is not null");
            return (Criteria) this;
        }

        public Criteria andReceivernameEqualTo(String value) {
            addCriterion("receivername =", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotEqualTo(String value) {
            addCriterion("receivername <>", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThan(String value) {
            addCriterion("receivername >", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThanOrEqualTo(String value) {
            addCriterion("receivername >=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThan(String value) {
            addCriterion("receivername <", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThanOrEqualTo(String value) {
            addCriterion("receivername <=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLike(String value) {
            addCriterion("receivername like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotLike(String value) {
            addCriterion("receivername not like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameIn(List<String> values) {
            addCriterion("receivername in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotIn(List<String> values) {
            addCriterion("receivername not in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameBetween(String value1, String value2) {
            addCriterion("receivername between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotBetween(String value1, String value2) {
            addCriterion("receivername not between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNull() {
            addCriterion("receiverphone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNotNull() {
            addCriterion("receiverphone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneEqualTo(String value) {
            addCriterion("receiverphone =", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotEqualTo(String value) {
            addCriterion("receiverphone <>", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThan(String value) {
            addCriterion("receiverphone >", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiverphone >=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThan(String value) {
            addCriterion("receiverphone <", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThanOrEqualTo(String value) {
            addCriterion("receiverphone <=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLike(String value) {
            addCriterion("receiverphone like", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotLike(String value) {
            addCriterion("receiverphone not like", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIn(List<String> values) {
            addCriterion("receiverphone in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotIn(List<String> values) {
            addCriterion("receiverphone not in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneBetween(String value1, String value2) {
            addCriterion("receiverphone between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotBetween(String value1, String value2) {
            addCriterion("receiverphone not between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrIsNull() {
            addCriterion("receiveraddr is null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrIsNotNull() {
            addCriterion("receiveraddr is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrEqualTo(String value) {
            addCriterion("receiveraddr =", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrNotEqualTo(String value) {
            addCriterion("receiveraddr <>", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrGreaterThan(String value) {
            addCriterion("receiveraddr >", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrGreaterThanOrEqualTo(String value) {
            addCriterion("receiveraddr >=", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrLessThan(String value) {
            addCriterion("receiveraddr <", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrLessThanOrEqualTo(String value) {
            addCriterion("receiveraddr <=", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrLike(String value) {
            addCriterion("receiveraddr like", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrNotLike(String value) {
            addCriterion("receiveraddr not like", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrIn(List<String> values) {
            addCriterion("receiveraddr in", values, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrNotIn(List<String> values) {
            addCriterion("receiveraddr not in", values, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrBetween(String value1, String value2) {
            addCriterion("receiveraddr between", value1, value2, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrNotBetween(String value1, String value2) {
            addCriterion("receiveraddr not between", value1, value2, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
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

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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

        public Criteria andFloadreqrIsNull() {
            addCriterion("floadreqr is null");
            return (Criteria) this;
        }

        public Criteria andFloadreqrIsNotNull() {
            addCriterion("floadreqr is not null");
            return (Criteria) this;
        }

        public Criteria andFloadreqrEqualTo(String value) {
            addCriterion("floadreqr =", value, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrNotEqualTo(String value) {
            addCriterion("floadreqr <>", value, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrGreaterThan(String value) {
            addCriterion("floadreqr >", value, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrGreaterThanOrEqualTo(String value) {
            addCriterion("floadreqr >=", value, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrLessThan(String value) {
            addCriterion("floadreqr <", value, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrLessThanOrEqualTo(String value) {
            addCriterion("floadreqr <=", value, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrLike(String value) {
            addCriterion("floadreqr like", value, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrNotLike(String value) {
            addCriterion("floadreqr not like", value, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrIn(List<String> values) {
            addCriterion("floadreqr in", values, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrNotIn(List<String> values) {
            addCriterion("floadreqr not in", values, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrBetween(String value1, String value2) {
            addCriterion("floadreqr between", value1, value2, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andFloadreqrNotBetween(String value1, String value2) {
            addCriterion("floadreqr not between", value1, value2, "floadreqr");
            return (Criteria) this;
        }

        public Criteria andActlweitIsNull() {
            addCriterion("actlweit is null");
            return (Criteria) this;
        }

        public Criteria andActlweitIsNotNull() {
            addCriterion("actlweit is not null");
            return (Criteria) this;
        }

        public Criteria andActlweitEqualTo(Double value) {
            addCriterion("actlweit =", value, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitNotEqualTo(Double value) {
            addCriterion("actlweit <>", value, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitGreaterThan(Double value) {
            addCriterion("actlweit >", value, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitGreaterThanOrEqualTo(Double value) {
            addCriterion("actlweit >=", value, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitLessThan(Double value) {
            addCriterion("actlweit <", value, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitLessThanOrEqualTo(Double value) {
            addCriterion("actlweit <=", value, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitIn(List<Double> values) {
            addCriterion("actlweit in", values, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitNotIn(List<Double> values) {
            addCriterion("actlweit not in", values, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitBetween(Double value1, Double value2) {
            addCriterion("actlweit between", value1, value2, "actlweit");
            return (Criteria) this;
        }

        public Criteria andActlweitNotBetween(Double value1, Double value2) {
            addCriterion("actlweit not between", value1, value2, "actlweit");
            return (Criteria) this;
        }

        public Criteria andVolIsNull() {
            addCriterion("vol is null");
            return (Criteria) this;
        }

        public Criteria andVolIsNotNull() {
            addCriterion("vol is not null");
            return (Criteria) this;
        }

        public Criteria andVolEqualTo(String value) {
            addCriterion("vol =", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotEqualTo(String value) {
            addCriterion("vol <>", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThan(String value) {
            addCriterion("vol >", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThanOrEqualTo(String value) {
            addCriterion("vol >=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThan(String value) {
            addCriterion("vol <", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThanOrEqualTo(String value) {
            addCriterion("vol <=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLike(String value) {
            addCriterion("vol like", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotLike(String value) {
            addCriterion("vol not like", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolIn(List<String> values) {
            addCriterion("vol in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotIn(List<String> values) {
            addCriterion("vol not in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolBetween(String value1, String value2) {
            addCriterion("vol between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotBetween(String value1, String value2) {
            addCriterion("vol not between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andManagercheckIsNull() {
            addCriterion("managerCheck is null");
            return (Criteria) this;
        }

        public Criteria andManagercheckIsNotNull() {
            addCriterion("managerCheck is not null");
            return (Criteria) this;
        }

        public Criteria andManagercheckEqualTo(String value) {
            addCriterion("managerCheck =", value, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckNotEqualTo(String value) {
            addCriterion("managerCheck <>", value, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckGreaterThan(String value) {
            addCriterion("managerCheck >", value, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckGreaterThanOrEqualTo(String value) {
            addCriterion("managerCheck >=", value, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckLessThan(String value) {
            addCriterion("managerCheck <", value, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckLessThanOrEqualTo(String value) {
            addCriterion("managerCheck <=", value, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckLike(String value) {
            addCriterion("managerCheck like", value, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckNotLike(String value) {
            addCriterion("managerCheck not like", value, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckIn(List<String> values) {
            addCriterion("managerCheck in", values, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckNotIn(List<String> values) {
            addCriterion("managerCheck not in", values, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckBetween(String value1, String value2) {
            addCriterion("managerCheck between", value1, value2, "managercheck");
            return (Criteria) this;
        }

        public Criteria andManagercheckNotBetween(String value1, String value2) {
            addCriterion("managerCheck not between", value1, value2, "managercheck");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andStationIsNull() {
            addCriterion("station is null");
            return (Criteria) this;
        }

        public Criteria andStationIsNotNull() {
            addCriterion("station is not null");
            return (Criteria) this;
        }

        public Criteria andStationEqualTo(String value) {
            addCriterion("station =", value, "station");
            return (Criteria) this;
        }

        public Criteria andStationNotEqualTo(String value) {
            addCriterion("station <>", value, "station");
            return (Criteria) this;
        }

        public Criteria andStationGreaterThan(String value) {
            addCriterion("station >", value, "station");
            return (Criteria) this;
        }

        public Criteria andStationGreaterThanOrEqualTo(String value) {
            addCriterion("station >=", value, "station");
            return (Criteria) this;
        }

        public Criteria andStationLessThan(String value) {
            addCriterion("station <", value, "station");
            return (Criteria) this;
        }

        public Criteria andStationLessThanOrEqualTo(String value) {
            addCriterion("station <=", value, "station");
            return (Criteria) this;
        }

        public Criteria andStationLike(String value) {
            addCriterion("station like", value, "station");
            return (Criteria) this;
        }

        public Criteria andStationNotLike(String value) {
            addCriterion("station not like", value, "station");
            return (Criteria) this;
        }

        public Criteria andStationIn(List<String> values) {
            addCriterion("station in", values, "station");
            return (Criteria) this;
        }

        public Criteria andStationNotIn(List<String> values) {
            addCriterion("station not in", values, "station");
            return (Criteria) this;
        }

        public Criteria andStationBetween(String value1, String value2) {
            addCriterion("station between", value1, value2, "station");
            return (Criteria) this;
        }

        public Criteria andStationNotBetween(String value1, String value2) {
            addCriterion("station not between", value1, value2, "station");
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