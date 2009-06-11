package jlucidity.bytecode;

import java.io.*;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~*/
/* CONSTANT_Class                 |         7 */
public class CIClass extends ConstantInfo{
	/*************************/
	/* CONSTANT_Class_info { */
	/*   u1 tag;             */
	public final static int tag=7;
	/*   u2 name_index;      */
	private int name_index;
	/* }                     */
	/*************************/

	public static ConstantInfo getItem(DataInputStream d) {
		ConstantInfo c=new CIClass();
		try{c.readItem(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	public int readItem(DataInputStream d) throws IOException {
		int ret=3;
		name_index=d.readUnsignedShort();
		return ret;
	}

	public String toString(ConstantInfo pool[]){
		String t="";
		t+="type: "+super.toString(pool)+"; ";
		t+="name: "+getName(pool);
		return t;
	}

	public String getName(ConstantInfo pool[]) {
		ConstantInfo ci=ConstantPoolReader.getIndex(pool,name_index);
		if(ci instanceof CIUtf8)
			return ((CIUtf8)ci).toString();
		return null;
	}
}
