package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHelp;

import java.io.IOException;

public final class LifeGiver extends Angel {
    public LifeGiver(final String angelDetails) {
        super(angelDetails);
    }

    public void action(final Hero h) throws IOException {
        if (!h.isDead()) {
            GrandMagician obs = new ObserveAngelHelp();
            obs.observe(h, null, this);
            h.lifeGiverAction();
        }
    }
}
