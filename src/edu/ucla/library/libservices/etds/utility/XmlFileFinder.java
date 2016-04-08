package edu.ucla.library.libservices.etds.utility;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

public class XmlFileFinder
  extends DirectoryWalker
{
  private File root;

  public XmlFileFinder( IOFileFilter ioFileFilter,
                        IOFileFilter ioFileFilter1, int i )
  {
    super( ioFileFilter, ioFileFilter1, i );
  }

  public XmlFileFinder( java.io.FileFilter fileFilter, int i )
  {
    super( fileFilter, i );
  }

  public XmlFileFinder()
  {
    super();
  }

  public void setRoot( File root )
  {
    this.root = root;
  }

  private File getRoot()
  {
    return root;
  }

  @SuppressWarnings( "unchecked" )
  protected void handleFile( final File file, final int depth,
                             final Collection results )
  {
    if ( file.isFile() &&
         FilenameUtils.getExtension( file.getName() ).equalsIgnoreCase( "xml" ) )
      results.add( file );
  }

  public List<File> getFiles()
  {
    List<File> files = new ArrayList<File>();

    try
    {
      walk( getRoot(), files );
    }
    catch ( IOException ioe )
    {
      System.out.println( "Problem finding XML files: " +
                          ioe.getMessage() );
    }

    return files;
  }
}
