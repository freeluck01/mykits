/*
 * Powered By caoxm
 * Since 2016 - 2016
 */

package com.mykits.client.vo;

//import com.mykits.domain.base.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @author caoxm
 * @version 1.0
 * @since 1.0
 */


public class DemoVo implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//columns START
    /**
     * id       db_column: id 
     */	
	private java.lang.Long id;
    /**
     * 用户姓名       db_column: name 
     */	
	private java.lang.String name;
    /**
     * erp账号       db_column: erp 
     */	
	private java.lang.String erp;
    /**
     * 电话号码       db_column: phone 
     */	
	private java.lang.String phone;
    /**
     * 用户邮箱       db_column: email 
     */	
	private java.lang.String email;
    /**
     * 组织机构编号       db_column: orgid 
     */	
	private java.lang.String orgid;
    /**
     * 部门名称       db_column: depart 
     */	
	private java.lang.String depart;
	//columns END

	public DemoVo(){
	}

	public DemoVo(
		java.lang.Long id
	){
		this.id = id;
	}


	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setErp(java.lang.String value) {
		this.erp = value;
	}
	
	public java.lang.String getErp() {
		return this.erp;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setOrgid(java.lang.String value) {
		this.orgid = value;
	}
	
	public java.lang.String getOrgid() {
		return this.orgid;
	}
	public void setDepart(java.lang.String value) {
		this.depart = value;
	}
	
	public java.lang.String getDepart() {
		return this.depart;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())//
			.append("Name",getName())//
			.append("Erp",getErp())//
			.append("Phone",getPhone())//
			.append("Email",getEmail())//
			.append("Orgid",getOrgid())//
			.append("Depart",getDepart())//
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())//
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DemoVo == false) return false;
		if(this == obj) return true;
		DemoVo other = (DemoVo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())//
			.isEquals();
	}
}

