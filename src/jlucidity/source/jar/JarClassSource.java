package jlucidity.source.jar;

import jlucidity.source.*;
import jlucidity.info.*;

import java.io.IOException;
import java.io.File;

import java.net.URL;
import java.net.JarURLConnection;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import java.util.Enumeration;

/*import java.util.jar.JarFile;*/
import java.util.jar.*;
//import java.util.zip.*;

/**
 * Retrieve class information from bytecode in a JAR file.
 *
 * @see java.util.jar.JarFile
 */
public class JarClassSource implements ClassSource
{
	private Map<ClassName,JarClassInfo> classes;
	private JarFile jar;
	private File file;

	private boolean mapped;

	public JarClassSource(String jarFileName) throws IOException
	{
		this(new File(jarFileName));
	}

	public JarClassSource(File jarFile) throws IOException
	{
		this.file=jarFile;
		this.jar=new JarFile(jarFile);
	}

        /*
         * TODO
         * reimplement somewhere else
         */
	/*public JarClassSource(JarURLConnection jarConnect)
	{
		this(jarConnect.getJarFile());
	}

	public JarClassSource(URL jarURL)
	{
		this(new JarURLConnection(jarURL));
	}*/

	public String getSourceName()
	{
		return jar.getName();
	}

	public String getSourceDescription()
	{
		return "Jar";
	}

	public String toString()
	{
		return getSourceDescription()+" : "+getSourceName();
	}

	public Set<ClassName> getClassNames()
	{
		if(!mapped)
			map();
		return classes.keySet();
	}

	/* TODO */
	public Set<ClassName> getClassNames(PackageName packageName)
	{
		if(!mapped)
			map();
		return null;
	}

	/* TODO */
	/*
	 * Fix this so it is more efficient in cases such as where
	 * className is a JarClassName
	 */
	public ClassInfo getClassInfo(ClassName className) throws UnsupportedOperationException
	{
		if(!mapped)
			map();
		JarClassName jcn=null;
		for(ClassName cn:classes.keySet())
			if(cn.hashCode()==className.hashCode())
				jcn=(JarClassName)cn;
		try{
		if(classes.get(className)==null)
			classes.put(jcn,new JarClassInfo(this,jcn));
		}catch(IOException e) {
			throw new UnsupportedOperationException("Could not get class: "+className, e);
		}
		return classes.get(className);
	}

	/* TODO */
	public Set<PackageName> getPackages()
	{
		if(!mapped)
			map();
		return null;
	}

	public JarFile getJarFile()
	{
		return jar;
	}

	/* TODO */
	public void remap() throws UnsupportedOperationException
	{
		try{
			this.jar=new JarFile(this.file);
		}catch(IOException e) {
			throw new UnsupportedOperationException("Can not open jar file: "+file, e);
		}
		boolean reinst=false;
		try{
			classes.clear();
		}catch(UnsupportedOperationException e) {
			reinst=true;
		}
		if(reinst || !classes.isEmpty())
			classes=null;
		mapped=false;
		map();
	}

	/* TODO */
	public void map()
	{
		if(classes==null)
			classes=new HashMap<ClassName,JarClassInfo>();
		Enumeration<JarEntry> en=jar.entries();
		while(en.hasMoreElements())
		{
			JarEntry jentry=en.nextElement();
			if(!jentry.isDirectory() && jentry.getName().endsWith(".class"))
			{
				classes.put(new JarClassName(jentry),null);
				/* TODO add to package set */
			}
		}
		mapped=true;
	}
}
