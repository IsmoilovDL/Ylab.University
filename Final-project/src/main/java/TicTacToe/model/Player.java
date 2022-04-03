package TicTacToe.model;

import javax.persistence.*;

@Entity
@Table(name = "PLAYER")
public class Player {

    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

//    @Transient
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


}
