import classes.InvalidDataException;
import classes.Learner;
import classes.Olympiad;
import classes.Schoolchild;
import classes.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Schoolchild> schoolList = new ArrayList<>();
            Schoolchild s1 = new Schoolchild("Anna Ivanova", Learner.Gender.FEMALE, 16, 12);
            s1.addGrade("mathematics", 5); s1.addGrade("russian", 5);
            s1.addGrade("history", 5); s1.addGrade("english", 5);
            s1.addGrade("physics", 4);
            s1.addOlympiad(new Olympiad("mathematics", Olympiad.Level.SCHOOL, 1));
            schoolList.add(s1);

            Schoolchild s2 = new Schoolchild("Boris Petrov", Learner.Gender.MALE, 17, 5);
            s2.addGrade("mathematics", 5); s2.addGrade("russian", 5);
            s2.addGrade("history", 5); s2.addGrade("english", 5);
            s2.addOlympiad(new Olympiad("biology", Olympiad.Level.CITY, 2));
            schoolList.add(s2);

            Schoolchild s3 = new Schoolchild("Ivan Sidorov", Learner.Gender.MALE, 16, 3);
            s3.addGrade("mathematics", 5); s3.addGrade("russian", 4);
            s3.addGrade("history", 5); s3.addGrade("english", 5);
            schoolList.add(s3);

            List<Student> studentList = new ArrayList<>();
            Student st1 = new Student("Olga Kuznetsova", Learner.Gender.FEMALE, 20);
            st1.addSessionGrade(5); st1.addSessionGrade(5); st1.addSessionGrade(4);
            st1.addCourseworkGrade(5);
            studentList.add(st1);

            Student st2 = new Student("Pavel Orlov", Learner.Gender.MALE, 21);
            st2.addSessionGrade(5); st2.addSessionGrade(4); st2.addSessionGrade(5);
            studentList.add(st2);

            // 1) combined array of learners who should receive special scholarship, sorted by surname
            List<Learner> eligible = new ArrayList<>();
            for (Schoolchild sc : schoolList) if (sc.isEligibleForSpecialScholarship()) eligible.add(sc);
            for (Student st : studentList) if (st.isEligibleForSpecialScholarship()) eligible.add(st);

            Collections.sort(eligible); // Learner.compareTo -> by surname then name

            System.out.println("Learners eligible for special scholarship (sorted by surname):");
            if (eligible.isEmpty()) System.out.println("  (none)");
            else for (Learner l : eligible) System.out.println("  " + l);

            // 2) determine best student and best schoolchild by rating
            Schoolchild bestSchoolchild = schoolList.stream().max(Comparator.comparingDouble(Schoolchild::getRating)).orElse(null);
            Student bestStudent = studentList.stream().max(Comparator.comparingDouble(Student::getRating)).orElse(null);

            System.out.println("\nBest schoolchild: " + (bestSchoolchild == null ? "(none)" : bestSchoolchild));
            System.out.println("Best student: " + (bestStudent == null ? "(none)" : bestStudent));

            // 3) print schoolchildren sorted by rating then by school number
            List<Schoolchild> schoolSorted = new ArrayList<>(schoolList);
            schoolSorted.sort(Schoolchild.BY_RATING_THEN_SCHOOL);

            System.out.println("\nSchoolchildren sorted by rating (desc) then school number:");
            for (Schoolchild sc : schoolSorted) System.out.println("  " + sc);

            // 4) print students sorted by rating
            List<Student> studentsSorted = new ArrayList<>(studentList);
            studentsSorted.sort(Student.BY_RATING_DESC);

            System.out.println("\nStudents sorted by rating (desc):");
            for (Student st : studentsSorted) System.out.println("  " + st);

        } catch (InvalidDataException ex) {
            System.err.println("Data error: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Unexpected error: " + ex.getMessage());
        }
    }
}
