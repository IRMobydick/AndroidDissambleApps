package com.baidu.mapapi.search.route;

import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static TransitRouteResult a(String paramString)
  {
    TransitRouteResult localTransitRouteResult = new TransitRouteResult();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      localTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localTransitRouteResult;
    }
    JSONArray localJSONArray1;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1.optJSONObject("taxi") != null)
        localTransitRouteResult.a(d(localJSONObject1.optString("taxi")));
      localJSONArray1 = localJSONObject1.optJSONArray("routes");
      if ((localJSONArray1 == null) || (localJSONArray1.length() <= 0))
      {
        localTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localTransitRouteResult;
      }
    }
    catch (JSONException localJSONException)
    {
      localTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      localJSONException.printStackTrace();
      return localTransitRouteResult;
    }
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < localJSONArray1.length())
    {
      JSONObject localJSONObject2 = ((JSONObject)localJSONArray1.opt(i)).optJSONObject("legs");
      if (localJSONObject2 == null);
      while (true)
      {
        i++;
        break;
        TransitRouteLine localTransitRouteLine = new TransitRouteLine();
        localTransitRouteLine.setDistance(localJSONObject2.optInt("distance"));
        localTransitRouteLine.setDuration(localJSONObject2.optInt("time"));
        localTransitRouteLine.setStarting(RouteNode.location(com.baidu.mapapi.model.a.a(localJSONObject2.optString("start_geo"))));
        localTransitRouteLine.setTerminal(RouteNode.location(com.baidu.mapapi.model.a.a(localJSONObject2.optString("end_geo"))));
        JSONArray localJSONArray2 = localJSONObject2.optJSONArray("steps");
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
        {
          ArrayList localArrayList2 = new ArrayList();
          int j = 0;
          while (j < localJSONArray2.length())
          {
            JSONArray localJSONArray3 = localJSONArray2.optJSONObject(j).optJSONArray("busline");
            if ((localJSONArray3 == null) || (localJSONArray3.length() <= 0))
            {
              j++;
            }
            else
            {
              JSONObject localJSONObject3 = localJSONArray3.optJSONObject(0);
              TransitRouteLine.TransitStep localTransitStep = new TransitRouteLine.TransitStep();
              localTransitStep.a(RouteNode.location(com.baidu.mapapi.model.a.a(localJSONObject3.optString("start_location"))));
              localTransitStep.b(RouteNode.location(com.baidu.mapapi.model.a.a(localJSONObject3.optString("end_location"))));
              if (localJSONObject3.optInt("type") == 5)
              {
                localTransitStep.a(TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING);
                label368: localTransitStep.a(g(localJSONObject3.optString("instructions")));
                localTransitStep.setDistance(localJSONObject3.optInt("distance"));
                localTransitStep.setDuration(localJSONObject3.optInt("duration"));
                localTransitStep.b(localJSONObject3.optString("path_geo"));
                if (localJSONObject3.has("vehicle"))
                {
                  localTransitStep.a(e(localJSONObject3.optString("vehicle")));
                  JSONObject localJSONObject4 = localJSONObject3.optJSONObject("vehicle");
                  localTransitStep.getEntrace().setUid(localJSONObject4.optString("start_uid"));
                  localTransitStep.getEntrace().setTitle(localJSONObject4.optString("start_name"));
                  localTransitStep.getExit().setUid(localJSONObject4.optString("end_uid"));
                  localTransitStep.getExit().setTitle(localJSONObject4.optString("end_name"));
                  Integer localInteger = Integer.valueOf(localJSONObject4.optInt("type"));
                  if (localInteger == null)
                    break label582;
                  if (localInteger.intValue() != 1)
                    break label571;
                  localTransitStep.a(TransitRouteLine.TransitStep.TransitRouteStepType.SUBWAY);
                }
              }
              while (true)
              {
                localArrayList2.add(localTransitStep);
                break;
                localTransitStep.a(TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING);
                break label368;
                label571: localTransitStep.a(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                continue;
                label582: localTransitStep.a(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
              }
            }
          }
          localTransitRouteLine.setSteps(localArrayList2);
          localArrayList1.add(localTransitRouteLine);
        }
      }
    }
    localTransitRouteResult.a(localArrayList1);
    return localTransitRouteResult;
  }

  public static List<CityInfo> a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || (paramString.equals("")));
    JSONArray localJSONArray;
    do
    {
      return null;
      localJSONArray = paramJSONObject.optJSONArray(paramString);
    }
    while ((localJSONArray == null) || (localJSONArray.length() <= 0));
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < localJSONArray.length(); i++)
    {
      JSONObject localJSONObject = (JSONObject)localJSONArray.opt(i);
      CityInfo localCityInfo = new CityInfo();
      localCityInfo.num = localJSONObject.optInt("num");
      localCityInfo.city = localJSONObject.optString("name");
      localArrayList.add(localCityInfo);
    }
    localArrayList.trimToSize();
    return localArrayList;
  }

  private static List<PoiInfo> a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject == null) || (paramString1 == null) || ("".equals(paramString1)))
      return null;
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString1);
    if (localJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = (JSONObject)localJSONArray.opt(i);
        PoiInfo localPoiInfo = new PoiInfo();
        PlanNode.withCityNameAndPlaceName(paramString2, localJSONObject.optString("name"));
        localPoiInfo.address = localJSONObject.optString("addr");
        localPoiInfo.uid = localJSONObject.optString("uid");
        localPoiInfo.name = localJSONObject.optString("name");
        localPoiInfo.location = com.baidu.mapapi.model.a.a(localJSONObject.optString("geo"));
        localPoiInfo.city = paramString2;
        localArrayList.add(localPoiInfo);
      }
      if (localArrayList.size() > 0)
        return localArrayList;
    }
    return null;
  }

  private static RouteNode b(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString)))
      return null;
    JSONObject localJSONObject = paramJSONObject.optJSONObject(paramString);
    RouteNode localRouteNode = new RouteNode();
    localRouteNode.setTitle(localJSONObject.optString("name"));
    localRouteNode.setLocation(com.baidu.mapapi.model.a.a(localJSONObject.optString("geo")));
    return localRouteNode;
  }

  public static DrivingRouteResult b(String paramString)
  {
    int i = 0;
    DrivingRouteResult localDrivingRouteResult = new DrivingRouteResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localDrivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localDrivingRouteResult;
    }
    DrivingRouteLine localDrivingRouteLine;
    JSONObject localJSONObject2;
    while (true)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        if (localJSONObject1.has("taxi"))
          localDrivingRouteResult.a(d(localJSONObject1.optString("taxi")));
        localDrivingRouteLine = new DrivingRouteLine();
        if (localJSONObject1.optInt("avoid_jam") != 0)
        {
          bool = true;
          localDrivingRouteLine.a(bool);
          localDrivingRouteLine.setStarting(b(localJSONObject1, "start_point"));
          localDrivingRouteLine.setTerminal(b(localJSONObject1, "end_point"));
          localDrivingRouteLine.a(c(localJSONObject1, "waypoints"));
          localJSONObject2 = localJSONObject1.optJSONObject("routes");
          if (localJSONObject2 != null)
            break;
          return localDrivingRouteResult;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localDrivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localDrivingRouteResult;
      }
      boolean bool = false;
    }
    JSONObject localJSONObject3 = localJSONObject2.optJSONObject("legs");
    if (localJSONObject3 == null)
      return localDrivingRouteResult;
    localDrivingRouteLine.setDistance(localJSONObject3.optInt("distance"));
    localDrivingRouteLine.setDuration(localJSONObject3.optInt("duration"));
    JSONArray localJSONArray = localJSONObject3.optJSONArray("steps");
    if (localJSONArray != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      if (i < localJSONArray.length())
      {
        DrivingRouteLine.DrivingStep localDrivingStep = new DrivingRouteLine.DrivingStep();
        JSONObject localJSONObject4 = localJSONArray.optJSONObject(i);
        if (localJSONObject4 == null);
        while (true)
        {
          i++;
          break;
          localDrivingStep.a(30 * localJSONObject4.optInt("direction"));
          localDrivingStep.setDistance(localJSONObject4.optInt("distance"));
          localDrivingStep.setDuration(localJSONObject4.optInt("duration"));
          localDrivingStep.a(RouteNode.location(com.baidu.mapapi.model.a.a(localJSONObject4.optString("start_loc"))));
          localDrivingStep.b(RouteNode.location(com.baidu.mapapi.model.a.a(localJSONObject4.optString("end_loc"))));
          localDrivingStep.d(g(localJSONObject4.optString("description")));
          localDrivingStep.b(g(localJSONObject4.optString("start_desc")));
          localDrivingStep.c(g(localJSONObject4.optString("end_desc")));
          localDrivingStep.b(localJSONObject4.optInt("turn"));
          localDrivingStep.a(localJSONObject4.optString("path"));
          localArrayList1.add(localDrivingStep);
        }
      }
      if (localArrayList1.size() > 0)
        localDrivingRouteLine.setSteps(localArrayList1);
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localDrivingRouteLine);
    localDrivingRouteResult.a(localArrayList2);
    return localDrivingRouteResult;
  }

  public static WalkingRouteResult c(String paramString)
  {
    WalkingRouteResult localWalkingRouteResult = new WalkingRouteResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localWalkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localWalkingRouteResult;
    }
    WalkingRouteLine localWalkingRouteLine;
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1.has("taxi"))
        localWalkingRouteResult.a(d(localJSONObject1.optString("taxi")));
      localWalkingRouteLine = new WalkingRouteLine();
      localWalkingRouteLine.setStarting(b(localJSONObject1, "start_point"));
      localWalkingRouteLine.setTerminal(b(localJSONObject1, "end_point"));
      localJSONObject2 = localJSONObject1.optJSONObject("routes");
      if (localJSONObject2 == null)
        return localWalkingRouteResult;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localWalkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localWalkingRouteResult;
    }
    JSONObject localJSONObject3 = localJSONObject2.optJSONObject("legs");
    if (localJSONObject3 == null)
      return localWalkingRouteResult;
    localWalkingRouteLine.setDistance(localJSONObject3.optInt("distance"));
    localWalkingRouteLine.setDuration(localJSONObject3.optInt("duration"));
    JSONArray localJSONArray = localJSONObject3.optJSONArray("steps");
    if (localJSONArray != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      if (i < localJSONArray.length())
      {
        WalkingRouteLine.WalkingStep localWalkingStep = new WalkingRouteLine.WalkingStep();
        JSONObject localJSONObject4 = localJSONArray.optJSONObject(i);
        if (localJSONObject4 == null);
        while (true)
        {
          i++;
          break;
          localWalkingStep.a(30 * localJSONObject4.optInt("direction"));
          localWalkingStep.setDistance(localJSONObject4.optInt("distance"));
          localWalkingStep.setDuration(localJSONObject4.optInt("duration"));
          localWalkingStep.a(RouteNode.location(com.baidu.mapapi.model.a.a(localJSONObject4.optString("start_loc"))));
          localWalkingStep.b(RouteNode.location(com.baidu.mapapi.model.a.a(localJSONObject4.optString("end_loc"))));
          localWalkingStep.d(g(localJSONObject4.optString("description")));
          localWalkingStep.b(g(localJSONObject4.optString("start_desc")));
          localWalkingStep.c(g(localJSONObject4.optString("end_desc")));
          localWalkingStep.a(localJSONObject4.optString("path"));
          localArrayList1.add(localWalkingStep);
        }
      }
      if (localArrayList1.size() > 0)
        localWalkingRouteLine.setSteps(localArrayList1);
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localWalkingRouteLine);
    localWalkingRouteResult.a(localArrayList2);
    return localWalkingRouteResult;
  }

  private static List<RouteNode> c(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString)));
    JSONArray localJSONArray;
    do
    {
      return null;
      localJSONArray = paramJSONObject.optJSONArray(paramString);
    }
    while (localJSONArray == null);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (true)
    {
      RouteNode localRouteNode;
      if (i < localJSONArray.length())
        localRouteNode = new RouteNode();
      try
      {
        localRouteNode.setTitle(localJSONArray.getJSONObject(i).optString("name"));
        localRouteNode.setLocation(com.baidu.mapapi.model.a.a(localJSONArray.getJSONObject(i).optString("geo")));
        localArrayList.add(localRouteNode);
        label101: i++;
        continue;
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        break label101;
      }
    }
  }

  public static TaxiInfo d(String paramString)
  {
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject == null)
        return null;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      while (true)
      {
        localJSONException.printStackTrace();
        localJSONObject = null;
      }
      TaxiInfo localTaxiInfo = new TaxiInfo();
      localTaxiInfo.setDesc(localJSONObject.optString("remark"));
      localTaxiInfo.setDistance(localJSONObject.optInt("distance"));
      localTaxiInfo.setDuration(localJSONObject.optInt("duration"));
      localTaxiInfo.setTotalPrice(localJSONObject.optInt("total_price"));
      return localTaxiInfo;
    }
  }

  public static VehicleInfo e(String paramString)
  {
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject == null)
        return null;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      while (true)
      {
        localJSONException.printStackTrace();
        localJSONObject = null;
      }
      VehicleInfo localVehicleInfo = new VehicleInfo();
      localVehicleInfo.setZonePrice(localJSONObject.optInt("zone_price"));
      localVehicleInfo.setTotalPrice(localJSONObject.optInt("total_price"));
      localVehicleInfo.setTitle(localJSONObject.optString("name"));
      localVehicleInfo.setPassStationNum(localJSONObject.optInt("stop_num"));
      localVehicleInfo.setUid(localJSONObject.optString("uid"));
      return localVehicleInfo;
    }
  }

  public static SuggestAddrInfo f(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      return null;
    SuggestAddrInfo localSuggestAddrInfo;
    JSONArray localJSONArray;
    while (true)
    {
      JSONObject localJSONObject1;
      String str2;
      try
      {
        localJSONObject1 = new JSONObject(paramString);
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("address_info");
        if (localJSONObject2 == null)
          break;
        localSuggestAddrInfo = new SuggestAddrInfo();
        String str1 = localJSONObject2.optString("st_cityname");
        str2 = localJSONObject2.optString("en_cityname");
        if (localJSONObject2.optBoolean("have_stcitylist"))
        {
          localSuggestAddrInfo.d(a(localJSONObject1, "startcitys"));
          if (localJSONObject2.optBoolean("have_encitylist"))
          {
            localSuggestAddrInfo.e(a(localJSONObject1, "endcitys"));
            localJSONArray = localJSONObject1.optJSONArray("way_points_citylist");
            if (localJSONArray == null)
              break label327;
            if (localJSONArray.length() > 0)
              break label173;
            break label327;
          }
        }
        else
        {
          localSuggestAddrInfo.a(a(localJSONObject1, "startpoints", str1));
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return null;
      }
      localSuggestAddrInfo.b(a(localJSONObject1, "endpoints", str2));
    }
    label173: ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (int i = 0; ; i++)
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject3 = localJSONArray.getJSONObject(i);
        if (localJSONObject3.optBoolean("have_citylist"))
        {
          List localList2 = a(localJSONObject3, "way_points_item");
          if (localList2 != null)
            localArrayList1.add(localList2);
        }
        if (localJSONObject3.optBoolean("have_poilist"))
        {
          List localList1 = a(localJSONObject3, "way_points_poilist", "");
          if (localList1 != null)
            localArrayList2.add(localList1);
        }
      }
      else
      {
        if (localArrayList1.size() > 0)
          localSuggestAddrInfo.f(localArrayList1);
        if (localArrayList2.size() > 0)
          localSuggestAddrInfo.c(localArrayList2);
        return localSuggestAddrInfo;
        label327: return localSuggestAddrInfo;
      }
  }

  public static String g(String paramString)
  {
    if (paramString == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = 0;
    if (i < arrayOfChar.length)
    {
      if (arrayOfChar[i] == '<')
        j = 1;
      while (true)
      {
        i++;
        break;
        if (arrayOfChar[i] == '>')
          j = 0;
        else if (j == 0)
          localStringBuilder.append(arrayOfChar[i]);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.a
 * JD-Core Version:    0.6.2
 */