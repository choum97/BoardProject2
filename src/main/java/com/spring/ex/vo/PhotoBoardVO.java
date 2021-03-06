package com.spring.ex.vo;

import java.sql.Date;

public class PhotoBoardVO { 
	/* 
	 * 번호 
	 * 작성자
	 * 제목
	 * 내용
	 * 조회수
	 * 좋아요
	 * 서버 저장파일 이름
	 * 작성일
	 */
	
	private int b_no;
	private String b_userId;
	private String b_title; 
	private String b_content;
	private int b_hit;
	private int b_like;
	private String b_file_name;
	private Date b_writing_date;
	
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_userId() {
		return b_userId;
	}
	public void setB_userId(String b_userId) {
		this.b_userId = b_userId;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public int getB_like() {
		return b_like;
	}
	public void setB_like(int b_like) {
		this.b_like = b_like;
	}
	public Date getB_writing_date() {
		return b_writing_date;
	}
	public void setB_writing_date(Date b_writing_date) {
		this.b_writing_date = b_writing_date;
	}
	public String getB_file_name() {
		return b_file_name;
	}
	public void setB_file_name(String b_file_name) {
		this.b_file_name = b_file_name;
	}
}