package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.a.a.j;
import java.util.Map;

public final class bu extends bw
{
  private Map a;

  private by b(String paramString)
  {
    Object localObject;
    try
    {
      Class localClass = Class.forName(paramString, false, bu.class.getClassLoader());
      if (com.google.a.a.b.class.isAssignableFrom(localClass))
      {
        com.google.a.a.b localb = (com.google.a.a.b)localClass.newInstance();
        localObject = new cj(localb, (j)this.a.get(localb.b()));
      }
      else if (com.google.android.gms.ads.c.b.class.isAssignableFrom(localClass))
      {
        localObject = new cg((com.google.android.gms.ads.c.b)localClass.newInstance());
      }
      else
      {
        hi.e("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
        throw new RemoteException();
      }
    }
    catch (Throwable localThrowable)
    {
      hi.e("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
    return (by)localObject;
  }

  public by a(String paramString)
  {
    return b(paramString);
  }

  public void a(Map paramMap)
  {
    this.a = paramMap;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bu
 * JD-Core Version:    0.6.0
 */