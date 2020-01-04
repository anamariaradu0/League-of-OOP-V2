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
    public void fight(Knight k) throws IOException {
        float damage = (float)BACKSTAB_DMG + BACKSTAB_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            if (noHit % BACKSTAB_CRIT == 0) {
                damage *= (BACKSTAB_MULTIPLIER + angelDamage);
            }
        }
        damage -= damage * (BACKSTAB_K_BONUS - angelDamage - strategyDamage);
        ++noHit;
        System.out.println("BACKSTAB DAMAGE " + damage);
        damage = Math.round(damage);
        k.damage((int) damage);


        damage = (float)PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        damage -= damage * (PARALYSIS_K_BONUS - angelDamage + 0.0000001f - strategyDamage);
        System.out.println("PARALYSIS DAMAGE " + damage);
        k.setParalysisDmg((int) Math.round(damage));
        damage = Math.round(damage);
        k.damage((int) damage);
        System.out.println("PARALYSIS DAMAGE " + damage);

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
    public void fight(Pyromancer k) throws IOException {
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

        System.out.println("BACKSTAB DAMAGE " + damage);

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

        System.out.println("PARALYSIS DAMAGE " + damage);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        }
    }

    @Override
    public void fight(Rogue k) throws IOException {
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
        System.out.println("BACKSTAB DAMAGE " + damage);

        damage = PARALYSIS_DMG + PARALYSIS_LVL * level;
        if (currTerrain == 'W') {
            damage += damage * (ROG_W_BONUS + angelDamage);
            k.setParalysisEffect(PARALYSIS_WOODS);
        } else {
            k.setParalysisEffect(PARALYSIS_ROUNDS);
        }
        //System.out.println("PARALYSIS DAMAGE " + damage);
        damage -= damage * (PARALYSIS_ROG_BONUS - angelDamage + 0.0000002f - strategyDamage);
        k.setParalysisDmg((int) Math.round(damage));
        k.damage((int) Math.round(damage));
        System.out.println("PARALYSIS DAMAGE " + damage);
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
    public void fight(Wizard k) throws IOException {
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
    public void fight(IHero h) throws IOException {
        h.fight(this);
    }

    @Override
    public void setAngelDamage() {
        this.angelDamage += 0.3f;
    }

    @Override
    public void draculaDamage() throws IOException {
        this.damage(35);
        this.angelDamage -= 0.10f;
        if (this.hp < 0) {
            this.setDead(true);
            GrandMagician obs = new ObserveAngelKill();
            obs.observe(this, null, null);
        }
    }

    @Override
    public void goodBoyAction() {
        this.addHp(40);
        this.angelDamage += 0.40f;
    }

    @Override
    public void smallAngelAction() {
        this.addHp(20);
        this.angelDamage += 0.05f;
    }

    @Override
    public void lifeGiverAction() {
        this.addHp(90);
        if (this.getHp() > ROG_INIT_HP + level * ROG_LVL_HP) {
            this.hp = ROG_INIT_HP + level * ROG_LVL_HP;
        }
    }

    @Override
    public void levelUpAction() throws IOException {
        int nextXp = MAX_LVL_XP_LIMIT + level * MAX_LVL_XP_MULTIPLIER;
        this.setXp(nextXp - this.xp);
        this.levelUp();
        this.angelDamage += 0.15f;
    }

    @Override
    public void spawn() {
        if (this.isDead() == true) {
            this.setDead(false);
            this.setHp(180);
            // this.xp = 0;
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
