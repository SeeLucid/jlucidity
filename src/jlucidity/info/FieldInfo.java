package jlucidity.info;

/**
 * Abstract class for storing information about fields.
 *
 * @see java.lang.reflect.Field
 */
public abstract class FieldInfo extends TypeInfo
{
	public abstract String getFieldDeclaration();

	public static class FieldDescriptor
	{
		public static String toGenericString(String desc)
		{
			String generic="";

			int arr=0;
			int i=0;
			while(i<desc.length() && desc.charAt(i)=='[')
			{
				arr++;
				i++;
			}

			switch(desc.charAt(i))
			{
				case 'B':
					generic+="byte";
				//B	byte 	signed byte
					break;
				case 'C':
					generic+="char";
				//C 	char 	Unicode character
					break;
				case 'D':
					generic+="double";
				//D 	double 	double-precision floating-point value
					break;
				case 'F':
					generic+="float";
				//F 	float 	single-precision floating-point value
					break;
				case 'I':
					generic+="int";
				//I 	int 	integer
					break;
				case 'J':
					generic+="long";
				//J 	long 	long integer
					break;
				case 'L':
					generic+=desc.substring(i+1,desc.indexOf(";",i)).replaceAll("/",".");
				//L<classname>; 	reference 	an instance of class <classname>
					break;
				case 'S':
					generic+="short";
				//S 	short 	signed short
					break;
				case 'Z':
					generic+="boolean";
				//Z 	boolean 	true or false
					break;
			}

			/*if(arr>0)
				generic+=" ";*/
			for(int j=0;j<arr;j++)
				generic+="[]";
			return generic;
		}
	}
}
