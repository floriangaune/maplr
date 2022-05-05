package com.maplr.testhockeygame.web.view;

import lombok.Getter;
import lombok.Setter;
import java.util.Collection;

/**
 * A team represents a group of hokey player for a given year
 */
@Getter
@Setter
public class TeamView extends MaplrView {

    private String coach;
    private long year;
    private Collection<PlayerView> players;
}
