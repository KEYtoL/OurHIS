package com.woniuxy.springboot.HIS.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BinglimingxiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BinglimingxiExample() {
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

        public Criteria andBmidIsNull() {
            addCriterion("bmid is null");
            return (Criteria) this;
        }

        public Criteria andBmidIsNotNull() {
            addCriterion("bmid is not null");
            return (Criteria) this;
        }

        public Criteria andBmidEqualTo(Integer value) {
            addCriterion("bmid =", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotEqualTo(Integer value) {
            addCriterion("bmid <>", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidGreaterThan(Integer value) {
            addCriterion("bmid >", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bmid >=", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidLessThan(Integer value) {
            addCriterion("bmid <", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidLessThanOrEqualTo(Integer value) {
            addCriterion("bmid <=", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidIn(List<Integer> values) {
            addCriterion("bmid in", values, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotIn(List<Integer> values) {
            addCriterion("bmid not in", values, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidBetween(Integer value1, Integer value2) {
            addCriterion("bmid between", value1, value2, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotBetween(Integer value1, Integer value2) {
            addCriterion("bmid not between", value1, value2, "bmid");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andBdateIsNull() {
            addCriterion("bdate is null");
            return (Criteria) this;
        }

        public Criteria andBdateIsNotNull() {
            addCriterion("bdate is not null");
            return (Criteria) this;
        }

        public Criteria andBdateEqualTo(Date value) {
            addCriterionForJDBCDate("bdate =", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("bdate <>", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateGreaterThan(Date value) {
            addCriterionForJDBCDate("bdate >", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bdate >=", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateLessThan(Date value) {
            addCriterionForJDBCDate("bdate <", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bdate <=", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateIn(List<Date> values) {
            addCriterionForJDBCDate("bdate in", values, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("bdate not in", values, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bdate between", value1, value2, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bdate not between", value1, value2, "bdate");
            return (Criteria) this;
        }

        public Criteria andBadviceIsNull() {
            addCriterion("badvice is null");
            return (Criteria) this;
        }

        public Criteria andBadviceIsNotNull() {
            addCriterion("badvice is not null");
            return (Criteria) this;
        }

        public Criteria andBadviceEqualTo(String value) {
            addCriterion("badvice =", value, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceNotEqualTo(String value) {
            addCriterion("badvice <>", value, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceGreaterThan(String value) {
            addCriterion("badvice >", value, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceGreaterThanOrEqualTo(String value) {
            addCriterion("badvice >=", value, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceLessThan(String value) {
            addCriterion("badvice <", value, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceLessThanOrEqualTo(String value) {
            addCriterion("badvice <=", value, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceLike(String value) {
            addCriterion("badvice like", value, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceNotLike(String value) {
            addCriterion("badvice not like", value, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceIn(List<String> values) {
            addCriterion("badvice in", values, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceNotIn(List<String> values) {
            addCriterion("badvice not in", values, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceBetween(String value1, String value2) {
            addCriterion("badvice between", value1, value2, "badvice");
            return (Criteria) this;
        }

        public Criteria andBadviceNotBetween(String value1, String value2) {
            addCriterion("badvice not between", value1, value2, "badvice");
            return (Criteria) this;
        }

        public Criteria andKidIsNull() {
            addCriterion("kid is null");
            return (Criteria) this;
        }

        public Criteria andKidIsNotNull() {
            addCriterion("kid is not null");
            return (Criteria) this;
        }

        public Criteria andKidEqualTo(Integer value) {
            addCriterion("kid =", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotEqualTo(Integer value) {
            addCriterion("kid <>", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThan(Integer value) {
            addCriterion("kid >", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThanOrEqualTo(Integer value) {
            addCriterion("kid >=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThan(Integer value) {
            addCriterion("kid <", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThanOrEqualTo(Integer value) {
            addCriterion("kid <=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidIn(List<Integer> values) {
            addCriterion("kid in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotIn(List<Integer> values) {
            addCriterion("kid not in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidBetween(Integer value1, Integer value2) {
            addCriterion("kid between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotBetween(Integer value1, Integer value2) {
            addCriterion("kid not between", value1, value2, "kid");
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