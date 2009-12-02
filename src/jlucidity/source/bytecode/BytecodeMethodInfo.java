package jlucidity.source.bytecode;

import jlucidity.info.MethodInfo;
import jlucidity.bytecode.*;

public class BytecodeMethodInfo extends MethodInfo
{
	private BytecodeClassInfo info;
	private BCMethodInfo minfo;

	public BytecodeMethodInfo(BytecodeClassInfo info, BCMethodInfo minfo)
	{
		this.info=info;
		this.minfo=minfo;
	}

	public int getModifiers()
	{
		return minfo.getAccessFlags();
	}

	public String getName()
	{
		return minfo.getDescriptor(info.getClassReader().getConstantPool());
	}

	public String getDescriptor()
	{
		return minfo.getDescriptor(info.getClassReader().getConstantPool());
	}

	/* TODO */
	public String toGenericString()
	{
		return null;
	}

	/* TODO */
	public String getMethodSignature()
	{
		return null;
	}
}
