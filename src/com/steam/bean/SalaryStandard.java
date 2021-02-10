package com.steam.bean;

public class SalaryStandard {
	private int lateStandard;		//迟到扣薪标准
	private int absentStandard;		//旷工扣薪标准
	private int overtimeStandard;	//加班加薪标准
	public int getLateStandard() {
		return lateStandard;
	}
	public void setLateStandard(int lateStandard) {
		this.lateStandard = lateStandard;
	}
	public int getAbsentStandard() {
		return absentStandard;
	}
	public void setAbsentStandard(int absentStandard) {
		this.absentStandard = absentStandard;
	}
	public int getOvertimeStandard() {
		return overtimeStandard;
	}
	public void setOvertimeStandard(int overtimeStandard) {
		this.overtimeStandard = overtimeStandard;
	}
	@Override
	public String toString() {
		return "SalaryStandard [lateStandard=" + lateStandard + ", absentStandard=" + absentStandard
				+ ", overtimeStandard=" + overtimeStandard + "]";
	}
	public SalaryStandard(int lateStandard, int absentStandard, int overtimeStandard) {
		super();
		this.lateStandard = lateStandard;
		this.absentStandard = absentStandard;
		this.overtimeStandard = overtimeStandard;
	}
	
}
