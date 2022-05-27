package ua.fan.hw21.model;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import ua.fan.hw21.annotations.AutoCreate;
import ua.fan.hw21.annotations.Init;
import ua.fan.hw21.annotations.Multiplier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class AnnotationService {
    public static void init() {
        final Reflections reflections = new Reflections("ua.fan.hw21");
        final Set<Class<?>> annotatedWith = reflections.getTypesAnnotatedWith(AutoCreate.class);
        final Map<String, Object> objects = new HashMap<>();

        for (Class<?> aClass : annotatedWith) {
            try {
                final Object obj = aClass.newInstance();
                final Field[] declaredFields = aClass.getDeclaredFields();
                System.out.printf("%n-----> CLASS %s " +
                        "%n---> Fields annotation:%n", aClass.getSimpleName().toUpperCase());
                printFieldsAnnotations(declaredFields, obj);
                System.out.printf("---> Before Multiplier: %n%s%n", obj);
                System.out.printf("---> After Multiplier: %n");
                fieldValueChanging(declaredFields, obj);
                System.out.println(obj);
                objects.put(aClass.getSimpleName(), obj);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%n-----> Calling methods with @Init: %n");
        callInitMethods(objects);
    }

    private static void callInitMethods(Map<String, Object> objects) {
        objects.forEach((s, object) -> {
            final Method[] declaredMethods = object.getClass().getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.isAnnotationPresent(Init.class)){
                    System.out.printf("---> %s @Init method: %n", object.getClass().getSimpleName());
                    try {
                        declaredMethod.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private static void printFieldsAnnotations(Field[] declaredFields, Object obj) {
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            final String fieldName = declaredField.getName();
            final Annotation[] annotations = declaredField.getDeclaredAnnotations();
            System.out.printf("%s: %s%n", fieldName, Arrays.toString(annotations));
        }
    }


    @SneakyThrows
    private static void fieldValueChanging(Field[] declaredFields, Object object) {
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Multiplier.class)) {
                final Multiplier.Action action = declaredField.getAnnotation(Multiplier.class).action();
                final Class<?> fieldType = declaredField.getType();

                if (isNumber(fieldType)) {
                    final double fieldValue = (double) declaredField.get(object);
                    declaredField.setAccessible(true);
                    Number newValue = 0;
                    switch (action) {
                        case MULTIPLICATION -> newValue = fieldValue * 3;
                        case ADDITION -> newValue = fieldValue + fieldValue;
                        case SUBTRACTION -> newValue = fieldValue - 1;
                    }
                    declaredField.set(object, newValue);
                } else {
                    System.out.printf("Cannot implement arithmetical operations with %s%n", fieldType.getSimpleName());
                }
            }
        }
    }

    private static boolean isNumber(Class<?> fieldType) {
        return !(fieldType.equals(String.class) ||
                fieldType.equals(Character.class) ||
                fieldType.equals(char.class) ||
                fieldType.equals(Boolean.class) ||
                fieldType.equals(boolean.class));
    }
}
