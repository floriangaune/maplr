package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Long> {

    Team findByYear(long year);
}
