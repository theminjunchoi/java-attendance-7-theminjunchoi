package attendance.domain;

public class Crew {
    private final String crewName;
    private final int penalty;

    public Crew(String crewName, int penalty) {
        this.crewName = crewName;
        this.penalty = penalty;
    }
}
