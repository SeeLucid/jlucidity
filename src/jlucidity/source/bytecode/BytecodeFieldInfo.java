package jlucidity.source.bytecode;

import jlucidity.info.FieldInfo;
import jlucidity.bytecode.*;

public class BytecodeFieldInfo extends FieldInfo
{
	private BytecodeClassInfo info;
	private BCFieldInfo finfo;

	public BytecodeFieldInfo(BytecodeClassInfo info, BCFieldInfo finfo)
	{
		this.info=info;
		this.finfo=finfo;
	}

	public int getModifiers()
	{
		return finfo.getAccessFlags();
	}

	public String getFieldDeclaration()
	{
		return  this.getDescriptor() + this.getName();
	}

	public String getName()
	{
		return finfo.getDescriptor(info.getClassReader().getConstantPool());
	}

	public String getDescriptor()
	{
		return finfo.getDescriptor(info.getClassReader().getConstantPool());
	}

	/*TODO*/
	public String toGenericString()
	{
		return null;
	}
}
