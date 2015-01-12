package com.ubercab.client.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MobileMessage
{
  MobileMessageDisplayProperties displayProps;
  String eTag;
  String id;
  Map<String, String> messageProps;
  List<MobileMessageModule> modules;
  Boolean showWhileSurgeIsActive;
  String tapDestination;
  String vehicleViewId;

  public MobileMessage addModule(MobileMessageModule paramMobileMessageModule)
  {
    if (this.modules == null)
      this.modules = new ArrayList();
    this.modules.add(paramMobileMessageModule);
    return this;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MobileMessage localMobileMessage;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMobileMessage = (MobileMessage)paramObject;
      if (this.eTag != null)
      {
        if (this.eTag.equals(localMobileMessage.eTag));
      }
      else
        while (localMobileMessage.eTag != null)
          return false;
      if (this.id == null)
        break;
    }
    while (this.id.equals(localMobileMessage.id));
    while (true)
    {
      return false;
      if (localMobileMessage.id == null)
        break;
    }
  }

  public MobileMessageDisplayProperties getDisplayProps()
  {
    return this.displayProps;
  }

  public String getETag()
  {
    return this.eTag;
  }

  public String getId()
  {
    return this.id;
  }

  public List<MobileMessageModule> getModules()
  {
    return this.modules;
  }

  public String getVehicleViewId()
  {
    return this.vehicleViewId;
  }

  public int hashCode()
  {
    if (this.id != null);
    for (int i = this.id.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.eTag;
      int k = 0;
      if (str != null)
        k = this.eTag.hashCode();
      return j + k;
    }
  }

  public boolean isShowAsModalOverRequestView()
  {
    return (this.displayProps != null) && (this.displayProps.isShowAsModalOverRequestView());
  }

  public boolean isStub()
  {
    return this.modules == null;
  }

  public MobileMessage setDisplayProps(MobileMessageDisplayProperties paramMobileMessageDisplayProperties)
  {
    this.displayProps = paramMobileMessageDisplayProperties;
    return this;
  }

  public void setETag(String paramString)
  {
    this.eTag = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setModules(List<MobileMessageModule> paramList)
  {
    this.modules = paramList;
  }

  public String toString()
  {
    return "id=" + this.id + " eTag=" + this.eTag + " isStub=" + isStub();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.MobileMessage
 * JD-Core Version:    0.6.2
 */