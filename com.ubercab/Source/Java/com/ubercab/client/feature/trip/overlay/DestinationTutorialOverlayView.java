package com.ubercab.client.feature.trip.overlay;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.TripEvent;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.trip.address.AddressView;
import com.ubercab.library.app.UberActivity;
import com.ubercab.ui.UberTextView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public class DestinationTutorialOverlayView extends FrameLayout
  implements View.OnClickListener
{
  private static final int ALPHA_GONE = 0;
  private static final int ALPHA_VISIBLE = 255;

  @InjectView(2131427870)
  AddressView mAddressView;

  @Inject
  AnalyticsManager mAnalyticsManager;
  private ObjectAnimator mAnimatorFadeInBg;

  @InjectView(2131427871)
  CoachMarkPathView mCoachMarkPathView;
  private int mDurationCoachMarkPhaseAnimTime;
  private List<Listener> mListeners = new CopyOnWriteArrayList();

  @Inject
  SessionPreferences mSessionPreferences;

  @InjectView(2131427875)
  UberTextView mTextViewMessage;

  @InjectView(2131427874)
  UberTextView mTextViewTitle;

  @InjectView(2131427872)
  ViewGroup mViewGroupIcon;

  @InjectView(2131427873)
  ViewGroup mViewGroupText;

  public DestinationTutorialOverlayView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DestinationTutorialOverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DestinationTutorialOverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      ((UberActivity)paramContext).inject(this);
  }

  private void dismissTutorial()
  {
    this.mSessionPreferences.setDestinationTutorialDismissed(true);
    setVisibility(8);
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  @OnClick({2131427870})
  public void onAddressClick()
  {
    dismissTutorial();
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickDestinationAddress();
  }

  public void onClick(View paramView)
  {
    dismissTutorial();
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
    setOnClickListener(this);
    this.mAddressView.setLabelVisibility(8);
    this.mAddressView.setIconMode(0);
    this.mAddressView.setBackgroundMode(0);
    Context localContext = getContext();
    this.mAddressView.setHintText(localContext.getString(2131558805));
    this.mTextViewTitle.setText(localContext.getString(2131558808));
    this.mTextViewMessage.setText(localContext.getString(2131558807));
    this.mAnimatorFadeInBg = ObjectAnimator.ofInt(getBackground(), "alpha", new int[] { 0, 255 });
    this.mAnimatorFadeInBg.setDuration(getResources().getInteger(2131492868));
    this.mDurationCoachMarkPhaseAnimTime = getResources().getInteger(2131492869);
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void reveal(int paramInt)
  {
    if ((getVisibility() == 0) || (this.mSessionPreferences.isDestinationTutorialDismissed()))
      return;
    setVisibility(0);
    this.mCoachMarkPathView.reset();
    getBackground().setAlpha(0);
    this.mViewGroupIcon.setAlpha(0.0F);
    this.mViewGroupText.setAlpha(0.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mAddressView.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.mAddressView.setLayoutParams(localLayoutParams);
    this.mAnimatorFadeInBg.start();
    this.mCoachMarkPathView.start();
    this.mViewGroupIcon.animate().alpha(1.0F).setDuration(this.mDurationCoachMarkPhaseAnimTime).setStartDelay(this.mDurationCoachMarkPhaseAnimTime).start();
    this.mViewGroupText.animate().alpha(1.0F).setDuration(this.mDurationCoachMarkPhaseAnimTime).setStartDelay(this.mDurationCoachMarkPhaseAnimTime).start();
    this.mAnalyticsManager.tripEvent().destinationOverlayView();
  }

  public void updateUI(int paramInt)
  {
    if ((paramInt != 2) || (this.mSessionPreferences.isDestinationTutorialDismissed()))
      setVisibility(8);
  }

  public static abstract interface Listener
  {
    public abstract void onClickDestinationAddress();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView
 * JD-Core Version:    0.6.2
 */