package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.List;

public class PeizaiinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeizaiinfoExample() {
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

        public Criteria andCombineIdIsNull() {
            addCriterion("combine_id is null");
            return (Criteria) this;
        }

        public Criteria andCombineIdIsNotNull() {
            addCriterion("combine_id is not null");
            return (Criteria) this;
        }

        public Criteria andCombineIdEqualTo(String value) {
            addCriterion("combine_id =", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdNotEqualTo(String value) {
            addCriterion("combine_id <>", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdGreaterThan(String value) {
            addCriterion("combine_id >", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdGreaterThanOrEqualTo(String value) {
            addCriterion("combine_id >=", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdLessThan(String value) {
            addCriterion("combine_id <", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdLessThanOrEqualTo(String value) {
            addCriterion("combine_id <=", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdLike(String value) {
            addCriterion("combine_id like", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdNotLike(String value) {
            addCriterion("combine_id not like", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdIn(List<String> values) {
            addCriterion("combine_id in", values, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdNotIn(List<String> values) {
            addCriterion("combine_id not in", values, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdBetween(String value1, String value2) {
            addCriterion("combine_id between", value1, value2, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdNotBetween(String value1, String value2) {
            addCriterion("combine_id not between", value1, value2, "combineId");
            return (Criteria) this;
        }

        public Criteria andOperateunitIsNull() {
            addCriterion("operateunit is null");
            return (Criteria) this;
        }

        public Criteria andOperateunitIsNotNull() {
            addCriterion("operateunit is not null");
            return (Criteria) this;
        }

        public Criteria andOperateunitEqualTo(String value) {
            addCriterion("operateunit =", value, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitNotEqualTo(String value) {
            addCriterion("operateunit <>", value, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitGreaterThan(String value) {
            addCriterion("operateunit >", value, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitGreaterThanOrEqualTo(String value) {
            addCriterion("operateunit >=", value, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitLessThan(String value) {
            addCriterion("operateunit <", value, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitLessThanOrEqualTo(String value) {
            addCriterion("operateunit <=", value, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitLike(String value) {
            addCriterion("operateunit like", value, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitNotLike(String value) {
            addCriterion("operateunit not like", value, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitIn(List<String> values) {
            addCriterion("operateunit in", values, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitNotIn(List<String> values) {
            addCriterion("operateunit not in", values, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitBetween(String value1, String value2) {
            addCriterion("operateunit between", value1, value2, "operateunit");
            return (Criteria) this;
        }

        public Criteria andOperateunitNotBetween(String value1, String value2) {
            addCriterion("operateunit not between", value1, value2, "operateunit");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayIsNull() {
            addCriterion("peizaiway is null");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayIsNotNull() {
            addCriterion("peizaiway is not null");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayEqualTo(String value) {
            addCriterion("peizaiway =", value, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayNotEqualTo(String value) {
            addCriterion("peizaiway <>", value, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayGreaterThan(String value) {
            addCriterion("peizaiway >", value, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayGreaterThanOrEqualTo(String value) {
            addCriterion("peizaiway >=", value, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayLessThan(String value) {
            addCriterion("peizaiway <", value, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayLessThanOrEqualTo(String value) {
            addCriterion("peizaiway <=", value, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayLike(String value) {
            addCriterion("peizaiway like", value, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayNotLike(String value) {
            addCriterion("peizaiway not like", value, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayIn(List<String> values) {
            addCriterion("peizaiway in", values, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayNotIn(List<String> values) {
            addCriterion("peizaiway not in", values, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayBetween(String value1, String value2) {
            addCriterion("peizaiway between", value1, value2, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andPeizaiwayNotBetween(String value1, String value2) {
            addCriterion("peizaiway not between", value1, value2, "peizaiway");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNull() {
            addCriterion("line_id is null");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNotNull() {
            addCriterion("line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLineIdEqualTo(String value) {
            addCriterion("line_id =", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotEqualTo(String value) {
            addCriterion("line_id <>", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThan(String value) {
            addCriterion("line_id >", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThanOrEqualTo(String value) {
            addCriterion("line_id >=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThan(String value) {
            addCriterion("line_id <", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThanOrEqualTo(String value) {
            addCriterion("line_id <=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLike(String value) {
            addCriterion("line_id like", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotLike(String value) {
            addCriterion("line_id not like", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdIn(List<String> values) {
            addCriterion("line_id in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotIn(List<String> values) {
            addCriterion("line_id not in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdBetween(String value1, String value2) {
            addCriterion("line_id between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotBetween(String value1, String value2) {
            addCriterion("line_id not between", value1, value2, "lineId");
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

        public Criteria andEndcityIsNull() {
            addCriterion("endcity is null");
            return (Criteria) this;
        }

        public Criteria andEndcityIsNotNull() {
            addCriterion("endcity is not null");
            return (Criteria) this;
        }

        public Criteria andEndcityEqualTo(String value) {
            addCriterion("endcity =", value, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityNotEqualTo(String value) {
            addCriterion("endcity <>", value, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityGreaterThan(String value) {
            addCriterion("endcity >", value, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityGreaterThanOrEqualTo(String value) {
            addCriterion("endcity >=", value, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityLessThan(String value) {
            addCriterion("endcity <", value, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityLessThanOrEqualTo(String value) {
            addCriterion("endcity <=", value, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityLike(String value) {
            addCriterion("endcity like", value, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityNotLike(String value) {
            addCriterion("endcity not like", value, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityIn(List<String> values) {
            addCriterion("endcity in", values, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityNotIn(List<String> values) {
            addCriterion("endcity not in", values, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityBetween(String value1, String value2) {
            addCriterion("endcity between", value1, value2, "endcity");
            return (Criteria) this;
        }

        public Criteria andEndcityNotBetween(String value1, String value2) {
            addCriterion("endcity not between", value1, value2, "endcity");
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