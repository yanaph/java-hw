package ua.fan.hw21.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Multiplier {
    enum Action {MULTIPLICATION, ADDITION, SUBTRACTION}
    Action action() default Action.SUBTRACTION;
}
