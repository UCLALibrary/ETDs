package edu.ucla.library.libservices.etds.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class ReleaseDateCalculator
{
  private static final DateFormat MONTH_OUTPUT =
    new SimpleDateFormat( "MM" );
  private static final DateFormat DAY_OUTPUT =
    new SimpleDateFormat( "dd" );
  private static final DateFormat YEAR_OUTPUT =
    new SimpleDateFormat( "yyyy" );
  private static final DateFormat HOUR_OUTPUT =
    new SimpleDateFormat( "HH" );
  private static final DateFormat MINUTE_OUTPUT =
    new SimpleDateFormat( "mm" );
  private static final DateFormat SECOND_OUTPUT =
    new SimpleDateFormat( "ss" );
  private static final SimpleDateFormat COMPLETE =
    new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
  private static Date pqPublish;
  private static Date pqRelease;
  private static Date uclaPublish;

  public ReleaseDateCalculator()
  {
    super();
  }

  public static void main( String[] args )
  {
    int embargoLength;
    GregorianCalendar uclaRelease;

    verifyTags( args );
    pqPublish = convertInputDate( args[ 0 ] );
    pqRelease = convertInputDate( args[ 1 ] );
    uclaPublish = convertInputDate( args[ 2 ] );
    checkConvertedDates();
    uclaRelease = populateRelease( uclaPublish );
    checkReleaseDate( uclaRelease );
    embargoLength = calculateEmbargo( pqPublish, pqRelease );
    checkEmbargoLength(embargoLength);
    uclaRelease.add( Calendar.DAY_OF_YEAR, embargoLength );
    System.out.println( COMPLETE.format( uclaRelease.getTime() ) );
    System.exit( 0 );
  }

  private static void verifyTags( String[] args )
  {
    if ( args.length != 3 )
    {
      System.err.println( "incorrect number of inputs" );
      System.exit( 1 );
    }
  }

  private static Date convertInputDate( String input )
  {
    try
    {
      return COMPLETE.parse( input );
    }
    catch ( ParseException pe )
    {
      System.err.println( pe.getMessage() );
      return null;
    }
  }

  private static GregorianCalendar populateRelease( Date source )
  {
    try
    {
      return new GregorianCalendar( Integer.parseInt( YEAR_OUTPUT.format( source ) ),
                                    Integer.parseInt( MONTH_OUTPUT.format( source ) ) -
                                    1,
                                    Integer.parseInt( DAY_OUTPUT.format( source ) ),
                                    Integer.parseInt( HOUR_OUTPUT.format( source ) ),
                                    Integer.parseInt( MINUTE_OUTPUT.format( source ) ),
                                    Integer.parseInt( SECOND_OUTPUT.format( source ) ) );
    }
    catch ( Exception e )
    {
      System.err.println( e.getMessage() );
      return null;
    }
  }

  private static int calculateEmbargo( Date start, Date stop )
  {
    try
    {
      return Days.daysBetween( new DateTime( start ),
                               new DateTime( stop ) ).getDays() + 1;
    }
    catch ( Exception e )
    {
      System.err.println( e.getMessage() );
    }
    return -1;
  }

  private static void checkConvertedDates()
  {
    if ( pqPublish == null || pqRelease == null || uclaPublish == null )
    {
      System.err.println( "converted input date set to null" );
      System.exit( 2 );
    }
  }

  private static void checkReleaseDate( GregorianCalendar calendar )
  {
    if ( calendar == null )
    {
      System.err.println( "converted release date set to null" );
      System.exit( 3 );
    }
  }

  private static void checkEmbargoLength( int length )
  {
    if ( length == -1 )
    {
      System.err.println( "calculated embargo set to -1" );
      System.exit( 4 );
    }
  }
}
