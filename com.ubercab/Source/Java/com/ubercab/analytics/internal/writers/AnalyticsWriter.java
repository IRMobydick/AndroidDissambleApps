package com.ubercab.analytics.internal.writers;

import com.squareup.javawriter.JavaWriter;
import java.io.IOException;

public abstract interface AnalyticsWriter
{
  public abstract void emitStatements(JavaWriter paramJavaWriter)
    throws IOException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.analytics.internal.writers.AnalyticsWriter
 * JD-Core Version:    0.6.2
 */