package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.maps.model.internal.b;

public final class Circle
{
  private final b ajF;

  public Circle(b paramb)
  {
    this.ajF = ((b)o.i(paramb));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Circle))
      return false;
    try
    {
      boolean bool = this.ajF.a(((Circle)paramObject).ajF);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public LatLng getCenter()
  {
    try
    {
      LatLng localLatLng = this.ajF.getCenter();
      return localLatLng;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public int getFillColor()
  {
    try
    {
      int i = this.ajF.getFillColor();
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
      String str = this.ajF.getId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public double getRadius()
  {
    try
    {
      double d = this.ajF.getRadius();
      return d;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public int getStrokeColor()
  {
    try
    {
      int i = this.ajF.getStrokeColor();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public float getStrokeWidth()
  {
    try
    {
      float f = this.ajF.getStrokeWidth();
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
      float f = this.ajF.getZIndex();
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
      int i = this.ajF.hashCodeRemote();
      return i;
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
      boolean bool = this.ajF.isVisible();
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
      this.ajF.remove();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setCenter(LatLng paramLatLng)
  {
    try
    {
      this.ajF.setCenter(paramLatLng);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setFillColor(int paramInt)
  {
    try
    {
      this.ajF.setFillColor(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setRadius(double paramDouble)
  {
    try
    {
      this.ajF.setRadius(paramDouble);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setStrokeColor(int paramInt)
  {
    try
    {
      this.ajF.setStrokeColor(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setStrokeWidth(float paramFloat)
  {
    try
    {
      this.ajF.setStrokeWidth(paramFloat);
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
      this.ajF.setVisible(paramBoolean);
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
      this.ajF.setZIndex(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Circle
 * JD-Core Version:    0.6.2
 */