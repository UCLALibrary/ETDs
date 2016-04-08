package edu.ucla.library.libservices.etds.utility;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class ErcFileWriter
{
  private static final String OUTPUT_FILE = "mrt-erc.txt";
  private static final String LASTNAME_TAG = "DISS_surname";
  private static final String FIRSTNAME_TAG = "DISS_fname";
  private static final String TITLE_TAG = "DISS_title";
  private static final String PUB_DATE_TAG =
    "DISS_agreement_decision_date";
  private static final String IN_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  private static final String OUT_DATE_FORMAT = "yyyy-MM-dd";

  private static String fileToRead;
  private static String outputDirectory;
  private static String pubDate;
  private static String lastName;
  private static String firstName;
  private static String title;
  private static String proQuestID;

  public ErcFileWriter()
  {
    super();
  }

  public static void main( String[] args )
  {
    verifyArgs( args );
    populateVarsFromInput( args );
    populateVarsFromXML( fileToRead );
    setProQuestID();
    convertPubDate();
    writeOutput();
    System.exit( 0 );
  }

  private static void verifyArgs( String[] args )
  {
    if ( args.length != 2 )
    {
      System.err.println( "usage: ErcFileWriter xmlFile outputDir" );
      System.exit( 101 );
    }
  }

  private static void populateVarsFromInput( String[] args )
  {
    fileToRead = args[ 0 ];
    outputDirectory = args[ 1 ];
  }

  private static void populateVarsFromXML( String filePath )
  {
    lastName = TagFinder.findTag( filePath, LASTNAME_TAG );
    firstName = TagFinder.findTag( filePath, FIRSTNAME_TAG );
    title = TagFinder.findTag( filePath, TITLE_TAG );
    pubDate = TagFinder.findTag( filePath, PUB_DATE_TAG );
  }

  private static void writeOutput()
  {
    BufferedWriter writer;
    try
    {
      writer =
          new BufferedWriter( new FileWriter( new File( outputDirectory.concat( OUTPUT_FILE ) ) ) );
      writer.write( "erc:" );
      writer.newLine();
      writer.write( "who: " );
      writer.write( lastName + ", " + firstName );
      writer.newLine();
      writer.write( "what: " );
      writer.write( title );
      writer.newLine();
      writer.write( "when: " );
      writer.write( pubDate );
      writer.newLine();
      writer.write( "where: " );
      writer.write( "ucla.etd:PQ".concat( proQuestID ) );
      writer.newLine();
      writer.flush();
      writer.close();
    }
    catch ( IOException ioe )
    {
      System.err.println( ioe.getMessage() );
      System.exit( 102 );
    }
  }

  private static void convertPubDate()
  {
    pubDate =
        DateFormatConverter.convertDate( pubDate, IN_DATE_FORMAT, OUT_DATE_FORMAT );
  }

  private static void setProQuestID()
  {
    String fileName;
    String[] tokens;
    fileName = fileToRead.substring( fileToRead.lastIndexOf( File.separator ) );
    tokens = fileName.split( "_" );
    proQuestID = tokens[3];
  }
}
