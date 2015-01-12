package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LineString extends Geometry
{
  public static final Parcelable.Creator<LineString> CREATOR = new Parcelable.Creator()
  {
    public LineString createFromParcel(Parcel paramAnonymousParcel)
    {
      return (LineString)GeoJSONObject.readParcel(paramAnonymousParcel);
    }

    public LineString[] newArray(int paramAnonymousInt)
    {
      return new LineString[paramAnonymousInt];
    }
  };
  private final PositionList mPositionList = new PositionList();

  public LineString()
  {
  }

  public LineString(JSONArray paramJSONArray)
  {
    setPositions(paramJSONArray);
  }

  public LineString(JSONObject paramJSONObject)
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
    return "LineString";
  }

  public boolean isLinearRing()
  {
    return this.mPositionList.isLinearRing();
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
 * Qualified Name:     com.cocoahero.android.geojson.LineString
 * JD-Core Version:    0.6.2
 */