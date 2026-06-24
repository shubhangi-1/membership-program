import jakarta.persistence.*;

@Entity
@Table(name = "tier_benefits")
public class TierBenefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BenefitKey benefitKey;

    private String value; 
    // stored as String so everything is flexible (true, 10, 2 days etc.)

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private MembershipTier tier;

    // getters and setters
}
