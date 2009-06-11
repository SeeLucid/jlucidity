package jlucidity.misc;

/**
 * Provides a single {@link java.lang.ClassLoader}
 * with the ability to convert bytecode into Class objects.
 */
public class AuxClassLoader extends ClassLoader
{
	private static AuxClassLoader instance;
	static{
		instance=new AuxClassLoader();
	}

	private AuxClassLoader(){};

	/**
	 * Converts bytecode in to a Class object, but avoid
	 * throwing a {@link java.lang.LinkageError}.
	 */
	public static Class bytecodetoClassForce(byte[] bytecode)
	{
		Class clazz=null;
		try{
			clazz=bytecodetoClass(bytecode);
		}catch(java.lang.LinkageError e){
			instance=new AuxClassLoader();
			clazz=bytecodetoClass(bytecode);
		}
		return clazz;
	}

	public static Class bytecodetoClass(byte[] bytecode)
	{
		return bytecodetoClass(null,bytecode);
	}

	/**
	 * @see java.lang.ClassLoader#defineClass(java.lang.String,byte[],int,int)
	 */
	public static Class bytecodetoClass(String binaryname, byte[] bytecode)
	{
		return instance.defineClass(binaryname,bytecode,0,bytecode.length);
	}
}
