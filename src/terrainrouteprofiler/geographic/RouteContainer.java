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

import java.util.ArrayList;

/**
 *
 * @author ms6401
 */
public class RouteContainer {
    
    /// List of coordinates in order
    private ArrayList<CoordinateGeodetic> m_pointList;
    
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
