package com.maplr.testhockeygame.service.contract;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.domain.Team;

/**
 * Service handling all hokey player team purposes
 */
public interface ITeamService {
    /**
     * Find a team for the given year
     *
     * @param year to search
     * @return the given team if exists
     */
    Team findOrCreateByYear(long year);

    /**
     * Create a new Hokey player and assign it to the team of the given year
     *
     * @param year
     * @param player
     * @return
     */
    Player createAndAddPlayerToTeamOfYEar(long year, Player player);
}
