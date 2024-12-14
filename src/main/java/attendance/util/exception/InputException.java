package attendance.util.exception;

public enum InputException {
    WRONG_TIME_FORMAT("잘못된 형식을 입력하였습니다.");

    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}
