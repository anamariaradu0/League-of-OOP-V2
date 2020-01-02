package heroes;

import jdk.swing.interop.SwingInterOpUtils;

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
    public void fight(IHero h) {
        h.fight(this);
    }

    @Override
    public void fight(Knight k) {
            double damage = FIREBLAST_DMG + level * FIREBLAST_LVL;
            if (currTerrain == 'V') {
                damage += damage * (PYR_V_BONUS + angelDamage);
            }
            damage += damage * (FIREBLAST_KNI_BONUS + angelDamage);
            k.damage((int) Math.round(damage));

            damage = IGNITE_DMG + IGNITE_LVL * level;
            double periodicDmg = IGNITE_ROUND_DMG + IGNITE_ROUND_LVL * level;
            if (currTerrain == 'V') {
                damage += damage * (PYR_V_BONUS + angelDamage);
                periodicDmg += periodicDmg * (PYR_V_BONUS + angelDamage);
            }

            damage += damage * (IGNITE_KNI_BONUS + angelDamage);
            periodicDmg += periodicDmg * (IGNITE_KNI_BONUS + angelDamage);

            k.damage((int) Math.round(damage));
            k.setPyroDmg((int) Math.round(periodicDmg));
            System.out.println("Periodic damage is " + periodicDmg + "\n");
            k.setPyroEffect(2);

            if (k.getHp() < 0) {
                k.setDead(true);
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.setXp(xp);
            }
    }

    @Override
    public void fight(Pyromancer k) {
        double damage = FIREBLAST_DMG + level * FIREBLAST_LVL;
        if (currTerrain == 'V') {
            damage += damage * (PYR_V_BONUS + angelDamage);
        }
        damage -= damage * (FIREBLAST_PYR_BONUS - angelDamage);
        k.damage((int) Math.round(damage));

        damage = IGNITE_DMG + IGNITE_LVL * level;
        double periodicDmg = IGNITE_ROUND_DMG + IGNITE_ROUND_LVL * level;
        if (currTerrain == 'V') {
            damage += damage * (PYR_V_BONUS + angelDamage);
            periodicDmg += periodicDmg * (PYR_V_BONUS + angelDamage);
        }

        damage -= damage * (IGNITE_PYR_BONUS - angelDamage);
        periodicDmg -= periodicDmg * (IGNITE_PYR_BONUS - angelDamage);

        k.damage((int) Math.round(damage));
        k.setPyroDmg((int) Math.round(periodicDmg));
        k.setPyroEffect(2);
        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(Rogue k) {
        double damage = FIREBLAST_DMG + level * FIREBLAST_LVL;
        if (currTerrain == 'V') {
            damage += damage * (PYR_V_BONUS + angelDamage);
        }
        damage -= damage * (FIREBLAST_ROG_BONUS - angelDamage);
        k.damage((int) Math.round(damage));

        damage = IGNITE_DMG + IGNITE_LVL * level;
        double periodicDmg = IGNITE_ROUND_DMG + IGNITE_ROUND_LVL * level;
        if (currTerrain == 'V') {
            damage += damage * (PYR_V_BONUS + angelDamage);
            periodicDmg += periodicDmg * (PYR_V_BONUS + angelDamage);
        }

        damage -= damage * (IGNITE_ROG_BONUS - angelDamage);
        periodicDmg -= periodicDmg * (IGNITE_ROG_BONUS - angelDamage);

        k.damage((int) Math.round(damage));
        k.setPyroDmg((int) Math.round(periodicDmg));
        k.setPyroEffect(2);

        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void fight(Wizard k) {
        double damage = FIREBLAST_DMG + level * FIREBLAST_LVL;
        if (currTerrain == 'V') {
            damage += damage * (PYR_V_BONUS + angelDamage);
        }
        damage -= damage * (FIREBLAST_WIZ_BONUS - angelDamage);
        damage = Math.round(damage);
        k.damage((int) Math.round(damage));

        damage = IGNITE_DMG + IGNITE_LVL * level;
        double periodicDmg = IGNITE_ROUND_DMG + IGNITE_ROUND_LVL * level;
        if (currTerrain == 'V') {
            damage += damage * (PYR_V_BONUS + angelDamage);
            periodicDmg += periodicDmg * (PYR_V_BONUS + angelDamage);
        }

        damage -= damage * (IGNITE_WIZ_BONUS - angelDamage);
        periodicDmg -= periodicDmg * (IGNITE_WIZ_BONUS - angelDamage);

        damage = Math.round(damage);
        k.damage((int) Math.round(damage));
        k.setPyroDmg((int)Math.round(periodicDmg));
        k.setPyroEffect(2);

        if (k.getHp() < 0) {
            k.setDead(true);
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        }
    }

    @Override
    public void setAngelDamage() {
        this.angelDamage += 0.2;
    }

    @Override
    public void draculaDamage() {
        this.damage(40);
        this.angelDamage -= 0.30;
    }

    @Override
    public void goodBoyAction() {
        this.addHp(30);
        this.angelDamage += 0.50;
    }

    @Override
    public void smallAngelAction() {
        this.addHp(15);
        this.angelDamage += 0.15;
    }

    @Override
    public void lifeGiverAction() {
        this.addHp(80);
        System.out.println("I AM GIVING LIFE TO PYRO\n");
    }

    @Override
    public void levelUpAction() {
        int nextXp = MAX_LVL_XP_LIMIT + (this.level) * MAX_LVL_XP_MULTIPLIER;
        System.out.println("NEXT XP IS " + nextXp + "\n");
        this.setXp(nextXp - this.xp);
        this.levelUp();
        this.angelDamage += 0.20;
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
        setHp(PYR_INIT_HP + level * PYR_LVL_HP);
    }

}
