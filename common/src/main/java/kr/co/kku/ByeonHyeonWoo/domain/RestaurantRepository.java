package kr.co.kku.ByeonHyeonWoo.domain;



import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    //가게 목록
    List<Restaurant> findAll();

    List<Restaurant> findAllByAddressContaining(String region);

    //가게 상세 목록
    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);
}
