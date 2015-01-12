package com.ubercab.client.feature.trip.dispatch;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.library.app.UberActivity;
import com.ubercab.library.ui.AnimatorCancelAdapter;
import com.ubercab.ui.UberTextView;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TitleView extends FrameLayout
{
  private static final int PROGRESS_BAR_MAX_MS = 800;
  private Animator mAnimatorProgressBar;
  private List<Listener> mListeners = new CopyOnWriteArrayList();

  @InjectView(2131427848)
  SmoothProgressBar mProgressBarRequesting;
  private State mState = State.Requesting;

  @InjectView(2131427847)
  UberTextView mTextViewStatus;

  public TitleView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TitleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
      return;
    ((UberActivity)paramContext).inject(this);
  }

  private void updateUI()
  {
    Context localContext = getContext();
    switch (2.$SwitchMap$com$ubercab$client$feature$trip$dispatch$TitleView$State[this.mState.ordinal()])
    {
    default:
      return;
    case 1:
      this.mTextViewStatus.setText(localContext.getString(2131559029));
      this.mProgressBarRequesting.setIndeterminate(true);
      int i = getResources().getColor(2131296333);
      this.mProgressBarRequesting.setSmoothProgressDrawableColor(i);
      return;
    case 2:
      this.mTextViewStatus.setText(localContext.getString(2131558890));
      this.mProgressBarRequesting.setIndeterminate(false);
      this.mProgressBarRequesting.setSmoothProgressDrawableColor(getResources().getColor(2131296325));
      this.mProgressBarRequesting.setProgress(0);
      this.mProgressBarRequesting.setMax(800);
      return;
    case 3:
    }
    this.mTextViewStatus.setText(localContext.getString(2131558472));
    this.mProgressBarRequesting.setIndeterminate(true);
    this.mProgressBarRequesting.setSmoothProgressDrawableColor(getResources().getColor(2131296325));
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
    updateUI();
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void reset()
  {
    this.mState = State.Requesting;
    updateUI();
  }

  public void startCancelAnimation()
  {
    AnimatorCancelAdapter local1 = new AnimatorCancelAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        TitleView localTitleView = TitleView.this;
        if (isCanceled());
        for (TitleView.State localState = TitleView.State.Requesting; ; localState = TitleView.State.Canceled)
        {
          TitleView.access$002(localTitleView, localState);
          TitleView.this.updateUI();
          if (TitleView.this.mState != TitleView.State.Canceled)
            break;
          Iterator localIterator = TitleView.this.mListeners.iterator();
          while (localIterator.hasNext())
            ((TitleView.Listener)localIterator.next()).onCancelAnimationElapsed();
        }
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        TitleView.access$002(TitleView.this, TitleView.State.Canceling);
        TitleView.this.updateUI();
      }
    };
    this.mAnimatorProgressBar = ObjectAnimator.ofInt(this.mProgressBarRequesting, "progress", new int[] { 0, 800 });
    this.mAnimatorProgressBar.setInterpolator(new LinearInterpolator());
    this.mAnimatorProgressBar.setDuration(800L);
    this.mAnimatorProgressBar.addListener(local1);
    this.mAnimatorProgressBar.start();
  }

  public void stopCancelAnimation()
  {
    if ((this.mAnimatorProgressBar != null) && (this.mAnimatorProgressBar.isRunning()))
    {
      this.mAnimatorProgressBar.cancel();
      this.mAnimatorProgressBar = null;
    }
  }

  public static abstract interface Listener
  {
    public abstract void onCancelAnimationElapsed();
  }

  private static enum State
  {
    static
    {
      Canceling = new State("Canceling", 1);
      Canceled = new State("Canceled", 2);
      State[] arrayOfState = new State[3];
      arrayOfState[0] = Requesting;
      arrayOfState[1] = Canceling;
      arrayOfState[2] = Canceled;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.dispatch.TitleView
 * JD-Core Version:    0.6.2
 */