package strategies;

import heroes.Hero;

public final class Context {
    private IStrategy strategy;

    public Context(final Hero h) {
        switch (h.type) {
            case "Knight":
                this.strategy = new KnightStrategy();
                break;
            case "Pyromancer":
                this.strategy = new PyromancerStrategy();
                break;
            case "Rogue":
                this.strategy = new RogueStrategy();
                break;
            case "Wizard":
                this.strategy = new WizardStrategy();
                break;
        }
    }

    public void executeStrategy(final Hero h) {
        strategy.applyStrategy(h);
    }
}
