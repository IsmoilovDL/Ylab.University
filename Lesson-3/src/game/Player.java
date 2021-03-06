package game;

public class Player {
    private String name;
    private int id;
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
        message(symbol);
        this.symbol=symbol;
    }

    public void setSymbolWithoutMessage(String symbol){
        this.symbol=symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }

    private void message(String symbol){
        System.out.println(this.getName()+ ", добро пожаловать в игру!\n ты играешь "+symbol+"-ом\n");
    }
}
