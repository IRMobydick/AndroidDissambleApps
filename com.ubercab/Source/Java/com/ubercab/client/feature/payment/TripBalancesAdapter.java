package com.ubercab.client.feature.payment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.model.TripBalance;
import java.util.ArrayList;
import java.util.List;

public class TripBalancesAdapter extends BaseAdapter
{
  private LayoutInflater mLayoutInflater;
  private List<TripBalance> mTripBalances = new ArrayList();

  public TripBalancesAdapter(Context paramContext)
  {
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }

  public int getCount()
  {
    if (this.mTripBalances == null)
      return 0;
    return this.mTripBalances.size();
  }

  public TripBalance getItem(int paramInt)
  {
    return (TripBalance)this.mTripBalances.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.mLayoutInflater.inflate(2130903152, paramViewGroup, false);
      paramView.setTag(new TripBalancesViewHolder(paramView));
    }
    ((TripBalancesViewHolder)paramView.getTag()).update(getItem(paramInt));
    return paramView;
  }

  public void update(List<TripBalance> paramList)
  {
    if (paramList == null)
      this.mTripBalances.clear();
    while (true)
    {
      notifyDataSetChanged();
      return;
      this.mTripBalances = new ArrayList(paramList);
    }
  }

  static class TripBalancesViewHolder
  {

    @InjectView(2131427657)
    TextView mDetails;

    @InjectView(2131427656)
    TextView mLabel;

    public TripBalancesViewHolder(View paramView)
    {
      ButterKnife.inject(this, paramView);
    }

    public void update(TripBalance paramTripBalance)
    {
      this.mLabel.setText(paramTripBalance.getLabel());
      this.mDetails.setText(paramTripBalance.getDetail());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.TripBalancesAdapter
 * JD-Core Version:    0.6.2
 */