package attendance.util;

import java.sql.Time;
import java.util.List;

public class TimeFormatMaker {
    public static Time makeTimeFormat(String line) {
        List<String> values = List.of(line.split(":"));
        int hour = Integer.parseInt(values.get(0));
        int minute = Integer.parseInt(values.get(1));
        return new Time(hour, minute, 0);
    }
}
