package jlucidity.source.reflect;

import jlucidity.info.*;

import java.lang.reflect.Constructor;

/**
 * Use reflection to retrieve constructor information.
 */
public class ReflectionConstructorInfo extends ConstructorInfo
{
	private final Constructor constructor;

	public ReflectionConstructorInfo(Constructor c)
	{
		this.constructor=c;
	}

	public String getContructorSignature()
	{
		return constructor.toGenericString();
	}

	public String toString()
	{
		return constructor.toString();
	}

	public int getModifiers()
	{
		return constructor.getModifiers();
	}

	public String toGenericString()
	{
		return constructor.toGenericString();
	}
}
