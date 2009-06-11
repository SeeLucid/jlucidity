package jlucidity.source;

import jlucidity.info.*;

import java.util.Set;

/**
 * Interface for getting class information.
 * A ClassSource is an object that retrieves
 * classes from a location and get information
 * about the classes from that source.
 */
public interface ClassSource
{
	/**
	 * Returns the name of the source.
	 */
	public String getSourceName();

	/**
	 * Returns string describing the source.
	 */
	public String getSourceDescription();

	/**
	 * Returns a Set of ClassName's found in in the source.
	 */
	public Set<ClassName> getClassNames();

	/**
	 * Returns a Set of ClassName's that are in a certain
	 * package.
	 *
	 * This method may return more than the actual number of
	 * classes in the source. This extra data could be guesses
	 * that will be verified when
	 * {@link #getClassInfo(ClassName)} is called.
	 *
	 * @param packageName the name of the package to look under
	 */
	public Set<ClassName> getClassNames(PackageName packageName);

	/**
	 * Get the ClassInfo for a requested ClassName.
	 *
	 * @param className the name of the class being requested
	 *
	 * @throws java.lang.UnsupportedOperationException
	 * 		if the class name can not be retrieved.
	 */
	public ClassInfo getClassInfo(ClassName className);

	/**
	 * Returns a Set of PackageName's found in in the source.
	 */
	public Set<PackageName> getPackages();

	/**
	 * Remaps the ClassSource so that it is up-to-date with
	 * whatever it represents.
	 *
	 * @throws java.lang.UnsupportedOperationException
	 * 		if the remap() can not be done.
	 */
	public void remap() throws UnsupportedOperationException;

	/**
	 * Map the available classes
	 */
	public void map();
}
