package com.gdut.dongjun.domain.po;

import java.util.Date;

public class HighVoltageHitchEvent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.id
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.switch_id
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    private String switchId;
    
    private Integer changeType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.hitch_reason
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    private String hitchReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.hitch_phase
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    private String hitchPhase;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.hitch_time
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    private Date hitchTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.solve_people
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    private String solvePeople;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.solve_time
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    private Date solveTime;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.solve_way
     *
     * @return the value of high_voltage_hitch_event.solve_way
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    private Integer solveWay;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.id
     *
     * @return the value of high_voltage_hitch_event.id
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */    
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.id
     *
     * @param id the value for high_voltage_hitch_event.id
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.switch_id
     *
     * @return the value of high_voltage_hitch_event.switch_id
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public String getSwitchId() {
        return switchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.switch_id
     *
     * @param switchId the value for high_voltage_hitch_event.switch_id
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public void setSwitchId(String switchId) {
        this.switchId = switchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.hitch_reason
     *
     * @return the value of high_voltage_hitch_event.hitch_reason
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public String getHitchReason() {
        return hitchReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.hitch_reason
     *
     * @param hitchReason the value for high_voltage_hitch_event.hitch_reason
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public void setHitchReason(String hitchReason) {
        this.hitchReason = hitchReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.hitch_phase
     *
     * @return the value of high_voltage_hitch_event.hitch_phase
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public String getHitchPhase() {
        return hitchPhase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.hitch_phase
     *
     * @param hitchPhase the value for high_voltage_hitch_event.hitch_phase
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public void setHitchPhase(String hitchPhase) {
        this.hitchPhase = hitchPhase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.hitch_time
     *
     * @return the value of high_voltage_hitch_event.hitch_time
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public Date getHitchTime() {
        return hitchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.hitch_time
     *
     * @param hitchTime the value for high_voltage_hitch_event.hitch_time
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public void setHitchTime(Date hitchTime) {
        this.hitchTime = hitchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.solve_people
     *
     * @return the value of high_voltage_hitch_event.solve_people
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public String getSolvePeople() {
        return solvePeople;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.solve_people
     *
     * @param solvePeople the value for high_voltage_hitch_event.solve_people
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public void setSolvePeople(String solvePeople) {
        this.solvePeople = solvePeople;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.solve_time
     *
     * @return the value of high_voltage_hitch_event.solve_time
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public Date getSolveTime() {
        return solveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.solve_time
     *
     * @param solveTime the value for high_voltage_hitch_event.solve_time
     *
     * @mbggenerated Thu Jan 28 21:43:47 CST 2016
     */
    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
    }
    
    public Integer getSolveWay() {
    	return solveWay;
    }
    
    public void setSolveWay(Integer solveWay) {
    	this.solveWay = solveWay;
    }
    
    public Integer getChangeType() {
    	return changeType;
    }
    
    public void setChangeType(Integer changeType) {
    	this.changeType = changeType;
    }
}