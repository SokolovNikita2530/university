package classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Schoolchild extends Learner {
    private final List<String> subjects = new ArrayList<>();
    private final List<Integer> grades = new ArrayList<>();
    private final List<Olympiad> olympiads = new ArrayList<>();
    private int schoolNumber = 1;

    public Schoolchild(String name, Gender gender, int age, int schoolNumber) {
        super(name, gender, age);
        this.schoolNumber = Validators.validatePositive(schoolNumber, "schoolNumber");
    }

    public void addGrade(String subject, int grade) {
        if (subject == null || subject.trim().isEmpty()) throw new InvalidDataException("Subject empty");
        grades.add(Validators.validateGrade(grade));
        subjects.add(subject.trim().toLowerCase());
    }

    public void addOlympiad(Olympiad o) {
        if (o != null) olympiads.add(o);
    }

    public int getSchoolNumber() { return schoolNumber; }

    // average of grades (rating)
    @Override
    public double getRating() {
        if (grades.isEmpty()) return 0.0;
        int s = 0;
        for (int g : grades) s += g;
        return (double) s / grades.size();
    }

    // eligibility for special scholarship (rules reused from previous task)
    public boolean isEligibleForSpecialScholarship() {
        String[] must = { "mathematics", "russian", "history", "english" };
        for (String subj : must) {
            Integer g = gradeFor(subj);
            if (g == null || g != 5) return false;
        }
        for (int g : grades) if (g < 4) return false;

        boolean regional = false, schoolFirst = false, cityPrize = false;
        for (Olympiad o : olympiads) {
            if (o.getLevel() == Olympiad.Level.REGIONAL) regional = true;
            if (o.getLevel() == Olympiad.Level.SCHOOL && o.getPlace() == 1) schoolFirst = true;
            if (o.getLevel() == Olympiad.Level.CITY && o.getPlace() <= 3) cityPrize = true;
        }
        return regional || schoolFirst || cityPrize;
    }

    private Integer gradeFor(String subject) {
        subject = subject == null ? "" : subject.trim().toLowerCase();
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).equalsIgnoreCase(subject)) return grades.get(i);
        }
        return null;
    }

    // comparator by rating descending
    public static final Comparator<Schoolchild> BY_RATING_DESC =
            Comparator.comparingDouble(Schoolchild::getRating).reversed();

    // comparator by rating desc then by school number asc
    public static final Comparator<Schoolchild> BY_RATING_THEN_SCHOOL =
            BY_RATING_DESC.thenComparingInt(Schoolchild::getSchoolNumber);

    @Override
    public String toString() {
        return super.toString() + " school#" + schoolNumber + " rating=" + String.format("%.2f", getRating());
    }
}
