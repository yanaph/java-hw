package ua.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String uniName;

    @OneToMany(mappedBy = "university", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<UniversityGroup> universityGroups;

    public University(String uniName) {
        this.uniName = uniName;
    }
}
