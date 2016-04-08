package edu.ucla.library.libservices.etds.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailer
{
  private static Properties appProps;
  private static Properties sysProps;
  private static File workingDir;
  private static File[] etdDirs;
  private static Session mailSession;
  private static Message message;
  private static MimeBodyPart content;
  private static Multipart letter;

  public Mailer()
  {
    super();
  }

  public static void main( String[] args )
  {
    sysProps = System.getProperties();
    appProps = new Properties();
    try
    {
      appProps.load( new FileInputStream( new File( args[ 0 ] ) ) );
      sysProps.put( "mail.smtp.host",
                    appProps.getProperty( "mail.mailhost" ) );
            
      workingDir = new File( appProps.getProperty( "dirs.working" ) );
      etdDirs = workingDir.listFiles();
      
      if ( etdDirs.length != 0 )
          sendProcessed();
      else
          sendNoProcessed();
    }
    catch ( IOException ioe )
    {
      ioe.printStackTrace();
    }
    catch ( MessagingException me )
    {
      me.printStackTrace();
    }
  }

  private static InternetAddress[] populateAddresses(  String propName )
  {
    InternetAddress[] output;
    String[] addresses;

    addresses = appProps.getProperty( propName ).split( ";" );
    output = new InternetAddress[ addresses.length ];
    for ( int index = 0; index < output.length; index++ )
    {
      try
      {
        output[ index ] = new InternetAddress( addresses[ index ] );
      }
      catch ( AddressException ae )
      {
        ae.printStackTrace();
      }
    }
    return output;
  }

  private static void sendNoProcessed()
    throws MessagingException
  {
    initMessage();
    message.setRecipients( Message.RecipientType.TO, populateAddresses( "mail.alwayssend" ) );
    message.setSubject( "No New ETDs Available on the Library's SFTP Server " );
    message.setSentDate( new Date() );
    content = new MimeBodyPart();
    content.setText( "No ETDs to process this run." );
    letter = new MimeMultipart();
    letter.addBodyPart( content );
    message.setContent( letter );
    Transport.send( message );
  }

  private static void initMessage()
    throws AddressException, MessagingException
  {
    mailSession = Session.getDefaultInstance( sysProps, null );
    message = new MimeMessage( mailSession );
    message.setFrom( new InternetAddress( appProps.getProperty( "mail.fromaddress" ) ) );
  }

  private static void sendProcessed()
    throws MessagingException
  {
    initMessage();
    message.setRecipients( Message.RecipientType.TO, populateAddresses( "mail.etdsend" ) );
    message.setRecipients( Message.RecipientType.CC, populateAddresses( "mail.alwayssend" ) );
    message.setSubject( "ETDs Available on the Library's SFTP Server " );
    message.setSentDate( new Date() );
    content = new MimeBodyPart();
    content.setText( populateEtds() );
    letter = new MimeMultipart();
    letter.addBodyPart( content );
    message.setContent( letter );
    Transport.send( message );
  }
  
  private static String populateEtds()
  {
    StringBuffer buffer;
    
    buffer = new StringBuffer( "The following ETDs are available on the Library's sftp server:\n" );
    buffer.append( "sftp.library.ucla.edu\n" );
    
    for ( File theDir : etdDirs )
    {
      String[] contents;

      contents = theDir.list();
      buffer.append( "--\n" );
      buffer.append( "Directory:     /graddiv/" ).append( theDir.getName() ).append( "/\n" );
      for ( String theItem : contents )
        buffer.append( theItem ).append( "\n" );
    }
    
    return buffer.toString();
  }
}
