package com.ubercab.client.feature.onboarding;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ubercab.ui.FontUtils;
import com.ubercab.ui.UberTextView;

class HeadlinePagerAdapter extends CircularPagerAdapter
{
  private static final int NUM_HEADLINES = 4;
  private Context mContext;

  HeadlinePagerAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private String getLocalizedHeading(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return this.mContext.getString(2131559106);
    case 1:
      return this.mContext.getString(2131559024);
    case 2:
      return this.mContext.getString(2131558938);
    case 3:
    }
    return this.mContext.getString(2131558923);
  }

  private String getLocalizedSubHeading(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
    }
    return this.mContext.getString(2131558935);
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130903119, null);
    int i = paramInt % 4;
    UberTextView localUberTextView1 = (UberTextView)localViewGroup.findViewById(2131427545);
    FontUtils.applyFontToTextView(this.mContext, localUberTextView1, 2131559282);
    localUberTextView1.setText(getLocalizedHeading(i).toUpperCase());
    String str = getLocalizedSubHeading(i);
    if (!TextUtils.isEmpty(str))
    {
      UberTextView localUberTextView2 = (UberTextView)localViewGroup.findViewById(2131427546);
      FontUtils.applyFontToTextView(this.mContext, localUberTextView2, 2131559281);
      localUberTextView2.setText(str.toUpperCase());
      localUberTextView2.setVisibility(0);
    }
    paramViewGroup.addView(localViewGroup);
    return localViewGroup;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.HeadlinePagerAdapter
 * JD-Core Version:    0.6.2
 */