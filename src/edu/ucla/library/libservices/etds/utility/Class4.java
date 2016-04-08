package edu.ucla.library.libservices.etds.utility;

import java.io.File;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Class4
{
  private static final String INSERT = "insert into vger_support.NEW_ETDS(PROQ_ID) values(?)";

  public Class4()
  {
    super();
  }

  public static void main( String[] args )
  {
    DriverManagerDataSource ds;
    File dir;
    File[] entries;

    ds = new DriverManagerDataSource();
    ds.setDriverClassName( "oracle.jdbc.OracleDriver" );
    ds.setUrl( "jdbc:oracle:thin:@ils-db-prod.library.ucla.edu:1521:VGER" );
    ds.setUsername( "vger_support" );
    ds.setPassword( "vger_support_pwd" );

    dir = new File( "F:\\cataloging" );
    entries = dir.listFiles();

//new  JdbcTemplate( ds ).queryForList( INSERT, String.class )

    for ( File theEntry: entries )
    {
      if ( theEntry.isDirectory() && theEntry.getName().length() == 5  )
      {
        int update;
        try
        {
          update = new JdbcTemplate( ds ).update( INSERT, new Object[]
                { theEntry.getName() } );
          if ( update != 1 )
            System.err.println( "error adding PQ " + theEntry.getName() );
        }
        catch ( Exception e )
        {
          System.err.println( "problem adding PQ " + theEntry.getName() +
                              "\t" + e.getMessage() );
        }

      }
    }
  }
}
