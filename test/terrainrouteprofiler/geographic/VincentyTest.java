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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marvin Smith <marvin_smith1@me.com>
 */
public class VincentyTest {
    
    public VincentyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of distanceMeters method, of class Vincenty.
     */
    @Test
    public void testDistanceMeters() {
        
        System.out.println("distanceMeters");
        
        // University of Nevada, Reno
        CoordinateGeodetic coordinateA = new CoordinateGeodetic( 39.544875,  -119.816574);
        
        // Nevada State Capitol
        CoordinateGeodetic coordinateB = new CoordinateGeodetic(  39.163788, -119.766080);
        
        double expResult = 42533;
        double result = Vincenty.distanceMeters(coordinateA, coordinateB);
        System.out.println("  diff: " + Double.toString(Math.abs(result-expResult)));
        assertEquals(expResult, result, 10.0);
        
    }

    /**
     * Test of distanceFormula method, of class Vincenty.
     */
    @Test
    public void testDistanceFormula() {
        System.out.println("distanceFormula");
        CoordinateGeodetic coordinateA = null;
        CoordinateGeodetic coordinateB = null;
        double expResult = 0.0;
        double result = Vincenty.distanceFormula(coordinateA, coordinateB);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
