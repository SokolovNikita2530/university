import classes.Learner;
import classes.Olympiad;
import classes.Schoolchild;
import classes.Student;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Sample schoolchildren
        ArrayList<Schoolchild> schoolList = new ArrayList<>();

        Schoolchild s1 = new Schoolchild("Anna Ivanova", Learner.Gender.FEMALE, 16);
        s1.addGrade("mathematics", 5);
        s1.addGrade("russian", 5);
        s1.addGrade("history", 5);
        s1.addGrade("english", 5);
        s1.addGrade("physics", 4);
        s1.addOlympiad(new Olympiad("mathematics", Olympiad.Level.SCHOOL, 1)); // first place school
        schoolList.add(s1);

        Schoolchild s2 = new Schoolchild("Maria Petrovna", Learner.Gender.FEMALE, 17);
        s2.addGrade("mathematics", 5);
        s2.addGrade("russian", 5);
        s2.addGrade("history", 5);
        s2.addGrade("english", 5);
        s2.addGrade("biology", 4);
        s2.addOlympiad(new Olympiad("biology", Olympiad.Level.CITY, 2)); // city prize
        schoolList.add(s2);

        Schoolchild s3 = new Schoolchild("Ivan Sidorov", Learner.Gender.MALE, 16);
        s3.addGrade("mathematics", 5);
        s3.addGrade("russian", 4); // fails required 5 -> not eligible
        s3.addGrade("history", 5);
        s3.addGrade("english", 5);
        s3.addOlympiad(new Olympiad("math", Olympiad.Level.REGIONAL, 5));
        schoolList.add(s3);

        // Sample students
        ArrayList<Student> studentList = new ArrayList<>();

        Student st1 = new Student("Olga Kuznetsova", Learner.Gender.FEMALE, 20);
        st1.addSessionGrade(5); st1.addSessionGrade(5); st1.addSessionGrade(4); st1.addSessionGrade(5);
        st1.addCourseworkGrade(5);
        studentList.add(st1);

        Student st2 = new Student("Pavel Orlov", Learner.Gender.MALE, 21);
        st2.addSessionGrade(5); st2.addSessionGrade(4); st2.addSessionGrade(5); st2.addSessionGrade(4);
        // no coursework grades
        studentList.add(st2);

        Student st3 = new Student("Irina Smirnova", Learner.Gender.FEMALE, 22);
        st3.addSessionGrade(5); st3.addSessionGrade(5); st3.addSessionGrade(5); st3.addSessionGrade(5);
        st3.addCourseworkGrade(4); // coursework not 5 -> not eligible
        studentList.add(st3);

        // 1) print girls who got first places on any olympiad
        System.out.println("Girls with first places on any olympiad:");
        for (Schoolchild sc : schoolList) {
            if (sc.getGender() == Learner.Gender.FEMALE) {
                for (Olympiad o : sc.getOlympiads()) {
                    if (o.getPlace() == 1) {
                        System.out.println("  " + sc.getName() + " -> " + o);
                        break;
                    }
                }
            }
        }

        // 2) print students who have coursework grades
        System.out.println("\nStudents who have coursework grades:");
        for (Student st : studentList) {
            if (!st.getCourseworkGrades().isEmpty()) {
                System.out.println("  " + st);
            }
        }

        // 3) combined list of learners eligible for special scholarship
        ArrayList<Learner> eligible = new ArrayList<>();
        for (Schoolchild sc : schoolList) if (sc.isEligibleForSpecialScholarship()) eligible.add(sc);
        for (Student st : studentList) if (st.isEligibleForSpecialScholarship()) eligible.add(st);

        System.out.println("\nLearners eligible for special scholarship:");
        if (eligible.isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Learner l : eligible) System.out.println("  " + l);
        }
    }
}
