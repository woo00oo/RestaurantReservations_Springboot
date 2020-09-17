package kr.co.kku.ByeonHyeonWoo.domain;

import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {

    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant("test","");
        assertThat(restaurant.getName(), is(equalTo("test")));
    }



    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("test","test02");
        assertThat(restaurant.getInformation(),is("test in test02"));
    }
    //Commit test

}