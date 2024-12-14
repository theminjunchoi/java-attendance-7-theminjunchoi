package attendance.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.accessibility.AccessibleText;

public class AttendRecords {
    private static final Path path = Paths.get("src/main/resources/attendances.csv");

    private List<AttendRecord> attendRecords;

    public AttendRecords() {
        this.attendRecords = new ArrayList<>();
    }

    public void createRecords() {
        // csv 읽기
        // 하나씩 attendRecord로 만들어서 add
        try {
            List<String> records = Files.readAllLines(path);
            for (int i = 1; i < records.size(); i++) {
                addRecord(records.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addRecord(String recordValue) {
        List<String> recordValues = List.of(recordValue.split(","));
        String crewName = recordValues.get(0);

        String dateValue = List.of(recordValues.get(1).split(" ")).get(0);
        List<Integer> dateValuesToint = getDate(dateValue);

        String timeValue = List.of(recordValues.get(1).split(" ")).get(1);
        List<Integer> timeValuesToint = getTime(timeValue);

        LocalDate date = LocalDate.of(dateValuesToint.get(0), dateValuesToint.get(1), dateValuesToint.get(2));
        LocalTime time = LocalTime.of(timeValuesToint.get(0), timeValuesToint.get(1));

        LocalDateTime attendDate = LocalDateTime.of(date, time);
        attendRecords.add(new AttendRecord(crewName, attendDate));
    }

    private static List<Integer> getDate(String dateValue) {
        List<String> dateValues = List.of(dateValue.split("-"));
        List<Integer> dateValuesToInt = new ArrayList<>();
        for (String value : dateValues) {
            dateValuesToInt.add(Integer.parseInt(value));
        }
        return dateValuesToInt;
    }

    private static List<Integer> getTime(String timeValue) {
        List<String> timeValues = List.of(timeValue.split(":"));
        List<Integer> timeValuesToInt = new ArrayList<>();
        for (String value : timeValues) {
            timeValuesToInt.add(Integer.parseInt(value));
        }
        return timeValuesToInt;
    }

    public List<AttendRecord> getRecords() {
        return attendRecords;
    }

    public void add(AttendRecord attendRecord) {
        attendRecords.add(attendRecord);
    }

    public void findAndChangeAttendanceInfo(String crewName, int changeDate, LocalTime changeTime) {
        for (AttendRecord record : attendRecords) {
            LocalDate date = LocalDate.of(20224, 12, changeDate);
            LocalDateTime dateTime = LocalDateTime.of(date, changeTime);
            record.setDateTime(dateTime);
        }
    }

    public LocalTime findTime(String crewName, int changeDate) {
        LocalTime time = null;
        for (AttendRecord record : attendRecords) {
            if (record.isExist(crewName, changeDate)) {
                int hour = record.getDateTime().getHour();
                int minute = record.getDateTime().getHour();
                time = LocalTime.of(hour, minute);
            }
        }
        return time;
    }

    public void addDayInfo() {
        for (AttendRecord record : attendRecords) {
            int dayValue = record.getDateTime().getDayOfWeek().getValue();
            Day day = Arrays.stream(Day.values())
                    .filter(value -> value.getDayValue() == dayValue)
                    .findAny()
                    .orElse(Day.RESTDAY);
            record.setDay(day);
        }
    }

    public boolean isExist(String crewName, LocalDate findDate) {
        for (AttendRecord record : attendRecords) {
            LocalDate localDate = record.getDateTime().toLocalDate();
            if (record.getCrewName().equals(crewName) && localDate.equals(findDate)) {
                return true;
            }
        }
        return false;
    }

    public AttendRecord findRecord(String crewName, LocalDate findDate) {
        for (AttendRecord record : attendRecords) {
            LocalDate localDate = record.getDateTime().toLocalDate();
            if (record.getCrewName().equals(crewName) && localDate.equals(findDate)) {
                return record;
            }
        }
        return null;
    }

    public List<Crew> organizeCrew() {
        List<Crew> crews = new ArrayList<>();
        List<String> crewNames = new ArrayList<>();
        for (AttendRecord record : attendRecords) {
            crewNames.add(record.getCrewName());
        }
        Set<String> uniqueCrewNames = new HashSet<>(crewNames);
        for (String name : uniqueCrewNames) {
            crews.add(new Crew(name));
        }
        return crews;
    }
}
