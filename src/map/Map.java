package map;

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

    public void setmRows(int mRows) {
        this.mRows = mRows;
    }

    public void setmCols(int mCols) {
        this.mCols = mCols;
    }

    public void createMap(int rows, int cols) {
        this.mCols = cols;
        this.mRows = rows;
        map = new Cell[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int  j = 0; j < cols; ++j) {
                map[i][j] = new Cell();
            }
        }
    }

    public void setCell(int i, int j, char type) {
        map[i][j].setType(type);
    }

    public Cell get(int i, int j) {
        return map[i][j];
    }

    public void print() {
        for (int i = 0; i < mRows; ++i) {
            for (int j = 0; j < mCols; ++j) {
                System.out.print(map[i][j].getType());
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }
}
