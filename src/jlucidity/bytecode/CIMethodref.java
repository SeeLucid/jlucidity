package jlucidity.bytecode;

import java.io.*;

/* CONSTANT_Methodref             |        10 */
public class CIMethodref extends ConstantInfo{
	/*****************************/
	/* CONSTANT_Methodref_info { */
	/*   u1 tag;                 */
	public final static int tag=10;
	/*   u2 class_index;         */
	private int class_index;
	/*   u2 name_and_type_index; */
	private int name_and_type_index;
	/* }                         */
	/*****************************/

	public static ConstantInfo getItem(DataInputStream d) {
		ConstantInfo c=new CIMethodref();
		try{c.readItem(d);} catch(IOException e){e.printStackTrace();}
		return c;
	}

	public int readItem(DataInputStream d) throws IOException {
		int ret=5;
		class_index=d.readUnsignedShort();
		name_and_type_index=d.readUnsignedShort();
		return ret;
	}

	public String toString(ConstantInfo pool[]){
		String t="";
		t+="type: "+super.toString(pool)+"; ";
		ConstantInfo classi=ConstantPoolReader.getIndex(pool,class_index);
		if(classi instanceof CIClass)
			t+="declaration: "+((CIClass)classi).getName(pool)+"; ";
		ConstantInfo ntinfo=ConstantPoolReader.getIndex(pool,name_and_type_index);
		if(ntinfo instanceof CINameAndType)
			t+="ntinfo: "+"["+((CINameAndType)ntinfo).toString(pool)+"]";
		return t;
	}
}
