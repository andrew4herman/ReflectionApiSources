package basics;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> student = Class.forName("basics.Student");

        var declaredConstructors = student.getDeclaredConstructors();
        var constructors = student.getConstructors();

        var declaredFields = student.getDeclaredFields();
        var fields = student.getFields();

        var declaredMethods = student.getDeclaredMethods();
        var methods = student.getMethods();

        System.out.println("=".repeat(30));
        System.out.println("Declared Constructors: ");
        outputList(declaredConstructors);

        System.out.println("Constructors: ");
        outputList(constructors);

        System.out.println("Declared Fields: ");
        outputList(declaredFields);

        System.out.println("Fields: ");
        outputList(fields);

        System.out.println("Declared Methods: ");
        outputList(declaredMethods);

        System.out.println("Methods: ");
        outputList(methods);
    }

    private static void outputList(Executable[] executables) {
        for (Executable executable : executables) {
            System.out.println("- " + executable.getName());
        }
        System.out.println("=".repeat(30));
    }

    private static void outputList(Member[] members) {
        for (Member member : members) {
            System.out.println("- " + member.getName());
        }
        System.out.println("=".repeat(30));
    }
}
