package edu.ucla.library.libservices.etds.main;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EtdsMaster
{
  public EtdsMaster()
  {
    super();
  }

  public static void main( String[] args )
  {
    Properties props;
    props = new Properties();

    try
    {
      props.load( new FileInputStream( new File( args[ 0 ] ) ) );
    }
    catch ( IOException ioe )
    {
      System.out.println( "problem with props file: " + ioe.getMessage() );
      System.exit( -1 );
    }
  }
}
