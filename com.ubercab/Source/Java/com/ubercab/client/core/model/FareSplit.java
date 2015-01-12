package com.ubercab.client.core.model;

import android.content.Context;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import com.ubercab.library.util.PhoneNumberUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class FareSplit
{
  private List<FareSplitClient> clients;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FareSplit localFareSplit;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFareSplit = (FareSplit)paramObject;
      if (this.clients == null)
        break;
    }
    while (this.clients.equals(localFareSplit.clients));
    while (true)
    {
      return false;
      if (localFareSplit.clients == null)
        break;
    }
  }

  public Collection<String> getClientE164Numbers()
  {
    HashSet localHashSet = new HashSet();
    if (this.clients != null)
    {
      Iterator localIterator = this.clients.iterator();
      while (localIterator.hasNext())
      {
        FareSplitClient localFareSplitClient = (FareSplitClient)localIterator.next();
        localHashSet.add(PhoneNumberUtils.getE164PhoneNumber(localFareSplitClient.getMobileDigits(), localFareSplitClient.getMobileCountryIso2()));
      }
    }
    return localHashSet;
  }

  public FareSplitClient getClientInitiator()
  {
    if (this.clients == null)
      return null;
    return (FareSplitClient)Iterables.tryFind(this.clients, new Predicate()
    {
      public boolean apply(FareSplitClient paramAnonymousFareSplitClient)
      {
        return paramAnonymousFareSplitClient.isInitiator();
      }
    }).orNull();
  }

  public FareSplitClient getClientSelf()
  {
    if (this.clients == null)
      return null;
    return (FareSplitClient)Iterables.tryFind(this.clients, new Predicate()
    {
      public boolean apply(FareSplitClient paramAnonymousFareSplitClient)
      {
        return paramAnonymousFareSplitClient.isSelf();
      }
    }).orNull();
  }

  public List<FareSplitClient> getClients()
  {
    if (this.clients == null)
      return new ArrayList();
    return this.clients;
  }

  public String getDescription(Context paramContext)
  {
    List localList = this.clients;
    int i = 0;
    if (localList != null)
    {
      Iterator localIterator = this.clients.iterator();
      while (localIterator.hasNext())
        if (((FareSplitClient)localIterator.next()).getStatus().equals("Accepted"))
          i++;
    }
    if (i < 2)
      return paramContext.getString(2131558866);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(i);
    return paramContext.getString(2131558865, arrayOfObject);
  }

  public int hashCode()
  {
    if (this.clients != null)
      return this.clients.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FareSplit
 * JD-Core Version:    0.6.2
 */