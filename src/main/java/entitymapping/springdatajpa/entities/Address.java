package entitymapping.springdatajpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

    private String city;
    private String addressType;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    @JsonBackReference
    private Employee employee;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", addressType='" + addressType + '\'' +
                '}';
    }
}
