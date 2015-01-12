package com.ubercab.client.feature.search;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class LocationSearchFooterView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LocationSearchFooterView paramLocationSearchFooterView, Object paramObject)
  {
    paramLocationSearchFooterView.mImageViewPoweredByGoogle = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427698, "field 'mImageViewPoweredByGoogle'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427697, "field 'mRemoveTaggedButton' and method 'onClickRemoveButton'");
    paramLocationSearchFooterView.mRemoveTaggedButton = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickRemoveButton();
      }
    });
    paramLocationSearchFooterView.mFooterTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427696, "field 'mFooterTitle'"));
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427694, "field 'mViewGroupSearchMore' and method 'onClickSearchMore'");
    paramLocationSearchFooterView.mViewGroupSearchMore = ((ViewGroup)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickSearchMore();
      }
    });
  }

  public static void reset(LocationSearchFooterView paramLocationSearchFooterView)
  {
    paramLocationSearchFooterView.mImageViewPoweredByGoogle = null;
    paramLocationSearchFooterView.mRemoveTaggedButton = null;
    paramLocationSearchFooterView.mFooterTitle = null;
    paramLocationSearchFooterView.mViewGroupSearchMore = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchFooterView..ViewInjector
 * JD-Core Version:    0.6.2
 */