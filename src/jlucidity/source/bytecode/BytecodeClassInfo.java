package jlucidity.source.bytecode;

import jlucidity.bytecode.*;
import jlucidity.source.*;
import jlucidity.info.*;

import java.util.Set;
import java.util.HashSet;
import java.io.InputStream;
import java.io.IOException;

/**
 * Uses {@link jlucidity.bytecode.ClassReader ClassReader} to
 * retrieve information from bytecode.
 *
 */
public class BytecodeClassInfo extends ClassInfo implements VerifiableClassInfo
{
	private ClassReader creader;
	private ClassName name;
	private Set<FieldInfo> fields;
	private Set<MethodInfo> methods;
	private Set<ConstructorInfo> constructors;

	/**
	 * @param in	bytecode data
	 */
	public BytecodeClassInfo(ClassSource source, InputStream in) throws IOException
	{
		super(source);
		try{
			creader=new ClassReader(in);
		} catch(IOException e) {
			throw new IOException("BytecodeClassInfo: Malformed bytecode",e);
		};
	}

	/* TODO */
	public boolean verify(ClassName name)
	{
		return getClassName().equals(name);
	}

	/* TODO */
	public ClassName getClassName()
	{
		if(name==null)
			name=new ClassName(((CIClass)ConstantPoolReader.getIndex(creader.getConstantPool(),creader.getThisClass())).getName(creader.getConstantPool()));
		return name;
	}

	public ClassReader getClassReader()
	{
		return creader;
	}

	public Set<FieldInfo> getFields()
	{
		if(fields == null)
			retrieveFields();
		return fields;
	}

	public Set<MethodInfo> getMethods()
	{
		if(methods == null)
			retrieveMethods();
		return methods;
	}

	public Set<ConstructorInfo> getContructors()
	{
		if(constructors == null)
			retrieveMethods();
		return constructors;
	}

	private void retrieveFields()
	{
		fields = new HashSet<FieldInfo>();
		BCFieldInfo[] bfield = creader.getFields();
		for(BCFieldInfo f : bfield)
			fields.add(new BytecodeFieldInfo(this,f));
	}

	private void retrieveMethods()
	{
		methods = new HashSet<MethodInfo>();
		constructors = new HashSet<ConstructorInfo>();
		BCMethodInfo[] bmeth = creader.getMethods();
		for(BCMethodInfo m : bmeth)
			if(m.getName(creader.getConstantPool()).equals("<init>"))
				constructors.add(new BytecodeConstructorInfo(this,m));
			else
				methods.add(new BytecodeMethodInfo(this,m));
	}

	public int getModifiers()
	{
		return creader.getAccessFlags();
	}

	/* TODO */
	public String toGenericString()
	{
		return "";
	}
}
