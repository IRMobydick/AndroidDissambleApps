package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.util.AttributeSet;

public class ContentLoadingSmoothProgressBar extends SmoothProgressBar
{
  private static final int MIN_DELAY = 500;
  private static final int MIN_SHOW_TIME = 500;
  private final Runnable mDelayedHide = new Runnable()
  {
    public void run()
    {
      ContentLoadingSmoothProgressBar.access$002(ContentLoadingSmoothProgressBar.this, false);
      ContentLoadingSmoothProgressBar.access$102(ContentLoadingSmoothProgressBar.this, -1L);
      ContentLoadingSmoothProgressBar.this.setVisibility(8);
    }
  };
  private final Runnable mDelayedShow = new Runnable()
  {
    public void run()
    {
      ContentLoadingSmoothProgressBar.access$202(ContentLoadingSmoothProgressBar.this, false);
      if (!ContentLoadingSmoothProgressBar.this.mDismissed)
      {
        ContentLoadingSmoothProgressBar.access$102(ContentLoadingSmoothProgressBar.this, System.currentTimeMillis());
        ContentLoadingSmoothProgressBar.this.setVisibility(0);
      }
    }
  };
  private boolean mDismissed = false;
  private boolean mPostedHide = false;
  private boolean mPostedShow = false;
  private long mStartTime = -1L;

  public ContentLoadingSmoothProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public ContentLoadingSmoothProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }

  private void removeCallbacks()
  {
    removeCallbacks(this.mDelayedHide);
    removeCallbacks(this.mDelayedShow);
  }

  public void hide()
  {
    this.mDismissed = true;
    removeCallbacks(this.mDelayedShow);
    long l = System.currentTimeMillis() - this.mStartTime;
    if ((l >= 500L) || (this.mStartTime == -1L))
      setVisibility(8);
    while (this.mPostedHide)
      return;
    postDelayed(this.mDelayedHide, 500L - l);
    this.mPostedHide = true;
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks();
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks();
  }

  public void show()
  {
    this.mStartTime = -1L;
    this.mDismissed = false;
    removeCallbacks(this.mDelayedHide);
    if (!this.mPostedShow)
    {
      postDelayed(this.mDelayedShow, 500L);
      this.mPostedShow = true;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     fr.castorflex.android.smoothprogressbar.ContentLoadingSmoothProgressBar
 * JD-Core Version:    0.6.2
 */