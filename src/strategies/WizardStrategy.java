package strategies;

import heroes.Hero;

import static common.Constants.*;

public final class WizardStrategy implements IStrategy {
    @Override
    public void applyStrategy(final Hero h) {
        int maxHp = WIZ_INIT_HP + h.getLevel() * WIZ_LVL_HP;
        if ((maxHp / WIZ_STRATEGY_LOW) < h.getHp()
                && h.getHp() < (maxHp / WIZ_STRATEGY_HIGH)) {
            h.damage((int) ((float) (h.getHp() / WIZ_STRATEGY_DAMAGE)));
            h.addStrategyDamage(WIZ_STRATEGY_ADDMOD);
        } else if (h.getHp() < (maxHp / WIZ_STRATEGY_LOW)) {
            h.addStrategyDamage(WIZ_STRATEGY_REMMOD);
            h.addHp((int) ((float) (h.getHp() / WIZ_STRATEGY_ADDHP)));
        }
    }
}
