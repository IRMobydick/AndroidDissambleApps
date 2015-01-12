package com.ubercab.client.feature.trip.rates;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.ui.CustomTypefaceSpan;
import com.ubercab.ui.FontUtils;
import com.ubercab.ui.UberTextView;

public class RateCardAddressView extends LinearLayout
{
  private String mDefaultHintText;
  private RiderLocation mLocation;

  @InjectView(2131427820)
  UberTextView mTextViewAddress;

  public RateCardAddressView(Context paramContext)
  {
    this(paramContext, null);
  }

  public RateCardAddressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public RateCardAddressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private Spannable getBoldSpannable(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new CustomTypefaceSpan(getContext(), FontUtils.getTypefaceFromResource(getContext(), 2131559276)), 0, localSpannableString.length(), 17);
    return localSpannableString;
  }

  public RiderLocation getLocation()
  {
    return this.mLocation;
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
  }

  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
  }

  public void setDefaultHintText(String paramString)
  {
    this.mDefaultHintText = paramString;
  }

  public void setLocation(RiderLocation paramRiderLocation)
  {
    this.mLocation = paramRiderLocation;
    if (this.mLocation == null)
    {
      this.mTextViewAddress.setText("");
      this.mTextViewAddress.setHint(this.mDefaultHintText);
      return;
    }
    String str1 = paramRiderLocation.getNickname();
    String str2 = paramRiderLocation.getDisplayAddressDescription();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(str1))
    {
      localSpannableStringBuilder.append(getBoldSpannable(str1.trim()));
      localSpannableStringBuilder.append(" ");
    }
    if ((TextUtils.isEmpty(str1)) || (!str2.startsWith(str1)))
      localSpannableStringBuilder.append(str2.trim());
    this.mTextViewAddress.setHint("");
    this.mTextViewAddress.setText(localSpannableStringBuilder);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.RateCardAddressView
 * JD-Core Version:    0.6.2
 */