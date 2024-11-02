package com.coworking.reservation_service.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "space_id", nullable = false)
    private Long spaceId;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reservation_date")
    private Date reservationDate;
    private boolean status;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    private String comments;
}
