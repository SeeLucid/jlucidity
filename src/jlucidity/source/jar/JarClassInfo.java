package jlucidity.source.jar;

import jlucidity.source.bytecode.*;

import java.util.jar.JarFile;
import java.util.jar.JarEntry;

import java.io.InputStream;
import java.io.IOException;
import java.net.URLClassLoader;

/* TODO */
public class JarClassInfo extends BytecodeClassInfo
{
	public JarClassInfo(JarClassSource source, JarClassName className) throws IOException
	{
		super(source, getInputStream(source, className) );
	}

	private static InputStream getInputStream(JarClassSource source, JarClassName className) throws IOException
	{
		JarFile jf=source.getJarFile();
		InputStream in=jf.getInputStream(className.getJarEntry());
		return in;
	}
}
