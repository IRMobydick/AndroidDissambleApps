package com.ubercab.client.core.analytics.event;

import android.text.TextUtils;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.PingUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public final class NearestCabEvent extends AnalyticsEvent
{
  private static final String CONTEXT_PICKUP = "pickup";
  private static final String EVENT_NEAREST_CAB_REQUEST = "NearestCabRequest";
  private static final String FORMAT_VEHICLE_DATA = "%s:%s:%s";
  private static final String REASON_LOCATION_CHANGE = "locationChange";
  private static final String REASON_MOVE_PIN = "movePin";
  private static final String REASON_OPEN_APP = "openApp";
  private static final String REASON_PING = "ping";
  private static final String REASON_SNAPPED_LOCATION = "snappedLocation";
  private String mLastVehicleViewId;
  private List<String> mListVehicleViewData = new ArrayList();
  private List<String> mListVehicleViewIds = new ArrayList();
  private Map<String, NearbyVehicle> mNearbyVehicles = new HashMap();
  private Map<String, VehicleView> mVehicleViews = new HashMap();

  public NearestCabEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private String getVehicleDataString(String paramString)
  {
    VehicleView localVehicleView = (VehicleView)this.mVehicleViews.get(paramString);
    NearbyVehicle localNearbyVehicle = (NearbyVehicle)this.mNearbyVehicles.get(paramString);
    float f = 1.0F;
    if ((localVehicleView != null) && (localVehicleView.getSurge() != null))
      f = localVehicleView.getSurge().getMultiplier();
    if (localNearbyVehicle != null);
    for (int i = localNearbyVehicle.getMinEta(); ; i = 0)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Float.valueOf(f);
      arrayOfObject[2] = Integer.valueOf(i);
      return String.format("%s:%s:%s", arrayOfObject);
    }
  }

  private List<String> resetList(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramList.isEmpty())
      localArrayList.add(paramList.get(-1 + paramList.size()));
    return localArrayList;
  }

  private void sendNearestCabRequest(EventBuilder paramEventBuilder)
  {
    ArrayList localArrayList = new ArrayList(this.mListVehicleViewIds);
    String str = TextUtils.join(",", this.mListVehicleViewData);
    paramEventBuilder.setEventName("NearestCabRequest").putParameter("field", str).putParameter("vehicleViewIds", localArrayList);
    sendEvent(paramEventBuilder.build());
    this.mListVehicleViewIds = resetList(this.mListVehicleViewIds);
    this.mListVehicleViewData = resetList(this.mListVehicleViewData);
  }

  public void locationChangeRequest()
  {
    sendNearestCabRequest(new EventBuilder().putParameter("reason", "locationChange"));
  }

  public void movePinRequest()
  {
    sendNearestCabRequest(new EventBuilder().putParameter("reason", "movePin"));
  }

  public void openAppRequest()
  {
    sendNearestCabRequest(new EventBuilder().putParameter("reason", "openApp"));
  }

  public void ping()
  {
    sendNearestCabRequest(new EventBuilder().putParameter("reason", "ping"));
  }

  public void snappedLocationPickupRequest()
  {
    sendNearestCabRequest(new EventBuilder().putParameter("reason", "snappedLocation").putParameter("page", "pickup"));
  }

  public void trackVehicleViewId(String paramString)
  {
    if (paramString.equals(this.mLastVehicleViewId))
      return;
    this.mLastVehicleViewId = paramString;
    this.mListVehicleViewIds.add(paramString);
    this.mListVehicleViewData.add(getVehicleDataString(paramString));
  }

  public void updateVehicleDataFromPing(Ping paramPing)
  {
    if (PingUtils.hasCity(paramPing))
      this.mVehicleViews = paramPing.getCity().getVehicleViews();
    if (this.mVehicleViews == null)
      this.mVehicleViews = new HashMap();
    if (PingUtils.hasNearbyVehicles(paramPing));
    for (Object localObject = paramPing.getNearbyVehicles(); ; localObject = new HashMap())
    {
      this.mNearbyVehicles = ((Map)localObject);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.NearestCabEvent
 * JD-Core Version:    0.6.2
 */