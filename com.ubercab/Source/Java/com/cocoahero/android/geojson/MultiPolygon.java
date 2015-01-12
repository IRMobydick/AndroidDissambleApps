package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiPolygon extends Geometry
{
  public static final Parcelable.Creator<MultiPolygon> CREATOR = new Parcelable.Creator()
  {
    public MultiPolygon createFromParcel(Parcel paramAnonymousParcel)
    {
      return (MultiPolygon)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public MultiPolygon[] newArray(int paramAnonymousInt)
    {
      return new MultiPolygon[paramAnonymousInt];
    }
  };
  private final List<Polygon> mPolygons = new ArrayList();

  public MultiPolygon()
  {
  }

  public MultiPolygon(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    setPolygons(paramJSONObject.optJSONArray("coordinates"));
  }

  public void addPolygon(Polygon paramPolygon)
  {
    this.mPolygons.add(paramPolygon);
  }

  public List<Polygon> getPolygons()
  {
    return this.mPolygons;
  }

  public String getType()
  {
    return "MultiPolygon";
  }

  public void removePolygon(Polygon paramPolygon)
  {
    this.mPolygons.remove(paramPolygon);
  }

  public void setPolygons(List<Polygon> paramList)
  {
    this.mPolygons.clear();
    if (paramList != null)
      this.mPolygons.addAll(paramList);
  }

  public void setPolygons(JSONArray paramJSONArray)
  {
    this.mPolygons.clear();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++)
      {
        JSONArray localJSONArray = paramJSONArray.optJSONArray(i);
        if (localJSONArray != null)
          this.mPolygons.add(new Polygon(localJSONArray));
      }
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator1 = this.mPolygons.iterator();
    while (localIterator1.hasNext())
    {
      Polygon localPolygon = (Polygon)localIterator1.next();
      JSONArray localJSONArray2 = new JSONArray();
      Iterator localIterator2 = localPolygon.getRings().iterator();
      while (localIterator2.hasNext())
        localJSONArray2.put(((Ring)localIterator2.next()).toJSON());
      localJSONArray1.put(localJSONArray2);
    }
    localJSONObject.put("coordinates", localJSONArray1);
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.MultiPolygon
 * JD-Core Version:    0.6.2
 */