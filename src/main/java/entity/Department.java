package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@ToString(exclude = {"workers"})
public class Department {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idDepartment;
    private String name;
    private boolean status;
    @OneToMany(fetch = FetchType.LAZY
            ,mappedBy = "departmentId"
            ,cascade = {CascadeType.REMOVE})
    private List<Workers> workers;

}



