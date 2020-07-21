package com.montran.main;

import com.montran.pojo.Time;

public class TimeMain {

	public static void main(String[] args) {
		Time time=new Time();
		Time time2=new Time();
		Time time3=new Time();
		time.setTime(7, 11);
		time2.setTime(8,11);
		time3=time2.sum(time);
		System.out.println(time.showTime());
		System.out.println(time2.showTime());
		System.out.println(time3.showTime());
	}

}
