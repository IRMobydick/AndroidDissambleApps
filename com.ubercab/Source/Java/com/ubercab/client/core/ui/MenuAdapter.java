package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<Item>
{
  public MenuAdapter(Context paramContext, Item[] paramArrayOfItem)
  {
    super(paramContext, 2130903173, paramArrayOfItem);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    Item localItem = (Item)getItem(paramInt);
    TextView localTextView = (TextView)localView.findViewById(16908308);
    localTextView.setText(localItem.getText());
    localTextView.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(localItem.getIcon()), null, null, null);
    return localView;
  }

  public static class Item
  {
    private int mIcon;
    private int mId;
    private String mText;

    public Item(int paramInt1, int paramInt2, String paramString)
    {
      this.mId = paramInt1;
      this.mText = paramString;
      this.mIcon = paramInt2;
    }

    public int getIcon()
    {
      return this.mIcon;
    }

    public int getId()
    {
      return this.mId;
    }

    public String getText()
    {
      return this.mText;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.MenuAdapter
 * JD-Core Version:    0.6.2
 */