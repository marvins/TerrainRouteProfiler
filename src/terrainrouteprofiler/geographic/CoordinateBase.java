/*
 * The MIT License
 *
 * Copyright 2014 Marvin Smith.
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

/**
 *
 * @author Marvin Smith
 */
public class CoordinateBase {
  
    /// Datum
    private Datum m_datum;
    
    /// Altitude
    private double m_altitude;
    
    /**
     * Default Constructor
     */
    public CoordinateBase(){
        
        // set the datum
        m_datum = Datum.WGS84;
        
        // set the altitude
        m_altitude = 0;
    }
    
    /**
     * Constructor given altitude
     * @param altitude Altitude in meters
     */
    public CoordinateBase( double altitude ){
        
        // set the altitude
        m_altitude = altitude;
        
        // set the datum
        m_datum = Datum.WGS84;
        
    }
    
    /**
     * Constructor given altitude and datum
     * @param altitude  Altitude in meters
     * @param datum Datum
     */
    public CoordinateBase( double altitude, Datum datum ){
    
        // set the altitude
        m_altitude = altitude;
        
        // set the datum 
        m_datum = datum;
    }
    
    /**
     * Get the altitude
     * @return Altitude in meters
     */
    public double getAltitude(){
        return this.m_altitude;
    }
    
    /**
     * Set the altitude
     * @param altitude Altitude in meters
     */
    public void setAltitude( double altitude ){
        this.m_altitude = altitude;
    }
    
    /**
     * Get the datum
     * @return Datum
     */
    public Datum getDatum(){
        return this.m_datum;
    }
    
    /**
     * Set the datum
     * @param datum Datum to set to.
     */
    public void setDatum( Datum datum ){
        this.m_datum = datum;
    }
    
}
