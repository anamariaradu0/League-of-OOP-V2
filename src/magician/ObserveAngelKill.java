package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public final class ObserveAngelKill extends GrandMagician {
    @Override
    public void observe(final Hero a, final Hero b, final Angel c) throws IOException {
        fileio.FileSystem fs = GameFlow.getFS();

        fs.writeWord("Player " + a.type + " " + a.getId() + " was killed by an angel\n");
    }
}
