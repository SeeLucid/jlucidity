package jlucidity.source.bytecode;

import jlucidity.bytecode.*;
import jlucidity.source.*;
import jlucidity.info.*;

import java.util.Set;
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

	/* TODO */
	public Set<FieldInfo> getFields()
	{
		/*BytecodeFieldInfo*/
		return null;
	}

	/* TODO */
	public Set<MethodInfo> getMethods()
	{
		/*BytecodeMethodInfo*/
		return null;
	}

	/* TODO */
	public Set<ConstructorInfo> getContructors()
	{
		/*BytecodeConstructorInfo*/
		return null;
	}

	/* TODO */
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
