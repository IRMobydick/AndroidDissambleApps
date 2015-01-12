package com.ubercab.client.feature.search;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class LocationSearchFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LocationSearchFragment paramLocationSearchFragment, Object paramObject)
  {
    paramLocationSearchFragment.mEditTextSearch = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427491, "field 'mEditTextSearch'"));
    paramLocationSearchFragment.mTextViewEmpty = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427498, "field 'mTextViewEmpty'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427492, "field 'mImageButtonClear' and method 'onClickImageButtonClear'");
    paramLocationSearchFragment.mImageButtonClear = ((ImageButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickImageButtonClear();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427495, "field 'mListViewLocation' and method 'onTouchListViewLocations'");
    paramLocationSearchFragment.mListViewLocation = ((ListView)localView2);
    localView2.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return this.val$target.onTouchListViewLocations();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427490, "field 'mSearchIcon' and method 'onClickLocationSearchIcon'");
    paramLocationSearchFragment.mSearchIcon = ((LocationSearchIconView)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickLocationSearchIcon();
      }
    });
    View localView4 = paramFinder.findRequiredView(paramObject, 2131427493, "field 'mTextViewSkip' and method 'onClickTextViewSkip'");
    paramLocationSearchFragment.mTextViewSkip = ((UberTextView)localView4);
    localView4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickTextViewSkip();
      }
    });
    paramLocationSearchFragment.mViewGroupContent = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427494, "field 'mViewGroupContent'"));
    paramLocationSearchFragment.mViewGroupEmpty = ((LinearLayout)paramFinder.findRequiredView(paramObject, 2131427497, "field 'mViewGroupEmpty'"));
    paramLocationSearchFragment.mViewGroupLoading = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427496, "field 'mViewGroupLoading'"));
  }

  public static void reset(LocationSearchFragment paramLocationSearchFragment)
  {
    paramLocationSearchFragment.mEditTextSearch = null;
    paramLocationSearchFragment.mTextViewEmpty = null;
    paramLocationSearchFragment.mImageButtonClear = null;
    paramLocationSearchFragment.mListViewLocation = null;
    paramLocationSearchFragment.mSearchIcon = null;
    paramLocationSearchFragment.mTextViewSkip = null;
    paramLocationSearchFragment.mViewGroupContent = null;
    paramLocationSearchFragment.mViewGroupEmpty = null;
    paramLocationSearchFragment.mViewGroupLoading = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */