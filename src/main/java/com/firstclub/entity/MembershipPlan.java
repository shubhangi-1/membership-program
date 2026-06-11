package com.firstclub.entity; 

@Entity
@Table(name = "membership_plan")
public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Monthly, Quarterly, Yearly

    private Double price;

    private Integer validityDays;
}