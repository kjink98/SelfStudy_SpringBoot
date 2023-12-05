package com.dogether.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dogether.domain.Place;
import com.dogether.mapper.PlaceMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PlaceRepository {

    private final PlaceMapper placeMapper;

    public List<Place> getDataAll(String place_category) {
        List<Place> list = placeMapper.SelectAll(place_category);
        return list;
    }
    
    public Place selectOne(int place_id) {
        return placeMapper.selectOne(place_id);
    }

}
