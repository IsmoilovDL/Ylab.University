package game;

import game.resultIO.WriteResult;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру!");
        Scanner scannner=new Scanner(System.in);

        //Создаем первого игрока
        Player player1=new Player();
        System.out.println("Введите имя первого игрока");
        String player1Name=scannner.nextLine();
        player1.setName(player1Name);
        player1.setSymbol("X");

        //Создаем второго игрока
        Player player2=new Player();
        System.out.println("Введите имя второго игрока");
        String player2Name=scannner.nextLine();
        player2.setName(player2Name);
        player2.setSymbol("0");

        //Создаем новую игру и выводим
        gameTable game =new gameTable();
        game.newGame();
        System.out.println(game.getTableXO());

        //Рейтинг игроков
        playerRating rating=new playerRating();

        //
        ArrayList<GameStep> steps=new ArrayList<>();
        WriteResult result=new WriteResult();
        while (true){

            //ход первого игрока
            System.out.println(player1.getName()+ " введи номер строки от 1 до 3");
            int row=scannner.nextInt();
            System.out.println(player1.getName()+ " введи номер столбца от 1 до 3");
            int column=scannner.nextInt();
            game.setPosition(row-1,column-1, "X");
            GameStep p1=new GameStep(row, column, player1.getName(), "X", player1.getId());
            steps.add(p1);
            System.out.println(game.getTableXO());

            //Проверка победителья
            if(game.searchWinner("X")){
                System.out.println("Победил игрок "+ player1.getName());
                rating.saveReting(player1.getName());
                result.write(player1, player2, steps);



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

            //ход второго игрока
            System.out.println(player2.getName()+ " введи номер строки от 1 до 3");
            int row2=scannner.nextInt();
            System.out.println(player2.getName()+ " введи номер столбца от 1 до 3");
            int column2=scannner.nextInt();
            game.setPosition(row2-1,column2-1, "0");
            GameStep p2=new GameStep(row2, column2, player2.getName(), "X", player2.getId());
            steps.add(p2);
            System.out.println(game.getTableXO());

            //Проверка победителья
            if(game.searchWinner("0")){
                System.out.println("Победил игрок "+ player2.getName());
                rating.saveReting(player2.getName());
                result.write(player2, player1, steps);

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
