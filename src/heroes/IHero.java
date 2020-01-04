package heroes;

import java.io.IOException;

public interface IHero {
    void fight(IHero h) throws IOException;
    void fight(Knight k) throws IOException;
    void fight(Pyromancer p) throws IOException;
    void fight(Wizard w) throws IOException;
    void fight(Rogue r) throws IOException;
}
