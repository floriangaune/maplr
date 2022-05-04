package com.maplr.testhockeygame.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Getter
@Setter
public class Team extends MaplrEntity {

    @Id
    private long id;
    private String coach;
    private long year;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Collection<Player> players;
}
