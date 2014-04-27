/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package terrainrouteprofiler;

import javax.swing.JFrame;
import terrainrouteprofiler.gui.MainGUI;

/**
 * Main Driver for the Terrain Route Profiler
 * @author Marvin Smith
 */
public class TerrainRouteProfiler {

    /**
     * Main Driver
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create the GUI to show
        MainGUI gui = new MainGUI();
        
        // configure some settings and show it
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
        
        
    }
    
    
    
}
