package angels.angelVisitors;

public class WizardAngelVisitor {
    private static WizardAngelVisitor instance = null;

    private WizardAngelVisitor() {

    }

    public static WizardAngelVisitor getInstance() {
        if (instance == null) {
            instance = new WizardAngelVisitor();
        }

        return instance;
    }
}
