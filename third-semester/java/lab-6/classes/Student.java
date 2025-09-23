package classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student extends Learner {
    private final List<Integer> sessionGrades = new ArrayList<>();
    private final List<Integer> courseworkGrades = new ArrayList<>();

    public Student(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    public void addSessionGrade(int g) { sessionGrades.add(Validators.validateGrade(g)); }
    public void addCourseworkGrade(int g) { courseworkGrades.add(Validators.validateGrade(g)); }

    @Override
    public double getRating() {
        if (sessionGrades.isEmpty()) return 0.0;
        int s = 0;
        for (int g : sessionGrades) s += g;
        return (double) s / sessionGrades.size();
    }

    public boolean isEligibleForSpecialScholarship() {
        if (getRating() < 4.75) return false;
        for (int g : courseworkGrades) if (g == 5) return true;
        return false;
    }

    // comparator by rating descending
    public static final Comparator<Student> BY_RATING_DESC =
            Comparator.comparingDouble(Student::getRating).reversed();

    @Override
    public String toString() {
        return super.toString() + " rating=" + String.format("%.2f", getRating());
    }
}