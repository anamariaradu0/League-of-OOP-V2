package angels;

import heroes.Hero;

import java.io.IOException;

public class XPAngel extends Angel {
    public XPAngel(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        if (h.isDead() == false) {
            switch (h.type) {
                case "Knight":
                    h.setXp(45);
                    h.levelUp();
                    break;
                case "Pyromancer":
                    h.setXp(50);
                    h.levelUp();
                    break;
                case "Rogue":
                    h.setXp(40);
                    h.levelUp();
                    break;
                case "Wizard":
                    h.setXp(60);
                    h.levelUp();
                    break;
                default:
                    break;
            }
        }
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("XPAngel helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
