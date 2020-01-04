package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHelp;

import java.io.IOException;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(String angelDetails) {
        super(angelDetails);
    }

    public void action(Hero h) throws IOException {
        if (h.isDead() == false) {
            GrandMagician obs = new ObserveAngelHelp();
            obs.observe(h, null, this);
            h.levelUpAction();
        }

    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("LevelUpAngel helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
