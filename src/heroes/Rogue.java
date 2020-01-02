package heroes;

import static common.Constants.*;
import static java.lang.Math.max;

public final class Rogue extends Hero {
    private int noHit;
    public Rogue() {
        super();
        type = "Rogue";
        hp = ROG_INIT_HP; // 900
        xp = 0;
        level = 0;
        dead = false;
        canMove = true;
        pyroDmg = 0;
        pyroEffect = 0;
        paralysisEffect = 0;
        paralysisDmg = 0;
        noHit = 0;
        canMove = true;
    }

    @Override
    public void fight(Knight k) {
        double damage = BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= BACKSTAB_MULTIPLIER;
            }
        }
        damage -= damage * (BACKSTAB_K_BONUS - angelDamage);
        ++noHit;
        k.damage((int) Math.round(damage));

        damage = PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage -= damage * (PARALYSIS_K_BONUS - angelDamage);
        k.setParalysisDmg((int) Math.round(damage));
        k.damage((int) Math.round(damage));
        k.setCanMove(false);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(Pyromancer k) {
        double damage = BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * ROG_W_BONUS;
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= BACKSTAB_MULTIPLIER;
            }
        }
        damage += damage * BACKSTAB_PYR_BONUS;
        ++noHit;
        k.damage((int) Math.round(damage));

        damage = PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * ROG_W_BONUS;
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage += damage * PARALYSIS_PYR_BONUS;
        k.setParalysisDmg((int) Math.round(damage));
        k.damage((int) Math.round(damage));
        k.setCanMove(false);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(Rogue k) {
        double damage = BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * ROG_W_BONUS;
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= BACKSTAB_MULTIPLIER;
            }
        }
        damage += damage * BACKSTAB_ROG_BONUS;
        ++noHit;
        k.damage((int) Math.round(damage));

        damage = PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * ROG_W_BONUS;
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage -= damage * PARALYSIS_ROG_BONUS;
        k.setParalysisDmg((int) Math.round(damage));
        k.damage((int) Math.round(damage));
        k.setCanMove(false);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(Wizard k) {
        double damage = BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * ROG_W_BONUS;
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= BACKSTAB_MULTIPLIER;
            }
        }
        damage += damage * BACKSTAB_WIZ_BONUS;
        ++noHit;
        k.damage((int) Math.round(damage));

        damage = PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * ROG_W_BONUS;
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage += damage * PARALYSIS_WIZ_BONUS;
        k.setParalysisDmg((int) Math.round(damage));
        k.damage((int) Math.round(damage));
        k.setCanMove(false);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(IHero h) {
        h.fight(this);
    }

    @Override
    public void setAngelDamage() {
        this.angelDamage += 0.3;
    }

    @Override
    public void draculaDamage() {
        this.damage(35);
        this.angelDamage -= 0.10;
    }

    @Override
    public void goodBoyAction() {
        this.addHp(40);
        this.angelDamage += 0.40;
    }

    @Override
    public void smallAngelAction() {
        this.addHp(20);
        this.angelDamage += 0.05;
    }

    @Override
    public void lifeGiverAction() {
        this.addHp(90);
        if (this.getHp() > ROG_INIT_HP + level * ROG_LVL_HP) {
            this.hp = ROG_INIT_HP + level * ROG_LVL_HP;
        }
    }

    @Override
    public void levelUpAction() {
        int nextXp = MAX_LVL_XP_LIMIT + level * MAX_LVL_XP_MULTIPLIER;
        this.setXp(nextXp - this.xp);
        this.levelUp();
        this.angelDamage += 0.15;
    }

    @Override
    public void spawn() {
        if (this.isDead() == true) {
            this.setDead(false);
            this.setHp(180);
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

    public void maxHp() {
        setHp(ROG_INIT_HP + level * ROG_LVL_HP);
    }
}
