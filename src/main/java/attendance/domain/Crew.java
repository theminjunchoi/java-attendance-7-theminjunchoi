package attendance.domain;

public class Crew {
    private final String crewName;
    private int notCount;
    private int lateCount;

    public Crew(String crewName) {
        this.crewName = crewName;
        this.notCount = 0;
        this.lateCount = 0;
    }

    public String getName() {
        return crewName;
    }

    public void setNotCount(int count) {
        this.notCount = count;
    }

    public void setLateCount(int count) {
        this.lateCount = count;
    }

    public int getNotCount() {
        return notCount;
    }

    public int getLateCount() {
        return lateCount;
    }
}
