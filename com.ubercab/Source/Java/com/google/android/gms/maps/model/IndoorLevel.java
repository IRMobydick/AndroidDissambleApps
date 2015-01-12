package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.maps.model.internal.e;

public final class IndoorLevel
{
  private final e ajX;

  public IndoorLevel(e parame)
  {
    this.ajX = ((e)o.i(parame));
  }

  public void activate()
  {
    try
    {
      this.ajX.activate();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IndoorLevel))
      return false;
    try
    {
      boolean bool = this.ajX.a(((IndoorLevel)paramObject).ajX);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public String getName()
  {
    try
    {
      String str = this.ajX.getName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public String getShortName()
  {
    try
    {
      String str = this.ajX.getShortName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public int hashCode()
  {
    try
    {
      int i = this.ajX.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.IndoorLevel
 * JD-Core Version:    0.6.2
 */