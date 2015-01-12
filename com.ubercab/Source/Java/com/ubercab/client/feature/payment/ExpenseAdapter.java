package com.ubercab.client.feature.payment;

import android.content.Context;
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
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResource;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResources;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class ExpenseAdapter extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  private TripExpenseInfo mExpenseInfo = new TripExpenseInfo();

  @Inject
  ExpenseLinkResources mExpenseLinkResources;
  private String mExpenseType;
  private final boolean mIsEditableMode;
  private LayoutInflater mLayoutInflater;
  private Listener mListener;
  private boolean mShowSendToExpenseLinkToggle;

  public ExpenseAdapter(Context paramContext, int paramInt, TripExpenseInfo paramTripExpenseInfo)
  {
    this.mShowSendToExpenseLinkToggle = i;
    RiderApplication.get(paramContext).inject(this);
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mExpenseInfo = paramTripExpenseInfo;
    if ((paramInt == i) || (paramInt == 2));
    while (true)
    {
      this.mIsEditableMode = i;
      this.mShowSendToExpenseLinkToggle = this.mIsEditableMode;
      return;
      i = 0;
    }
  }

  public int getCount()
  {
    if (this.mShowSendToExpenseLinkToggle)
      return 1;
    return 0;
  }

  public Object getItem(int paramInt)
  {
    return this.mExpenseInfo;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.mLayoutInflater.inflate(2130903146, paramViewGroup, false);
      paramView.setTag(new ExpenseLinkItemViewHolder(paramView, this, this.mExpenseLinkResources));
    }
    ((ExpenseLinkItemViewHolder)paramView.getTag()).update(this.mExpenseType, this.mExpenseInfo, paramViewGroup);
    return paramView;
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.mExpenseInfo.setExpenseTrip(paramBoolean);
    if (this.mListener != null)
      this.mListener.onSendExpenseChanged(paramBoolean);
  }

  void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  void update(Ping paramPing)
  {
    if ((this.mIsEditableMode) && (paramPing != null))
    {
      this.mExpenseType = paramPing.getExpenseLinkType();
      if (this.mExpenseLinkResources.getResource(this.mExpenseType) == null)
        break label45;
    }
    label45: for (boolean bool = true; ; bool = false)
    {
      this.mShowSendToExpenseLinkToggle = bool;
      notifyDataSetChanged();
      return;
    }
  }

  static class ExpenseLinkItemViewHolder
  {
    private final ExpenseLinkResources mExpenseLinkResources;
    private final CompoundButton.OnCheckedChangeListener mListenerChecked;

    @InjectView(2131427643)
    Switch mSwitchSendToExpense;

    @InjectView(2131427642)
    UberTextView mTextViewExpense;

    ExpenseLinkItemViewHolder(View paramView, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, ExpenseLinkResources paramExpenseLinkResources)
    {
      ButterKnife.inject(this, paramView);
      this.mListenerChecked = paramOnCheckedChangeListener;
      this.mExpenseLinkResources = paramExpenseLinkResources;
      this.mSwitchSendToExpense.setOnCheckedChangeListener(this.mListenerChecked);
    }

    void update(String paramString, TripExpenseInfo paramTripExpenseInfo, ViewGroup paramViewGroup)
    {
      ExpenseLinkResource localExpenseLinkResource = this.mExpenseLinkResources.getResource(paramString);
      if (localExpenseLinkResource == null)
      {
        paramViewGroup.setVisibility(8);
        return;
      }
      int i = localExpenseLinkResource.getDrawableListIcon();
      String str = localExpenseLinkResource.getLocalizedText();
      this.mTextViewExpense.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      this.mTextViewExpense.setText(str);
      this.mSwitchSendToExpense.setOnCheckedChangeListener(null);
      this.mSwitchSendToExpense.setChecked(paramTripExpenseInfo.isExpenseTrip());
      this.mSwitchSendToExpense.setOnCheckedChangeListener(this.mListenerChecked);
    }
  }

  static abstract interface Listener
  {
    public abstract void onSendExpenseChanged(boolean paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.ExpenseAdapter
 * JD-Core Version:    0.6.2
 */