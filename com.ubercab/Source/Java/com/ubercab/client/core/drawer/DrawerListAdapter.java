package com.ubercab.client.core.drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.ubercab.ui.UberTextView;

public class DrawerListAdapter extends ArrayAdapter<DrawerItem>
{
  private LayoutInflater mLayoutInflater;

  public DrawerListAdapter(Context paramContext)
  {
    super(paramContext, 0);
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }

  public long getItemId(int paramInt)
  {
    return ((DrawerItem)getItem(paramInt)).getId();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new ViewHolder(null);
      paramView = this.mLayoutInflater.inflate(2130903114, paramViewGroup, false);
      ViewHolder.access$102(localViewHolder, (ImageView)paramView.findViewById(2131427534));
      ViewHolder.access$202(localViewHolder, (UberTextView)paramView.findViewById(2131427535));
      paramView.setTag(localViewHolder);
    }
    while (true)
    {
      DrawerItem localDrawerItem = (DrawerItem)getItem(paramInt);
      localViewHolder.mImageViewIcon.setImageDrawable(localDrawerItem.getIcon());
      localViewHolder.mTextViewTitle.setText(localDrawerItem.getTitle());
      return paramView;
      localViewHolder = (ViewHolder)paramView.getTag();
    }
  }

  private static class ViewHolder
  {
    private ImageView mImageViewIcon;
    private UberTextView mTextViewTitle;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.drawer.DrawerListAdapter
 * JD-Core Version:    0.6.2
 */