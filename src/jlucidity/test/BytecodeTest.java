package jlucidity.test;

import java.util.*;
import jlucidity.info.*;
import jlucidity.source.*;
import jlucidity.source.bytecode.*;
import jlucidity.source.jar.*;
import javax.swing.JTextField;
import java.util.jar.JarFile;
import java.io.*;

public class BytecodeTest
{
	List<String> classpaths;
	List<String> classes;

	public static void main(String args[])
	{
		new BytecodeTest();
	}

	BytecodeTest()
	{
		findClassPaths();
	}

	private void findClassPaths()
	{
		classpaths=new ArrayList<String>();
		/* Boot class path */
		classpaths.addAll(
			cpSplit(System.getProperty("sun.boot.class.path")));
		/* $CLASSPATH or -classpath */
		classpaths.addAll(
			cpSplit(System.getProperty("java.class.path")));
		for(int i=0;i<classpaths.size();)
			if(classpaths.get(i).matches("\\s*"))
				classpaths.remove(i);
			else
				i++;
		removeDuplicates(classpaths);
	}

	/**
	 * Split a class path string by the system's path
	 * separator.
	 *
	 * @param cp class path
	 */
	private static List<String> cpSplit(String cp)
	{
		List<String> l=new ArrayList<String>();
		String sep=System.getProperty("path.separator");
		l.addAll(Arrays.asList(cp.split(sep)));
		return l;
	}

	private static void removeDuplicates(List l)
	{
		for(int i=0;i<l.size()-1;i++)
		{
			Object cur=l.get(i);
			for(int j=i+1;j<l.size();)
				if(l.get(j).equals(cur))
					l.remove(j);
				else
					j++;
		}
	}

}

class SourceFactory
{
	static ClassSource getSource(String path)
	{
		try{
		if(isJar(path))
			return new JarClassSource(path);
		} catch(Exception e)
		{
			return null;
		}
		return null;
	}

	public static boolean isDirectory(String d)
	{
		return new File(d).isDirectory();
	}

	public static boolean isJar(String j)
	{
		try{
			new JarFile(j);
			return true;
		}catch(Exception e){
			/* ZipException or IOException */
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isFile(String f)
	{
		return new File(f).isFile();
	}
}
