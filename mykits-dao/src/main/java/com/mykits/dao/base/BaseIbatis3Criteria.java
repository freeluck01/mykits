package com.mykits.dao.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

public class BaseIbatis3Criteria {
	protected static Pattern $EXPR_PTN = Pattern.compile("\\$\\{([^\\}]*)\\}");
	private BaseIbatis3Example example;
	/**
	 * 表达式集合
	 */
	protected List<BaseCriterion> criteria = new ArrayList<BaseCriterion>();

	public BaseIbatis3Example getExample() {
		return example;
	}

	public void setExample(BaseIbatis3Example example) {
		this.example = example;
	}

	public boolean isValid() {
		return criteria.size() > 0;
	}

	public List<BaseCriterion> getAllCriteria() {
		return criteria;
	}

	public List<BaseCriterion> getCriteria() {
		return criteria;
	}

	protected void addCriterion(String condition) {
		if (condition == null) {
			throw new RuntimeException("Value for condition cannot be null");
		}
		criteria.add(new BaseCriterion(condition));
	}

	protected void addCriterion(String condition, Object value, String property) {
		if (value == null) {
			throw new RuntimeException("Value for " + property + " cannot be null");
		}
		criteria.add(new BaseCriterion(condition, value));
	}

	protected void addCriterion(String condition, Object value1, Object value2, String property) {
		if (value1 == null || value2 == null) {
			throw new RuntimeException("Between values for " + property + " cannot be null");
		}
		criteria.add(new BaseCriterion(condition, value1, value2));
	}

	protected void addCriterionExprs(Object bean, String... args) {
		if (bean == null)
			return;
		// 将bean转换成map备用
		Map beanmap = null;
		try {
			beanmap = PropertyUtils.describe(bean);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// 逐行解析表达式
		for (int i = 0; args != null && i != args.length; i++) {
			String line = args[i];
			// 查找$ {}表达式
			Matcher mch = $EXPR_PTN.matcher(line);
			// 本行解析出的criteria
			List<BaseCriterion> lineCriteria = new ArrayList<BaseCriterion>();
			// 不做解释了
			int laststart = 0;
			while (mch.find()) {
				// $ {表达式}
				String key = mch.group(1).trim();
				// 表达式对应的值
				Object val = beanmap.get(key);
				// 当值不为空时
				if (val != null && !StringUtils.isEmpty(val.toString())) {
					// 解析sql表达式 如: id=
					String criter = line.substring(laststart, mch.start());
					laststart = mch.end();
					if (val instanceof String && criter.toLowerCase().contains("like")) {
						val = StringUtils.join(new Object[] { '%', val, '%' });
					}
					lineCriteria.add(new BaseCriterion(criter, val));
				} else {
					// 当此行有一个值为空则不对本行进行处理
					lineCriteria.clear();
					break;
				}
			}
			if (lineCriteria.size() != 0)
				this.criteria.addAll(lineCriteria);
		}
	}

}
