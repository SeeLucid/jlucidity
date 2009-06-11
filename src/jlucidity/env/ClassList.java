package jlucidity.env;

import jlucidity.source.*;
import jlucidity.info.*;

import java.util.Set;
import java.util.HashSet;

import java.util.Map;
import java.util.HashMap;

//import java.util.List;
//import java.util.LinkedList;

/**
 * Keep track of all the class information from multiple class
 * sources.
 */
public class ClassList
{
	private static Set<ClassSource> sources;
	/*private static Set<ClassName> classes;*/
	private static Map<PackageName,Set<PackageInfo>> packages;
	private static Map<ClassName,Set<ClassInfo>> classes;

	static {
		sources=new HashSet<ClassSource>();
		packages=new HashMap<PackageName,Set<PackageInfo>>();
		classes=new HashMap<ClassName,Set<ClassInfo>>();
	}

	public static void addSource(ClassSource source)
	{
		sources.add(source);
	}
}
