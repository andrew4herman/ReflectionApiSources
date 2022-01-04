package modifiers;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Item item = new Item("apples", 500);

        Class<? extends Item> itemClass = item.getClass();
        Field[] fields = itemClass.getDeclaredFields();

        for (Field field : fields) {
            int modifiers = field.getModifiers();

            if (Modifier.isPublic(modifiers)) {
                System.out.print("public ");

            } else if (Modifier.isProtected(modifiers)) {
                System.out.print("protected ");

            } else if (Modifier.isPrivate(modifiers)) {
                System.out.print("private ");
            }

            if (Modifier.isStatic(modifiers)) {
                System.out.print("static ");
            }
            if (Modifier.isFinal(modifiers)) {
                System.out.print("final ");
            }

            System.out.print(field.getType().getSimpleName() + " ");
            System.out.println(field.getName());
        }
    }
}
