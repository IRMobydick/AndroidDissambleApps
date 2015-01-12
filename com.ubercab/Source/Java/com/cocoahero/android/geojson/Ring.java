package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONArray;

public class Ring extends PositionList
{
  public static final Parcelable.Creator<Ring> CREATOR = new Parcelable.Creator()
  {
    public Ring createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Ring(paramAnonymousParcel);
    }

    public Ring[] newArray(int paramAnonymousInt)
    {
      return new Ring[paramAnonymousInt];
    }
  };

  public Ring()
  {
  }

  protected Ring(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public Ring(JSONArray paramJSONArray)
  {
    super(paramJSONArray);
  }

  public Ring(double[][] paramArrayOfDouble)
  {
    super(paramArrayOfDouble);
  }

  public void close()
  {
    if (!isLinearRing())
      addPosition(getHead());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.Ring
 * JD-Core Version:    0.6.2
 */