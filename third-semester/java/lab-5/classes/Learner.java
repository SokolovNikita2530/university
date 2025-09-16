package classes;

public abstract class Learner {
    public enum Gender { MALE, FEMALE }

    private String name;
    private Gender gender;
    private int age;

    public Learner(String name, Gender gender, int age) {
        this.name = name == null ? "" : name;
        this.gender = gender == null ? Gender.MALE : gender;
        this.age = Math.max(0, age);
    }

    public String getName() { return name; }
    public Gender getGender() { return gender; }
    public int getAge() { return age; }

    public abstract boolean isEligibleForSpecialScholarship();

    @Override
    public String toString() {
        return name + " (" + gender + ", " + age + " y)";
    }
}