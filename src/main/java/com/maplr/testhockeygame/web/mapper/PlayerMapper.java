package com.maplr.testhockeygame.web.mapper;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.web.mapper.shared.EntityMapper;
import com.maplr.testhockeygame.web.view.PlayerView;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper extends EntityMapper<Player, PlayerView> {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
}
