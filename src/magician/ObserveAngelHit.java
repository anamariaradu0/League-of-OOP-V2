package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public final class ObserveAngelHit extends GrandMagician {
    @Override
    public void observe(final Hero a, final Hero b, final Angel c) throws IOException {
        String[] details = Angel.getAngelDetails().split(",");
        String name = details[0];

        fileio.FileSystem fs = GameFlow.getFS();

        fs.writeWord(name + " hit " + a.type + " " + a.getId() + "\n");
    }
}
