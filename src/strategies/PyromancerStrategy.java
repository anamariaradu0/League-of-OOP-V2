package strategies;

import heroes.Hero;

import static common.Constants.*;

public class PyromancerStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h) {
        System.out.println("PYRO STRATEGY");
        int max_level_hp = PYR_INIT_HP + h.getLevel() * PYR_LVL_HP;
        if ( ((float)1 / 4) * max_level_hp < h.getHp() &&
                h.getHp() < ((float)1 / 3) * max_level_hp) {
            h.damage((int)((float)1/4) * h.getHp());
            h.addStrategyDamage(0.70f);
        } else if (h.getHp() < ((float)1 / 4) * max_level_hp) {
            h.addStrategyDamage(-0.30f);
            h.addHp((int)((float)1/3) * h.getHp());
        }
    }
}
