package ua.fan.hw26.entity;

import com.mongodb.lang.NonNull;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
public class Customer {
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private Integer age;
    private String status;

    public Customer(@NonNull String firstName, @NonNull String lastName, Integer age, String status) {
        id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
    }
}
