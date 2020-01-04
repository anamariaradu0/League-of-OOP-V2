package heroes;

import jdk.swing.interop.SwingInterOpUtils;
import magician.GrandMagician;
import magician.ObserveAngelKill;
import magician.ObserveHeroKill;
import magician.ObserveLevelUp;
import map.Map;

import java.io.IOException;

import static common.Constants.*;
import static java.lang.Math.max;

public final class Pyromancer extends Hero {
    public Pyromancer() {
        super();
        type = "Pyromancer";
        hp = PYR_INIT_HP;
        xp = 0;
        level = 0;
        dead = false;
        canMove = true;
        pyroDmg = 0;
        pyroEffect = 0;
        canMove = true;
    }

    @Override
    public void fight(IHero h) throws IOException {
        h.fight(this);
    }

    @Override
    public void fight(Knight k) throws IOException {
            float damage = FIREBLAST_DMG + level * FIREBLAST_LVL;
            if (currTerrain == 'V') {
                damage += damage * PYR_V_BONUS;
            }
            damage += damage * (FIREBLAST_KNI_BONUS + angelDamage + strategyDamage);
            k.damage((int) Math.round(damage));

            damage = IGNITE_DMG + IGNITE_LVL * level;
            float periodicDmg = IGNITE_ROUND_DMG + IGNITE_ROUND_LVL * level;
            if (currTerrain == 'V') {
                damage += damage * PYR_V_BONUS;
                periodicDmg += periodicDmg * PYR_V_BONUS;
            }

            damage += damage * (IGNITE_KNI_BONUS + angelDamage + strategyDamage);
            periodicDmg += periodicDmg * (IGNITE_KNI_BONUS + angelDamage + strategyDamage);

            k.damage((int) Math.round(damage));
            k.setPyroDmg((int) Math.round(periodicDmg));
            System.out.println("Periodic damage is " + periodicDmg + "\n");
            k.setPyroEffect(2);

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
        float damage = FIREBLAST_DMG + level * FIREBLAST_LVL;
        if (currTerrain == 'V') {
            damage += damage * PYR_V_BONUS;
        }
        damage -= damage * (FIREBLAST_PYR_BONUS - angelDamage - strategyDamage);
        k.damage((int) Math.round(damage));

        damage = IGNITE_DMG + IGNITE_LVL * level;
        float periodicDmg = IGNITE_ROUND_DMG + IGNITE_ROUND_LVL * level;
        if (currTerrain == 'V') {
            damage += damage * PYR_V_BONUS;
            periodicDmg += periodicDmg * PYR_V_BONUS;
        }

        damage -= damage * (IGNITE_PYR_BONUS - angelDamage - strategyDamage);
        periodicDmg -= periodicDmg * (IGNITE_PYR_BONUS - angelDamage - strategyDamage);

        k.damage((int) Math.round(damage));
        k.setPyroDmg((int) Math.round(periodicDmg));
        k.setPyroEffect(2);


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
        float damage = FIREBLAST_DMG + level * FIREBLAST_LVL;
        if (currTerrain == 'V') {
            damage += damage * PYR_V_BONUS;
        }
        damage -= damage * (FIREBLAST_ROG_BONUS - angelDamage - strategyDamage);
        k.damage((int) Math.round(damage));

        damage = IGNITE_DMG + IGNITE_LVL * level;
        float periodicDmg = IGNITE_ROUND_DMG + IGNITE_ROUND_LVL * level;
        if (currTerrain == 'V') {
            damage += damage * PYR_V_BONUS;
            periodicDmg += periodicDmg * PYR_V_BONUS;
        }

        System.out.println("FIREBLAST DAMAGE " + damage);

        damage -= damage * (IGNITE_ROG_BONUS - angelDamage - strategyDamage);
        periodicDmg -= periodicDmg * (IGNITE_ROG_BONUS - angelDamage - strategyDamage);

        k.damage((int) Math.round(damage));
        k.setPyroDmg((int) Math.round(periodicDmg));
        k.setPyroEffect(2);
        System.out.println("IGNITE DAMAGE " + damage);
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
        float damage = FIREBLAST_DMG + level * FIREBLAST_LVL;
        if (currTerrain == 'V') {
            damage += damage * PYR_V_BONUS;
        }
        damage -= damage * (FIREBLAST_WIZ_BONUS - angelDamage - strategyDamage);
        damage = Math.round(damage);
        k.damage((int) Math.round(damage));

        damage = IGNITE_DMG + IGNITE_LVL * level;
        float periodicDmg = IGNITE_ROUND_DMG + IGNITE_ROUND_LVL * level;
        if (currTerrain == 'V') {
            damage += damage * PYR_V_BONUS;
            periodicDmg += periodicDmg * PYR_V_BONUS;
        }

        damage -= damage * (IGNITE_WIZ_BONUS - angelDamage - strategyDamage);
        periodicDmg -= periodicDmg * (IGNITE_WIZ_BONUS - angelDamage - strategyDamage);

        damage = Math.round(damage);
        k.damage((int) Math.round(damage));
        k.setPyroDmg((int)Math.round(periodicDmg));
        k.setPyroEffect(2);

        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        }
    }

    @Override
    public void setAngelDamage() {
        this.angelDamage += 0.2f;
    }

    @Override
    public void draculaDamage() throws IOException {
        this.damage(40);
        this.angelDamage -= 0.30f;
        if (this.hp < 0) {
            this.setDead(true);
            GrandMagician obs = new ObserveAngelKill();
            obs.observe(this, null, null);
        }
    }

    @Override
    public void goodBoyAction() {
        this.addHp(30);
        this.angelDamage += 0.50f;
    }

    @Override
    public void smallAngelAction() {
        this.addHp(15);
        this.angelDamage += 0.15f;
    }

    @Override
    public void lifeGiverAction() {
        this.addHp(80);
        if (this.getHp() > PYR_INIT_HP + level * PYR_LVL_HP) {
            this.hp = PYR_INIT_HP + level * PYR_LVL_HP;
        }
    }

    @Override
    public void levelUpAction() throws IOException {
        int nextXp = MAX_LVL_XP_LIMIT + (this.level) * MAX_LVL_XP_MULTIPLIER;
        System.out.println("NEXT XP IS " + nextXp + "\n");
        this.setXp(nextXp - this.xp);
        this.levelUp();
        this.angelDamage += 0.20f;
    }

    @Override
    public void spawn() {
        if (this.isDead() == true) {
            this.setDead(false);
            this.setHp(150);
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
        setHp(PYR_INIT_HP + level * PYR_LVL_HP);
    }



}
