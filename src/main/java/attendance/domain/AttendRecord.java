package attendance.domain;

import java.time.LocalDateTime;

public class AttendRecord {
    private final String crewName;
    private LocalDateTime dateTimes;
    private Day day;
    private Status status;

    public AttendRecord(String crewName, LocalDateTime dateTimes) {
        this.crewName = crewName;
        this.dateTimes = dateTimes;
        this.day = null;
        this.status = null;
    }

    public LocalDateTime getDateTime() {
        return dateTimes;
    }

    public String getCrewName() {
        return crewName;
    }

    public boolean isExist(String crewName, int changeDate) {
        int date = dateTimes.getDayOfMonth();
        if (crewName.equals(crewName) && date == changeDate) {
            return true;
        }
        return false;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTimes = dateTime;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Day getDay() {
        return day;
    }

    public String checkStatus() {
        if (dateTimes.toLocalTime().isBefore(day.getStartTime().plusMinutes(4))) {
            return "출석";
        }
        if (dateTimes.toLocalTime().isAfter(day.getStartTime().plusMinutes(5))
        && dateTimes.toLocalTime().isBefore(day.getStartTime().plusMinutes(29))) {
            return "지각";
        }
        if (dateTimes.toLocalTime().isAfter(day.getStartTime().plusMinutes(5))) {
            return "출석";
        }
        return "null";
    }
}
