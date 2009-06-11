package jlucidity.bytecode;

import java.io.*;

/* CONSTANT_Float                 |         4 */
public class CIFloat extends ConstantInfo{
	/*************************/
	/* CONSTANT_Float_info { */
	/*   u1 tag;             */
	public final static int tag=4;
	/*   u4 bytes;           */
	private int bytes;
	/* }                     */
	/*************************/

	public static ConstantInfo getItem(DataInputStream d) {
		ConstantInfo c=new CIFloat();
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
		t+="valu: "+Float.intBitsToFloat(bytes);
		return t;
	}
}
