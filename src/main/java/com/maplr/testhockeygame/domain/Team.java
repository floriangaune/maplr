package com.maplr.testhockeygame.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;

/**
 * A team represents a group of hokey player for a given year
 */
@Getter
@Setter
@Entity
public class Team extends MaplrEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String coach;
    private long year;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Collection<Player> players;
}
