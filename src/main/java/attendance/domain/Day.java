package attendance.domain;

import java.time.LocalTime;
import java.util.Arrays;

public enum Day {
    MONDAY(1, "월요일", LocalTime.of(13, 00), LocalTime.of(18,00)),
    TUESDAY(2, "화요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    WEDNESDAY(3, "수요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    THURSDAY(4, "목요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    FRIDAY(5, "금요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    SATURDAY(6, "토요일", null, null),
    SUNDAY(7, "일요일", null, null),
    RESTDAY(0, "공휴일", null, null);

    private final int dayValue;
    private final String dayName;
    private final LocalTime startTime;
    private final LocalTime endTime;

    Day(int dayValue, String dayName, LocalTime startTime, LocalTime endTime) {
        this.dayValue = dayValue;
        this.dayName = dayName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Day of(int i) {
        return Arrays.stream(values())
                .filter(value -> value.getDayValue() == i)
                .findFirst()
                .orElse(null);
    }

    public int getDayValue() {
        return dayValue;
    }

    public String getDayName() {
        return dayName;
    }

    public boolean isWorkDay() {
        if (dayValue < 6) {
            return true;
        }
        return false;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
