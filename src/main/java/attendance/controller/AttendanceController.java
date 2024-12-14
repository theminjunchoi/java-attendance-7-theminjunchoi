package attendance.controller;

import attendance.domain.MenuCommand;
import attendance.view.InputView;
import attendance.view.OutputView;

public class AttendanceController {
    private final InputView inputView;
    private final OutputView outputView;

    public AttendanceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        MenuCommand command = null;
        while(!MenuCommand.QUIT.equals(command)){
            command = inputView.readMenuCommand();
            executeCommand(command);
        }
    }
}
