package com.coworking.user_membership_service.persistence.entity;

import com.coworking.user_membership_service.util.enums.MembershipStatus;
import com.coworking.user_membership_service.util.enums.MembershipType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "membership_type",nullable = false)
    private MembershipType membershiptype;
    @Column(nullable = false)
    private BigDecimal price;
}
