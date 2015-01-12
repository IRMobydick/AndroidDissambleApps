package com.ubercab.client.feature.trip.address;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.ui.AnimationListenerAdapter;
import com.ubercab.client.core.ui.CustomTypefaceSpan;
import com.ubercab.client.core.util.CharacterUtils;
import com.ubercab.library.util.LocationUtils;
import com.ubercab.ui.FontUtils;
import com.ubercab.ui.UberTextView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public class AddressView extends LinearLayout
{
  private static final int ALPHA_GONE = 0;
  private static final int ALPHA_VISIBLE = 255;
  public static final int MODE_BG_SPLIT = 1;
  public static final int MODE_BG_STANDALONE = 0;
  public static final int MODE_ICON_DOT = 1;
  public static final int MODE_ICON_LINKED = 2;
  public static final int MODE_ICON_SEARCH;
  private int mAlphaBg = 255;
  private ValueAnimator mAnimatorFadeIn;
  private ValueAnimator mAnimatorFadeOut;
  private int mBackgroundSplitResource;
  private Animation mErrorAnimation;
  private int mIconDotResource;
  private int mIconDotSplitResource;
  private int mIconSearchResource;

  @InjectView(2131427850)
  ImageButton mImageButtonAdd;

  @InjectView(2131427849)
  ImageButton mImageButtonClear;
  private RiderLocation mLocation;
  private List<OnClickAddListener> mOnClickAddListeners = new CopyOnWriteArrayList();
  private List<OnClickClearListener> mOnClickClearListeners = new CopyOnWriteArrayList();
  private ColorStateList mOriginalHintTextColor;

  @Inject
  RiderPreferences mRiderPreferences;

  @InjectView(2131427820)
  AddressTextView mTextViewAddress;

  @InjectView(2131427819)
  UberTextView mTextViewLabel;

  @InjectView(2131427851)
  UberTextView mTextViewSubtext;

  @InjectView(2131427818)
  View mViewIcon;

  public AddressView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AddressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AddressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      RiderApplication.get(paramContext).inject(this);
  }

  private Spannable getBoldSpannable(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new CustomTypefaceSpan(getContext(), FontUtils.getTypefaceFromResource(getContext(), 2131559276)), 0, localSpannableString.length(), 17);
    return localSpannableString;
  }

  private String getLocationLabel(RiderLocation paramRiderLocation)
  {
    for (String str : LocationSearchResult.HOME_WORK_TAGS)
    {
      LocationSearchResult localLocationSearchResult = this.mRiderPreferences.getFavoriteLocation(str);
      if ((localLocationSearchResult != null) && (LocationUtils.equalWithinPrecision(localLocationSearchResult.getUberLatLng(), paramRiderLocation.getUberLatLng())))
        return str;
    }
    return null;
  }

  public void addOnClickAddListener(OnClickAddListener paramOnClickAddListener)
  {
    this.mOnClickAddListeners.add(paramOnClickAddListener);
  }

  public void addOnClickClearListener(OnClickClearListener paramOnClickClearListener)
  {
    this.mOnClickClearListeners.add(paramOnClickClearListener);
  }

  public void fadeIn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      animate().alpha(1.0F).start();
      return;
    }
    setAlpha(1.0F);
  }

  public void fadeOut(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      animate().alpha(0.0F).start();
      return;
    }
    setAlpha(0.0F);
  }

  public RiderLocation getLocation()
  {
    return this.mLocation;
  }

  public void hideBackground(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mAnimatorFadeIn.cancel();
      this.mAnimatorFadeOut.cancel();
      getBackground().setAlpha(0);
      this.mAlphaBg = 0;
    }
    do
    {
      return;
      if (this.mAnimatorFadeIn.isRunning())
      {
        this.mAnimatorFadeIn.reverse();
        return;
      }
    }
    while (this.mAlphaBg <= 0);
    ValueAnimator localValueAnimator = this.mAnimatorFadeOut;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.mAlphaBg;
    arrayOfInt[1] = 0;
    localValueAnimator.setIntValues(arrayOfInt);
    this.mAnimatorFadeOut.start();
  }

  public boolean locationEquals(RiderLocation paramRiderLocation)
  {
    if (this.mLocation != null)
      return this.mLocation.equals(paramRiderLocation);
    return paramRiderLocation == null;
  }

  @OnClick({2131427850})
  public void onClickAdd()
  {
    Iterator localIterator = this.mOnClickAddListeners.iterator();
    while (localIterator.hasNext())
      ((OnClickAddListener)localIterator.next()).onClickAdd(this);
  }

  @OnClick({2131427849})
  public void onClickClear()
  {
    Iterator localIterator = this.mOnClickClearListeners.iterator();
    while (localIterator.hasNext())
      ((OnClickClearListener)localIterator.next()).onClickClear(this);
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
    this.mIconSearchResource = 2130837784;
    this.mAnimatorFadeIn = ObjectAnimator.ofInt(getBackground(), "alpha", new int[] { 0, 255 });
    this.mAnimatorFadeOut = ObjectAnimator.ofInt(getBackground(), "alpha", new int[] { 255, 0 });
    this.mAnimatorFadeIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AddressView.access$002(AddressView.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
    this.mAnimatorFadeOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AddressView.access$002(AddressView.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
  }

  public void removeOnClickAddListener(OnClickAddListener paramOnClickAddListener)
  {
    this.mOnClickAddListeners.remove(paramOnClickAddListener);
  }

  public void removeOnClickClearListener(OnClickClearListener paramOnClickClearListener)
  {
    this.mOnClickClearListeners.remove(paramOnClickClearListener);
  }

  public void setAddButtonVisibility(int paramInt)
  {
    this.mImageButtonAdd.setVisibility(paramInt);
  }

  public void setBackgroundMode(int paramInt)
  {
    if (paramInt == 1)
      setBackgroundResource(this.mBackgroundSplitResource);
    while (true)
    {
      Drawable localDrawable = getBackground();
      localDrawable.setAlpha(this.mAlphaBg);
      this.mAnimatorFadeIn.setTarget(localDrawable);
      this.mAnimatorFadeOut.setTarget(localDrawable);
      return;
      setBackgroundResource(2130837684);
    }
  }

  public void setBackgroundSplitResource(int paramInt)
  {
    this.mBackgroundSplitResource = paramInt;
  }

  public void setClearButtonVisibility(int paramInt)
  {
    this.mImageButtonClear.setVisibility(paramInt);
  }

  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    this.mTextViewAddress.setEditable(paramBoolean);
  }

  public void setHintText(String paramString)
  {
    this.mTextViewAddress.setHint(paramString);
  }

  public void setHintTextColor(int paramInt)
  {
    this.mTextViewAddress.setHintTextColor(paramInt);
  }

  public void setIconDotResource(int paramInt)
  {
    this.mIconDotResource = paramInt;
  }

  public void setIconDotSplitResource(int paramInt)
  {
    this.mIconDotSplitResource = paramInt;
  }

  public void setIconMode(int paramInt)
  {
    switch (paramInt)
    {
    default:
      this.mViewIcon.setBackgroundResource(this.mIconSearchResource);
      return;
    case 1:
      this.mViewIcon.setBackgroundResource(this.mIconDotResource);
      return;
    case 2:
    }
    this.mViewIcon.setBackgroundResource(this.mIconDotSplitResource);
  }

  public void setLabelText(String paramString)
  {
    this.mTextViewLabel.setText(paramString);
  }

  public void setLabelTextColor(int paramInt)
  {
    this.mTextViewLabel.setTextColor(paramInt);
  }

  public void setLabelVisibility(int paramInt)
  {
    this.mTextViewLabel.setVisibility(paramInt);
  }

  public void setLocation(RiderLocation paramRiderLocation)
  {
    this.mLocation = paramRiderLocation;
    if (this.mLocation == null)
    {
      this.mTextViewAddress.setAddressText("");
      return;
    }
    String str1 = getLocationLabel(paramRiderLocation);
    if (!TextUtils.isEmpty(str1))
    {
      boolean bool = LocationSearchResult.isTagHome(str1);
      String str4;
      AddressTextView localAddressTextView;
      if (bool)
      {
        str4 = getResources().getString(2131558891);
        this.mTextViewAddress.setAddressText(CharacterUtils.capitalizeFirstLetter(str4));
        localAddressTextView = this.mTextViewAddress;
        if (!bool)
          break label110;
      }
      label110: for (int i = 2130837762; ; i = 2130837773)
      {
        localAddressTextView.setLeftDrawable(i);
        return;
        str4 = getResources().getString(2131559348);
        break;
      }
    }
    String str2 = paramRiderLocation.getNickname();
    String str3 = paramRiderLocation.getDisplayAddressDescription();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(str2))
    {
      localSpannableStringBuilder.append(getBoldSpannable(str2));
      localSpannableStringBuilder.append(" ");
    }
    if ((TextUtils.isEmpty(str2)) || (!str3.startsWith(str2)))
      localSpannableStringBuilder.append(str3);
    this.mTextViewAddress.clearLeftDrawable();
    this.mTextViewAddress.setAddressText(localSpannableStringBuilder);
  }

  public void setSubtextText(String paramString)
  {
    this.mTextViewSubtext.setText(paramString);
  }

  public void setSubtextVisibility(int paramInt)
  {
    this.mTextViewSubtext.setVisibility(paramInt);
  }

  public void showBackground(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mAnimatorFadeIn.cancel();
      this.mAnimatorFadeOut.cancel();
      getBackground().setAlpha(255);
      this.mAlphaBg = 255;
    }
    do
    {
      return;
      if (this.mAnimatorFadeOut.isRunning())
      {
        this.mAnimatorFadeOut.reverse();
        return;
      }
    }
    while (this.mAlphaBg >= 255);
    ValueAnimator localValueAnimator = this.mAnimatorFadeIn;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.mAlphaBg;
    arrayOfInt[1] = 255;
    localValueAnimator.setIntValues(arrayOfInt);
    this.mAnimatorFadeIn.start();
  }

  public void showError()
  {
    if (this.mErrorAnimation != null)
      this.mErrorAnimation.cancel();
    this.mErrorAnimation = AnimationUtils.loadAnimation(getContext(), 2130968582);
    this.mErrorAnimation.setAnimationListener(new AnimationListenerAdapter()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AddressView.this.mTextViewAddress.setHintTextColor(AddressView.this.mOriginalHintTextColor);
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AddressView.access$102(AddressView.this, AddressView.this.mTextViewAddress.getHintTextColors());
        AddressView.this.mTextViewAddress.setHintTextColor(AddressView.this.getResources().getColor(2131296325));
      }
    });
    this.mTextViewAddress.startAnimation(this.mErrorAnimation);
  }

  public static abstract interface OnClickAddListener
  {
    public abstract void onClickAdd(AddressView paramAddressView);
  }

  public static abstract interface OnClickClearListener
  {
    public abstract void onClickClear(AddressView paramAddressView);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.address.AddressView
 * JD-Core Version:    0.6.2
 */