package TicTacToe.repository;

import TicTacToe.model.StepsHistory;
import org.springframework.data.repository.CrudRepository;

public interface StepsHistoryRep extends CrudRepository<StepsHistory, Integer> {
}
