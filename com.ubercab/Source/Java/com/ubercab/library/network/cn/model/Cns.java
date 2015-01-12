package com.ubercab.library.network.cn.model;

import com.ubercab.common.collect.ImmutableList;
import java.util.List;

final class Cns
{
  private List<Cn> cnList = ImmutableList.of(new Cn());

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Cns localCns;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCns = (Cns)paramObject;
      if (this.cnList == null)
        break;
    }
    while (this.cnList.equals(localCns.cnList));
    while (true)
    {
      return false;
      if (localCns.cnList == null)
        break;
    }
  }

  public List<Cn> getCnList()
  {
    return this.cnList;
  }

  public int hashCode()
  {
    if (this.cnList != null)
      return this.cnList.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.cn.model.Cns
 * JD-Core Version:    0.6.2
 */