package com.market_management.market_management.models.entities;

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

    @OneToMany(
            mappedBy = "local",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Order> orders;
}
