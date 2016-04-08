package edu.ucla.library.libservices.etds.main;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.net.URI;

import java.util.Deque;
import java.util.LinkedList;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class Copier
{
  private static final String BASE_IN_DIR = "C:\\etds\\";
  private static final String BASE_OUT_DIR = "C:\\cataloging\\";
  private static final String BASE_ZIP_DIR = "C:\\zips\\";

  public Copier()
  {
    super();
  }

  public static void main( String[] args )
    throws IOException
  {
    long start, end;
    File inputDir;
    File outputDir;
    File[] inputFiles;
    
    start = System.currentTimeMillis();
    inputDir = new File( BASE_IN_DIR );
    outputDir = new File( BASE_OUT_DIR );

    inputFiles = inputDir.listFiles();

    for ( File theFile: inputFiles )
    {
      String matchName;

      matchName = null;
      if ( theFile.isFile() )
      {
        matchName = FilenameUtils.getBaseName( theFile.getAbsolutePath() );

        try
        {
          File moveDir;

          moveDir =
              new File( BASE_OUT_DIR.concat( "\\" ).concat( matchName ) );
          if ( moveDir.exists() && moveDir.isDirectory() )
          {
            Deque<File> queue;
            OutputStream out;
            Closeable res;
            URI base;
            File zipfile;

            FileUtils.moveFileToDirectory( theFile, moveDir, false );

            zipfile =
                new File( BASE_ZIP_DIR.concat( matchName ).concat( ".zip" ) );
            base = moveDir.toURI();
            queue = new LinkedList<File>();
            queue.push( moveDir );
            out = new FileOutputStream( zipfile );
            res = out;
            ZipOutputStream zout = new ZipOutputStream( out );
            res = zout;
            while ( !queue.isEmpty() )
            {
              File directory;
              directory = queue.pop();
              for ( File kid: directory.listFiles() )
              {
                String name = base.relativize( kid.toURI() ).getPath();
                if ( kid.isDirectory() )
                {
                  queue.push( kid );
                  name = name.endsWith( "/" ) ? name: name + "/";
                  zout.putNextEntry( new ZipEntry( name ) );
                }
                else
                {
                  zout.putNextEntry( new ZipEntry( name ) );
                  copy( kid, zout );
                  zout.closeEntry();
                }
              }
            }
            res.close();
          }
        }
        catch ( IOException ioe )
        {
          ioe.printStackTrace();
        }
      }
    }
    end = System.currentTimeMillis();
    System.out.println( "run time = " + ( end - start ) / 1000 );
  }

  private static void copy( File file, OutputStream out )
    throws IOException
  {
    InputStream in = new FileInputStream( file );
    try
    {
      copy( in, out );
    }
    finally
    {
      in.close();
    }
  }

  private static void copy( InputStream in, OutputStream out )
    throws IOException
  {
    byte[] buffer = new byte[ 1024 ];
    while ( true )
    {
      int readCount = in.read( buffer );
      if ( readCount < 0 )
      {
        break;
      }
      out.write( buffer, 0, readCount );
    }
  }
}
