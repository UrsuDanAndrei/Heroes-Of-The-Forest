package angels.angelVisitors;

public class RogueAngelVisitor {
    private static RogueAngelVisitor instance = null;

    private RogueAngelVisitor() {

    }

    public static RogueAngelVisitor getInstance() {
        if (instance == null) {
            instance = new RogueAngelVisitor();
        }

        return instance;
    }
}
