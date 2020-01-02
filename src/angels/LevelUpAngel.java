package angels;

import heroes.Hero;

import java.io.IOException;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        if (h.isDead() == false)
            h.levelUpAction();
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("LevelUpAngel helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
