package angels;

import heroes.Hero;

import java.io.IOException;

public class DamageAngel extends Angel {

    public DamageAngel(String angelDetails) {
        super(angelDetails);
    }

    public static void action (Hero h) {
        if (h.isDead() == false)
            h.setAngelDamage();
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {

        fs.writeWord("DamageAngel helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
