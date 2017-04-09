package com.nortal.race.assignment.controller;

import com.nortal.race.assignment.model.RaceArea;
import com.nortal.race.assignment.model.Thruster;
import com.nortal.race.assignment.model.ThrusterLevel;
import com.nortal.race.assignment.model.Vessel;
import com.nortal.race.assignment.model.VesselCommand;

import java.awt.*;
import java.util.List;

public class RaceController {
    private boolean stop = false;
    private int count = 0;


    public RaceController() {
    }

    private List<Point> targetsToCapture;

    public VesselCommand calculateNextCommand(Vessel vessel, RaceArea raceArea) {
        VesselCommand vesselCommand = new VesselCommand(Thruster.BACK, ThrusterLevel.T0);
        double x = raceArea.getTargets().get(count).getX();
        double y = raceArea.getTargets().get(count).getY();
        double x2 = vessel.getPosition().getX();
        double y2 = vessel.getPosition().getY();

        if ((x2 <= x-2 || x2 >= x+2) && !stop){
            if (x < x2){
                vesselCommand.setThruster(Thruster.RIGHT);
                vesselCommand.setThrusterLevel(ThrusterLevel.T2);
                System.out.println("yay");
            } else {
                vesselCommand.setThruster(Thruster.LEFT);
                vesselCommand.setThrusterLevel(ThrusterLevel.T2);
            }
        } else if((y2 <= y-2 || y2 >= y+2)) {
            if (y < y2){
                vesselCommand.setThruster(Thruster.FRONT);
                vesselCommand.setThrusterLevel(ThrusterLevel.T2);
            } else {
                vesselCommand.setThruster(Thruster.BACK);
                vesselCommand.setThrusterLevel(ThrusterLevel.T2);
            }
        } else if ((x2 >= x-2 || x2 <= x+2) && (y2 >= y-2 || y2 <= y+2)){
            count++;
        } else{
            vesselCommand.setThrusterLevel(ThrusterLevel.T0);
        }

        // TODO: Implement algorithm to return command for the vessel to capture all the targets on the raceArea provided
        return vesselCommand;
    }



}

