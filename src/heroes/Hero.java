package heroes;

import map.Map;

import java.io.IOException;

import static common.Constants.MAX_MAP;

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
    protected int moveEffect = 0;
    protected float angelDamage = 0f;
    protected float strategyDamage = 0f;
    protected int possibleXp = 0;
    public fileio.FileSystem fs;


    public final void giveXp() {
        this.xp += this.possibleXp;
    }


    public final void addStrategyDamage(final float dmg) {
        strategyDamage += dmg;
    }


    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final boolean canMove() {
        return canMove;
    }

    public abstract void setAngelDamage();
    public abstract void draculaDamage() throws IOException;
    public abstract void goodBoyAction();
    public abstract void smallAngelAction();
    public abstract void xpAngelAction() throws IOException;
    public abstract void lifeGiverAction();
    public abstract void levelUpAction() throws IOException;
    public abstract void spawn();
    public abstract void darkAngelDamage();

    public final int getXp() {
        return xp;
    }

    public final void setXp(final int xp) {
        this.xp += xp;
    }

    public final void setCanMove(final boolean canMove) {
        this.canMove = canMove;
    }

    public final int getRow() {
        return pozRow;
    }

    public final int getCol() {
        return pozCol;
    }

    public final void setHp(final int mhp) {
        this.hp = mhp;
    }

    public final void addHp(final int mhp) {
        this.hp += mhp;
    }

    public final void damage(final int mhp) {
        hp -= mhp;
    }

    public final int getHp() {
        return hp;
    }

    public final boolean isDead() {
        return dead;
    }

    public final void setMoveEffect(final int moveEffect) {
        this.moveEffect = moveEffect;
    }

    public final void setDead(final boolean dead) {
        this.dead = dead;
    }

    public final void setCurrTerrain(final char currTerrain) {
        this.currTerrain = currTerrain;
    }

    public final void setPyroEffect(final int pyroEffect) {
        this.pyroEffect += pyroEffect;
    }

    public final void setPyroDmg(final int pyroDmg) {
        this.pyroDmg += pyroDmg;
    }

    public final void setParalysisEffect(final int paralysisEffect) {
        this.paralysisEffect += paralysisEffect;
        canMove = false;
    }

    public final void setParalysisDmg(final int paralysisDmg) {
        this.paralysisDmg += paralysisDmg;
    }

    public final void previousEffects() {
        if (moveEffect == 0 && paralysisEffect == 0) {
            canMove = true;
        }

        if (moveEffect > 0) {
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
    }

    public final int getLevel() {
        return level;
    }

    public final void setRowCol(final int row, final int col) {
        pozRow = row;
        pozCol = col;
    }

    public abstract void levelUp() throws IOException;

    public final void die() {
        dead = true;
    }

    public final void move(final String s, final Map m) {
        if (this.canMove) {
            if (s.contains("U")) {
                if (pozRow >= 0 && pozRow < MAX_MAP && pozCol >= 0 && pozCol < MAX_MAP) {
                    m.get(pozRow, pozCol).moveHero(this);
                    --pozRow;
                    if (pozRow >= 0 && pozRow < MAX_MAP) {
                        m.get(pozRow, pozCol).addHero(this);
                        currTerrain = m.get(pozRow, pozCol).getType();
                    }
                } else {
                    --pozRow;
                }
            } else if (s.contains("D")) {
                if (pozRow >= 0 && pozRow < MAX_MAP && pozCol >= 0 && pozCol < MAX_MAP) {
                    m.get(pozRow, pozCol).moveHero(this);
                    ++pozRow;
                    if (pozRow >= 0 && pozRow < MAX_MAP) {
                        m.get(pozRow, pozCol).addHero(this);
                        currTerrain = m.get(pozRow, pozCol).getType();
                    }
                } else {
                    ++pozRow;
                }
            } else if (s.contains("L")) {
                if (pozRow >= 0 && pozRow < MAX_MAP && pozCol >= 0 && pozCol < MAX_MAP) {
                    m.get(pozRow, pozCol).moveHero(this);
                    --pozCol;
                    if (pozCol >= 0 && pozCol < MAX_MAP) {
                        m.get(pozRow, pozCol).addHero(this);
                        currTerrain = m.get(pozRow, pozCol).getType();
                    }
                } else {
                    --pozCol;
                }
            } else if (s.contains("R")) {
                if (pozRow >= 0 && pozRow < MAX_MAP && pozCol >= 0 && pozCol < MAX_MAP) {
                    m.get(pozRow, pozCol).moveHero(this);
                    ++pozCol;
                    if (pozCol >= 0 && pozCol < MAX_MAP) {
                        m.get(pozRow, pozCol).addHero(this);
                        currTerrain = m.get(pozRow, pozCol).getType();
                    }
                } else {
                    ++pozCol;
                }
            }
        }
    }
}
