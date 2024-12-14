package attendance.domain;

import java.util.List;

public class AttendRecords {
    private final List<AttendRecord> attendRecords;

    public AttendRecords(List<AttendRecord> attendRecords) {
        this.attendRecords = attendRecords;
    }
}
