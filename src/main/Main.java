package main;

import fileio.FileSystem;
import gameflow.GameFlow;

public class Main {
    public static void main(String[] args) {
        try {
            FileSystem fs = new FileSystem(args[0], args[1]);
            GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
            GameInput gameInput = gameInputLoader.load();
            GameFlow.getInput(gameInput);
            GameFlow.addHeroesToMap(gameInput.getMap());
            gameInput.printAngels();
            GameFlow.play(gameInput.getMap(), fs);
            GameFlow.showLeaderBoard(fs);
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
