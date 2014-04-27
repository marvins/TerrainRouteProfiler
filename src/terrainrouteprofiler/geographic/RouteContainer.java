/*
 * The MIT License
 *
 * Copyright 2014 ms6401.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package terrainrouteprofiler.geographic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import terrainrouteprofiler.io.KMLData;
import terrainrouteprofiler.io.KMLParser;

/**
 *
 * @author ms6401
 */
public class RouteContainer {
    
    /// List of coordinates in order
    private ArrayList<CoordinateGeodetic> m_pointList;
    
    /// Total Distance Travelled
    private double m_distance;
    
    
    /**
     * Constructor
     */
    public RouteContainer(){
    
        // initialize the point list
        m_pointList = new ArrayList<>();
        
    }

    /**
     * Import the route given in the format of a Google KML File.
     * @param pathname Path to the KML file
     */
    public void importRouteKML(String pathname ) {
        
        // open a KML file parser and import all points
        KMLData kmlData = KMLParser.readKMLFile(new File(pathname));
        
        // add the points to the point list
        m_pointList.addAll(kmlData.getPathPoints());
        
        // update the length of the route
        //find the full distance
        m_distance = 0;
        for( int i=0; i<m_pointList.size()-1; i++) {
            m_distance += Vincenty.distanceMeters(m_pointList.get(i), m_pointList.get(i+1));
        }
    }

    /**
     * Get the size of the route
     */
    public int size(){
        return m_pointList.size();
    }
    
}
