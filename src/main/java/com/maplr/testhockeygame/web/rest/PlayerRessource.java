package com.maplr.testhockeygame.web.rest;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.service.contract.IPlayerService;
import com.maplr.testhockeygame.web.mapper.PlayerMapper;
import com.maplr.testhockeygame.web.view.PlayerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for player purposes
 */
@RestController
@RequestMapping("/api/player")
public class PlayerRessource {

    private IPlayerService playerService;

    @Autowired
    public PlayerRessource(IPlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Promote the hokey player related tio the given id as captain
     * @param id of the hokey player to promote
     * @return the promoted player if exists, 404 if unknown player
     */
    @PutMapping("/captain/{id}")
    public ResponseEntity<PlayerView> promoteCaptain(@PathVariable long id) {
        // Promoting player
        Player promotedPlayer = this.playerService.promoteCaptain(id);

        // Verification of the returned player to create the response
        if (promotedPlayer == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(PlayerMapper.INSTANCE.toView(promotedPlayer));
        }
    }
}
