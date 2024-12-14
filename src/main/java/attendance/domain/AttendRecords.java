package attendance.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
}
