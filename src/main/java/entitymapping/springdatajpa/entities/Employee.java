package entitymapping.springdatajpa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee_details")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String employeeName;
    private Integer employeeAge;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)//// mappedBy değeri, Address sınıfındaki Employee field'ına atıfta bulunmaktadır.
    @JsonManagedReference // Bu annotation ile sonsuz döngüyü engelliyoruz
    private List<Address> addresses;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                '}';
    }
}
