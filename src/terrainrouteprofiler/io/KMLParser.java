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
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import terrainrouteprofiler.geographic.CoordinateGeodetic;

/**
 *
 * @author Marvin Smith <marvin_smith1@me.com>
 */
public class KMLParser {
    
    public static KMLData readKMLFile( File kmlFilePath ){
    
        // create a return object
        KMLData kmlData = new KMLData();
        
        try{
        
            // initialize the Document Builder Factory Objects
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        
            // create the document builder
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = docBuilder.parse( kmlFilePath);
            
            // grab the appropriate nodes
            NodeList nodes = document.getDocumentElement().getChildNodes();
            
            for (int i = 0; i < nodes.getLength(); i++) {

                // iterate through each node
                Node node = nodes.item(i);
                
                // test if the node is a document node for the KML file
                if (node.getNodeType() == Node.ELEMENT_NODE && ((Element) node).getTagName().equals("Document")) {

                    // convert the node to an xml element
                    Element docElement = (Element) node;

                    // grab the placemark element
                    NodeList placemarkList = docElement.getElementsByTagName("Placemark");

                    // pull the node for coordinates
                    NodeList lineSet = ((Element) placemarkList.item(0)).getElementsByTagName("coordinates");

                    // grab the text from the string
                    String content = lineSet.item(0).getTextContent().trim();
                    String[] items = content.split("\\s+|,");

                    // make sure the kml document has three elements
                    if (items.length % 3 != 0) {
                        throw new Exception("ERROR: kml must have strings with 3 values per coordinate");
                    }

                    // convert to a geodetic coordinate
                    for (int it = 0; it < items.length / 3; it++) {
                        
                        // add the coordinate
                        kmlData.push_back(new CoordinateGeodetic(Double.valueOf(items[it*3+1]), 
                                                                 Double.valueOf(items[it*3+0]),
                                                                 Double.valueOf(items[it*3+2])));
                        
                    }

                }
            }
            
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
        
        // return the kml information
        return kmlData; 
    }
    
}
