package classes;

public abstract class Learner implements Comparable<Learner> {
    public enum Gender { MALE, FEMALE }

    private final String name;
    private final Gender gender;
    private final int age;

    protected Learner(String name, Gender gender, int age) {
        Validators.checkName(name);
        this.name = name;
        this.gender = gender == null ? Gender.MALE : gender;
        this.age = Math.max(0, age);
    }

    public String getName() { return name; }
    public Gender getGender() { return gender; }
    public int getAge() { return age; }

    // surname is last token of the full name
    public String getSurname() {
        String[] parts = name.trim().split("\\s+");
        return parts.length == 0 ? name : parts[parts.length - 1];
    }

    // rating used for academic comparisons (subclasses implement)
    public abstract double getRating();

    // compare by surname then full name (common comparison)
    @Override
    public int compareTo(Learner other) {
        int c = this.getSurname().compareToIgnoreCase(other.getSurname());
        if (c != 0) return c;
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + gender + ", " + age + "y)";
    }
}