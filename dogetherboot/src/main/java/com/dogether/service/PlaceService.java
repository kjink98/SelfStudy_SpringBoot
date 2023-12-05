package com.dogether.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogether.domain.Place;
import com.dogether.repository.PlaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<Place> list(String place_category) {
        List<Place> places = placeRepository.getDataAll(place_category);
        return places;
    }

    public Place detail(int place_id) {
        return placeRepository.selectOne(place_id);
    }
}
