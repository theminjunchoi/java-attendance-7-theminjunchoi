package attendance.view;

import attendance.util.TimeFormatMaker;
import attendance.util.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.sql.Time;

public class InputView {
    private static final String GET_NAME = "닉네임을 입력해 주세요.";
    private static final String GET_ATTENDANCE_TIME = "등교 시간을 입력해 주세요.";

    public String getNewName() {
        System.out.println(GET_NAME);
        String nameInput = Console.readLine();
        return nameInput;
    }

    public Time getAttendanceTime() {
        System.out.println(GET_ATTENDANCE_TIME);
        String attendanceTimeInput = Console.readLine();
        InputValidator.validateTime(attendanceTimeInput);
        Time time = TimeFormatMaker.makeTimeFormat(attendanceTimeInput);
        return time;
    }

}
