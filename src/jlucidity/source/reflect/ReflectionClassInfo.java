package jlucidity.source.reflect;

import jlucidity.source.*;
import jlucidity.info.*;

//import java.lang.reflect.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.Set;
import java.util.HashSet;

/**
 * Use reflection to retrieve information about classes.
 */
public class ReflectionClassInfo extends ClassInfo
{
	private final Class clazz;

	private ClassName clazzName;
	private Set<FieldInfo> fields;
	private Set<MethodInfo> methods;
	private Set<ConstructorInfo> constructors;

	public ReflectionClassInfo(ClassSource source, Class clazz)
	{
		super(source);
		this.clazz=clazz;
	}

	public ClassSource getSource()
	{
		return source;
	}

	public ClassName getClassName()
	{
		if(clazzName==null)
			clazzName=new ClassName(clazz.getName());
		return clazzName;
	}

	public Set<FieldInfo> getFields()
	{
		if(fields==null)
		{
			fields=new HashSet<FieldInfo>();
			Field[] f=clazz.getFields();
			for(int i=0;i<f.length;i++)
				fields.add(new ReflectionFieldInfo(f[i]));
		}
		return fields;
	}

	public Set<MethodInfo> getMethods()
	{
		if(methods==null)
		{
			methods=new HashSet<MethodInfo>();
			Method[] m=clazz.getMethods();
			for(int i=0;i<m.length;i++)
				methods.add(new ReflectionMethodInfo(m[i]));
		}
		return methods;
	}

	public Set<ConstructorInfo> getContructors()
	{
		if(constructors==null)
		{
			constructors=new HashSet<ConstructorInfo>();
			Constructor[] c=clazz.getConstructors();
			for(int i=0;i<c.length;i++)
				constructors.add(new ReflectionConstructorInfo(c[i]));
		}
		return constructors;
	}

	public int getModifiers()
	{
		return clazz.getModifiers();
	}

	public String toGenericString()
	{
		return "";
	}
}
