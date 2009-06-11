package jlucidity.info;

import jlucidity.lang.*;

/**
 * Stores a class name.
 */
public class ClassName
{
	private PackageName pack;
	private	String name;

	private int hash=-1;

	/**
	 * Returns the last part of the FQN.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the class' package.
	 */
	public PackageName getPackageName()
	{
		return pack;
	}

	public final String getFQN()
	{
		String ts="";
		if(!pack.isUnnamed())
			ts+=pack.toString()+".";
		return ts+name;
	}

	public String toString()
	{
		return getFQN();
	}

	public ClassName(String fqn)
	{
		this(PackageName.fqnToPackageName(fqn),
				JavaLanguage.getClassPart(fqn));
	}

	public ClassName(PackageName pack,String clazzName)
	{
		if(clazzName==null || clazzName.equals(""))
			throw new IllegalArgumentException("Class name missing.");
		if(pack==null)
			pack=new PackageName();
		this.pack=pack;
		this.name=clazzName;
	}

	public int hashCode()
	{
		if(hash==-1)
			hash=(pack==null?0:pack.hashCode()) +
				(name==null?0:name.hashCode());
		return hash;
	}

	/*
	 * TODO
	 * 	be able to handle multiple types
	 */
	public boolean equals(Object o)
	{
		ClassName other=(ClassName)o;
		boolean eq=o!=null;
		eq=eq && this.pack!=null && this.pack.equals(other.pack);
		eq=eq && this.name!=null && this.name.equals(other.name);
		return eq;
	}
}
