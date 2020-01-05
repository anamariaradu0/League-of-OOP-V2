package heroes;

import magician.GrandMagician;
import magician.ObserveAngelKill;
import magician.ObserveHeroKill;
import magician.ObserveLevelUp;
import map.Map;

import java.io.IOException;

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
    public void fight(final Knight k) throws IOException {
        float damage = (float) BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= (BACKSTAB_MULTIPLIER + angelDamage);
            }
        }
        damage -= damage * (BACKSTAB_K_BONUS - angelDamage - strategyDamage);
        ++noHit;
        damage = Math.round(damage);
        k.damage((int) damage);


        damage = (float) PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage -= damage * (PARALYSIS_K_BONUS - angelDamage + APPROX - strategyDamage);
        k.setParalysisDmg((int) Math.round(damage));
        damage = Math.round(damage);
        k.damage((int) damage);

        k.setCanMove(false);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        }
    }

    @Override
    public void fight(final Pyromancer k) throws IOException {
        float damage = BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= (BACKSTAB_MULTIPLIER + angelDamage);
            }
        }
        damage += damage * (BACKSTAB_PYR_BONUS + angelDamage + strategyDamage);
        ++noHit;
        k.damage((int) Math.round(damage));

        damage = PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage += damage * (PARALYSIS_PYR_BONUS + angelDamage + strategyDamage);
        k.setParalysisDmg((int) Math.round(damage));
        k.damage((int) Math.round(damage));
        k.setCanMove(false);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        }
    }

    @Override
    public void fight(final Rogue k) throws IOException {
        float damage = BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= (BACKSTAB_MULTIPLIER + angelDamage);
            }
        }
        damage += damage * (BACKSTAB_ROG_BONUS + angelDamage + strategyDamage);
        ++noHit;
        k.damage((int) Math.round(damage));

        damage = PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage -= damage * (PARALYSIS_ROG_BONUS - angelDamage + APPROXIMATE - strategyDamage);
        k.setParalysisDmg((int) Math.round(damage));
        k.damage((int) Math.round(damage));
        k.setCanMove(false);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        }
    }

    @Override
    public void fight(final Wizard k) throws IOException {
        float damage = BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * ROG_W_BONUS;
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= BACKSTAB_MULTIPLIER;
            }
        }
        damage += damage * (BACKSTAB_WIZ_BONUS + angelDamage + strategyDamage);
        ++noHit;
        k.damage((int) Math.round(damage));

        damage = PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * ROG_W_BONUS;
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage += damage * (PARALYSIS_WIZ_BONUS + angelDamage + strategyDamage);
        k.setParalysisDmg((int) Math.round(damage));
        k.damage((int) Math.round(damage));
        k.setCanMove(false);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        }
    }

    @Override
    public void fight(final IHero h) throws IOException {
        h.fight(this);
    }

    @Override
    public void setAngelDamage() {
        this.angelDamage += ROG_DAMAGEANGEL;
    }

    @Override
    public void draculaDamage() throws IOException {
        this.damage(ROG_DRACULA_DAMAGE);
        this.angelDamage -= ROG_DRACULA_MOD;
        if (this.hp < 0) {
            this.setDead(true);
            GrandMagician obs = new ObserveAngelKill();
            obs.observe(this, null, null);
        }
    }

    @Override
    public void goodBoyAction() {
        this.addHp(ROG_GOODBOY_HP);
        this.angelDamage += ROG_GOODBOY_MOD;
    }

    @Override
    public void smallAngelAction() {
        this.addHp(ROG_SMALLANGEL_HP);
        this.angelDamage += ROG_SMALLANGEL_MOD;
    }

    @Override
    public void darkAngelDamage() {
        this.damage(ROG_DA_DAMAGE);
    }

    @Override
    public void lifeGiverAction() {
        this.addHp(ROG_LIFEGIVER_HP);
        if (this.getHp() > ROG_INIT_HP + level * ROG_LVL_HP) {
            this.hp = ROG_INIT_HP + level * ROG_LVL_HP;
        }
    }

    @Override
    public void levelUpAction() throws IOException {
        int nextXp = MAX_LVL_XP_LIMIT + level * MAX_LVL_XP_MULTIPLIER;
        this.setXp(nextXp - this.xp);
        this.levelUp();
        this.angelDamage += ROG_LEVELUP_MOD;
    }

    @Override
    public void xpAngelAction() throws IOException {
        this.setXp(ROG_XP_ANGEL);
        this.levelUp();
    }

    @Override
    public void spawn() {
        if (this.isDead()) {
            this.setDead(false);
            this.setHp(ROG_SPAWN_HP);
            Map.getInstance().get(this.getRow(), this.getCol()).reviveHero(this);
        }
    }

    public void levelUp() throws IOException {
        int prevLvl = level;
        GrandMagician obs = new ObserveLevelUp();
        while (xp >= MAX_LVL_XP_LIMIT + level * MAX_LVL_XP_MULTIPLIER) {
            ++level;
            obs.observe(this, null, null);
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
