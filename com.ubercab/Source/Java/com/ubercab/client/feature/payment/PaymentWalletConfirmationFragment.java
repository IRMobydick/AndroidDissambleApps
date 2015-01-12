package com.ubercab.client.feature.payment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.library.app.UberActivity;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class PaymentWalletConfirmationFragment extends RiderDialogFragment
{
  public static final String BUNDLE_WALLET_CONFIRMATION_PHONE_NUMBER = "dialog.phone_number";
  public static final String TAG = PaymentWalletConfirmationFragment.class.getName();

  @InjectView(2131427547)
  UberButton mButtonCancel;

  @InjectView(2131427652)
  UberButton mButtonOk;
  private String mPhoneNumber;

  @InjectView(2131427649)
  UberTextView mTextViewConfirm;

  @InjectView(2131427651)
  UberTextView mTextViewDetails;

  @InjectView(2131427650)
  UberTextView mTextViewNumber;

  public static PaymentWalletConfirmationFragment newInstance()
  {
    return new PaymentWalletConfirmationFragment();
  }

  public static void show(UberActivity paramUberActivity, int paramInt, String paramString)
  {
    Bundle localBundle = createArguments(paramInt);
    localBundle.putString("dialog.phone_number", paramString);
    PaymentWalletConfirmationFragment localPaymentWalletConfirmationFragment = new PaymentWalletConfirmationFragment();
    localPaymentWalletConfirmationFragment.setArguments(localBundle);
    localPaymentWalletConfirmationFragment.show(paramUberActivity.getFragmentManager(), localPaymentWalletConfirmationFragment.getClass().getName());
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.PAYMENT_METHOD_LINK_PAYTM;
  }

  @OnClick({2131427547})
  public void onClickCancel()
  {
    onResult(0);
    dismiss();
  }

  @OnClick({2131427652})
  public void onClickOk()
  {
    onResult(-1);
    dismiss();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.mPhoneNumber = paramBundle.getString("dialog.phone_number");
      return;
    }
    this.mPhoneNumber = getArguments().getString("dialog.phone_number");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903149, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("dialog.phone_number", this.mPhoneNumber);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    getDialog().requestWindowFeature(1);
    this.mButtonCancel.setText(getString(2131558467));
    this.mButtonOk.setText(getString(2131558973));
    this.mTextViewConfirm.setText(getString(2131559346));
    this.mTextViewDetails.setText(getString(2131559347));
    this.mTextViewNumber.setText(this.mPhoneNumber);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentWalletConfirmationFragment
 * JD-Core Version:    0.6.2
 */