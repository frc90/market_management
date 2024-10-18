package com.market_management.market_management.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString(exclude = "manager")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please add the local name.")
    private String name;

    @NotBlank(message = "Please add the floor.")
    @Length(max = 10)
    private String floor;

    @NotBlank(message = "Please add the code.")
    @Length(min = 4, max = 15)
    private String code;

    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "id"
    )
    @ToString.Exclude
    private Manager manager;

    @OneToMany(
            mappedBy = "local",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Order> orders;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "local_customer_map",
            joinColumns = @JoinColumn(
                    name = "local_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "customer_id",
                    referencedColumnName = "id"
            )
    )
    private List<Customer> customers;
}
