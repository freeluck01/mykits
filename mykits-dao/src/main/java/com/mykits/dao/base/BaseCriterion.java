package com.mykits.dao.base;

import java.util.List;

public class BaseCriterion {
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

	public BaseCriterion(String condition) {
		super();
		this.condition = condition;
		this.typeHandler = null;
		this.noValue = true;
	}

	public BaseCriterion(String condition, Object value, String typeHandler) {
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

	public BaseCriterion(String condition, Object value) {
		this(condition, value, null);
	}

	public BaseCriterion(String condition, Object value, Object secondValue, String typeHandler) {
		super();
		this.condition = condition;
		this.value = value;
		this.secondValue = secondValue;
		this.typeHandler = typeHandler;
		this.betweenValue = true;
	}

	public BaseCriterion(String condition, Object value, Object secondValue) {
		this(condition, value, secondValue, null);
	}
}
