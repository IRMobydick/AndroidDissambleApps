package com.ubercab.client.feature.employee.inject;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OnPreferenceChange
{
  public abstract int value();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employee.inject.OnPreferenceChange
 * JD-Core Version:    0.6.2
 */