package com.ubercab.client.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.ImageButton;
import com.google.gson.Gson;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.locale.Countries;
import com.ubercab.client.core.util.CountryFlagUtil;
import com.ubercab.client.core.util.CountryFlagUtil.FlagListener;
import java.util.Locale;
import javax.inject.Inject;

public class FlagButton extends ImageButton
  implements CountryFlagUtil.FlagListener
{
  private Countries mCountries;
  private String mCountryIso2 = Locale.getDefault().getCountry();

  @Inject
  Gson mGson;

  public FlagButton(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }

  public FlagButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }

  public FlagButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }

  private void init(Context paramContext)
  {
    if (isInEditMode())
      return;
    RiderApplication.get(paramContext).inject(this);
    this.mCountries = new Countries(paramContext);
  }

  public String getCountryIso2()
  {
    return this.mCountryIso2;
  }

  public void onFlagLoaded(Drawable paramDrawable)
  {
    setImageDrawable(paramDrawable);
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    setCountryIso2(localSavedState.mCountryIso2);
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.access$002(localSavedState, this.mCountryIso2);
    return localSavedState;
  }

  public void setCountryIso2(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    this.mCountryIso2 = paramString;
    setContentDescription(this.mCountries.getCountryName(paramString));
    CountryFlagUtil.loadFlag(getContext(), AsyncTask.THREAD_POOL_EXECUTOR, paramString, this);
  }

  public static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public FlagButton.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new FlagButton.SavedState(paramAnonymousParcel);
      }

      public FlagButton.SavedState[] newArray(int paramAnonymousInt)
      {
        return new FlagButton.SavedState[paramAnonymousInt];
      }
    };
    private String mCountryIso2;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.mCountryIso2 = paramParcel.readString();
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.mCountryIso2);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.FlagButton
 * JD-Core Version:    0.6.2
 */