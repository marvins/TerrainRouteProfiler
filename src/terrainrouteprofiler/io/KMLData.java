/*
 * The MIT License
 *
 * Copyright 2014 Marvin Smith <marvin_smith1@me.com>.
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

package terrainrouteprofiler.io;

import java.util.ArrayList;
import terrainrouteprofiler.geographic.CoordinateGeodetic;

/**
 *
 * @author Marvin Smith <marvin_smith1@me.com>
 */
public class KMLData {

    private ArrayList<CoordinateGeodetic> m_pathPoints;
    
    private KMLParserState m_stateFlag;
    
    public KMLData(){
        m_pathPoints = new ArrayList<>();
        
        m_stateFlag = KMLParserState.KMLReadFailed;
    }
    
    /**
     * Get the KML Data
     * @return 
     */
    public ArrayList<CoordinateGeodetic> getPathPoints(){
        return m_pathPoints;
    }
    
    /**
     * Set the KML Data
     */
    public void setPathPoints( ArrayList<CoordinateGeodetic> pathPoints ){
        this.m_pathPoints = pathPoints;
    }
    
    public KMLParserState getStateFlag(){
        return this.m_stateFlag;
    }
    
    public void setStateFlag( KMLParserState stateFlag ){
        this.m_stateFlag = stateFlag;
    }
    
    public void push_back( CoordinateGeodetic point ){
        this.m_pathPoints.add( point );
    }
}
