package angels;

import heroes.Hero;

import java.io.IOException;

public class Spawner extends Angel {
    public Spawner(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        h.spawn();
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("Spawner helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
