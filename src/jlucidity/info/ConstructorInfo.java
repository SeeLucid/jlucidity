package jlucidity.info;

/**
 * Abstract class for storing information about constructors.
 *
 * @see java.lang.reflect.Constructor
 */
public abstract class ConstructorInfo extends TypeInfo
{
	public abstract String getContructorSignature();
}
