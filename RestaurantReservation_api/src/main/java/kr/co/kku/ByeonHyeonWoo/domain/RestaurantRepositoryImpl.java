package kr.co.kku.ByeonHyeonWoo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//레포지토리를 스프링이 관리하게
@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl(){
        restaurants.add(new Restaurant(1004L,"Bob zip","Seoul"));
        restaurants.add(new Restaurant(2020L,"Cyber Food","Seoul"));
    }

    //가게 목록
    @Override
    public List<Restaurant> findAll(){
        return restaurants;
    }
    //가게 상세 목록
   @Override
   public Restaurant findById(Long id){
        return restaurants.stream() //스트림 생성
                .filter(r->r.getId().equals(id)) //중간 연산
                .findFirst()
                .orElse(null); //최종 연산
        //스트림 소멸
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        restaurant.setId(1234L);
        restaurants.add(restaurant);
        return restaurant;
    }
}
