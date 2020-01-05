package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public final class ObserveLevelUp extends GrandMagician {
    @Override
    public void observe(final Hero a, final Hero b, final Angel c) throws IOException {
        if (!a.isDead()) {
            fileio.FileSystem fs = GameFlow.getFS();

            fs.writeWord(a.type + " " + a.getId() + " reached level " + a.getLevel() + "\n");
        }
    }
}
