package kr.co.kku.ByeonHyeonWoo.domain;

import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class RestaurantTests {

    @Test
    public void creation(){
        //Restaurant restaurant = new Restaurant(1004L,"Bob zip","Seoul");

        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(), is("Seoul"));
        //assertThat(restaurant.getID(), is(equalTo(1004L)));
        //assertThat(restaurant.getName(), is(equalTo("Bob zip")));
        //assertThat(restaurant.getAddress(), is(equalTo("Seoul")));
    }



    @Test
    public void information(){
        //Restaurant restaurant = new Restaurant(1004L,"Bob zip","Seoul");
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        assertThat(restaurant.getInformation(),is("Bob zip in Seoul"));
    }


}