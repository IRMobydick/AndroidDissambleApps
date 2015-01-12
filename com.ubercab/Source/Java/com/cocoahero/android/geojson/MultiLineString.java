package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiLineString extends Geometry
{
  public static final Parcelable.Creator<MultiLineString> CREATOR = new Parcelable.Creator()
  {
    public MultiLineString createFromParcel(Parcel paramAnonymousParcel)
    {
      return (MultiLineString)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public MultiLineString[] newArray(int paramAnonymousInt)
    {
      return new MultiLineString[paramAnonymousInt];
    }
  };
  private final List<LineString> mLineStrings = new ArrayList();

  public MultiLineString()
  {
  }

  public MultiLineString(JSONArray paramJSONArray)
  {
    setLineStrings(paramJSONArray);
  }

  public MultiLineString(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    setLineStrings(paramJSONObject.optJSONArray("coordinates"));
  }

  public void addLineString(LineString paramLineString)
  {
    this.mLineStrings.add(paramLineString);
  }

  public List<LineString> getLineStrings()
  {
    return this.mLineStrings;
  }

  public String getType()
  {
    return "MultiLineString";
  }

  public void removeLineString(LineString paramLineString)
  {
    this.mLineStrings.remove(paramLineString);
  }

  public void setLineStrings(List<LineString> paramList)
  {
    this.mLineStrings.clear();
    if (paramList != null)
      this.mLineStrings.addAll(paramList);
  }

  public void setLineStrings(JSONArray paramJSONArray)
  {
    this.mLineStrings.clear();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++)
      {
        JSONArray localJSONArray = paramJSONArray.optJSONArray(i);
        if (localJSONArray != null)
          this.mLineStrings.add(new LineString(localJSONArray));
      }
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator1 = this.mLineStrings.iterator();
    while (localIterator1.hasNext())
    {
      LineString localLineString = (LineString)localIterator1.next();
      JSONArray localJSONArray2 = new JSONArray();
      Iterator localIterator2 = localLineString.getPositions().iterator();
      while (localIterator2.hasNext())
        localJSONArray2.put(((Position)localIterator2.next()).toJSON());
      localJSONArray1.put(localJSONArray2);
    }
    localJSONObject.put("coordinates", localJSONArray1);
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.MultiLineString
 * JD-Core Version:    0.6.2
 */