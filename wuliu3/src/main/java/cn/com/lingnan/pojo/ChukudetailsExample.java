package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChukudetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChukudetailsExample() {
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

        public Criteria andCombinebillIdIsNull() {
            addCriterion("combinebill_id is null");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdIsNotNull() {
            addCriterion("combinebill_id is not null");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdEqualTo(String value) {
            addCriterion("combinebill_id =", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdNotEqualTo(String value) {
            addCriterion("combinebill_id <>", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdGreaterThan(String value) {
            addCriterion("combinebill_id >", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdGreaterThanOrEqualTo(String value) {
            addCriterion("combinebill_id >=", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdLessThan(String value) {
            addCriterion("combinebill_id <", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdLessThanOrEqualTo(String value) {
            addCriterion("combinebill_id <=", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdLike(String value) {
            addCriterion("combinebill_id like", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdNotLike(String value) {
            addCriterion("combinebill_id not like", value, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdIn(List<String> values) {
            addCriterion("combinebill_id in", values, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdNotIn(List<String> values) {
            addCriterion("combinebill_id not in", values, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdBetween(String value1, String value2) {
            addCriterion("combinebill_id between", value1, value2, "combinebillId");
            return (Criteria) this;
        }

        public Criteria andCombinebillIdNotBetween(String value1, String value2) {
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

        public Criteria andVolIsNull() {
            addCriterion("vol is null");
            return (Criteria) this;
        }

        public Criteria andVolIsNotNull() {
            addCriterion("vol is not null");
            return (Criteria) this;
        }

        public Criteria andVolEqualTo(Double value) {
            addCriterion("vol =", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotEqualTo(Double value) {
            addCriterion("vol <>", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThan(Double value) {
            addCriterion("vol >", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThanOrEqualTo(Double value) {
            addCriterion("vol >=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThan(Double value) {
            addCriterion("vol <", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThanOrEqualTo(Double value) {
            addCriterion("vol <=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolIn(List<Double> values) {
            addCriterion("vol in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotIn(List<Double> values) {
            addCriterion("vol not in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolBetween(Double value1, Double value2) {
            addCriterion("vol between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotBetween(Double value1, Double value2) {
            addCriterion("vol not between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andScantimeIsNull() {
            addCriterion("scantime is null");
            return (Criteria) this;
        }

        public Criteria andScantimeIsNotNull() {
            addCriterion("scantime is not null");
            return (Criteria) this;
        }

        public Criteria andScantimeEqualTo(Date value) {
            addCriterion("scantime =", value, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeNotEqualTo(Date value) {
            addCriterion("scantime <>", value, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeGreaterThan(Date value) {
            addCriterion("scantime >", value, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scantime >=", value, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeLessThan(Date value) {
            addCriterion("scantime <", value, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeLessThanOrEqualTo(Date value) {
            addCriterion("scantime <=", value, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeIn(List<Date> values) {
            addCriterion("scantime in", values, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeNotIn(List<Date> values) {
            addCriterion("scantime not in", values, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeBetween(Date value1, Date value2) {
            addCriterion("scantime between", value1, value2, "scantime");
            return (Criteria) this;
        }

        public Criteria andScantimeNotBetween(Date value1, Date value2) {
            addCriterion("scantime not between", value1, value2, "scantime");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("productname is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("productname is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("productname =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("productname <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("productname >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("productname >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("productname <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("productname <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("productname like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("productname not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("productname in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("productname not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("productname between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("productname not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleIsNull() {
            addCriterion("shouhuopeople is null");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleIsNotNull() {
            addCriterion("shouhuopeople is not null");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleEqualTo(String value) {
            addCriterion("shouhuopeople =", value, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleNotEqualTo(String value) {
            addCriterion("shouhuopeople <>", value, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleGreaterThan(String value) {
            addCriterion("shouhuopeople >", value, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleGreaterThanOrEqualTo(String value) {
            addCriterion("shouhuopeople >=", value, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleLessThan(String value) {
            addCriterion("shouhuopeople <", value, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleLessThanOrEqualTo(String value) {
            addCriterion("shouhuopeople <=", value, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleLike(String value) {
            addCriterion("shouhuopeople like", value, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleNotLike(String value) {
            addCriterion("shouhuopeople not like", value, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleIn(List<String> values) {
            addCriterion("shouhuopeople in", values, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleNotIn(List<String> values) {
            addCriterion("shouhuopeople not in", values, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleBetween(String value1, String value2) {
            addCriterion("shouhuopeople between", value1, value2, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuopeopleNotBetween(String value1, String value2) {
            addCriterion("shouhuopeople not between", value1, value2, "shouhuopeople");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressIsNull() {
            addCriterion("shouhuoaddress is null");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressIsNotNull() {
            addCriterion("shouhuoaddress is not null");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressEqualTo(String value) {
            addCriterion("shouhuoaddress =", value, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressNotEqualTo(String value) {
            addCriterion("shouhuoaddress <>", value, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressGreaterThan(String value) {
            addCriterion("shouhuoaddress >", value, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressGreaterThanOrEqualTo(String value) {
            addCriterion("shouhuoaddress >=", value, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressLessThan(String value) {
            addCriterion("shouhuoaddress <", value, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressLessThanOrEqualTo(String value) {
            addCriterion("shouhuoaddress <=", value, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressLike(String value) {
            addCriterion("shouhuoaddress like", value, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressNotLike(String value) {
            addCriterion("shouhuoaddress not like", value, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressIn(List<String> values) {
            addCriterion("shouhuoaddress in", values, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressNotIn(List<String> values) {
            addCriterion("shouhuoaddress not in", values, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressBetween(String value1, String value2) {
            addCriterion("shouhuoaddress between", value1, value2, "shouhuoaddress");
            return (Criteria) this;
        }

        public Criteria andShouhuoaddressNotBetween(String value1, String value2) {
            addCriterion("shouhuoaddress not between", value1, value2, "shouhuoaddress");
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

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
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