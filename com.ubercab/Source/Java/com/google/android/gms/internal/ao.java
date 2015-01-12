package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class ao
{
  private static MessageDigest nI = null;
  protected Object mw = new Object();

  protected MessageDigest ba()
  {
    while (true)
    {
      int i;
      synchronized (this.mw)
      {
        if (nI != null)
        {
          MessageDigest localMessageDigest2 = nI;
          return localMessageDigest2;
        }
        i = 0;
        if (i >= 2);
      }
      try
      {
        nI = MessageDigest.getInstance("MD5");
        label38: i++;
        continue;
        MessageDigest localMessageDigest1 = nI;
        return localMessageDigest1;
        localObject2 = finally;
        throw localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        break label38;
      }
    }
  }

  abstract byte[] l(String paramString);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ao
 * JD-Core Version:    0.6.2
 */