package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkbillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkbillExample() {
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

        public Criteria andNoticebillIdIsNull() {
            addCriterion("noticebill_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdIsNotNull() {
            addCriterion("noticebill_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdEqualTo(String value) {
            addCriterion("noticebill_id =", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdNotEqualTo(String value) {
            addCriterion("noticebill_id <>", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdGreaterThan(String value) {
            addCriterion("noticebill_id >", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdGreaterThanOrEqualTo(String value) {
            addCriterion("noticebill_id >=", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdLessThan(String value) {
            addCriterion("noticebill_id <", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdLessThanOrEqualTo(String value) {
            addCriterion("noticebill_id <=", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdLike(String value) {
            addCriterion("noticebill_id like", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdNotLike(String value) {
            addCriterion("noticebill_id not like", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdIn(List<String> values) {
            addCriterion("noticebill_id in", values, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdNotIn(List<String> values) {
            addCriterion("noticebill_id not in", values, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdBetween(String value1, String value2) {
            addCriterion("noticebill_id between", value1, value2, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdNotBetween(String value1, String value2) {
            addCriterion("noticebill_id not between", value1, value2, "noticebillId");
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

        public Criteria andPickstateIsNull() {
            addCriterion("pickstate is null");
            return (Criteria) this;
        }

        public Criteria andPickstateIsNotNull() {
            addCriterion("pickstate is not null");
            return (Criteria) this;
        }

        public Criteria andPickstateEqualTo(String value) {
            addCriterion("pickstate =", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateNotEqualTo(String value) {
            addCriterion("pickstate <>", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateGreaterThan(String value) {
            addCriterion("pickstate >", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateGreaterThanOrEqualTo(String value) {
            addCriterion("pickstate >=", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateLessThan(String value) {
            addCriterion("pickstate <", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateLessThanOrEqualTo(String value) {
            addCriterion("pickstate <=", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateLike(String value) {
            addCriterion("pickstate like", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateNotLike(String value) {
            addCriterion("pickstate not like", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateIn(List<String> values) {
            addCriterion("pickstate in", values, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateNotIn(List<String> values) {
            addCriterion("pickstate not in", values, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateBetween(String value1, String value2) {
            addCriterion("pickstate between", value1, value2, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateNotBetween(String value1, String value2) {
            addCriterion("pickstate not between", value1, value2, "pickstate");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNull() {
            addCriterion("buildtime is null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNotNull() {
            addCriterion("buildtime is not null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeEqualTo(Date value) {
            addCriterionForJDBCDate("buildtime =", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("buildtime <>", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("buildtime >", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buildtime >=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThan(Date value) {
            addCriterionForJDBCDate("buildtime <", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buildtime <=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIn(List<Date> values) {
            addCriterionForJDBCDate("buildtime in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("buildtime not in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buildtime between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buildtime not between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesIsNull() {
            addCriterion("attachbilltimes is null");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesIsNotNull() {
            addCriterion("attachbilltimes is not null");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesEqualTo(Integer value) {
            addCriterion("attachbilltimes =", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesNotEqualTo(Integer value) {
            addCriterion("attachbilltimes <>", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesGreaterThan(Integer value) {
            addCriterion("attachbilltimes >", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("attachbilltimes >=", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesLessThan(Integer value) {
            addCriterion("attachbilltimes <", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesLessThanOrEqualTo(Integer value) {
            addCriterion("attachbilltimes <=", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesIn(List<Integer> values) {
            addCriterion("attachbilltimes in", values, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesNotIn(List<Integer> values) {
            addCriterion("attachbilltimes not in", values, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesBetween(Integer value1, Integer value2) {
            addCriterion("attachbilltimes between", value1, value2, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesNotBetween(Integer value1, Integer value2) {
            addCriterion("attachbilltimes not between", value1, value2, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andPickaddressIsNull() {
            addCriterion("pickaddress is null");
            return (Criteria) this;
        }

        public Criteria andPickaddressIsNotNull() {
            addCriterion("pickaddress is not null");
            return (Criteria) this;
        }

        public Criteria andPickaddressEqualTo(String value) {
            addCriterion("pickaddress =", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressNotEqualTo(String value) {
            addCriterion("pickaddress <>", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressGreaterThan(String value) {
            addCriterion("pickaddress >", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressGreaterThanOrEqualTo(String value) {
            addCriterion("pickaddress >=", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressLessThan(String value) {
            addCriterion("pickaddress <", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressLessThanOrEqualTo(String value) {
            addCriterion("pickaddress <=", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressLike(String value) {
            addCriterion("pickaddress like", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressNotLike(String value) {
            addCriterion("pickaddress not like", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressIn(List<String> values) {
            addCriterion("pickaddress in", values, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressNotIn(List<String> values) {
            addCriterion("pickaddress not in", values, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressBetween(String value1, String value2) {
            addCriterion("pickaddress between", value1, value2, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressNotBetween(String value1, String value2) {
            addCriterion("pickaddress not between", value1, value2, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPicktimeIsNull() {
            addCriterion("picktime is null");
            return (Criteria) this;
        }

        public Criteria andPicktimeIsNotNull() {
            addCriterion("picktime is not null");
            return (Criteria) this;
        }

        public Criteria andPicktimeEqualTo(Date value) {
            addCriterionForJDBCDate("picktime =", value, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("picktime <>", value, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeGreaterThan(Date value) {
            addCriterionForJDBCDate("picktime >", value, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("picktime >=", value, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeLessThan(Date value) {
            addCriterionForJDBCDate("picktime <", value, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("picktime <=", value, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeIn(List<Date> values) {
            addCriterionForJDBCDate("picktime in", values, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("picktime not in", values, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("picktime between", value1, value2, "picktime");
            return (Criteria) this;
        }

        public Criteria andPicktimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("picktime not between", value1, value2, "picktime");
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