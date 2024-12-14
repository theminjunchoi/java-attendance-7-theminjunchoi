package attendance.view;

import attendance.domain.AttendRecord;
import attendance.domain.AttendRecords;
import attendance.domain.Day;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private static final String RECORD_DATE_FORMAT = "MM월 dd일 ";
    private static final String RECORD_TIME_FORMAT = " HH:mm";
    private static final String OWN_RECORD_FORMAT = "이번 달 %s의 출석 기록입니다.\n";


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

    public void printAdjustRecord(int changeDate, LocalTime originalTime, LocalTime changeTime) {
        LocalDate date = LocalDate.of(2024, 12, changeDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dateInfo = date.format(DateTimeFormatter.ofPattern(RECORD_DATE_FORMAT));
        String dayInfo = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
        String originalTimeInfo = originalTime.format(DateTimeFormatter.ofPattern(RECORD_TIME_FORMAT));
        String changeTimeInfo =changeTime.format(DateTimeFormatter.ofPattern(RECORD_TIME_FORMAT));
        System.out.printf(dateInfo + dayInfo + originalTimeInfo + " -> " + changeTimeInfo + " 수정 완료!\n");
    }

    public void showOwnRecord(String crewName, AttendRecords attendRecords) {
        System.out.printf(OWN_RECORD_FORMAT, crewName);
        int date = DateTimes.now().getDayOfMonth();
        for (int i = 1; i < date; i++) {
            Day findDay = Day.of(LocalDate.of(2024, 12, i).getDayOfWeek().getValue());
            LocalDate findDate = LocalDate.of(2024, 12, i);
            if (attendRecords.isExist(crewName, findDate) && findDay.isWorkDay()) {
                AttendRecord record = attendRecords.findRecord(crewName, findDate);
                String dateInfo = record.getDateTime().format(DateTimeFormatter.ofPattern(RECORD_DATE_FORMAT));
                String dayInfo = findDay.getDayName();
                String timeInfo = record.getDateTime().format(DateTimeFormatter.ofPattern(RECORD_TIME_FORMAT));
                String recordStatus = record.checkStatus();
                System.out.printf(dateInfo + dayInfo + timeInfo + " (" + recordStatus + ")\n");
            }
            if (!attendRecords.isExist(crewName, findDate) && findDay.isWorkDay()) {
                String dateInfo = LocalDate.of(2024, 12, i).format(DateTimeFormatter.ofPattern(RECORD_DATE_FORMAT));
                String dayInfo = findDay.getDayName();
                String timeInfo = " --:--";
                System.out.printf(dateInfo + dayInfo + timeInfo + " (결석)\n");
            }
        }
    }
}
