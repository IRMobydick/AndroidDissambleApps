package com.ubercab.client.feature.music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.ui.RiderGridView;
import com.ubercab.library.app.UberFragment;
import javax.inject.Inject;

public class BrowseFragment extends UberFragment
{

  @InjectView(2131427507)
  RiderGridView mGridView;

  @InjectView(2131427508)
  ImageView mImageViewHeader;

  @Inject
  Picasso mPicasso;

  @InjectView(2131427506)
  ViewGroup mViewGroupHeader;

  private void updateHeader()
  {
    ((ViewManager)this.mViewGroupHeader.getParent()).removeView(this.mViewGroupHeader);
    this.mGridView.addHeaderView(this.mViewGroupHeader);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramLayoutInflater.inflate(2130903101, paramViewGroup, false);
    ButterKnife.inject(this, localViewGroup);
    updateHeader();
    this.mGridView.setAdapter(new PlaylistGridAdapter(paramLayoutInflater, this.mPicasso));
    return localViewGroup;
  }

  public void onDestroy()
  {
    super.onDestroy();
    ButterKnife.reset(this);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mPicasso.load("https://i.scdn.co/image/07c323340e03e25a8e5dd5b9a8ec72b69c50089d").into(this.mImageViewHeader, new Callback()
    {
      public void onError()
      {
      }

      public void onSuccess()
      {
        BrowseFragment.this.updateHeader();
      }
    });
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.BrowseFragment
 * JD-Core Version:    0.6.2
 */