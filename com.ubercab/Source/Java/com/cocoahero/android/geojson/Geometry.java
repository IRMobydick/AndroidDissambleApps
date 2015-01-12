package com.cocoahero.android.geojson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Geometry extends GeoJSONObject
{
  public static final String JSON_COORDINATES = "coordinates";

  public Geometry()
  {
  }

  public Geometry(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    localJSONObject.put("coordinates", new JSONArray());
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.Geometry
 * JD-Core Version:    0.6.2
 */