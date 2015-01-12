package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class GeoJSONObject
  implements Parcelable
{
  public static final Parcelable.Creator<GeoJSONObject> CREATOR = new Parcelable.Creator()
  {
    public GeoJSONObject createFromParcel(Parcel paramAnonymousParcel)
    {
      return GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public GeoJSONObject[] newArray(int paramAnonymousInt)
    {
      return new GeoJSONObject[paramAnonymousInt];
    }
  };
  public static final String JSON_TYPE = "type";

  public GeoJSONObject()
  {
  }

  public GeoJSONObject(JSONObject paramJSONObject)
  {
  }

  protected static GeoJSONObject readParcel(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    try
    {
      GeoJSONObject localGeoJSONObject = GeoJSON.parse(str);
      return localGeoJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public abstract String getType();

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", getType());
    return localJSONObject;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(toJSON().toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.GeoJSONObject
 * JD-Core Version:    0.6.2
 */