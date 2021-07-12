package com.jpa.lendlocker.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
public class User {

    @Id @Column(name = "user_id")
    private String id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_mobile")
    private String mobile;

    @OneToMany(mappedBy = "user")
    private List<Lend> lends = new ArrayList<>();




}
