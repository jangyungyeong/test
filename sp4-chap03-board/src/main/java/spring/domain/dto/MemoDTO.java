package spring.domain.dto;

public class MemoDTO {
	private String content;
	private String writer;
	private String password;
	private String confirmPassword;
	
	// isPasswordMathcing 메소드
	public boolean isPasswordMatching() {
		return password.equals(confirmPassword);
	}

	// setter, getter 메소드
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
