package edu.ucla.library.libservices.etds.utility;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import java.text.SimpleDateFormat;

public class Class1
{
  private static final SimpleDateFormat FORMATTER =
    new SimpleDateFormat( "yyyy-MM-dd" );

  public Class1()
  {
    super();
  }

  public static void main( String[] args )
    throws IOException
  {
    XmlFileFinder finder;
    List<File> files;
    List<String> embargoed;
    BufferedWriter writer;

    //writer = new BufferedWriter( new FileWriter( new File( "C:\\Temp\\etds\\metafiles.txt" ) ) );


    finder = new XmlFileFinder();
    finder.setRoot( new File( "\\\\ad\\staff\\workGroups\\ETD\\cataloging\\" ) );
    System.out.println( "starting @ " + new Date() );
    files = finder.getFiles();

    embargoed = new ArrayList<String>();

    /*for ( File theFile : files )
    {
      if ( findMetadata( theFile ) )
      {
        writer.write( theFile.getAbsolutePath() );
        writer.newLine();
      }
    }*/
    for ( int embargoCode = 1; embargoCode < 5; embargoCode++ )
    {
      embargoed = findEmbargoed( files, embargoCode );
      writeFile(embargoed, embargoCode);
    }
    //writer.flush();
    //writer.close();
    System.out.println( "ending @ " + new Date() );

  }

  private static void writeFile( List<String> embargoed, int embargoCode )
    throws IOException
  {
    BufferedWriter writer;
    writer =
        new BufferedWriter( new FileWriter( new File( "C:\\Temp\\etds\\embargo_code" +
                                                      embargoCode + "_" +
                                                      FORMATTER.format( new Date() ) +
                                                      ".txt" ) ) );
    for ( String fileName: embargoed )
    {
      writer.write( fileName );
      writer.newLine();
    }
    writer.flush();
    writer.close();
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

  private static boolean findMetadata( File theFile )
    throws IOException
  {
    /*
     * find all the proquest metadat files
     * if xml file contains DISS_submission then proquest metadata
     * write names of files to temp file
     */
    if ( FileUtils.readFileToString( theFile ).contains( "DISS_submission" ) )
      return true;
    else
      return false;
  }
}
/*
 * for embargocode = 0 .. 4 do:
 *   allocate list<string>
 *   recursively read directories
 *   if file is xml && contains embargo_code = embargocode then add file name to list
 *   write list contents to text file
 * done
 */
    /*File dir;
    File[] subs;
    List<String> embargo3;

    dir = new File( "C:\\Temp\\etds\\extract" );
    subs = dir.listFiles();
    embargo3 = new ArrayList<String>();

    for ( File theSub: subs )
    {
      File[] contents;

      contents = theSub.listFiles();
      for ( File theEntry: contents )
      {
        if ( theEntry.isFile() &&
             FilenameUtils.getExtension( theEntry.getCanonicalPath() ).equalsIgnoreCase( "xml" ) )
        {
          String fileContents;
          fileContents = FileUtils.readFileToString(theEntry);
          if ( fileContents.contains( "embargo_code=\"3\"" ) )
            embargo3.add( theSub.getName().concat( "/" ).concat( theEntry.getName() ) );
        }
      }
    }
    for ( String embargoed : embargo3 )
      System.out.println( embargoed );*/
