package attendance.domain;

public enum Status {
    LATE("지각"),
    NOT("결석");

    private String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }
}
