package com.nortal.race.assignment.controller;

import com.nortal.race.assignment.model.RaceArea;
import com.nortal.race.assignment.model.Thruster;
import com.nortal.race.assignment.model.ThrusterLevel;
import com.nortal.race.assignment.model.Vessel;
import com.nortal.race.assignment.model.VesselCommand;

import java.awt.*;
import java.util.List;

public class RaceController {
    private double x;
    private double y;
    private boolean take = true;
    private Point point;
    private boolean taken;
    public static final int THREE = 3;
    private Point place;

    public RaceController() {
    }

    private List<Point> targetsToCapture;

    private void sortList(Vessel vessel) {
        targetsToCapture.sort((z1, z2) -> {
            if (Math.sqrt(Math.abs(Math.pow(z1.getX() - vessel.getPosition().getX(), 2) + Math.pow(z1.getY()
                    - vessel.getPosition().getY(), 2))) < Math.sqrt(Math.abs(Math.pow(z2.getX()
                    - vessel.getPosition().getX(), 2) + Math.pow(z2.getY() - vessel.getPosition().getY(), 2)))) {
                return -1;
            }
            if (Math.sqrt(Math.abs(Math.pow(z1.getX() - vessel.getPosition().getX(), 2) + Math.pow(z1.getY()
                    - vessel.getPosition().getY(), 2))) > Math.sqrt(Math.abs(Math.pow(z2.getX()
                    - vessel.getPosition().getX(), 2) + Math.pow(z2.getY() - vessel.getPosition().getY(), 2)))) {
                return 1;
            }
            return 0;
        });
    }

    public VesselCommand calculateNextCommand(Vessel vessel, RaceArea raceArea) {
        if (!taken) {
            place = vessel.getPosition();
            taken = true;
            targetsToCapture = raceArea.getTargets();
        }
        VesselCommand vesselCommand = new VesselCommand(Thruster.BACK, ThrusterLevel.T0);

        if (!targetsToCapture.isEmpty()) {
            sortList(vessel);
            if (take) {
                take = false;
                point = targetsToCapture.get(0);
            }
            x = point.getX();
            y = point.getY();

        }
        double x2 = vessel.getPosition().getX();
        double y2 = vessel.getPosition().getY();
        if ((x2 > x - 2 && x2 < x + 2) && (y2 > y - 2 && y2 < y + 2) || ((Math.abs(place.getX() - x2) == 1 || Math.abs(place.getX() - x2) == 0) && (Math.abs(x2 - point.getX()) == 1 || Math.abs(x2 - point.getX()) == 0) && ((place.getY() > point.getY() && point.getY() > y2) || (place.getY() < point.getY() && point.getY() < y2) ))){
            targetsToCapture.remove(point);
            take = true;
        } else if ((x2 <= x - 3 || x2 >= x + 3)) {
            if (x < x2 ) {
                vesselCommand.setThruster(Thruster.RIGHT);
            } else {
                vesselCommand.setThruster(Thruster.LEFT);
            }
        } else if ((y2 < y - 1.8 || y2 > y + 1.8)) {
            if (y < y2 && y2 - 2 > 0) {
                vesselCommand.setThruster(Thruster.FRONT);
            } else if (y >= y2 && y2 + 4 < raceArea.getHeight()){
                vesselCommand.setThruster(Thruster.BACK);
            }
        }
        if (!take) {
            double a = Math.abs(x - x2);
            double b = Math.abs(y - y2);
            double stopx = Math.pow(vessel.getSpeedX(), 2) / 6;
            double stopy = Math.pow(vessel.getSpeedY(), 2) / 6;
            if ((a <= stopx && vessel.getSpeedX() != 0) || (b <= stopy && vessel.getSpeedY() != 0)) {
                if (vesselCommand.getThruster() == Thruster.LEFT && vessel.getSpeedX() > 0) {
                    vesselCommand.setThruster(Thruster.RIGHT);
                } else if (vesselCommand.getThruster() == Thruster.RIGHT && vessel.getSpeedX() < 0) {
                    vesselCommand.setThruster(Thruster.LEFT);
                } else if (vesselCommand.getThruster() == Thruster.FRONT && vessel.getSpeedY() < 0 && targetsToCapture.size() > 1 && (targetsToCapture.get(1).getY() >= point.getY() - 50 || targetsToCapture.get(1).getY() == point.getY()) && y2 + 4 < raceArea.getHeight()) {
                    vesselCommand.setThruster(Thruster.BACK);
                } else if (vesselCommand.getThruster() == Thruster.BACK && vessel.getSpeedY() > 0 && targetsToCapture.size() > 1 && (targetsToCapture.get(1).getY() <= point.getY() + 50|| targetsToCapture.get(1).getY() == point.getY()) && y2 - 2 > 0) {
                    vesselCommand.setThruster(Thruster.FRONT);

                }
            }
            vesselCommand.setThrusterLevel(ThrusterLevel.T4);
        }
        place = vessel.getPosition();
        return vesselCommand;
    }
}
