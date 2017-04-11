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
    private double x;
    private double y;
    private boolean take = true;
    private Point point;
    private boolean taken;
    public RaceController() {
    }

    private List<Point> targetsToCapture;

    private void sortList(Vessel vessel){
        targetsToCapture.sort((z1, z2) -> {
            if (Math.sqrt(Math.abs(Math.pow(z1.getX() - vessel.getPosition().getX(), 2) + Math.pow(z1.getY() - vessel.getPosition().getY(), 2))) < Math.sqrt(Math.abs(Math.pow(z2.getX() - vessel.getPosition().getX(), 2) + Math.pow(z2.getY() - vessel.getPosition().getY(), 2))))
                return -1;
            if (Math.sqrt(Math.abs(Math.pow(z1.getX() - vessel.getPosition().getX(), 2) + Math.pow(z1.getY() - vessel.getPosition().getY(), 2))) > Math.sqrt(Math.abs(Math.pow(z2.getX() - vessel.getPosition().getX(), 2) + Math.pow(z2.getY() - vessel.getPosition().getY(), 2))))
                return 1;
            return 0;
        });
    }
    public VesselCommand calculateNextCommand(Vessel vessel, RaceArea raceArea) {
        if (!taken){
            taken = true;
            targetsToCapture = raceArea.getTargets();
        }
        VesselCommand vesselCommand = new VesselCommand(Thruster.BACK, ThrusterLevel.T0);

            if (!targetsToCapture.isEmpty()){
                if (take) {
                sortList(vessel);
                take = false;
                point = targetsToCapture.get(count);
                }
                x = targetsToCapture.get(count).getX();
                y = targetsToCapture.get(count).getY();

            }
            double x2 = vessel.getPosition().getX();
            double y2 = vessel.getPosition().getY();
            if (( x2 >= x - 2 && x2 <= x + 2) && ( y2 >= y - 2 && y2 <= y + 2 ) || (Math.abs(vessel.getSpeedY()) > 2 && x2 == x && ( y2 >= y - 4 && y2 <= y + 4 )) || (Math.abs(vessel.getSpeedX()) > 2 && ( x2 >= x - 3 && x2 <= x + 3) && y2 == y)) {
                targetsToCapture.remove(point);
                take = true;
            }  else if (( x2 <= x - 2 || x2 >= x + 2 ) ) {
                if (x < x2) {
                    vesselCommand.setThruster(Thruster.RIGHT);
                } else {
                    vesselCommand.setThruster(Thruster.LEFT);
                }
            }  else if (( y2 > y - 2 || y2 < y + 2 )) {
                if (y < y2) {
                    vesselCommand.setThruster(Thruster.FRONT);
                } else {
                    vesselCommand.setThruster(Thruster.BACK);
                }
            } else {
                vesselCommand.setThrusterLevel(ThrusterLevel.T0);
            }
            if (!take) {
                double a = Math.abs(x - x2);
                double b = Math.abs(y - y2);
                if (( ( a < 30 && vessel.getSpeedX() != 0 ) || ( b < 30 && vessel.getSpeedY() != 0 ) ) && ( vessel.getSpeedX() > 3 || vessel.getSpeedY() > 3 ) && !( a < 30 && b < 30 )) {
                    if (vesselCommand.getThruster() == Thruster.LEFT && vessel.getSpeedX() > 0) {
                        vesselCommand.setThruster(Thruster.RIGHT);
                    } else if (vesselCommand.getThruster() == Thruster.RIGHT && vessel.getSpeedX() < 0) {
                        vesselCommand.setThruster(Thruster.LEFT);
                    } else if (vesselCommand.getThruster() == Thruster.FRONT && vessel.getSpeedY() > 0) {
                        vesselCommand.setThruster(Thruster.BACK);
                    } else if (vesselCommand.getThruster() == Thruster.BACK && vessel.getSpeedY() < 0) {
                        vesselCommand.setThruster(Thruster.FRONT);
                    }
                    if (Math.abs(vessel.getSpeedX()) > 2 || Math.abs(vessel.getSpeedY()) > 2) {
                        vesselCommand.setThrusterLevel(ThrusterLevel.T3);
                    } else if (Math.abs(vessel.getSpeedX()) > 3 || Math.abs(vessel.getSpeedY()) > 3) {
                        vesselCommand.setThrusterLevel(ThrusterLevel.T4);
                    }
                } else if (a < 30 || b < 30) {
                    vesselCommand.setThrusterLevel(ThrusterLevel.T3);
                } else {
                    vesselCommand.setThrusterLevel(ThrusterLevel.T4);
                }
            }
        // TODO: Implement algorithm to return command for the vessel to capture all the targets on the raceArea provided
        return vesselCommand;
    }



}

