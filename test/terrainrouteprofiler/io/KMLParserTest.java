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

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import terrainrouteprofiler.geographic.CoordinateGeodetic;

/**
 *
 * @author Marvin Smith <marvin_smith1@me.com>
 */
public class KMLParserTest {
    
    public KMLParserTest() {
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
     * Test of readKMLFile method, of class KMLParser.
     */
    @Test
    public void testReadKMLFile() {
        
        // print the header
        System.out.println("readKMLFile");
        
        // read the demo kml file
        KMLData data = KMLParser.readKMLFile(new File("data/Road_NATC_Home.kml"));
        
        // get the point list
        ArrayList<CoordinateGeodetic> pointList = data.getPathPoints();
        
        assertEquals( pointList.size(), 151);
        
        assertEquals( pointList.get(0).getLatitude(), 39.32088331528426,   0.0001 );
        assertEquals( pointList.get(0).getLongitude(), -119.2329259308802, 0.0001 );
        assertEquals( pointList.get(0).getAltitude(), 0, 0.0001);
        
        
    }
    
}
