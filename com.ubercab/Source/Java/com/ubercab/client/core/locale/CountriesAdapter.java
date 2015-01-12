package com.ubercab.client.core.locale;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ubercab.client.core.util.CountryFlagUtil;
import com.ubercab.client.core.util.CountryFlagUtil.AllFlagListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class CountriesAdapter extends BaseAdapter
  implements CountryFlagUtil.AllFlagListener
{
  private Context mContext;
  private List<String> mCountryIso2s;
  private List<String> mCountryNames;
  private Map<String, Drawable> mFlags;

  CountriesAdapter(Context paramContext, Countries paramCountries)
  {
    this.mContext = paramContext;
    Map localMap = paramCountries.getCountryNames();
    this.mCountryIso2s = new ArrayList(localMap.values());
    this.mCountryNames = new ArrayList(localMap.keySet());
    prependCurrentCountry(paramCountries);
    CountryFlagUtil.loadAllFlags(this.mContext, this);
  }

  private void prependCurrentCountry(Countries paramCountries)
  {
    String str1 = Locale.getDefault().getCountry();
    String str2 = paramCountries.getCountryName(str1);
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      return;
    this.mCountryIso2s.add(0, str1.toLowerCase(Locale.US));
    this.mCountryNames.add(0, str2);
  }

  public int getCount()
  {
    return this.mCountryIso2s.size();
  }

  String getCountryIso2(int paramInt)
  {
    return (String)this.mCountryIso2s.get(paramInt);
  }

  String getCountryName(int paramInt)
  {
    return (String)this.mCountryNames.get(paramInt);
  }

  public Object getItem(int paramInt)
  {
    return this.mCountryIso2s.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = LayoutInflater.from(this.mContext).inflate(2130903074, paramViewGroup, false);
    String str1 = getCountryIso2(paramInt);
    String str2 = getCountryName(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131427428);
    localTextView.setText(str2);
    localTextView.setTag(str1);
    if ((this.mFlags != null) && (this.mFlags.containsKey(str1)))
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.mFlags.get(str1), null, null, null);
      return paramView;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    return paramView;
  }

  public boolean isEmpty()
  {
    return (super.isEmpty()) || (this.mFlags == null);
  }

  public void onFlagsLoaded(Map<String, Drawable> paramMap)
  {
    this.mFlags = paramMap;
    notifyDataSetChanged();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.locale.CountriesAdapter
 * JD-Core Version:    0.6.2
 */