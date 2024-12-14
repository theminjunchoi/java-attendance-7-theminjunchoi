package attendance.domain;

public class Crew {
    private final String crewName;
    private final int notCount;
    private final int lateCount;

    public Crew(String crewName) {
        this.crewName = crewName;
        this.notCount = 0;
        this.lateCount = 0;
    }
}
