package ua.fan.action;

import lombok.Getter;

@Getter
public enum ActionType {
    GROUP_BY_NAME ("Find group by name"),
    STUDENT_AMOUNT_IN_EACH_GROUP ("Get student amount in each group"),
    AVG_GRADE_FOR_EACH_GROUP ("Get avg grade of each group"),
    PROFESSOR_BY_NAME ("Find professor by name"),
    MAX_MIN_AVG_GRADE_DISCIPLINE ("Get discipline with max and min avg grade"),
    STUDENT_WITH_AVG_GRADE_GREATER_THAN ("Student with avg grade greater than ..."),
    EXIT ("Exit");

    private final String name;
    ActionType(String name) {
        this.name = name;
    }
}
