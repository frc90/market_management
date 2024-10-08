package com.market_management.market_management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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
}
