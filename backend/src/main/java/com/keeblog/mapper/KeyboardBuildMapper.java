package com.keeblog.mapper;

import com.keeblog.dto.*;
import com.keeblog.model.*;

public class KeyboardBuildMapper {

    public static KeyboardBuildResponse toResponse(KeyboardBuild build) {
        if (build == null) return null;

        SwitchSpring springs = build.getSwitchSprings();
        SwitchSpringsResponse springsResponse = null;
        if (springs != null) {
            springsResponse = new SwitchSpringsResponse();
            springsResponse.setBrand(springs.getBrand());
            springsResponse.setWeight(springs.getWeight());
            springsResponse.setLength(springs.getLength());
            springsResponse.setSpringLube(springs.getSpringLube());
        }

        KeyboardBuildResponse response = new KeyboardBuildResponse();
        response.setId(build.getId());
        response.setAuthorId(build.getAuthor().getId());
        response.setBuildNickname(build.getBuildNickname());
        response.setKeyboardName(build.getKeyboardName());
        response.setIsPlateless(build.getIsPlateless());
        response.setPlateMaterial(build.getPlateMaterial());
        response.setPlateHasFlexCuts(build.getPlateHasFlexCuts());
        response.setPcbThickness(build.getPcbThickness());
        response.setPcbHasFlexCuts(build.getPcbHasFlexCuts());
        response.setSwitches(build.getSwitches());
        response.setSwitchLube(build.getSwitchLube());
        response.setSwitchSprings(springsResponse);
        response.setSwitchFilms(build.getSwitchFilms());
        response.setStabilizers(build.getStabilizers());
        response.setStabilizerLube(build.getStabilizerLube());
        response.setKeycapSet(build.getKeycapSet());
        response.setArtisanKeycaps(build.getArtisanKeycaps());

        return response;
    }

    public static KeyboardBuild toEntity(KeyboardBuildRequest request) {
        if (request == null) return null;

        KeyboardBuild build = new KeyboardBuild();
        build.setBuildNickname(request.getBuildNickname());
        build.setKeyboardName(request.getKeyboardName());
        build.setIsPlateless(request.getIsPlateless());
        build.setPlateMaterial(request.getPlateMaterial());
        build.setPlateHasFlexCuts(request.getPlateHasFlexCuts());
        build.setPcbThickness(request.getPcbThickness());
        build.setPcbHasFlexCuts(request.getPcbHasFlexCuts());
        build.setSwitches(request.getSwitches());
        build.setSwitchLube(request.getSwitchLube());
        build.setSwitchFilms(request.getSwitchFilms());
        build.setStabilizers(request.getStabilizers());
        build.setStabilizerLube(request.getStabilizerLube());
        build.setKeycapSet(request.getKeycapSet());
        build.setArtisanKeycaps(request.getArtisanKeycaps());

        if (request.getSwitchSprings() != null) {
            SwitchSpring springs = new SwitchSpring();
            springs.setBrand(request.getSwitchSprings().getBrand());
            springs.setWeight(request.getSwitchSprings().getWeight());
            springs.setLength(request.getSwitchSprings().getLength());
            springs.setSpringLube(request.getSwitchSprings().getSpringLube());
            build.setSwitchSprings(springs);
        }

        return build;
    }
}
