package strategies;

import heroes.Hero;

import static common.Constants.*;

public class WizardStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h) {
        System.out.println("WIZARD STRATEGY");
        int max_level_hp = WIZ_INIT_HP + h.getLevel() * WIZ_LVL_HP;
        System.out.println(max_level_hp + " " + h.getHp() + " ");
        if ( ((float)1 / 4) * max_level_hp < h.getHp() &&
                h.getHp() < ((float)1 / 2) * max_level_hp) {
            System.out.println("HERERERERERERER11\n");
            System.out.println("HP" + h.getHp());
            System.out.println("HP" + (float)(h.getHp() / 10));
            h.damage((int)((float)(h.getHp() / 10)));
            System.out.println("HP" + h.getHp());
            h.addStrategyDamage(0.60f);
        } else if (h.getHp() < ((float)1 / 4) * max_level_hp) {
            System.out.println("HERERERERERERER\n");
            h.addStrategyDamage(-0.20f);
            h.addHp((int)((float)1 / 5) * h.getHp());
        }
    }
}
