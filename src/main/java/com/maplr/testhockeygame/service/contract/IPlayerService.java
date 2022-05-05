package com.maplr.testhockeygame.service.contract;

import com.maplr.testhockeygame.domain.Player;

/**
 * Service handling all player purposes
 */
public interface IPlayerService {
    /**
     * Promote a hokey player (represented by the id) as captain
     *
     * @param id of the player to promote
     * @return the player promoted
     */
    Player promoteCaptain(long id);

    /**
     * Create a new Player
     *
     * @param player to create
     * @return the created player
     */
    Player createPlayer(Player player);
}
