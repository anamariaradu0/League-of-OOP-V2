package strategies;

import heroes.Hero;

import static common.Constants.*;

public final class PyromancerStrategy implements IStrategy {
    @Override
    public void applyStrategy(final Hero h) {
        int maxHp = PYR_INIT_HP + h.getLevel() * PYR_LVL_HP;
        if ((maxHp / PYR_STRATEGY_LOW) < h.getHp()
                && h.getHp() < (maxHp / PYR_STRATEGY_HIGH)) {
            h.damage((int) ((float) (h.getHp() / PYR_STRATEGY_DAMAGE)));
            h.addStrategyDamage(PYR_STRATEGY_ADDMOD);
        } else if (h.getHp() < (maxHp / PYR_STRATEGY_LOW)) {
            h.addStrategyDamage(PYR_STRATEGY_REMMOD);
            h.addHp((int) ((float) (h.getHp() / PYR_STRATEGY_ADDHP)));
        }
    }
}
