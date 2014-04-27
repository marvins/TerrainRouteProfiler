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
public class CoordinateGeodetic extends CoordinateBase {
   
    /// Latitude
    private double m_latitude;
    
    /// Longitude
    private double m_longitude;
    
    
    /**
     * Default Constructor
     */
    public CoordinateGeodetic(){
        
        // construct parent
        super();
        
        // create the latitude
        m_latitude = 0;
        
        // create the longitude 
        m_longitude = 0;
    }
    
    /**
     * Parameterized Constructor
     * @param latitude desired latitude in decimal degrees
     * @param longitude desired longitude in decimal degrees
     */
    public CoordinateGeodetic( double latitude, double longitude ){
        
        // construct parent
        super();
        
        // set latitude
        m_latitude = latitude;
        
        // set longitude
        m_longitude = longitude;
        
    }
    
    /**
     * Parameterized Constructor
     * @param latitude desired latitude in decimal degrees
     * @param longitude desired longitude in decimal degrees
     * @param altitude altitude in meters
    */
    public CoordinateGeodetic( double latitude, double longitude, double altitude ){
        
        // create parent
        super(altitude);
        
        // create latitude
        m_latitude = latitude;
        
        // create longitude
        m_longitude = longitude;
        
    }
    
    /**
     * Parameterized Constructor
     * @param latitude desired latitude in decimal degrees
     * @param longitude desired longitude in decimal degrees
     * @param altitude desired altitude in meters
     * @param datum Geographic Datum
    */
    public CoordinateGeodetic( double latitude, double longitude, double altitude, Datum datum ){
        
        // create parent
        super(altitude, datum);
        
        // create latitude
        m_latitude = latitude;
        
        // create longitude
        m_longitude = longitude;
        
    }
    
    /**
     * Get latitude
     * @return Latitude in decimal degrees
     */
    public double getLatitude(){
        return this.m_latitude;
    }
    
    /**
     * Set latitude
     * @param latitude latitude to change to in decimal degrees
     */
    public void setLatitude( double latitude ){
        this.m_latitude = latitude;
    }
    
    /**
     * Get longitude
     * @return longitude in decimal degrees
     */
    public double getLongitude(){
        return  this.m_longitude;
    }
    
    /**
     * Set longitude
     * @param longitude Longitude to change to in decimal degrees
     */
    public void setLongitude( double longitude ){
        this.m_longitude = longitude;
    }
    
}
