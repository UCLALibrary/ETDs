package edu.ucla.library.libservices.etds.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Class6
{
  public Class6()
  {
    super();
  }

  public static void main( String[] args )
    throws ClassNotFoundException, SQLException
  {
    Connection impcdb = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    Class.forName( "oracle.jdbc.OracleDriver" );
    impcdb =
        DriverManager.getConnection( "url",
                                     "user", "pwd" );
    ps =
        impcdb.prepareStatement( "SELECT proq_id FROM vger_support.remaining_backlog" );
    rs = ps.executeQuery();
    rs.next();
    do
    {
      System.out.println( "ID = " + rs.getString( "proq_id" ) );
    } while ( rs.next() );
  }
}
