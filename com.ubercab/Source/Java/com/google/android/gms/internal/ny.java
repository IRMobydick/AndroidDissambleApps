package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class ny extends d
  implements Moment
{
  private nw amZ;

  public ny(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  private nw nt()
  {
    try
    {
      if (this.amZ == null)
      {
        byte[] arrayOfByte = getByteArray("momentImpl");
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
        localParcel.setDataPosition(0);
        this.amZ = nw.CREATOR.dc(localParcel);
        localParcel.recycle();
      }
      return this.amZ;
    }
    finally
    {
    }
  }

  public String getId()
  {
    return nt().getId();
  }

  public ItemScope getResult()
  {
    return nt().getResult();
  }

  public String getStartDate()
  {
    return nt().getStartDate();
  }

  public ItemScope getTarget()
  {
    return nt().getTarget();
  }

  public String getType()
  {
    return nt().getType();
  }

  public boolean hasId()
  {
    return nt().hasId();
  }

  public boolean hasResult()
  {
    return nt().hasResult();
  }

  public boolean hasStartDate()
  {
    return nt().hasStartDate();
  }

  public boolean hasTarget()
  {
    return nt().hasTarget();
  }

  public boolean hasType()
  {
    return nt().hasType();
  }

  public nw ns()
  {
    return nt();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ny
 * JD-Core Version:    0.6.2
 */