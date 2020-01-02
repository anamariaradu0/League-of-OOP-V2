package map;

import heroes.Hero;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.ArrayList;

public final class Cell {
    private char type;
    private int noHeroes;
    private ArrayList<Hero> currentHeroes;
    private ArrayList<Hero> allHeroes;

    public Cell() {
        currentHeroes = new ArrayList<>();
        allHeroes = new ArrayList<>();
        noHeroes = 0;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void addHero(Hero h) {
        currentHeroes.add(h);
        allHeroes.add(h);
    }

    public void removeHero(Hero h) {
        currentHeroes.remove(h);
    }

    public int getCurrentHeroes() {
        return currentHeroes.size();
    }

    public ArrayList<Hero> getHeroes() { return currentHeroes; }

    public ArrayList<Hero> getAllHeroes() {
        return allHeroes;
    }

    public void applyEffects() {
        for (Hero h : currentHeroes) {
            h.previousEffects();
        }
    }

    public void battle(fileio.FileSystem fs) throws IOException {
        if (!currentHeroes.get(0).isDead() && !currentHeroes.get(1).isDead()) {
            currentHeroes.get(0).fight(currentHeroes.get(1));
            Hero hero1 = currentHeroes.get(1);
            Hero hero2 = currentHeroes.get(0);
            currentHeroes.get(1).fight(currentHeroes.get(0));
            if (currentHeroes.get(1).isDead()) {
                fs.writeWord("Player " + hero1.type + " " + hero1.getId() + " was killed by " + hero2.type + " " + hero2.getId() + "\n");
            }
            if (currentHeroes.get(0).isDead()) {
                fs.writeWord("Player " + hero2.type + " " + hero2.getId() + " was killed by " + hero1.type + " " + hero1.getId() + "\n");
            }
        }

        if (currentHeroes.get(0).isDead() && currentHeroes.get(1).isDead()) {
            currentHeroes.get(0).levelUp();
            currentHeroes.get(1).levelUp();
            // removeHero(currentHeroes.get(1));
            // removeHero(currentHeroes.get(0));
        } else if (currentHeroes.get(0).isDead()) {
            currentHeroes.get(1).levelUp();
            // removeHero(currentHeroes.get(0));
        } else if (currentHeroes.get(1).isDead()) {
            currentHeroes.get(0).levelUp();
            // removeHero(currentHeroes.get(1));
        }
    }
}
