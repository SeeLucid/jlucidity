package jlucidity.source.reflect;

import jlucidity.source.*;
import jlucidity.info.*;
import jlucidity.misc.IOUtils;

import java.util.Set;
import java.net.URL;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Use reflection to retrieve information from class files.
 */
public class ReflectionClassSource implements ClassSource
{
	private byte[] bytecode;

	public ReflectionClassSource(URL url)
	{
		//bytecode=url;
	}

	public ReflectionClassSource(File file) throws FileNotFoundException,IOException
	{
		this(new FileInputStream(file));
	}

	public ReflectionClassSource(InputStream instream) throws IOException
	{
		bytecode=IOUtils.getStreamAsByteArray(instream);
	}

	public String getSourceName()
	{
		return bytecode.toString();
	}

	// TODO add annotations
	public String getSourceDescription()
	{
		return "Reflection";
	}

	public String toString()
	{
		return getSourceDescription()+": "+getSourceName();
	}

	/* TODO */
	public Set<PackageName> getPackages()
	{
		return null;
	}

	/* TODO */
	public ClassInfo getClassInfo(ClassName className)
	{
		return null;
	}

	/* TODO */
	public Set<ClassName> getClassNames()
	{
		return null;
	}

	/* TODO */
	public Set<ClassName> getClassNames(PackageName packageName)
	{
		return null;
	}

	/* TODO */
	public void remap()
	{
	}

	/* TODO */
	public void map()
	{
	}
}
