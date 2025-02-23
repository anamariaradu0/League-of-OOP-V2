package map;

import heroes.Hero;

public final class Map {
    private static Map instance = null;

    private int mRows;
    private int mCols;
    private Cell[][] map;

    private Map() {
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }

        return instance;
    }

    public int getmCols() {
        return mCols;
    }

    public int getmRows() {
        return mRows;
    }

    public void setmRows(final int mRows) {
        this.mRows = mRows;
    }

    public void setmCols(final int mCols) {
        this.mCols = mCols;
    }

    public void createMap(final int rows, final int cols) {
        this.mCols = cols;
        this.mRows = rows;
        map = new Cell[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int  j = 0; j < cols; ++j) {
                map[i][j] = new Cell();
            }
        }
    }

    public void setCell(final int i, final int j, final char type) {
        map[i][j].setType(type);
    }

    public Cell get(final int i, final int j) {
        return map[i][j];
    }

    public void print() {
        for (int i = 0; i < mRows; ++i) {
            for (int j = 0; j < mCols; ++j) {
                for (Hero k : map[i][j].getAllHeroes()) {
                    System.out.println(k.type + " " + k.getId() + " "
                            + k.getRow() + " " + k.getCol());
                }
            }
            System.out.println("\n");
        }
    }
}
