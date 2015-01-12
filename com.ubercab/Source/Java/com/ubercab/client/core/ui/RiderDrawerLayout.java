package com.ubercab.client.core.ui;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

public class RiderDrawerLayout extends DrawerLayout
{
  public RiderDrawerLayout(Context paramContext)
  {
    super(paramContext);
  }

  public RiderDrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public RiderDrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.RiderDrawerLayout
 * JD-Core Version:    0.6.2
 */