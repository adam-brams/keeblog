package com.keeblog.service;

import com.keeblog.dto.KeyboardBuildRequest;
import com.keeblog.dto.KeyboardBuildResponse;
import com.keeblog.dto.SwitchSpringsRequest;
import com.keeblog.dto.SwitchSpringsResponse;
import com.keeblog.enums.*;
import com.keeblog.model.KeyboardBuild;
import com.keeblog.model.SwitchSpring;
import com.keeblog.model.User;
import com.keeblog.repository.KeyboardBuildRepository;
import com.keeblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeyboardBuildService {

    private final KeyboardBuildRepository buildRepository;
    private final UserRepository userRepository;

    public KeyboardBuildResponse createBuild(KeyboardBuildRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        KeyboardBuild build = new KeyboardBuild();
        build.setAuthor(user);
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

        SwitchSpringsRequest springsReq = request.getSwitchSprings();
        SwitchSpring springs = new SwitchSpring();
        springs.setBrand(springsReq.getBrand());
        springs.setWeight(springsReq.getWeight());
        springs.setLength(springsReq.getLength());
        springs.setSpringLube(springsReq.getSpringLube());
        build.setSwitchSprings(springs);

        KeyboardBuild savedBuild = buildRepository.save(build);
        return mapToResponse(savedBuild);
    }

    public List<KeyboardBuildResponse> getAllBuilds() {
        return buildRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<KeyboardBuildResponse> getBuildsByUser(Long userId) {
        return buildRepository.findAllByAuthorId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private KeyboardBuildResponse mapToResponse(KeyboardBuild build) {
        SwitchSpring springs = build.getSwitchSprings();
        SwitchSpringsResponse springsResponse = new SwitchSpringsResponse();
        springsResponse.setBrand(springs.getBrand());
        springsResponse.setWeight(springs.getWeight());
        springsResponse.setLength(springs.getLength());
        springsResponse.setSpringLube(springs.getSpringLube());

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
}
