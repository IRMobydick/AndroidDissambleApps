package com.ubercab.client.feature.payment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ubercab.ui.UberTextView;

public class TripBalanceSummaryAdapter extends BaseAdapter
{
  private LayoutInflater mLayoutInflater;
  private TripBalanceSummary mSummary;

  public TripBalanceSummaryAdapter(Context paramContext, TripBalanceSummary paramTripBalanceSummary)
  {
    this.mSummary = paramTripBalanceSummary;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }

  public int getCount()
  {
    if (this.mSummary == null)
      return 0;
    return 1;
  }

  public Object getItem(int paramInt)
  {
    if (paramInt == 0)
      return this.mSummary;
    return null;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.mLayoutInflater.inflate(2130903140, paramViewGroup, false);
    ((UberTextView)paramView.findViewById(2131427618)).setText(this.mSummary.getSummary());
    return paramView;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.TripBalanceSummaryAdapter
 * JD-Core Version:    0.6.2
 */