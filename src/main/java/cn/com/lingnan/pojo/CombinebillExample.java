package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.List;

public class CombinebillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CombinebillExample() {
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

        public Criteria andCombinepeopleIsNull() {
            addCriterion("combinepeople is null");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleIsNotNull() {
            addCriterion("combinepeople is not null");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleEqualTo(String value) {
            addCriterion("combinepeople =", value, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleNotEqualTo(String value) {
            addCriterion("combinepeople <>", value, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleGreaterThan(String value) {
            addCriterion("combinepeople >", value, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleGreaterThanOrEqualTo(String value) {
            addCriterion("combinepeople >=", value, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleLessThan(String value) {
            addCriterion("combinepeople <", value, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleLessThanOrEqualTo(String value) {
            addCriterion("combinepeople <=", value, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleLike(String value) {
            addCriterion("combinepeople like", value, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleNotLike(String value) {
            addCriterion("combinepeople not like", value, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleIn(List<String> values) {
            addCriterion("combinepeople in", values, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleNotIn(List<String> values) {
            addCriterion("combinepeople not in", values, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleBetween(String value1, String value2) {
            addCriterion("combinepeople between", value1, value2, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andCombinepeopleNotBetween(String value1, String value2) {
            addCriterion("combinepeople not between", value1, value2, "combinepeople");
            return (Criteria) this;
        }

        public Criteria andSealIdIsNull() {
            addCriterion("seal_id is null");
            return (Criteria) this;
        }

        public Criteria andSealIdIsNotNull() {
            addCriterion("seal_id is not null");
            return (Criteria) this;
        }

        public Criteria andSealIdEqualTo(String value) {
            addCriterion("seal_id =", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdNotEqualTo(String value) {
            addCriterion("seal_id <>", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdGreaterThan(String value) {
            addCriterion("seal_id >", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdGreaterThanOrEqualTo(String value) {
            addCriterion("seal_id >=", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdLessThan(String value) {
            addCriterion("seal_id <", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdLessThanOrEqualTo(String value) {
            addCriterion("seal_id <=", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdLike(String value) {
            addCriterion("seal_id like", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdNotLike(String value) {
            addCriterion("seal_id not like", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdIn(List<String> values) {
            addCriterion("seal_id in", values, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdNotIn(List<String> values) {
            addCriterion("seal_id not in", values, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdBetween(String value1, String value2) {
            addCriterion("seal_id between", value1, value2, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdNotBetween(String value1, String value2) {
            addCriterion("seal_id not between", value1, value2, "sealId");
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

        public Criteria andCountDestinationIsNull() {
            addCriterion("count_destination is null");
            return (Criteria) this;
        }

        public Criteria andCountDestinationIsNotNull() {
            addCriterion("count_destination is not null");
            return (Criteria) this;
        }

        public Criteria andCountDestinationEqualTo(String value) {
            addCriterion("count_destination =", value, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationNotEqualTo(String value) {
            addCriterion("count_destination <>", value, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationGreaterThan(String value) {
            addCriterion("count_destination >", value, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("count_destination >=", value, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationLessThan(String value) {
            addCriterion("count_destination <", value, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationLessThanOrEqualTo(String value) {
            addCriterion("count_destination <=", value, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationLike(String value) {
            addCriterion("count_destination like", value, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationNotLike(String value) {
            addCriterion("count_destination not like", value, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationIn(List<String> values) {
            addCriterion("count_destination in", values, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationNotIn(List<String> values) {
            addCriterion("count_destination not in", values, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationBetween(String value1, String value2) {
            addCriterion("count_destination between", value1, value2, "countDestination");
            return (Criteria) this;
        }

        public Criteria andCountDestinationNotBetween(String value1, String value2) {
            addCriterion("count_destination not between", value1, value2, "countDestination");
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

        public Criteria andPiaoshuIsNull() {
            addCriterion("piaoshu is null");
            return (Criteria) this;
        }

        public Criteria andPiaoshuIsNotNull() {
            addCriterion("piaoshu is not null");
            return (Criteria) this;
        }

        public Criteria andPiaoshuEqualTo(Integer value) {
            addCriterion("piaoshu =", value, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuNotEqualTo(Integer value) {
            addCriterion("piaoshu <>", value, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuGreaterThan(Integer value) {
            addCriterion("piaoshu >", value, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuGreaterThanOrEqualTo(Integer value) {
            addCriterion("piaoshu >=", value, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuLessThan(Integer value) {
            addCriterion("piaoshu <", value, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuLessThanOrEqualTo(Integer value) {
            addCriterion("piaoshu <=", value, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuIn(List<Integer> values) {
            addCriterion("piaoshu in", values, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuNotIn(List<Integer> values) {
            addCriterion("piaoshu not in", values, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuBetween(Integer value1, Integer value2) {
            addCriterion("piaoshu between", value1, value2, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andPiaoshuNotBetween(Integer value1, Integer value2) {
            addCriterion("piaoshu not between", value1, value2, "piaoshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuIsNull() {
            addCriterion("jiangshu is null");
            return (Criteria) this;
        }

        public Criteria andJiangshuIsNotNull() {
            addCriterion("jiangshu is not null");
            return (Criteria) this;
        }

        public Criteria andJiangshuEqualTo(Integer value) {
            addCriterion("jiangshu =", value, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuNotEqualTo(Integer value) {
            addCriterion("jiangshu <>", value, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuGreaterThan(Integer value) {
            addCriterion("jiangshu >", value, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuGreaterThanOrEqualTo(Integer value) {
            addCriterion("jiangshu >=", value, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuLessThan(Integer value) {
            addCriterion("jiangshu <", value, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuLessThanOrEqualTo(Integer value) {
            addCriterion("jiangshu <=", value, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuIn(List<Integer> values) {
            addCriterion("jiangshu in", values, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuNotIn(List<Integer> values) {
            addCriterion("jiangshu not in", values, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuBetween(Integer value1, Integer value2) {
            addCriterion("jiangshu between", value1, value2, "jiangshu");
            return (Criteria) this;
        }

        public Criteria andJiangshuNotBetween(Integer value1, Integer value2) {
            addCriterion("jiangshu not between", value1, value2, "jiangshu");
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

        public Criteria andPeizaiIsNull() {
            addCriterion("peizai is null");
            return (Criteria) this;
        }

        public Criteria andPeizaiIsNotNull() {
            addCriterion("peizai is not null");
            return (Criteria) this;
        }

        public Criteria andPeizaiEqualTo(String value) {
            addCriterion("peizai =", value, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiNotEqualTo(String value) {
            addCriterion("peizai <>", value, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiGreaterThan(String value) {
            addCriterion("peizai >", value, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiGreaterThanOrEqualTo(String value) {
            addCriterion("peizai >=", value, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiLessThan(String value) {
            addCriterion("peizai <", value, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiLessThanOrEqualTo(String value) {
            addCriterion("peizai <=", value, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiLike(String value) {
            addCriterion("peizai like", value, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiNotLike(String value) {
            addCriterion("peizai not like", value, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiIn(List<String> values) {
            addCriterion("peizai in", values, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiNotIn(List<String> values) {
            addCriterion("peizai not in", values, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiBetween(String value1, String value2) {
            addCriterion("peizai between", value1, value2, "peizai");
            return (Criteria) this;
        }

        public Criteria andPeizaiNotBetween(String value1, String value2) {
            addCriterion("peizai not between", value1, value2, "peizai");
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