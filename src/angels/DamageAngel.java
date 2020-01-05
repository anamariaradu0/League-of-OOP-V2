package angels;

import heroes.Hero;
import magician.GrandMagician;
import magician.ObserveAngelHelp;

import java.io.IOException;

public final class DamageAngel extends Angel {
    public DamageAngel(final String angelDetails) {
        super(angelDetails);
    }

    public void action(final Hero h) throws IOException {
        if (!h.isDead()) {
            GrandMagician obs = new ObserveAngelHelp();
            obs.observe(h, null, this);
            h.setAngelDamage();
        }
    }
}
