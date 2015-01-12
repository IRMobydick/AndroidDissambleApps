package com.ubercab.client.feature.payment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.CreditBalance;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.ui.UberTextView;
import java.util.ArrayList;
import java.util.List;

public class CreditsAdapter extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  private boolean mIsUsingCredits;
  private LayoutInflater mLayoutInflater;
  private List<CreditBalance> mListCreditBalances = new ArrayList();
  private Listener mListener;
  private boolean mSetIsUsingCreditsCalled;
  private boolean mShowUseCreditsToggle;

  public CreditsAdapter(Context paramContext, int paramInt, boolean paramBoolean)
  {
    RiderApplication.get(paramContext).inject(this);
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mIsUsingCredits = paramBoolean;
    if ((paramInt == i) || (paramInt == 2));
    while (true)
    {
      this.mShowUseCreditsToggle = i;
      return;
      i = 0;
    }
  }

  public int getCount()
  {
    return this.mListCreditBalances.size();
  }

  public Object getItem(int paramInt)
  {
    return this.mListCreditBalances.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.mLayoutInflater.inflate(2130903141, paramViewGroup, false);
      paramView.setTag(new CreditsItemViewHolder(paramView, this));
    }
    CreditBalance localCreditBalance = (CreditBalance)getItem(paramInt);
    ((CreditsItemViewHolder)paramView.getTag()).update(localCreditBalance, this.mShowUseCreditsToggle, this.mIsUsingCredits);
    return paramView;
  }

  public boolean isEnabled(int paramInt)
  {
    return false;
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    setIsUsingCredits(paramBoolean);
  }

  public void setIsUsingCredits(boolean paramBoolean)
  {
    if (paramBoolean != this.mIsUsingCredits);
    for (int i = 1; ; i = 0)
    {
      this.mIsUsingCredits = paramBoolean;
      this.mSetIsUsingCreditsCalled = true;
      if ((this.mListener != null) && (i != 0))
        this.mListener.onUseCreditsChanged(paramBoolean);
      return;
    }
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public void update(Ping paramPing)
  {
    if (paramPing == null)
    {
      this.mListCreditBalances.clear();
      return;
    }
    if (this.mShowUseCreditsToggle)
    {
      CreditBalance localCreditBalance = paramPing.findCreditBalanceForCity();
      if (localCreditBalance != null)
      {
        this.mListCreditBalances = ImmutableList.of(localCreditBalance);
        if ((PingUtils.isClientOnTrip(paramPing)) && (!this.mSetIsUsingCreditsCalled))
          this.mIsUsingCredits = paramPing.getTrip().isUseCredits();
      }
    }
    while (true)
    {
      notifyDataSetChanged();
      return;
      this.mListCreditBalances = paramPing.getClient().getCreditBalances();
    }
  }

  static class CreditsItemViewHolder
  {
    private final CompoundButton.OnCheckedChangeListener mListenerChecked;

    @InjectView(2131427620)
    Switch mSwitchUseCredits;

    @InjectView(2131427619)
    UberTextView mTextViewCredit;

    public CreditsItemViewHolder(View paramView, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
    {
      ButterKnife.inject(this, paramView);
      this.mListenerChecked = paramOnCheckedChangeListener;
      this.mSwitchUseCredits.setOnCheckedChangeListener(this.mListenerChecked);
    }

    public void update(CreditBalance paramCreditBalance, boolean paramBoolean1, boolean paramBoolean2)
    {
      Switch localSwitch = this.mSwitchUseCredits;
      if (paramBoolean1);
      String str1;
      String str2;
      for (int i = 0; ; i = 8)
      {
        localSwitch.setVisibility(i);
        this.mSwitchUseCredits.setOnCheckedChangeListener(null);
        this.mSwitchUseCredits.setChecked(paramBoolean2);
        this.mSwitchUseCredits.setOnCheckedChangeListener(this.mListenerChecked);
        str1 = paramCreditBalance.getAmountString();
        str2 = paramCreditBalance.getDisplayName();
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          break;
        return;
      }
      this.mTextViewCredit.setText(String.format("%s %s", new Object[] { str2, str1 }));
    }
  }

  public static abstract interface Listener
  {
    public abstract void onUseCreditsChanged(boolean paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.CreditsAdapter
 * JD-Core Version:    0.6.2
 */