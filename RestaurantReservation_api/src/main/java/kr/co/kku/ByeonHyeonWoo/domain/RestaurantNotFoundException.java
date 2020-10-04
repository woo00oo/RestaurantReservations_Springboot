package kr.co.kku.ByeonHyeonWoo.domain;




public class RestaurantNotFoundException extends RuntimeException{

    public RestaurantNotFoundException(long id) {
        super("Could not find restaurant: " + id);
    }
}
