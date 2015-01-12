package com.ubercab.client.feature.trip.overlay;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.address.AddressView;
import com.ubercab.library.app.UberActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public class DispatchDestinationOverlayView extends LinearLayout
{
  private static final int ALPHA_GONE = 0;
  private static final int ALPHA_VISIBLE = 255;

  @InjectView(2131427773)
  AddressView mAddressView;
  private ObjectAnimator mAnimatorFadeInBg;
  private List<Listener> mListeners = new CopyOnWriteArrayList();

  @Inject
  RiderPreferences mRiderPreferences;

  @Inject
  SessionPreferences mSessionPreferences;

  @Inject
  TripUIStateManager mTripUIStateManager;

  public DispatchDestinationOverlayView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DispatchDestinationOverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DispatchDestinationOverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      ((UberActivity)paramContext).inject(this);
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  @OnClick({2131427773})
  public void onAddressClick()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickDispatchDestinationAddress();
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
    this.mAddressView.setIconMode(0);
    this.mAddressView.setBackgroundMode(0);
    this.mAddressView.setHintText(getContext().getString(2131558805));
    this.mAnimatorFadeInBg = ObjectAnimator.ofInt(getBackground(), "alpha", new int[] { 0, 255 });
    this.mAnimatorFadeInBg.setDuration(getResources().getInteger(2131492868));
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void reveal(int paramInt)
  {
    if (getVisibility() == 0)
      return;
    getBackground().setAlpha(0);
    this.mAnimatorFadeInBg.start();
    setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mAddressView.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.mAddressView.setLayoutParams(localLayoutParams);
  }

  public void updateUI(int paramInt, boolean paramBoolean)
  {
    if (!this.mTripUIStateManager.isDestinationHighlightEnabledOnDispatch())
      setVisibility(8);
    while ((paramInt == 2) && (!paramBoolean))
      return;
    setVisibility(8);
  }

  public static abstract interface Listener
  {
    public abstract void onClickDispatchDestinationAddress();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView
 * JD-Core Version:    0.6.2
 */