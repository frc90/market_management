package com.market_management.market_management.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address {
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "customer_city")
//            ),
//            @AttributeOverride(
//                    name = "mainStreet",
//                    column = @Column(name = "customer_main_street")
//            ),
//            @AttributeOverride(
//                    name = "secondaryStreet",
//                    column = @Column(name = "customer_secondary_street")
//            )
//    })

    private String city;
    @JsonProperty("main_street")
    private String mainStreet;
    @JsonProperty("secundary_street")
    private String secondaryStreet;

}
