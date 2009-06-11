package jlucidity.bytecode;

import java.io.*;

/* CONSTANT_NameAndType           |        12 */
public class CINameAndType extends ConstantInfo{
	/*******************************/
	/* CONSTANT_NameAndType_info { */
	/*   u1 tag;                   */
	public final static int tag=12;
	/*   u2 name_index;            */
	private int name_index;
	/*   u2 descriptor_index;      */
	private int descriptor_index;
	/* }                           */
	/*******************************/

	public static ConstantInfo getItem(DataInputStream d) {
		ConstantInfo c=new CINameAndType();
		try{c.readItem(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	public int readItem(DataInputStream d) throws IOException {
		int ret=9;
		name_index=d.readUnsignedShort();
		descriptor_index=d.readUnsignedShort();
		return ret;
	}

	public String toString(ConstantInfo pool[]){
		String t="";
		t+="type: "+super.toString(pool)+"; ";
		t+="name: "+getName(pool)+"; ";
		t+="desc: "+getDescriptor(pool);
		return t;
	}

	public String getName(ConstantInfo pool[]) {
		ConstantInfo ci=ConstantPoolReader.getIndex(pool,name_index);
		if(ci instanceof CIUtf8)
			return ((CIUtf8)ci).toString();
		return null;
	}

	public String getDescriptor(ConstantInfo pool[]) {
		ConstantInfo ci=ConstantPoolReader.getIndex(pool,descriptor_index);
		if(ci instanceof CIUtf8)
			return ((CIUtf8)ci).toString();
		return null;
	}
}
