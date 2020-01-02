package angels;

import heroes.Hero;

import java.io.IOException;

public class DarkAngel extends Angel {
    public DarkAngel(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        switch (h.type) {
            case "Knight":
                h.damage(40);
                break;
            case "Pyromancer":
                h.damage(30);
                break;
            case "Rogue":
                h.damage(10);
                break;
            case "Wizard":
                h.damage(20);
                break;
            default:
                break;
        }
    }
    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("DarkAngel hit " + type + " ");
        fs.writeWord(id + "\n");
    }
}
