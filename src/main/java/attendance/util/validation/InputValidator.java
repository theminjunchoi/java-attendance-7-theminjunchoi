package attendance.util.validation;

import attendance.domain.AttendRecord;
import attendance.util.exception.InputException;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern TIME_PATTERN = Pattern.compile("(2[0-3]|[01][0-9]):[0-5][0-9]");
    private static final Pattern DATE_PATTERN = Pattern.compile("[0-31]");

    public static void validateNewName(String nameInput) {
        if(nameInput.isBlank()) {
            throw new IllegalArgumentException(InputException.BLANK_NAME.getExceptionMessage());
        }
    }

    public static void validateTime(String attendanceTimeInput) {
        if (!TIME_PATTERN.matcher(attendanceTimeInput).matches()) {
            throw new IllegalArgumentException(InputException.WRONG_FORMAT.getExceptionMessage());
        }
    }

    public static void validateExistName(String nameInput, List<AttendRecord> records) {
        boolean flag = false;
        for (AttendRecord record : records) {
            if (record.getCrewName().equals(nameInput)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new IllegalArgumentException(InputException.NON_EXIST_NAME.getExceptionMessage());
        }
    }

    public static void validateDate(String dateInput) {
        if (!DATE_PATTERN.matcher(dateInput).matches()) {
            throw new IllegalArgumentException(InputException.WRONG_FORMAT.getExceptionMessage());
        }
        int date = DateTimes.now().getDayOfMonth();
        if (Integer.parseInt(dateInput) > date) {
            throw new IllegalArgumentException(InputException.FUTURE_DATE.getExceptionMessage());
        }
    }
}
