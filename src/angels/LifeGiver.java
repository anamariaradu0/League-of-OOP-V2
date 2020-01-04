package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHelp;

import java.io.IOException;

public class LifeGiver extends Angel {
    public LifeGiver(String angelDetails) {
        super(angelDetails);
    }

    public void action(Hero h) throws IOException {
        if (h.isDead() == false) {
            GrandMagician obs = new ObserveAngelHelp();
            obs.observe(h, null, this);
            h.lifeGiverAction();
        }
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("LifeGiver helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
