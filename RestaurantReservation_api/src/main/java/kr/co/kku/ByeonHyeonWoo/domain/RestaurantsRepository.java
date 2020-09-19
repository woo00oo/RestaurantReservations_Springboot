package kr.co.kku.ByeonHyeonWoo.domain;

import java.util.List;

public interface RestaurantsRepository {
    //가게 목록
    List<Restaurant> findAll();

    //가게 상세 목록
    Restaurant findById(Long id);
}
