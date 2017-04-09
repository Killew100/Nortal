package com.nortal.race.assignment.controller;

import java.awt.*;
import java.util.List;

import com.nortal.race.assignment.model.*;

public class RaceController {


    public RaceController() {
    }

    private List<Point> targetsToCapture;

    public VesselCommand calculateNextCommand(Vessel vessel, RaceArea raceArea) {
        VesselCommand vesselCommand = new VesselCommand(Thruster.FRONT, ThrusterLevel.T0);

        // TODO: Implement algorithm to return command for the vessel to capture all the targets on the raceArea provided
        return vesselCommand;
    }



}

