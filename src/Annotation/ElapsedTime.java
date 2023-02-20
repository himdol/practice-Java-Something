package Annotation;

import java.awt.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={TYPE, METHOD})
public @interface ElapsedTime {
  long startTime = System.currentTimeMillis();
  long endTime = System.currentTimeMillis();
}
