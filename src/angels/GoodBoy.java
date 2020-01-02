package angels;

import heroes.Hero;

import java.io.IOException;

public class GoodBoy extends Angel {
    public GoodBoy(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        h.goodBoyAction();
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("GoodBoy helped " + type + " ");
        fs.writeWord(id + "\n");
    }

}
