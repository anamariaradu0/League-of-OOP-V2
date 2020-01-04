package angels;

import heroes.Hero;

import java.io.IOException;

public class Angel {
    static String angelDetails;

    public Angel(String angelDetails) {
        this.angelDetails = angelDetails;
    }

    public static String getAngelDetails() {
        return angelDetails;
    }

    public void action(Hero h) throws IOException {
        Angel angel = AngelFactory.getAngel(angelDetails);
        angel.action(h);
    }
}
