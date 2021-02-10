package com.steam.bean;

/**
 * 职工实体类
 * 
 */
public class Staff {
	private String id;	//职工工号
	private String password;	//职工的登陆密码
	private String power;		//职工拥有的权限
	private String name;		//职工的姓名
	private String sex;		//职工的性别
	private int age;		//职工的年龄
	private String position;	//职工的职位
	private String telephone;	//职工的电话号码
	private int baseWages;		//职工的基本薪资
	private int meritWages;		//职工的绩效薪资
	private int punishingWages;		//职工的扣罚薪资
	private int totalWages;			//职工的总薪资
	private String department;		//职工所属部门
	private String status;			//职工的帐号状态（0为禁用，1为启用）
	private String salaryAudit;		//职工薪资审查状态（0为未审查，1为审查成功，2为审查错误）
	private int weekendovertime;	//周末加班时间
	private int festivalovertime;	//假期加班时间
	private int saleCommission;		//提成
	private int festivalWages;		//福利奖金
	private int yearendWages;		//年终奖金
	private int lateCount;			//迟到次数
	private int leaveCount;			//请假次数
	private int absentCount;		//旷工次数
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getBaseWages() {
		return baseWages;
	}
	public void setBaseWages(int baseWages) {
		this.baseWages = baseWages;
	}
	public int getMeritWages() {
		return meritWages;
	}
	public void setMeritWages(int meritWages) {
		this.meritWages = meritWages;
	}
	public int getPunishingWages() {
		return punishingWages;
	}
	public void setPunishingWages(int punishingWages) {
		this.punishingWages = punishingWages;
	}
	public int getTotalWages() {
		return totalWages;
	}
	public void setTotalWages(int totalWages) {
		this.totalWages = totalWages;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSalaryAudit() {
		return salaryAudit;
	}
	public void setSalaryAudit(String salaryAudit) {
		this.salaryAudit = salaryAudit;
	}
	public int getWeekendovertime() {
		return weekendovertime;
	}
	public void setWeekendovertime(int weekendovertime) {
		this.weekendovertime = weekendovertime;
	}
	public int getFestivalovertime() {
		return festivalovertime;
	}
	public void setFestivalovertime(int festivalovertime) {
		this.festivalovertime = festivalovertime;
	}
	public int getSaleCommission() {
		return saleCommission;
	}
	public void setSaleCommission(int saleCommission) {
		this.saleCommission = saleCommission;
	}
	public int getFestivalWages() {
		return festivalWages;
	}
	public void setFestivalWages(int festivalWages) {
		this.festivalWages = festivalWages;
	}
	public int getYearendWages() {
		return yearendWages;
	}
	public void setYearendWages(int yearendWages) {
		this.yearendWages = yearendWages;
	}
	public int getLateCount() {
		return lateCount;
	}
	public void setLateCount(int lateCount) {
		this.lateCount = lateCount;
	}
	public int getLeaveCount() {
		return leaveCount;
	}
	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}
	public int getAbsentCount() {
		return absentCount;
	}
	public void setAbsentCount(int absentCount) {
		this.absentCount = absentCount;
	}
	public Staff(String id, String password, String power, String name, String sex, int age, String position,
			String telephone, int baseWages, int meritWages, int punishingWages, int totalWages, String department,
			String status, String salaryAudit, int weekendovertime, int festivalovertime, int saleCommission,
			int festivalWages, int yearendWages, int lateCount, int leaveCount, int absentCount) {
		super();
		this.id = id;
		this.password = password;
		this.power = power;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.position = position;
		this.telephone = telephone;
		this.baseWages = baseWages;
		this.meritWages = meritWages;
		this.punishingWages = punishingWages;
		this.totalWages = totalWages;
		this.department = department;
		this.status = status;
		this.salaryAudit = salaryAudit;
		this.weekendovertime = weekendovertime;
		this.festivalovertime = festivalovertime;
		this.saleCommission = saleCommission;
		this.festivalWages = festivalWages;
		this.yearendWages = yearendWages;
		this.lateCount = lateCount;
		this.leaveCount = leaveCount;
		this.absentCount = absentCount;
	}
	public Staff() {
		super();
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", password=" + password + ", power=" + power + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", position=" + position + ", telephone=" + telephone + ", baseWages=" + baseWages
				+ ", meritWages=" + meritWages + ", punishingWages=" + punishingWages + ", totalWages=" + totalWages
				+ ", department=" + department + ", status=" + status + ", salaryAudit=" + salaryAudit
				+ ", weekendovertime=" + weekendovertime + ", festivalovertime=" + festivalovertime
				+ ", saleCommission=" + saleCommission + ", festivalWages=" + festivalWages + ", yearendWages="
				+ yearendWages + ", lateCount=" + lateCount + ", leaveCount=" + leaveCount + ", absentCount="
				+ absentCount + ", getId()=" + getId() + ", getPassword()=" + getPassword() + ", getPower()="
				+ getPower() + ", getName()=" + getName() + ", getSex()=" + getSex() + ", getAge()=" + getAge()
				+ ", getPosition()=" + getPosition() + ", getTelephone()=" + getTelephone() + ", getBaseWages()="
				+ getBaseWages() + ", getMeritWages()=" + getMeritWages() + ", getPunishingWages()="
				+ getPunishingWages() + ", getTotalWages()=" + getTotalWages() + ", getDepartment()=" + getDepartment()
				+ ", getStatus()=" + getStatus() + ", getSalaryAudit()=" + getSalaryAudit() + ", getWeekendovertime()="
				+ getWeekendovertime() + ", getFestivalovertime()=" + getFestivalovertime() + ", getSaleCommission()="
				+ getSaleCommission() + ", getFestivalWages()=" + getFestivalWages() + ", getYearendWages()="
				+ getYearendWages() + ", getLateCount()=" + getLateCount() + ", getLeaveCount()=" + getLeaveCount()
				+ ", getAbsentCount()=" + getAbsentCount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}