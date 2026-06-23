package com.firstclub.entity; 

 package com.example.membership.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "membership_plan")
public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Monthly, Quarterly, Yearly

    private Double price;

     private Integer durationInDays;

    private Integer validityDays;

    private BigDecimal price;

   


public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // MONTHLY, QUARTERLY, YEARLY

    private Integer durationInDays;

    private BigDecimal price;

    private Boolean active;
}
}
