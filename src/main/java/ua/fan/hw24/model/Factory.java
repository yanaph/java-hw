package ua.fan.hw24.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "factory",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private Set<Device> devices;

    public Factory(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
