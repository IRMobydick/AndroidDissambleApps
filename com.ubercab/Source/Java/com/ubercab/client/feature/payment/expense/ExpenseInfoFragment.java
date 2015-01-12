package com.ubercab.client.feature.payment.expense;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.feature.payment.event.CancelExpenseInfoEvent;
import com.ubercab.client.feature.payment.event.SaveExpenseInfoEvent;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class ExpenseInfoFragment extends RiderFragment
{

  @Inject
  ActionBar mActionBar;
  private ActionViewHolder mActionViewHolder;

  @Inject
  Bus mBus;

  @InjectView(2131427563)
  UberEditText mEditTextCode;

  @InjectView(2131427564)
  UberEditText mEditTextMemo;
  private TripExpenseInfo mLastExpenseInfo;

  @Inject
  PingProvider mPingProvider;

  @InjectView(2131427562)
  UberTextView mTextExpenseInfoDescription;

  @InjectView(2131427565)
  UberTextView mTextUseLastExpenseInfo;

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.EXPENSE_INFO;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903130, paramViewGroup, false);
    ButterKnife.inject(this, localView1);
    View localView2 = paramLayoutInflater.inflate(2130903120, null);
    this.mActionViewHolder = new ActionViewHolder(localView2, getActivity().getIntent().getBooleanExtra("EXTRA_SHOW_SKIP_BUTTON", false));
    this.mActionBar.setDisplayOptions(16, 26);
    this.mActionBar.setCustomView(localView2, new ActionBar.LayoutParams(-1, -1));
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mLastExpenseInfo = this.mPingProvider.get().getClient().getLastExpenseInfo();
    return localView1;
  }

  @OnTextChanged({2131427563})
  void onExpenseCodeTextChanged()
  {
    this.mActionViewHolder.setConfirmButtonLabel();
  }

  @OnTextChanged({2131427564})
  void onExpenseMemoTextChanged()
  {
    this.mActionViewHolder.setConfirmButtonLabel();
  }

  @OnClick({2131427565})
  void onUseLastExpenseInfoClicked()
  {
    this.mEditTextCode.setText(this.mLastExpenseInfo.getCode());
    this.mEditTextMemo.setText(this.mLastExpenseInfo.getMemo());
    KeyboardUtils.hideKeyboard(getActivity());
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.mTextExpenseInfoDescription.setText(getString(2131558849));
    if ((!TextUtils.isEmpty(this.mLastExpenseInfo.getCode())) || (!TextUtils.isEmpty(this.mLastExpenseInfo.getMemo())))
      this.mTextUseLastExpenseInfo.setText(getString(2131559323));
    TripExpenseInfo localTripExpenseInfo = (TripExpenseInfo)getActivity().getIntent().getParcelableExtra("com.ubercab.EXPENSE_INFO");
    if (localTripExpenseInfo != null)
    {
      if (!TextUtils.isEmpty(localTripExpenseInfo.getCode()))
        break label126;
      this.mEditTextCode.setHint(getString(2131558425));
      if (!TextUtils.isEmpty(localTripExpenseInfo.getMemo()))
        break label140;
      this.mEditTextMemo.setHint(getString(2131558426));
    }
    while (true)
    {
      this.mActionViewHolder.setConfirmButtonLabel();
      return;
      label126: this.mEditTextCode.setText(localTripExpenseInfo.getCode());
      break;
      label140: this.mEditTextMemo.setText(localTripExpenseInfo.getMemo());
    }
  }

  final class ActionViewHolder
  {

    @InjectView(2131427547)
    View actionButtonCancel;

    @InjectView(2131427549)
    View actionButtonSave;
    boolean mIsShowSkipButton;

    @InjectView(2131427548)
    UberTextView textViewCancel;

    @InjectView(2131427550)
    UberTextView textViewSave;

    ActionViewHolder(View paramBoolean, boolean arg3)
    {
      ButterKnife.inject(this, paramBoolean);
      boolean bool;
      this.mIsShowSkipButton = bool;
      setConfirmButtonLabel();
      this.textViewCancel.setText(ExpenseInfoFragment.this.getString(2131558467));
    }

    @OnClick({2131427547})
    void onCancelClicked()
    {
      ExpenseInfoFragment.this.mBus.post(new CancelExpenseInfoEvent());
    }

    @OnClick({2131427549})
    void onSaveClicked()
    {
      ExpenseInfoFragment.this.mBus.post(new SaveExpenseInfoEvent(ExpenseInfoFragment.this.mEditTextCode.getText().toString(), ExpenseInfoFragment.this.mEditTextMemo.getText().toString()));
    }

    void setConfirmButtonLabel()
    {
      if ((TextUtils.isEmpty(ExpenseInfoFragment.this.mEditTextCode.getText())) && (TextUtils.isEmpty(ExpenseInfoFragment.this.mEditTextMemo.getText())))
      {
        setSkipLabel();
        return;
      }
      setSaveLabel();
    }

    void setSaveLabel()
    {
      this.textViewSave.setText(ExpenseInfoFragment.this.getString(2131559042));
      this.textViewSave.setTextColor(ExpenseInfoFragment.this.getResources().getColor(2131296333));
    }

    void setSkipLabel()
    {
      if (this.mIsShowSkipButton)
      {
        this.textViewSave.setText(ExpenseInfoFragment.this.getString(2131559074));
        this.textViewSave.setTextColor(ExpenseInfoFragment.this.getResources().getColor(2131296316));
        return;
      }
      setSaveLabel();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseInfoFragment
 * JD-Core Version:    0.6.2
 */