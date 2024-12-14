package attendance.controller;

import attendance.domain.AttendRecord;
import attendance.domain.AttendRecords;
import attendance.domain.MenuCommand;
import attendance.view.InputView;
import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class AttendanceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final AttendRecords attendRecords;

    public AttendanceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.attendRecords = new AttendRecords();
    }

    public void run() {
        MenuCommand command = null;

        attendRecords.createRecords();

        LocalDate now = LocalDate.now();
        int dateOfMonth = now.getDayOfMonth();
        String dayOfWeek = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);

        while(!MenuCommand.QUIT.equals(command)){
            command = inputView.readMenuCommand(dateOfMonth, dayOfWeek);
            executeCommand(command);
            outputView.showRecord(attendRecords.getRecords());
        }
    }

    private void executeCommand(MenuCommand menuCommand){
        if(menuCommand.equals(MenuCommand.QUIT)){
            return;
        }
        execute(menuCommand);
    }

    private void execute(MenuCommand command) {
        if(command.equals(MenuCommand.ATTEND)){
            executeAttend();
        }
        if(command.equals(MenuCommand.ADJUST_ATTENDANCE)){
            executeAdjust();
        }
        if(command.equals(MenuCommand.FIND_ATTENDANCE)){
            executeFind();
        }
        if(command.equals(MenuCommand.CHECK_EXPELLED)){
            executeCheck();
        }
    }

    private void executeAttend() {
        String crewName = inputView.getNewName();
        LocalTime time = inputView.getAttendanceTime();
        int date = DateTimes.now().getDayOfMonth();
        LocalDate todayDate = LocalDate.of(2024, 12, date);
        LocalDateTime today = LocalDateTime.of(todayDate, time);
        attendRecords.add(new AttendRecord(crewName, today));
    }

    private void executeAdjust() {
        String crewName = inputView.getExistName(attendRecords);
        int changeDate = inputView.getChangeDate();
        LocalTime changeTime = inputView.getAttendanceTime();
        attendRecords.findAndChangeAttendanceInfo(crewName, changeDate, changeTime);
    }

    private void executeFind() {

    }

    private void executeCheck() {

    }


}
