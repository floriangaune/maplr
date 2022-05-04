package com.maplr.testhockeygame.web.mapper;

import com.maplr.testhockeygame.domain.Team;
import com.maplr.testhockeygame.web.mapper.shared.EntityMapper;
import com.maplr.testhockeygame.web.view.TeamView;
import org.mapstruct.factory.Mappers;

public interface TeamMapper extends EntityMapper<Team, TeamView> {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
}
