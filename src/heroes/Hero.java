package heroes;

import map.Map;

import java.io.IOException;

public abstract class Hero implements IHero {
    protected int id;
    public String type;
    protected int hp;
    protected int xp;
    protected int pozRow;
    protected int pozCol;
    protected int level;
    protected boolean dead;
    protected boolean canMove;
    protected char currTerrain;
    protected int pyroEffect;
    protected int pyroDmg;
    protected int paralysisEffect;
    protected int paralysisDmg;
    protected int kill = 0;
    protected int moveEffect = 0;
    protected float angelDamage = 0f;
    protected float strategyDamage = 0f;
    protected int possibleXp = 0;
    public fileio.FileSystem fs;

    public void giveXp() {
        System.out.println("GIVING XP " + possibleXp);
        this.xp += this.possibleXp;
    }

    public void addStrategyDamage(float dmg) {
        strategyDamage += dmg;
    }
    public void setStrategyDamage(float dmg) {
        strategyDamage = dmg;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addAngelDamage (float dmg) {
        this.angelDamage += dmg;
    }

    public boolean canMove() {
        return canMove;
    }

    public abstract void setAngelDamage();
    public abstract void draculaDamage() throws IOException;
    public abstract void goodBoyAction();
    public abstract void smallAngelAction();
    public abstract void lifeGiverAction();
    public abstract void levelUpAction() throws IOException;
    public abstract void spawn();

    public final int getXp() {
        return xp;
    }

    public final void setXp(int xp) {
        this.xp += xp;
    }

    public final void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public final int getRow() {
        return pozRow;
    }

    public final int getCol() {
        return pozCol;
    }

    public final void setHp(int hp) {
        this.hp = hp;
    }

    public final void addHp(int hp) {
        this.hp += hp;
    }

    public final void damage(int mhp) {
        hp -= mhp;
    }

    public final int getHp() {
        return hp;
    }

    public final boolean isDead() {
        return dead;
    }

    public final void setMoveEffect(int moveEffect) {
        this.moveEffect = moveEffect;
    }

    public final void setDead(boolean dead) {
        this.dead = dead;
    }

    public final void setCurrTerrain(char currTerrain) {
        this.currTerrain = currTerrain;
    }

    public final void setPyroEffect(int pyroEffect) {
        this.pyroEffect += pyroEffect;
    }

    public final void setPyroDmg(int pyroDmg) {
        this.pyroDmg += pyroDmg;
    }

    public final void setParalysisEffect(int paralysisEffect) {
        this.paralysisEffect += paralysisEffect;
        canMove = false;
    }

    public final void setParalysisDmg(int paralysisDmg) {
        this.paralysisDmg += paralysisDmg;
    }

    public final void previousEffects() {
        // System.out.println(this.type);
        // System.out.println("FIRST " + canMove + "\n");
        // System.out.println("MOVE EFFECT IS " + moveEffect + "\n");
        if (moveEffect == 0 && paralysisEffect == 0) {
            canMove = true;
        }

        if (moveEffect > 0) {
            // System.out.println("CAN'T MOVE\n");
            --moveEffect;
        }

        if (pyroEffect == 0) {
            pyroDmg = 0;
        }

        if (pyroEffect > 0) {
            --pyroEffect;
            damage(pyroDmg);
        }

        if (paralysisEffect == 0) {
            paralysisDmg = 0;
        }

        if (paralysisEffect > 0) {
            --paralysisEffect;
            damage(paralysisDmg);
        }

        if (hp < 0) {
            this.setDead(true);
        }
        // System.out.println("SECOND " + canMove);
    }

    public final int getLevel() {
        return level;
    }

    public final void setRowCol(int row, int col) {
        pozRow = row;
        pozCol = col;
    }

    public abstract void levelUp() throws IOException;

    public final void die() {
        dead = true;
    }

    public final void move(String s, Map m) {
        if (this.canMove) {
            if (s.contains("U")) {
                m.get(pozRow, pozCol).moveHero(this);
                --pozRow;
                m.get(pozRow, pozCol).addHero(this);
                currTerrain = m.get(pozRow, pozCol).getType();
            } else if (s.contains("D")) {
                m.get(pozRow, pozCol).moveHero(this);
                ++pozRow;
                m.get(pozRow, pozCol).addHero(this);
                currTerrain = m.get(pozRow, pozCol).getType();
            } else if (s.contains("L")) {
                m.get(pozRow, pozCol).moveHero(this);
                --pozCol;
                m.get(pozRow, pozCol).addHero(this);
                currTerrain = m.get(pozRow, pozCol).getType();
            } else if (s.contains("R")) {
                m.get(pozRow, pozCol).moveHero(this);
                ++pozCol;
                m.get(pozRow, pozCol).addHero(this);
                currTerrain = m.get(pozRow, pozCol).getType();
            }
        }
    }
}
