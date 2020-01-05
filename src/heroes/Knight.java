package heroes;

import magician.GrandMagician;
import magician.ObserveAngelKill;
import magician.ObserveHeroKill;
import magician.ObserveLevelUp;
import map.Map;

import java.io.IOException;

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
    public void fight(final IHero h) throws IOException {
        h.fight(this);
    }

    @Override
    public void fight(final Knight k) throws IOException {
        float hpLimit = k.getHp() * EXECUTE_LIMIT;
        if (k.getHp() < hpLimit) {
            k.die();
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) *  MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        } else {
            float dmg = EXECUTE_DMG + level * EXECUTE_LVL;
            if (currTerrain == 'L') {
                dmg += dmg * KNI_L_BONUS;
                dmg = Math.round(dmg);
            }
            dmg = Math.round(dmg);
            k.damage((int) dmg);
        }

        if (!k.isDead()) {
            float dmg = SLAM + SLAM_LVL * level;
            if (currTerrain == 'L') {
                dmg += dmg * (SLAM_K_BONUS + angelDamage + strategyDamage);
                dmg = Math.round(dmg);
                dmg += dmg * KNI_L_BONUS;
                dmg = Math.round(dmg);
                k.damage((int) dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            } else {
                dmg += dmg * (SLAM_K_BONUS + angelDamage + strategyDamage);
                dmg = Math.round(dmg);
                k.damage((int) dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            }

            if (k.getHp() < 0) {
                k.setDead(true);
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.possibleXp = xp;
                GrandMagician obs = new ObserveHeroKill();
                obs.observe(this, k, null);
            }
        }
    }

    @Override
    public void fight(final Pyromancer k) throws IOException {
            float hpLimit = PYR_INIT_HP * EXECUTE_LIMIT;
            if (k.getHp() < hpLimit) {
                k.die();
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.possibleXp = xp;
                GrandMagician obs = new ObserveHeroKill();
                obs.observe(this, k, null);
            } else {
                float dmg = EXECUTE_DMG + level * EXECUTE_LVL;
                dmg += dmg * (EXECUTE_PYRO_BONUS + angelDamage + strategyDamage);
                if (currTerrain == 'L') {
                    dmg += dmg * KNI_L_BONUS;
                    dmg = Math.round(dmg);
                }
                dmg = Math.round(dmg);
                k.damage((int) dmg);
                System.out.println(dmg + "\n");
            }

            if (!k.isDead()) {
                float dmg = SLAM + SLAM_LVL * level;
                if (currTerrain == 'L') {
                    dmg += dmg * KNI_L_BONUS;
                    dmg = Math.round(dmg);
                    dmg -= dmg * (SLAM_PYRO_BONUS - angelDamage - strategyDamage);
                    dmg = Math.round(dmg);
                    k.damage((int) dmg);
                    k.setCanMove(false);
                    k.setMoveEffect(1);
                } else {
                    dmg -= dmg * (SLAM_PYRO_BONUS - angelDamage - strategyDamage);
                    dmg = Math.round(dmg);
                    k.damage((int) dmg);
                    k.setCanMove(false);
                    k.setMoveEffect(1);
                    System.out.println(dmg + "\n");
                }

                if (k.getHp() < 0) {
                    k.setDead(true);
                    int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                    this.possibleXp = xp;
                    GrandMagician obs = new ObserveHeroKill();
                    obs.observe(this, k, null);
                }
            }
    }

    @Override
    public void fight(final Rogue k) throws IOException {
        float hpLimit = ROG_INIT_HP * EXECUTE_LIMIT;
        if (k.getHp() < hpLimit) {
            k.die();
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        } else {
            float dmg = EXECUTE_DMG + level * EXECUTE_LVL;

            if (currTerrain == 'L') {
                dmg += dmg * KNI_L_BONUS;
                dmg = Math.round(dmg);
            }

            dmg += dmg * (EXECUTE_ROG_BONUS + angelDamage + strategyDamage);
            dmg = Math.round(dmg);
            k.damage(Math.round((int) dmg));
        }

        if (!k.isDead()) {
            float dmg = SLAM + SLAM_LVL * level;
            if (currTerrain == 'L') {
                dmg += dmg * KNI_L_BONUS;
                dmg = Math.round(dmg);
                dmg -= dmg * (SLAM_ROG_BONUS - angelDamage - strategyDamage);
                dmg = Math.round(dmg);
                k.damage((int) dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            } else {
                dmg -= dmg * (SLAM_ROG_BONUS - angelDamage - strategyDamage);
                dmg = Math.round(dmg);
                k.damage((int) dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
            }

            if (k.getHp() < 0) {
                k.setDead(true);
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.possibleXp = xp;
                GrandMagician obs = new ObserveHeroKill();
                obs.observe(this, k, null);
            }
        }
    }

    @Override
    public void fight(final Wizard k) throws IOException {
        float hpLimit = WIZ_INIT_HP * EXECUTE_LIMIT;
        if (k.getHp() < hpLimit) {
            k.die();
            int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
            this.possibleXp = xp;
            GrandMagician obs = new ObserveHeroKill();
            obs.observe(this, k, null);
        } else {
            float dmg = EXECUTE_DMG + level * EXECUTE_LVL;
            dmg -= dmg * (EXECUTE_WIZ_BONUS -  angelDamage - strategyDamage);
            if (currTerrain == 'L') {
                dmg += dmg * KNI_L_BONUS;
                dmg = Math.round(dmg);
            }
            dmg = Math.round(dmg);
            k.damage((int) dmg);
            System.out.println(" EXECUTE DAMAGE " + dmg);
        }



        if (!k.isDead()) {
            float dmg = SLAM + SLAM_LVL * level;
            if (currTerrain == 'L') {
                dmg += dmg * KNI_L_BONUS;
                dmg = Math.round(dmg);
                dmg += dmg * (SLAM_WIZ_BONUS + angelDamage + strategyDamage);
                dmg = Math.round(dmg);
                k.damage((int) dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
                System.out.println(" SLAM DAMAGE " + dmg);
            } else {
                dmg += dmg * (SLAM_WIZ_BONUS + angelDamage + strategyDamage);
                dmg = Math.round(dmg);
                k.damage((int) dmg);
                k.setCanMove(false);
                k.setMoveEffect(1);
                System.out.println(" SLAM DAMAGE " + dmg);
            }

            if (k.getHp() < 0) {
                k.setDead(true);
                int xp = max(0, MAX_XP_LIMIT - (this.level - k.getLevel()) * MAX_XP_MULTIPLIER);
                this.possibleXp = xp;
                GrandMagician obs = new ObserveHeroKill();
                obs.observe(this, k, null);
            }

        }

    }

    @Override
    public void setAngelDamage() {
        this.angelDamage += KNI_DAMAGEANGEL;
    }

    @Override
    public void draculaDamage() throws IOException {
        this.damage(KNI_DRACULA_DAMAGE);
        this.angelDamage -= KNI_DRACULA_MOD;
        if (this.hp < 0) {
            this.setDead(true);
            GrandMagician obs = new ObserveAngelKill();
            obs.observe(this, null, null);
        }
    }

    @Override
    public void goodBoyAction() {
        this.addHp(KNI_GOODBOY_HP);
        this.angelDamage += KNI_GOODBOY_MOD;
    }

    @Override
    public void smallAngelAction() {
        this.addHp(KNI_SMALLANGEL_HP);
        this.angelDamage += KNI_SMALLANGEL_MOD;
    }

    @Override
    public void lifeGiverAction() {
        this.addHp(KNI_LIFEGIVER_HP);
        if (this.getHp() > KNI_INIT_HP + level * KNI_LVL_HP) {
            this.hp = KNI_INIT_HP + level * KNI_LVL_HP;
        }
    }

    @Override
    public void darkAngelDamage() {
        this.damage(KNI_DA_DAMAGE);
    }

    @Override
    public void levelUpAction() throws IOException {
        int nextXp = MAX_LVL_XP_LIMIT + level * MAX_LVL_XP_MULTIPLIER;
        this.setXp(nextXp - this.xp);
        this.levelUp();
        this.angelDamage += KNI_LEVELUP_MOD;
    }

    @Override
    public void xpAngelAction() throws IOException {
        this.setXp(KNI_XP_ANGEL);
        this.levelUp();
    }

    @Override
    public void spawn() {
        if (this.isDead()) {
            this.setDead(false);
            this.setHp(KNI_SPAWN_HP);
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

}
