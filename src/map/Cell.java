package map;

import heroes.Hero;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.Collections;

public final class Cell {
    private char type;
    private ArrayList<Hero> currentHeroes;
    private ArrayList<Hero> allHeroes;

    public Cell() {
        currentHeroes = new ArrayList<>();
        allHeroes = new ArrayList<>();
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

    public void reviveHero(Hero h) {
        currentHeroes.add(h);
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

    public void moveHero(Hero h) {
        currentHeroes.remove(h);
        allHeroes.remove(h);
    }

    public void printAllHeroes() {
        System.out.println("PRINTING ALL HEROES");
        for (Hero h : allHeroes) {
            System.out.println(h.type + " " + h.getId());
        }
    }

    public void sortCell() {
        for (int  i = 0; i < allHeroes.size() - 1; ++i) {
            if (allHeroes.get(i).type == allHeroes.get(i + 1).type) {
                if (allHeroes.get(i).getId() > allHeroes.get(i + 1).getId()) {
                    Collections.swap(allHeroes, i, i+1);
                }
            }
        }
    }

    public void battle(fileio.FileSystem fs) throws IOException {
        if (!currentHeroes.get(0).isDead() && !currentHeroes.get(1).isDead()) {
            currentHeroes.get(1).fight(currentHeroes.get(0));
            currentHeroes.get(0).fight(currentHeroes.get(1));
        }

        if (currentHeroes.get(0).isDead() && currentHeroes.get(1).isDead()) {
            removeHero(currentHeroes.get(1));
            removeHero(currentHeroes.get(0));
        } else if (currentHeroes.get(0).isDead()) {
            currentHeroes.get(1).giveXp();
            currentHeroes.get(1).levelUp();
            removeHero(currentHeroes.get(0));
        } else if (currentHeroes.get(1).isDead()) {
            currentHeroes.get(0).giveXp();
            currentHeroes.get(0).levelUp();
            removeHero(currentHeroes.get(1));
        }
    }
}
