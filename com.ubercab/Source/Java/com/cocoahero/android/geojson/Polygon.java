package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Polygon extends Geometry
{
  public static final Parcelable.Creator<Polygon> CREATOR = new Parcelable.Creator()
  {
    public Polygon createFromParcel(Parcel paramAnonymousParcel)
    {
      return (Polygon)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public Polygon[] newArray(int paramAnonymousInt)
    {
      return new Polygon[paramAnonymousInt];
    }
  };
  private final List<Ring> mRings = new ArrayList();

  public Polygon()
  {
  }

  public Polygon(Ring paramRing)
  {
    addRing(paramRing);
  }

  public Polygon(JSONArray paramJSONArray)
  {
    setRings(paramJSONArray);
  }

  public Polygon(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    setRings(paramJSONObject.optJSONArray("coordinates"));
  }

  public void addRing(Ring paramRing)
  {
    this.mRings.add(paramRing);
  }

  public List<Ring> getRings()
  {
    return this.mRings;
  }

  public String getType()
  {
    return "Polygon";
  }

  public void removeRing(Ring paramRing)
  {
    this.mRings.remove(paramRing);
  }

  public void setRings(List<Ring> paramList)
  {
    this.mRings.clear();
    if (paramList != null)
      this.mRings.addAll(paramList);
  }

  public void setRings(JSONArray paramJSONArray)
  {
    this.mRings.clear();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++)
      {
        JSONArray localJSONArray = paramJSONArray.optJSONArray(i);
        if (localJSONArray != null)
          this.mRings.add(new Ring(localJSONArray));
      }
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.mRings.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(((Ring)localIterator.next()).toJSON());
    localJSONObject.put("coordinates", localJSONArray);
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.Polygon
 * JD-Core Version:    0.6.2
 */