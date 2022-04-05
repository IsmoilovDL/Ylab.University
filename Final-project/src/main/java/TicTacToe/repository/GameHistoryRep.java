package TicTacToe.repository;

import TicTacToe.model.GameHistory;
import org.springframework.data.repository.CrudRepository;

public interface GameHistoryRep extends CrudRepository<GameHistory, Integer> {
}
