package TicTacToe.model;

import javax.persistence.*;

@Entity
@Table(name = "RATING")
public class Rating {
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

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


    public int getPlayer_rating() {
        return player_rating;
    }

    public void setPlayer_rating(int player_rating) {
        this.player_rating = player_rating;
    }



//    @OneToOne(mappedBy="rating", cascade = CascadeType.ALL)
//    public Player player;
//
//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }

}
