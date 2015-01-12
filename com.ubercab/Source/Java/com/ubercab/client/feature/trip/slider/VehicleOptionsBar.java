package com.ubercab.client.feature.trip.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VehicleOptionsBar extends LinearLayout
  implements VehicleOptionGroup.Listener
{
  private ObjectAnimator mAnimatorHide;
  private ObjectAnimator mAnimatorShow;
  private final Context mContext;
  private boolean mIsVisible;
  private final List<Listener> mListeners = new CopyOnWriteArrayList();
  private String mSelectedGroupId;

  @InjectView(2131427903)
  FrameLayout mViewGroupContainer;

  public VehicleOptionsBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public VehicleOptionsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public VehicleOptionsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }

  private void cancelAnimators()
  {
    this.mAnimatorHide.cancel();
    this.mAnimatorShow.cancel();
  }

  private void ensureCorrectVisibility()
  {
    if (this.mIsVisible);
    for (int i = 0; ; i = 8)
    {
      setVisibility(i);
      return;
    }
  }

  private VehicleOptionGroup findOptionGroup(List<VehicleOptionGroup> paramList, final String paramString)
  {
    return (VehicleOptionGroup)Iterables.tryFind(paramList, new Predicate()
    {
      public boolean apply(VehicleOptionGroup paramAnonymousVehicleOptionGroup)
      {
        return paramAnonymousVehicleOptionGroup.getVehicleViewGroup().hasVehicleView(paramString);
      }
    }).orNull();
  }

  private List<VehicleOptionGroup> getVehicleViewOptionGroups()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < this.mViewGroupContainer.getChildCount(); i++)
      localArrayList.add((VehicleOptionGroup)this.mViewGroupContainer.getChildAt(i));
    return localArrayList;
  }

  private void startHideAnimator()
  {
    this.mAnimatorHide.start();
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onOptionsBarVisibilityChanged(8);
  }

  private void startShowAnimator()
  {
    this.mAnimatorShow.start();
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onOptionsBarVisibilityChanged(0);
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  protected VehicleOptionGroup findOptionGroup(String paramString)
  {
    return findOptionGroup(getVehicleViewOptionGroups(), paramString);
  }

  int getBarHeight()
  {
    return getResources().getDimensionPixelSize(2131362020);
  }

  public String getSelectedVehicleViewId()
  {
    VehicleOptionGroup localVehicleOptionGroup = findOptionGroup(this.mSelectedGroupId);
    if (localVehicleOptionGroup != null)
      return localVehicleOptionGroup.getSelectedVehicleViewId();
    return this.mSelectedGroupId;
  }

  void initAnimators()
  {
    int i = getBarHeight();
    int j = this.mContext.getResources().getInteger(2131492872);
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = i;
    arrayOfFloat1[1] = 0.0F;
    this.mAnimatorShow = ObjectAnimator.ofFloat(this, "translationY", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = i;
    this.mAnimatorHide = ObjectAnimator.ofFloat(this, "translationY", arrayOfFloat2);
    this.mAnimatorShow.setDuration(j);
    this.mAnimatorHide.setDuration(j);
    this.mAnimatorShow.setInterpolator(new DecelerateInterpolator());
    this.mAnimatorHide.setInterpolator(new DecelerateInterpolator());
    this.mAnimatorShow.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        VehicleOptionsBar.this.ensureCorrectVisibility();
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        VehicleOptionsBar.this.ensureCorrectVisibility();
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        VehicleOptionsBar.access$002(VehicleOptionsBar.this, true);
        VehicleOptionsBar.this.ensureCorrectVisibility();
      }
    });
    this.mAnimatorHide.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        VehicleOptionsBar.this.ensureCorrectVisibility();
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        VehicleOptionsBar.this.ensureCorrectVisibility();
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        VehicleOptionsBar.access$002(VehicleOptionsBar.this, false);
      }
    });
  }

  boolean isVisible()
  {
    return this.mIsVisible;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
    initAnimators();
  }

  public void onVehicleViewOptionChanged(String paramString1, String paramString2)
  {
    this.mSelectedGroupId = paramString1;
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onVehicleOptionBarChanged(paramString1, paramString2);
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  void setSelectedVehicleGroup(String paramString)
  {
    this.mSelectedGroupId = paramString;
    List localList = getVehicleViewOptionGroups();
    VehicleOptionGroup localVehicleOptionGroup1 = findOptionGroup(localList, paramString);
    if (localVehicleOptionGroup1 == null)
    {
      if (this.mIsVisible)
      {
        cancelAnimators();
        startHideAnimator();
      }
      return;
    }
    if (!this.mIsVisible)
    {
      cancelAnimators();
      startShowAnimator();
    }
    Iterator localIterator = localList.iterator();
    label60: VehicleOptionGroup localVehicleOptionGroup2;
    if (localIterator.hasNext())
    {
      localVehicleOptionGroup2 = (VehicleOptionGroup)localIterator.next();
      if (localVehicleOptionGroup2 != localVehicleOptionGroup1)
        break label101;
    }
    label101: for (int i = 0; ; i = 4)
    {
      localVehicleOptionGroup2.setVisibility(i);
      break label60;
      break;
    }
  }

  public void setSelectedVehicleView(String paramString)
  {
    setSelectedVehicleGroup(paramString);
    VehicleOptionGroup localVehicleOptionGroup = findOptionGroup(paramString);
    if (localVehicleOptionGroup != null)
      localVehicleOptionGroup.setVehicleViewId(paramString);
  }

  void setVehicleGroups(List<VehicleViewGroup> paramList)
  {
    List localList = getVehicleViewOptionGroups();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      final VehicleViewGroup localVehicleViewGroup = (VehicleViewGroup)localIterator.next();
      VehicleOptionGroup localVehicleOptionGroup = (VehicleOptionGroup)Iterables.tryFind(localList, new Predicate()
      {
        public boolean apply(VehicleOptionGroup paramAnonymousVehicleOptionGroup)
        {
          return paramAnonymousVehicleOptionGroup.getVehicleViewGroup().getPrimaryVehicleId().equals(localVehicleViewGroup.getPrimaryVehicleId());
        }
      }).orNull();
      if (!localVehicleViewGroup.hasMultiple())
      {
        if (localVehicleOptionGroup != null)
        {
          localVehicleOptionGroup.removeListener(this);
          this.mViewGroupContainer.removeView(localVehicleOptionGroup);
        }
      }
      else
      {
        if (localVehicleOptionGroup == null)
        {
          localVehicleOptionGroup = new VehicleOptionGroup(getContext());
          localVehicleOptionGroup.setVisibility(4);
          this.mViewGroupContainer.addView(localVehicleOptionGroup);
          localVehicleOptionGroup.addListener(this);
        }
        localVehicleOptionGroup.updateVehicleViews(localVehicleViewGroup);
      }
    }
    initAnimators();
  }

  public static abstract interface Listener
  {
    public abstract void onOptionsBarVisibilityChanged(int paramInt);

    public abstract void onVehicleOptionBarChanged(String paramString1, String paramString2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleOptionsBar
 * JD-Core Version:    0.6.2
 */