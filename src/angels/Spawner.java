package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHelp;
import magician.ObserveAngelRevive;

import java.io.IOException;

public class Spawner extends Angel {
    public Spawner(String angelDetails) {
        super(angelDetails);
    }

    public void action(Hero h) throws IOException {
        if (h.isDead() == true) {
            GrandMagician obs = new ObserveAngelHelp();
            obs.observe(h, null, this);
            obs = new ObserveAngelRevive();
            obs.observe(h, null, null);
            h.spawn();
        }
    }

    protected static void print(int x, int y, String type, int id, fileio.FileSystem fs) throws IOException {
        fs.writeWord("Spawner helped " + type + " ");
        fs.writeWord(id + "\n");
    }
}
