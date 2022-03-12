package game;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру!");
        Scanner scannner=new Scanner(System.in);

        Player player1=new Player();
        Player player2=new Player();

        System.out.println("Введите имя первого игрока");
        String player1Name=scannner.nextLine();
        player1.setName(player1Name);
        player1.setSymbol("X");

        System.out.println("Введите имя второго игрока");
        String player2Name=scannner.nextLine();
        player2.setName(player2Name);
        player1.setSymbol("0");

        gameTable game =new gameTable();
        game.newGame();
        System.out.println(game.getTableXO());

        playerRating rating=new playerRating();
        while (true){
            System.out.println(player1.getName()+ " введи номер строки от 1 до 3");
            int row=scannner.nextInt();
            System.out.println(player1.getName()+ " введи номер столбца от 1 до 3");
            int column=scannner.nextInt();
            game.setPosition(row-1,column-1, "X");
            System.out.println(game.getTableXO());

            if(game.searchWinner("X")){
                System.out.println("Победил игрок "+ player1.getName());
                rating.saveReting(player1.getName());
                System.out.println("Рейтинг игроков:");
                System.out.println(rating.showRating()+"\n");

                System.out.println("Хотите продолжать игру? 0-да 1-нет");
                int answer=scannner.nextInt();
                if(answer==0){
                    game.newGame();
                    System.out.println(game.getTableXO());
                    continue;
                }
                else if (answer==1){
                    break;
                }
            }

            System.out.println(player2.getName()+ " введи номер строки от 1 до 3");
            int row2=scannner.nextInt();
            System.out.println(player2.getName()+ " введи номер столбца от 1 до 3");
            int column2=scannner.nextInt();
            game.setPosition(row2-1,column2-1, "0");
            System.out.println(game.getTableXO());
            if(game.searchWinner("0")){
                System.out.println("Победил игрок "+ player2.getName());

                rating.saveReting(player2.getName());
                System.out.println("Рейтинг игроков:");
                System.out.println(rating.showRating()+"\n");

                System.out.println("Хотите продолжать игру? 0-да 1-нет");
                int answer=scannner.nextInt();
                if(answer==0){
                    game.newGame();
                    System.out.println(game.getTableXO());
                    continue;
                }
                else if (answer==1){
                    break;
                }
            }
        }


        scannner.close();
    }
}
