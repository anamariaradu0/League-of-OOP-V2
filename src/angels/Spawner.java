package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHelp;
import magician.ObserveAngelRevive;

import java.io.IOException;

public final class Spawner extends Angel {
    public Spawner(final String angelDetails) {
        super(angelDetails);
    }

    public void action(final Hero h) throws IOException {
        if (h.isDead()) {
            GrandMagician obs = new ObserveAngelHelp();
            obs.observe(h, null, this);
            obs = new ObserveAngelRevive();
            obs.observe(h, null, null);
            h.spawn();
        }
    }
}
