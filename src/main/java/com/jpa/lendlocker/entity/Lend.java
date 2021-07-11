package com.jpa.lendlocker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.jpa.lendlocker.entity.User;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter @Setter
@NoArgsConstructor(access = PROTECTED)
public class Lend {

    @Id
    @Column(name = "lend_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = LAZY)
    @JoinColumns({
            @JoinColumn(name="area_id"),
            @JoinColumn(name="locker_no")
    })
    private Locker locker;

    @Column(name = "lend_hour")
    private int hour;

    @Column(name = "lend_price")
    private int price;

    @Column(name = "lend_status")
    private LendStatus status;

    @Column(name = "lend_date")
    private LocalDateTime lendDate;


}
