package com.maplr.testhockeygame.domain;

import com.maplr.testhockeygame.domain.enumeration.PlayerPositionEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Player extends MaplrEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long number;
    private String name;
    private String lastName;

    @ManyToOne
    private Team team;

    @Enumerated(EnumType.STRING)
    private PlayerPositionEnum position;
    private boolean isCaptain;

}
