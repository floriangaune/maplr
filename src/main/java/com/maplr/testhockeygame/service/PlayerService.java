package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private IPlayerRepository playerRepository;

    @Autowired
    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player promoteCaptain(long id) {
        Player searchPlayer = this.playerRepository.getById(id);

        if (searchPlayer != null) {
            searchPlayer.setCaptain(true);
            this.playerRepository.save(searchPlayer);
        }

        return searchPlayer;
    }

    /**
     * Create a new Player
     * @param player
     * @return
     */
    public Player createPlayer(Player player) {
        return this.playerRepository.save(player);
    }
}
