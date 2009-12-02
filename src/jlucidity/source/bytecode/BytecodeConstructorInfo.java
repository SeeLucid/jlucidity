package jlucidity.source.bytecode;

import jlucidity.info.ConstructorInfo;
import jlucidity.bytecode.*;

public class BytecodeConstructorInfo extends ConstructorInfo
{
	private BytecodeClassInfo info;
	private BCMethodInfo minfo;

	public BytecodeConstructorInfo(BytecodeClassInfo info, BCMethodInfo minfo)
	{
		this.info=info;
		this.minfo=minfo;
	}

	public int getModifiers()
	{
		return minfo.getAccessFlags();
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
	public String getContructorSignature()
	{
		return null;
	}
}
