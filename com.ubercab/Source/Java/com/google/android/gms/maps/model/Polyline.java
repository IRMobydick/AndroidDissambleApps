package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import java.util.List;

public final class Polyline
{
  private final IPolylineDelegate ako;

  public Polyline(IPolylineDelegate paramIPolylineDelegate)
  {
    this.ako = ((IPolylineDelegate)o.i(paramIPolylineDelegate));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Polyline))
      return false;
    try
    {
      boolean bool = this.ako.equalsRemote(((Polyline)paramObject).ako);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public int getColor()
  {
    try
    {
      int i = this.ako.getColor();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public String getId()
  {
    try
    {
      String str = this.ako.getId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public List<LatLng> getPoints()
  {
    try
    {
      List localList = this.ako.getPoints();
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public float getWidth()
  {
    try
    {
      float f = this.ako.getWidth();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public float getZIndex()
  {
    try
    {
      float f = this.ako.getZIndex();
      return f;
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
      int i = this.ako.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public boolean isGeodesic()
  {
    try
    {
      boolean bool = this.ako.isGeodesic();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public boolean isVisible()
  {
    try
    {
      boolean bool = this.ako.isVisible();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void remove()
  {
    try
    {
      this.ako.remove();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setColor(int paramInt)
  {
    try
    {
      this.ako.setColor(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setGeodesic(boolean paramBoolean)
  {
    try
    {
      this.ako.setGeodesic(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setPoints(List<LatLng> paramList)
  {
    try
    {
      this.ako.setPoints(paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setVisible(boolean paramBoolean)
  {
    try
    {
      this.ako.setVisible(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setWidth(float paramFloat)
  {
    try
    {
      this.ako.setWidth(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setZIndex(float paramFloat)
  {
    try
    {
      this.ako.setZIndex(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Polyline
 * JD-Core Version:    0.6.2
 */