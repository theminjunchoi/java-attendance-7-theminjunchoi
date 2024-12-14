package attendance.domain;

import java.sql.Time;

public enum Day {
    MONDAY("월요일", new Time(13,00,00), new Time(18,00,00)),
    TUESDAY("화요일", new Time(10,00,00), new Time(18,00,00)),
    WEDNESDAY("수요일", new Time(10,00,00), new Time(18,00,00)),
    THURSDAY("목요일", new Time(10,00,00), new Time(18,00,00)),
    FRIDAY("금요일", new Time(10,00,00), new Time(18,00,00)),
    RESTDAY("쉬는날", null, null);

    private final String dayName;
    private final Time startTime;
    private final Time endTime;

    Day(String dayName, Time startTime, Time endTime) {
        this.dayName = dayName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDayName() {
        return dayName;
    }
}
