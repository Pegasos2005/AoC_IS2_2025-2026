package software.ulpgc.aoc.reto10.controller;

import software.ulpgc.aoc.reto10.command.*;
import software.ulpgc.aoc.reto10.model.*;

import java.util.List;

public class MachineController {
    public long turnOnMachines(List<MachineLights> machineLights) {
        return new InitializationCommand(machineLights).execute();
    }

    public long regulerVoltMachines(List<MachineVolts> machinesVolts) {
        return new VoltRegulerCommand(machinesVolts).execute();
    }
}
