package jlucidity.source.bytecode;

import jlucidity.source.*;
import jlucidity.info.*;

import java.util.Set;
import java.io.File;

/**
 * Retrieve class information from bytecode in a directory.
 *
 */
public class BytecodeClassSource implements ClassSource
{
	private boolean mapped;
	private File dir;

	public BytecodeClassSource(File dir)
	{
		this.dir=dir;
		this.mapped=false;
	}

	/* TODO */
	public String getSourceName()
	{
		return dir.getName();
	}

	public String getSourceDescription()
	{
		return "Bytecode";
	}

	/* TODO */
	public Set<ClassName> getClassNames()
	{
		if(!mapped)
			map();
		return null;
	}

	/* TODO */
	public Set<ClassName> getClassNames(PackageName packageName)
	{
		if(!mapped)
			map();
		return null;
	}

	/* TODO */
	public ClassInfo getClassInfo(ClassName className)
	{
		if(!mapped)
			map();
		return null;
	}

	/* TODO */
	public Set<PackageName> getPackages()
	{
		if(!mapped)
			map();
		return null;
	}

	/* TODO */
	public void remap()
	{
	}

	/* TODO */
	public void map()
	{
		if(!dir.isDirectory())
			throw new IllegalArgumentException("BytecodeClassSource: "+dir.getName()+
					" is not a directory.");
	}
}
