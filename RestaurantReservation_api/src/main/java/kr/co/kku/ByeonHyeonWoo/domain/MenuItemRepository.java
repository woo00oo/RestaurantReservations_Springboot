package kr.co.kku.ByeonHyeonWoo.domain;

import java.util.List;

public interface MenuItemRepository {

    List<MenuItem> findAllByRestaurantId(Long restaurantsId);


}
