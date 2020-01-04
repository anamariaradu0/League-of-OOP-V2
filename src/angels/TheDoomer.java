package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHit;
import magician.ObserveAngelKill;

import java.io.IOException;

public class TheDoomer extends Angel {
    public TheDoomer(String angelDetails) {
        super(angelDetails);
    }

    public void action(Hero h) throws IOException {
        if (h.isDead() == false) {
            h.setDead(true);
            GrandMagician o = new ObserveAngelHit();
            o.observe(h, null, this);
            GrandMagician obs = new ObserveAngelKill();
            obs.observe(h, null, null);
        }
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("The Doomer hit " + type + " ");
        fs.writeWord(id + "\n");
    }
}
