package attendance.view;

import attendance.domain.AttendRecord;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private static final String RECORD_DATE_FORMAT = "MM월 dd일 ";
    private static final String RECORD_TIME_FORMAT = " HH:mm";

    public void showRecord(List<AttendRecord> records) {
        for (AttendRecord record : records) {
            String date = record.getDateTime().format(DateTimeFormatter.ofPattern(RECORD_DATE_FORMAT));
            String day = record.getDateTime().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
            String time = record.getDateTime().format(DateTimeFormatter.ofPattern(RECORD_TIME_FORMAT));
            String crewName = record.getCrewName();
            System.out.print(crewName + " ");
            System.out.printf(date + day + time + "\n");
        }
    }

    public void printAttendanceRecord(AttendRecord record) {
        String date = record.getDateTime().format(DateTimeFormatter.ofPattern(RECORD_DATE_FORMAT));
        String day = record.getDateTime().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
        String time = record.getDateTime().format(DateTimeFormatter.ofPattern(RECORD_TIME_FORMAT));
        System.out.printf(date + day + time + " (출석)\n");
    }
}
