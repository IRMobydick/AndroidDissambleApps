package com.cocoahero.android.geojson;

import com.cocoahero.android.geojson.util.JSONUtils;
import com.cocoahero.android.geojson.util.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class GeoJSON
{
  public static final String TYPE_FEATURE = "Feature";
  public static final String TYPE_FEATURE_COLLECTION = "FeatureCollection";
  public static final String TYPE_GEOMETRY_COLLECTION = "GeometryCollection";
  public static final String TYPE_LINE_STRING = "LineString";
  public static final String TYPE_MULTI_LINE_STRING = "MultiLineString";
  public static final String TYPE_MULTI_POINT = "MultiPoint";
  public static final String TYPE_MULTI_POLYGON = "MultiPolygon";
  public static final String TYPE_POINT = "Point";
  public static final String TYPE_POLYGON = "Polygon";

  public static GeoJSONObject parse(InputStream paramInputStream)
    throws IOException, JSONException
  {
    return parse(StreamUtils.toString(paramInputStream));
  }

  public static GeoJSONObject parse(String paramString)
    throws JSONException
  {
    return parse(new JSONObject(paramString));
  }

  public static GeoJSONObject parse(JSONObject paramJSONObject)
  {
    String str = JSONUtils.optString(paramJSONObject, "type");
    if ("Point".equalsIgnoreCase(str))
      return new Point(paramJSONObject);
    if ("MultiPoint".equalsIgnoreCase(str))
      return new MultiPoint(paramJSONObject);
    if ("LineString".equalsIgnoreCase(str))
      return new LineString(paramJSONObject);
    if ("MultiLineString".equalsIgnoreCase(str))
      return new MultiLineString(paramJSONObject);
    if ("Polygon".equalsIgnoreCase(str))
      return new Polygon(paramJSONObject);
    if ("MultiPolygon".equalsIgnoreCase(str))
      return new MultiPolygon(paramJSONObject);
    if ("GeometryCollection".equalsIgnoreCase(str))
      return new GeometryCollection(paramJSONObject);
    if ("Feature".equalsIgnoreCase(str))
      return new Feature(paramJSONObject);
    if ("FeatureCollection".equalsIgnoreCase(str))
      return new FeatureCollection(paramJSONObject);
    throw new IllegalArgumentException("The type '" + str + "' is not a valid GeoJSON type.");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.GeoJSON
 * JD-Core Version:    0.6.2
 */