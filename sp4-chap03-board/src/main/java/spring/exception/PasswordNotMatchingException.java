package spring.exception;

// RuntimeException
// 실행중 발생하는 예외, 사용자의 잘못된 입력값 처리
// Exception도 처리가 가능하지만 코드의 의도를 정확히 보여주기 위해 RuntimeException 사용
// throw나 try~catch로 예외를 강제할 필요없다
public class PasswordNotMatchingException extends RuntimeException {
	
	public PasswordNotMatchingException(String message) {
		super(message);
	}
}
