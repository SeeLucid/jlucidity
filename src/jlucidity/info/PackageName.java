package jlucidity.info;

import jlucidity.lang.*;

/**
 * Stores a package name.
 *
 * see JLS 3rd ed. §6.8.1, §7, §3.8
 */
public class PackageName
{
	boolean unnamed;
	private String pack;

	private int hash=-1;

	/**
	 * Creates a named package
	 *
	 * @param pack	the name of the package
	 *
	 * @throws java.lang.IllegalArgumentException	if the package name is invalid.
	 */
	public PackageName(String pack)
	{
		if(pack!=null && !isValidPackageName(pack))
			throw new
				IllegalArgumentException("Not a valid package name: "+pack);
		this.pack=pack;
		this.unnamed=(pack==null);
	}

	/**
	 * Creates an unnamed package.
	 *
	 * see JLS 3rd ed. §7.4.2
	 */
	public PackageName()
	{
		this(null);
	}

	public static PackageName fqnToPackageName(String fqn)
	{
		return new PackageName(JavaLanguage.getPackagePart(fqn));
	}

	public boolean isUnnamed()
	{
		return unnamed;
	}

	public String getPackage()
	{
		if(isUnnamed())
			return "<Unnamed>";
		return pack;
	}

	public static boolean isValidPackageName(String packName)
	{
		String sp[]=packName.split("\\.",-1);
		boolean b=true;
		for(int i=0;i<sp.length && b;i++)
			b=b&&JavaLanguage.isIdentifier(sp[i]);
		return b;
	}

	public String toString()
	{
		return getPackage();
	}

	public int hashCode()
	{
		if(hash==-1)
			hash=unnamed?0:pack.hashCode();
		return hash;
	}

	/*
	 * TODO
	 * 	be able to handle multiple types
	 */
	public boolean equals(Object o)
	{
		PackageName other=(PackageName)o;
		boolean eq=o!=null;
		eq=eq && this.unnamed==other.unnamed;
		eq=eq && this.pack!=null && this.pack.equals(other.pack);
		return eq;
	}
}
