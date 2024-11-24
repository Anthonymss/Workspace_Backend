package com.coworking.membership_service.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "user_membership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id",nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name="membership_id",nullable = false)
    private Membership membership;
    @Column(name="start_date",nullable = false)
    private Date startDate;
    @Column(name="end_date",nullable = false)
    private Date endDate;
}
