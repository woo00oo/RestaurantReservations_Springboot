package kr.co.kku.ByeonHyeonWoo.domain;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Long> {

    Review save(Review review);

}
