package kr.co.kku.ByeonHyeonWoo.interfaces;

import kr.co.kku.ByeonHyeonWoo.domain.Restaurant;
import kr.co.kku.ByeonHyeonWoo.domain.RestaurantsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantsRepository repository = new RestaurantsRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list(){

        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = repository.findById(id);

        return restaurant;
    }

}
