package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeometryCollection extends Geometry
{
  public static final Parcelable.Creator<GeometryCollection> CREATOR = new Parcelable.Creator()
  {
    public GeometryCollection createFromParcel(Parcel paramAnonymousParcel)
    {
      return (GeometryCollection)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public GeometryCollection[] newArray(int paramAnonymousInt)
    {
      return new GeometryCollection[paramAnonymousInt];
    }
  };
  public static final String JSON_GEOMETRIES = "geometries";
  private final List<Geometry> mGeometries = new ArrayList();

  public GeometryCollection()
  {
  }

  public GeometryCollection(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("geometries");
    if (localJSONArray != null)
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
          this.mGeometries.add((Geometry)GeoJSON.parse(localJSONObject));
      }
  }

  public void addGeometry(Geometry paramGeometry)
  {
    this.mGeometries.add(paramGeometry);
  }

  public List<Geometry> getGeometries()
  {
    return this.mGeometries;
  }

  public String getType()
  {
    return "GeometryCollection";
  }

  public void removeGeometry(Geometry paramGeometry)
  {
    this.mGeometries.remove(paramGeometry);
  }

  public void setGeometries(List<Geometry> paramList)
  {
    this.mGeometries.clear();
    if (paramList != null)
      this.mGeometries.addAll(paramList);
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.mGeometries.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(((Geometry)localIterator.next()).toJSON());
    localJSONObject.put("geometries", localJSONArray);
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.GeometryCollection
 * JD-Core Version:    0.6.2
 */