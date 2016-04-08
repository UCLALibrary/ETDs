package edu.ucla.library.libservices.etds.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Class3
{
  private static final String BASE_DIR = "C:\\Temp\\etds\\embargoes\\";
  private static final String CODE_1 =
    BASE_DIR.concat( "embargo_code1_2015-07-21.txt" );
  private static final String CODE_2 =
    BASE_DIR.concat( "embargo_code2_2015-07-21.txt" );
  private static final String CODE_3 =
    BASE_DIR.concat( "embargo_code3_2015-07-21.txt" );
  private static final String CODE_4 =
    BASE_DIR.concat( "embargo_code4_2015-07-21.txt" );
  private static final String COUNT_QUERY =
    "SELECT count(*) FROM vger_subfields.ucladb_bib_subfield WHERE tag = '948k'" +
    " AND lower(subfield) LIKE 'etds-%' || ?";
  private static final String ID_QUERY =
    "SELECT record_id FROM vger_subfields.ucladb_bib_subfield WHERE tag = '948k'" +
    " AND lower(subfield) LIKE 'etds-%' || ?";
  private static final String INSERT_QUERY =
    "INSERT INTO vger_support.TMP_EMBARGO(proq_id, embargo_code) VALUES(?,?)";

  private static DriverManagerDataSource ds;

  public Class3()
  {
    super();
  }

  public static void main( String[] args )
    throws FileNotFoundException, IOException
  {
    makeConnection();
    //processFile( CODE_1, 1 );
    //processFile( CODE_2, 2 );
    //processFile( CODE_3, 3 );
    processFile( CODE_4, 3 );
  }

  private static void makeConnection()
  {
    ds = new DriverManagerDataSource();
    ds.setDriverClassName( "oracle.jdbc.OracleDriver" );
    ds.setUrl( "jdbc:oracle:thin:@ils-db-prod.library.ucla.edu:1521:VGER" );
    ds.setUsername( "vger_support" );
    ds.setPassword( "vger_support_pwd" );
  }

  private static void processFile( String fileName, int embargo )
    throws FileNotFoundException, IOException
  {
    BufferedReader reader;
    String line;

    reader = new BufferedReader( new FileReader( new File( fileName ) ) );
    line = null;

    while ( ( line = reader.readLine() ) != null )
    {
      //int id;
      int update;

      //id = getRecordID( line );
      try
      {
        update = new JdbcTemplate( ds ).update( INSERT_QUERY, new Object[]
              { line.substring( 0, line.indexOf( "/" ) ), embargo } );
        if ( update != 1 )
          System.err.println( "error adding PQ " + line );
      }
      catch ( Exception e )
      {
        System.err.println( "problem adding PQ " + line + "\t" +
                            e.getMessage() );
      }
    }
  }

  private static int getRecordID( String proqID )
  {
    int recordID;
    recordID = -1;

    if ( new JdbcTemplate( ds ).queryForInt( COUNT_QUERY, new Object[]
        { proqID } ) != 0 )
    {
      try
      {
        recordID =
            new JdbcTemplate( ds ).queryForInt( ID_QUERY, new Object[]
              { proqID } );
      }
      catch ( Exception e )
      {
        System.err.println( "problem matching  PQ " + proqID + "\t" +
                            e.getMessage() );
      }
    }

    return recordID;
  }
}
