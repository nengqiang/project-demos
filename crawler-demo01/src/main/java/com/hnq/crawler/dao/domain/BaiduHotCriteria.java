package com.hnq.crawler.dao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaiduHotCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaiduHotCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleLine1IsNull() {
            addCriterion("title_line1 is null");
            return (Criteria) this;
        }

        public Criteria andTitleLine1IsNotNull() {
            addCriterion("title_line1 is not null");
            return (Criteria) this;
        }

        public Criteria andTitleLine1EqualTo(String value) {
            addCriterion("title_line1 =", value, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1NotEqualTo(String value) {
            addCriterion("title_line1 <>", value, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1GreaterThan(String value) {
            addCriterion("title_line1 >", value, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1GreaterThanOrEqualTo(String value) {
            addCriterion("title_line1 >=", value, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1LessThan(String value) {
            addCriterion("title_line1 <", value, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1LessThanOrEqualTo(String value) {
            addCriterion("title_line1 <=", value, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1Like(String value) {
            addCriterion("title_line1 like", value, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1NotLike(String value) {
            addCriterion("title_line1 not like", value, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1In(List<String> values) {
            addCriterion("title_line1 in", values, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1NotIn(List<String> values) {
            addCriterion("title_line1 not in", values, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1Between(String value1, String value2) {
            addCriterion("title_line1 between", value1, value2, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine1NotBetween(String value1, String value2) {
            addCriterion("title_line1 not between", value1, value2, "titleLine1");
            return (Criteria) this;
        }

        public Criteria andTitleLine2IsNull() {
            addCriterion("title_line2 is null");
            return (Criteria) this;
        }

        public Criteria andTitleLine2IsNotNull() {
            addCriterion("title_line2 is not null");
            return (Criteria) this;
        }

        public Criteria andTitleLine2EqualTo(Integer value) {
            addCriterion("title_line2 =", value, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2NotEqualTo(Integer value) {
            addCriterion("title_line2 <>", value, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2GreaterThan(Integer value) {
            addCriterion("title_line2 >", value, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2GreaterThanOrEqualTo(Integer value) {
            addCriterion("title_line2 >=", value, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2LessThan(Integer value) {
            addCriterion("title_line2 <", value, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2LessThanOrEqualTo(Integer value) {
            addCriterion("title_line2 <=", value, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2In(List<Integer> values) {
            addCriterion("title_line2 in", values, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2NotIn(List<Integer> values) {
            addCriterion("title_line2 not in", values, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2Between(Integer value1, Integer value2) {
            addCriterion("title_line2 between", value1, value2, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine2NotBetween(Integer value1, Integer value2) {
            addCriterion("title_line2 not between", value1, value2, "titleLine2");
            return (Criteria) this;
        }

        public Criteria andTitleLine3IsNull() {
            addCriterion("title_line3 is null");
            return (Criteria) this;
        }

        public Criteria andTitleLine3IsNotNull() {
            addCriterion("title_line3 is not null");
            return (Criteria) this;
        }

        public Criteria andTitleLine3EqualTo(String value) {
            addCriterion("title_line3 =", value, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3NotEqualTo(String value) {
            addCriterion("title_line3 <>", value, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3GreaterThan(String value) {
            addCriterion("title_line3 >", value, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3GreaterThanOrEqualTo(String value) {
            addCriterion("title_line3 >=", value, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3LessThan(String value) {
            addCriterion("title_line3 <", value, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3LessThanOrEqualTo(String value) {
            addCriterion("title_line3 <=", value, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3Like(String value) {
            addCriterion("title_line3 like", value, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3NotLike(String value) {
            addCriterion("title_line3 not like", value, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3In(List<String> values) {
            addCriterion("title_line3 in", values, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3NotIn(List<String> values) {
            addCriterion("title_line3 not in", values, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3Between(String value1, String value2) {
            addCriterion("title_line3 between", value1, value2, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine3NotBetween(String value1, String value2) {
            addCriterion("title_line3 not between", value1, value2, "titleLine3");
            return (Criteria) this;
        }

        public Criteria andTitleLine4IsNull() {
            addCriterion("title_line4 is null");
            return (Criteria) this;
        }

        public Criteria andTitleLine4IsNotNull() {
            addCriterion("title_line4 is not null");
            return (Criteria) this;
        }

        public Criteria andTitleLine4EqualTo(String value) {
            addCriterion("title_line4 =", value, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4NotEqualTo(String value) {
            addCriterion("title_line4 <>", value, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4GreaterThan(String value) {
            addCriterion("title_line4 >", value, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4GreaterThanOrEqualTo(String value) {
            addCriterion("title_line4 >=", value, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4LessThan(String value) {
            addCriterion("title_line4 <", value, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4LessThanOrEqualTo(String value) {
            addCriterion("title_line4 <=", value, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4Like(String value) {
            addCriterion("title_line4 like", value, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4NotLike(String value) {
            addCriterion("title_line4 not like", value, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4In(List<String> values) {
            addCriterion("title_line4 in", values, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4NotIn(List<String> values) {
            addCriterion("title_line4 not in", values, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4Between(String value1, String value2) {
            addCriterion("title_line4 between", value1, value2, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andTitleLine4NotBetween(String value1, String value2) {
            addCriterion("title_line4 not between", value1, value2, "titleLine4");
            return (Criteria) this;
        }

        public Criteria andHotStockName1IsNull() {
            addCriterion("hot_stock_name_1 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockName1IsNotNull() {
            addCriterion("hot_stock_name_1 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockName1EqualTo(String value) {
            addCriterion("hot_stock_name_1 =", value, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1NotEqualTo(String value) {
            addCriterion("hot_stock_name_1 <>", value, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1GreaterThan(String value) {
            addCriterion("hot_stock_name_1 >", value, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_name_1 >=", value, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1LessThan(String value) {
            addCriterion("hot_stock_name_1 <", value, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_name_1 <=", value, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1Like(String value) {
            addCriterion("hot_stock_name_1 like", value, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1NotLike(String value) {
            addCriterion("hot_stock_name_1 not like", value, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1In(List<String> values) {
            addCriterion("hot_stock_name_1 in", values, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1NotIn(List<String> values) {
            addCriterion("hot_stock_name_1 not in", values, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1Between(String value1, String value2) {
            addCriterion("hot_stock_name_1 between", value1, value2, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockName1NotBetween(String value1, String value2) {
            addCriterion("hot_stock_name_1 not between", value1, value2, "hotStockName1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1IsNull() {
            addCriterion("hot_stock_code_1 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1IsNotNull() {
            addCriterion("hot_stock_code_1 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1EqualTo(String value) {
            addCriterion("hot_stock_code_1 =", value, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1NotEqualTo(String value) {
            addCriterion("hot_stock_code_1 <>", value, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1GreaterThan(String value) {
            addCriterion("hot_stock_code_1 >", value, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_code_1 >=", value, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1LessThan(String value) {
            addCriterion("hot_stock_code_1 <", value, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_code_1 <=", value, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1Like(String value) {
            addCriterion("hot_stock_code_1 like", value, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1NotLike(String value) {
            addCriterion("hot_stock_code_1 not like", value, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1In(List<String> values) {
            addCriterion("hot_stock_code_1 in", values, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1NotIn(List<String> values) {
            addCriterion("hot_stock_code_1 not in", values, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1Between(String value1, String value2) {
            addCriterion("hot_stock_code_1 between", value1, value2, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockCode1NotBetween(String value1, String value2) {
            addCriterion("hot_stock_code_1 not between", value1, value2, "hotStockCode1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1IsNull() {
            addCriterion("hot_stock_price_1 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1IsNotNull() {
            addCriterion("hot_stock_price_1 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1EqualTo(Double value) {
            addCriterion("hot_stock_price_1 =", value, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1NotEqualTo(Double value) {
            addCriterion("hot_stock_price_1 <>", value, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1GreaterThan(Double value) {
            addCriterion("hot_stock_price_1 >", value, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1GreaterThanOrEqualTo(Double value) {
            addCriterion("hot_stock_price_1 >=", value, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1LessThan(Double value) {
            addCriterion("hot_stock_price_1 <", value, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1LessThanOrEqualTo(Double value) {
            addCriterion("hot_stock_price_1 <=", value, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1In(List<Double> values) {
            addCriterion("hot_stock_price_1 in", values, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1NotIn(List<Double> values) {
            addCriterion("hot_stock_price_1 not in", values, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1Between(Double value1, Double value2) {
            addCriterion("hot_stock_price_1 between", value1, value2, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice1NotBetween(Double value1, Double value2) {
            addCriterion("hot_stock_price_1 not between", value1, value2, "hotStockPrice1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1IsNull() {
            addCriterion("hot_stock_increment_1 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1IsNotNull() {
            addCriterion("hot_stock_increment_1 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1EqualTo(String value) {
            addCriterion("hot_stock_increment_1 =", value, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1NotEqualTo(String value) {
            addCriterion("hot_stock_increment_1 <>", value, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1GreaterThan(String value) {
            addCriterion("hot_stock_increment_1 >", value, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_increment_1 >=", value, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1LessThan(String value) {
            addCriterion("hot_stock_increment_1 <", value, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_increment_1 <=", value, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1Like(String value) {
            addCriterion("hot_stock_increment_1 like", value, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1NotLike(String value) {
            addCriterion("hot_stock_increment_1 not like", value, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1In(List<String> values) {
            addCriterion("hot_stock_increment_1 in", values, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1NotIn(List<String> values) {
            addCriterion("hot_stock_increment_1 not in", values, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1Between(String value1, String value2) {
            addCriterion("hot_stock_increment_1 between", value1, value2, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement1NotBetween(String value1, String value2) {
            addCriterion("hot_stock_increment_1 not between", value1, value2, "hotStockIncrement1");
            return (Criteria) this;
        }

        public Criteria andHotStockName2IsNull() {
            addCriterion("hot_stock_name_2 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockName2IsNotNull() {
            addCriterion("hot_stock_name_2 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockName2EqualTo(String value) {
            addCriterion("hot_stock_name_2 =", value, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2NotEqualTo(String value) {
            addCriterion("hot_stock_name_2 <>", value, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2GreaterThan(String value) {
            addCriterion("hot_stock_name_2 >", value, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_name_2 >=", value, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2LessThan(String value) {
            addCriterion("hot_stock_name_2 <", value, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_name_2 <=", value, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2Like(String value) {
            addCriterion("hot_stock_name_2 like", value, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2NotLike(String value) {
            addCriterion("hot_stock_name_2 not like", value, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2In(List<String> values) {
            addCriterion("hot_stock_name_2 in", values, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2NotIn(List<String> values) {
            addCriterion("hot_stock_name_2 not in", values, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2Between(String value1, String value2) {
            addCriterion("hot_stock_name_2 between", value1, value2, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockName2NotBetween(String value1, String value2) {
            addCriterion("hot_stock_name_2 not between", value1, value2, "hotStockName2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2IsNull() {
            addCriterion("hot_stock_code_2 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2IsNotNull() {
            addCriterion("hot_stock_code_2 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2EqualTo(String value) {
            addCriterion("hot_stock_code_2 =", value, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2NotEqualTo(String value) {
            addCriterion("hot_stock_code_2 <>", value, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2GreaterThan(String value) {
            addCriterion("hot_stock_code_2 >", value, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_code_2 >=", value, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2LessThan(String value) {
            addCriterion("hot_stock_code_2 <", value, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_code_2 <=", value, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2Like(String value) {
            addCriterion("hot_stock_code_2 like", value, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2NotLike(String value) {
            addCriterion("hot_stock_code_2 not like", value, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2In(List<String> values) {
            addCriterion("hot_stock_code_2 in", values, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2NotIn(List<String> values) {
            addCriterion("hot_stock_code_2 not in", values, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2Between(String value1, String value2) {
            addCriterion("hot_stock_code_2 between", value1, value2, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockCode2NotBetween(String value1, String value2) {
            addCriterion("hot_stock_code_2 not between", value1, value2, "hotStockCode2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2IsNull() {
            addCriterion("hot_stock_price_2 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2IsNotNull() {
            addCriterion("hot_stock_price_2 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2EqualTo(Double value) {
            addCriterion("hot_stock_price_2 =", value, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2NotEqualTo(Double value) {
            addCriterion("hot_stock_price_2 <>", value, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2GreaterThan(Double value) {
            addCriterion("hot_stock_price_2 >", value, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2GreaterThanOrEqualTo(Double value) {
            addCriterion("hot_stock_price_2 >=", value, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2LessThan(Double value) {
            addCriterion("hot_stock_price_2 <", value, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2LessThanOrEqualTo(Double value) {
            addCriterion("hot_stock_price_2 <=", value, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2In(List<Double> values) {
            addCriterion("hot_stock_price_2 in", values, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2NotIn(List<Double> values) {
            addCriterion("hot_stock_price_2 not in", values, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2Between(Double value1, Double value2) {
            addCriterion("hot_stock_price_2 between", value1, value2, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice2NotBetween(Double value1, Double value2) {
            addCriterion("hot_stock_price_2 not between", value1, value2, "hotStockPrice2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2IsNull() {
            addCriterion("hot_stock_increment_2 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2IsNotNull() {
            addCriterion("hot_stock_increment_2 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2EqualTo(String value) {
            addCriterion("hot_stock_increment_2 =", value, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2NotEqualTo(String value) {
            addCriterion("hot_stock_increment_2 <>", value, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2GreaterThan(String value) {
            addCriterion("hot_stock_increment_2 >", value, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_increment_2 >=", value, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2LessThan(String value) {
            addCriterion("hot_stock_increment_2 <", value, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_increment_2 <=", value, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2Like(String value) {
            addCriterion("hot_stock_increment_2 like", value, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2NotLike(String value) {
            addCriterion("hot_stock_increment_2 not like", value, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2In(List<String> values) {
            addCriterion("hot_stock_increment_2 in", values, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2NotIn(List<String> values) {
            addCriterion("hot_stock_increment_2 not in", values, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2Between(String value1, String value2) {
            addCriterion("hot_stock_increment_2 between", value1, value2, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement2NotBetween(String value1, String value2) {
            addCriterion("hot_stock_increment_2 not between", value1, value2, "hotStockIncrement2");
            return (Criteria) this;
        }

        public Criteria andHotStockName3IsNull() {
            addCriterion("hot_stock_name_3 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockName3IsNotNull() {
            addCriterion("hot_stock_name_3 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockName3EqualTo(String value) {
            addCriterion("hot_stock_name_3 =", value, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3NotEqualTo(String value) {
            addCriterion("hot_stock_name_3 <>", value, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3GreaterThan(String value) {
            addCriterion("hot_stock_name_3 >", value, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_name_3 >=", value, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3LessThan(String value) {
            addCriterion("hot_stock_name_3 <", value, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_name_3 <=", value, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3Like(String value) {
            addCriterion("hot_stock_name_3 like", value, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3NotLike(String value) {
            addCriterion("hot_stock_name_3 not like", value, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3In(List<String> values) {
            addCriterion("hot_stock_name_3 in", values, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3NotIn(List<String> values) {
            addCriterion("hot_stock_name_3 not in", values, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3Between(String value1, String value2) {
            addCriterion("hot_stock_name_3 between", value1, value2, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockName3NotBetween(String value1, String value2) {
            addCriterion("hot_stock_name_3 not between", value1, value2, "hotStockName3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3IsNull() {
            addCriterion("hot_stock_code_3 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3IsNotNull() {
            addCriterion("hot_stock_code_3 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3EqualTo(String value) {
            addCriterion("hot_stock_code_3 =", value, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3NotEqualTo(String value) {
            addCriterion("hot_stock_code_3 <>", value, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3GreaterThan(String value) {
            addCriterion("hot_stock_code_3 >", value, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_code_3 >=", value, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3LessThan(String value) {
            addCriterion("hot_stock_code_3 <", value, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_code_3 <=", value, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3Like(String value) {
            addCriterion("hot_stock_code_3 like", value, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3NotLike(String value) {
            addCriterion("hot_stock_code_3 not like", value, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3In(List<String> values) {
            addCriterion("hot_stock_code_3 in", values, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3NotIn(List<String> values) {
            addCriterion("hot_stock_code_3 not in", values, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3Between(String value1, String value2) {
            addCriterion("hot_stock_code_3 between", value1, value2, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockCode3NotBetween(String value1, String value2) {
            addCriterion("hot_stock_code_3 not between", value1, value2, "hotStockCode3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3IsNull() {
            addCriterion("hot_stock_price_3 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3IsNotNull() {
            addCriterion("hot_stock_price_3 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3EqualTo(Double value) {
            addCriterion("hot_stock_price_3 =", value, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3NotEqualTo(Double value) {
            addCriterion("hot_stock_price_3 <>", value, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3GreaterThan(Double value) {
            addCriterion("hot_stock_price_3 >", value, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3GreaterThanOrEqualTo(Double value) {
            addCriterion("hot_stock_price_3 >=", value, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3LessThan(Double value) {
            addCriterion("hot_stock_price_3 <", value, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3LessThanOrEqualTo(Double value) {
            addCriterion("hot_stock_price_3 <=", value, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3In(List<Double> values) {
            addCriterion("hot_stock_price_3 in", values, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3NotIn(List<Double> values) {
            addCriterion("hot_stock_price_3 not in", values, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3Between(Double value1, Double value2) {
            addCriterion("hot_stock_price_3 between", value1, value2, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockPrice3NotBetween(Double value1, Double value2) {
            addCriterion("hot_stock_price_3 not between", value1, value2, "hotStockPrice3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3IsNull() {
            addCriterion("hot_stock_increment_3 is null");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3IsNotNull() {
            addCriterion("hot_stock_increment_3 is not null");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3EqualTo(String value) {
            addCriterion("hot_stock_increment_3 =", value, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3NotEqualTo(String value) {
            addCriterion("hot_stock_increment_3 <>", value, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3GreaterThan(String value) {
            addCriterion("hot_stock_increment_3 >", value, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3GreaterThanOrEqualTo(String value) {
            addCriterion("hot_stock_increment_3 >=", value, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3LessThan(String value) {
            addCriterion("hot_stock_increment_3 <", value, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3LessThanOrEqualTo(String value) {
            addCriterion("hot_stock_increment_3 <=", value, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3Like(String value) {
            addCriterion("hot_stock_increment_3 like", value, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3NotLike(String value) {
            addCriterion("hot_stock_increment_3 not like", value, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3In(List<String> values) {
            addCriterion("hot_stock_increment_3 in", values, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3NotIn(List<String> values) {
            addCriterion("hot_stock_increment_3 not in", values, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3Between(String value1, String value2) {
            addCriterion("hot_stock_increment_3 between", value1, value2, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andHotStockIncrement3NotBetween(String value1, String value2) {
            addCriterion("hot_stock_increment_3 not between", value1, value2, "hotStockIncrement3");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNull() {
            addCriterion("last_update_date is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNotNull() {
            addCriterion("last_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateEqualTo(Date value) {
            addCriterion("last_update_date =", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotEqualTo(Date value) {
            addCriterion("last_update_date <>", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThan(Date value) {
            addCriterion("last_update_date >", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_date >=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThan(Date value) {
            addCriterion("last_update_date <", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("last_update_date <=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIn(List<Date> values) {
            addCriterion("last_update_date in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotIn(List<Date> values) {
            addCriterion("last_update_date not in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateBetween(Date value1, Date value2) {
            addCriterion("last_update_date between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("last_update_date not between", value1, value2, "lastUpdateDate");
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