package com.ubercab.library.network.cn.model;

import java.util.Arrays;
import java.util.List;

public class CnFile
{
  private List<Cn> cnList;

  public static CnFile createDefault()
  {
    CnFile localCnFile = new CnFile();
    Cn[] arrayOfCn = new Cn[1];
    arrayOfCn[0] = Cn.createDefault();
    localCnFile.cnList = Arrays.asList(arrayOfCn);
    return localCnFile;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CnFile localCnFile;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCnFile = (CnFile)paramObject;
      if (this.cnList == null)
        break;
    }
    while (this.cnList.equals(localCnFile.cnList));
    while (true)
    {
      return false;
      if (localCnFile.cnList == null)
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
 * Qualified Name:     com.ubercab.library.network.cn.model.CnFile
 * JD-Core Version:    0.6.2
 */