package edu.ucla.library.libservices.etds.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProqIDMapper
  implements RowMapper
{
  public ProqIDMapper()
  {
    super();
  }

  public Object mapRow( ResultSet rs, int rowNum )
    throws SQLException
  {
    ProqID bean;

    bean = new ProqID();
    bean.setIdNo( rs.getString( "proq_id" ) );
    
    return bean;
  }
}
