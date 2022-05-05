package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Long> {

    /**
     * Find a team for a given year
     * @param year to search
     * @return a Team of the given year if exists
     */
    Team findByYear(long year);
}
