package TicTacToe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating {
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "player_id")
    private int player_id;

    @Column(name = "player_rating")
    private int player_rating;

    /**
     * Конструктор
     */
    public Rating() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getPlayer_rating() {
        return player_rating;
    }

    public void setPlayer_rating(int player_rating) {
        this.player_rating = player_rating;
    }
}
