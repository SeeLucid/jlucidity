package jlucidity.bytecode;

import java.io.*;

/**********************************************/
/* Constant Type                  |Value      */
public class ConstantInfo{
	public int readItem(DataInputStream d) throws IOException {return 0;}
	public static ConstantInfo getItem(DataInputStream d) {return null;}
	public String toString(ConstantInfo pool[]){return this.getClass().toString();}
}
