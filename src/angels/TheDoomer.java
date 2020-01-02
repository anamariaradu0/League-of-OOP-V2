package angels;

import heroes.Hero;

import java.io.IOException;

public class TheDoomer extends Angel {
    public TheDoomer(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        if (h.isDead()) {
            h.setDead(true);
        }
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("The Doomer hit " + type + " ");
        fs.writeWord(id + "\n");
        fs.writeWord("Player " + type + " ");
        fs.writeWord(id + " was killed by an angel\n");
    }
}
