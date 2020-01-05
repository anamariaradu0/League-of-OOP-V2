package main;

import java.util.List;

import map.Map;

public final class GameInput {
    private final List<String> heroOrder;
    private final List<Integer> heroInitPositions;
    private final List<String> moves;
    private final int rounds;
    private final Map map;
    private final List<Integer> noAngels;
    private final List<String> angels;

    public GameInput(final List<String> heroOrder, final List<Integer> heroInitPositions,
                     final int rounds, final List<String> moves, final Map m,
                     final List<Integer> noAngels, final List<String> angels) {
        this.heroOrder = heroOrder;
        this.heroInitPositions = heroInitPositions;
        this.moves = moves;
        this.rounds = rounds;
        this.map = m;
        this.noAngels = noAngels;
        this.angels = angels;
    }

    public List<String> getHeroOrder() {
        return heroOrder;
    }

    public List<Integer> getHeroInitPositions() {
        return heroInitPositions;
    }

    public List<String> getMoves() {
        return moves;
    }

    public int getRounds() {
        return rounds;
    }

    public List<Integer> getNoAngels() {
        return noAngels;
    }

    public List<String> getAngels() {
        return angels;
    }

    public Map getMap() {
        return map;
    }

    public boolean isValidInput() {
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

    public void printAngels() {
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

    public void printInput() {
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
