/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

import java.util.ArrayList;

/**
 *
 * @author quyen
 */
public class Original {
    private ArrayList<Nation> origin = new ArrayList();

    public Original() {
        origin.add(new Nation("Vietnam"));
        origin.add(new Nation("Thailand"));
        origin.add(new Nation("US"));
        origin.add(new Nation("France"));
        origin.add(new Nation("China"));
    }

    public ArrayList<Nation> getOrigin() {
        return origin;
    }

    public void setOrigin(ArrayList<Nation> origin) {
        this.origin = origin;
    }
    
}
