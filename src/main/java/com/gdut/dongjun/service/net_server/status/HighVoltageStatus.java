package com.gdut.dongjun.service.net_server.status;

/**   
 * @author	Sherlock-lee
 * @date	2016年1月15日 下午11:20:25
 * @see 	TODO
 * @since   1.0
 */
public class HighVoltageStatus {
	
	private String id;//设备ID
	private String status;//当前状态 00分闸 01合闸
	
	private String guo_liu_yi_duan;
	private String guo_liu_er_duan;
	private String guo_liu_san_duan;
	
	private String ling_xu_guo_liu_;//零序过流
	
	private String chong_he_zha;//
	
	private String pt1_you_ya;
	private String pt2_you_ya;
	
	private String pt1_guo_ya;
	private String pt2_guo_ya;
	
	private String jiao_liu_shi_dian;
	
	private String shou_dong_he_zha;
	private String shou_dong_fen_zha;
	
	private String yao_kong_fu_gui;
	private String yao_kong_he_zha;
	private String yao_kong_fen_zha;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGuo_liu_yi_duan() {
		return guo_liu_yi_duan;
	}
	public void setGuo_liu_yi_duan(String guo_liu_yi_duan) {
		this.guo_liu_yi_duan = guo_liu_yi_duan;
	}
	public String getGuo_liu_er_duan() {
		return guo_liu_er_duan;
	}
	public void setGuo_liu_er_duan(String guo_liu_er_duan) {
		this.guo_liu_er_duan = guo_liu_er_duan;
	}
	public String getGuo_liu_san_duan() {
		return guo_liu_san_duan;
	}
	public void setGuo_liu_san_duan(String guo_liu_san_duan) {
		this.guo_liu_san_duan = guo_liu_san_duan;
	}
	public String getLing_xu_guo_liu_() {
		return ling_xu_guo_liu_;
	}
	public void setLing_xu_guo_liu_(String ling_xu_guo_liu_) {
		this.ling_xu_guo_liu_ = ling_xu_guo_liu_;
	}
	public String getChong_he_zha() {
		return chong_he_zha;
	}
	public void setChong_he_zha(String chong_he_zha) {
		this.chong_he_zha = chong_he_zha;
	}
	public String getPt1_you_ya() {
		return pt1_you_ya;
	}
	public void setPt1_you_ya(String pt1_you_ya) {
		this.pt1_you_ya = pt1_you_ya;
	}
	public String getPt2_you_ya() {
		return pt2_you_ya;
	}
	public void setPt2_you_ya(String pt2_you_ya) {
		this.pt2_you_ya = pt2_you_ya;
	}
	public String getPt1_guo_ya() {
		return pt1_guo_ya;
	}
	public void setPt1_guo_ya(String pt1_guo_ya) {
		this.pt1_guo_ya = pt1_guo_ya;
	}
	public String getPt2_guo_ya() {
		return pt2_guo_ya;
	}
	public void setPt2_guo_ya(String pt2_guo_ya) {
		this.pt2_guo_ya = pt2_guo_ya;
	}
	public String getJiao_liu_shi_dian() {
		return jiao_liu_shi_dian;
	}
	public void setJiao_liu_shi_dian(String jiao_liu_shi_dian) {
		this.jiao_liu_shi_dian = jiao_liu_shi_dian;
	}
	public String getShou_dong_he_zha() {
		return shou_dong_he_zha;
	}
	public void setShou_dong_he_zha(String shou_dong_he_zha) {
		this.shou_dong_he_zha = shou_dong_he_zha;
	}
	public String getShou_dong_fen_zha() {
		return shou_dong_fen_zha;
	}
	public void setShou_dong_fen_zha(String shou_dong_fen_zha) {
		this.shou_dong_fen_zha = shou_dong_fen_zha;
	}
	public String getYao_kong_fu_gui() {
		return yao_kong_fu_gui;
	}
	public void setYao_kong_fu_gui(String yao_kong_fu_gui) {
		this.yao_kong_fu_gui = yao_kong_fu_gui;
	}
	public String getYao_kong_he_zha() {
		return yao_kong_he_zha;
	}
	public void setYao_kong_he_zha(String yao_kong_he_zha) {
		this.yao_kong_he_zha = yao_kong_he_zha;
	}
	public String getYao_kong_fen_zha() {
		return yao_kong_fen_zha;
	}
	public void setYao_kong_fen_zha(String yao_kong_fen_zha) {
		this.yao_kong_fen_zha = yao_kong_fen_zha;
	}
	
}
