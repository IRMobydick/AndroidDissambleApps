package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeatureCollection extends GeoJSONObject
{
  public static final Parcelable.Creator<FeatureCollection> CREATOR = new Parcelable.Creator()
  {
    public FeatureCollection createFromParcel(Parcel paramAnonymousParcel)
    {
      return (FeatureCollection)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public FeatureCollection[] newArray(int paramAnonymousInt)
    {
      return new FeatureCollection[paramAnonymousInt];
    }
  };
  public static final String JSON_FEATURES = "features";
  private final List<Feature> mFeatures = new ArrayList();

  public FeatureCollection()
  {
  }

  public FeatureCollection(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("features");
    if (localJSONArray != null)
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
          this.mFeatures.add(new Feature(localJSONObject));
      }
  }

  public void addFeature(Feature paramFeature)
  {
    this.mFeatures.add(paramFeature);
  }

  public List<Feature> getFeatures()
  {
    return this.mFeatures;
  }

  public String getType()
  {
    return "FeatureCollection";
  }

  public void removeFeature(Feature paramFeature)
  {
    this.mFeatures.remove(paramFeature);
  }

  public void setFeatures(List<Feature> paramList)
  {
    this.mFeatures.clear();
    if (paramList != null)
      this.mFeatures.addAll(paramList);
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.mFeatures.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(((Feature)localIterator.next()).toJSON());
    localJSONObject.put("features", localJSONArray);
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.FeatureCollection
 * JD-Core Version:    0.6.2
 */