package TicTacToe.repository;

import TicTacToe.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRep extends CrudRepository<Player, Long> {
}
