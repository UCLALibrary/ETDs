package edu.ucla.library.libservices.etds.utility;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Class5
{
  private static final String IDS =
    "SELECT proq_id FROM vger_support.remaining_backlog WHERE record_id = -1";
  private static final String COUNT_QUERY =
    "SELECT count(*) FROM vger_subfields.ucladb_bib_subfield WHERE tag = '948k'" +
    " AND lower(subfield) LIKE 'etds-%' || ?";
  private static final String ID_QUERY =
    "SELECT record_id FROM vger_subfields.ucladb_bib_subfield WHERE tag = '948k'" +
    " AND lower(subfield) LIKE 'etds-%' || ?";
  private static final String UPDATE_QUERY =
    "UPDATE vger_support.remaining_backlog SET record_id = ? WHERE proq_id = ?";
  private static DriverManagerDataSource ds;

  public Class5()
  {
    super();
  }

  public static void main( String[] args )
  {
    List<String> proqIDs;

    ds = new DriverManagerDataSource();
    ds.setDriverClassName( "oracle.jdbc.OracleDriver" );
    ds.setUrl( "url" );
    ds.setUsername( "user" );
    ds.setPassword( "pwd" );
    
    System.out.println( "getting proq IDs" );
    proqIDs = new JdbcTemplate( ds ).queryForList( IDS, String.class );
    System.out.println( "number of results = " + proqIDs.size() );
    for ( String proq : proqIDs )
    {
      int bib;
      int update;
      
      System.out.println( "working with proq " + proq );
      bib = getRecordID( proq );
      try
      {
        update = new JdbcTemplate( ds ).update( UPDATE_QUERY, new Object[]
              { bib, proq } );
        if ( update != 1 )
          System.err.println( "error adding PQ " + proq );
      }
      catch ( Exception e )
      {
        System.err.println( "problem adding PQ " + proq + "\t" +
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
