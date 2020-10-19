package kr.co.kku.ByeonHyeonWoo.domain;



import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;



public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    //가게 목록
    List<Restaurant> findAll();

//    메서드 이름에서 쿼리 생성
    List<Restaurant> findAllByAddressContaining(String region);

    List<Restaurant> findAllByAddressContainingAndCategoryId(String region, Long categoryId);

    //가게 상세 목록
    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);


}
