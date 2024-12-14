package attendance.view;

import attendance.domain.Day;
import attendance.domain.MenuCommand;
import attendance.util.TimeFormatMaker;
import attendance.util.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.sql.Time;
import java.time.LocalTime;

public class InputView {
    private static final String GET_MENU_COMMAND = "오늘은 12월 %d일 %s입니다. 기능을 선택해 주세요.\n"
            + "1. 출석 확인\n"
            + "2. 출석 수정\n"
            + "3. 크루별 출석 기록 확인\n"
            + "4. 제적 위험자 확인\n";
    private static final String GET_NAME = "닉네임을 입력해 주세요.";
    private static final String GET_ATTENDANCE_TIME = "등교 시간을 입력해 주세요.";


    public MenuCommand readMenuCommand(int date, String day) {
        System.out.printf(GET_MENU_COMMAND, date, day);
        try{
            return MenuCommand.fromInput(Console.readLine());
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMenuCommand(date, day);
        }
    }

    public String getNewName() {
        System.out.println(GET_NAME);
        String nameInput = Console.readLine();
        InputValidator.validateNewName(nameInput);
        return nameInput;
    }

    public LocalTime getAttendanceTime() {
        System.out.println(GET_ATTENDANCE_TIME);
        String attendanceTimeInput = Console.readLine();
        InputValidator.validateTime(attendanceTimeInput);
        LocalTime time = TimeFormatMaker.makeTimeFormat(attendanceTimeInput);
        return time;
    }


}
