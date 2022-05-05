package com.maplr.testhockeygame.service.impl;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.repository.IPlayerRepository;
import com.maplr.testhockeygame.service.contract.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service handling all player purposes
 */
@Service
public class PlayerService implements IPlayerService {

    private IPlayerRepository playerRepository;

    @Autowired
    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Promote a hokey player (represented by the id) as captain
     * @param id of the player to promote
     * @return the player promoted
     */
    @Override
    public Player promoteCaptain(long id) {
        Player searchPlayer = this.playerRepository.getById(id);

        // Ensure that the player exists before promote
        if (searchPlayer != null) {
            searchPlayer.setCaptain(true);
            this.playerRepository.save(searchPlayer);
        }

        return searchPlayer;
    }

    /**
     * Create a new Player
     * @param player to create
     * @return the created player
     */
    @Override
    public Player createPlayer(Player player) {
        return this.playerRepository.save(player);
    }
}
