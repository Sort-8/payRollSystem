package com.steam.bean;

/**
 * 部门实体类
 * @author 庞海
 *
 */
public class Department {
	private String name; //部门名称
	private String changedtime; //最近更改时间
	private String operator; //更改者
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChangedtime() {
		return changedtime;
	}
	public void setChangedtime(String changedtime) {
		this.changedtime = changedtime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Department(String name, String changedtime, String operator) {
		super();
		this.name = name;
		this.changedtime = changedtime;
		this.operator = operator;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", changedtime=" + changedtime + ", operator=" + operator + ", getName()="
				+ getName() + ", getChangedtime()=" + getChangedtime() + ", getOperator()=" + getOperator()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
