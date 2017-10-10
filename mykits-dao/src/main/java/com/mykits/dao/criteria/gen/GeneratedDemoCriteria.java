/*
 * Powered By caoxm
 * Since 2016 - 2016
 */

package com.mykits.dao.criteria.gen;

import java.util.List;

import com.mykits.dao.base.BaseIbatis3Criteria;

/**
 * @author caoxm
 * @version 1.0
 * @since 1.0
 */


public abstract class GeneratedDemoCriteria extends BaseIbatis3Criteria{
	public GeneratedDemoCriteria andIdIsNull() {
	    addCriterion("id is null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdIsNotNull() {
	    addCriterion("id is not null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdEqualTo(java.lang.Long value) {
	    addCriterion("id =", value, "id");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdNotEqualTo(java.lang.Long value) {
	    addCriterion("id <>", value, "id");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdIn(List<java.lang.Long> values) {
	    addCriterion("id in", values, "id");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdNotIn(List<java.lang.Long> values) {
	    addCriterion("id not in", values, "id");
	    return (GeneratedDemoCriteria) this;
	}
        
	public GeneratedDemoCriteria andIdBetween(java.lang.Long value1, java.lang.Long value2) {
	    addCriterion("id between", value1, value2, "id");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
	    addCriterion("id not between", value1, value2, "id");
	    return (GeneratedDemoCriteria) this;
	}

	public GeneratedDemoCriteria andIdGreaterThan(java.lang.Long value) {
	    addCriterion("id >", value, "id");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdGreaterThanOrEqualTo(java.lang.Long value) {
	    addCriterion("id >=", value, "id");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdLessThan(java.lang.Long value) {
	    addCriterion("id <", value, "id");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andIdLessThanOrEqualTo(java.lang.Long value) {
	    addCriterion("id <=", value, "id");
	    return (GeneratedDemoCriteria) this;
	}

	public GeneratedDemoCriteria andNameIsNull() {
	    addCriterion("name is null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andNameIsNotNull() {
	    addCriterion("name is not null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andNameEqualTo(java.lang.String value) {
	    addCriterion("name =", value, "name");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andNameNotEqualTo(java.lang.String value) {
	    addCriterion("name <>", value, "name");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andNameIn(List<java.lang.String> values) {
	    addCriterion("name in", values, "name");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andNameNotIn(List<java.lang.String> values) {
	    addCriterion("name not in", values, "name");
	    return (GeneratedDemoCriteria) this;
	}
        
	public GeneratedDemoCriteria andNameLike(java.lang.String value) {
		if(value!=null && !value.contains("%")) {
			return andNameEqualTo(value);
		}
	    addCriterion("name like", value, "name");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andErpIsNull() {
	    addCriterion("erp is null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andErpIsNotNull() {
	    addCriterion("erp is not null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andErpEqualTo(java.lang.String value) {
	    addCriterion("erp =", value, "erp");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andErpNotEqualTo(java.lang.String value) {
	    addCriterion("erp <>", value, "erp");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andErpIn(List<java.lang.String> values) {
	    addCriterion("erp in", values, "erp");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andErpNotIn(List<java.lang.String> values) {
	    addCriterion("erp not in", values, "erp");
	    return (GeneratedDemoCriteria) this;
	}
        
	public GeneratedDemoCriteria andErpLike(java.lang.String value) {
		if(value!=null && !value.contains("%")) {
			return andErpEqualTo(value);
		}
	    addCriterion("erp like", value, "erp");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andPhoneIsNull() {
	    addCriterion("phone is null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andPhoneIsNotNull() {
	    addCriterion("phone is not null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andPhoneEqualTo(java.lang.String value) {
	    addCriterion("phone =", value, "phone");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andPhoneNotEqualTo(java.lang.String value) {
	    addCriterion("phone <>", value, "phone");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andPhoneIn(List<java.lang.String> values) {
	    addCriterion("phone in", values, "phone");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andPhoneNotIn(List<java.lang.String> values) {
	    addCriterion("phone not in", values, "phone");
	    return (GeneratedDemoCriteria) this;
	}
        
	public GeneratedDemoCriteria andPhoneLike(java.lang.String value) {
		if(value!=null && !value.contains("%")) {
			return andPhoneEqualTo(value);
		}
	    addCriterion("phone like", value, "phone");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andEmailIsNull() {
	    addCriterion("email is null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andEmailIsNotNull() {
	    addCriterion("email is not null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andEmailEqualTo(java.lang.String value) {
	    addCriterion("email =", value, "email");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andEmailNotEqualTo(java.lang.String value) {
	    addCriterion("email <>", value, "email");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andEmailIn(List<java.lang.String> values) {
	    addCriterion("email in", values, "email");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andEmailNotIn(List<java.lang.String> values) {
	    addCriterion("email not in", values, "email");
	    return (GeneratedDemoCriteria) this;
	}
        
	public GeneratedDemoCriteria andEmailLike(java.lang.String value) {
		if(value!=null && !value.contains("%")) {
			return andEmailEqualTo(value);
		}
	    addCriterion("email like", value, "email");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andOrgidIsNull() {
	    addCriterion("orgid is null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andOrgidIsNotNull() {
	    addCriterion("orgid is not null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andOrgidEqualTo(java.lang.String value) {
	    addCriterion("orgid =", value, "orgid");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andOrgidNotEqualTo(java.lang.String value) {
	    addCriterion("orgid <>", value, "orgid");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andOrgidIn(List<java.lang.String> values) {
	    addCriterion("orgid in", values, "orgid");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andOrgidNotIn(List<java.lang.String> values) {
	    addCriterion("orgid not in", values, "orgid");
	    return (GeneratedDemoCriteria) this;
	}
        
	public GeneratedDemoCriteria andOrgidLike(java.lang.String value) {
		if(value!=null && !value.contains("%")) {
			return andOrgidEqualTo(value);
		}
	    addCriterion("orgid like", value, "orgid");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andDepartIsNull() {
	    addCriterion("depart is null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andDepartIsNotNull() {
	    addCriterion("depart is not null");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andDepartEqualTo(java.lang.String value) {
	    addCriterion("depart =", value, "depart");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andDepartNotEqualTo(java.lang.String value) {
	    addCriterion("depart <>", value, "depart");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andDepartIn(List<java.lang.String> values) {
	    addCriterion("depart in", values, "depart");
	    return (GeneratedDemoCriteria) this;
	}
	
	public GeneratedDemoCriteria andDepartNotIn(List<java.lang.String> values) {
	    addCriterion("depart not in", values, "depart");
	    return (GeneratedDemoCriteria) this;
	}
        
	public GeneratedDemoCriteria andDepartLike(java.lang.String value) {
		if(value!=null && !value.contains("%")) {
			return andDepartEqualTo(value);
		}
	    addCriterion("depart like", value, "depart");
	    return (GeneratedDemoCriteria) this;
	}
	
}