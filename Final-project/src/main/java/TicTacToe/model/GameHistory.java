package TicTacToe.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "HISTORY")
public class GameHistory {
    public GameHistory(){}

    @Expose
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Expose
    @Column(name = "player_1")
    private String player1;

    @Expose
    @Column(name = "player_2")
    private String player2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public Collection<StepsHistory> getStepsHistories() {
        return stepsHistories;
    }

    public void setStepsHistories(Collection<StepsHistory> stepsHistories) {
        this.stepsHistories = stepsHistories;
    }

    @Expose
    @OneToMany(mappedBy = "primaryGame", cascade = CascadeType.ALL)
    private Collection<StepsHistory> stepsHistories;
}
