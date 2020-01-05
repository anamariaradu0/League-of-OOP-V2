package gameflow;

import angels.Angel;
import heroes.Hero;
import heroes.HeroFactory;
import magician.GrandMagician;
import magician.ObserveAngelSpawn;
import main.GameInput;
import map.Map;
import strategies.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class GameFlow {
    private static List<String> heroOrder;
    private static List<Integer> heroInitPositions;
    private static List<String> moves;
    private static int rounds;
    private static ArrayList<Hero> heroes;
    private static List<Integer> noAngels;
    private static List<String> angels;
    private static fileio.FileSystem fs;

    private GameFlow() {
    }

    public static void receiveFS(final fileio.FileSystem fsystem) {
        GameFlow.fs = fsystem;
    }

    public static fileio.FileSystem getFS() {
        return fs;
    }

    public static void getInput(final GameInput input) {
        heroOrder = new ArrayList<>();
        heroInitPositions = new ArrayList<>();
        moves = new ArrayList<>();
        heroes = new ArrayList<>();
        noAngels = new ArrayList<>();
        angels = new ArrayList<>();

        heroOrder = input.getHeroOrder();
        heroInitPositions = input.getHeroInitPositions();
        moves = input.getMoves();
        rounds = input.getRounds();
        noAngels = input.getNoAngels();
        angels = input.getAngels();

        for (String h : heroOrder) {
            heroes.add(HeroFactory.getHero(h));
        }

    }

    public static void addHeroesToMap(final Map m) {
        int poz = 0;
        int id = 0;
        for (Hero h : heroes) {
            h.setId(id);
            ++id;
            int hRow = heroInitPositions.get(poz);
            ++poz;
            int hCol = heroInitPositions.get(poz);
            ++poz;
            h.setRowCol(hRow, hCol);
            h.setCurrTerrain(m.get(hRow, hCol).getType());
            m.get(hRow, hCol).addHero(h);
        }
    }

    public static void play(final Map m, final fileio.FileSystem fsystem) throws IOException {
        for (int i = 0; i < rounds; ++i) {
            fsystem.writeWord("~~ Round ");
            fsystem.writeInt(i + 1);
            fsystem.writeWord(" ~~\n");
            String currentMoves = moves.get(i);
            for (int j = 0; j < m.getmRows(); ++j) {
                for (int k = 0; k < m.getmCols(); ++k) {
                    m.get(j, k).applyEffects();
                }
            }

            for (Hero h : heroes) {
                if (h.canMove()) {
                    Context context = new Context(h);
                    context.executeStrategy(h);
                }
            }

            for (Hero h : heroes) {
                h.move(currentMoves.substring(0, 1), m);
                currentMoves = currentMoves.substring(1);
            }

            for (int j = 0; j < m.getmRows(); ++j) {
                for (int k = 0; k < m.getmCols(); ++k) {
                    if (m.get(j, k).getCurrentHeroes() > 1) {
                        m.get(j, k).battle();
                    }
                }
            }

            int aux = 0;
            for (int j = 0; j < i; ++j) {
                aux += noAngels.get(j);
            }

            for (int j = 0; j < noAngels.get(i); ++j) {
                Angel angel = new Angel(angels.get(aux + j));

                String angelToParse = angels.get(aux + j);
                String[] angelDetails = angelToParse.split(",");
                int angX = Integer.parseInt(angelDetails[1]);
                int angY = Integer.parseInt(angelDetails[2]);

                GrandMagician obs = new ObserveAngelSpawn();
                obs.observe(null, null, angel);

                m.get(angX, angY).sortCell();
                for (Hero h : m.get(angX, angY).getAllHeroes()) {
                    angel.action(h);
                }
            }
            fsystem.writeWord("\n");
        }
    }

    public static void showLeaderBoard(final fileio.FileSystem fsystem) throws IOException {
        fsystem.writeWord("~~ Results ~~\n");
        for (int i = 0; i < heroes.size(); ++i) {
            if (heroes.get(i).isDead()) {
                fsystem.writeWord(heroes.get(i).type.substring(0, 1));
                fsystem.writeWord(" dead");
                fsystem.writeWord("\n");
            } else {
                fsystem.writeWord(heroes.get(i).type.substring(0, 1));
                fsystem.writeWord(" ");
                fsystem.writeInt(heroes.get(i).getLevel());
                fsystem.writeWord(" ");
                fsystem.writeInt(heroes.get(i).getXp());
                fsystem.writeWord(" ");
                fsystem.writeInt(heroes.get(i).getHp());
                fsystem.writeWord(" ");
                fsystem.writeInt(heroes.get(i).getRow());
                fsystem.writeWord(" ");
                fsystem.writeInt(heroes.get(i).getCol());
                fsystem.writeWord("\n");
            }
        }
    }
}
