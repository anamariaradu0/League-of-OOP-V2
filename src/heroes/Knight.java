package heroes;

import magician.GrandMagician;
import magician.ObserveHeroKill;

import static common.Constants.*;
import static java.lang.Math.max;

public final class Knight extends Hero {
    public Knight() {
        super();
        type = "Knight";
        hp = KNI_INIT_HP;
        xp = 0;
        level = 0;
        dead = false;
        canMove = true;
        pyroDmg = 0;
        pyroEffect = 0;
    }

    public void maxHp() {
        this.setHp(KNI_INIT_HP + getLevel() * KNI_LVL_HP);
    }


    @Override
    public void fight(IHero h, fileio.FileSystem fs) {
        h.fight(this);
    }

    @Override
    public void fight(Knight k, fileio.FileSystem fs) {
        System.out.println("ANGEL DAMAGE IS " + angelDamage + "\n");
        double hpLimit = k.getHp() * EXECUTE_LIMIT;
        if (k.getHp() < hpLimit) {
            k.die();
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) *  MAX_XP_MULTIPLIER);
            this.setXp(xp);
        } else {
            double dmg = EXECUTE_DMG + level * EXECUTE_LVL;
            if (currTerrain == 'L') {
                dmg += dmg * KNI_L_BONUS;
                dmg = Math.round(dmg);
            }
            // dmg += dmg * angelDamage;
            dmg = Math.round(dmg);
            k.damage((int)dmg);
        }

        if (!k.isDead()) {
            double dmg = SLAM + SLAM_LVL * level;
            if (currTerrain == 'L') {
                dmg += dmg * (SLAM_K_BONUS + angelDamage);
                dmg = Math.round(dmg);
                dmg += dmg * (KNI_L_BONUS +  angelDamage);
                dmg = Math.round(dmg);
                k.damage((int)dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            } else {
                dmg += dmg * (SLAM_K_BONUS + angelDamage);
                dmg = Math.round(dmg);
                k.damage((int)dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            }

            if (k.getHp() < 0) {
                k.setDead(true);
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.setXp(xp);
                ObserveHeroKill obs = new ObserveHeroKill();
                obs.heroKill(this, k, fs);
            }
        }
    }

    @Override
    public void fight(Pyromancer k) {
        // System.out.println(this.canMove);
        System.out.println("KNIGHT ANGEL MULTI IS " + angelDamage + "\n");
            double hpLimit = PYR_INIT_HP * EXECUTE_LIMIT;
            if (k.getHp() < hpLimit) {
                k.die();
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.setXp(xp);
            } else {
                double dmg = EXECUTE_DMG + level * EXECUTE_LVL;
                dmg += dmg * (EXECUTE_PYRO_BONUS + angelDamage);
                if (currTerrain == 'L') {
                    dmg += dmg * (KNI_L_BONUS + angelDamage);
                    dmg = Math.round(dmg);
                }
                dmg = Math.round(dmg);
                k.damage((int)dmg);
                System.out.println(dmg + "\n");
            }

            if (!k.isDead()) {
                double dmg = SLAM + SLAM_LVL * level;
                if (currTerrain == 'L') {
                    dmg += dmg * (SLAM_K_BONUS + angelDamage);
                    dmg = Math.round(dmg);
                    dmg -= dmg * (SLAM_PYRO_BONUS - angelDamage);
                    dmg = Math.round(dmg);
                    k.damage((int) dmg);
                    k.setCanMove(false);
                    k.setMoveEffect(1);
                } else {
                    dmg -= dmg * (SLAM_PYRO_BONUS - angelDamage);
                    dmg = Math.round(dmg);
                    k.damage((int) dmg);
                    k.setCanMove(false);
                    k.setMoveEffect(1);
                    System.out.println(dmg + "\n");
                }

                if (k.getHp() < 0) {
                    k.setDead(true);
                    int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                    this.setXp(xp);
                }
            }
    }

    @Override
    public void fight(Rogue k) {
        double hpLimit = ROG_INIT_HP * EXECUTE_LIMIT;
        if (k.getHp() < hpLimit) {
            k.die();
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        } else {
            double dmg = EXECUTE_DMG + level * EXECUTE_LVL;

            if (currTerrain == 'L') {
                dmg += dmg * (KNI_L_BONUS + angelDamage);
                dmg = Math.round(dmg);
            }

            dmg += dmg * (EXECUTE_ROG_BONUS + angelDamage);
            dmg = Math.round(dmg);
            k.damage(Math.round((int)dmg));
        }

        if (!k.isDead()) {
            double dmg = SLAM + SLAM_LVL * level;
            if (currTerrain == 'L') {
                dmg += dmg * (KNI_L_BONUS + angelDamage);
                dmg = Math.round(dmg);
                dmg -= dmg * (SLAM_ROG_BONUS - angelDamage);
                dmg = Math.round(dmg);
                k.damage((int)dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            } else {
                dmg -= dmg * (SLAM_ROG_BONUS - angelDamage);
                dmg = Math.round(dmg);
                k.damage((int)dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            }

            if (k.getHp() < 0) {
                k.setDead(true);
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.setXp(xp);
            }
        }
    }

    @Override
    public void fight(Wizard k) {
        double hpLimit = WIZ_INIT_HP * EXECUTE_LIMIT;
        if (k.getHp() < hpLimit) {
            k.die();
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.setXp(xp);
        } else {
            double dmg = EXECUTE_DMG + level * EXECUTE_LVL;
            dmg -= dmg * (EXECUTE_WIZ_BONUS -  angelDamage);
            if (currTerrain == 'L') {
                dmg += dmg * (KNI_L_BONUS + angelDamage);
                dmg = Math.round(dmg);
            }
            dmg = Math.round(dmg);
            k.damage((int)dmg);
        }

        if (!k.isDead()) {
            double dmg = SLAM + SLAM_LVL * level;
            if (currTerrain == 'L') {
                dmg += dmg * (SLAM_K_BONUS + angelDamage);
                dmg = Math.round(dmg);
                dmg += dmg * (SLAM_WIZ_BONUS + angelDamage);
                dmg = Math.round(dmg);
                k.damage((int)dmg);
                k.setCanMove(false);
                setMoveEffect(1);
            } else {
                dmg += dmg * (SLAM_WIZ_BONUS + angelDamage);
                dmg = Math.round(dmg);
                k.damage((int)dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            }

            if (k.getHp() < 0) {
                k.setDead(true);
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.setXp(xp);
            }

        }

    }

    @Override
    public void setAngelDamage() {
        this.angelDamage += 0.15;
    }

    @Override
    public void draculaDamage() {
        this.damage(60);
        this.angelDamage -= 0.20;
    }

    @Override
    public void goodBoyAction() {
        this.addHp(20);
        this.angelDamage += 0.40;
    }

    @Override
    public void smallAngelAction() {
        this.addHp(10);
        this.angelDamage += 0.10;
    }

    @Override
    public void lifeGiverAction() {
        this.addHp(100);
        if (this.getHp() > KNI_INIT_HP + level * KNI_LVL_HP) {
            this.hp = KNI_INIT_HP + level * KNI_LVL_HP;
        }
    }

    @Override
    public void levelUpAction() {
        int nextXp = MAX_LVL_XP_LIMIT + level * MAX_LVL_XP_MULTIPLIER;
        this.setXp(nextXp - this.xp);
        this.levelUp();
        this.angelDamage += 0.10;
    }

    @Override
    public void spawn() {
        if (this.isDead() == true) {
            this.setDead(false);
            this.setHp(200);
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
