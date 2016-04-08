package edu.ucla.library.libservices.etds.utility;

import java.io.File;

import java.text.ParseException;

import java.util.Date;

import java.text.SimpleDateFormat;

public class Class9
{
  public Class9()
  {
    super();
  }

  public static void main( String[] args )
    throws ParseException
  {
    Date theDate;
    SimpleDateFormat fromFormat;
    SimpleDateFormat toFormat;
    String baseDate;
    String resultDate;

    baseDate = "09/09/2017";
    fromFormat = new SimpleDateFormat( "MM/dd/yyyy" );
    toFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    theDate = fromFormat.parse( baseDate );
    resultDate = toFormat.format( theDate );
    System.out.println( "result = " + resultDate );

    String pair = "this@that";
    System.out.println( "tag = " +
                        pair.substring( 0, pair.indexOf( "@" ) ) );
    System.out.println( "attribute = " +
                        pair.substring( pair.indexOf( "@" ) + 1 ) );

    String a = "Realegeno_ucla_0031D_14071_DATA.xml";
    String[] as = a.split( "_" );
    for ( int i = 0; i < as.length; i++ )
      System.out.println( " element " + i + " = " + as[ i ] );
    for ( String anA: as )
      System.out.println( anA );
    System.out.println( "path separator = " + File.separator );
  }
}
