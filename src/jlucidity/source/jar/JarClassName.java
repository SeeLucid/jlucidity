package jlucidity.source.jar;

import jlucidity.info.*;
import jlucidity.lang.*;

import java.util.jar.JarEntry;

public class JarClassName extends ClassName
{
	private JarEntry entry;

	public JarClassName(JarEntry jEntry)
	{
		super(JavaLanguage.convertPathToFQN(jEntry.getName()));
		this.entry=jEntry;
	}

	public JarEntry getJarEntry()
	{
		return entry;
	}
}
