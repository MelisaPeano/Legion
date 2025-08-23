package university.jala.capstonelegion;

import university.jala.capstonelegion.errors.RuntimeParameterExceptionWithMessage;

public class Troops {
    public static void main(String[] args) throws RuntimeParameterExceptionWithMessage {
        TroopsManager troopsManager = new TroopsManager();
        troopsManager.verifyParameters(args);
        if (troopsManager.processParameters()) {
            troopsManager.representationOfBattlefield();
            troopsManager.assignRandomTroops();
            troopsManager.orderByAlgorithm();
        }

    }
}
