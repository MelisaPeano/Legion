package university.jala.capstonelegion;

import university.jala.capstonelegion.errors.RuntimeParameterExceptionWithMessage;

public class Troops {
    public static void main(String[] args) throws RuntimeParameterExceptionWithMessage {
        TroopsManager troopsManager = new TroopsManager();
        troopsManager.VerifyParameters(args);
        if (troopsManager.ProcessParameters()) {
            troopsManager.representationOfBattlefield();
            troopsManager.AssignRandomTroops();
            troopsManager.OrderByAlgorithm();
        }

    }
}
