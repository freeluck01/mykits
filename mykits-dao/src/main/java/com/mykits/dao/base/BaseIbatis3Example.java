package com.mykits.dao.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;

public class BaseIbatis3Example {

    protected String orderByClause;

    protected boolean distinct;

    protected List oredCriteria;
    
	protected RowBounds rowBound;

    public BaseIbatis3Example() {
        oredCriteria = new ArrayList();
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

    public List getOredCriteria() {
        return oredCriteria;
    }

    public void or(Object criteria) {
        oredCriteria.add(criteria);
    }

	public <T> T or(Class<T> clszz) {
        T criteria = createCriteriaInternal(clszz);
        oredCriteria.add(criteria);
        return criteria;
    }


	public static <T> T criteria(Class<T> clszz) {
		return new BaseIbatis3Example().createCriteria(clszz);
	}

	public <T> T createCriteria(Class<T> clszz) {
		T criteria = createCriteriaInternal(clszz);
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	public <T> T createCriteriaInternal(Class<T> clszz) {
		T criteria = BeanUtils.instantiateClass(clszz);
		if (criteria != null && criteria instanceof BaseIbatis3Criteria) {
			((BaseIbatis3Criteria) criteria).setExample(this);
		}
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
	}
	
	public BaseIbatis3Example setRowBound(int offset, int limit) {
		this.rowBound = new RowBounds(offset, limit);
		return this;
	}
}
