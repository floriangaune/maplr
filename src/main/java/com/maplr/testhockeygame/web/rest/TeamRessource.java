package com.maplr.testhockeygame.web.rest;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.service.contract.ITeamService;
import com.maplr.testhockeygame.web.mapper.PlayerMapper;
import com.maplr.testhockeygame.web.mapper.TeamMapper;
import com.maplr.testhockeygame.web.view.PlayerView;
import com.maplr.testhockeygame.web.view.TeamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * Controller for Tem purposes
 */
@RestController
@RequestMapping("/api/team")
public class TeamRessource {

    private ITeamService teamService;

    @Autowired
    public TeamRessource(ITeamService teamService) {
        this.teamService = teamService;
    }

    /**
     * Find a team for the given year if not exists, create it
     * @param year for search the team
     * @return the team if exists, 404 otherwise
     */
    @GetMapping("/{year}")
    public ResponseEntity<TeamView> findByYear(@PathVariable long year) {
        return ResponseEntity.accepted().body(TeamMapper.INSTANCE.toView(this.teamService.findOrCreateByYear(year)));
    }

    /**
     * Add the given player for the team of the given year
     * @param year of the team
     * @param player to add to the team
     * @return the new added player, or bad request if an error occurs
     */
    @PostMapping("/{year}")
    public ResponseEntity<PlayerView> addPlayerToTeamOfGivenYear(@PathVariable long year, @RequestBody PlayerView player) {
        // Create the player and add to the tema of given year
        Player createdPlayer = this.teamService.createAndAddPlayerToTeamOfYEar(year, PlayerMapper.INSTANCE.toEntity(player));

        // Create response depending of the returned player
        if (createdPlayer == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.created(URI.create("/player")).body(PlayerMapper.INSTANCE.toView(createdPlayer));
        }
    }
}
