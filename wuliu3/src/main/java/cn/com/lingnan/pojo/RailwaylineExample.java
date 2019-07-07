package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RailwaylineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RailwaylineExample() {
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

        public Criteria andTrainnumIsNull() {
            addCriterion("trainnum is null");
            return (Criteria) this;
        }

        public Criteria andTrainnumIsNotNull() {
            addCriterion("trainnum is not null");
            return (Criteria) this;
        }

        public Criteria andTrainnumEqualTo(String value) {
            addCriterion("trainnum =", value, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumNotEqualTo(String value) {
            addCriterion("trainnum <>", value, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumGreaterThan(String value) {
            addCriterion("trainnum >", value, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumGreaterThanOrEqualTo(String value) {
            addCriterion("trainnum >=", value, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumLessThan(String value) {
            addCriterion("trainnum <", value, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumLessThanOrEqualTo(String value) {
            addCriterion("trainnum <=", value, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumLike(String value) {
            addCriterion("trainnum like", value, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumNotLike(String value) {
            addCriterion("trainnum not like", value, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumIn(List<String> values) {
            addCriterion("trainnum in", values, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumNotIn(List<String> values) {
            addCriterion("trainnum not in", values, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumBetween(String value1, String value2) {
            addCriterion("trainnum between", value1, value2, "trainnum");
            return (Criteria) this;
        }

        public Criteria andTrainnumNotBetween(String value1, String value2) {
            addCriterion("trainnum not between", value1, value2, "trainnum");
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

        public Criteria andTransferpriIsNull() {
            addCriterion("transferpri is null");
            return (Criteria) this;
        }

        public Criteria andTransferpriIsNotNull() {
            addCriterion("transferpri is not null");
            return (Criteria) this;
        }

        public Criteria andTransferpriEqualTo(String value) {
            addCriterion("transferpri =", value, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriNotEqualTo(String value) {
            addCriterion("transferpri <>", value, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriGreaterThan(String value) {
            addCriterion("transferpri >", value, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriGreaterThanOrEqualTo(String value) {
            addCriterion("transferpri >=", value, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriLessThan(String value) {
            addCriterion("transferpri <", value, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriLessThanOrEqualTo(String value) {
            addCriterion("transferpri <=", value, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriLike(String value) {
            addCriterion("transferpri like", value, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriNotLike(String value) {
            addCriterion("transferpri not like", value, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriIn(List<String> values) {
            addCriterion("transferpri in", values, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriNotIn(List<String> values) {
            addCriterion("transferpri not in", values, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriBetween(String value1, String value2) {
            addCriterion("transferpri between", value1, value2, "transferpri");
            return (Criteria) this;
        }

        public Criteria andTransferpriNotBetween(String value1, String value2) {
            addCriterion("transferpri not between", value1, value2, "transferpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriIsNull() {
            addCriterion("directpri is null");
            return (Criteria) this;
        }

        public Criteria andDirectpriIsNotNull() {
            addCriterion("directpri is not null");
            return (Criteria) this;
        }

        public Criteria andDirectpriEqualTo(String value) {
            addCriterion("directpri =", value, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriNotEqualTo(String value) {
            addCriterion("directpri <>", value, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriGreaterThan(String value) {
            addCriterion("directpri >", value, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriGreaterThanOrEqualTo(String value) {
            addCriterion("directpri >=", value, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriLessThan(String value) {
            addCriterion("directpri <", value, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriLessThanOrEqualTo(String value) {
            addCriterion("directpri <=", value, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriLike(String value) {
            addCriterion("directpri like", value, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriNotLike(String value) {
            addCriterion("directpri not like", value, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriIn(List<String> values) {
            addCriterion("directpri in", values, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriNotIn(List<String> values) {
            addCriterion("directpri not in", values, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriBetween(String value1, String value2) {
            addCriterion("directpri between", value1, value2, "directpri");
            return (Criteria) this;
        }

        public Criteria andDirectpriNotBetween(String value1, String value2) {
            addCriterion("directpri not between", value1, value2, "directpri");
            return (Criteria) this;
        }

        public Criteria andStartcityIsNull() {
            addCriterion("startcity is null");
            return (Criteria) this;
        }

        public Criteria andStartcityIsNotNull() {
            addCriterion("startcity is not null");
            return (Criteria) this;
        }

        public Criteria andStartcityEqualTo(String value) {
            addCriterion("startcity =", value, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityNotEqualTo(String value) {
            addCriterion("startcity <>", value, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityGreaterThan(String value) {
            addCriterion("startcity >", value, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityGreaterThanOrEqualTo(String value) {
            addCriterion("startcity >=", value, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityLessThan(String value) {
            addCriterion("startcity <", value, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityLessThanOrEqualTo(String value) {
            addCriterion("startcity <=", value, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityLike(String value) {
            addCriterion("startcity like", value, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityNotLike(String value) {
            addCriterion("startcity not like", value, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityIn(List<String> values) {
            addCriterion("startcity in", values, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityNotIn(List<String> values) {
            addCriterion("startcity not in", values, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityBetween(String value1, String value2) {
            addCriterion("startcity between", value1, value2, "startcity");
            return (Criteria) this;
        }

        public Criteria andStartcityNotBetween(String value1, String value2) {
            addCriterion("startcity not between", value1, value2, "startcity");
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

        public Criteria andOutcenterIsNull() {
            addCriterion("outcenter is null");
            return (Criteria) this;
        }

        public Criteria andOutcenterIsNotNull() {
            addCriterion("outcenter is not null");
            return (Criteria) this;
        }

        public Criteria andOutcenterEqualTo(String value) {
            addCriterion("outcenter =", value, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterNotEqualTo(String value) {
            addCriterion("outcenter <>", value, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterGreaterThan(String value) {
            addCriterion("outcenter >", value, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterGreaterThanOrEqualTo(String value) {
            addCriterion("outcenter >=", value, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterLessThan(String value) {
            addCriterion("outcenter <", value, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterLessThanOrEqualTo(String value) {
            addCriterion("outcenter <=", value, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterLike(String value) {
            addCriterion("outcenter like", value, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterNotLike(String value) {
            addCriterion("outcenter not like", value, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterIn(List<String> values) {
            addCriterion("outcenter in", values, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterNotIn(List<String> values) {
            addCriterion("outcenter not in", values, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterBetween(String value1, String value2) {
            addCriterion("outcenter between", value1, value2, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutcenterNotBetween(String value1, String value2) {
            addCriterion("outcenter not between", value1, value2, "outcenter");
            return (Criteria) this;
        }

        public Criteria andOutpiciIsNull() {
            addCriterion("outpici is null");
            return (Criteria) this;
        }

        public Criteria andOutpiciIsNotNull() {
            addCriterion("outpici is not null");
            return (Criteria) this;
        }

        public Criteria andOutpiciEqualTo(String value) {
            addCriterion("outpici =", value, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciNotEqualTo(String value) {
            addCriterion("outpici <>", value, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciGreaterThan(String value) {
            addCriterion("outpici >", value, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciGreaterThanOrEqualTo(String value) {
            addCriterion("outpici >=", value, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciLessThan(String value) {
            addCriterion("outpici <", value, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciLessThanOrEqualTo(String value) {
            addCriterion("outpici <=", value, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciLike(String value) {
            addCriterion("outpici like", value, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciNotLike(String value) {
            addCriterion("outpici not like", value, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciIn(List<String> values) {
            addCriterion("outpici in", values, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciNotIn(List<String> values) {
            addCriterion("outpici not in", values, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciBetween(String value1, String value2) {
            addCriterion("outpici between", value1, value2, "outpici");
            return (Criteria) this;
        }

        public Criteria andOutpiciNotBetween(String value1, String value2) {
            addCriterion("outpici not between", value1, value2, "outpici");
            return (Criteria) this;
        }

        public Criteria andCheciIsNull() {
            addCriterion("checi is null");
            return (Criteria) this;
        }

        public Criteria andCheciIsNotNull() {
            addCriterion("checi is not null");
            return (Criteria) this;
        }

        public Criteria andCheciEqualTo(String value) {
            addCriterion("checi =", value, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciNotEqualTo(String value) {
            addCriterion("checi <>", value, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciGreaterThan(String value) {
            addCriterion("checi >", value, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciGreaterThanOrEqualTo(String value) {
            addCriterion("checi >=", value, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciLessThan(String value) {
            addCriterion("checi <", value, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciLessThanOrEqualTo(String value) {
            addCriterion("checi <=", value, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciLike(String value) {
            addCriterion("checi like", value, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciNotLike(String value) {
            addCriterion("checi not like", value, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciIn(List<String> values) {
            addCriterion("checi in", values, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciNotIn(List<String> values) {
            addCriterion("checi not in", values, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciBetween(String value1, String value2) {
            addCriterion("checi between", value1, value2, "checi");
            return (Criteria) this;
        }

        public Criteria andCheciNotBetween(String value1, String value2) {
            addCriterion("checi not between", value1, value2, "checi");
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

        public Criteria andIntcenterIsNull() {
            addCriterion("intcenter is null");
            return (Criteria) this;
        }

        public Criteria andIntcenterIsNotNull() {
            addCriterion("intcenter is not null");
            return (Criteria) this;
        }

        public Criteria andIntcenterEqualTo(String value) {
            addCriterion("intcenter =", value, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterNotEqualTo(String value) {
            addCriterion("intcenter <>", value, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterGreaterThan(String value) {
            addCriterion("intcenter >", value, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterGreaterThanOrEqualTo(String value) {
            addCriterion("intcenter >=", value, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterLessThan(String value) {
            addCriterion("intcenter <", value, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterLessThanOrEqualTo(String value) {
            addCriterion("intcenter <=", value, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterLike(String value) {
            addCriterion("intcenter like", value, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterNotLike(String value) {
            addCriterion("intcenter not like", value, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterIn(List<String> values) {
            addCriterion("intcenter in", values, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterNotIn(List<String> values) {
            addCriterion("intcenter not in", values, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterBetween(String value1, String value2) {
            addCriterion("intcenter between", value1, value2, "intcenter");
            return (Criteria) this;
        }

        public Criteria andIntcenterNotBetween(String value1, String value2) {
            addCriterion("intcenter not between", value1, value2, "intcenter");
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

        public Criteria andTransfepiciIsNull() {
            addCriterion("transfepici is null");
            return (Criteria) this;
        }

        public Criteria andTransfepiciIsNotNull() {
            addCriterion("transfepici is not null");
            return (Criteria) this;
        }

        public Criteria andTransfepiciEqualTo(String value) {
            addCriterion("transfepici =", value, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciNotEqualTo(String value) {
            addCriterion("transfepici <>", value, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciGreaterThan(String value) {
            addCriterion("transfepici >", value, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciGreaterThanOrEqualTo(String value) {
            addCriterion("transfepici >=", value, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciLessThan(String value) {
            addCriterion("transfepici <", value, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciLessThanOrEqualTo(String value) {
            addCriterion("transfepici <=", value, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciLike(String value) {
            addCriterion("transfepici like", value, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciNotLike(String value) {
            addCriterion("transfepici not like", value, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciIn(List<String> values) {
            addCriterion("transfepici in", values, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciNotIn(List<String> values) {
            addCriterion("transfepici not in", values, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciBetween(String value1, String value2) {
            addCriterion("transfepici between", value1, value2, "transfepici");
            return (Criteria) this;
        }

        public Criteria andTransfepiciNotBetween(String value1, String value2) {
            addCriterion("transfepici not between", value1, value2, "transfepici");
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

        public Criteria andUnitpriceIsNull() {
            addCriterion("unitprice is null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIsNotNull() {
            addCriterion("unitprice is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceEqualTo(Double value) {
            addCriterion("unitprice =", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotEqualTo(Double value) {
            addCriterion("unitprice <>", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceGreaterThan(Double value) {
            addCriterion("unitprice >", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("unitprice >=", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLessThan(Double value) {
            addCriterion("unitprice <", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLessThanOrEqualTo(Double value) {
            addCriterion("unitprice <=", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIn(List<Double> values) {
            addCriterion("unitprice in", values, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotIn(List<Double> values) {
            addCriterion("unitprice not in", values, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceBetween(Double value1, Double value2) {
            addCriterion("unitprice between", value1, value2, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotBetween(Double value1, Double value2) {
            addCriterion("unitprice not between", value1, value2, "unitprice");
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

        public Criteria andInputpersonIsNull() {
            addCriterion("inputperson is null");
            return (Criteria) this;
        }

        public Criteria andInputpersonIsNotNull() {
            addCriterion("inputperson is not null");
            return (Criteria) this;
        }

        public Criteria andInputpersonEqualTo(String value) {
            addCriterion("inputperson =", value, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonNotEqualTo(String value) {
            addCriterion("inputperson <>", value, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonGreaterThan(String value) {
            addCriterion("inputperson >", value, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonGreaterThanOrEqualTo(String value) {
            addCriterion("inputperson >=", value, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonLessThan(String value) {
            addCriterion("inputperson <", value, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonLessThanOrEqualTo(String value) {
            addCriterion("inputperson <=", value, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonLike(String value) {
            addCriterion("inputperson like", value, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonNotLike(String value) {
            addCriterion("inputperson not like", value, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonIn(List<String> values) {
            addCriterion("inputperson in", values, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonNotIn(List<String> values) {
            addCriterion("inputperson not in", values, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonBetween(String value1, String value2) {
            addCriterion("inputperson between", value1, value2, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputpersonNotBetween(String value1, String value2) {
            addCriterion("inputperson not between", value1, value2, "inputperson");
            return (Criteria) this;
        }

        public Criteria andInputtimeIsNull() {
            addCriterion("inputtime is null");
            return (Criteria) this;
        }

        public Criteria andInputtimeIsNotNull() {
            addCriterion("inputtime is not null");
            return (Criteria) this;
        }

        public Criteria andInputtimeEqualTo(Date value) {
            addCriterion("inputtime =", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotEqualTo(Date value) {
            addCriterion("inputtime <>", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeGreaterThan(Date value) {
            addCriterion("inputtime >", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inputtime >=", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeLessThan(Date value) {
            addCriterion("inputtime <", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeLessThanOrEqualTo(Date value) {
            addCriterion("inputtime <=", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeIn(List<Date> values) {
            addCriterion("inputtime in", values, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotIn(List<Date> values) {
            addCriterion("inputtime not in", values, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeBetween(Date value1, Date value2) {
            addCriterion("inputtime between", value1, value2, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotBetween(Date value1, Date value2) {
            addCriterion("inputtime not between", value1, value2, "inputtime");
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