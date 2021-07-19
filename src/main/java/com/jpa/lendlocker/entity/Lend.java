package com.jpa.lendlocker.entity;

import com.jpa.lendlocker.dto.LendRequestDto;
import com.jpa.lendlocker.enums.LendStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Lend {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lend_id")
    private Long id;

    // 연관관계 주인
    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "user_key" )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
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
    @Enumerated(EnumType.STRING)
    private LendStatus status;

    @Column(name = "lend_date")
    private LocalDateTime lendDate;


    // 연관관계 편의 메소드
    public void setUser(User user){
        this.user = user;
        user.getLends().add(this);
    }

    @Builder
    public Lend(int hour, int price, LendStatus status){
        this.hour = hour;
        this.price = price;
        this.status = status;
    }

    // 대여할 때 무조건 생성
    public static Lend lend(User user, Locker locker, LendRequestDto lendRequestDto){
        Lend lend = new Lend();
        lend.setUser(user);
        locker.setUseYn("Y");
        lend.setLocker(locker);
        lend.setHour(lendRequestDto.getHour());
        lend.setPrice(lendRequestDto.getPrice());
        lend.setStatus(LendStatus.LEND);
        lend.setLendDate(LocalDateTime.now());
        return lend;
    }

    // 반납할때 무조건 생성
    public Lend returnLend(Long id, Locker locker) {
        this.id = id;
        this.status = LendStatus.RETURN;
        locker.setUseYn("N");
        this.locker = locker;
        return this;
    }

}
