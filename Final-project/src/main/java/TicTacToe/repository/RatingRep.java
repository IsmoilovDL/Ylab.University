package TicTacToe.repository;

import TicTacToe.model.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRep extends CrudRepository<Rating, Long> {
}
