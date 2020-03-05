package com.woniuxy.springboot.HIS.entity;

import java.util.ArrayList;
import java.util.List;

public class BedsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BedsExample() {
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

        public Criteria andIsnullIsNull() {
            addCriterion("isnull is null");
            return (Criteria) this;
        }

        public Criteria andIsnullIsNotNull() {
            addCriterion("isnull is not null");
            return (Criteria) this;
        }

        public Criteria andIsnullEqualTo(Integer value) {
            addCriterion("isnull =", value, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullNotEqualTo(Integer value) {
            addCriterion("isnull <>", value, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullGreaterThan(Integer value) {
            addCriterion("isnull >", value, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullGreaterThanOrEqualTo(Integer value) {
            addCriterion("isnull >=", value, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullLessThan(Integer value) {
            addCriterion("isnull <", value, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullLessThanOrEqualTo(Integer value) {
            addCriterion("isnull <=", value, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullIn(List<Integer> values) {
            addCriterion("isnull in", values, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullNotIn(List<Integer> values) {
            addCriterion("isnull not in", values, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullBetween(Integer value1, Integer value2) {
            addCriterion("isnull between", value1, value2, "isnull");
            return (Criteria) this;
        }

        public Criteria andIsnullNotBetween(Integer value1, Integer value2) {
            addCriterion("isnull not between", value1, value2, "isnull");
            return (Criteria) this;
        }

        public Criteria andBtypeIsNull() {
            addCriterion("btype is null");
            return (Criteria) this;
        }

        public Criteria andBtypeIsNotNull() {
            addCriterion("btype is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeEqualTo(Integer value) {
            addCriterion("btype =", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotEqualTo(Integer value) {
            addCriterion("btype <>", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeGreaterThan(Integer value) {
            addCriterion("btype >", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("btype >=", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeLessThan(Integer value) {
            addCriterion("btype <", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeLessThanOrEqualTo(Integer value) {
            addCriterion("btype <=", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeIn(List<Integer> values) {
            addCriterion("btype in", values, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotIn(List<Integer> values) {
            addCriterion("btype not in", values, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeBetween(Integer value1, Integer value2) {
            addCriterion("btype between", value1, value2, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("btype not between", value1, value2, "btype");
            return (Criteria) this;
        }

        public Criteria andBpriceIsNull() {
            addCriterion("bprice is null");
            return (Criteria) this;
        }

        public Criteria andBpriceIsNotNull() {
            addCriterion("bprice is not null");
            return (Criteria) this;
        }

        public Criteria andBpriceEqualTo(Integer value) {
            addCriterion("bprice =", value, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceNotEqualTo(Integer value) {
            addCriterion("bprice <>", value, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceGreaterThan(Integer value) {
            addCriterion("bprice >", value, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("bprice >=", value, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceLessThan(Integer value) {
            addCriterion("bprice <", value, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceLessThanOrEqualTo(Integer value) {
            addCriterion("bprice <=", value, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceIn(List<Integer> values) {
            addCriterion("bprice in", values, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceNotIn(List<Integer> values) {
            addCriterion("bprice not in", values, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceBetween(Integer value1, Integer value2) {
            addCriterion("bprice between", value1, value2, "bprice");
            return (Criteria) this;
        }

        public Criteria andBpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("bprice not between", value1, value2, "bprice");
            return (Criteria) this;
        }

        public Criteria andBaddrIsNull() {
            addCriterion("baddr is null");
            return (Criteria) this;
        }

        public Criteria andBaddrIsNotNull() {
            addCriterion("baddr is not null");
            return (Criteria) this;
        }

        public Criteria andBaddrEqualTo(String value) {
            addCriterion("baddr =", value, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrNotEqualTo(String value) {
            addCriterion("baddr <>", value, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrGreaterThan(String value) {
            addCriterion("baddr >", value, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrGreaterThanOrEqualTo(String value) {
            addCriterion("baddr >=", value, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrLessThan(String value) {
            addCriterion("baddr <", value, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrLessThanOrEqualTo(String value) {
            addCriterion("baddr <=", value, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrLike(String value) {
            addCriterion("baddr like", value, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrNotLike(String value) {
            addCriterion("baddr not like", value, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrIn(List<String> values) {
            addCriterion("baddr in", values, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrNotIn(List<String> values) {
            addCriterion("baddr not in", values, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrBetween(String value1, String value2) {
            addCriterion("baddr between", value1, value2, "baddr");
            return (Criteria) this;
        }

        public Criteria andBaddrNotBetween(String value1, String value2) {
            addCriterion("baddr not between", value1, value2, "baddr");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
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