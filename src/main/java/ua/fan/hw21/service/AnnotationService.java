package ua.fan.hw21.service;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import ua.fan.hw21.annotations.AutoCreate;
import ua.fan.hw21.annotations.Init;
import ua.fan.hw21.annotations.Multiplier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
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
                final Constructor<?> constructor = aClass.getConstructor();
                final Object obj = constructor.newInstance();
                final Field[] declaredFields = aClass.getDeclaredFields();
                System.out.printf("%n-----> CLASS %s " +
                        "%n---> Fields annotation:%n", aClass.getSimpleName().toUpperCase());
                printFieldsAnnotations(declaredFields, obj);
                System.out.printf("---> Before Multiplier: %n%s%n", obj);
                System.out.printf("---> After Multiplier: %n");
                fieldValueChanging(declaredFields, obj);
                System.out.println(obj);
                objects.put(aClass.getSimpleName(), obj);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
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
                if (declaredMethod.isAnnotationPresent(Init.class)) {
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
                    declaredField.setAccessible(true);
                    Number newValue;
                    if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
                        final Integer fieldValue = (Integer) declaredField.get(object);
                        newValue = arithmeticalOperationForInteger(fieldValue, action);
                        declaredField.set(object, newValue);
                    } else if (fieldType.equals(Double.class) || fieldType.equals(double.class)) {
                        final Double fieldValue = (Double) declaredField.get(object);
                        newValue = arithmeticalOperationForDouble(fieldValue, action);
                        declaredField.set(object, newValue);
                    } else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
                        final Long fieldValue = (Long) declaredField.get(object);
                        newValue = arithmeticalOperationForLong(fieldValue, action);
                        declaredField.set(object, newValue);
                    } else {
                    System.out.printf("Cannot implement arithmetical operations with %s%n", fieldType.getSimpleName());
                }
            }
        }
    }

    private static Number arithmeticalOperationForInteger(Integer fieldValue, Multiplier.Action action) {
        switch (action) {
            case MULTIPLICATION -> {
                return fieldValue * 3;
            }
            case ADDITION -> {
                return fieldValue + fieldValue;
            }
            case SUBTRACTION -> {
                return fieldValue - 1;
            }
        }
        return 0;
    }

    private static Number arithmeticalOperationForDouble(Double fieldValue, Multiplier.Action action) {
        switch (action) {
            case MULTIPLICATION -> {
                return fieldValue * 3;
            }
            case ADDITION -> {
                return fieldValue + fieldValue;
            }
            case SUBTRACTION -> {
                return fieldValue - 1;
            }
        }
        return 0;
    }

    private static Number arithmeticalOperationForLong(Long fieldValue, Multiplier.Action action) {
        switch (action) {
            case MULTIPLICATION -> {
                return fieldValue * 3;
            }
            case ADDITION -> {
                return fieldValue + fieldValue;
            }
            case SUBTRACTION -> {
                return fieldValue - 1;
            }
        }
        return 0;
    }
}
