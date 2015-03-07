package net.pocketbukkit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
public @interface Unsupported{
	int[] value();
}
