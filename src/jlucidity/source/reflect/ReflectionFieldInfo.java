package jlucidity.source.reflect;

import jlucidity.info.*;

import java.lang.reflect.Field;

/**
 * Use reflection to retrieve field information.
 */
public class ReflectionFieldInfo extends FieldInfo
{
	private final Field field;

	public ReflectionFieldInfo(Field f)
	{
		this.field=f;
	}

	public String getFieldDeclaration()
	{
		return field.toGenericString();
	}

	public String toString()
	{
		return field.toString();
	}

	/* TODO */
	public String getDescriptor()
	{
		return "";
	}

	/* TODO */
	public String getName()
	{
		return "";
	}

	public int getModifiers()
	{
		return field.getModifiers();
	}

	/* TODO */
	public String toGenericString()
	{
		return "";
	}
}
