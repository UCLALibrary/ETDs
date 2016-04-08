package edu.ucla.library.libservices.etds.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatConverter
{
  public DateFormatConverter()
  {
    super();
  }

  public static void main( String[] args )
  {
    String inputDate;
    SimpleDateFormat inputFormat;
    SimpleDateFormat outputFormat;
    
    if ( args.length != 3 )
    {
      System.err.println( "usage: <date string> <in format> <out format>" );
      System.exit( 1 );
    }
    inputDate = args[ 0 ];
    inputFormat = new SimpleDateFormat( args[ 1 ] );
    outputFormat = new SimpleDateFormat( args[ 2 ] );

    try
    {
      System.out.println( outputFormat.format( inputFormat.parse( inputDate ) ) );
      System.exit( 0 );
    }
    catch ( ParseException pe )
    {
      System.err.println( pe.getMessage() );
      System.exit( 2 );
    }
  }

  public static String convertDate( String inputDate, String startFormat,
                                    String finalFormat )
  {
    SimpleDateFormat inputFormat;
    SimpleDateFormat outputFormat;

    inputFormat = new SimpleDateFormat( startFormat );
    outputFormat = new SimpleDateFormat( finalFormat );

    try
    {
      return outputFormat.format( inputFormat.parse( inputDate ) );
    }
    catch ( ParseException pe )
    {
      System.err.println( pe.getMessage() );
      return null;
    }
  }
}
