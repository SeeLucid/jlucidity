package jlucidity.bytecode;

import java.io.*;

/* CONSTANT_Utf8                  |         1 */
public class CIUtf8 extends ConstantInfo{
	/************************/
	/* CONSTANT_Utf8_info { */
	/*   u1 tag;            */
	public final static int tag=1;
	/*   u2 length;         */
	private int length;
	/*   u1 bytes[length];  */
	private byte bytes[];
	/* }                    */
	/************************/

	String str;

	public static ConstantInfo getItem(DataInputStream d) {
		ConstantInfo c=new CIUtf8();
		try{c.readItem(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	public int readItem(DataInputStream d) throws IOException {
		int ret=3;
		length=d.readUnsignedShort();
		ret+=length;
		bytes=new byte[length];
		for(int i=0;i<length;i++)
			bytes[i]=d.readByte();
		return ret;
	}

	public String toString()
	{
		if(str==null)
			try{
			str=new String(bytes,"UTF-8");
			}catch (UnsupportedEncodingException e){}
		return str;
	}

	public String toString(ConstantInfo pool[]){
		String t="";
		t+="type: "+super.toString(pool)+"; ";
		t+="str : "+toString();
		return t;
	}
}
