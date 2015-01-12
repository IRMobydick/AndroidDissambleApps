package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.nz;
import com.google.android.gms.internal.ok;

public final class PersonBuffer extends DataBuffer<Person>
{
  private final e<nz> anJ;

  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.gy() != null) && (paramDataHolder.gy().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.anJ = new e(paramDataHolder, nz.CREATOR);
      return;
    }
    this.anJ = null;
  }

  public Person get(int paramInt)
  {
    if (this.anJ != null)
      return (Person)this.anJ.aq(paramInt);
    return new ok(this.II, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.model.people.PersonBuffer
 * JD-Core Version:    0.6.2
 */