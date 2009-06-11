package jlucidity.filter;

import java.io.*;

public class ClassSearchFilter implements FileFilter
{
	final static int magic=0xCAFEBABE;

	public boolean accept(File pathname)
	{
		if(pathname.canRead())
			return pathname.isDirectory()||isClassFile(pathname);
		return false;
	}

	/* XXX could look to see if it begins with 0xCAFEBABE :^) */
	public static boolean isClassFile(File pathname)
	{
		return pathname.isFile() && pathCheck(pathname.getName());
	}

	public static boolean pathCheck(String path)
	{
		//return path.matches(".*(?i)\\.class$");
		return path.endsWith(".class");
			//|| path.endsWith(".CLASS");
	}

	/* 0xCAFEBABE */
	public static boolean isClass(InputStream clazz)
	{
		int n=0;
		int s=0;
		int fn=4;
		try{
			int ch=-1;
			while((ch=clazz.read())!=-1 && n<fn)
			{
				s+=ch;
				s<<=8;
			}
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
		return s==magic;
	}
}
