package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public final class ObserveHeroKill extends GrandMagician {
    @Override
    public void observe(final Hero a, final Hero b, final Angel c) throws IOException {
        fileio.FileSystem fs = GameFlow.getFS();

        fs.writeWord("Player " + b.type + " " + b.getId() + " was killed by "
                + a.type + " " + a.getId() + "\n");
    }
}
