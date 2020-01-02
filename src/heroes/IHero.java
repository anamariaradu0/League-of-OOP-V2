package heroes;

public interface IHero {
    void fight(IHero h);
    void fight(Knight k);
    void fight(Pyromancer p);
    void fight(Wizard w);
    void fight(Rogue r);
}
