package com.ubercab.client.feature.trip.slider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VehicleOptionGroup extends HorizontalScrollView
  implements RadioGroup.OnCheckedChangeListener
{
  public static final int COUNT_MIN_FULL_WIDTH_OPTIONS = 2;
  public static final float DIMEN_FADING_EDGE_STRENGTH = 0.5F;
  private boolean mIsCheckedInternally;
  private final List<Listener> mListeners = new CopyOnWriteArrayList();
  private int mOptionPadding;

  @InjectView(2131427907)
  RadioGroup mRadioGroup;
  private VehicleViewGroup mVehicleViewGroup;
  private WindowManager mWindowManager;

  public VehicleOptionGroup(Context paramContext)
  {
    this(paramContext, null);
  }

  public VehicleOptionGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public VehicleOptionGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2130903222, this);
    ButterKnife.inject(this);
    this.mRadioGroup.setOnCheckedChangeListener(this);
    this.mWindowManager = ((WindowManager)getContext().getSystemService("window"));
    this.mOptionPadding = getResources().getDimensionPixelSize(2131362023);
  }

  private OptionRadioButton findOptionRadioButton(String paramString)
  {
    return findOptionRadioButton(getOptionRadioButtons(), paramString);
  }

  private OptionRadioButton findOptionRadioButton(List<OptionRadioButton> paramList, final String paramString)
  {
    return (OptionRadioButton)Iterables.tryFind(paramList, new Predicate()
    {
      public boolean apply(OptionRadioButton paramAnonymousOptionRadioButton)
      {
        return paramAnonymousOptionRadioButton.getVehicleViewId().equals(paramString);
      }
    }).orNull();
  }

  private void focusOnOption(final HorizontalScrollView paramHorizontalScrollView, OptionRadioButton paramOptionRadioButton)
  {
    int i = paramOptionRadioButton.getLeftEdge();
    int j = paramOptionRadioButton.getWidth();
    final int k;
    if (i < 0)
      k = i - paramOptionRadioButton.getPaddingLeft();
    while (true)
    {
      if (k != 0)
        new Handler().post(new Runnable()
        {
          public void run()
          {
            paramHorizontalScrollView.smoothScrollBy(k, 0);
          }
        });
      return;
      if (i + j > getRight())
        k = i + j + paramOptionRadioButton.getPaddingRight() - getRight();
      else
        k = 0;
    }
  }

  private int getButtonWidth(int paramInt)
  {
    if (paramInt > 2)
      return -2;
    Display localDisplay = this.mWindowManager.getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    return (localPoint.x - this.mOptionPadding * (paramInt + 1)) / paramInt;
  }

  private List<OptionRadioButton> getOptionRadioButtons()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < this.mRadioGroup.getChildCount(); i++)
      localArrayList.add((OptionRadioButton)this.mRadioGroup.getChildAt(i));
    return localArrayList;
  }

  private void removeUnusedButtons(List<OptionRadioButton> paramList, List<VehicleView> paramList1)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      final OptionRadioButton localOptionRadioButton = (OptionRadioButton)localIterator.next();
      if (!Iterables.any(paramList1, new Predicate()
      {
        public boolean apply(VehicleView paramAnonymousVehicleView)
        {
          return localOptionRadioButton.getVehicleViewId().equals(paramAnonymousVehicleView.getId());
        }
      }))
        this.mRadioGroup.removeView(localOptionRadioButton);
    }
  }

  void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  protected float getLeftFadingEdgeStrength()
  {
    return 0.5F;
  }

  protected float getRightFadingEdgeStrength()
  {
    return 0.5F;
  }

  String getSelectedVehicleViewId()
  {
    return ((OptionRadioButton)this.mRadioGroup.findViewById(this.mRadioGroup.getCheckedRadioButtonId())).getVehicleViewId();
  }

  VehicleViewGroup getVehicleViewGroup()
  {
    return this.mVehicleViewGroup;
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (this.mIsCheckedInternally);
    while (true)
    {
      return;
      OptionRadioButton localOptionRadioButton = (OptionRadioButton)paramRadioGroup.findViewById(paramInt);
      String str = localOptionRadioButton.getVehicleViewId();
      focusOnOption(this, localOptionRadioButton);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
        ((Listener)localIterator.next()).onVehicleViewOptionChanged(this.mVehicleViewGroup.getPrimaryVehicleId(), str);
    }
  }

  void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  void setVehicleViewId(String paramString)
  {
    OptionRadioButton localOptionRadioButton = findOptionRadioButton(paramString);
    this.mIsCheckedInternally = true;
    this.mRadioGroup.check(localOptionRadioButton.getId());
    this.mIsCheckedInternally = false;
  }

  void updateVehicleViews(VehicleViewGroup paramVehicleViewGroup)
  {
    this.mVehicleViewGroup = paramVehicleViewGroup;
    int i = getButtonWidth(paramVehicleViewGroup.getVehicleViews().size());
    List localList = getOptionRadioButtons();
    Iterator localIterator = paramVehicleViewGroup.getVehicleViews().iterator();
    while (localIterator.hasNext())
    {
      VehicleView localVehicleView = (VehicleView)localIterator.next();
      OptionRadioButton localOptionRadioButton2 = findOptionRadioButton(localList, localVehicleView.getId());
      if (localOptionRadioButton2 == null)
      {
        localOptionRadioButton2 = (OptionRadioButton)inflate(getContext(), 2130903219, null);
        localOptionRadioButton2.setVehicleViewId(localVehicleView.getId());
        localOptionRadioButton2.setLayoutParams(new FrameLayout.LayoutParams(i, -1, 1));
        this.mRadioGroup.addView(localOptionRadioButton2);
      }
      localOptionRadioButton2.setText(localVehicleView.getDescription());
      localOptionRadioButton2.setIsSurging(localVehicleView.isSurging());
      localOptionRadioButton2.setActivated(paramVehicleViewGroup.isVehicleViewAvailable(localVehicleView.getId()));
    }
    removeUnusedButtons(localList, paramVehicleViewGroup.getVehicleViews());
    if (this.mRadioGroup.getCheckedRadioButtonId() == -1)
    {
      OptionRadioButton localOptionRadioButton1 = findOptionRadioButton(getOptionRadioButtons(), paramVehicleViewGroup.getPrimaryVehicleId());
      this.mIsCheckedInternally = true;
      this.mRadioGroup.check(localOptionRadioButton1.getId());
      this.mIsCheckedInternally = false;
    }
  }

  public static abstract interface Listener
  {
    public abstract void onVehicleViewOptionChanged(String paramString1, String paramString2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleOptionGroup
 * JD-Core Version:    0.6.2
 */