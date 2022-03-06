package game;

public class gameTable {
    private String[][] tableXO=new String[3][3];


    public gameTable(){
        tableXO[0][0]="*";
        tableXO[0][1]="*";
        tableXO[0][2]="*";

        tableXO[1][0]="*";
        tableXO[1][1]="*";
        tableXO[1][2]="*";

        tableXO[2][0]="*";
        tableXO[2][1]="*";
        tableXO[2][2]="*";
    }

    public String getTableXO() {
        String gameTable=tableXO[0][0]+"|"+tableXO[0][1]+"|"+tableXO[0][2]+"\n"+"- - -\n"
                        +tableXO[1][0]+"|"+tableXO[1][1]+"|"+tableXO[1][2]+"\n"+"- - -\n"+
                        tableXO[2][0]+"|"+tableXO[2][1]+"|"+tableXO[2][2];
        return gameTable;
    }

   public void setPosition(int row, int column, String value){
        tableXO[row][column]=value;
   }

   public boolean searchWinner(String s){
        if(s.equals(tableXO[0][0]) && s.equals(tableXO[0][1]) && s.equals(tableXO[0][2])) {
            return true;
        }
       if(s.equals(tableXO[1][0]) && s.equals(tableXO[1][1]) && s.equals(tableXO[1][2])) {
           return true;
       }
       if(s.equals(tableXO[2][0]) && s.equals(tableXO[2][1]) && s.equals(tableXO[2][2])) {
           return true;
       }

       if(s.equals(tableXO[0][0]) && s.equals(tableXO[1][0]) && s.equals(tableXO[2][0])) {
           return true;
       }
       if(s.equals(tableXO[0][1]) && s.equals(tableXO[1][1]) && s.equals(tableXO[2][1])) {
           return true;
       }
       if(s.equals(tableXO[0][2]) && s.equals(tableXO[1][2]) && s.equals(tableXO[2][2])) {
           return true;
       }
       if(s.equals(tableXO[0][0]) && s.equals(tableXO[1][1]) && s.equals(tableXO[2][2])) {
           return true;
       }
       if(s.equals(tableXO[0][2]) && s.equals(tableXO[1][1]) && s.equals(tableXO[2][0])) {
           return true;
       }
            return false;

   }
}
