package com.ubercab.client.feature.payment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.AddFundsDefaultValues;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.PaymentCheckBalanceResponse;
import com.ubercab.client.core.model.PaymentDepositRequestResponse;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.events.PaymentCheckBalanceResponseEvent;
import com.ubercab.client.core.network.events.PaymentDepositRequestResponseEvent;
import com.ubercab.client.core.util.NumberUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class AddFundsFragment extends RiderFragment
{
  private static final String ARG_PAYMENT_DEFAULT_VALUE = "default_value";
  private static final String ARG_UUID = "uuid";
  private static final String INDIA_CURRENCY_CODE = "INR";
  private static final int INDIA_CURRENCY_MAX = 10000;
  private static final int INDIA_CURRENCY_MIN = 0;
  private static final String INDIA_CURRENCY_SYMBOL = "₨";

  @Inject
  AnalyticsClient mAnalyticsClient;

  @InjectView(2131427586)
  UberButton mButtonDenomination1;

  @InjectView(2131427587)
  UberButton mButtonDenomination2;

  @InjectView(2131427588)
  UberButton mButtonDenomination3;

  @InjectView(2131427589)
  UberButton mButtonSubmit;

  @Inject
  Context mContext;
  private int mDefaultValue;
  private int mDenomination1;
  private int mDenomination2;
  private int mDenomination3;

  @InjectView(2131427582)
  UberEditText mEditTextAddFunds;

  @Inject
  PaymentClient mPaymentClient;

  @InjectView(2131427584)
  ProgressBar mProgressBarCurrentBalanceRequest;

  @InjectView(2131427583)
  UberTextView mTextViewBalanceValue;

  @InjectView(2131427581)
  UberTextView mTextViewCurrencyCodeAddFunds;

  @InjectView(2131427590)
  UberTextView mTextViewMinimumBalanceValue;

  @InjectView(2131427580)
  UberTextView mTextViewTitleAddFunds;
  private String mUuid;

  @InjectView(2131427585)
  ViewGroup mViewGroupDenominations;

  public static AddFundsFragment newInstance(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("default_value", paramInt);
    localBundle.putString("uuid", paramString);
    AddFundsFragment localAddFundsFragment = new AddFundsFragment();
    localAddFundsFragment.setArguments(localBundle);
    return localAddFundsFragment;
  }

  private void updateAddFundsValue(int paramInt)
  {
    int i = NumberUtils.tryParseInteger(this.mEditTextAddFunds.getText().toString(), 0);
    if (i + paramInt <= 10000);
    for (int j = i + paramInt; ; j = 10000)
    {
      this.mEditTextAddFunds.setText(String.valueOf(j));
      this.mEditTextAddFunds.setSelection(this.mEditTextAddFunds.getText().length());
      return;
    }
  }

  private void updateUI()
  {
    if ((this.mDenomination1 == 0) || (this.mDenomination2 == 0) || (this.mDenomination3 == 0))
      this.mViewGroupDenominations.setVisibility(8);
    while (true)
    {
      this.mTextViewCurrencyCodeAddFunds.setText("₨");
      return;
      UberButton localUberButton1 = this.mButtonDenomination1;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = "₨";
      arrayOfObject1[1] = Integer.valueOf(this.mDenomination1);
      localUberButton1.setText(getString(2131558429, arrayOfObject1));
      UberButton localUberButton2 = this.mButtonDenomination2;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = "₨";
      arrayOfObject2[1] = Integer.valueOf(this.mDenomination2);
      localUberButton2.setText(getString(2131558429, arrayOfObject2));
      UberButton localUberButton3 = this.mButtonDenomination3;
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = "₨";
      arrayOfObject3[1] = Integer.valueOf(this.mDenomination3);
      localUberButton3.setText(getString(2131558429, arrayOfObject3));
      this.mTextViewMinimumBalanceValue.setText("₨" + this.mDenomination1);
    }
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.WALLET_FUND_ADD_MONEY;
  }

  @OnClick({2131427589})
  public void onClickButtonSubmit()
  {
    int i = NumberUtils.tryParseInteger(this.mEditTextAddFunds.getText().toString(), 0);
    if (i != 0)
    {
      showLoadingDialogSticky(getString(2131559010), null);
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_FUND_ADD_MONEY_ADD);
      this.mPaymentClient.depositRequest(this.mUuid, i, "INR");
      return;
    }
    showToast(getString(2131558431));
  }

  @OnClick({2131427586})
  public void onClickFirstValue()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_FUND_ADD_MONEY_AMT_1);
    updateAddFundsValue(this.mDenomination1);
  }

  @OnClick({2131427587})
  public void onClickSecondValue()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_FUND_ADD_MONEY_AMT_2);
    updateAddFundsValue(this.mDenomination2);
  }

  @OnClick({2131427588})
  public void onClickThirdValue()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_FUND_ADD_MONEY_AMT_3);
    updateAddFundsValue(this.mDenomination3);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mDefaultValue = localBundle.getInt("default_value");
      this.mUuid = localBundle.getString("uuid");
      this.mPaymentClient.checkBalance(this.mUuid);
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903134, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onPaymentCheckBalanceResponseEvent(PaymentCheckBalanceResponseEvent paramPaymentCheckBalanceResponseEvent)
  {
    this.mProgressBarCurrentBalanceRequest.setVisibility(8);
    if (!paramPaymentCheckBalanceResponseEvent.isSuccess())
    {
      showToast(getString(2131558428));
      return;
    }
    String str = ((PaymentCheckBalanceResponse)paramPaymentCheckBalanceResponseEvent.getModel()).getDisplayAmount();
    this.mTextViewBalanceValue.setText(str);
  }

  @Subscribe
  public void onPaymentDepositRequestResponseEvent(PaymentDepositRequestResponseEvent paramPaymentDepositRequestResponseEvent)
  {
    hideLoadingDialog();
    if (!paramPaymentDepositRequestResponseEvent.isSuccess())
    {
      showToast(getString(2131559011));
      return;
    }
    PaymentDepositRequestResponse localPaymentDepositRequestResponse = (PaymentDepositRequestResponse)paramPaymentDepositRequestResponseEvent.getModel();
    String str1 = getString(2131558434);
    String str2 = localPaymentDepositRequestResponse.getUrl();
    String str3 = localPaymentDepositRequestResponse.getData();
    startActivity(AddFundsWebViewActivity.newIntent(this.mContext, str1, str2, str3));
    getActivity().finish();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (PingUtils.hasRiderAppConfig(localPing))
    {
      AddFundsDefaultValues localAddFundsDefaultValues = localPing.getAppConfig().getRiderConfig().getAddFundsDefaultValues();
      if (localAddFundsDefaultValues != null)
      {
        this.mDenomination1 = localAddFundsDefaultValues.getDenomination1();
        this.mDenomination2 = localAddFundsDefaultValues.getDenomination2();
        this.mDenomination3 = localAddFundsDefaultValues.getDenomination3();
      }
    }
    updateUI();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonSubmit.setText(getString(2131558422));
    UberEditText localUberEditText1 = this.mEditTextAddFunds;
    if (this.mDefaultValue != 0);
    for (String str = String.valueOf(this.mDefaultValue); ; str = null)
    {
      localUberEditText1.setText(str);
      this.mTextViewTitleAddFunds.setText(getString(2131558430));
      UberEditText localUberEditText2 = this.mEditTextAddFunds;
      InputFilter[] arrayOfInputFilter = new InputFilter[1];
      arrayOfInputFilter[0] = new InputFilterMinMax(0, 10000);
      localUberEditText2.setFilters(arrayOfInputFilter);
      return;
    }
  }

  private class InputFilterMinMax
    implements InputFilter
  {
    private int mMax;
    private int mMin;

    public InputFilterMinMax(int paramInt1, int arg3)
    {
      this.mMin = paramInt1;
      int i;
      this.mMax = i;
    }

    private boolean isInRange(int paramInt1, int paramInt2, int paramInt3)
    {
      return (paramInt3 >= paramInt1) && (paramInt3 <= paramInt2);
    }

    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      int i = NumberUtils.tryParseInteger(paramSpanned.toString() + paramCharSequence.toString(), 0);
      if (isInRange(this.mMin, this.mMax, i))
        return null;
      return "";
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsFragment
 * JD-Core Version:    0.6.2
 */