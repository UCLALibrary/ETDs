package edu.ucla.library.libservices.etds.utility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Class2
{
  private static final String OUTDIR = "C:\\Temp\\etds\\missing";

  public Class2()
  {
    super();
  }

  public static void main( String[] args )
    throws FileNotFoundException, IOException
  {
    BufferedReader reader;
    String line;

    reader =
        new BufferedReader( new FileReader( new File( "C:\\Temp\\etds\\zips.txt" ) ) );
    line = null;

    while ( ( line = reader.readLine() ) != null )
    {
      File sourceZip;
      sourceZip = new File( line );
      if ( sourceZip.exists() && sourceZip.isFile() &&
           sourceZip.getName().endsWith( "zip" ) )
      {
        Enumeration e;
        ZipFile zipFile;

        zipFile = new ZipFile( sourceZip );
        e = zipFile.entries();
        while ( e.hasMoreElements() )
        {
          ZipEntry entry = ( ZipEntry ) e.nextElement();
          File destinationFilePath = new File( OUTDIR, entry.getName() );
          destinationFilePath.getParentFile().mkdirs();
          if ( entry.isDirectory() )
          {
            continue;
          }
          else
          {
            BufferedInputStream bis =
              new BufferedInputStream( zipFile.getInputStream( entry ) );
            int b;
            byte buffer[] = new byte[ 1024 ];
            FileOutputStream fos =
              new FileOutputStream( destinationFilePath );
            BufferedOutputStream bos =
              new BufferedOutputStream( fos, 1024 );

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
    }
  }
}
