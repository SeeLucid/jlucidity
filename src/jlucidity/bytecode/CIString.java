package jlucidity.bytecode;

import java.io.*;

/* CONSTANT_String                |         8 */
public class CIString extends ConstantInfo{
	/**************************/
	/* CONSTANT_String_info { */
	/*   u1 tag;              */
	public final static int tag=8;
	/*   u2 string_index;     */
	private int string_index;
	/* }                      */
	/**************************/

	public static ConstantInfo getItem(DataInputStream d) {
		ConstantInfo c=new CIString();
		try{c.readItem(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	public int readItem(DataInputStream d) throws IOException {
		int ret=3;
		string_index=d.readUnsignedShort();
		return ret;
	}

	public String toString(ConstantInfo pool[]){
		String t="";
		t+="type: "+super.toString(pool)+"; ";
		ConstantInfo strinfo=ConstantPoolReader.getIndex(pool,string_index);
		if(strinfo instanceof CIUtf8)
			t+="valr: "+((CIUtf8)strinfo).toString();
		return t;
	}
}
