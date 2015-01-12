package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.cocoahero.android.geojson.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Feature extends GeoJSONObject
{
  public static final Parcelable.Creator<Feature> CREATOR = new Parcelable.Creator()
  {
    public Feature createFromParcel(Parcel paramAnonymousParcel)
    {
      return (Feature)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public Feature[] newArray(int paramAnonymousInt)
    {
      return new Feature[paramAnonymousInt];
    }
  };
  private static final String JSON_GEOMETRY = "geometry";
  private static final String JSON_ID = "id";
  private static final String JSON_PROPERTIES = "properties";
  private Geometry mGeometry;
  private String mIdentifier;
  private JSONObject mProperties;

  public Feature()
  {
  }

  public Feature(Geometry paramGeometry)
  {
    this.mGeometry = paramGeometry;
  }

  public Feature(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.mIdentifier = JSONUtils.optString(paramJSONObject, "id");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("geometry");
    if (localJSONObject != null)
      this.mGeometry = ((Geometry)GeoJSON.parse(localJSONObject));
    this.mProperties = paramJSONObject.optJSONObject("properties");
  }

  public Geometry getGeometry()
  {
    return this.mGeometry;
  }

  public String getIdentifier()
  {
    return this.mIdentifier;
  }

  public JSONObject getProperties()
  {
    return this.mProperties;
  }

  public String getType()
  {
    return "Feature";
  }

  public void setGeometry(Geometry paramGeometry)
  {
    this.mGeometry = paramGeometry;
  }

  public void setIdentifier(String paramString)
  {
    this.mIdentifier = paramString;
  }

  public void setProperties(JSONObject paramJSONObject)
  {
    this.mProperties = paramJSONObject;
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    localJSONObject.put("id", this.mIdentifier);
    if (this.mGeometry != null)
      localJSONObject.put("geometry", this.mGeometry.toJSON());
    while (this.mProperties != null)
    {
      localJSONObject.put("properties", this.mProperties);
      return localJSONObject;
      localJSONObject.put("geometry", JSONObject.NULL);
    }
    localJSONObject.put("properties", JSONObject.NULL);
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.Feature
 * JD-Core Version:    0.6.2
 */