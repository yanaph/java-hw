package ua.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Curator {
    private final static Random RANDOM = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String fullName;
    private LocalDate birthDate;
    private Integer experience;

    @OneToOne
    private UniversityGroup universityGroup;

    public Curator(String fullName) {
        this.fullName = fullName;
        birthDate = generateBirthDate();
        experience = RANDOM.nextInt(25);
    }
    private LocalDate generateBirthDate (){
        long minDay = LocalDate.of(1940, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(1999, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}