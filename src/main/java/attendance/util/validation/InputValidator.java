package attendance.util.validation;

import attendance.util.exception.InputException;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern TIME_PATTERN = Pattern.compile("[0-9]+:[0-9]");

    public static void validateTime(String attendanceTimeInput) {
        if (!TIME_PATTERN.matcher(attendanceTimeInput).matches()) {
            throw new IllegalArgumentException(InputException.WRONG_TIME_FORMAT.getExceptionMessage());
        }
    }
}
