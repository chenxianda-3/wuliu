package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RoutelinebillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoutelinebillExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andRoutebillIdIsNull() {
            addCriterion("routebill_id is null");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdIsNotNull() {
            addCriterion("routebill_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdEqualTo(String value) {
            addCriterion("routebill_id =", value, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdNotEqualTo(String value) {
            addCriterion("routebill_id <>", value, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdGreaterThan(String value) {
            addCriterion("routebill_id >", value, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdGreaterThanOrEqualTo(String value) {
            addCriterion("routebill_id >=", value, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdLessThan(String value) {
            addCriterion("routebill_id <", value, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdLessThanOrEqualTo(String value) {
            addCriterion("routebill_id <=", value, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdLike(String value) {
            addCriterion("routebill_id like", value, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdNotLike(String value) {
            addCriterion("routebill_id not like", value, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdIn(List<String> values) {
            addCriterion("routebill_id in", values, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdNotIn(List<String> values) {
            addCriterion("routebill_id not in", values, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdBetween(String value1, String value2) {
            addCriterion("routebill_id between", value1, value2, "routebillId");
            return (Criteria) this;
        }

        public Criteria andRoutebillIdNotBetween(String value1, String value2) {
            addCriterion("routebill_id not between", value1, value2, "routebillId");
            return (Criteria) this;
        }

        public Criteria andStartstationIsNull() {
            addCriterion("startstation is null");
            return (Criteria) this;
        }

        public Criteria andStartstationIsNotNull() {
            addCriterion("startstation is not null");
            return (Criteria) this;
        }

        public Criteria andStartstationEqualTo(String value) {
            addCriterion("startstation =", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationNotEqualTo(String value) {
            addCriterion("startstation <>", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationGreaterThan(String value) {
            addCriterion("startstation >", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationGreaterThanOrEqualTo(String value) {
            addCriterion("startstation >=", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationLessThan(String value) {
            addCriterion("startstation <", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationLessThanOrEqualTo(String value) {
            addCriterion("startstation <=", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationLike(String value) {
            addCriterion("startstation like", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationNotLike(String value) {
            addCriterion("startstation not like", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationIn(List<String> values) {
            addCriterion("startstation in", values, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationNotIn(List<String> values) {
            addCriterion("startstation not in", values, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationBetween(String value1, String value2) {
            addCriterion("startstation between", value1, value2, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationNotBetween(String value1, String value2) {
            addCriterion("startstation not between", value1, value2, "startstation");
            return (Criteria) this;
        }

        public Criteria andEndstationIsNull() {
            addCriterion("endstation is null");
            return (Criteria) this;
        }

        public Criteria andEndstationIsNotNull() {
            addCriterion("endstation is not null");
            return (Criteria) this;
        }

        public Criteria andEndstationEqualTo(String value) {
            addCriterion("endstation =", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationNotEqualTo(String value) {
            addCriterion("endstation <>", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationGreaterThan(String value) {
            addCriterion("endstation >", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationGreaterThanOrEqualTo(String value) {
            addCriterion("endstation >=", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationLessThan(String value) {
            addCriterion("endstation <", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationLessThanOrEqualTo(String value) {
            addCriterion("endstation <=", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationLike(String value) {
            addCriterion("endstation like", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationNotLike(String value) {
            addCriterion("endstation not like", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationIn(List<String> values) {
            addCriterion("endstation in", values, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationNotIn(List<String> values) {
            addCriterion("endstation not in", values, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationBetween(String value1, String value2) {
            addCriterion("endstation between", value1, value2, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationNotBetween(String value1, String value2) {
            addCriterion("endstation not between", value1, value2, "endstation");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterionForJDBCTime("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCTime("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCTime("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCTime("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCTime("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCTime("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCTime("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andPiciIsNull() {
            addCriterion("pici is null");
            return (Criteria) this;
        }

        public Criteria andPiciIsNotNull() {
            addCriterion("pici is not null");
            return (Criteria) this;
        }

        public Criteria andPiciEqualTo(String value) {
            addCriterion("pici =", value, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciNotEqualTo(String value) {
            addCriterion("pici <>", value, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciGreaterThan(String value) {
            addCriterion("pici >", value, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciGreaterThanOrEqualTo(String value) {
            addCriterion("pici >=", value, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciLessThan(String value) {
            addCriterion("pici <", value, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciLessThanOrEqualTo(String value) {
            addCriterion("pici <=", value, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciLike(String value) {
            addCriterion("pici like", value, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciNotLike(String value) {
            addCriterion("pici not like", value, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciIn(List<String> values) {
            addCriterion("pici in", values, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciNotIn(List<String> values) {
            addCriterion("pici not in", values, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciBetween(String value1, String value2) {
            addCriterion("pici between", value1, value2, "pici");
            return (Criteria) this;
        }

        public Criteria andPiciNotBetween(String value1, String value2) {
            addCriterion("pici not between", value1, value2, "pici");
            return (Criteria) this;
        }

        public Criteria andLinenameIsNull() {
            addCriterion("linename is null");
            return (Criteria) this;
        }

        public Criteria andLinenameIsNotNull() {
            addCriterion("linename is not null");
            return (Criteria) this;
        }

        public Criteria andLinenameEqualTo(String value) {
            addCriterion("linename =", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameNotEqualTo(String value) {
            addCriterion("linename <>", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameGreaterThan(String value) {
            addCriterion("linename >", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameGreaterThanOrEqualTo(String value) {
            addCriterion("linename >=", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameLessThan(String value) {
            addCriterion("linename <", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameLessThanOrEqualTo(String value) {
            addCriterion("linename <=", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameLike(String value) {
            addCriterion("linename like", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameNotLike(String value) {
            addCriterion("linename not like", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameIn(List<String> values) {
            addCriterion("linename in", values, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameNotIn(List<String> values) {
            addCriterion("linename not in", values, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameBetween(String value1, String value2) {
            addCriterion("linename between", value1, value2, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameNotBetween(String value1, String value2) {
            addCriterion("linename not between", value1, value2, "linename");
            return (Criteria) this;
        }

        public Criteria andLinepriceIsNull() {
            addCriterion("lineprice is null");
            return (Criteria) this;
        }

        public Criteria andLinepriceIsNotNull() {
            addCriterion("lineprice is not null");
            return (Criteria) this;
        }

        public Criteria andLinepriceEqualTo(Double value) {
            addCriterion("lineprice =", value, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceNotEqualTo(Double value) {
            addCriterion("lineprice <>", value, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceGreaterThan(Double value) {
            addCriterion("lineprice >", value, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("lineprice >=", value, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceLessThan(Double value) {
            addCriterion("lineprice <", value, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceLessThanOrEqualTo(Double value) {
            addCriterion("lineprice <=", value, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceIn(List<Double> values) {
            addCriterion("lineprice in", values, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceNotIn(List<Double> values) {
            addCriterion("lineprice not in", values, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceBetween(Double value1, Double value2) {
            addCriterion("lineprice between", value1, value2, "lineprice");
            return (Criteria) this;
        }

        public Criteria andLinepriceNotBetween(Double value1, Double value2) {
            addCriterion("lineprice not between", value1, value2, "lineprice");
            return (Criteria) this;
        }

        public Criteria andMileageIsNull() {
            addCriterion("mileage is null");
            return (Criteria) this;
        }

        public Criteria andMileageIsNotNull() {
            addCriterion("mileage is not null");
            return (Criteria) this;
        }

        public Criteria andMileageEqualTo(Double value) {
            addCriterion("mileage =", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotEqualTo(Double value) {
            addCriterion("mileage <>", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThan(Double value) {
            addCriterion("mileage >", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThanOrEqualTo(Double value) {
            addCriterion("mileage >=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThan(Double value) {
            addCriterion("mileage <", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThanOrEqualTo(Double value) {
            addCriterion("mileage <=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageIn(List<Double> values) {
            addCriterion("mileage in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotIn(List<Double> values) {
            addCriterion("mileage not in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageBetween(Double value1, Double value2) {
            addCriterion("mileage between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotBetween(Double value1, Double value2) {
            addCriterion("mileage not between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andTianshuIsNull() {
            addCriterion("tianshu is null");
            return (Criteria) this;
        }

        public Criteria andTianshuIsNotNull() {
            addCriterion("tianshu is not null");
            return (Criteria) this;
        }

        public Criteria andTianshuEqualTo(String value) {
            addCriterion("tianshu =", value, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuNotEqualTo(String value) {
            addCriterion("tianshu <>", value, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuGreaterThan(String value) {
            addCriterion("tianshu >", value, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuGreaterThanOrEqualTo(String value) {
            addCriterion("tianshu >=", value, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuLessThan(String value) {
            addCriterion("tianshu <", value, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuLessThanOrEqualTo(String value) {
            addCriterion("tianshu <=", value, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuLike(String value) {
            addCriterion("tianshu like", value, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuNotLike(String value) {
            addCriterion("tianshu not like", value, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuIn(List<String> values) {
            addCriterion("tianshu in", values, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuNotIn(List<String> values) {
            addCriterion("tianshu not in", values, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuBetween(String value1, String value2) {
            addCriterion("tianshu between", value1, value2, "tianshu");
            return (Criteria) this;
        }

        public Criteria andTianshuNotBetween(String value1, String value2) {
            addCriterion("tianshu not between", value1, value2, "tianshu");
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