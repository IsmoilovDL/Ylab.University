package game;

import java.util.Arrays;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру!");
        Scanner scannner=new Scanner(System.in);

        System.out.println("Введите имя первого игрока");
        String player1=scannner.nextLine();
        System.out.println(player1+", добро пожаловать в игру!\n ты играешь Х-ом\n");

        System.out.println("Введите имя второго игрока");
        String player2=scannner.nextLine();
        System.out.println(player2+", добро пожаловать в игру!\n ты играешь 0-ом\n");

        gameTable game =new gameTable();
        game.newGame();
        System.out.println(game.getTableXO());
        System.out.println(game.searchWinner("X"));

        while (true){
            System.out.println(player1+ " введи номер строки от 1 до 3");
            int row=scannner.nextInt();
            System.out.println(player1+ " введи номер столбца от 1 до 3");
            int column=scannner.nextInt();
            game.setPosition(row-1,column-1, "X");
            System.out.println(game.getTableXO());
            if(game.searchWinner("X")){
                System.out.println("Победил игрок "+ player1);

                System.out.println("Хотите продолжать игру? y-n");
                String answer = scannner.nextLine();
                if(answer.equals("y")){
                    continue;
                }
                else if (answer.equals("n")){
                    break;
                }
            }

            System.out.println(player2+ " введи номер строки от 1 до 3");
            int row2=scannner.nextInt();
            System.out.println(player2+ " введи номер столбца от 1 до 3");
            int column2=scannner.nextInt();
            game.setPosition(row2-1,column2-1, "0");
            System.out.println(game.getTableXO());
            if(game.searchWinner("0")){
                System.out.println("Победил игрок "+ player2);
            }
        }


    }
}
