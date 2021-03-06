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
public class KMLParserStateTest {
    
    public KMLParserStateTest() {
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
     * Test of values method, of class KMLParserState.
     */
    @Test
    public void testValues() {
        
        // test tehe values
        System.out.println("values");
        
        // create our test container
        KMLParserState array[] = new KMLParserState[2];
        array[0] = KMLParserState.KMLReadSuccess;
        array[1] = KMLParserState.KMLReadFailed;
        
        // call the function in question
        KMLParserState[] result = KMLParserState.values();
        assertArrayEquals(array, result);
        
    }

    /**
     * Test of valueOf method, of class KMLParserState.
     */
    @Test
    public void testValueOf() {
        
        System.out.println("valueOf");
        
        // test value of
        assertEquals( KMLParserState.valueOf("KMLReadFailed"), KMLParserState.KMLReadFailed);
        assertEquals( KMLParserState.valueOf("KMLReadSuccess"), KMLParserState.KMLReadSuccess);
        
    }
    
}
