package angels;

import heroes.Hero;

import java.io.IOException;

public class Dracula extends Angel {

    public Dracula(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        h.draculaDamage();
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("Dracula hit " + type + " ");
        fs.writeWord(id + "\n");
    }
}
