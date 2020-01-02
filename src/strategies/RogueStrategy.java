package strategies;

import heroes.Hero;

import static common.Constants.*;

public class RogueStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h ) {
        System.out.println("ROGUE STRATEGY");
        int max_level_hp = ROG_INIT_HP + h.getLevel() * ROG_LVL_HP;
        System.out.println(max_level_hp + " " + h.getHp() + " ");
        if ( ((double)1 / 7) * max_level_hp < h.getHp() &&
                h.getHp() < ((double)1 / 5) * max_level_hp) {
            System.out.println("HERERERERERERER11\n");
            h.damage(Math.round((int)((double)1/7) * h.getHp()));
            h.addAngelDamage(0.40);
        }
        if (h.getHp() < ((double)1 / 7) * max_level_hp) {
            System.out.println("HERERERERERERER\n");
            h.addAngelDamage(-0.10);
            h.addHp((int)((double)1/ 2) * h.getHp());
        }
    }
}
