package attendance.domain;

import camp.nextstep.edu.missionutils.DateTimes;

public class AttendRecord {
    private final String name;
    private final DateTimes dateTimes;
    private final Day day;

    public AttendRecord(String name, DateTimes dateTimes) {
        this.name = name;
        this.dateTimes = dateTimes;
        this.day = null;
    }
}
