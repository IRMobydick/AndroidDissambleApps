package com.ubercab.client.core.drawer;

import android.graphics.drawable.Drawable;

public class DrawerItem
{
  private Drawable mDrawableIcon;
  private int mId;
  private String mTitle;

  public DrawerItem(int paramInt, String paramString, Drawable paramDrawable)
  {
    this.mId = paramInt;
    this.mTitle = paramString;
    this.mDrawableIcon = paramDrawable;
  }

  public Drawable getIcon()
  {
    return this.mDrawableIcon;
  }

  public int getId()
  {
    return this.mId;
  }

  public String getTitle()
  {
    return this.mTitle;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.drawer.DrawerItem
 * JD-Core Version:    0.6.2
 */