package com.maplr.testhockeygame.web.mapper;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.domain.enumeration.PlayerPositionEnum;
import com.maplr.testhockeygame.shared.exception.TechnicalException;
import com.maplr.testhockeygame.shared.logger.MaplrLogger;
import com.maplr.testhockeygame.web.view.PlayerView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
    static MaplrLogger LOGGER = new MaplrLogger(PlayerMapper.class);

    @Mapping(source = "position", target = "position", qualifiedByName = "positionEnumToString")
    @Mapping(source = "lastName", target = "lastname")
    PlayerView toView(Player entity);

    @Mapping(source = "position", target = "position", qualifiedByName = "stringToPositionEnum")
    @Mapping(source = "lastname", target = "lastName")
    Player toEntity(PlayerView view);

    @Named("positionEnumToString")
    default String positionEnumToString(PlayerPositionEnum position) {
        return position.getLabel();
    }

    @Named("stringToPositionEnum")
    default PlayerPositionEnum stringToPositionEnum(String positionEnum) {
        // If the player position isn't recognized, return null to not crash the app. This information is considered as not essential to the application.
        try {
            return PlayerPositionEnum.findByLabel(positionEnum);
        } catch (TechnicalException exception) {
            exception.logIt(LOGGER);
            return null;
        }

    }
}
