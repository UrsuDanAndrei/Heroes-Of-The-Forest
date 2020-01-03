package angels.angelVisitors;

public class PyromancerAngelVisitor {
    private static PyromancerAngelVisitor instance = null;

    private PyromancerAngelVisitor() {

    }

    public static PyromancerAngelVisitor getInstance() {
        if (instance == null) {
            instance = new PyromancerAngelVisitor();
        }

        return instance;
    }
}
