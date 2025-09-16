package classes;

public class Olympiad {
    public enum Level { SCHOOL, CITY, REGIONAL } // областная = REGIONAL

    private final String subject;
    private final Level level;
    private final int place; // 1 = first, 2 = second, etc.

    public Olympiad(String subject, Level level, int place) {
        this.subject = subject == null ? "" : subject;
        this.level = level == null ? Level.SCHOOL : level;
        this.place = Math.max(1, place);
    }

    public String getSubject() { return subject; }
    public Level getLevel() { return level; }
    public int getPlace() { return place; }

    @Override
    public String toString() {
        return subject + " [" + level + ", place=" + place + "]";
    }
}