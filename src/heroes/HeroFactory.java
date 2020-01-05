package heroes;

public final class HeroFactory {
    private HeroFactory() {

    }

    public static Hero getHero(final String inputHero) {
        switch (inputHero) {
            case "W":
                return new Wizard();
            case "P":
                return new Pyromancer();
            case "K":
                return new Knight();
            case "R":
                return new Rogue();
            default:
                return null;
        }
    }
}
