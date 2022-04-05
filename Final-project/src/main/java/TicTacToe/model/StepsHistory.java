package TicTacToe.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "STEPS")
public class StepsHistory {
    @Expose
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Expose
    @Column(name = "position_row")
    private int position_row;

    @Expose
    @Column(name = "position_col")
    private int position_col;

    @Expose
    @Column(name = "step_number")
    private int step_number;

    @Expose
    @Column(name = "symbol")
    private String symbol;

    @Expose
    @Column(name = "player_id")
    private int player_id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_ID")
    private GameHistory primaryGame;

    public GameHistory getPrimaryGame() {
        return primaryGame;
    }

    public void setPrimaryGame(GameHistory primaryGame) {
        this.primaryGame = primaryGame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition_row() {
        return position_row;
    }

    public void setPosition_row(int position_row) {
        this.position_row = position_row;
    }

    public int getPosition_col() {
        return position_col;
    }

    public void setPosition_col(int position_col) {
        this.position_col = position_col;
    }

    public int getStep_number() {
        return step_number;
    }

    public void setStep_number(int step_number) {
        this.step_number = step_number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }
}
