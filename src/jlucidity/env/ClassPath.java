package jlucidity.env;

import java.util.LinkedList;
import java.util.List;
import java.net.URL;

/**
 * Stores a class path.
 */
public class ClassPath
{
	List<URL> cp;

	public ClassPath(String classpath)
	{

	}

	public static ClassPath systemClassPath()
	{
		return new ClassPath(
				System.getProperty("java.class.path"));
	}
}
