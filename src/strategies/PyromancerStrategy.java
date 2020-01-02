package strategies;

import heroes.Hero;

import static common.Constants.*;

public class PyromancerStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h) {
        System.out.println("PYRO STRATEGY");
        int max_level_hp = PYR_INIT_HP + h.getLevel() * PYR_LVL_HP;
        if ( ((double)1 / 4) * max_level_hp < h.getHp() &&
                h.getHp() < ((double)1 / 3) * max_level_hp) {
            h.damage((int)((double)1/4) * h.getHp());
            h.addAngelDamage(0.70);
        }
        if (h.getHp() < ((double)1 / 4) * max_level_hp) {
            h.addAngelDamage(-0.30);
            h.addHp((int)((double)1/3) * h.getHp());
        }
    }
}
