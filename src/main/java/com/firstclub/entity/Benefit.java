package com.firstclub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "benefits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Benefit {

    private boolean freeDelivery;
    private double extraDiscountPercent;
    private boolean prioritySupport;
    private boolean exclusiveCoupons;

    public Benefit(boolean freeDelivery,
                   double extraDiscountPercent,
                   boolean prioritySupport,
                   boolean exclusiveCoupons) {
        this.freeDelivery = freeDelivery;
        this.extraDiscountPercent = extraDiscountPercent;
        this.prioritySupport = prioritySupport;
        this.exclusiveCoupons = exclusiveCoupons;
    }

    public boolean isFreeDelivery() {
        return freeDelivery;
    }

    public double getExtraDiscountPercent() {
        return extraDiscountPercent;
    }

    public boolean isPrioritySupport() {
        return prioritySupport;
    }

    public boolean isExclusiveCoupons() {
        return exclusiveCoupons;
    }

    @Override
    public String toString() {
        return "Benefit{" +
                "freeDelivery=" + freeDelivery +
                ", extraDiscountPercent=" + extraDiscountPercent +
                ", prioritySupport=" + prioritySupport +
                ", exclusiveCoupons=" + exclusiveCoupons +
                '}';
    }
}
