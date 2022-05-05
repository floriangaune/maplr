package com.maplr.testhockeygame.service.impl;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.domain.Team;
import com.maplr.testhockeygame.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service handling all hokey player team purposes
 */
@Service
public class TeamService implements com.maplr.testhockeygame.service.contract.ITeamService {

    private ITeamRepository teamRepository;
    private PlayerService playerService;

    @Autowired
    public TeamService(ITeamRepository teamRepository, PlayerService playerService) {
        this.teamRepository = teamRepository;
        this.playerService = playerService;
    }

    /**
     * Find a team for the given year
     * @param year to search
     * @return the given team if exists
     */
    @Override
    public Team findByYear(long year) {
        return this.teamRepository.findByYear(year);
    }

    /**
     * Create a new Hokey player and assign it to the team of the given year
     * @param year
     * @param player
     * @return
     */
    @Override
    public Player createAndAddPlayerToTeamOfYEar(long year, Player player) {
        // Search or create the team
        Team team = this.findOrCreateTeamIfNecessary(year);

        // Create the new player and set the team
        player = this.playerService.createPlayer(player);
        player.setTeam(team);

        // Create and return the player in the team
        return this.playerService.createPlayer(player);
    }

    /**
     * Find a team by year, and if it not exists, create it
     * @param year to search or create
     * @return the existing team, or the new team
     */
    private Team findOrCreateTeamIfNecessary(long year) {
        Team searchedTeam = this.findByYear(year);

        if (searchedTeam == null) {
            Team newTeam = new Team();
            newTeam.setYear(year);
            return this.teamRepository.save(newTeam);
        }

        return searchedTeam;
    }
}
