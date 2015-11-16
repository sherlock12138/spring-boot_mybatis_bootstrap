package com.gdut.dongjun.domain.po;

import java.util.Date;

public class HighVoltageHitchEvent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.id
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.switch_id
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private String switchId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.hitch_reason
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Integer hitchReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.hitch_phase
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private String hitchPhase;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.hitch_time
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Date hitchTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.residual_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Integer residualCurrent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.behitch_a_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Integer behitchAPhaseVoltage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.behitch_b_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Integer behitchBPhaseVoltage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.behitch_c_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Integer behitchCPhaseVoltage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.behitch_a_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Integer behitchAPhaseCurrent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.behitch_b_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Integer behitchBPhaseCurrent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column high_voltage_hitch_event.behitch_c_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    private Integer behitchCPhaseCurrent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.id
     *
     * @return the value of high_voltage_hitch_event.id
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
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
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
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
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
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
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
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
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public Integer getHitchReason() {
        return hitchReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.hitch_reason
     *
     * @param hitchReason the value for high_voltage_hitch_event.hitch_reason
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setHitchReason(Integer hitchReason) {
        this.hitchReason = hitchReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.hitch_phase
     *
     * @return the value of high_voltage_hitch_event.hitch_phase
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
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
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
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
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
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
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setHitchTime(Date hitchTime) {
        this.hitchTime = hitchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.residual_current
     *
     * @return the value of high_voltage_hitch_event.residual_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public Integer getResidualCurrent() {
        return residualCurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.residual_current
     *
     * @param residualCurrent the value for high_voltage_hitch_event.residual_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setResidualCurrent(Integer residualCurrent) {
        this.residualCurrent = residualCurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.behitch_a_phase_voltage
     *
     * @return the value of high_voltage_hitch_event.behitch_a_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public Integer getBehitchAPhaseVoltage() {
        return behitchAPhaseVoltage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.behitch_a_phase_voltage
     *
     * @param behitchAPhaseVoltage the value for high_voltage_hitch_event.behitch_a_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setBehitchAPhaseVoltage(Integer behitchAPhaseVoltage) {
        this.behitchAPhaseVoltage = behitchAPhaseVoltage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.behitch_b_phase_voltage
     *
     * @return the value of high_voltage_hitch_event.behitch_b_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public Integer getBehitchBPhaseVoltage() {
        return behitchBPhaseVoltage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.behitch_b_phase_voltage
     *
     * @param behitchBPhaseVoltage the value for high_voltage_hitch_event.behitch_b_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setBehitchBPhaseVoltage(Integer behitchBPhaseVoltage) {
        this.behitchBPhaseVoltage = behitchBPhaseVoltage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.behitch_c_phase_voltage
     *
     * @return the value of high_voltage_hitch_event.behitch_c_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public Integer getBehitchCPhaseVoltage() {
        return behitchCPhaseVoltage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.behitch_c_phase_voltage
     *
     * @param behitchCPhaseVoltage the value for high_voltage_hitch_event.behitch_c_phase_voltage
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setBehitchCPhaseVoltage(Integer behitchCPhaseVoltage) {
        this.behitchCPhaseVoltage = behitchCPhaseVoltage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.behitch_a_phase_current
     *
     * @return the value of high_voltage_hitch_event.behitch_a_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public Integer getBehitchAPhaseCurrent() {
        return behitchAPhaseCurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.behitch_a_phase_current
     *
     * @param behitchAPhaseCurrent the value for high_voltage_hitch_event.behitch_a_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setBehitchAPhaseCurrent(Integer behitchAPhaseCurrent) {
        this.behitchAPhaseCurrent = behitchAPhaseCurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.behitch_b_phase_current
     *
     * @return the value of high_voltage_hitch_event.behitch_b_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public Integer getBehitchBPhaseCurrent() {
        return behitchBPhaseCurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.behitch_b_phase_current
     *
     * @param behitchBPhaseCurrent the value for high_voltage_hitch_event.behitch_b_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setBehitchBPhaseCurrent(Integer behitchBPhaseCurrent) {
        this.behitchBPhaseCurrent = behitchBPhaseCurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column high_voltage_hitch_event.behitch_c_phase_current
     *
     * @return the value of high_voltage_hitch_event.behitch_c_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public Integer getBehitchCPhaseCurrent() {
        return behitchCPhaseCurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column high_voltage_hitch_event.behitch_c_phase_current
     *
     * @param behitchCPhaseCurrent the value for high_voltage_hitch_event.behitch_c_phase_current
     *
     * @mbggenerated Sat Nov 14 14:24:15 CST 2015
     */
    public void setBehitchCPhaseCurrent(Integer behitchCPhaseCurrent) {
        this.behitchCPhaseCurrent = behitchCPhaseCurrent;
    }
}