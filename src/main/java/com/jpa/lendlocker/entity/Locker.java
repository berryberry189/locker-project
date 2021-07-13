package com.jpa.lendlocker.entity;

import com.jpa.lendlocker.dto.LockerRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Locker {

    @MapsId("areaId")
    @ManyToOne
    @JoinColumn(name = "area_id")
    private LockerArea area;

    @EmbeddedId // 복합키일 경우 @GeneratedValue 기본키 생성 불가능
    private LockerId lockerId;

    @Column(name = "locker_type")
    @Enumerated(EnumType.STRING)
    private LockerType type;

    @Column(name = "locker_price")
    private int price;

    private String useYn;

    @Builder
    public Locker(LockerArea area, LockerId lockerId, LockerType type, int price, String useYn){
        this.lockerId = lockerId;
        this.type = type;
        this.price = price;
        this.useYn = useYn;

        if(area != null) changeLockerArea(area);
    }

    public void changeLockerArea(LockerArea area){
        this.area = area;
    }

    public Locker update(LockerRequestDto requestDto) {
        this.type = requestDto.getType();
        this.price = requestDto.getPrice();
        return this;
    }
}
