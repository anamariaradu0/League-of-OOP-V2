package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHit;
import magician.ObserveAngelKill;

import java.io.IOException;

public final class TheDoomer extends Angel {
    public TheDoomer(final String angelDetails) {
        super(angelDetails);
    }

    public void action(final Hero h) throws IOException {
        if (!h.isDead()) {
            h.setDead(true);
            GrandMagician o = new ObserveAngelHit();
            o.observe(h, null, this);
            GrandMagician obs = new ObserveAngelKill();
            obs.observe(h, null, null);
        }
    }
}
