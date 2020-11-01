package com.jkr;

import java.io.File;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        if (args.length <= 0) {
            System.out.println("error en la ruta de el archivo");
            System.exit(-1);
        }
        try {
            FileReader fileReader = new FileReaderFromScanner(new Scanner(new File(args[0])));
            ScoreManager scoreManager = new GameScoreManager(fileReader.readPlayerGames());
            scoreManager.processData();
            GamePrinter gamePrinter = new ConsoleGamePrinter();
            gamePrinter.print(scoreManager.getPlayerGames());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
