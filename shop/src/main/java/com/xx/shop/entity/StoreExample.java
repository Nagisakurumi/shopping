package com.xx.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public StoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Long value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Long value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Long value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Long value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Long value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Long> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Long> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Long value1, Long value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Long value1, Long value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStorerankIdIsNull() {
            addCriterion("storerank_id is null");
            return (Criteria) this;
        }

        public Criteria andStorerankIdIsNotNull() {
            addCriterion("storerank_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorerankIdEqualTo(Integer value) {
            addCriterion("storerank_id =", value, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdNotEqualTo(Integer value) {
            addCriterion("storerank_id <>", value, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdGreaterThan(Integer value) {
            addCriterion("storerank_id >", value, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("storerank_id >=", value, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdLessThan(Integer value) {
            addCriterion("storerank_id <", value, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdLessThanOrEqualTo(Integer value) {
            addCriterion("storerank_id <=", value, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdIn(List<Integer> values) {
            addCriterion("storerank_id in", values, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdNotIn(List<Integer> values) {
            addCriterion("storerank_id not in", values, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdBetween(Integer value1, Integer value2) {
            addCriterion("storerank_id between", value1, value2, "storerankId");
            return (Criteria) this;
        }

        public Criteria andStorerankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("storerank_id not between", value1, value2, "storerankId");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDescribtionIsNull() {
            addCriterion("describtion is null");
            return (Criteria) this;
        }

        public Criteria andDescribtionIsNotNull() {
            addCriterion("describtion is not null");
            return (Criteria) this;
        }

        public Criteria andDescribtionEqualTo(String value) {
            addCriterion("describtion =", value, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionNotEqualTo(String value) {
            addCriterion("describtion <>", value, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionGreaterThan(String value) {
            addCriterion("describtion >", value, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionGreaterThanOrEqualTo(String value) {
            addCriterion("describtion >=", value, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionLessThan(String value) {
            addCriterion("describtion <", value, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionLessThanOrEqualTo(String value) {
            addCriterion("describtion <=", value, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionLike(String value) {
            addCriterion("describtion like", value, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionNotLike(String value) {
            addCriterion("describtion not like", value, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionIn(List<String> values) {
            addCriterion("describtion in", values, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionNotIn(List<String> values) {
            addCriterion("describtion not in", values, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionBetween(String value1, String value2) {
            addCriterion("describtion between", value1, value2, "describtion");
            return (Criteria) this;
        }

        public Criteria andDescribtionNotBetween(String value1, String value2) {
            addCriterion("describtion not between", value1, value2, "describtion");
            return (Criteria) this;
        }

        public Criteria andHonestiesIsNull() {
            addCriterion("honesties is null");
            return (Criteria) this;
        }

        public Criteria andHonestiesIsNotNull() {
            addCriterion("honesties is not null");
            return (Criteria) this;
        }

        public Criteria andHonestiesEqualTo(Integer value) {
            addCriterion("honesties =", value, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesNotEqualTo(Integer value) {
            addCriterion("honesties <>", value, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesGreaterThan(Integer value) {
            addCriterion("honesties >", value, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesGreaterThanOrEqualTo(Integer value) {
            addCriterion("honesties >=", value, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesLessThan(Integer value) {
            addCriterion("honesties <", value, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesLessThanOrEqualTo(Integer value) {
            addCriterion("honesties <=", value, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesIn(List<Integer> values) {
            addCriterion("honesties in", values, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesNotIn(List<Integer> values) {
            addCriterion("honesties not in", values, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesBetween(Integer value1, Integer value2) {
            addCriterion("honesties between", value1, value2, "honesties");
            return (Criteria) this;
        }

        public Criteria andHonestiesNotBetween(Integer value1, Integer value2) {
            addCriterion("honesties not between", value1, value2, "honesties");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_store
     *
     * @mbg.generated do_not_delete_during_merge Thu Mar 15 15:46:48 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
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