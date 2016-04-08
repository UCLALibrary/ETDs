package edu.ucla.library.libservices.etds.utility;

import java.io.File;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

public class Class8
{
  public Class8()
  {
    super();
  }

  public static void main( String[] args )
  {
    Document xmlSource;
    File fileToRead;
    String tagToFind;
    String tagValue;

    fileToRead = new File( args[ 0 ] );
    tagToFind = args[ 1 ];

    if ( !fileToRead.exists() || !fileToRead.isFile() ||
         !fileToRead.canRead() ||
         !fileToRead.getName().toLowerCase().endsWith( "xml" ) )
    {
      //log issue with file
      System.exit( -1 );
    }
    else if ( tagToFind == null || tagToFind.trim().length() == 0 )
    {
      //log issue with tag
      System.exit( -2 );
    }
    else
    {
      try
      {
        xmlSource =
            DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( fileToRead );
        tagValue =
            xmlSource.getElementsByTagName( tagToFind ).item( 0 ).getChildNodes().item( 0 ).getTextContent();
        System.out.println( tagValue );
      }
      catch ( ParserConfigurationException pce )
      {
        pce.printStackTrace();
        System.exit( -3 );
      }
      catch ( SAXException saxe )
      {
        saxe.printStackTrace();
        System.exit( -4 );
      }
      catch ( IOException ioe )
      {
        ioe.printStackTrace();
        System.exit( -5 );
      }
    }
  }
}
/*
 * receive /path/to/file.xml
 * receive tag to find
 * receive optional attribute to find
 * verify existence of file
 */
