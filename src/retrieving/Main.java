package retrieving;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        Class<Integer> intClass = int.class;
        Class<Void> voidClass = void.class;

        System.out.println(stringClass.getName());
        System.out.println(intClass.getName());
        System.out.println(voidClass.getName());
        System.out.println("=".repeat(30));

        Class<? extends String> instanceClass = "abc".getClass();
        System.out.println(instanceClass.getName());
        System.out.println("=".repeat(30));

        Class<?> forName = Class.forName("java.lang.String");
        System.out.println(forName.getName());
    }
}
