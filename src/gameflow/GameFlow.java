package gameflow;

import angels.Angel;
import angels.TheDoomer;
import angels.XPAngel;
import heroes.Hero;
import heroes.HeroFactory;
import main.GameInput;
import map.Map;
import strategies.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameFlow {
    private static List<String> heroOrder;
    private static List<Integer> heroInitPositions;
    private static List<String> moves;
    private static int rounds;
    private static ArrayList<Hero> heroes;
    private static List<Integer> noAngels;
    private static List<String> angels;

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

    public static void addHeroesToMap(Map m) {
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

    public static void play(Map m, fileio.FileSystem fs) throws IOException {
        for (int i = 0; i < rounds; ++i) {
            fs.writeWord("~~ Round ");
            fs.writeInt(i + 1);
            fs.writeWord(" ~~\n");
            String currentMoves = moves.get(i);
            for (int j = 0; j < m.getmRows(); ++j) {
                for (int k = 0; k < m.getmCols(); ++k) {
                    m.get(j, k).applyEffects();
                    System.out.println("I AM APPLYING EFFECTS");
                }
            }

            for (Hero h : heroes) {
                Context context = new Context(h);
                context.executeStrategy(h);
            }

            for (Hero h : heroes) {
                h.move(currentMoves.substring(0, 1), m);
                currentMoves = currentMoves.substring(1);
            }

            for (int j = 0; j < m.getmRows(); ++j) {
                for (int k = 0; k < m.getmCols(); ++k) {
                    if (m.get(j, k).getCurrentHeroes() > 1) {
                        m.get(j, k).battle(fs);
                    }
                }
            }

            int aux = 0;
            for (int j = 0; j < i; ++j) {
                aux += noAngels.get(j);
            }
            System.out.println("aux is " + aux);

            for (int j = 0; j < noAngels.get(i); ++j) {
                Angel angel = new Angel(angels.get(aux + j));

                String angelToParse = angels.get(aux + j);
                String[] angelDetails = angelToParse.split(",");
                String name = angelDetails[0];
                int angX = Integer.parseInt(angelDetails[1]);
                int angY = Integer.parseInt(angelDetails[2]);

                angel.spawnPrint(angX, angY, fs);

                for (Hero h : m.get(angX, angY).getHeroes()) {
                    angel.action(h);
                    angel.angPrint(angX, angY, h.type, h.getId(), fs);
                }

                // showLeaderBoard(fs);
            }
            fs.writeWord("\n");
        }
    }

    public static void showLeaderBoard(fileio.FileSystem fs) throws IOException {
        fs.writeWord("~~ Results ~~\n");
        for (int i = 0; i < heroes.size(); ++i) {
            if (heroes.get(i).isDead()) {
                fs.writeWord(heroes.get(i).type.substring(0,1));
                fs.writeWord(" dead");
                fs.writeWord("\n");
            } else {
                // fs.writeInt(heroes.get(i).getId());
                // fs.writeWord(" ");
                fs.writeWord(heroes.get(i).type.substring(0,1));
                fs.writeWord(" ");
                fs.writeInt(heroes.get(i).getLevel());
                fs.writeWord(" ");
                fs.writeInt(heroes.get(i).getXp());
                fs.writeWord(" ");
                fs.writeInt(heroes.get(i).getHp());
                fs.writeWord(" ");
                fs.writeInt(heroes.get(i).getRow());
                fs.writeWord(" ");
                fs.writeInt(heroes.get(i).getCol());
                fs.writeWord("\n");
            }
        }
    }
}
