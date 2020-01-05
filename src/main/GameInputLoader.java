package main;

import fileio.FileSystem;
import map.Map;

import java.util.ArrayList;
import java.util.List;

public final class GameInputLoader {
    private final String inPath;
    private final String outPath;

    public GameInputLoader(final String inPath, final String outPath) {
        this.inPath = inPath;
        this.outPath = outPath;
    }

    public GameInput load() {
        int matrixRows = 0;
        int matrixCols = 0;
        String terrainType = null;

        int noHeroes;

        int rounds = 0;

        List<String> heroOrder = new ArrayList<>();
        List<Integer> heroInitPositions = new ArrayList<>();
        List<String> moves = new ArrayList<>();
        List<String> angels = new ArrayList<>();
        List<Integer> noAngels = new ArrayList<>();
        Map m = Map.getInstance();

        try {
            FileSystem fs = new FileSystem(inPath, outPath);
            matrixRows = fs.nextInt();
            matrixCols = fs.nextInt();

            m.setmCols(matrixCols);
            m.setmRows(matrixRows);

            m.createMap(matrixRows, matrixCols);

            for (int i = 0; i < matrixRows; ++i) {
                terrainType = fs.nextWord();
                for (int j = 0; j < matrixCols; ++j) {
                    m.setCell(i, j, terrainType.charAt(i));
                }
            }

            noHeroes = fs.nextInt();

            for (int i = 0; i < noHeroes; ++i) {
                heroOrder.add(fs.nextWord());
                heroInitPositions.add(fs.nextInt());
                heroInitPositions.add(fs.nextInt());
            }

            rounds = fs.nextInt();
            for (int i = 0; i < rounds; ++i) {
                moves.add(fs.nextWord());
            }

            for (int i = 0; i < rounds; ++i) {
                int aux = fs.nextInt();
                noAngels.add(aux);
                if (aux != 0) {
                    for (int j = 0; j < aux; ++j) {
                        angels.add(fs.nextWord());
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(heroOrder, heroInitPositions, rounds, moves, m, noAngels, angels);
    }
}
