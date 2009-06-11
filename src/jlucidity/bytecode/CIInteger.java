package jlucidity.bytecode;

import java.io.*;

/* CONSTANT_Integer               |         3 */
public class CIInteger extends ConstantInfo{

	/***************************/
	/* CONSTANT_Integer_info { */
	/*   u1 tag;               */
	public final static int tag=3;
	/*   u4 bytes;             */
	private int bytes;
	/* }                       */
	/***************************/

	public static ConstantInfo getItem(DataInputStream d) {
		ConstantInfo c=new CIInteger();
		try{c.readItem(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	public int readItem(DataInputStream d) throws IOException {
		int ret=5;
		bytes=d.readInt();
		return ret;
	}

	public String toString(ConstantInfo pool[]){
		String t="";
		t+="type: "+super.toString(pool)+"; ";
		t+="valu: "+bytes;
		return t;
	}
}
