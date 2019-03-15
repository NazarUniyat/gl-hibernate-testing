package entity;


import entity.enums.Availability;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Workers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    @Enumerated(EnumType.STRING)
    private Availability availability;
    private String fullName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department departmentId;

}
