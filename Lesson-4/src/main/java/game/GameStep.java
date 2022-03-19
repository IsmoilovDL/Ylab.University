package game;

//класс используется для сохранение шагов в ArrayList
public class GameStep {
    private static int count=0;
    private int id;
    private int row;
    private int column;
    private String name;
    private int playerId;

    public int getPlayerId() {
        return playerId;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    private String symbol;


    public GameStep(int row, int column, String name, String symbol, int playerId){
        count++;
        this.id=count;
        this.name=name;
        this.symbol=symbol;
        this.column=column;
        this.row=row;
        this.playerId=playerId;
    }

    @Override
    public String toString() {
        return "GameStep{" +
                "id=" + id +
                ", row=" + row +
                ", column=" + column +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }

}
