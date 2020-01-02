package angels;

import heroes.Hero;

import java.io.IOException;

public class SmallAngel extends Angel {
    public SmallAngel(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        if (h.isDead() == false)
            h.smallAngelAction();
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("SmallAngel helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
