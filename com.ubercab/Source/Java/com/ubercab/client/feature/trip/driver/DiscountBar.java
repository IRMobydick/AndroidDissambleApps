package com.ubercab.client.feature.trip.driver;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher.ViewFactory;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripEntity;
import com.ubercab.client.core.model.TripLeg;
import com.ubercab.client.core.model.TripLegAction;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.util.TextMarkupUtils;
import com.ubercab.client.feature.trip.driver.animation.DiscountProgressAnimView;
import com.ubercab.common.base.Objects;
import com.ubercab.ui.FontUtils;
import com.ubercab.ui.UberTextView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import timber.log.Timber;

public class DiscountBar extends RelativeLayout
{
  private static final int ANIM_POSITION = 0;
  private static final int CHECK_ANIMATION_DURATION = 1600;
  private static final int INITIAL_DISCOUNT = 20;
  private static final String MARKUP_TOKEN = "**";
  private static final int PEOPLE_ICON_POSITION = 1;

  @InjectView(2131427882)
  TextView mDiscountTextView;

  @InjectView(2131427878)
  ImageView mPeopleIcon;
  private String mPreviousState;

  @InjectView(2131427879)
  TextSwitcher mTextSwitcher;

  @InjectView(2131427877)
  DiscountProgressAnimView mUberPoolMatchAnimationView;
  private ViewSwitcher.ViewFactory mViewFactory;

  @InjectView(2131427876)
  ViewFlipper mViewFlipper;

  public DiscountBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public DiscountBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DiscountBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void animateMainText(String paramString)
  {
    this.mTextSwitcher.setText(TextMarkupUtils.parseMarkup(paramString, 2131296329));
  }

  private void animatePeopleIcon()
  {
    this.mPeopleIcon.setScaleX(0.0F);
    this.mPeopleIcon.setScaleY(0.0F);
    this.mPeopleIcon.setAlpha(0.0F);
    showPeopleIcon();
    this.mPeopleIcon.animate().setInterpolator(new OvershootInterpolator(1.0F)).alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(getResources().getInteger(2131492872)).start();
  }

  private TripEntity getOtherUser(Ping paramPing)
  {
    Client localClient = paramPing.getClient();
    Iterator localIterator = paramPing.getTrip().getEntities().values().iterator();
    while (localIterator.hasNext())
    {
      TripEntity localTripEntity = (TripEntity)localIterator.next();
      if (!Objects.equal(localTripEntity.getUuid(), localClient.getUuid()))
        return localTripEntity;
    }
    return null;
  }

  private String getSwitcherText()
  {
    return ((TextView)this.mTextSwitcher.getCurrentView()).getText().toString();
  }

  private void initTextSwitcher()
  {
    this.mTextSwitcher.setFactory(this.mViewFactory);
    this.mTextSwitcher.setInAnimation(AnimationUtils.loadAnimation(getContext(), 2130968590));
    this.mTextSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getContext(), 2130968591));
  }

  private void initUIWithoutAnimations(DiscountBarSavedState paramDiscountBarSavedState)
  {
    this.mPreviousState = paramDiscountBarSavedState.getCurrentState();
    if (paramDiscountBarSavedState.getCurrentIconPosition() > 0)
      showPeopleIcon();
    while (true)
    {
      setMainTextWithoutAnimationAndMarkup(paramDiscountBarSavedState.getCurrentMainText());
      this.mDiscountTextView.setText(paramDiscountBarSavedState.getCurrentDiscountText());
      return;
      showPulseAnimation();
    }
  }

  private void initViewFactory()
  {
    this.mViewFactory = new ViewSwitcher.ViewFactory()
    {
      public View makeView()
      {
        UberTextView localUberTextView = new UberTextView(DiscountBar.this.getContext());
        localUberTextView.setEllipsize(TextUtils.TruncateAt.END);
        localUberTextView.setSingleLine();
        localUberTextView.setTextSize(2, 12.0F);
        localUberTextView.setTextColor(DiscountBar.this.getResources().getColor(2131296330));
        localUberTextView.setGravity(17);
        localUberTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        FontUtils.applyFontToTextView(DiscountBar.this.getContext(), localUberTextView, 2131559279);
        return localUberTextView;
      }
    };
  }

  private boolean isFinalDropOffLeg(Ping paramPing)
  {
    Trip localTrip = paramPing.getTrip();
    Set localSet = localTrip.getEntities().keySet();
    List localList = localTrip.getLegs();
    Iterator localIterator1 = ((TripLeg)localList.get(localTrip.getCurrentLeg().intValue())).getActions().iterator();
    while (localIterator1.hasNext())
    {
      TripLegAction localTripLegAction1 = (TripLegAction)localIterator1.next();
      if ((localTripLegAction1.getEntityRef().equals(paramPing.getClient().getUuid())) && (localTripLegAction1.getType().equals("Dropoff")))
      {
        for (int i = 0; i < localTrip.getCurrentLeg().intValue(); i++)
        {
          Iterator localIterator2 = ((TripLeg)localList.get(i)).getActions().iterator();
          while (localIterator2.hasNext())
          {
            TripLegAction localTripLegAction2 = (TripLegAction)localIterator2.next();
            if (localTripLegAction2.getType().equals("Dropoff"))
              localSet.remove(localTripLegAction2.getEntityRef());
          }
        }
        return localSet.size() == 1;
      }
    }
    return false;
  }

  private void runMatchFoundStepOne(String paramString1, final String paramString2)
  {
    final int i;
    Object[] arrayOfObject;
    try
    {
      i = Integer.parseInt(paramString1);
      int j = 20;
      arrayOfObject = new Object[i - j];
      int m;
      for (int k = 0; j < i; k = m)
      {
        m = k + 1;
        j++;
        arrayOfObject[k] = Integer.toString(j);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Timber.e("Promo discount failed to parse", new Object[] { localNumberFormatException });
      runMatchFoundStepTwo(paramString2);
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(new AnimatedTextView(this.mDiscountTextView), "Text", new TypeEvaluator()
    {
      public String evaluate(float paramAnonymousFloat, String paramAnonymousString1, String paramAnonymousString2)
      {
        if (paramAnonymousFloat < 0.5D)
          return paramAnonymousString1;
        return paramAnonymousString2;
      }
    }
    , arrayOfObject).setDuration(2 * getResources().getInteger(2131492870));
    localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!Integer.toString(i).equals(DiscountBar.this.mDiscountTextView.getText()))
          DiscountBar.this.mDiscountTextView.setText(Integer.toString(i));
        DiscountBar.this.runMatchFoundStepTwo(paramString2);
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
    localObjectAnimator.start();
  }

  private void runMatchFoundStepTwo(final String paramString)
  {
    showCheckOutAnimation();
    postDelayed(new Runnable()
    {
      public void run()
      {
        DiscountBar.this.animatePeopleIcon();
        DiscountBar localDiscountBar = DiscountBar.this;
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = "**";
        arrayOfObject[1] = DiscountBar.this.getResources().getString(2131559317);
        arrayOfObject[2] = "**";
        arrayOfObject[3] = paramString;
        localDiscountBar.animateMainText(String.format("%S%S%S %S", arrayOfObject));
      }
    }
    , 1600L);
  }

  private void setMainTextWithoutAnimationAndMarkup(String paramString)
  {
    this.mTextSwitcher.setCurrentText(paramString);
  }

  private void showCheckInAnimation()
  {
    this.mViewFlipper.setDisplayedChild(0);
    this.mUberPoolMatchAnimationView.startCheckInAnimation();
  }

  private void showCheckOutAnimation()
  {
    this.mViewFlipper.setDisplayedChild(0);
    this.mUberPoolMatchAnimationView.startCheckOutAnimation();
  }

  private void showMatchFoundState(final String paramString1, final String paramString2)
  {
    showCheckInAnimation();
    animateMainText(getResources().getString(2131559313));
    postDelayed(new Runnable()
    {
      public void run()
      {
        DiscountBar.this.runMatchFoundStepOne(paramString2, paramString1);
      }
    }
    , 1600L);
  }

  private void showMatchNotFoundState()
  {
    animatePeopleIcon();
    animateMainText(getResources().getString(2131559312));
  }

  private void showMatchingState(String paramString)
  {
    showPulseAnimation();
    animateMainText(getResources().getString(2131559314));
    this.mDiscountTextView.setText(paramString);
  }

  private void showPeopleIcon()
  {
    this.mViewFlipper.setDisplayedChild(1);
  }

  private void showPulseAnimation()
  {
    this.mViewFlipper.setDisplayedChild(0);
    this.mUberPoolMatchAnimationView.startPulseAnimation();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
    initViewFactory();
    initTextSwitcher();
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    DiscountBarSavedState localDiscountBarSavedState = (DiscountBarSavedState)paramParcelable;
    super.onRestoreInstanceState(localDiscountBarSavedState.getSuperState());
    initUIWithoutAnimations(localDiscountBarSavedState);
  }

  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    String str = this.mPreviousState;
    if (this.mViewFlipper.getDisplayedChild() == 0);
    for (int i = 0; ; i = 3)
      return new DiscountBarSavedState(localParcelable, str, i, getSwitcherText(), this.mDiscountTextView.getText().toString());
  }

  void update(Ping paramPing)
  {
    if ((!PingUtils.hasTripEntities(paramPing)) || (!PingUtils.hasTripExtraStates(paramPing)))
      setVisibility(8);
    Map localMap1;
    do
    {
      do
      {
        return;
        setVisibility(0);
        localMap1 = paramPing.getTrip().getExtraStates();
        if (!localMap1.containsKey("UberPoolNotMatched"))
          break;
      }
      while ((this.mPreviousState != null) && (this.mPreviousState.equals("UberPoolNotMatched")));
      showMatchNotFoundState();
      this.mPreviousState = "UberPoolNotMatched";
      return;
      if (localMap1.containsKey("UberPoolMatched"))
      {
        Map localMap2 = (Map)localMap1.get("UberPoolMatched");
        String str1 = getSwitcherText();
        String str2 = getResources().getString(2131559312);
        if ((!str1.equals(str2)) && (isFinalDropOffLeg(paramPing)))
        {
          showPeopleIcon();
          this.mDiscountTextView.setText((CharSequence)localMap2.get("promoString"));
          animateMainText(str2);
        }
        while (true)
        {
          this.mPreviousState = "UberPoolMatched";
          return;
          if ((this.mPreviousState == null) || (!this.mPreviousState.equals("UberPoolMatched")))
          {
            TripEntity localTripEntity = getOtherUser(paramPing);
            if ((localMap2.containsKey("promoString")) && (localTripEntity != null))
              showMatchFoundState(localTripEntity.getTitle(), (String)localMap2.get("promoString"));
          }
        }
      }
    }
    while ((!localMap1.containsKey("UberPoolMatching")) || ((this.mPreviousState != null) && (this.mPreviousState.equals("UberPoolMatching"))));
    showMatchingState((String)((Map)localMap1.get("UberPoolMatching")).get("promoString"));
    this.mPreviousState = "UberPoolMatching";
  }

  private static class AnimatedTextView
  {
    private final TextView textView;

    public AnimatedTextView(TextView paramTextView)
    {
      this.textView = paramTextView;
    }

    public String getText()
    {
      return this.textView.getText().toString();
    }

    public void setText(String paramString)
    {
      this.textView.setText(paramString);
    }
  }

  private static class DiscountBarSavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<DiscountBarSavedState> CREATOR = new Parcelable.Creator()
    {
      public DiscountBar.DiscountBarSavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new DiscountBar.DiscountBarSavedState(paramAnonymousParcel);
      }

      public DiscountBar.DiscountBarSavedState[] newArray(int paramAnonymousInt)
      {
        return new DiscountBar.DiscountBarSavedState[paramAnonymousInt];
      }
    };
    private final String mCurrentDiscountText;
    private final int mCurrentIconPosition;
    private final String mCurrentMainText;
    private final String mCurrentState;

    protected DiscountBarSavedState(Parcel paramParcel)
    {
      super();
      this.mCurrentState = paramParcel.readString();
      this.mCurrentIconPosition = paramParcel.readInt();
      this.mCurrentMainText = paramParcel.readString();
      this.mCurrentDiscountText = paramParcel.readString();
    }

    protected DiscountBarSavedState(Parcelable paramParcelable, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      super();
      this.mCurrentState = paramString1;
      this.mCurrentIconPosition = paramInt;
      this.mCurrentMainText = paramString2;
      this.mCurrentDiscountText = paramString3;
    }

    public String getCurrentDiscountText()
    {
      return this.mCurrentDiscountText;
    }

    public int getCurrentIconPosition()
    {
      return this.mCurrentIconPosition;
    }

    public String getCurrentMainText()
    {
      return this.mCurrentMainText;
    }

    public String getCurrentState()
    {
      return this.mCurrentState;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.mCurrentState);
      paramParcel.writeInt(this.mCurrentIconPosition);
      paramParcel.writeString(this.mCurrentMainText);
      paramParcel.writeString(this.mCurrentDiscountText);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.driver.DiscountBar
 * JD-Core Version:    0.6.2
 */