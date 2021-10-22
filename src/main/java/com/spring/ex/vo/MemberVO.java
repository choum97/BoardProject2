package com.spring.ex.vo;

import java.sql.Date;

public class MemberVO {
	/*
	 * 번호
	 * 회원 이름
	 * 회원 아이디
	 * 회원 비밀번호
	 * 가입날짜
	 * 최근접속일
	 * 관리자 유무 체크
	 */
	
	private int m_no;
	private String m_name;
	private String m_userId;
	private String m_pw;
	private String m_email;
	private Date m_join_date;
	private Date m_last_date;
	private int m_access_right;
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_userId() {
		return m_userId;
	}
	public void setM_userId(String m_userId) {
		this.m_userId = m_userId;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public Date getM_join_date() {
		return m_join_date;
	}
	public void setM_join_date(Date m_join_date) {
		this.m_join_date = m_join_date;
	}
	public Date getM_last_date() {
		return m_last_date;
	}
	public void setM_last_date(Date m_last_date) {
		this.m_last_date = m_last_date;
	}
	public int getM_access_right() {
		return m_access_right;
	}
	public void setM_access_right(int m_access_right) {
		this.m_access_right = m_access_right;
	}
}