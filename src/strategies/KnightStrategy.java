package strategies;

import heroes.Hero;
import common.Constants;

import static common.Constants.KNI_INIT_HP;
import static common.Constants.KNI_LVL_HP;


public class KnightStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h) {
        System.out.println("KNIGHT STRATEGY");
        int max_level_hp = KNI_INIT_HP + h.getLevel() * KNI_LVL_HP;
        System.out.println(max_level_hp + " " + h.getHp() + " ");
        if ( ((float)1 / 3) * max_level_hp < h.getHp() &&
                h.getHp() < ((float)1 / 2) * max_level_hp) {
            System.out.println("HERERERERERERER11\n");
            h.damage(Math.round((int)((float)1/5) * h.getHp()));
            h.addStrategyDamage(0.50f);
        } else if (h.getHp() < ((float)1 / 3) * max_level_hp) {
            System.out.println("HERERERERERERER\n");
            h.addStrategyDamage(-0.20f);
            h.addHp((int)((float)1/4) * h.getHp());
        }
    }
}
