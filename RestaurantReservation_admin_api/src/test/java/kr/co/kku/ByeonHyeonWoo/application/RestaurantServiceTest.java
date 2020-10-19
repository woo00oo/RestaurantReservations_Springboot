package kr.co.kku.ByeonHyeonWoo.application;

import kr.co.kku.ByeonHyeonWoo.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class RestaurantServiceTest {

    private RestaurantService restaurantService;
    @Mock
    private RestaurantRepository restaurantRepository;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mockRestaurantRepository();

        restaurantService = new RestaurantService(restaurantRepository);
    }


    private void mockRestaurantRepository(){
        List<Restaurant> restaurants = new ArrayList<>();
        //Restaurant restaurant = new Restaurant(1004L,"Bob zip","Seoul"); 멤버 변수가 추가 될 경우 새롭게 생성자를 만들어줘야하는 번거러움이 덜해짐.
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .categoryId(1L)
                .name("Bob zip")
                .address("Seoul")
                // .menuItems(new ArrayList<MenuItem>())
                .build();
        restaurants.add(restaurant);

        given(restaurantRepository.findAll()).willReturn(restaurants);

        given(restaurantRepository.findById(1004L)).willReturn(java.util.Optional.of(restaurant));
    }


    @Test
    public void getRestaurants(){

        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId(),is(1004L));
    }

    @Test
    public void getRestaurantWithExisted(){

        Restaurant restaurant = restaurantService.getRestaurant(1004L);


        assertThat(restaurant.getId(), is(1004L));

    }

    @Test
    public void getRestaurantWithNotExisted(){
        Assertions.assertThrows(RestaurantNotFoundException.class ,() -> restaurantService.getRestaurant(404L));
        //Restaurant restaurant = restaurantService.getRestaurant(404L);
    }

    @Test
    public void addRestaurant(){
        given(restaurantRepository.save(any())).will(invocation -> {
            Restaurant restaurant = invocation.getArgument(0);
            restaurant.setId(1234L);
            return restaurant;
        });

        //Restaurant restaurant = new Restaurant("BeRyong","Busan");
        Restaurant restaurant = Restaurant.builder()
                .name("BeRyong")
                .address("Busan")
                .build();

        Restaurant created = restaurantService.addRestaurant(restaurant);

        assertThat(created.getId(),is(1234L));
    }

    @Test
    public void updateRestaurant(){

        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();


        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));

        restaurantService.updateRestaurant(1004L,"Sool zip","Busan");

        assertThat(restaurant.getName(),is("Sool zip"));
        assertThat(restaurant.getAddress(),is("Busan"));
    }


}