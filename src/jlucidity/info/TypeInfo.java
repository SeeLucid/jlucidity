package jlucidity.info;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * A superclass for storing information about Java language
 * structures.
 *
 * @see java.lang.reflect.Member
 */
public abstract class TypeInfo
{
	private static Map<String,String> infoTypes;

	static {
		infoTypes=new HashMap<String,String>();
		//"Class and member access modifiers."
		infoTypes.put("Modifiers","The type access modifiers.");
	}

	/**
	 * @see java.lang.reflect.Modifier
	 */
	public abstract int getModifiers();

	public abstract String toGenericString();

	/**
	 * Returns a {@link Map} that contains the types of information
	 * that this {@link TypeInfo} provides.
	 *
	 * <dl>
	 * <dt>Key</dt>
	 * 	<dd>Info type</dd>
	 * <dt>Value</dt>
	 * 	<dd>Metadata about info type</dd>
	 * </dl>
	 */
	public static Map<String,String> getInfoTypes()
	{
		return infoTypes;
	}

	/**
	 * Returns a {@link Map} that contains all of information in the
	 * {@link TypeInfo}.
	 */
	public final Map<String,Object> getInfo()
	{
		Set<String> iTypes=null;
		try{
			iTypes=((Map<String,String>)this.getClass().getMethod("getInfoTypes",new Class[0]).invoke(null)).keySet();
                        /*
			 * NOTE:
                         * not equivalent to :
                         * 	iTypes=this.getInfoTypes().keySet()
                         */
		}
		catch(ClassCastException e){e.printStackTrace();}
		catch(NoSuchMethodException e){e.printStackTrace();}
		catch(IllegalAccessException e){e.printStackTrace();}
		catch(java.lang.reflect.InvocationTargetException e){e.printStackTrace();}
		Map <String,Object> m=new HashMap<String,Object>();
		for(String s : iTypes)
			m.put(s,getInfo(s));
		return m;
	}

	/**
	 * @param infoType	the corresponding strings from the
	 * {@link Map} returned by {@link #getInfoTypes()}
	 *
	 * @return	an {@link Object} representing the information, or
	 * 		<code>null</code> if nonexistent.
	 */
	public Object getInfo(String infoType)
	{
		if(infoType.equals("Modifiers"))
				return getModifiers();
		return null;
	}
}
