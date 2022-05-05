package com.maplr.testhockeygame.web.view;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class TeamView extends MaplrView {

    private String coach;
    private long year;
    private Collection<PlayerView> players;
}
