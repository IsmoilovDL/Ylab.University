package TicTacToe.sevices.player;

public class Player {
    private int id=0;
    private String name;
    private String symbol;
    private static int  count=0;
    public Player(){
        count++;
        setId();
    }

    private void setId(){
            this.id=count;
    }
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
