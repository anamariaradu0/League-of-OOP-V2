package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHit;

import java.io.IOException;

public class Dracula extends Angel {

    public Dracula(String angelDetails) {
        super(angelDetails);
    }

    public void action(Hero h) throws IOException {
        if (h.isDead() == false) {
            GrandMagician obs = new ObserveAngelHit();
            obs.observe(h, null, this);
            h.draculaDamage();
        }
    }
}
