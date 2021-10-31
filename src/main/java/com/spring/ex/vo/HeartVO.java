package com.spring.ex.vo;

public class HeartVO {
	/*
	 * 좋아요 번호
	 * 게시판 번호
	 * 회원 아이디
	 */
	private int h_no;
	private int m_no;
	private String m_userId;
	public int getH_no() {
		return h_no;
	}
	public void setH_no(int h_no) {
		this.h_no = h_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_userId() {
		return m_userId;
	}
	public void setM_userId(String m_userId) {
		this.m_userId = m_userId;
	}

}