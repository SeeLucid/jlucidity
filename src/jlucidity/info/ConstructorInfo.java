package jlucidity.info;

/**
 * Abstract class for storing information about constructors.
 *
 * @see java.lang.reflect.Constructor
 */
public abstract class ConstructorInfo extends TypeInfo
{
	/* TODO */
	/*public static Map<String,String> getInfoTypes()
	{
		return infoTypes;
	}*/

	public abstract String getContructorSignature();
}
