package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.FareSplit;

public final class FareSplitEvent
{
  private final FareSplit mFareSplit;

  public FareSplitEvent(FareSplit paramFareSplit)
  {
    this.mFareSplit = paramFareSplit;
  }

  public FareSplit getFareSplit()
  {
    return this.mFareSplit;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.FareSplitEvent
 * JD-Core Version:    0.6.2
 */