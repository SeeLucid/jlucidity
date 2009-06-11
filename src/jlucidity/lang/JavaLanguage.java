package jlucidity.lang;

public class JavaLanguage
{
	public static boolean isIdentifier(String ident)
	{
		boolean b=true;
		/* Identifier must have at least one character. */
		if(ident.length()>0)
		{
			b=b&&Character.isJavaIdentifierStart(ident.charAt(0));
			for(int i=1;i<ident.length() && b;i++)
				b=b&&Character.isJavaIdentifierPart(ident.charAt(i));
		}
		else
			b=false;
		return b;
	}

	public static String getClassPart(String fqn)
	{
		int sep=fqn.lastIndexOf('.');
		// If there is not a separator (i.e. sep==-1), the entire FQN is returned.
		return new String(fqn.substring(sep+1));
	}

	public static String getPackagePart(String fqn)
	{
		int sep=fqn.lastIndexOf('.');
		if(sep==-1)
			return null;
		return new String(fqn.substring(0,sep));
	}

	public static String convertPathToFQN(String path)
	{
		return path.replaceFirst("\\.class$","").replaceAll("/",".");
	}
}
