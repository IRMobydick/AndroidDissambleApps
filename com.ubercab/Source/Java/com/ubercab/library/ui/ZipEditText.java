package com.ubercab.library.ui;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberEditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipEditText extends UberEditText
{
  private static final int LENGTH_US_ZIP = 5;
  private static final Pattern PATTERN_US_ZIP = Pattern.compile("^\\d{5}$");
  private static final String US_ISO2 = "US";
  private static final ImmutableList<String> VALID_ISO2_FOR_ZIP = ImmutableList.of("US", "CA", "GB");
  private String mCountryIso2;
  private boolean mIsValid;
  private Listener mListener;

  public ZipEditText(Context paramContext)
  {
    this(paramContext, null);
  }

  public ZipEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }

  public ZipEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSingleLine();
    addTextChangedListener(new ZipTextWatcher(null));
  }

  private void changeVisibilityByCountry()
  {
    if ((!TextUtils.isEmpty(this.mCountryIso2)) && (VALID_ISO2_FOR_ZIP.contains(this.mCountryIso2.toUpperCase())))
    {
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }

  private void validate()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.mCountryIso2)) && (VALID_ISO2_FOR_ZIP.contains(this.mCountryIso2.toUpperCase())))
      if ("US".equals(this.mCountryIso2))
        bool = PATTERN_US_ZIP.matcher(getText()).matches();
    while (true)
    {
      if (bool != this.mIsValid)
      {
        this.mIsValid = bool;
        if (this.mListener != null)
          this.mListener.onZipChanged(this.mIsValid);
      }
      return;
      if (getText().length() > 0);
      for (bool = true; ; bool = false)
        break;
      bool = true;
    }
  }

  public String getCountryIso2()
  {
    return this.mCountryIso2;
  }

  public boolean isValid()
  {
    return this.mIsValid;
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    setCountry(localSavedState.mCountryIso2);
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SavedState.access$102(localSavedState, this.mCountryIso2);
    return localSavedState;
  }

  public void setCountry(String paramString)
  {
    this.mCountryIso2 = paramString;
    if ("US".equalsIgnoreCase(this.mCountryIso2))
    {
      setInputType(2);
      InputFilter[] arrayOfInputFilter = new InputFilter[1];
      arrayOfInputFilter[0] = new InputFilter.LengthFilter(5);
      setFilters(arrayOfInputFilter);
    }
    while (true)
    {
      validate();
      changeVisibilityByCountry();
      return;
      setInputType(1);
      setFilters(new InputFilter[0]);
    }
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
    setText(getText());
  }

  public static abstract interface Listener
  {
    public abstract void onZipChanged(boolean paramBoolean);
  }

  public static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ZipEditText.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ZipEditText.SavedState(paramAnonymousParcel);
      }

      public ZipEditText.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ZipEditText.SavedState[paramAnonymousInt];
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

  private class ZipTextWatcher extends TextWatcherAdapter
  {
    private ZipTextWatcher()
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      ZipEditText.this.validate();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.ui.ZipEditText
 * JD-Core Version:    0.6.2
 */