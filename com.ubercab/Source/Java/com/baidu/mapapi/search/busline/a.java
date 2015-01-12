package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static BusLineResult a(String paramString)
  {
    int i = 1;
    int k = 0;
    BusLineResult localBusLineResult = new BusLineResult();
    JSONArray localJSONArray1;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      int m = localJSONObject1.optInt("count");
      localJSONArray1 = localJSONObject1.optJSONArray("details");
      if ((localJSONArray1 == null) || (m <= 0))
      {
        localBusLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localBusLineResult;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localBusLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localBusLineResult;
    }
    JSONObject localJSONObject2 = localJSONArray1.optJSONObject(0);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    try
    {
      localBusLineResult.a(localSimpleDateFormat.parse(localJSONObject2.optString("starttime")));
      localBusLineResult.b(localSimpleDateFormat.parse(localJSONObject2.optString("endtime")));
      localBusLineResult.a(localJSONObject2.optString("name"));
      if (localJSONObject2.optInt("ismonticket") == i)
      {
        localBusLineResult.a(i);
        localBusLineResult.b(localJSONObject2.optString("uid"));
        localArrayList1 = new ArrayList();
        List localList1 = com.baidu.mapapi.model.a.d(localJSONObject2.optString("geo"));
        if (localList1 == null)
          break label265;
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext())
        {
          List localList2 = (List)localIterator.next();
          BusLineResult.BusStep localBusStep = new BusLineResult.BusStep();
          localBusStep.setWayPoints(localList2);
          localArrayList1.add(localBusStep);
        }
      }
    }
    catch (ParseException localParseException)
    {
      ArrayList localArrayList1;
      while (true)
      {
        localParseException.printStackTrace();
        continue;
        int j = 0;
      }
      label265: if (localArrayList1.size() > 0)
        localBusLineResult.b(localArrayList1);
      JSONArray localJSONArray2 = localJSONObject2.optJSONArray("stations");
      if (localJSONArray2 != null)
      {
        ArrayList localArrayList2 = new ArrayList();
        if (k < localJSONArray2.length())
        {
          JSONObject localJSONObject3 = localJSONArray2.optJSONObject(k);
          if (localJSONObject3 == null);
          while (true)
          {
            k++;
            break;
            BusLineResult.BusStation localBusStation = new BusLineResult.BusStation();
            localBusStation.setTitle(localJSONObject3.optString("name"));
            localBusStation.setLocation(com.baidu.mapapi.model.a.a(localJSONObject3.optString("geo")));
            localBusStation.setUid(localJSONObject3.optString("uid"));
            localArrayList2.add(localBusStation);
          }
        }
        if (localArrayList2.size() > 0)
          localBusLineResult.a(localArrayList2);
      }
    }
    return localBusLineResult;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.busline.a
 * JD-Core Version:    0.6.2
 */