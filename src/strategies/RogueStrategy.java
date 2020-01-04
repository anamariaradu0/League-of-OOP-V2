package strategies;

import heroes.Hero;

import static common.Constants.*;

public class RogueStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h ) {
        System.out.println("ROGUE STRATEGY");
        int max_level_hp = ROG_INIT_HP + h.getLevel() * ROG_LVL_HP;
        System.out.println(max_level_hp + " " + h.getHp() + " ");
        if ( ((float)1 / 7) * max_level_hp < h.getHp() &&
                h.getHp() < ((float)1 / 5) * max_level_hp) {
            System.out.println("HERERERERERERER11\n");
            h.damage(Math.round((int)((float)1/7) * h.getHp()));
            h.addStrategyDamage(0.40f);
        } else if (h.getHp() < ((float)1 / 7) * max_level_hp) {
            System.out.println("HERERERERERERER\n");
            h.addStrategyDamage(-0.10f);
            h.addHp((int)((float)1/ 2) * h.getHp());
        }
    }
}
