package edu.ucla.library.libservices.etds.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import java.util.Vector;

import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

public class EtdMetaUpdater
{
  //private static final SimpleDateFormat LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  //private static final SimpleDateFormat SHORT = new SimpleDateFormat("MM/dd/yyyy");

  //private static int embargoCode;
  private static File xml;
  private static String pubDate;
  //private static String releaseDate;
  private static Vector<String> lines;
  private static BufferedWriter writer;

  public EtdMetaUpdater()
  {
    super();
  }

  public static void main(String[] args)
  {
    verifyArgs(args);

    populateFromInput(args);

    verifyXml();

    populateLines();
    
    checkIfPreModified();

    prepWriter();

    //if ( embargoCode == 0 )
    updateNoEmbargo();
    //else
    //updateEmbargoed();
    verifyXml();
  }

  private static void populateFromInput(String[] args)
  {
    xml = new File(args[0]);
    //embargoCode = Integer.parseInt( args[ 1 ] );
    pubDate = args[1];
    //releaseDate = args[ 3 ];
  }

  private static void verifyArgs(String[] args)
  {
    if (args.length != 2)
    {
      System.err.println("incorrect number of inputs");
      System.exit(1);
    }
  }

  @SuppressWarnings("oracle.jdeveloper.java.nested-assignment")
  private static void populateLines()
  {
    BufferedReader reader;
    String theLine;

    try
    {
      reader = new BufferedReader(new FileReader(xml));
      lines = new Vector<String>();
      theLine = null;
      while ((theLine = reader.readLine()) != null)
      {
        //lines.add( theLine );
        lines.add(new String(StandardCharsets.UTF_8
                                             .encode(theLine)
                                             .array()).trim());
      }
      reader.close();
    }
    catch (FileNotFoundException fnfe)
    {
      System.err.println(fnfe.getMessage());
      System.exit(2);
    }
    catch (IOException ioe)
    {
      System.err.println(ioe.getMessage());
      System.exit(3);
    }
  }

  private static void prepWriter()
  {
    writer = null;
    try
    {
      writer = new BufferedWriter(new FileWriter(xml));
    }
    catch (IOException ioe)
    {
      System.err.println(ioe.getMessage());
      System.exit(4);
    }
  }

  private static void updateNoEmbargo()
  {
    if (writer != null)
    {
      try
      {
        for (String copyLine: lines)
        {
          if (copyLine.contains("ISO-8859-1"))
          {
            writer.write(copyLine.substring(0, copyLine.indexOf("ISO-8859-1")));
            writer.write("UTF-8");
            writer.write(copyLine.substring(copyLine.indexOf("ISO-8859-1") + 10));
            writer.newLine();
          }
          else if (copyLine.contains("DISS_agreement_decision_date"))
          {
            writer.write("<!-- Replacing PQ acceptance with UCLA acceptance -->");
            writer.write("<!--");
            writer.write(copyLine);
            writer.write("-->");
            writer.newLine();
            writer.write("<DISS_agreement_decision_date>" + pubDate + "</DISS_agreement_decision_date>");
            writer.newLine();
          }
          else
          {
            writer.write(copyLine);
            writer.newLine();
          }
        }
        writer.flush();
        writer.close();
      }
      catch (IOException ioe)
      {
        System.err.println(ioe.getMessage());
        System.exit(4);
      }
    }
  }

  /*private static void updateEmbargoed()
  {
    if (writer != null)
    {
      try
      {
        for (String copyLine: lines)
        {
          if (copyLine.contains("embargo_code"))
          {
            writer.write("<!--");
            writer.write(copyLine);
            writer.write("-->");
            writer.newLine();
            writer.write(copyLine.substring(0, copyLine.indexOf("embargo_code") + 14));
            writer.write("4");
            writer.write(copyLine.substring(copyLine.indexOf("embargo_code") + 15));
            writer.newLine();
          }
          else if (copyLine.contains("DISS_sales_restriction"))
          {
            writer.write("<!--");
            writer.write(copyLine);
            writer.write("-->");
            writer.write("<DISS_sales_restriction code=\"1\" remove=\"" + formatReleaseDate() + "\"/>");
            writer.newLine();
          }
          else if (copyLine.contains("DISS_agreement_decision_date"))
          {
            writer.write("<!-- Replacing PQ pub with UCLA pub-->");
            writer.write("<!--");
            writer.write(copyLine);
            writer.write("-->");
            writer.newLine();
            writer.write("<DISS_agreement_decision_date>" + pubDate + "</DISS_agreement_decision_date>");
            writer.newLine();
          }
          else if (copyLine.contains("DISS_delayed_release"))
          {
            writer.write("<!-- Replacing PQ release with UCLA release-->");
            writer.write("<!--");
            writer.write(copyLine);
            writer.write("-->");
            writer.newLine();
            writer.write("<DISS_delayed_release>" + releaseDate + "</DISS_delayed_release>");
            writer.newLine();
          }
          else
          {
            writer.write(copyLine);
            writer.newLine();
          }
        }
        writer.flush();
        writer.close();
      }
      catch (IOException ioe)
      {
        System.err.println(ioe.getMessage());
        System.exit(4);
      }
    }
  }

  private static String formatReleaseDate()
  {
    try
    {
      return SHORT.format(LONG.parse(releaseDate));
    }
    catch (ParseException pe)
    {
      System.err.println(pe.getMessage());
      return null;
    }
  }*/

  private static void verifyXml()
  {
    Document doc;
    try
    {
      doc = DocumentBuilderFactory.newInstance()
                                  .newDocumentBuilder()
                                  .parse(xml);
    }
    catch (ParserConfigurationException pce)
    {
      System.err.println(pce.getMessage());
      System.exit(5);
    }
    catch (SAXException saxe)
    {
      System.err.println(saxe.getMessage());
      System.exit(6);
    }
    catch (IOException ioe)
    {
      System.err.println(ioe.getMessage());
      System.exit(7);
    }
  }

  private static void checkIfPreModified()
  {
    for ( String theLine : lines )
    {
      if ( theLine.contains("Replacing PQ acceptance ") )
      {
        // file has already been modified with UCLA acceptance date, no need to edit
        System.exit(0);
      }
    }
  }
}
