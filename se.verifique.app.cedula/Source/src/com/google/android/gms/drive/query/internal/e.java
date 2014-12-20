package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Iterator;
import java.util.Set;

class e
{
  static a a(MetadataBundle paramMetadataBundle)
  {
    Set localSet = paramMetadataBundle.a();
    if (localSet.size() != 1)
      throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    return (a)localSet.iterator().next();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.e
 * JD-Core Version:    0.6.0
 */