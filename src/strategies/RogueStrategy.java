package strategies;

import heroes.Hero;

import static common.Constants.*;

public final class RogueStrategy implements IStrategy {
    @Override
    public void applyStrategy(final Hero h) {
        int maxHp = ROG_INIT_HP + h.getLevel() * ROG_LVL_HP;
        if ((maxHp / ROG_STRATEGY_LOW) < h.getHp()
                && h.getHp() < (maxHp / ROG_STRATEGY_HIGH)) {
            h.damage(Math.round((int) (h.getHp() / ROG_STRATEGY_DAMAGE)));
            h.addStrategyDamage(ROG_STRATEGY_ADDMOD);
        } else if (h.getHp() < (maxHp / ROG_STRATEGY_LOW)) {
            h.addStrategyDamage(ROG_STRATEGY_REMMOD);
            h.addHp((int) (h.getHp() / ROG_STRATEGY_ADDHP));
        }
    }
}
