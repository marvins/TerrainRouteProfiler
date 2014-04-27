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

package terrainrouteprofiler.geographic;

/**
 *
 * @author Marvin Smith <marvin_smith1@me.com>
 */
public class Vincenty {

    /// Variable for converting Degrees To Radians
    private static final double DEG2RAD = Math.PI/180.0;
    
    /// Variable for converting Radians to Degrees
    private static final double RAD2DEG = 180.0/Math.PI;
    
    /// Convert Degrees to Meters
    private static final double DEG2METERS = 111699;
    
    /**
     * Compute the distance between the two points using the vincenty formula.
     * @param coordinateA  The starting coordinate
     * @param coordinateB The ending coordinate
     * @return Distance in meters
     */
    public static double distanceMeters( CoordinateGeodetic coordinateA, CoordinateGeodetic coordinateB ){
    
        //if coordinates have the same latitude, then we need to use a different method
        if( Math.abs(coordinateA.getLatitude() - coordinateB.getLatitude()) < 0.00001 ){
            return distanceFormula( coordinateA, coordinateB );
        }
        
        double output;
        
        //assuming WGS84, use standard ellipsoid parameters
        double a = 6378137;
        double b = 6356752.314245;
        double f = 1/298.257223563;  // WGS-84 ellipsiod
        
        //latitudes
        double latA = coordinateA.getLatitude() * DEG2RAD;
        double latB = coordinateB.getLatitude() * DEG2RAD;
        
        //longitude difference
        double L = (coordinateB.getLongitude() - coordinateA.getLongitude())*DEG2RAD;
        
        double U1 = Math.atan((1-f)*Math.tan(latA));
        double U2 = Math.atan((1-f)*Math.tan(latB));
        
        double sinU1 = Math.sin(U1); double cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2); double cosU2 = Math.cos(U2);
        
        double lambda = L; //first approximation
        double lambda2;
        double deltaL = 100000;
        int iterations = 0;
        
        double sinLambda, cosLambda, sinSigma = 0, cosSigma = 0, sigma = 0, sinAlpha, cos2alpha = 0, cos2sigmaM = 0, C;
        double tempA, tempB, tempC;
        
        //useful variables 
        double a2 = Math.pow(a, 2);
        double b2 = Math.pow(b, 2);
        
        while( iterations < 1 || ( iterations < 12 && deltaL > 1E-12 /*0.000000001*/ ) ){
            
            //small variables, big space and computation savings
            sinLambda = Math.sin(lambda);
            cosLambda = Math.cos(lambda);
            
            tempA = ( cosU2 * sinLambda ) * ( cosU2 * sinLambda );
            tempB = ( cosU1 * sinU2 - sinU1 * cosU2 * cosLambda );
            sinSigma = Math.sqrt( tempA + tempB * tempB );
                
            cosSigma = sinU1*sinU2 + cosU1*cosU2*cosLambda;
            
            sigma = Math.atan2( sinSigma, cosSigma);
            
            sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
            
            cos2alpha = 1 - sinAlpha*sinAlpha;
            
            cos2sigmaM = cosSigma - 2 * sinU1 * sinU2/cos2alpha;
            
            C = f / 16*cos2alpha*(4 + f *(4 - 3 * cos2alpha));
            
            
            tempA = -1 + 2 * cos2sigmaM * cos2sigmaM;
            tempB = cos2sigmaM + C*cosSigma*tempA;
            tempC = sigma + C * sinSigma * tempB;
            lambda2 = L + (1-C) * f * sinAlpha * tempC;
            
            deltaL = Math.abs( lambda- lambda2);
            
            
            
            iterations++;
            lambda = lambda2;
        }
        
        double u2 = cos2alpha * (a2 - b2)/b2;
              
        double A = 1 + u2 / 16384 * ( 4096 + u2 * ( -768 + u2*(320 - 175 *u2)));
        double B = u2 /  1024 * ( 256 + u2 * ( -128 + u2 * ( 74 - 47*u2)));
        
        tempB = (cosSigma*(-1+2*cos2sigmaM*cos2sigmaM)- B/6*cos2sigmaM*(-3+4*sinSigma*sinSigma)*(-3+4*cos2sigmaM*cos2sigmaM));
        tempC = (cos2sigmaM + B/4*tempB);
        double dSigma = B*sinSigma*tempC;        
        
        output = b*A*(sigma - dSigma );
        
        return output;
        
    }
    
    /**
     * Compute the Euclidean distance between the two coordinates.  Note that this is not 
     * a good method, but a last resort. 
     */
    public static double distanceFormula( CoordinateGeodetic coordinateA, CoordinateGeodetic coordinateB ){
        
        double output = Math.sqrt( Math.pow(coordinateA.getLatitude()  - coordinateB.getLatitude(),  2)  + 
                                   Math.pow(coordinateA.getLongitude() - coordinateB.getLongitude(), 2)) * DEG2METERS;
        
        return output;
    }
    
}
