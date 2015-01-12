package com.ubercab.client.core.model;

import java.util.ArrayList;
import java.util.List;

public class MobileMessageModule
{
  List<String> content;
  Boolean disableSwipeGesture;
  MobileMessageModuleDisplayProperties displayProps;
  Boolean showNativeOpenCloseButton;
  Boolean showPageControlIndicator;

  public MobileMessageModule addHtmlPage(String paramString)
  {
    if (this.content == null)
      this.content = new ArrayList();
    this.content.add(paramString);
    return this;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MobileMessageModule localMobileMessageModule;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMobileMessageModule = (MobileMessageModule)paramObject;
      if (this.content != null)
      {
        if (this.content.equals(localMobileMessageModule.content));
      }
      else
        while (localMobileMessageModule.content != null)
          return false;
      if (this.disableSwipeGesture != null)
      {
        if (this.disableSwipeGesture.equals(localMobileMessageModule.disableSwipeGesture));
      }
      else
        while (localMobileMessageModule.disableSwipeGesture != null)
          return false;
      if (this.displayProps != null)
      {
        if (this.displayProps.equals(localMobileMessageModule.displayProps));
      }
      else
        while (localMobileMessageModule.displayProps != null)
          return false;
      if (this.showNativeOpenCloseButton != null)
      {
        if (this.showNativeOpenCloseButton.equals(localMobileMessageModule.showNativeOpenCloseButton));
      }
      else
        while (localMobileMessageModule.showNativeOpenCloseButton != null)
          return false;
      if (this.showPageControlIndicator == null)
        break;
    }
    while (this.showPageControlIndicator.equals(localMobileMessageModule.showPageControlIndicator));
    while (true)
    {
      return false;
      if (localMobileMessageModule.showPageControlIndicator == null)
        break;
    }
  }

  public String getHtmlContent(int paramInt)
  {
    if (paramInt > getPageCount())
      return "";
    return (String)this.content.get(paramInt);
  }

  public int getPageCount()
  {
    if (this.content == null)
      return 0;
    return this.content.size();
  }

  public int hashCode()
  {
    int i;
    int k;
    label37: int n;
    label61: int i1;
    if (this.content != null)
    {
      i = this.content.hashCode();
      int j = i * 31;
      if (this.disableSwipeGesture == null)
        break label131;
      k = this.disableSwipeGesture.hashCode();
      int m = 31 * (j + k);
      if (this.showNativeOpenCloseButton == null)
        break label136;
      n = this.showNativeOpenCloseButton.hashCode();
      i1 = 31 * (m + n);
      if (this.showPageControlIndicator == null)
        break label142;
    }
    label131: label136: label142: for (int i2 = this.showPageControlIndicator.hashCode(); ; i2 = 0)
    {
      int i3 = 31 * (i1 + i2);
      MobileMessageModuleDisplayProperties localMobileMessageModuleDisplayProperties = this.displayProps;
      int i4 = 0;
      if (localMobileMessageModuleDisplayProperties != null)
        i4 = this.displayProps.hashCode();
      return i3 + i4;
      i = 0;
      break;
      k = 0;
      break label37;
      n = 0;
      break label61;
    }
  }

  public void setContent(List<String> paramList)
  {
    this.content = paramList;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.MobileMessageModule
 * JD-Core Version:    0.6.2
 */