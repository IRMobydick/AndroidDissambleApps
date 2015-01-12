package com.ubercab.client.feature.search;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.feature.search.event.AddFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.EditFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.GetLocationDetailsEvent;
import com.ubercab.client.feature.search.event.LocationResultClickEvent;
import java.util.ArrayList;
import java.util.List;

public class LocationSearchAdapter extends BaseAdapter
{
  private final Bus mBus;
  private Context mContext;
  private List<LocationSearchResultWrapper> mItems;
  private boolean mOverrideBackground;
  private boolean mShowActionIcon;

  public LocationSearchAdapter(Context paramContext, Bus paramBus, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mContext = paramContext;
    this.mItems = new ArrayList();
    this.mBus = paramBus;
    this.mOverrideBackground = paramBoolean1;
    this.mShowActionIcon = paramBoolean2;
  }

  public void clear()
  {
    this.mItems.clear();
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.mItems.size();
  }

  public LocationSearchResultWrapper getItem(int paramInt)
  {
    return (LocationSearchResultWrapper)this.mItems.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public List<LocationSearchResultWrapper> getItems()
  {
    return this.mItems;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2130903164, paramViewGroup, false);
      paramView.setTag(new LocationViewHolder(paramView));
    }
    LocationSearchResultWrapper localLocationSearchResultWrapper = getItem(paramInt);
    ((LocationViewHolder)paramView.getTag()).update(localLocationSearchResultWrapper, paramInt);
    return paramView;
  }

  public void update(List<LocationSearchResultWrapper> paramList)
  {
    if (paramList == null)
      paramList = new ArrayList();
    this.mItems = paramList;
    notifyDataSetChanged();
  }

  class LocationViewHolder
  {

    @InjectView(2131427692)
    ImageButton mEditLocationButton;

    @InjectView(2131427689)
    ImageView mImageViewIcon;
    private View mItemView;
    private LocationSearchResultWrapper mLocationSearchResultWrapper;
    private int mPosition;

    @InjectView(2131427691)
    TextView mTextViewSubtitle;

    @InjectView(2131427690)
    TextView mTextViewTitle;

    public LocationViewHolder(View arg2)
    {
      View localView;
      this.mItemView = localView;
      ButterKnife.inject(this, localView);
    }

    private int getBackgroundForPosition(int paramInt)
    {
      if ((paramInt == 0) && (LocationSearchAdapter.this.mItems.size() == 1))
        return 2130837684;
      if (paramInt == 0)
        return 2130837716;
      if (paramInt == -1 + LocationSearchAdapter.this.mItems.size())
        return 2130837686;
      return 2130837699;
    }

    @OnClick({2131427692})
    public void onClickEdit()
    {
      if (this.mLocationSearchResultWrapper == null)
        return;
      LocationSearchAdapter.this.mBus.post(new EditFavoriteLocationEvent(this.mLocationSearchResultWrapper.getTag(), this.mPosition));
    }

    @OnClick({2131427688})
    public void onItemClick()
    {
      if (this.mLocationSearchResultWrapper == null);
      LocationSearchResult localLocationSearchResult;
      do
      {
        return;
        localLocationSearchResult = this.mLocationSearchResultWrapper.getLocationSearchResult();
        if ((this.mLocationSearchResultWrapper.isTagged()) && (localLocationSearchResult == null))
        {
          LocationSearchAdapter.this.mBus.post(new AddFavoriteLocationEvent(this.mLocationSearchResultWrapper.getTag(), this.mPosition));
          return;
        }
        if ((localLocationSearchResult != null) && (localLocationSearchResult.getUberLatLng() != null))
        {
          LocationSearchAdapter.this.mBus.post(new LocationResultClickEvent(localLocationSearchResult, this.mLocationSearchResultWrapper.getTag()));
          return;
        }
      }
      while (localLocationSearchResult == null);
      String str1 = localLocationSearchResult.getReference();
      String str2 = localLocationSearchResult.getType();
      LocationSearchAdapter.this.mBus.post(new GetLocationDetailsEvent(str1, str2));
    }

    public void update(LocationSearchResultWrapper paramLocationSearchResultWrapper, int paramInt)
    {
      this.mLocationSearchResultWrapper = paramLocationSearchResultWrapper;
      this.mPosition = paramInt;
      String str1 = paramLocationSearchResultWrapper.getTitle();
      String str2 = paramLocationSearchResultWrapper.getSubtitle();
      this.mImageViewIcon.setImageResource(paramLocationSearchResultWrapper.getImageResource());
      int i;
      label74: int j;
      if ((paramLocationSearchResultWrapper.isTagged()) && (paramLocationSearchResultWrapper.getLocationSearchResult() != null) && (LocationSearchAdapter.this.mShowActionIcon))
      {
        this.mEditLocationButton.setVisibility(0);
        if (TextUtils.isEmpty(str1))
          break label166;
        i = 1;
        if (TextUtils.isEmpty(str2))
          break label172;
        j = 1;
        label85: if ((i == 0) || (j == 0))
          break label178;
        this.mTextViewTitle.setText(str1);
        this.mTextViewSubtitle.setText(str2);
        this.mTextViewSubtitle.setVisibility(0);
      }
      while (true)
      {
        this.mTextViewTitle.setTextColor(paramLocationSearchResultWrapper.getTitleColor());
        if (LocationSearchAdapter.this.mOverrideBackground)
          this.mItemView.setBackgroundResource(getBackgroundForPosition(paramInt));
        return;
        this.mEditLocationButton.setVisibility(8);
        break;
        label166: i = 0;
        break label74;
        label172: j = 0;
        break label85;
        label178: if (i == 0)
        {
          this.mTextViewTitle.setText(str2);
          this.mTextViewSubtitle.setVisibility(8);
        }
        else
        {
          this.mTextViewTitle.setText(str1);
          this.mTextViewSubtitle.setVisibility(8);
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchAdapter
 * JD-Core Version:    0.6.2
 */