package jlucidity.info;

import jlucidity.source.*;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/**
 * Abstract class for storing information about classes.
 *
 * @see java.lang.Class
 */
public abstract class ClassInfo extends TypeInfo implements SourceProduct
{
	private static Map<String,String> infoTypes;
	protected ClassSource source;

	static {
		infoTypes=new HashMap<String,String>();
		infoTypes.putAll(TypeInfo.getInfoTypes());
		infoTypes.put("Class name","The name of the class.");
		infoTypes.put("Fields","The fields available to this class.");
		infoTypes.put("Methods","The methods available to this class.");
		infoTypes.put("Constructors","The constructors available to this class.");
	}

	public ClassInfo(ClassSource source)
	{
		this.source=source;
	}

	public ClassSource getSource()
	{
		return source;
	}

	public static Map<String,String> getInfoTypes()
	{
		return infoTypes;
	}

	public Object getInfo(String infoType)
	{
		if("Class name".equals(infoType))
			return getClassName();
		else if("Fields".equals(infoType))
			return getFields();
		else if("Methods".equals(infoType))
			return getMethods();
		else if("Constructors".equals(infoType))
			return getContructors();
		else
			return super.getInfo(infoType);
	}

	public abstract ClassName getClassName();

	public abstract Set<FieldInfo> getFields();

	public abstract Set<MethodInfo> getMethods();

	public abstract Set<ConstructorInfo> getContructors();

	// TODO
	//public abstract Set<ClassInfo> getClasses();
}
