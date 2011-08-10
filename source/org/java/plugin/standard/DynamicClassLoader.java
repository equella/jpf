package org.java.plugin.standard;

public interface DynamicClassLoader
{
	Class<?> findClass(String name);
}
