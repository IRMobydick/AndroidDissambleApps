package com.ubercab.client.core.model.event;

public final class IsForceUpgradeEvent
{
  private final boolean mIsForceUpgrade;

  public IsForceUpgradeEvent(boolean paramBoolean)
  {
    this.mIsForceUpgrade = paramBoolean;
  }

  public boolean getIsForceUpgrade()
  {
    return this.mIsForceUpgrade;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.IsForceUpgradeEvent
 * JD-Core Version:    0.6.2
 */