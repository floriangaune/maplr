package com.maplr.testhockeygame.web.mapper;

import com.maplr.testhockeygame.domain.Team;
import com.maplr.testhockeygame.web.mapper.shared.EntityMapper;
import com.maplr.testhockeygame.web.view.TeamView;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    TeamView toView(Team entity);
    Team toEntity(TeamView view);
}
