package attendance;

import attendance.controller.AttendanceController;

public class Application {
    public static void main(String[] args) {
        AttendanceController attendanceSystem = new AttendanceController();
        attendanceSystem.run();
    }
}
