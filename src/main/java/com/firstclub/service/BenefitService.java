import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BenefitService {

    private Map<BenefitKey, String> mapBenefits(MembershipTier tier) {
        return tier.getBenefits()
                .stream()
                .collect(Collectors.toMap(
                        TierBenefit::getBenefitKey,
                        TierBenefit::getValue
                ));
    }

    public boolean hasBenefit(MembershipTier tier, BenefitKey key) {
        return mapBenefits(tier).containsKey(key);
    }

    public String getValue(MembershipTier tier, BenefitKey key) {
        return mapBenefits(tier).get(key);
    }
}
