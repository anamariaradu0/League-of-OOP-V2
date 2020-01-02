package angels;

import heroes.Hero;

import java.io.IOException;

public class LifeGiver extends Angel {
    public LifeGiver(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        h.lifeGiverAction();
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("LifeGiver helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
