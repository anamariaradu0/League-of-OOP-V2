package magician;

import angels.Angel;
import heroes.Hero;

import java.io.IOException;

public abstract class GrandMagician {
    public abstract void observe(Hero a, Hero b, Angel c) throws IOException;
}
