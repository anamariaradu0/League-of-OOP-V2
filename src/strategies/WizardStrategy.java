package strategies;

import heroes.Hero;

import static common.Constants.ROG_INIT_HP;
import static common.Constants.ROG_LVL_HP;

public class WizardStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h) {
        System.out.println("WIZARD STRATEGY");
        int max_level_hp = ROG_INIT_HP + h.getLevel() * ROG_LVL_HP;
        System.out.println(max_level_hp + " " + h.getHp() + " ");
        if ( ((double)1 / 4) * max_level_hp < h.getHp() &&
                h.getHp() < ((double)1 / 2) * max_level_hp) {
            System.out.println("HERERERERERERER11\n");
            h.damage(Math.round((int)((double)1/10) * h.getHp()));
            h.addAngelDamage(0.60);
        }
        if (h.getHp() < ((double)1 / 4) * max_level_hp) {
            System.out.println("HERERERERERERER\n");
            h.addAngelDamage(-0.20);
            h.addHp((int)((double)1 / 5) * h.getHp());
        }
    }
}
