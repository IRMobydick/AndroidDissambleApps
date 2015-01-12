package com.ubercab.geo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GeoManager
{
  private Integer mFakeGeo;
  private int mGeo = 0;
  private final GeoFetcher mGeoFetcher;
  GeoFetcher.Listener mGeoFetcherListener = new GeoFetcher.Listener()
  {
    public void onGeoLocationReceived(double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      if (GeoManager.this.mGeoRegion.isInRegion("china", paramAnonymousDouble1, paramAnonymousDouble2))
        GeoManager.access$102(GeoManager.this, 3);
      while (true)
      {
        GeoManager.this.mGeoRegion.recycle();
        GeoManager.this.notifyGeo(GeoManager.this.mGeo);
        return;
        if (GeoManager.this.mGeoRegion.isInRegion("india_approximate", paramAnonymousDouble1, paramAnonymousDouble2))
        {
          if (GeoManager.this.mGeoRegion.isInRegion("india", paramAnonymousDouble1, paramAnonymousDouble2))
            GeoManager.access$102(GeoManager.this, 4);
        }
        else
          GeoManager.access$102(GeoManager.this, 2);
      }
    }

    public void onGeoNoLocationReceived()
    {
      GeoManager.access$102(GeoManager.this, 1);
      GeoManager.this.notifyGeo(GeoManager.this.mGeo);
    }
  };
  private final GeoRegion mGeoRegion;
  private final List<Listener> mListeners = new CopyOnWriteArrayList();

  public GeoManager(GeoFetcher paramGeoFetcher, GeoRegion paramGeoRegion)
  {
    this.mGeoFetcher = paramGeoFetcher;
    this.mGeoRegion = paramGeoRegion;
  }

  private void notifyGeo(int paramInt)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onGeoDetermined(paramInt);
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  public void fetch()
  {
    if (this.mFakeGeo != null)
    {
      notifyGeo(this.mFakeGeo.intValue());
      return;
    }
    this.mGeoFetcher.setListener(this.mGeoFetcherListener);
    this.mGeoFetcher.connect();
  }

  public int getGeo()
  {
    if (this.mFakeGeo != null)
      return this.mFakeGeo.intValue();
    return this.mGeo;
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void setFakeGeo(int paramInt)
  {
    this.mFakeGeo = Integer.valueOf(paramInt);
  }

  public static abstract interface Listener
  {
    public abstract void onGeoDetermined(int paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.geo.GeoManager
 * JD-Core Version:    0.6.2
 */