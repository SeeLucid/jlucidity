package jlucidity.bytecode;

import java.io.*;

/* field_info {                                         */
public class BCFieldInfo
{
	/************************************************/
	/* u2 access_flags;                             */
	private int access_flags;
	/* u2 name_index;                               */
	private int name_index;
	/* u2 descriptor_index;                         */
	private int descriptor_index;
	/* u2 attributes_count;                         */
	private int attributes_count;
	/* attribute_info attributes[attributes_count]; */
	private BCAttributeInfo attributes[];
	/************************************************/

	public int getAccessFlags()
	{
		return access_flags;
	}

	public String getName(ConstantInfo pool[])
	{
		return ((CIUtf8)ConstantPoolReader.getIndex(pool,name_index)).toString();
	}

	public String getDescriptor(ConstantInfo pool[])
	{
		return ((CIUtf8)ConstantPoolReader.getIndex(pool,descriptor_index)).toString();
	}

	public static BCFieldInfo getField(DataInputStream d) {
		BCFieldInfo c=new BCFieldInfo();
		try{c.readField(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	private int readField(DataInputStream d) throws IOException {
		int ret=8;
		access_flags=d.readUnsignedShort();
		name_index=d.readUnsignedShort();
		descriptor_index=d.readUnsignedShort();
		attributes_count=d.readUnsignedShort();
		BCAttributeInfo[] attributes=new BCAttributeInfo[attributes_count];
		for(int i=0;i<attributes_count;i++)
			attributes[i]=BCAttributeInfo.getAttribute(d);
		return ret;
	}

	public String toString(ConstantInfo pool[])
	{
		String t="";
		t+=java.lang.reflect.Modifier.toString(getAccessFlags())+" ";
		t+=getDescriptor(pool)+" ";
		t+=getName(pool);
		return t;
	}
}
/* }                                                    */
