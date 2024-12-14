package attendance.util;

import java.time.LocalTime;
import java.util.List;

public class TimeFormatMaker {
    public static LocalTime makeTimeFormat(String line) {
        List<String> values = List.of(line.split(":"));
        int hour = Integer.parseInt(values.get(0));
        int minute = Integer.parseInt(values.get(1));
        return LocalTime.of(hour, minute);
    }
}
