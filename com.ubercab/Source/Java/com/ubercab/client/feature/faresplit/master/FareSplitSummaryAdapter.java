package com.ubercab.client.feature.faresplit.master;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.FareSplitClient;
import com.ubercab.library.app.UberApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FareSplitSummaryAdapter extends BaseAdapter
  implements View.OnClickListener
{
  private List<FareSplitClient> mClients = new ArrayList();
  private boolean mIsMaster;
  private LayoutInflater mLayoutInflater;
  private Listener mListener;

  public FareSplitSummaryAdapter(Context paramContext)
  {
    UberApplication.get(paramContext).inject(this);
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }

  private int weightForStatus(String paramString)
  {
    int i = 1;
    int j = -1;
    switch (paramString.hashCode())
    {
    default:
    case -2081881145:
    case 982065527:
    case 632840270:
    case 1418225932:
    case -522759168:
    }
    while (true)
      switch (j)
      {
      default:
        i = 6;
      case 0:
        return i;
        if (paramString.equals("Accepted"))
        {
          j = 0;
          continue;
          if (paramString.equals("Pending"))
          {
            j = i;
            continue;
            if (paramString.equals("Declined"))
            {
              j = 2;
              continue;
              if (paramString.equals("NoAccount"))
              {
                j = 3;
                continue;
                if (paramString.equals("InvalidNumber"))
                  j = 4;
              }
            }
          }
        }
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      }
    return 2;
    return 3;
    return 4;
    return 5;
  }

  public int getCount()
  {
    return this.mClients.size();
  }

  public FareSplitClient getItem(int paramInt)
  {
    return (FareSplitClient)this.mClients.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.mLayoutInflater.inflate(2130903087, paramViewGroup, false);
    FareSplitClientViewHolder localFareSplitClientViewHolder = (FareSplitClientViewHolder)paramView.getTag();
    if (localFareSplitClientViewHolder == null)
    {
      localFareSplitClientViewHolder = new FareSplitClientViewHolder(paramView, this);
      paramView.setTag(localFareSplitClientViewHolder);
    }
    localFareSplitClientViewHolder.update(getItem(paramInt), paramInt, this.mIsMaster);
    return paramView;
  }

  public boolean isEnabled(int paramInt)
  {
    return false;
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131427471)
    {
      FareSplitClient localFareSplitClient = getItem(((Integer)paramView.getTag()).intValue());
      if (this.mListener != null)
        this.mListener.onUninviteClicked(localFareSplitClient);
    }
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public void update(FareSplit paramFareSplit)
  {
    FareSplitClient localFareSplitClient = paramFareSplit.getClientSelf();
    if ((localFareSplitClient != null) && (localFareSplitClient.isInitiator()));
    for (boolean bool = true; ; bool = false)
    {
      this.mIsMaster = bool;
      ArrayList localArrayList = new ArrayList(paramFareSplit.getClients());
      Collections.sort(localArrayList, new Comparator()
      {
        public int compare(FareSplitClient paramAnonymousFareSplitClient1, FareSplitClient paramAnonymousFareSplitClient2)
        {
          Integer localInteger1 = Integer.valueOf(FareSplitSummaryAdapter.this.weightForStatus(paramAnonymousFareSplitClient1.getStatus()));
          Integer localInteger2 = Integer.valueOf(FareSplitSummaryAdapter.this.weightForStatus(paramAnonymousFareSplitClient2.getStatus()));
          if (!localInteger1.equals(localInteger2))
            return localInteger1.compareTo(localInteger2);
          String str = paramAnonymousFareSplitClient1.getDisplayNameOrNumber();
          return paramAnonymousFareSplitClient2.getDisplayNameOrNumber().compareTo(str);
        }
      });
      this.mClients = localArrayList;
      notifyDataSetChanged();
      return;
    }
  }

  public static abstract interface Listener
  {
    public abstract void onUninviteClicked(FareSplitClient paramFareSplitClient);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitSummaryAdapter
 * JD-Core Version:    0.6.2
 */