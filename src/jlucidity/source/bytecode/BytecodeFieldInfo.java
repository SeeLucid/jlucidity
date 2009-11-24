package jlucidity.source.bytecode;

import jlucidity.info.FieldInfo;
import jlucidity.bytecode.*;

public class BytecodeFieldInfo extends FieldInfo
{
	private BytecodeClassSource source;
	private BCFieldInfo finfo;

	public BytecodeFieldInfo(BytecodeClassSource source, BCFieldInfo finfo)
	{
		this.source=source;
		this.finfo=finfo;
	}

	public int getModifiers()
	{
		return finfo.getAccessFlags();
	}

	public String getFieldDeclaration()
	{
		return finfo.getDescriptor(source.getClassReader().getConstantPool()) + finfo.getName(source.getClassReader().getConstantPool());
	}

	public String toGenericString()
	{
		return null;
	}
}
