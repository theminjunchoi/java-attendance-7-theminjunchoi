package attendance.domain;

import java.time.LocalDateTime;

public class AttendRecord {
    private final String crewName;
    private final LocalDateTime dateTimes;
    private final Day day;

    public AttendRecord(String crewName, LocalDateTime dateTimes) {
        this.crewName = crewName;
        this.dateTimes = dateTimes;
        this.day = null;
    }

    public LocalDateTime getDateTime() {
        return dateTimes;
    }
}
