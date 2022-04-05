package TicTacToe.model;


import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "PLAYER")
public class Player {

    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @Expose
    private int id;

    @Expose
    @Column(name = "name")
    private String name;

    @Expose
    @Transient
    private String symbol;


    public Player(){}

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setSymbol(String symbol){
        this.symbol=symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }

    @Expose
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rating_id")
    private Rating rating;

    public Rating getRating() {
        return rating;
    }


    public void setRating(Rating rating) {
        this.rating = rating;
    }


}
