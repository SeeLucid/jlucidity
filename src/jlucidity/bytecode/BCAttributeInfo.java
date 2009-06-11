package jlucidity.bytecode;

import java.io.*;

/* attribute_info {                   */
public class BCAttributeInfo
{
	/******************************/
	/* u2 attribute_name_index;   */
	private int attribute_name_index;
	/* u4 attribute_length;       */
	private int attribute_length;
	/* u1 info[attribute_length]; */
	private byte info[];
	/******************************/

	public static BCAttributeInfo getAttribute(DataInputStream d) {
		BCAttributeInfo c=new BCAttributeInfo();
		try{c.readAttribute(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	private int readAttribute(DataInputStream d) throws IOException {
		int ret=6;
		attribute_name_index=d.readUnsignedShort();
		attribute_length=d.readInt();
		ret+=attribute_length;
		info=new byte[attribute_length];
		for(int i=0;i<attribute_length;i++)
			info[i]=d.readByte();
		return ret;
	}

	public String toString(ConstantInfo pool[])
	{
		String t="";
		ConstantInfo ci=ConstantPoolReader.getIndex(pool,attribute_name_index);
		if(ci instanceof CIUtf8)
			t+=((CIUtf8)ci).toString();
		return t;
	}
}
/* }                                  */
