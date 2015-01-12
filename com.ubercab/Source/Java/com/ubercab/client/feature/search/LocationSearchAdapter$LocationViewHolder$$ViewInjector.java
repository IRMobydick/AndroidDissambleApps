package com.ubercab.client.feature.search;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class LocationSearchAdapter$LocationViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LocationSearchAdapter.LocationViewHolder paramLocationViewHolder, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427692, "field 'mEditLocationButton' and method 'onClickEdit'");
    paramLocationViewHolder.mEditLocationButton = ((ImageButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickEdit();
      }
    });
    paramLocationViewHolder.mImageViewIcon = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427689, "field 'mImageViewIcon'"));
    paramLocationViewHolder.mTextViewTitle = ((TextView)paramFinder.findRequiredView(paramObject, 2131427690, "field 'mTextViewTitle'"));
    paramLocationViewHolder.mTextViewSubtitle = ((TextView)paramFinder.findRequiredView(paramObject, 2131427691, "field 'mTextViewSubtitle'"));
    paramFinder.findRequiredView(paramObject, 2131427688, "method 'onItemClick'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onItemClick();
      }
    });
  }

  public static void reset(LocationSearchAdapter.LocationViewHolder paramLocationViewHolder)
  {
    paramLocationViewHolder.mEditLocationButton = null;
    paramLocationViewHolder.mImageViewIcon = null;
    paramLocationViewHolder.mTextViewTitle = null;
    paramLocationViewHolder.mTextViewSubtitle = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchAdapter.LocationViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */