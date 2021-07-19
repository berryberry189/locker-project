package com.jpa.lendlocker.entity;

import com.jpa.lendlocker.dto.LockerUpdateRequestDto;
import com.jpa.lendlocker.enums.LockerType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Locker {

    @MapsId("areaId")
    @ManyToOne(fetch = FetchType.LAZY)
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

    @OneToMany(mappedBy = "locker", cascade= CascadeType.ALL)
    private List<Lend> lends = new ArrayList<>();

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

    public Locker update(LockerUpdateRequestDto lockerUpdateRequestDto) {
        this.type = lockerUpdateRequestDto.getType();
        this.price = lockerUpdateRequestDto.getPrice();
        this.useYn = lockerUpdateRequestDto.getUseYn();
        return this;
    }

}
