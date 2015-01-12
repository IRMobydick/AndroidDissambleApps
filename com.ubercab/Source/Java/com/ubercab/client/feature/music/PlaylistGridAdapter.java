package com.ubercab.client.feature.music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

class PlaylistGridAdapter extends BaseAdapter
{
  private final LayoutInflater mLayoutInflater;
  private final Picasso mPicasso;

  PlaylistGridAdapter(LayoutInflater paramLayoutInflater, Picasso paramPicasso)
  {
    this.mLayoutInflater = paramLayoutInflater;
    this.mPicasso = paramPicasso;
    notifyDataSetChanged();
  }

  private View createView(ViewGroup paramViewGroup)
  {
    return this.mLayoutInflater.inflate(2130903105, paramViewGroup, false);
  }

  public int getCount()
  {
    return 8;
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = createView(paramViewGroup);
    localView.setTag(new ViewHolder(localView));
    return localView;
  }

  class ViewHolder
  {

    @InjectView(2131427514)
    ImageView mImageViewPlaylist;

    ViewHolder(View arg2)
    {
      View localView;
      ButterKnife.inject(this, localView);
      PlaylistGridAdapter.this.mPicasso.load("https://i.scdn.co/image/8b662d81966a0ec40dc10563807696a8479cd48b").into(this.mImageViewPlaylist);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.PlaylistGridAdapter
 * JD-Core Version:    0.6.2
 */