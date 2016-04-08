package edu.ucla.library.libservices.etds.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Class7
{
  private static final String DIRECTORY = "F:\\cataloging\\";

  public Class7()
  {
    super();
  }

  public static void main( String[] args )
    throws FileNotFoundException, IOException
  {
    BufferedReader sourceReader;
    String line;

    sourceReader =
        new BufferedReader( new FileReader( new File( "C:\\Temp\\etds\\unloaded.txt" ) ) );
    line = null;

    while ( ( line = sourceReader.readLine() ) != null )
    {
      System.out.print( line + "," );
      File[] contents;

      contents = new File( DIRECTORY.concat( line ) ).listFiles();

      for ( File entry: contents )
      {
        if ( entry.isFile() && entry.getName().endsWith( "xml" ) )
        {
          System.out.print( entry.getName() + "," );
          BufferedReader fileReader;
          String entryLine;

          fileReader = new BufferedReader( new FileReader( entry ) );
          entryLine = null;

          while ( ( entryLine = fileReader.readLine() ) != null )
          {
            try
            {
              if ( entryLine.contains( "DISS_agreement_decision_date" ) )
                System.out.print( "pub date = " +
                                  entryLine.substring( entryLine.indexOf( ">" ) +
                                                       1,
                                                       entryLine.indexOf( ">" ) +
                                                       20 ) );
            }
            catch ( Exception e )
            {
              System.err.println( "for " + line + ", " + e.getMessage() );
            }
            /*if ( entryLine.contains( "embargo_code" ) )
              System.out.print( "\tembargo code " +
                                entryLine.substring( entryLine.indexOf( "embargo_code" ) +
                                                     14,
                                                     entryLine.indexOf( "embargo_code" ) +
                                                     15 ) );*/
            /*if ( entryLine.contains( "DISS_sales_restriction" ) )
              System.out.print( "release date = " +
                                entryLine.substring( entryLine.indexOf( "remove" ) +
                                                     8,
                                                     entryLine.indexOf( "remove" ) +
                                                     18 ) + "," );
            try
            {
              if ( entryLine.contains( "DISS_delayed_release" ) )
                System.out.print( "delayed release = " +
                                  entryLine.substring( entryLine.indexOf( ">" ) +
                                                       1,
                                                       entryLine.indexOf( ">" ) +
                                                       20 ) + "," );
            }
            catch ( Exception e )
            {
              System.err.println( "for " + line + ", " + e.getMessage() );
            }*/
          }
        }
        System.out.println( "" );
      }
    }
  }
}
