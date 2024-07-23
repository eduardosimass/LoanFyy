package simas.dev.LoanFyy.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "costumer")
@NoArgsConstructor
@AllArgsConstructor
public class Costumers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age ;
    private String cpf ;
    private String name;
    private Double income;
    private String Location;
}
