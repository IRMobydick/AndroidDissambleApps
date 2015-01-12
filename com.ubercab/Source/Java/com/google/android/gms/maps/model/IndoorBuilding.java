package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.maps.model.internal.d;
import com.google.android.gms.maps.model.internal.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class IndoorBuilding
{
  private final d ajW;

  public IndoorBuilding(d paramd)
  {
    this.ajW = ((d)o.i(paramd));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IndoorBuilding))
      return false;
    try
    {
      boolean bool = this.ajW.b(((IndoorBuilding)paramObject).ajW);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public int getActiveLevelIndex()
  {
    try
    {
      int i = this.ajW.getActiveLevelIndex();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public int getDefaultLevelIndex()
  {
    try
    {
      int i = this.ajW.getActiveLevelIndex();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public List<IndoorLevel> getLevels()
  {
    ArrayList localArrayList;
    try
    {
      List localList = this.ajW.getLevels();
      localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(new IndoorLevel(e.a.bt((IBinder)localIterator.next())));
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    return localArrayList;
  }

  public int hashCode()
  {
    try
    {
      int i = this.ajW.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public boolean isUnderground()
  {
    try
    {
      boolean bool = this.ajW.isUnderground();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.IndoorBuilding
 * JD-Core Version:    0.6.2
 */