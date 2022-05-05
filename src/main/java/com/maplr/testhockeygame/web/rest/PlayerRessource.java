package com.maplr.testhockeygame.web.rest;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.service.PlayerService;
import com.maplr.testhockeygame.web.mapper.PlayerMapper;
import com.maplr.testhockeygame.web.view.PlayerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
public class PlayerRessource {

    private PlayerService playerService;

    @Autowired
    public PlayerRessource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PutMapping("/captain/{id}")
    public ResponseEntity<PlayerView> promoteCaptain(@PathVariable long id) {
        Player promotedPlayer = this.playerService.promoteCaptain(id);
        if (promotedPlayer == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(PlayerMapper.INSTANCE.toView(promotedPlayer));
        }
    }
}
