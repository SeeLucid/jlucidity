package jlucidity.info;

import java.util.Map;
import java.util.HashMap;

/**
 * Abstract class for storing information about methods.
 *
 * @see java.lang.reflect.Method
 */
public abstract class MethodInfo extends TypeInfo
{
	private final static Map<String,String> infoTypes;

	static {
		infoTypes=new HashMap<String,String>();
		infoTypes.putAll(TypeInfo.getInfoTypes());
		infoTypes.put("Method signature","Signature of the method (access, return type, name, arguments).");
	}

	public static Map<String,String> getInfoTypes()
	{
		return infoTypes;
	}

	public abstract String getName();

	public abstract String getDescriptor();

	public abstract String getMethodSignature();

	public static class MethodDescriptor
	{
		public static String toGenericString(String desc)
		{
			String generic="(";

			String param=desc.substring(desc.indexOf('(')+1,desc.indexOf(')'));
			int i=0;
			boolean add=false;
			while(i<param.length())
			{
				if(add)
					generic+=", ";
				String found="";
				while(i<param.length() && param.charAt(i)=='[')
				{
					found+='[';
					i++;
				}

				if(param.charAt(i)=='L')
				{
					int j=param.indexOf(';',i);
					found+=param.substring(i,j+1);
					i=j;

				}
				else
					found+=param.charAt(i);
				generic+=FieldInfo.FieldDescriptor.toGenericString(found);
				i++;

				add=true;
			}
			generic+=')';

			if(desc.charAt(desc.indexOf(')')+1)=='V')
				generic+="void";
			else
				generic+=FieldInfo.FieldDescriptor.toGenericString(desc.substring(desc.indexOf(')')+1));

			return generic;

		}
	}
}
