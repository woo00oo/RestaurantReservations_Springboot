package kr.co.kku.ByeonHyeonWoo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantsRepository(){
        restaurants.add(new Restaurant(1004L,"Bob zip","Seoul"));
        restaurants.add(new Restaurant(2020L,"Cyber Food","Seoul"));
    }

    public List<Restaurant> findAll(){
        return restaurants;
    }

    public Restaurant findById(Long id){
        return restaurants.stream() //스트림 생성
                .filter(r->r.getID().equals(id)) //중간 연산
                .findFirst()
                .orElse(null); //최종 연산
        //스트림 소멸
    }
}
