package software.ulpgc.aoc.reto04.controller;

import software.ulpgc.aoc.reto04.command.CountAccessibleRolls;
import software.ulpgc.aoc.reto04.command.RemoveAccessRolls;
import software.ulpgc.aoc.reto04.model.RollGrid;

public class StoreController {

    public long countAccessibleRolls(RollGrid grid) {
        return new CountAccessibleRolls(grid).execute();
    }

    public long removeAllAccessRolls(RollGrid grid) {
        RemoveAccessRolls command = new RemoveAccessRolls(grid);

        long count = 0;
        long delRolls = command.execute();
        while (delRolls != 0) {
            count += delRolls;
            delRolls = command.execute();
        }
        return count;
    }
}
