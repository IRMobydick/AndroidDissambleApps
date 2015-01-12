package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiPoint extends Geometry
{
  public static final Parcelable.Creator<MultiPoint> CREATOR = new Parcelable.Creator()
  {
    public MultiPoint createFromParcel(Parcel paramAnonymousParcel)
    {
      return (MultiPoint)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public MultiPoint[] newArray(int paramAnonymousInt)
    {
      return new MultiPoint[paramAnonymousInt];
    }
  };
  private final PositionList mPositionList = new PositionList();

  public MultiPoint()
  {
  }

  public MultiPoint(JSONArray paramJSONArray)
  {
    setPositions(paramJSONArray);
  }

  public MultiPoint(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    setPositions(paramJSONObject.optJSONArray("coordinates"));
  }

  public void addPosition(Position paramPosition)
  {
    this.mPositionList.addPosition(paramPosition);
  }

  public List<Position> getPositions()
  {
    return this.mPositionList.getPositions();
  }

  public String getType()
  {
    return "MultiPoint";
  }

  public void removePosition(Position paramPosition)
  {
    this.mPositionList.removePosition(paramPosition);
  }

  public void setPositions(List<Position> paramList)
  {
    this.mPositionList.setPositions(paramList);
  }

  public void setPositions(JSONArray paramJSONArray)
  {
    this.mPositionList.setPositions(paramJSONArray);
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = super.toJSON();
    localJSONObject.put("coordinates", this.mPositionList.toJSON());
    return localJSONObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.MultiPoint
 * JD-Core Version:    0.6.2
 */