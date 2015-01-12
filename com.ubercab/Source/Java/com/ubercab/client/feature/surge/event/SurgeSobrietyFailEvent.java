package com.ubercab.client.feature.surge.event;

public final class SurgeSobrietyFailEvent
{
  private final float mMultiplier;

  public SurgeSobrietyFailEvent(float paramFloat)
  {
    this.mMultiplier = paramFloat;
  }

  public float getMultiplier()
  {
    return this.mMultiplier;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.surge.event.SurgeSobrietyFailEvent
 * JD-Core Version:    0.6.2
 */