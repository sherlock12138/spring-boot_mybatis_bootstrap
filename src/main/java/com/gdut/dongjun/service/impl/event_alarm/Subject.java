package com.gdut.dongjun.service.impl.event_alarm;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title: Subject.java
 * @Package com.gdut.dongjun.service.impl.event_alarm
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月7日 下午8:57:12
 * @version V1.0
 */
public abstract class Subject extends Thread {
	/**
	 * @ClassName: Subject
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年8月7日 下午8:57:12
	 */
	@Autowired
	private Vector<Observer> obsVector;

	/**
	 * 
	 * @Title: addObserver
	 * @Description: TODO
	 * @param @param o
	 * @return void
	 * @throws
	 */
	public void addObserver(Observer o) {
		this.obsVector.add(o);
	}

	/**
	 * 
	 * @Title: delObserver
	 * @Description: TODO
	 * @param @param o
	 * @return void
	 * @throws
	 */
	public void delObserver(Observer o) {
		this.obsVector.remove(o);
	}

	/**
	 * 
	 * @Title: notifyObservers
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public void notifyObservers() {

		for (Observer observer : obsVector) {
			observer.update();
		}
	}

}
