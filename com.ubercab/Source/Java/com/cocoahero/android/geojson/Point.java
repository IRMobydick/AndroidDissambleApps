package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Point extends Geometry
{
  public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator()
  {
    public Point createFromParcel(Parcel paramAnonymousParcel)
    {
      return (Point)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public Point[] newArray(int paramAnonymousInt)
    {
      return new Point[paramAnonymousInt];
    }
  };
  private Position mPosition;

  public Point()
  {
  }

  public Point(double paramDouble1, double paramDouble2)
  {
    this.mPosition = new Position(paramDouble1, paramDouble2);
  }

  public Point(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.mPosition = new Position(paramDouble1, paramDouble2, paramDouble3);
  }

  public Point(Position paramPosition)
  {
    setPosition(paramPosition);
  }

  public Point(JSONArray paramJSONArray)
  {
    setPosition(paramJSONArray);
  }

  public Point(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    setPosition(paramJSONObject.optJSONArray("coordinates"));
  }

  public Position getPosition()
  {
    return this.mPosition;
  }

  public String getType()
  {
    return "Point";
  }

  public void setPosition(Position paramPosition)
  {
    this.mPosition = paramPosition;
  }

  public void setPosition(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      this.mPosition = new Position(paramJSONArray);
      return;
    }
    this.mPosition = null;
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    if (this.mPosition != null)
      localJSONObject.put("coordinates", this.mPosition.toJSON());
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.Point
 * JD-Core Version:    0.6.2
 */