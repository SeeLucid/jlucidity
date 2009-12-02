package jlucidity.source.bytecode;

import jlucidity.info.MethodInfo;

public class BytecodeMethodInfo extends MethodInfo
{
	private BytecodeClassSource source;
	private BytecodeClassInfo info;
	private BCMethodInfo finfo;

	public BytecodeMethodInfo(BytecodeClassSource source, BytecodeClassInfo info, BCFieldInfo finfo)
	{
		this.source=source;
		this.info=info;
		this.finfo=finfo;
	}
	public int getModifiers()
	{
		return -1;
	}

	public String toGenericString()
	{
		return null;
	}

	public String getMethodSignature()
	{
		return null;
	}
}
