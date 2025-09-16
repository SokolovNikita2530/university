package classes;

import java.util.ArrayList;
import java.util.List;

public class Student extends Learner {
    private final List<Integer> sessionGrades = new ArrayList<>();
    private final List<Integer> courseworkGrades = new ArrayList<>();

    public Student(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    public void addSessionGrade(int grade) {
        sessionGrades.add(Math.max(1, Math.min(5, grade)));
    }

    public void addCourseworkGrade(int grade) {
        courseworkGrades.add(Math.max(1, Math.min(5, grade)));
    }

    public List<Integer> getCourseworkGrades() {
        return new ArrayList<>(courseworkGrades);
    }

    private double averageSession() {
        if (sessionGrades.isEmpty()) return 0.0;
        int sum = 0;
        for (int g : sessionGrades) sum += g;
        return (double) sum / sessionGrades.size();
    }

    @Override
    public boolean isEligibleForSpecialScholarship() {
        if (averageSession() < 4.75) return false;
        for (int g : courseworkGrades) if (g == 5) return true;
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " session=" + sessionGrades + " coursework=" + courseworkGrades;
    }
}