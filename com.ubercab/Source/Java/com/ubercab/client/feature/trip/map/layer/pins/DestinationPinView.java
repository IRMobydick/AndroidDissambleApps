package com.ubercab.client.feature.trip.map.layer.pins;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.util.TextMarkupUtils;
import com.ubercab.ui.UberTextView;

public class DestinationPinView extends LinearLayout
{

  @InjectView(2131427501)
  UberTextView mTextViewEstimate;

  @InjectView(2131427500)
  UberTextView mTextViewTagline;

  @InjectView(2131427499)
  ViewGroup mViewGroupPopup;

  public DestinationPinView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DestinationPinView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DestinationPinView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  Bitmap getBitmap()
  {
    measure(-2, -2);
    Bitmap localBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    draw(localCanvas);
    return localBitmap;
  }

  String getEstimateText()
  {
    return this.mTextViewEstimate.getText().toString();
  }

  boolean hasFareEstimate()
  {
    return this.mViewGroupPopup.getVisibility() == 0;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }

  void setEstimateText(String paramString)
  {
    this.mTextViewEstimate.setText(paramString);
  }

  void setTaglineText(String paramString)
  {
    this.mTextViewTagline.setText(TextMarkupUtils.parseMarkup(paramString, getResources().getColor(2131296329)));
  }

  void updateUI(int paramInt)
  {
    int i = 8;
    if (paramInt != 1)
    {
      this.mViewGroupPopup.setVisibility(i);
      return;
    }
    UberTextView localUberTextView = this.mTextViewTagline;
    int j;
    ViewGroup localViewGroup;
    if (TextUtils.isEmpty(this.mTextViewTagline.getText()))
    {
      j = i;
      localUberTextView.setVisibility(j);
      localViewGroup = this.mViewGroupPopup;
      if (!TextUtils.isEmpty(this.mTextViewEstimate.getText()))
        break label76;
    }
    while (true)
    {
      localViewGroup.setVisibility(i);
      return;
      j = 0;
      break;
      label76: i = 0;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.pins.DestinationPinView
 * JD-Core Version:    0.6.2
 */