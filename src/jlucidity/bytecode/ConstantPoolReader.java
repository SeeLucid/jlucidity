package jlucidity.bytecode;

import java.io.*;
import java.util.*;

public class ConstantPoolReader
{
	public static Map<Integer,ConstantInfo> types;
	static{
		types=new HashMap<Integer,ConstantInfo>();
		types.put(7 ,new CIClass             ());
		types.put(9 ,new CIFieldref          ());
		types.put(10,new CIMethodref         ());
		types.put(11,new CIInterfaceMethodref());
		types.put(8 ,new CIString            ());
		types.put(3 ,new CIInteger           ());
		types.put(4 ,new CIFloat             ());
		types.put(5 ,new CILong              ());
		types.put(6 ,new CIDouble            ());
		types.put(12,new CINameAndType       ());
		types.put(1 ,new CIUtf8              ());
	}

	public static ConstantInfo getItem(DataInputStream ds)
	{
		try{
			int tag=ds.readUnsignedByte();
			//System.out.println(tag);
			ConstantInfo ci=null;
			try{
				ConstantInfo type=types.get(tag);
				ci=((ConstantInfo)type.getClass().getDeclaredMethod("getItem",new Class[]{DataInputStream.class}).invoke(null,ds));
				// types.get(tag).getItem(ds);
			}
			catch(ClassCastException e){e.printStackTrace();}
			catch(NoSuchMethodException e){e.printStackTrace();}
			catch(IllegalAccessException e){e.printStackTrace();}
			catch(java.lang.reflect.InvocationTargetException e){e.printStackTrace();}

			return ci;
		}catch(IOException e){e.printStackTrace();}
		return null;
	}

	public static ConstantInfo getIndex(ConstantInfo[] pool,int index)
	{
		int realindex=index-1;
		if(realindex>=0 && realindex<pool.length)
		{
			// if it is CONSTANT_Long or
			// CONSTANT_Double, then it will be null
			// anyway
			return pool[realindex];
		}
		return null;
	}

}
