package strategies;

import heroes.Hero;

import static common.Constants.*;

public final class KnightStrategy implements IStrategy {
    @Override
    public void applyStrategy(final Hero h) {
        int maxHp = KNI_INIT_HP + h.getLevel() * KNI_LVL_HP;
        if ((maxHp / KNI_STRATEGY_LOW) < h.getHp()
                && h.getHp() < (maxHp / KNI_STRATEGY_HIGH)) {
            h.damage(Math.round(h.getHp() / KNI_STRATEGY_DAMAGE));
            h.addStrategyDamage(KNI_STRATEGY_ADDMOD);
        } else if (h.getHp() < (maxHp / KNI_STRATEGY_LOW)) {
            h.addStrategyDamage(KNI_STRATEGY_REMMOD);
            h.addHp((int)(h.getHp() / KNI_STRATEGY_ADDHP));
        }
    }
}
