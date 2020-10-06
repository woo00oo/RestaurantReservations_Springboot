package kr.co.kku.ByeonHyeonWoo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

    List<MenuItem> findAllByRestaurantId(Long restaurantsId);

    void deleteById(Long id);


}
