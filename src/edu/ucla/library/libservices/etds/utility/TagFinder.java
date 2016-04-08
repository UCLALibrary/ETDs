package edu.ucla.library.libservices.etds.utility;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

public class TagFinder
{
  private static Document xmlSource;
  private static File fileToRead;
  private static StringBuffer output;

  public TagFinder()
  {
    super();
  }

  public static void main( String[] args )
  {
    fileToRead = new File( args[ 0 ] );
    output = new StringBuffer();

    verifyFile();
    parseFile();
    verifyTags( args );
    for ( int index = 1; index < args.length; index++ )
    {
      if ( args[ index ].indexOf( "@" ) == -1 )
        findTag( args[ index ] );
      else
        findAttribute( args[ index ] );
    }
    System.out.println( output );
    System.exit( 0 );
  }

  private static void verifyFile()
  {
    if ( !fileToRead.exists() )
      System.exit( 1 );
    if ( !fileToRead.isFile() )
      System.exit( 2 );
    if ( !fileToRead.canRead() )
      System.exit( 3 );
  }
  
  public static String findTag(String filePath, String tag)
  {
    fileToRead = new File( filePath );
    output = new StringBuffer();

    verifyFile();
    parseFile();

    if ( tag.indexOf( "@" ) == -1 )
      findTag( tag );
    else
      findAttribute( tag );

    return output.toString().trim();
  }
  
  private static void parseFile()
  {
    try
    {
      xmlSource =
          DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( fileToRead );
    }
    catch ( ParserConfigurationException pce )
    {
      System.err.println( pce.getMessage() );
      System.exit( 4 );
    }
    catch ( SAXException saxe )
    {
      System.err.println( saxe.getMessage() );
      System.exit( 5 );
    }
    catch ( IOException ioe )
    {
      System.err.println( ioe.getMessage() );
      System.exit( 6 );
    }
  }

  private static void verifyTags( String[] args )
  {
    if ( args.length < 2 )
      System.exit( 7 );
  }

  private static void findTag( String tagToFind )
  {
    try
    {
      output.append( xmlSource.getElementsByTagName( tagToFind ).item( 0 )
                     .getChildNodes().item( 0 ).getTextContent() );
      output.append( "\t" );
    }
    catch ( Exception e )
    {
      System.err.println( e.getMessage() );
      System.exit( 8 );
    }
  }

  private static void findAttribute( String pairToFind )
  {
    String attribute;
    String tag;

    tag = pairToFind.substring( 0, pairToFind.indexOf( "@" ) );
    attribute = pairToFind.substring( pairToFind.indexOf( "@" ) + 1 );
    try
    {
      output.append( xmlSource.getElementsByTagName( tag ).item( 0 )
                     .getAttributes().getNamedItem( attribute ).getNodeValue() );
      output.append( "\t" );
    }
    catch ( Exception e )
    {
      System.err.println( e.getMessage() );
      System.exit( 8 );
    }
  }
}
