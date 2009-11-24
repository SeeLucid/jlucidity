package jlucidity.source.bytecode;

import jlucidity.info.FieldInfo;
import jlucidity.bytecode.*;

public class BytecodeFieldInfo extends FieldInfo
{
	private BytecodeClassSource source;
	private BytecodeClassInfo info;
	private BCFieldInfo finfo;

	public BytecodeFieldInfo(BytecodeClassSource source, BytecodeClassInfo info, BCFieldInfo finfo)
	{
		this.source=source;
		this.info=info;
		this.finfo=finfo;
	}

	public int getModifiers()
	{
		return finfo.getAccessFlags();
	}

	public String getFieldDeclaration()
	{
		return finfo.getDescriptor(info.getClassReader().getConstantPool()) + finfo.getName(info.getClassReader().getConstantPool());
	}

	public String toGenericString()
	{
		return null;
	}
}
