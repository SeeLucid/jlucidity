package jlucidity.source.reflect;

import jlucidity.info.*;

import java.lang.reflect.Method;

/**
 * Use reflection to retrieve method information.
 */
public class ReflectionMethodInfo extends MethodInfo
{
	private final Method method;

	public ReflectionMethodInfo(Method m)
	{
		this.method=m;
	}

	public String getMethodSignature()
	{
		return method.toGenericString();
	}

	public String toString()
	{
		return method.toString();
	}

	public int getModifiers()
	{
		return method.getModifiers();
	}

	public String toGenericString()
	{
		return method.toGenericString();
	}
}
