package jlucidity.bytecode;

import java.io.*;

/* CONSTANT_Long                  |         5 */
public class CILong extends ConstantInfo{
	/************************/
	/* CONSTANT_Long_info { */
	/*   u1 tag;            */
	public final static int tag=5;
	/*   u4 high_bytes;     */
	private int high_bytes;
	/*   u4 low_bytes;      */
	private int low_bytes;
	/* }                    */
	/************************/

	public static ConstantInfo getItem(DataInputStream d) {
		ConstantInfo c=new CILong();
		try{c.readItem(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	public int readItem(DataInputStream d) throws IOException {
		int ret=9;
		high_bytes=d.readInt();
		low_bytes=d.readInt();
		return ret;
	}

	/* TODO check this */
	public String toString(ConstantInfo pool[]){
		String t="";
		t+="type: "+super.toString(pool)+"; ";
		t+="valu: "+(((long)high_bytes<<32)+low_bytes);
		return t;
	}
}
