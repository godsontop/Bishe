package Simulation;

import java.text.ParseException;

public class test {
    public static void main(String[] args) throws ParseException {
        Simulation sim = new Simulation();
        for (int i = 0; i<180; i++) {
            System.out.println(sim.getStartTime() +"  "+ sim.getEndTime());
            sim.update(sim.getStartTime());
        }
    }
}
