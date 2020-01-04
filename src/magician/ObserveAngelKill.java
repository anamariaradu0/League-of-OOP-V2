package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public class ObserveAngelKill extends GrandMagician {
    @Override
    public void observe(Hero a, Hero b, Angel c) throws IOException {
        fileio.FileSystem fs = GameFlow.getFS();

        fs.writeWord("Player " + a.type + " " + a.getId() + " was killed by an angel\n");
    }
}
