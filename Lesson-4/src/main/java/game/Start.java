package game;

import game.resultIO.WriteXML;

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

        //для сохранения хода игроков
        ArrayList<GameStep> steps=new ArrayList<>();
        //объект класса для записи ходов
        WriteXML result=new WriteXML();
        while (true){

            //ход первого игрока
            int row;
            int column;
            while (true) {
                System.out.println(player1.getName()+ " введи номер строки от 1 до 3");
                row=scannner.nextInt();
                System.out.println(player1.getName()+ " введи номер столбца от 1 до 3");
                column = scannner.nextInt();
                if(game.getPosition(row-1, column-1)=="*") {
                    break;
                }else {
                    System.out.println("Выбранная ячейка занята, вводите заново!");
                }

            }
            game.setPosition(row-1,column-1, player1.getSymbol());
            GameStep p1=new GameStep(row, column, player1.getName(), player1.getSymbol(), player1.getId());
            steps.add(p1);
            System.out.println(game.getTableXO());


            //Проверка победителья
            if(game.searchWinner("X") || game.Draw()){
                if(game.Draw()){
                    System.out.println("Draw!");
                    result.write(player1, player2, steps, true);
                }
                else {
                    System.out.println("Победил игрок " + player1.getName());
                    rating.saveReting(player1.getName());
                    result.write(player1, player2, steps, false);
                }
                System.out.println("Рейтинг игроков:");
                System.out.println(rating.showRating()+"\n");

                System.out.println("Хотите продолжать игру? 0-да 1-нет");
                int answer=scannner.nextInt();
                if(answer==0){
                    game.newGame();
                    System.out.println(game.getTableXO());
                    steps=new ArrayList<>();
                    continue;
                }
                else if (answer==1){
                    break;
                }
            }

            //ход второго игрока
            int row2;
            int column2;
            while (true){
                System.out.println(player2.getName()+ " введи номер строки от 1 до 3");
                row2=scannner.nextInt();
                System.out.println(player2.getName()+ " введи номер столбца от 1 до 3");
                column2=scannner.nextInt();
                if(game.getPosition(row2-1,column2-1)=="*"){
                    break;
                }
                else {
                    System.out.println("Выбранная ячейка занята, вводите заново!");
                }
            }
            game.setPosition(row2-1,column2-1, player2.getSymbol());
            GameStep p2=new GameStep(row2, column2, player2.getName(), player2.getSymbol(), player2.getId());
            steps.add(p2);
            System.out.println(game.getTableXO());

            //Проверка победителья
            if(game.searchWinner("0") || game.Draw()){
                if(game.Draw()){
                    System.out.println("Draw!");
                    result.write(player2, player1, steps, true);
                }
                else {
                    System.out.println("Победил игрок " + player2.getName());
                    rating.saveReting(player2.getName());
                    result.write(player2, player1, steps, false);
                }
                System.out.println("Рейтинг игроков:");
                System.out.println(rating.showRating()+"\n");

                System.out.println("Хотите продолжать игру? 0-да 1-нет");
                int answer=scannner.nextInt();
                if(answer==0){
                    game.newGame();
                    System.out.println(game.getTableXO());
                    steps=new ArrayList<>();
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
