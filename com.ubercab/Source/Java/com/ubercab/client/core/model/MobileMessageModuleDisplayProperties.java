package com.ubercab.client.core.model;

import java.util.Map;

public class MobileMessageModuleDisplayProperties
{
  Map<String, Float> nativeOpenCloseButtonColor;
  Integer nativeOpenCloseButtonRightMargin;
  Integer nativeOpenCloseButtonTopMargin;
  Map<String, Float> pageControlIndicatorCurrentPageTintColor;
  Float pageControlIndicatorTintColorAlpha;
  Boolean showNativeOpenCloseButton;
  Boolean showPageControlIndicator;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MobileMessageModuleDisplayProperties localMobileMessageModuleDisplayProperties;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMobileMessageModuleDisplayProperties = (MobileMessageModuleDisplayProperties)paramObject;
      if (this.nativeOpenCloseButtonColor != null)
      {
        if (this.nativeOpenCloseButtonColor.equals(localMobileMessageModuleDisplayProperties.nativeOpenCloseButtonColor));
      }
      else
        while (localMobileMessageModuleDisplayProperties.nativeOpenCloseButtonColor != null)
          return false;
      if (this.nativeOpenCloseButtonRightMargin != null)
      {
        if (this.nativeOpenCloseButtonRightMargin.equals(localMobileMessageModuleDisplayProperties.nativeOpenCloseButtonRightMargin));
      }
      else
        while (localMobileMessageModuleDisplayProperties.nativeOpenCloseButtonRightMargin != null)
          return false;
      if (this.nativeOpenCloseButtonTopMargin != null)
      {
        if (this.nativeOpenCloseButtonTopMargin.equals(localMobileMessageModuleDisplayProperties.nativeOpenCloseButtonTopMargin));
      }
      else
        while (localMobileMessageModuleDisplayProperties.nativeOpenCloseButtonTopMargin != null)
          return false;
      if (this.pageControlIndicatorCurrentPageTintColor != null)
      {
        if (this.pageControlIndicatorCurrentPageTintColor.equals(localMobileMessageModuleDisplayProperties.pageControlIndicatorCurrentPageTintColor));
      }
      else
        while (localMobileMessageModuleDisplayProperties.pageControlIndicatorCurrentPageTintColor != null)
          return false;
      if (this.pageControlIndicatorTintColorAlpha != null)
      {
        if (this.pageControlIndicatorTintColorAlpha.equals(localMobileMessageModuleDisplayProperties.pageControlIndicatorTintColorAlpha));
      }
      else
        while (localMobileMessageModuleDisplayProperties.pageControlIndicatorTintColorAlpha != null)
          return false;
      if (this.showNativeOpenCloseButton != null)
      {
        if (this.showNativeOpenCloseButton.equals(localMobileMessageModuleDisplayProperties.showNativeOpenCloseButton));
      }
      else
        while (localMobileMessageModuleDisplayProperties.showNativeOpenCloseButton != null)
          return false;
      if (this.showPageControlIndicator == null)
        break;
    }
    while (this.showPageControlIndicator.equals(localMobileMessageModuleDisplayProperties.showPageControlIndicator));
    while (true)
    {
      return false;
      if (localMobileMessageModuleDisplayProperties.showPageControlIndicator == null)
        break;
    }
  }

  public Map<String, Float> getNativeOpenCloseButtonColor()
  {
    return this.nativeOpenCloseButtonColor;
  }

  public Integer getNativeOpenCloseButtonRightMargin()
  {
    return this.nativeOpenCloseButtonRightMargin;
  }

  public Integer getNativeOpenCloseButtonTopMargin()
  {
    return this.nativeOpenCloseButtonTopMargin;
  }

  public Map<String, Float> getPageControlIndicatorCurrentPageTintColor()
  {
    return this.pageControlIndicatorCurrentPageTintColor;
  }

  public Float getPageControlIndicatorTintColorAlpha()
  {
    return this.pageControlIndicatorTintColorAlpha;
  }

  public Boolean getShowNativeOpenCloseButton()
  {
    return this.showNativeOpenCloseButton;
  }

  public Boolean getShowPageControlIndicator()
  {
    return this.showPageControlIndicator;
  }

  public int hashCode()
  {
    int i;
    int k;
    label37: int n;
    label61: int i2;
    label89: int i4;
    label115: int i5;
    if (this.nativeOpenCloseButtonColor != null)
    {
      i = this.nativeOpenCloseButtonColor.hashCode();
      int j = i * 31;
      if (this.nativeOpenCloseButtonRightMargin == null)
        break label185;
      k = this.nativeOpenCloseButtonRightMargin.hashCode();
      int m = 31 * (j + k);
      if (this.nativeOpenCloseButtonTopMargin == null)
        break label190;
      n = this.nativeOpenCloseButtonTopMargin.hashCode();
      int i1 = 31 * (m + n);
      if (this.pageControlIndicatorCurrentPageTintColor == null)
        break label196;
      i2 = this.pageControlIndicatorCurrentPageTintColor.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.pageControlIndicatorTintColorAlpha == null)
        break label202;
      i4 = this.pageControlIndicatorTintColorAlpha.hashCode();
      i5 = 31 * (i3 + i4);
      if (this.showPageControlIndicator == null)
        break label208;
    }
    label185: label190: label196: label202: label208: for (int i6 = this.showPageControlIndicator.hashCode(); ; i6 = 0)
    {
      int i7 = 31 * (i5 + i6);
      Boolean localBoolean = this.showNativeOpenCloseButton;
      int i8 = 0;
      if (localBoolean != null)
        i8 = this.showNativeOpenCloseButton.hashCode();
      return i7 + i8;
      i = 0;
      break;
      k = 0;
      break label37;
      n = 0;
      break label61;
      i2 = 0;
      break label89;
      i4 = 0;
      break label115;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.MobileMessageModuleDisplayProperties
 * JD-Core Version:    0.6.2
 */