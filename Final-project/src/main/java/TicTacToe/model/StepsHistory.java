package TicTacToe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "STEPS")
public class StepsHistory {
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "position_row")
    private int position_row;

    @Column(name = "position_col")
    private int position_col;

    @Column(name = "step_number")
    private int step_number;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "player_id")
    private int player_id;

}
