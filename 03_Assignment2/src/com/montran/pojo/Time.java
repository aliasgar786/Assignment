package com.montran.pojo;

public class Time {
	private int hours;
	private int minutes;

	public void setTime(int hours,int minutes)
	{
		this.hours=hours;
		this.minutes=minutes;
	}
	
	public Time showTime()
	{
		return this;
	}
	
	public Time sum(Time time)
	{
		Time time3=new Time();
		time3.hours=time.hours+this.hours;
		time3.minutes=time.minutes+this.minutes;
		return time3;
	}
	
	
	@Override
	public String toString() {
		return "Time [hours=" + hours + ", minutes=" + minutes + "]";
	}
	
	
}
