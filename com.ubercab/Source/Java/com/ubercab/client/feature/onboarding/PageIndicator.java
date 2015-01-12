package com.ubercab.client.feature.onboarding;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

public class PageIndicator extends LinearLayout
{
  private Context mContext;
  private int mCount;
  private final List<ImageView> mDots = new LinkedList();
  private Bitmap mOff;
  private Bitmap mOn;
  private int mSelected;

  public PageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.mOn = BitmapFactory.decodeResource(getResources(), 2130837828);
    this.mOff = BitmapFactory.decodeResource(getResources(), 2130837827);
  }

  private void addDotAt(int paramInt, boolean paramBoolean, LayoutInflater paramLayoutInflater)
  {
    ImageView localImageView = (ImageView)paramLayoutInflater.inflate(2130903117, null);
    if (paramBoolean)
      localImageView.setImageBitmap(this.mOn);
    addView(localImageView);
    this.mDots.add(paramInt, localImageView);
  }

  private void setDotAt(int paramInt)
  {
    int i = 0;
    if (i < this.mCount)
    {
      ImageView localImageView = (ImageView)this.mDots.get(i);
      if (i == paramInt);
      for (Bitmap localBitmap = this.mOn; ; localBitmap = this.mOff)
      {
        localImageView.setImageBitmap(localBitmap);
        i++;
        break;
      }
    }
  }

  private void show()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    int i = 0;
    if (i < this.mCount)
    {
      if (this.mSelected == i);
      for (boolean bool = true; ; bool = false)
      {
        addDotAt(i, bool, localLayoutInflater);
        i++;
        break;
      }
    }
  }

  void setCount(int paramInt)
  {
    this.mCount = paramInt;
    show();
  }

  void setSelected(int paramInt)
  {
    this.mSelected = paramInt;
    setDotAt(paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.PageIndicator
 * JD-Core Version:    0.6.2
 */