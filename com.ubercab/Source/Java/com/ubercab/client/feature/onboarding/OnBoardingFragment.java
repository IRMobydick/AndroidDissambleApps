package com.ubercab.client.feature.onboarding;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTouch;
import com.ubercab.client.feature.launch.MagicActivity;
import com.ubercab.library.app.UberFragment;
import com.ubercab.ui.FontUtils;

public class OnBoardingFragment extends UberFragment
{
  private static final int PAGE_COUNT = 4;
  private static final long PAGE_DWELL_TIME_MS = 4000L;
  private static final int SCROLL_SPEED_DECREASE_FACTOR = 5;

  @InjectView(2131427544)
  Button mCallToAction;
  private int mCurrentHeadlineItem;
  private int mCurrentScreenshotItem;
  private Handler mHandler;

  @InjectView(2131427541)
  ScrollingViewPager mHeadlinePager;
  private boolean mManualMode;

  @InjectView(2131427540)
  MovableBackgroundLayout mPage;
  private final ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.SimpleOnPageChangeListener()
  {
    private int previousPage;

    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
    {
      int i = paramAnonymousInt1 % 4;
      int j;
      MovableBackgroundLayout localMovableBackgroundLayout;
      if ((this.previousPage == 3) && (i == 3))
      {
        j = 1;
        int k;
        if ((i != 0) && (this.previousPage != 0))
        {
          k = 0;
          if (j == 0);
        }
        else
        {
          k = 1;
        }
        localMovableBackgroundLayout = OnBoardingFragment.this.mPage;
        if (k == 0)
          break label104;
      }
      label104: for (int m = 2130837829; ; m = -1)
      {
        localMovableBackgroundLayout.setBackground(m);
        if (j == 0)
          break label110;
        OnBoardingFragment.this.mPage.setBackgroundLeft(OnBoardingFragment.this.mPage.getWidth() - paramAnonymousInt2);
        return;
        j = 0;
        break;
      }
      label110: if (this.previousPage >= i)
      {
        OnBoardingFragment.this.mPage.setBackgroundLeft(-paramAnonymousInt2);
        return;
      }
      OnBoardingFragment.this.mPage.setBackgroundRight(paramAnonymousInt2);
    }

    public void onPageSelected(int paramAnonymousInt)
    {
      int i = paramAnonymousInt % 4;
      OnBoardingFragment.this.mPageIndicator.setSelected(i);
      this.previousPage = i;
    }
  };

  @InjectView(2131427542)
  PageIndicator mPageIndicator;

  @InjectView(2131427543)
  ScrollingViewPager mScreenshotPager;
  private final Runnable mScrollToNextScreen = new Runnable()
  {
    public void run()
    {
      int i = 1 + OnBoardingFragment.this.mHeadlinePager.getCurrentItem();
      OnBoardingFragment.this.mHeadlinePager.setCurrentItem(i, true);
      int j = 1 + OnBoardingFragment.this.mScreenshotPager.getCurrentItem();
      OnBoardingFragment.this.mScreenshotPager.setCurrentItem(j, true);
      OnBoardingFragment.this.mHandler.postDelayed(this, 4000L);
    }
  };

  private void disableAutomaticScrolling()
  {
    this.mManualMode = true;
    this.mHandler.removeCallbacks(this.mScrollToNextScreen);
    this.mScreenshotPager.resetScrollFactor();
    this.mHeadlinePager.resetScrollFactor();
  }

  private void initPagers()
  {
    View.OnTouchListener local3 = new View.OnTouchListener()
    {
      static final int NUMBER_OF_PAGERS = 2;
      int countdownLatch = 2;

      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        int i = -1 + this.countdownLatch;
        this.countdownLatch = i;
        if (i == 0)
          this.countdownLatch = 2;
        while (true)
        {
          if (!OnBoardingFragment.this.mManualMode)
            OnBoardingFragment.this.disableAutomaticScrolling();
          return false;
          if (paramAnonymousView == OnBoardingFragment.this.mHeadlinePager)
            OnBoardingFragment.this.mScreenshotPager.dispatchTouchEvent(paramAnonymousMotionEvent);
          else if (paramAnonymousView == OnBoardingFragment.this.mScreenshotPager)
            OnBoardingFragment.this.mHeadlinePager.dispatchTouchEvent(paramAnonymousMotionEvent);
        }
      }
    };
    this.mPageIndicator.setCount(4);
    this.mPage.setBackground(2130837829);
    Activity localActivity = getActivity();
    this.mHeadlinePager.setOnTouchListener(local3);
    this.mHeadlinePager.setAdapter(new HeadlinePagerAdapter(localActivity));
    this.mHeadlinePager.setScrollFactor(5);
    this.mScreenshotPager.setOnTouchListener(local3);
    this.mScreenshotPager.setAdapter(new ScreenshotPagerAdapter(localActivity));
    this.mScreenshotPager.setScrollFactor(5);
    this.mScreenshotPager.setPageTransformer(true, new DimmingTransformer());
    this.mScreenshotPager.setOnPageChangeListener(this.mPageChangeListener);
  }

  private void initTryUberForFreeButton()
  {
    FontUtils.applyFontToTextView(getActivity(), this.mCallToAction, 2131559280);
    this.mCallToAction.setText(getString(2131559112).toUpperCase());
  }

  public static Fragment newInstance()
  {
    return new OnBoardingFragment();
  }

  private void restorePagers()
  {
    this.mHeadlinePager.setCurrentItem(this.mCurrentHeadlineItem);
    this.mScreenshotPager.setCurrentItem(this.mCurrentScreenshotItem);
  }

  private void startAutomaticScrolling()
  {
    if (!this.mManualMode)
      this.mHandler.postDelayed(this.mScrollToNextScreen, 4000L);
  }

  @OnClick({2131427544})
  public void onCallToActionClicked()
  {
    Activity localActivity = getActivity();
    startActivity(new Intent(localActivity, MagicActivity.class));
    localActivity.finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mCurrentHeadlineItem = CircularPagerAdapter.midpoint(4);
    this.mCurrentScreenshotItem = CircularPagerAdapter.midpoint(4);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903118, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    initPagers();
    initTryUberForFreeButton();
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @OnTouch({2131427540})
  public boolean onPageTouched()
  {
    if (!this.mManualMode)
      disableAutomaticScrolling();
    return false;
  }

  public void onPause()
  {
    this.mHandler.removeCallbacks(this.mScrollToNextScreen);
    this.mCurrentHeadlineItem = this.mHeadlinePager.getCurrentItem();
    this.mCurrentScreenshotItem = this.mScreenshotPager.getCurrentItem();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    startAutomaticScrolling();
    restorePagers();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.OnBoardingFragment
 * JD-Core Version:    0.6.2
 */