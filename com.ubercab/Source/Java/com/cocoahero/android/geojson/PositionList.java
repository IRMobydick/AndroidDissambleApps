package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.cocoahero.android.geojson.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class PositionList
  implements Parcelable
{
  public static final Parcelable.Creator<PositionList> CREATOR = new Parcelable.Creator()
  {
    public PositionList createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PositionList(paramAnonymousParcel);
    }

    public PositionList[] newArray(int paramAnonymousInt)
    {
      return new PositionList[paramAnonymousInt];
    }
  };
  private final List<Position> mPositions = new ArrayList();

  public PositionList()
  {
  }

  protected PositionList(Parcel paramParcel)
  {
    setPositions(paramParcel.createTypedArrayList(Position.CREATOR));
  }

  public PositionList(JSONArray paramJSONArray)
  {
    setPositions(paramJSONArray);
  }

  public PositionList(double[][] paramArrayOfDouble)
  {
    for (int i = 0; i < paramArrayOfDouble.length; i++)
      addPosition(new Position(paramArrayOfDouble[i]));
  }

  public void addPosition(Position paramPosition)
  {
    this.mPositions.add(paramPosition);
  }

  public void addPositions(PositionList paramPositionList)
  {
    this.mPositions.addAll(paramPositionList.mPositions);
  }

  public void addPositions(List<Position> paramList)
  {
    this.mPositions.addAll(paramList);
  }

  public void clearPositions()
  {
    this.mPositions.clear();
  }

  public int describeContents()
  {
    return 0;
  }

  public Position getHead()
  {
    return (Position)ListUtils.getHead(this.mPositions);
  }

  public List<Position> getPositions()
  {
    return this.mPositions;
  }

  public Position getTail()
  {
    return (Position)ListUtils.getTail(this.mPositions);
  }

  public boolean isLinearRing()
  {
    if (this.mPositions.size() < 4)
      return false;
    return getHead().equals(getTail());
  }

  public void removePosition(Position paramPosition)
  {
    this.mPositions.remove(paramPosition);
  }

  public void removePositions(PositionList paramPositionList)
  {
    this.mPositions.removeAll(paramPositionList.mPositions);
  }

  public void removePositions(List<Position> paramList)
  {
    this.mPositions.removeAll(paramList);
  }

  public void setPositions(PositionList paramPositionList)
  {
    this.mPositions.clear();
    if (paramPositionList != null)
      this.mPositions.addAll(paramPositionList.mPositions);
  }

  public void setPositions(List<Position> paramList)
  {
    this.mPositions.clear();
    if (paramList != null)
      this.mPositions.addAll(paramList);
  }

  public void setPositions(JSONArray paramJSONArray)
  {
    this.mPositions.clear();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++)
      {
        JSONArray localJSONArray = paramJSONArray.optJSONArray(i);
        if (localJSONArray != null)
          this.mPositions.add(new Position(localJSONArray));
      }
  }

  public JSONArray toJSON()
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.mPositions.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(((Position)localIterator.next()).toJSON());
    return localJSONArray;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.mPositions);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.PositionList
 * JD-Core Version:    0.6.2
 */