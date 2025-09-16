package classes;

import java.util.ArrayList;
import java.util.List;

public class Schoolchild extends Learner {
    // simple subjects storage: parallel lists for subject names and grades (1..5)
    private final List<String> subjects = new ArrayList<>();
    private final List<Integer> grades = new ArrayList<>();
    private final List<Olympiad> olympiads = new ArrayList<>();

    public Schoolchild(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    public void addGrade(String subject, int grade) {
        if (subject == null) return;
        int g = Math.max(1, Math.min(5, grade));
        subjects.add(subject);
        grades.add(g);
    }

    public void addOlympiad(Olympiad o) {
        if (o != null) olympiads.add(o);
    }

    public List<Olympiad> getOlympiads() { return new ArrayList<>(olympiads); }

    private Integer gradeFor(String subject) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).equalsIgnoreCase(subject)) return grades.get(i);
        }
        return null;
    }

    @Override
    public boolean isEligibleForSpecialScholarship() {
        // required five in these subjects
        String[] mustFive = { "mathematics", "russian", "history", "english" };
        for (String s : mustFive) {
            Integer g = gradeFor(s);
            if (g == null || g != 5) return false;
        }
        // all other grades >= 4
        for (int g : grades) {
            // skip the previously checked subjects
            // but simpler: if any grade < 4 -> fail
            if (g < 4) return false;
        }
        // olympiad condition:
        boolean hasRegional = false;
        boolean schoolFirst = false;
        boolean cityPrize = false;
        for (Olympiad o : olympiads) {
            if (o.getLevel() == Olympiad.Level.REGIONAL) hasRegional = true;
            if (o.getLevel() == Olympiad.Level.SCHOOL && o.getPlace() == 1) schoolFirst = true;
            if (o.getLevel() == Olympiad.Level.CITY && o.getPlace() <= 3) cityPrize = true;
        }
        return hasRegional || schoolFirst || cityPrize;
    }

    @Override
    public String toString() {
        return super.toString() + " Schoolchild grades=" + gradesSummary() + " olympiads=" + olympiads;
    }

    private String gradesSummary() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < subjects.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(subjects.get(i)).append(":").append(grades.get(i));
        }
        sb.append("}");
        return sb.toString();
    }
}