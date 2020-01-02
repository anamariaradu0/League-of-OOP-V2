package heroes;

import static common.Constants.*;
import static java.lang.Math.max;
import static java.lang.Math.min;

public final class Wizard extends Hero {
    public Wizard() {
        super();
        type = "Wizard";
        hp = WIZ_INIT_HP;
        xp = 0;
        level = 0;
        dead = false;
        canMove = true;
        pyroDmg = 0;
        pyroEffect = 0;
        paralysisEffect = 0;
        paralysisDmg = 0;
        canMove = true;
    }

    @Override
    public void fight(Knight k) {
        double percent = DRAIN_PERCENT + DRAIN_PERC_LVL * level;
        double damage = 0;

        percent += percent * DRAIN_KNI_BONUS;
        damage = percent * min(DRAIN_MIN * KNI_INIT_HP, k.getHp());
        if (currTerrain == 'D') {
            damage += damage * DESERT_BONUS;
        }
        k.damage((int) Math.round(damage));

        percent = DEFLECT_PERCENT + DEFLECT_PERC_LVL * level;
        if (percent > DEFLECT_PERC_MAX) {
            percent = DEFLECT_PERC_MAX;
        }

        double totalDmg;
        damage = 0;

        percent += percent * DEFLECT_KNI_BONUS;
        double damage1 = EXECUTE_DMG + EXECUTE_LVL * k.getLevel();
        if (currTerrain == 'L') {
            damage1 += damage1 * KNI_L_BONUS;
        }
        double damage2 = SLAM + SLAM_LVL * k.getLevel();
        if (currTerrain == 'L') {
            damage2 += damage2 * KNI_L_BONUS;
        }

        totalDmg = Math.round(damage1) + Math.round(damage2);

        damage = percent * totalDmg;
        if (currTerrain == 'D') {
            damage += damage * DESERT_BONUS;
        }

        k.damage((int) Math.round(damage));
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(Pyromancer k) {
        double percent = DRAIN_PERCENT + DRAIN_PERC_LVL * level;
        double damage = 0;

        percent -= percent * DRAIN_PYR_BONUS;
        damage = percent * min(DRAIN_MIN * PYR_INIT_HP, k.getHp());
        if (currTerrain == 'D') {
            damage += damage * DESERT_BONUS;
        }
        k.damage((int) Math.round(damage));

        percent = DEFLECT_PERCENT + DEFLECT_PERC_LVL * level;
        if (percent > DEFLECT_PERC_MAX) {
            percent = DEFLECT_PERC_MAX;
        }

        double totalDmg;
        damage = 0;

        percent += percent * DEFLECT_PYR_BONUS;
        double damage1 = FIREBLAST_DMG + FIREBLAST_LVL * k.getLevel();
        if (currTerrain == 'V') {
            damage1 += damage1 * PYR_V_BONUS;
        }
        double damage2 = IGNITE_DMG + IGNITE_LVL * k.getLevel();
        if (currTerrain == 'V') {
            damage2 += damage2 * PYR_V_BONUS;
        }

        totalDmg = Math.round(damage1) + Math.round(damage2);

        damage = percent * totalDmg;
        if (currTerrain == 'D') {
            damage += damage * DESERT_BONUS;
        }

        k.damage((int) Math.round(damage));
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(Rogue k) {
        double percent = DRAIN_PERCENT + DRAIN_PERC_LVL * level;
        double damage = 0;

        percent -= percent * DRAIN_ROG_BONUS;
        damage = percent * min(DRAIN_MIN * ROG_INIT_HP, k.getHp());
        if (currTerrain == 'D') {
            damage += damage * DESERT_BONUS;
        }
        k.damage((int) Math.round(damage));

        percent = DEFLECT_PERCENT + DEFLECT_PERC_LVL * level;
        if (percent > DEFLECT_PERC_MAX) {
            percent = DEFLECT_PERC_MAX;
        }

        double totalDmg = 0;
        damage = 0;

        percent += percent * DEFLECT_ROG_BONUS;
        double damage1 = BACKSTAB_DMG + BACKSTAB_LVL * k.getLevel();
        if (currTerrain == 'W') {
            damage1 += damage1 * ROG_W_BONUS;
            damage1 *= BACKSTAB_MULTIPLIER;
        }
        double damage2 = PARALYSIS_DMG + PARALYSIS_LVL * k.getLevel();
        if (currTerrain == 'W') {
            damage2 += damage2 * ROG_W_BONUS;
        }

        totalDmg = Math.round(damage1) + Math.round(damage2);

        damage = percent * totalDmg;
        if (currTerrain == 'D') {
            damage += damage * DESERT_BONUS;
        }

        k.damage((int) Math.round(damage));
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(Wizard w) {
        double percent = DRAIN_PERCENT + DRAIN_PERC_LVL * level;
        double damage = 0;

        percent += percent * DRAIN_WIZ_BONUS;
        damage = percent * min(DRAIN_MIN * WIZ_INIT_HP, w.getHp());
        if (currTerrain == 'D') {
            damage += damage * DESERT_BONUS;
        }

        w.damage((int) Math.round(damage));
        if (w.getHp() < 0) {
            w.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - w.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(IHero h) {
        h.fight(this);
    }

    public void maxHp() {
        setHp(WIZ_INIT_HP + level * WIZ_LVL_HP);
    }

    @Override
    public void setAngelDamage() {
        this.angelDamage += 0.4;
    }

    @Override
    public void draculaDamage() {
        this.damage(20);
        this.angelDamage -= 0.40;
    }

    @Override
    public void goodBoyAction() {
        this.addHp(50);
        this.angelDamage += 0.30;
    }

    @Override
    public void smallAngelAction() {
        this.addHp(25);
        this.angelDamage += 0.10;
    }

    @Override
    public void lifeGiverAction() {
        this.addHp(120);
        if (this.getHp() > WIZ_INIT_HP + level * WIZ_LVL_HP) {
            this.hp = WIZ_INIT_HP + level * WIZ_LVL_HP;
        }
    }

    @Override
    public void levelUpAction() {
        int nextXp = MAX_LVL_XP_LIMIT + level * MAX_LVL_XP_MULTIPLIER;
        this.setXp(nextXp - this.xp);
        this.levelUp();
        this.angelDamage += 0.25;
    }

    @Override
    public void spawn() {
        if (this.isDead() == true) {
            this.setDead(false);
            this.setHp(120);
        }
    }

    public void levelUp() {
        int prevLvl = level;
        while (xp >= MAX_LVL_XP_LIMIT + level * MAX_LVL_XP_MULTIPLIER) {
            ++level;
        }
        int newLvl = level;
        if (newLvl != prevLvl) {
            this.maxHp();
        }
    }
}
