package edu.ucla.library.libservices.etds.main;

import edu.ucla.library.libservices.etds.utility.XmlFileFinder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class EmbargoCoder
{
  private static final SimpleDateFormat FORMATTER =
    new SimpleDateFormat( "yyyy-MM-dd" );

  public EmbargoCoder()
  {
    super();
  }

  public static void main( String[] args )
  {
    List<File> files;
    List<String> embargoed;
    Properties props;
    XmlFileFinder finder;
    String rootDir;
    String writeDir;

    props = new Properties();

    try
    {
      props.load( new FileInputStream( new File( args[ 0 ] ) ) );
    }
    catch ( IOException ioe )
    {
      System.out.println( "problem with props file: " + ioe.getMessage() );
      System.exit( -1 );
    }
    
    rootDir = "F:\\cataloging"; // props.getProperty( "dirs.working" );
    writeDir = "C:\\Temp\\etds\\embargoes";
    finder = new XmlFileFinder();
    finder.setRoot( new File( rootDir ) );
    files = finder.getFiles();
    if ( files.size() > 0 )
    {
      for ( int embargoCode = 0;
            embargoCode < Integer.parseInt( props.getProperty( "embargo.max" ) );
            embargoCode++ )
      {
        try
        {
          embargoed = findEmbargoed( files, embargoCode );
          writeFile( embargoed, embargoCode, writeDir );
        }
        catch ( IOException ioe )
        {
          System.out.println( "problem processing embargo code " +
                              embargoCode + ": " + ioe.getMessage() );
        }
      }
    }
  }

  private static List<String> findEmbargoed( List<File> files,
                                             int embargoCode )
    throws IOException
  {
    List<String> embargoed;
    List<File> toRemove;

    embargoed = new ArrayList<String>();
    toRemove = new ArrayList<File>();

    for ( File theEntry: files )
    {
      System.out.println( "checking " + theEntry.getName() );
      if ( FileUtils.readFileToString( theEntry ).contains( "embargo_code=\"" +
                                                            embargoCode +
                                                            "\"" ) )
      {
        embargoed.add( theEntry.getParentFile().getName().concat( "/" ).concat( theEntry.getName() ) );
        toRemove.add( theEntry );
      }
    }
    files.removeAll( toRemove );
    return embargoed;
  }

  private static void writeFile( List<String> embargoed, int embargoCode, String root )
    throws IOException
  {
    BufferedWriter writer;
    writer =
        new BufferedWriter( new FileWriter( new File( root + "/embargo_code" +
                                                      embargoCode + "_" +
                                                      FORMATTER.format( new Date() ) +
                                                      ".alt.txt" ) ) );
    for ( String fileName: embargoed )
    {
      writer.write( fileName.substring( 0, fileName.indexOf( "/" ) ) );
      writer.newLine();
    }
    writer.flush();
    writer.close();
  }
}
