package game;

public class Player {
    private int id;
    private String name;
    private static int count=0;
    private String symbol;
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

    public void setSymbolWithoutMessage(String symbol){
        this.symbol=symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }


}
