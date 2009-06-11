package jlucidity.bytecode;

import java.io.*;

public class ClassReader
{
	DataInputStream dstrm;
	boolean read;

	public ClassReader(InputStream in) throws IOException
	{
		dstrm=new DataInputStream(in);
		read(dstrm);
	}

	private void read(DataInputStream dstrm) throws IOException /*{{{*/
	{
		readMagic(dstrm);
		readMinorVersion(dstrm);
		readMajorVersion(dstrm);
		readConstant_Pool_Count(dstrm);
		readConstantPool(dstrm);
		readAccessFlags(dstrm);
		readThisClass(dstrm);
		readSuperClass(dstrm);
		readInterfacesCount(dstrm);
		readInterfaces(dstrm);
		readFieldsCount(dstrm);
		readFields(dstrm);
		readMethodsCount(dstrm);
		readMethods(dstrm);
		readAttributesCount(dstrm);
		readAttributes(dstrm);
	} /*}}}*/

	public String toString() /*{{{*/
	{
		String s="";
		s+="Magic: "+"0x"+Integer.toHexString(this.getMagic()).toUpperCase()+'\n';
		//s+="Minor ver: "+this.getMinorVersion()+'\n';
		//s+="Major ver: "+this.getMajorVersion()+'\n';
		s+="Version: "+this.getMajorVersion()+"."+this.getMinorVersion()+'\n';
		s+="Constant pool count: "+this.getConstant_Pool_Count()+'\n';
		s+="****BEGIN CONSTANT POOL TABLE****"+'\n';
		for(int i=0;i<this.getConstantPool().length;i++)
			s+=""+(i+1)+": "+this.getConstantPool()[i].toString(this.getConstantPool())+'\n';
		s+="****END CONSTANT POOL TABLE****"+'\n';
		s+='\n';
		s+="This class: "+java.lang.reflect.Modifier.toString(this.getAccessFlags())+" "+((CIClass)ConstantPoolReader.getIndex(this.getConstantPool(),this.getThisClass())).getName(this.getConstantPool())+" "+(java.lang.reflect.Modifier.isInterface(this.getAccessFlags())?"implements":"extends")+" "+this.getSuperClass()+'\n';
		s+="Direct superinterfaces: "+'\n';
		for(int i=0;i<this.getInterfacesCount();i++)
			s+="\t"+((CIClass)ConstantPoolReader.getIndex(this.getConstantPool(),this.getInterfaces()[i])).getName(this.getConstantPool())+'\n';
		if(this.getInterfacesCount()==0)
			s+="\tnone"+'\n';
		s+="Fields:"+'\n';
		for(int i=0;i<this.getFieldsCount();i++){
			s+="\t"+this.getFields()[i].toString(this.getConstantPool())+'\n';
		}
		s+="Methods:"+'\n';
		for(int i=0;i<this.getMethodsCount();i++){
			s+="\t"+this.getMethods()[i].toString(this.getConstantPool())+'\n';
		}
		return s;
	} /*}}}*/

	/* ClassFile {                                           */ /*{{{*/
	/*         u4 magic;                                     */ /*{{{*/
	private int magic;
	private int readMagic(DataInputStream dstrm) throws IOException
	{
		int ret=4;
		magic=dstrm.readInt();
		return ret;
	}
	public int getMagic()
	{
		return magic;
	}
	/*}}}*/
	/*         u2 minor_version;                             */ /*{{{*/
	private int minor_version;
	private int readMinorVersion(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		minor_version=dstrm.readUnsignedShort();
		return ret;
	}
	public int getMinorVersion()
	{
		return minor_version;
	}
	/*}}}*/
	/*         u2 major_version;                             */ /*{{{*/
	private int major_version;
	private int readMajorVersion(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		major_version=dstrm.readUnsignedShort();
		return ret;
	}
	public int getMajorVersion()
	{
		return major_version;
	}
	/*}}}*/
	/*         u2 constant_pool_count;                       */ /*{{{*/
	private int constant_pool_count;
	private int readConstant_Pool_Count(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		constant_pool_count=dstrm.readUnsignedShort();
		return ret;
	}
	public int getConstant_Pool_Count()
	{
		return constant_pool_count;
	}
	/*}}}*/
	/*         cp_info constant_pool[constant_pool_count-1]; */ /*{{{*/
	/* c.f. ConstantPoolReader */
	/* TODO */
	private ConstantInfo[] pool;
	private int readConstantPool(DataInputStream dstrm) throws IOException
	{
		pool=new ConstantInfo[constant_pool_count-1];
		for(int i=0;i<pool.length;i++)
		{
			ConstantInfo ci=ConstantPoolReader.getItem(dstrm);
			//System.out.println(ci);
			pool[i]=ci;
			if(ci instanceof CILong || ci instanceof CIDouble) // skip one
				i++;
		}
		return constant_pool_count;
	}
	public ConstantInfo[] getConstantPool()
	{
		return pool;
	}
	/*}}}*/
	/*         u2 access_flags;                              */ /*{{{*/
	private int access_flags;
	private int readAccessFlags(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		access_flags=dstrm.readUnsignedShort();
		return ret;
	}
	public int getAccessFlags()
	{
		return access_flags;
	}
	/*}}}*/
	/*         u2 this_class;                                */ /*{{{*/
	private int this_class;
	private int readThisClass(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		this_class=dstrm.readUnsignedShort();
		return ret;
	}
	public int getThisClass()
	{
		return this_class;
	}
	/*}}}*/
	/*         u2 super_class;                               */ /*{{{*/
	private int super_class;
	private int readSuperClass(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		super_class=dstrm.readUnsignedShort();
		return ret;
	}

	public String getSuperClass()
	{
		if(super_class==0)
			return "java/lang/Object";
		return ((CIClass)ConstantPoolReader.getIndex(pool,super_class)).getName(pool);
	}
	/*}}}*/
	/*         u2 interfaces_count;                          */ /*{{{*/
	private int interfaces_count;
	private int readInterfacesCount(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		interfaces_count=dstrm.readUnsignedShort();
		return ret;
	}
	public int getInterfacesCount()
	{
		return interfaces_count;
	}
	/*}}}*/
	/*         u2 interfaces[interfaces_count];              */ /*{{{*/
	private int[] interfaces;
	private int readInterfaces(DataInputStream dstrm) throws IOException
	{
		interfaces=new int[interfaces_count];
		for(int i=0;i<interfaces_count;i++)
			interfaces[i]=dstrm.readUnsignedShort();
		return interfaces_count;
	}
	public int[] getInterfaces()
	{
		return interfaces;
	}
	/*}}}*/
	/*         u2 fields_count;                              */ /*{{{*/
	private int fields_count;
	private int readFieldsCount(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		fields_count=dstrm.readUnsignedShort();
		return ret;
	}
	public int getFieldsCount()
	{
		return fields_count;
	}
	/*}}}*/
	/*         field_info fields[fields_count];              */ /*{{{*/
	private BCFieldInfo fields[];
	private int readFields(DataInputStream dstrm) throws IOException
	{
		fields=new BCFieldInfo[fields_count];
		for(int i=0;i<fields_count;i++)
			fields[i]=BCFieldInfo.getField(dstrm);
		return fields_count;
	}
	public BCFieldInfo[] getFields()
	{
		return fields;
	}
	/*}}}*/
	/*         u2 methods_count;                             */ /*{{{*/
	private int methods_count;
	private int readMethodsCount(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		methods_count=dstrm.readUnsignedShort();
		return ret;
	}
	public int getMethodsCount()
	{
		return methods_count;
	}
	/*}}}*/
	/*         method_info methods[methods_count];           */ /*{{{*/
	private BCMethodInfo methods[];
	private int readMethods(DataInputStream dstrm) throws IOException
	{
		methods=new BCMethodInfo[methods_count];
		for(int i=0;i<methods_count;i++)
			methods[i]=BCMethodInfo.getMethod(dstrm);
		return methods_count;
	}
	public BCMethodInfo[] getMethods()
	{
		return methods;
	}
	/*}}}*/
	/*         u2 attributes_count;                          */ /*{{{*/
	private int attributes_count;
	private int readAttributesCount(DataInputStream dstrm) throws IOException
	{
		int ret=2;
		attributes_count=dstrm.readUnsignedShort();
		return ret;
	}
	public int getAttributesCount()
	{
		return attributes_count;
	}
	/*}}}*/
	/*         attribute_info attributes[attributes_count];  */ /*{{{*/
	private BCAttributeInfo attributes[];
	private int readAttributes(DataInputStream dstrm) throws IOException
	{
		attributes=new BCAttributeInfo[attributes_count];
		for(int i=0;i<attributes_count;i++)
			attributes[i]=BCAttributeInfo.getAttribute(dstrm);
		return attributes_count;
	}
	public BCAttributeInfo[] getAttributes()
	{
		return attributes;
	}
	/*}}}*/
	/* }                                                     */ /*}}}*/
}

// vim:fdm=marker
