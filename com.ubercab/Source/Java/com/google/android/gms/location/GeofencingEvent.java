package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.mc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent
{
  private final int aep;
  private final List<Geofence> aeq;
  private final Location aer;
  private final int tc;

  private GeofencingEvent(int paramInt1, int paramInt2, List<Geofence> paramList, Location paramLocation)
  {
    this.tc = paramInt1;
    this.aep = paramInt2;
    this.aeq = paramList;
    this.aer = paramLocation;
  }

  public static GeofencingEvent fromIntent(Intent paramIntent)
  {
    if (paramIntent == null)
      return null;
    return new GeofencingEvent(paramIntent.getIntExtra("gms_error_code", -1), getGeofenceTransition(paramIntent), getTriggeringGeofences(paramIntent), (Location)paramIntent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
  }

  private static int getGeofenceTransition(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
    if (i == -1);
    while ((i != 1) && (i != 2) && (i != 4))
      return -1;
    return i;
  }

  private static List<Geofence> getTriggeringGeofences(Intent paramIntent)
  {
    ArrayList localArrayList1 = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
    if (localArrayList1 == null)
      return null;
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
      localArrayList2.add(mc.h((byte[])localIterator.next()));
    return localArrayList2;
  }

  public int getErrorCode()
  {
    return this.tc;
  }

  public int getGeofenceTransition()
  {
    return this.aep;
  }

  public List<Geofence> getTriggeringGeofences()
  {
    return this.aeq;
  }

  public Location getTriggeringLocation()
  {
    return this.aer;
  }

  public boolean hasError()
  {
    return this.tc != -1;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.GeofencingEvent
 * JD-Core Version:    0.6.2
 */