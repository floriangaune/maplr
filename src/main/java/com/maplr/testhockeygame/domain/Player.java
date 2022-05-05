package com.maplr.testhockeygame.domain;

import com.maplr.testhockeygame.domain.enumeration.PlayerPositionEnum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * Player represents a hokey player with its own data.
 */
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
    private boolean isCaptain;

    @ManyToOne
    private Team team;

    @Enumerated(EnumType.STRING)
    private PlayerPositionEnum position;
}
