package com.ubercab.client.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import com.google.gson.Gson;
import com.ubercab.client.core.locale.Countries;
import com.ubercab.client.core.util.CountryFlagUtil;
import com.ubercab.client.core.util.CountryFlagUtil.FlagListener;
import com.ubercab.library.app.UberApplication;
import com.ubercab.ui.UberTextView;
import java.util.Locale;
import javax.inject.Inject;

public class CountryButton extends UberTextView
  implements CountryFlagUtil.FlagListener
{
  private Countries mCountries;
  private String mCountryIso2 = Locale.getDefault().getCountry();

  @Inject
  Gson mGson;

  public CountryButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public CountryButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842881);
  }

  public CountryButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusableInTouchMode(false);
    setEllipsize(TextUtils.TruncateAt.END);
    setSingleLine();
    if (!isInEditMode())
    {
      UberApplication.get(paramContext).inject(this);
      this.mCountries = new Countries(paramContext);
    }
  }

  public String getCountryIso2()
  {
    return this.mCountryIso2;
  }

  public void onFlagLoaded(Drawable paramDrawable)
  {
    setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
  }

  public void setCountry(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    this.mCountryIso2 = paramString;
    setText(this.mCountries.getCountryName(paramString));
    CountryFlagUtil.loadFlag(getContext(), AsyncTask.THREAD_POOL_EXECUTOR, paramString, this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.CountryButton
 * JD-Core Version:    0.6.2
 */