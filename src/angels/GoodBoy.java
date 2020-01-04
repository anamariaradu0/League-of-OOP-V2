package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHelp;
import magician.ObserveAngelHit;

import java.io.IOException;

public class GoodBoy extends Angel {
    public GoodBoy(String angelDetails) {
        super(angelDetails);
    }

    public void action(Hero h) throws IOException {
        if (h.isDead() == false) {
            GrandMagician obs = new ObserveAngelHelp();
            obs.observe(h, null, this);
            h.goodBoyAction();

        }

    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("GoodBoy helped " + type + " ");
        fs.writeWord(id + "\n");
    }

}
