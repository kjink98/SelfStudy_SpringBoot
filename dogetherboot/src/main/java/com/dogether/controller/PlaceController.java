package com.dogether.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogether.domain.Place;
import com.dogether.domain.Review;
import com.dogether.service.PlaceService;
import com.dogether.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final ReviewService reviewService;

    // 완성
    @GetMapping("/place_list")
    public List<Place> getPlaceList(String place_category, Model model) {
        List<Place> places = placeService.list(place_category);
        // model.addAttribute("places", places);

        // 테스트용 조건문
        if (!places.isEmpty()) {
            // 인덱스 0의 place_name 출력. 정상
            System.out.println(places.get(0).getPlace_name());
        } else {
            System.out.println("place is null");
        }
        return places;
    }

    // 완성
    @GetMapping("/place_detail")
    public Place getPlaceDetail(int place_id, Model model) {
        Place place = placeService.detail(place_id);
        List<Review> reviews = reviewService.list(place_id);
        model.addAttribute("reviews", reviews);
        model.addAttribute("place", place);

        // 테스트용 출력 : place id : place_name 출력. 정상
        System.out.println(place.getPlace_id() + " : " + place.getPlace_name());
        if (!reviews.isEmpty()) {
            for (Review review : reviews) {
                System.out.println(review.getReview_title());
            }
        } else {
            System.out.println("review is null");
        }
        return place;
    }
}
