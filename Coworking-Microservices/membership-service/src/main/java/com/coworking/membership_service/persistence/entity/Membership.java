package com.coworking.membership_service.persistence.entity;

import com.coworking.membership_service.util.MembershipType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    private String name;
    private String description;
    private Double price;
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private MembershipType type;

    @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL)
    private List<UserMembership> userMemberships;
}
