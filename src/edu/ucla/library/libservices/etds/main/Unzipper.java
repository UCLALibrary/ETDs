package edu.ucla.library.libservices.etds.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Enumeration;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class Unzipper
{
  private static File inDir;
  private static File tempDir;
  private static File outputBase;
  private static File[] zips;

  public Unzipper()
  {
    super();
  }

  public static void main( String[] args )
    //throws ZipException, IOException
  {
    Properties props;

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
    prepDirs( props );
    for ( File sourceZip: zips )
    {
      if ( sourceZip.isFile() && sourceZip.getName().endsWith( "zip" ) )
      {
        try
        {
          unzipFiles( sourceZip, tempDir );
          moveFile( tempDir, outputBase );
        }
        catch ( ZipException ze )
        {
          System.out.println( "zip error with file " + sourceZip +
                              " because " + ze.getMessage() );
        }
        catch ( IOException ioe )
        {
          System.out.println( "IO error with file " + sourceZip +
                              " because " + ioe.getMessage() );
        }
      }
    }
  }

  private static void prepDirs( Properties propFile )
  {
    inDir = new File( propFile.getProperty( "dirs.incoming" ) );
    System.out.println( "in dir = " + inDir );
    tempDir = new File( propFile.getProperty( "dirs.temp" ) );
    System.out.println( "temp dir = " + tempDir );
    outputBase = new File( propFile.getProperty( "dirs.working" ) );
    System.out.println( "working = " + outputBase );
    zips = inDir.listFiles();
  }

  private static void unzipFiles( File source, File outDir )
    throws ZipException, IOException
  {
    ZipFile zipFile;
    Enumeration e;

    System.out.println( "working with zip file " + source );
    zipFile = new ZipFile( source );
    e = zipFile.entries();
    while ( e.hasMoreElements() )
    {
      ZipEntry entry = ( ZipEntry ) e.nextElement();
      File destinationFilePath = new File( outDir, entry.getName() );
      destinationFilePath.getParentFile().mkdirs();
      if ( entry.isDirectory() )
      {
        continue;
      }
      else
      {
        System.out.println( "\tExtracting " + destinationFilePath );
        BufferedInputStream bis =
          new BufferedInputStream( zipFile.getInputStream( entry ) );
        int b;
        byte buffer[] = new byte[ 1024 ];
        FileOutputStream fos = new FileOutputStream( destinationFilePath );
        BufferedOutputStream bos = new BufferedOutputStream( fos, 1024 );

        while ( ( b = bis.read( buffer, 0, 1024 ) ) != -1 )
        {
          bos.write( buffer, 0, b );
        }
        bos.flush();
        bos.close();

        //close the input stream.
        bis.close();
      }
    }
  }

  private static void moveFile( File tempDir, File outputBase )
    throws IOException
  {
    File moveDir;
    File[] unzipped;

    unzipped = tempDir.listFiles();
    
    moveDir = null;
    for ( File theEntry: unzipped )
    {
      System.out.println( "moving file " + theEntry );
      if ( theEntry.isFile() &&
           FilenameUtils.getExtension( theEntry.getAbsolutePath() ).equalsIgnoreCase( "pdf" ) )
      {
        String pqID;
        pqID =
            FilenameUtils.getBaseName( theEntry.getAbsolutePath() ).substring( FilenameUtils.getBaseName( theEntry.getAbsolutePath() ).lastIndexOf( "_" ) +
                                                                               1 );
        System.out.println( "pqID = " + pqID );
        moveDir = new File( outputBase, pqID );
        if ( !moveDir.exists() )
        {
          moveDir.mkdir();
        }
      }
    }

    System.out.println( "moveDir = " + moveDir.getAbsolutePath() );
    if ( moveDir.exists() && moveDir.isDirectory() )
    {
      for ( File theEntry: unzipped )
      {
        System.out.println( "moving = " + theEntry );
        if ( theEntry.isFile() )
          FileUtils.moveFileToDirectory( theEntry, moveDir, false );
        if ( theEntry.isDirectory() )
          FileUtils.moveDirectoryToDirectory( theEntry, moveDir, true );
      }
    }
  }
}