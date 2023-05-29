package spring.domain;

import java.util.Date;

public class MemoVO {

	private Long id;
	private String content;
	private String writer;
	private String password;
	private Date regDate;
	
	public MemoVO() {

	}

	public MemoVO(Long id, String content, String writer, String password, Date regDate) {
		this.id = id;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.regDate = regDate;
	}

	public MemoVO(String content, String writer, String password, Date regDate) {
		super();
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.regDate = regDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemoVO [id=" + id + ", content=" + content + ", writer=" + writer + ", password=" + password
				+ ", regDate=" + regDate + "]";
	}
	
	public boolean isMatchingPassword(String password) {
		return this.password.equals(password);
	}
}
