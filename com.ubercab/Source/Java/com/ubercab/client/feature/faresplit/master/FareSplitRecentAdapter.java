package com.ubercab.client.feature.faresplit.master;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RecentFareSplitter;
import com.ubercab.client.core.ui.ChipEditText.Chip;
import com.ubercab.library.util.PhoneNumberUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FareSplitRecentAdapter extends BaseAdapter
{
  private Collection<String> mCollectionChipNumbers;
  private Collection<String> mCollectionClientNumbers;
  private LayoutInflater mLayoutInflater;
  private List<RecentFareSplitter> mListRecents;

  public FareSplitRecentAdapter(Context paramContext)
  {
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mListRecents = new ArrayList();
    this.mCollectionClientNumbers = new HashSet();
    this.mCollectionChipNumbers = new HashSet();
  }

  public int getCount()
  {
    return this.mListRecents.size();
  }

  public RecentFareSplitter getItem(int paramInt)
  {
    return (RecentFareSplitter)this.mListRecents.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FareSplitContactViewHolder localFareSplitContactViewHolder;
    if (paramView == null)
    {
      paramView = this.mLayoutInflater.inflate(2130903087, paramViewGroup, false);
      localFareSplitContactViewHolder = new FareSplitContactViewHolder(paramView, true);
      paramView.setTag(localFareSplitContactViewHolder);
      RecentFareSplitter localRecentFareSplitter = getItem(paramInt);
      String str1 = localRecentFareSplitter.getMobileDigits();
      String str2 = localRecentFareSplitter.getMobileCountryIso2();
      boolean bool1 = TextUtils.isEmpty(str1);
      bool2 = false;
      if (!bool1)
      {
        boolean bool3 = TextUtils.isEmpty(str2);
        bool2 = false;
        if (!bool3)
        {
          String str3 = PhoneNumberUtils.getE164PhoneNumber(str1, str2);
          if ((!this.mCollectionClientNumbers.contains(str3)) && (!this.mCollectionChipNumbers.contains(str3)))
            break label150;
        }
      }
    }
    label150: for (boolean bool2 = true; ; bool2 = false)
    {
      localFareSplitContactViewHolder.update(getItem(paramInt), bool2);
      return paramView;
      localFareSplitContactViewHolder = (FareSplitContactViewHolder)paramView.getTag();
      break;
    }
  }

  public boolean isEnabled(int paramInt)
  {
    RecentFareSplitter localRecentFareSplitter = getItem(paramInt);
    String str1 = localRecentFareSplitter.getMobileDigits();
    String str2 = localRecentFareSplitter.getMobileCountryIso2();
    boolean bool1 = TextUtils.isEmpty(str1);
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = TextUtils.isEmpty(str2);
      bool2 = false;
      if (!bool3)
      {
        String str3 = PhoneNumberUtils.getE164PhoneNumber(str1, str2);
        boolean bool4 = this.mCollectionClientNumbers.contains(str3);
        bool2 = false;
        if (!bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public void setChips(Collection<ChipEditText.Chip> paramCollection)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localHashSet.add(((ChipEditText.Chip)localIterator.next()).getText());
    this.mCollectionChipNumbers = localHashSet;
    notifyDataSetChanged();
  }

  public void update(Ping paramPing)
  {
    this.mListRecents = new ArrayList(paramPing.getClient().getRecentFareSplitters());
    this.mCollectionClientNumbers = paramPing.getFareSplit().getClientE164Numbers();
    notifyDataSetChanged();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitRecentAdapter
 * JD-Core Version:    0.6.2
 */