package attendance.domain;

import java.time.LocalDateTime;

public class AttendRecord {
    private final String crewName;
    private LocalDateTime dateTimes;
    private final Day day;

    public AttendRecord(String crewName, LocalDateTime dateTimes) {
        this.crewName = crewName;
        this.dateTimes = dateTimes;
        this.day = null;
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
}
