package com.ubercab.client.feature.trip.slider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Ping;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsEvent.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public class VehicleSlider extends LinearLayout
  implements VehicleSeekBar.Listener, VehicleLabelBar.Listener, VehicleOptionsBar.Listener, VehicleBannerBar.Listener
{

  @Inject
  AnalyticsClient mAnalyticsClient;
  private String mAnalyticsVehicleOptionId;
  private String mAnalyticsVehicleProductId;

  @InjectView(2131427901)
  VehicleBannerBar mBannerBar;
  private String mCurrentVehicleGroupId;

  @InjectView(2131427905)
  VehicleLabelBar mLabelBar;
  private final List<Listener> mListeners = new CopyOnWriteArrayList();

  @InjectView(2131427902)
  VehicleOptionsBar mOptionsBar;

  @Inject
  RiderPreferences mRiderPreferences;

  @InjectView(2131427906)
  VehicleSeekBar mSeekBar;

  @InjectView(2131427904)
  ViewGroup mViewGroupBottom;

  @InjectView(2131427900)
  View mViewShadow;

  public VehicleSlider(Context paramContext)
  {
    this(paramContext, null);
  }

  public VehicleSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public VehicleSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      UberApplication.get(paramContext).inject(this);
  }

  private void notifyVehicleSliderSizeChanged()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onVehicleSliderSizeChanged(this.mOptionsBar.isVisible());
  }

  private void setHorizontalPadding(View paramView, int paramInt)
  {
    int i = getResources().getDimensionPixelSize(2131361961);
    if (paramInt == 2)
      i = getResources().getDimensionPixelSize(2131361964);
    while (true)
    {
      paramView.setPadding(i, paramView.getPaddingTop(), i, paramView.getPaddingBottom());
      return;
      if (paramInt <= 4)
        i = getResources().getDimensionPixelSize(2131361962);
    }
  }

  private void updateShadowVisibility(boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView = this.mViewShadow;
    if ((paramBoolean1) || (paramBoolean2));
    for (int i = 8; ; i = 0)
    {
      localView.setVisibility(i);
      notifyVehicleSliderSizeChanged();
      return;
    }
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  public int getHeightForModal()
  {
    if (this.mOptionsBar.isVisible())
      return getMinHeight() + this.mOptionsBar.getBarHeight();
    return getMinHeight();
  }

  public int getMaxHeight()
  {
    if (this.mOptionsBar.isVisible())
      return getMinHeight() + this.mOptionsBar.getBarHeight();
    if (this.mBannerBar.isVisible())
      return getMinHeight() + this.mBannerBar.getBarHeight();
    return getMinHeight();
  }

  public int getMinHeight()
  {
    int i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.mViewGroupBottom.measure(i, j);
    return this.mViewGroupBottom.getMeasuredHeight();
  }

  public void onBannerBarVisibilityChanged(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.mOptionsBar.getVisibility() == 0)
    {
      bool2 = bool1;
      if (paramInt != 0)
        break label30;
    }
    while (true)
    {
      updateShadowVisibility(bool2, bool1);
      return;
      bool2 = false;
      break;
      label30: bool1 = false;
    }
  }

  @OnClick({2131427901})
  public void onClickBannerBar()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onVehicleBannerBarClicked(this.mCurrentVehicleGroupId);
  }

  public void onDrawVehicleBitmaps(List<VehicleTextBitmap> paramList)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onDrawVehicleBitmaps(paramList);
  }

  @SuppressLint({"NewApi"})
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
    int i = this.mSeekBar.getThumb().getIntrinsicWidth() / 2;
    this.mSeekBar.setListener(this);
    int j = getResources().getDimensionPixelSize(2131361963);
    int k = this.mSeekBar.getPaddingBottom();
    int m = this.mSeekBar.getPaddingTop();
    this.mSeekBar.setPadding(j + i, m, j + i, k);
    this.mLabelBar.setListener(this);
    this.mLabelBar.setPadding(i + this.mLabelBar.getPaddingLeft(), this.mLabelBar.getPaddingTop(), i + this.mLabelBar.getPaddingRight(), this.mLabelBar.getPaddingBottom());
    this.mOptionsBar.addListener(this);
    this.mBannerBar.addListener(this);
    this.mViewShadow.setVisibility(0);
  }

  public void onOptionsBarVisibilityChanged(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt == 0)
    {
      bool2 = bool1;
      if (this.mBannerBar.getVisibility() != 0)
        break label30;
    }
    while (true)
    {
      updateShadowVisibility(bool2, bool1);
      return;
      bool2 = false;
      break;
      label30: bool1 = false;
    }
  }

  public void onVehicleLabelBarTouchEvent(VehicleLabelBar paramVehicleLabelBar, MotionEvent paramMotionEvent)
  {
    this.mSeekBar.onTouchEvent(paramMotionEvent);
  }

  public void onVehicleOptionBarChanged(String paramString1, String paramString2)
  {
    this.mCurrentVehicleGroupId = paramString1;
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onVehicleViewChanged(paramString2);
    if ((this.mAnalyticsVehicleOptionId != null) && (this.mAnalyticsVehicleOptionId.equals(paramString2)))
      return;
    int i = this.mOptionsBar.findOptionGroup(paramString2).getVehicleViewGroup().indexOfVehicle(paramString2);
    this.mAnalyticsVehicleOptionId = paramString2;
    this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("tap").setName(RiderEvents.Tap.PRODUCT_SELECT_CHILD).setValue("switch_product").setValuePosition(Long.valueOf(i)).build());
  }

  public void onVehicleSeekBarChanged(String paramString)
  {
    if (paramString.equals(this.mCurrentVehicleGroupId));
    do
    {
      return;
      this.mCurrentVehicleGroupId = paramString;
      this.mOptionsBar.setSelectedVehicleGroup(this.mCurrentVehicleGroupId);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
        ((Listener)localIterator.next()).onVehicleViewChanged(this.mOptionsBar.getSelectedVehicleViewId());
    }
    while ((this.mAnalyticsVehicleProductId != null) && (this.mAnalyticsVehicleProductId.equals(paramString)));
    this.mAnalyticsVehicleProductId = paramString;
    this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("tap").setName(RiderEvents.Tap.PRODUCT_SELECT_PARENT).setValue("switch_product").setValuePosition(Long.valueOf(this.mSeekBar.getProgress())).build());
  }

  public void onVehicleSeekBarThumbClicked()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onVehicleViewClicked(this.mOptionsBar.getSelectedVehicleViewId());
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void setSelectedVehicleViewId(String paramString)
  {
    this.mCurrentVehicleGroupId = paramString;
    this.mSeekBar.setSelectedVehicleView(paramString);
    this.mOptionsBar.setSelectedVehicleGroup(paramString);
    this.mOptionsBar.setSelectedVehicleView(paramString);
  }

  public void update(Ping paramPing)
  {
    this.mBannerBar.update(paramPing);
    List localList = VehicleViewGroup.extractVehicleViewGroups(paramPing);
    int i = localList.size();
    setHorizontalPadding(this.mSeekBar, i);
    setHorizontalPadding(this.mLabelBar, i);
    this.mSeekBar.setVehicleGroups(localList);
    this.mLabelBar.setVehicleGroups(localList);
    this.mOptionsBar.setVehicleGroups(localList);
  }

  public static abstract interface Listener
  {
    public abstract void onDrawVehicleBitmaps(List<VehicleTextBitmap> paramList);

    public abstract void onVehicleBannerBarClicked(String paramString);

    public abstract void onVehicleSliderSizeChanged(boolean paramBoolean);

    public abstract void onVehicleViewChanged(String paramString);

    public abstract void onVehicleViewClicked(String paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleSlider
 * JD-Core Version:    0.6.2
 */