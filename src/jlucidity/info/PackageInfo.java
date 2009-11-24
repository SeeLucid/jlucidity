package jlucidity.info;

import jlucidity.source.*;

import java.util.Map;
import java.util.HashMap;

/**
 * Abstract class for storing information about packages.
 *
 * @see java.lang.Package
 */
public abstract class PackageInfo extends TypeInfo implements SourceProduct
{
	private final static Map<String,String> infoTypes;

	public static Map<String,String> getInfoTypes()
	{
		return infoTypes;
	}

	static {
		infoTypes=new HashMap<String,String>();
		infoTypes.putAll(TypeInfo.getInfoTypes());
		infoTypes.put("Package name","The name of the package.");
	}

	public Object getInfo(String infoType)
	{
		if(infoType.equals("Package name"))
				return getPackageName();
		else
			return super.getInfo(infoType);
	}

	public abstract PackageName getPackageName();
}
