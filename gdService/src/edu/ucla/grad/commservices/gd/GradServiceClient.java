package edu.ucla.grad.commservices.gd;

import java.text.SimpleDateFormat;

import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.soap.AddressingFeature;

public class GradServiceClient
{
  @WebServiceRef
  private static ProquestFilerService proquestFilerService;
  private static final SimpleDateFormat FORMAT =
    new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

  public GradServiceClient()
  {
    super();
  }

  public static void main( String[] args )
  {
    IProquestFilerService iProquestFilerService;
    Map<String, Object> requestContext;
    ReturnResultsForProquestFilersByID result;

    if ( args.length != 2 )
    {
      System.err.println( "usage: GradServiceClient <access key> <PQ ID>" );
      System.exit( 1 );
    }
    try
    {
      proquestFilerService = new ProquestFilerService();
      iProquestFilerService =
          proquestFilerService.getWsHttpEndpoint( new AddressingFeature( true,
                                                                         true ) );

      requestContext =
          ( ( BindingProvider ) iProquestFilerService ).getRequestContext();
      result =
          iProquestFilerService.getProquestFilerForProquestID( args[ 0 ],
                                                               args[ 1 ] );
      System.out.println( FORMAT.format( result.getProquestFiler().getValue()
                                         .getFileDate().getValue().toGregorianCalendar().getTime() ) );
    }
    catch ( Exception ex )
    {
      System.err.println( ex.getMessage() );
      System.exit( 2 );
    }
  }
}
