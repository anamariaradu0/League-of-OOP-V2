package angels;

import heroes.Hero;

import java.io.IOException;

public class Angel {
    static String angelDetails;

    public Angel(String angelDetails) {
        this.angelDetails = angelDetails;
    }

    public static void action(Hero h) {
        String[] details = angelDetails.split(",");
        String name = details[0];
        int angX = Integer.parseInt(details[1]);
        int angY = Integer.parseInt(details[2]);

        switch (name) {
            case "TheDoomer":
                TheDoomer.action(h);
                break;
            case "XPAngel":
                XPAngel.action(h);
                break;
            case "DamageAngel":
                DamageAngel.action(h);
                break;
            case "Dracula":
                Dracula.action(h);
                break;
            case "GoodBoy":
                GoodBoy.action(h);
                break;
            case "SmallAngel":
                SmallAngel.action(h);
                break;
            case "LifeGiver":
                LifeGiver.action(h);
                break;
            case "LevelUpAngel":
                LevelUpAngel.action(h);
                break;
            case "DarkAngel":
                DarkAngel.action(h);
                break;
            case "Spawner":
                Spawner.action(h);
                break;
        }
    }

    public static void spawnPrint(int x, int y, fileio.FileSystem fs) throws IOException {
        String[] details = angelDetails.split(",");
        String name = details[0];
        int angX = Integer.parseInt(details[1]);
        int angY = Integer.parseInt(details[2]);

        switch (name) {
            case "TheDoomer":
                fs.writeWord("Angel The Doomer was spawned at " + x + " " + y + "\n");
                break;
            case "XPAngel":
                fs.writeWord("Angel XPAngel was spawned at "+ x + " " + y + "\n");
                break;
            case "DamageAngel":
                fs.writeWord("Angel DamageAngel was spawned at " + x + " " + y + "\n");
                break;
            case "Dracula":
                fs.writeWord("Angel Dracula was spawned at " + x + " " + y + "\n");
                break;
            case "GoodBoy":
                fs.writeWord("Angel GoodBoy was spawned at " + x + " " + y + "\n");
                break;
            case "SmallAngel":
                fs.writeWord("Angel SmallAngel was spawned at " + x + " " + y + "\n");
                break;
            case "LifeGiver":
                fs.writeWord("Angel LifeGiver was spawned at " + x + " " + y + "\n");
                break;
            case "LevelUpAngel":
                fs.writeWord("Angel LevelUpAngel was spawned at " + x + " " + y + "\n");
                break;
            case "DarkAngel":
                fs.writeWord("Angel DarkAngel was spawned at " + x + " " + y + "\n");
                break;
            case "Spawner":
                fs.writeWord("Angel Spawner was spawned at " + x + " " + y + "\n");
                break;

        }
    }

    public static void angPrint(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        String[] details = angelDetails.split(",");
        String name = details[0];
        int angX = Integer.parseInt(details[1]);
        int angY = Integer.parseInt(details[2]);

        switch (name) {
            case "TheDoomer":
                TheDoomer.print(x, y, type, id, fs);
                break;
            case "XPAngel":
                XPAngel.print(x, y, type, id, fs);
                break;
            case "DamageAngel":
                DamageAngel.print(x, y, type, id, fs);
                break;
            case "Dracula":
                Dracula.print(x, y, type, id, fs);
                break;
            case "GoodBoy":
                GoodBoy.print(x, y, type, id, fs);
                break;
            case "SmallAngel":
                SmallAngel.print(x, y, type, id, fs);
                break;
            case "LifeGiver":
                LifeGiver.print(x, y, type, id, fs);
                break;
            case "LevelUpAngel":
                LevelUpAngel.print(x, y, type, id, fs);
                break;
            case "DarkAngel":
                DarkAngel.print(x, y, type, id, fs);
                break;
            case "Spawner":
                Spawner.print(x, y, type, id, fs);
                break;
        }
    }
}
