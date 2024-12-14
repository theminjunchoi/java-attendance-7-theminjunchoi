package attendance.util.exception;

public enum InputException {
    WRONG_FORMAT("잘못된 형식을 입력하였습니다."),
    BLANK_NAME("이름은 비어있을 수 없습니다."),
    NON_EXIST_NAME("등록되지 않은 닉네임입니다."),
    FUTURE_DATE("아직 수정할 수 없습니다.");

    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}
