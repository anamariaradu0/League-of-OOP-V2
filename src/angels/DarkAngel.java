package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHit;

import java.io.IOException;

public final class DarkAngel extends Angel {
    public DarkAngel(final String angelDetails) {
        super(angelDetails);
    }

    public void action(final Hero h) throws IOException {
        if (!h.isDead()) {
            GrandMagician obs = new ObserveAngelHit();
            obs.observe(h, null, this);
            h.darkAngelDamage();
        }
    }
}
