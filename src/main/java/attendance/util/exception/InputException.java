package attendance.util.exception;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public enum InputException {
    WRONG_FORMAT("잘못된 형식을 입력하였습니다."),
    BLANK_NAME("이름은 비어있을 수 없습니다."),
    NON_EXIST_NAME("등록되지 않은 닉네임입니다."),
    FUTURE_DATE("아직 수정할 수 없습니다."),
    WRONG_TODAY("은 등교일이 아닙니다.");


    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String RECORD_DATE_FORMAT = "MM월 dd일 ";

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }

    public String getTodayMessage() {
        LocalDate now = LocalDate.now();
        String date = now.format(DateTimeFormatter.ofPattern(RECORD_DATE_FORMAT));
        String day = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);

        return ERROR_HEADER + date + day + this.exceptionMessage;
    }

}
