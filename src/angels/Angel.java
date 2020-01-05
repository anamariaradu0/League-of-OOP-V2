package angels;

import heroes.Hero;

import java.io.IOException;

public class Angel {
    private static String angelDetails;

    public Angel(final String angelDetails) {
        this.angelDetails = angelDetails;
    }

    public static String getAngelDetails() {
        return angelDetails;
    }

    /**
     * Method that performs an angel action over a hero.
     *
     * Calls the 'action' method pertaining to each angel.
     */
    public void action(final Hero h) throws IOException {
        Angel angel = AngelFactory.getAngel(angelDetails);
        angel.action(h);
    }
}
