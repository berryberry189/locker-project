package com.jpa.lendlocker.entity;

import com.jpa.lendlocker.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor // @Builder 사용할때 써줌
public class User implements Persistable<String> {

    @Id
    @Column(name = "user_id", nullable = false)
    private String id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_mobile")
    private String mobile;

    @OneToMany(mappedBy = "user")
    private List<Lend> lends = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdDate;

    @Builder
    public User(String id, String name, String mobile){
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public User update(UserDto dto){
        this.name = dto.getName();
        this.mobile = dto.getMobile();
        return this;
    }


    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
