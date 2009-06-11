package jlucidity.filter;

import java.io.*;

public class DirectoryFilter implements FileFilter
{
	public boolean accept(File pathname)
	{
		return pathname.canRead() && pathname.isDirectory();
	}
}
