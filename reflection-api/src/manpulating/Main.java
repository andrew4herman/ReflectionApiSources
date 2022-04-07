package manpulating;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    private static Item item;
    private static Class<? extends Item> itemClass;

    public static void main(String[] args) {
        item = new Item("apples", 500);
        itemClass = item.getClass();

        try {
            System.out.println(itemClass.getDeclaredMethod("getName", int.class, int.class, int.class));
        } catch ( NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void readFields() throws IllegalAccessException {
        Field[] fields = itemClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " " + field.get(item));
        }
    }

    private static void setNonFinalFieldsToZero() throws IllegalAccessException {
        Field[] fields = itemClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getType() == int.class && !Modifier.isFinal(field.getModifiers())) {
                field.set(item, 0);
            }
            System.out.println(field.getName() + " " + field.get(item));
        }
    }

    private static void invokeAllMethods() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = itemClass.getDeclaredMethods();

        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.invoke(item));
        }
    }
}
