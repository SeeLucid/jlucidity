package jlucidity.misc;

import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class IOUtils
{
	private IOUtils() {}

	/**
	 * Returns the <code>InputStream</code> as a byte array.
	 *
	 * @param in		the InputStream to read from
	 * @param length	the length of data to read, if <code>length &lt; 0 </code>
	 * 			the length is unlimited
	 */
	public static byte[] getStreamAsByteArray(InputStream in, int length) throws IOException
	{
		if(length==0) return new byte[0];	// empty array
		boolean limited=true;
		if(length<0)
		{
			length=Integer.MAX_VALUE;
			limited=false;
		}
		ByteArrayOutputStream byteOut=new ByteArrayOutputStream();
		do{
			int next=in.read();
			if(next==-1) break;
			byteOut.write(next);
			if(limited) length--;
		}while(length>=0);

		return byteOut.toByteArray();
	}

	/**
	 * Returns all of the <code>InputStream</code> as a byte array.
	 * Equivalent to: <code>getStreamAsByteArray(in,-1)</code>
	 *
	 * @see #getStreamAsByteArray(InputStream,int)
	 */
	public static byte[] getStreamAsByteArray(InputStream in) throws IOException
	{
		return getStreamAsByteArray(in,-1);
	}
}
