package com.maplr.testhockeygame.web.rest;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.domain.Team;
import com.maplr.testhockeygame.service.TeamService;
import com.maplr.testhockeygame.web.mapper.PlayerMapper;
import com.maplr.testhockeygame.web.mapper.TeamMapper;
import com.maplr.testhockeygame.web.view.PlayerView;
import com.maplr.testhockeygame.web.view.TeamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/team")
public class TeamRessource {

    private TeamService teamService;

    @Autowired
    public TeamRessource(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{year}")
    public ResponseEntity<TeamView> findByYear(@PathVariable long year) {
        Team searchedTeam = this.teamService.findByYear(year);
        if (searchedTeam == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(TeamMapper.INSTANCE.toView(searchedTeam));
        }
    }

    @PostMapping("/{year}")
    public ResponseEntity<PlayerView> addPlayerToTeamOfGivenYear(@PathVariable long year, @RequestBody PlayerView player) {
        Player createdPlayer = this.teamService.createAndAddPlayerToTeamOfYEar(year, PlayerMapper.INSTANCE.toEntity(player));
        if (createdPlayer == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.created(URI.create("/player")).body(PlayerMapper.INSTANCE.toView(createdPlayer));
        }
    }
}
