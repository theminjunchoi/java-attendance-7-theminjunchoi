package attendance.controller;

import attendance.domain.AttendRecords;
import attendance.domain.MenuCommand;
import attendance.view.InputView;
import attendance.view.OutputView;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class AttendanceController {
    private final InputView inputView;
    private final OutputView outputView;

    public AttendanceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        MenuCommand command = null;

        AttendRecords attendRecords = new AttendRecords();
        attendRecords.createRecords();

        LocalDate now = LocalDate.now();
        int dateOfMonth = now.getDayOfMonth();
        String dayOfWeek = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);

        outputView.showRecord(attendRecords.getRecords());

        while(!MenuCommand.QUIT.equals(command)){
            command = inputView.readMenuCommand(dateOfMonth, dayOfWeek);
            executeCommand(command);
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

    }

    private void executeAdjust() {

    }

    private void executeFind() {

    }

    private void executeCheck() {

    }
}
