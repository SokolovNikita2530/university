package classes;

public final class Validators {
    private Validators() {}

    public static void checkName(String name) {
        if (name == null || name.trim().isEmpty()) throw new InvalidDataException("Name is empty");
        char c = name.trim().charAt(0);
        if (!Character.isUpperCase(c)) throw new InvalidDataException("Name must start with an uppercase letter");
    }

    public static int validateGrade(int g) {
        if (g < 2 || g > 5) throw new InvalidDataException("Grade must be between 2 and 5: " + g);
        return g;
    }

    public static int validatePositive(int v, String field) {
        if (v <= 0) throw new InvalidDataException(field + " must be positive");
        return v;
    }
}
