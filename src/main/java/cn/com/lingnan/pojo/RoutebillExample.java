package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RoutebillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoutebillExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andStartprovinceIsNull() {
            addCriterion("startprovince is null");
            return (Criteria) this;
        }

        public Criteria andStartprovinceIsNotNull() {
            addCriterion("startprovince is not null");
            return (Criteria) this;
        }

        public Criteria andStartprovinceEqualTo(String value) {
            addCriterion("startprovince =", value, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceNotEqualTo(String value) {
            addCriterion("startprovince <>", value, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceGreaterThan(String value) {
            addCriterion("startprovince >", value, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("startprovince >=", value, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceLessThan(String value) {
            addCriterion("startprovince <", value, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceLessThanOrEqualTo(String value) {
            addCriterion("startprovince <=", value, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceLike(String value) {
            addCriterion("startprovince like", value, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceNotLike(String value) {
            addCriterion("startprovince not like", value, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceIn(List<String> values) {
            addCriterion("startprovince in", values, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceNotIn(List<String> values) {
            addCriterion("startprovince not in", values, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceBetween(String value1, String value2) {
            addCriterion("startprovince between", value1, value2, "startprovince");
            return (Criteria) this;
        }

        public Criteria andStartprovinceNotBetween(String value1, String value2) {
            addCriterion("startprovince not between", value1, value2, "startprovince");
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

        public Criteria andStartdistrictIsNull() {
            addCriterion("startdistrict is null");
            return (Criteria) this;
        }

        public Criteria andStartdistrictIsNotNull() {
            addCriterion("startdistrict is not null");
            return (Criteria) this;
        }

        public Criteria andStartdistrictEqualTo(String value) {
            addCriterion("startdistrict =", value, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictNotEqualTo(String value) {
            addCriterion("startdistrict <>", value, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictGreaterThan(String value) {
            addCriterion("startdistrict >", value, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictGreaterThanOrEqualTo(String value) {
            addCriterion("startdistrict >=", value, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictLessThan(String value) {
            addCriterion("startdistrict <", value, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictLessThanOrEqualTo(String value) {
            addCriterion("startdistrict <=", value, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictLike(String value) {
            addCriterion("startdistrict like", value, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictNotLike(String value) {
            addCriterion("startdistrict not like", value, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictIn(List<String> values) {
            addCriterion("startdistrict in", values, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictNotIn(List<String> values) {
            addCriterion("startdistrict not in", values, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictBetween(String value1, String value2) {
            addCriterion("startdistrict between", value1, value2, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andStartdistrictNotBetween(String value1, String value2) {
            addCriterion("startdistrict not between", value1, value2, "startdistrict");
            return (Criteria) this;
        }

        public Criteria andEndprovinceIsNull() {
            addCriterion("endprovince is null");
            return (Criteria) this;
        }

        public Criteria andEndprovinceIsNotNull() {
            addCriterion("endprovince is not null");
            return (Criteria) this;
        }

        public Criteria andEndprovinceEqualTo(String value) {
            addCriterion("endprovince =", value, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceNotEqualTo(String value) {
            addCriterion("endprovince <>", value, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceGreaterThan(String value) {
            addCriterion("endprovince >", value, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("endprovince >=", value, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceLessThan(String value) {
            addCriterion("endprovince <", value, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceLessThanOrEqualTo(String value) {
            addCriterion("endprovince <=", value, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceLike(String value) {
            addCriterion("endprovince like", value, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceNotLike(String value) {
            addCriterion("endprovince not like", value, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceIn(List<String> values) {
            addCriterion("endprovince in", values, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceNotIn(List<String> values) {
            addCriterion("endprovince not in", values, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceBetween(String value1, String value2) {
            addCriterion("endprovince between", value1, value2, "endprovince");
            return (Criteria) this;
        }

        public Criteria andEndprovinceNotBetween(String value1, String value2) {
            addCriterion("endprovince not between", value1, value2, "endprovince");
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

        public Criteria andEnddistrictIsNull() {
            addCriterion("enddistrict is null");
            return (Criteria) this;
        }

        public Criteria andEnddistrictIsNotNull() {
            addCriterion("enddistrict is not null");
            return (Criteria) this;
        }

        public Criteria andEnddistrictEqualTo(String value) {
            addCriterion("enddistrict =", value, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictNotEqualTo(String value) {
            addCriterion("enddistrict <>", value, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictGreaterThan(String value) {
            addCriterion("enddistrict >", value, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictGreaterThanOrEqualTo(String value) {
            addCriterion("enddistrict >=", value, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictLessThan(String value) {
            addCriterion("enddistrict <", value, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictLessThanOrEqualTo(String value) {
            addCriterion("enddistrict <=", value, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictLike(String value) {
            addCriterion("enddistrict like", value, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictNotLike(String value) {
            addCriterion("enddistrict not like", value, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictIn(List<String> values) {
            addCriterion("enddistrict in", values, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictNotIn(List<String> values) {
            addCriterion("enddistrict not in", values, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictBetween(String value1, String value2) {
            addCriterion("enddistrict between", value1, value2, "enddistrict");
            return (Criteria) this;
        }

        public Criteria andEnddistrictNotBetween(String value1, String value2) {
            addCriterion("enddistrict not between", value1, value2, "enddistrict");
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

        public Criteria andTimelimitEqualTo(String value) {
            addCriterion("timelimit =", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotEqualTo(String value) {
            addCriterion("timelimit <>", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThan(String value) {
            addCriterion("timelimit >", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThanOrEqualTo(String value) {
            addCriterion("timelimit >=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThan(String value) {
            addCriterion("timelimit <", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThanOrEqualTo(String value) {
            addCriterion("timelimit <=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLike(String value) {
            addCriterion("timelimit like", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotLike(String value) {
            addCriterion("timelimit not like", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitIn(List<String> values) {
            addCriterion("timelimit in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotIn(List<String> values) {
            addCriterion("timelimit not in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitBetween(String value1, String value2) {
            addCriterion("timelimit between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotBetween(String value1, String value2) {
            addCriterion("timelimit not between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTransfernode1IsNull() {
            addCriterion("transfernode1 is null");
            return (Criteria) this;
        }

        public Criteria andTransfernode1IsNotNull() {
            addCriterion("transfernode1 is not null");
            return (Criteria) this;
        }

        public Criteria andTransfernode1EqualTo(String value) {
            addCriterion("transfernode1 =", value, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1NotEqualTo(String value) {
            addCriterion("transfernode1 <>", value, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1GreaterThan(String value) {
            addCriterion("transfernode1 >", value, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1GreaterThanOrEqualTo(String value) {
            addCriterion("transfernode1 >=", value, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1LessThan(String value) {
            addCriterion("transfernode1 <", value, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1LessThanOrEqualTo(String value) {
            addCriterion("transfernode1 <=", value, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1Like(String value) {
            addCriterion("transfernode1 like", value, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1NotLike(String value) {
            addCriterion("transfernode1 not like", value, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1In(List<String> values) {
            addCriterion("transfernode1 in", values, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1NotIn(List<String> values) {
            addCriterion("transfernode1 not in", values, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1Between(String value1, String value2) {
            addCriterion("transfernode1 between", value1, value2, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode1NotBetween(String value1, String value2) {
            addCriterion("transfernode1 not between", value1, value2, "transfernode1");
            return (Criteria) this;
        }

        public Criteria andTransfernode2IsNull() {
            addCriterion("transfernode2 is null");
            return (Criteria) this;
        }

        public Criteria andTransfernode2IsNotNull() {
            addCriterion("transfernode2 is not null");
            return (Criteria) this;
        }

        public Criteria andTransfernode2EqualTo(String value) {
            addCriterion("transfernode2 =", value, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2NotEqualTo(String value) {
            addCriterion("transfernode2 <>", value, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2GreaterThan(String value) {
            addCriterion("transfernode2 >", value, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2GreaterThanOrEqualTo(String value) {
            addCriterion("transfernode2 >=", value, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2LessThan(String value) {
            addCriterion("transfernode2 <", value, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2LessThanOrEqualTo(String value) {
            addCriterion("transfernode2 <=", value, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2Like(String value) {
            addCriterion("transfernode2 like", value, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2NotLike(String value) {
            addCriterion("transfernode2 not like", value, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2In(List<String> values) {
            addCriterion("transfernode2 in", values, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2NotIn(List<String> values) {
            addCriterion("transfernode2 not in", values, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2Between(String value1, String value2) {
            addCriterion("transfernode2 between", value1, value2, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode2NotBetween(String value1, String value2) {
            addCriterion("transfernode2 not between", value1, value2, "transfernode2");
            return (Criteria) this;
        }

        public Criteria andTransfernode3IsNull() {
            addCriterion("transfernode3 is null");
            return (Criteria) this;
        }

        public Criteria andTransfernode3IsNotNull() {
            addCriterion("transfernode3 is not null");
            return (Criteria) this;
        }

        public Criteria andTransfernode3EqualTo(String value) {
            addCriterion("transfernode3 =", value, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3NotEqualTo(String value) {
            addCriterion("transfernode3 <>", value, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3GreaterThan(String value) {
            addCriterion("transfernode3 >", value, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3GreaterThanOrEqualTo(String value) {
            addCriterion("transfernode3 >=", value, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3LessThan(String value) {
            addCriterion("transfernode3 <", value, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3LessThanOrEqualTo(String value) {
            addCriterion("transfernode3 <=", value, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3Like(String value) {
            addCriterion("transfernode3 like", value, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3NotLike(String value) {
            addCriterion("transfernode3 not like", value, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3In(List<String> values) {
            addCriterion("transfernode3 in", values, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3NotIn(List<String> values) {
            addCriterion("transfernode3 not in", values, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3Between(String value1, String value2) {
            addCriterion("transfernode3 between", value1, value2, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode3NotBetween(String value1, String value2) {
            addCriterion("transfernode3 not between", value1, value2, "transfernode3");
            return (Criteria) this;
        }

        public Criteria andTransfernode4IsNull() {
            addCriterion("transfernode4 is null");
            return (Criteria) this;
        }

        public Criteria andTransfernode4IsNotNull() {
            addCriterion("transfernode4 is not null");
            return (Criteria) this;
        }

        public Criteria andTransfernode4EqualTo(String value) {
            addCriterion("transfernode4 =", value, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4NotEqualTo(String value) {
            addCriterion("transfernode4 <>", value, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4GreaterThan(String value) {
            addCriterion("transfernode4 >", value, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4GreaterThanOrEqualTo(String value) {
            addCriterion("transfernode4 >=", value, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4LessThan(String value) {
            addCriterion("transfernode4 <", value, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4LessThanOrEqualTo(String value) {
            addCriterion("transfernode4 <=", value, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4Like(String value) {
            addCriterion("transfernode4 like", value, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4NotLike(String value) {
            addCriterion("transfernode4 not like", value, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4In(List<String> values) {
            addCriterion("transfernode4 in", values, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4NotIn(List<String> values) {
            addCriterion("transfernode4 not in", values, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4Between(String value1, String value2) {
            addCriterion("transfernode4 between", value1, value2, "transfernode4");
            return (Criteria) this;
        }

        public Criteria andTransfernode4NotBetween(String value1, String value2) {
            addCriterion("transfernode4 not between", value1, value2, "transfernode4");
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

        public Criteria andRoutepriceIsNull() {
            addCriterion("routeprice is null");
            return (Criteria) this;
        }

        public Criteria andRoutepriceIsNotNull() {
            addCriterion("routeprice is not null");
            return (Criteria) this;
        }

        public Criteria andRoutepriceEqualTo(Double value) {
            addCriterion("routeprice =", value, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceNotEqualTo(Double value) {
            addCriterion("routeprice <>", value, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceGreaterThan(Double value) {
            addCriterion("routeprice >", value, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("routeprice >=", value, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceLessThan(Double value) {
            addCriterion("routeprice <", value, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceLessThanOrEqualTo(Double value) {
            addCriterion("routeprice <=", value, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceIn(List<Double> values) {
            addCriterion("routeprice in", values, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceNotIn(List<Double> values) {
            addCriterion("routeprice not in", values, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceBetween(Double value1, Double value2) {
            addCriterion("routeprice between", value1, value2, "routeprice");
            return (Criteria) this;
        }

        public Criteria andRoutepriceNotBetween(Double value1, Double value2) {
            addCriterion("routeprice not between", value1, value2, "routeprice");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
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