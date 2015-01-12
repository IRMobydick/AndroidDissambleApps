package com.cocoahero.android.geojson;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

public class Position
  implements Parcelable
{
  private static final int ALT_IDX = 2;
  public static final Parcelable.Creator<Position> CREATOR = new Parcelable.Creator()
  {
    public Position createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Position(paramAnonymousParcel, null);
    }

    public Position[] newArray(int paramAnonymousInt)
    {
      return new Position[paramAnonymousInt];
    }
  };
  private static final int LAT_IDX = 1;
  private static final int LON_IDX;
  private final double[] mStorage = new double[3];

  public Position(double paramDouble1, double paramDouble2)
  {
    this.mStorage[1] = paramDouble1;
    this.mStorage[0] = paramDouble2;
  }

  public Position(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.mStorage[1] = paramDouble1;
    this.mStorage[0] = paramDouble2;
    this.mStorage[2] = paramDouble3;
  }

  public Position(Location paramLocation)
  {
    this.mStorage[1] = paramLocation.getLatitude();
    this.mStorage[0] = paramLocation.getLongitude();
    this.mStorage[2] = paramLocation.getAltitude();
  }

  private Position(Parcel paramParcel)
  {
    this(paramParcel.createDoubleArray());
  }

  public Position(JSONArray paramJSONArray)
  {
    this.mStorage[0] = paramJSONArray.optDouble(0, 0.0D);
    this.mStorage[1] = paramJSONArray.optDouble(1, 0.0D);
    this.mStorage[2] = paramJSONArray.optDouble(2, 0.0D);
  }

  public Position(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length == 2)
    {
      this.mStorage[0] = paramArrayOfDouble[0];
      this.mStorage[1] = paramArrayOfDouble[1];
    }
    while (paramArrayOfDouble.length != 3)
      return;
    this.mStorage[0] = paramArrayOfDouble[0];
    this.mStorage[1] = paramArrayOfDouble[1];
    this.mStorage[2] = paramArrayOfDouble[2];
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof Position))
      return false;
    Position localPosition = (Position)paramObject;
    return Arrays.equals(this.mStorage, localPosition.mStorage);
  }

  public double getAltitude()
  {
    return this.mStorage[2];
  }

  public double getLatitude()
  {
    return this.mStorage[1];
  }

  public double getLongitude()
  {
    return this.mStorage[0];
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.mStorage);
  }

  public void setAltitude(double paramDouble)
  {
    this.mStorage[2] = paramDouble;
  }

  public void setLatitude(double paramDouble)
  {
    this.mStorage[1] = paramDouble;
  }

  public void setLongitude(double paramDouble)
  {
    this.mStorage[0] = paramDouble;
  }

  public double[] toArray()
  {
    return this.mStorage;
  }

  public JSONArray toJSON()
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(1, getLatitude());
    localJSONArray.put(0, getLongitude());
    localJSONArray.put(2, getAltitude());
    return localJSONArray;
  }

  public Location toLocation()
  {
    Location localLocation = new Location("GeoJSON");
    localLocation.setLatitude(getLatitude());
    localLocation.setLongitude(getLongitude());
    localLocation.setAltitude(getAltitude());
    return localLocation;
  }

  public String toString()
  {
    return Arrays.toString(this.mStorage);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDoubleArray(this.mStorage);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.Position
 * JD-Core Version:    0.6.2
 */