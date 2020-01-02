package main;

import java.util.List;

import heroes.Hero;
import map.Map;

public class GameInput {
    private final List<String> heroOrder;
    private final List<Integer> heroInitPositions;
    private final List<String> moves;
    private final int rounds;
    private final Map map;
    private final List<Integer> noAngels;
    private final List<String> angels;



    public GameInput(List<String> heroOrder, List<Integer> heroInitPositions,
                     int rounds, List<String> moves, Map m, List<Integer> noAngels, List<String> angels) {
        this.heroOrder = heroOrder;
        this.heroInitPositions = heroInitPositions;
        this.moves = moves;
        this.rounds = rounds;
        this.map = m;
        this.noAngels = noAngels;
        this.angels = angels;
    }

    public final List<String> getHeroOrder() {
        return heroOrder;
    }

    public final List<Integer> getHeroInitPositions() {
        return heroInitPositions;
    }

    public final List<String> getMoves() {
        return moves;
    }

    public final int getRounds() {
        return rounds;
    }

    public List<Integer> getNoAngels() {
        return noAngels;
    }

    public List<String> getAngels() {
        return angels;
    }

    public final Map getMap() {
        return map;
    }

    public final boolean isValidInput() {
        boolean heroesInitiated = heroOrder != null && heroInitPositions != null;
        boolean heroesNotEmpty = heroOrder.size() > 0 && heroInitPositions.size() > 0;
        boolean heroesOk = heroesNotEmpty && heroesInitiated;

        boolean terrainOk = map != null;
        boolean roundsOk = rounds > 0;
        boolean playOk = terrainOk && roundsOk;

        boolean movesInitiated = moves != null;
        boolean movesNotEmpty = moves.size() > 0;
        boolean movesOk = movesInitiated && movesNotEmpty;

        return heroesOk && playOk && movesOk;
    }

    public final void printAngels() {
        int angelIndex = 0;
        for (int i = 0; i < rounds; ++i) {
            System.out.print(noAngels.get(i));
            System.out.print(" ");
            for (int j = 0; j < noAngels.get(i); ++j) {
                System.out.print(angels.get(angelIndex + j));
                System.out.print(" ");
            }
            angelIndex += noAngels.get(i);
            System.out.println("\n");
        }
    }

    public final void printInput() {
        map.print();
        System.out.println("Heroes below");
        for (int i = 0; i < heroOrder.size(); ++i) {
            System.out.println(heroOrder.get(i));
        }
        System.out.println("Initial positions below");
        for (int i = 0; i < heroInitPositions.size(); ++i) {
            System.out.println(heroInitPositions.get(i));
        }
        System.out.println("Rounds below");
        System.out.println(rounds);
        System.out.println("Moves below");
        for (int i = 0; i < moves.size(); ++i) {
            System.out.println(moves.get(i));
        }
    }
}
