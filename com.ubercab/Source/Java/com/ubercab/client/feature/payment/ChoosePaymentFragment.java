package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.ApiResponse;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.CreatePaymentProfileResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.event.ChooseInternationalCreditCardEvent;
import com.ubercab.client.feature.payment.event.PaymentProfileAddedEvent;
import com.ubercab.client.feature.signup.LegalActivity;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.app.UberActivity;
import com.ubercab.library.util.PhoneNumberUtils;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class ChoosePaymentFragment extends RiderFragment
{
  private static final int REQUEST_CODE_WALLET_CONFIRMATION = 10;

  @Inject
  ActionBar mActionBar;

  @Inject
  Bus mBus;

  @InjectView(2131427593)
  UberButton mButtonPrepaid;

  @Inject
  Context mContext;
  private String mEmail;
  private String mMobileCountryIso;
  private String mMobileDigits;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427928)
  UberTextView mTextViewOr;

  public static boolean isEligible(GeoManager paramGeoManager)
  {
    return paramGeoManager.getGeo() == 4;
  }

  public static Fragment newInstance()
  {
    return new ChoosePaymentFragment();
  }

  private void sendCreatePaymentProfileRequest(String paramString1, String paramString2)
  {
    showLoadingDialogSticky(getString(2131558440), null);
    this.mRiderClient.createPaymentProfilePayTm(paramString1, paramString2);
  }

  private void updateUI(List<PaymentProfile> paramList)
  {
    if (Iterables.any(paramList, new Predicate()
    {
      public boolean apply(PaymentProfile paramAnonymousPaymentProfile)
      {
        return paramAnonymousPaymentProfile.isMobileWallet();
      }
    }))
    {
      this.mButtonPrepaid.setEnabled(false);
      this.mButtonPrepaid.setText(getString(2131559009));
    }
  }

  @OnClick({2131427591})
  public void onClickCreditCard()
  {
    this.mBus.post(new ChooseInternationalCreditCardEvent());
  }

  @OnClick({2131427597})
  public void onClickLegal()
  {
    startActivity(new Intent(getActivity(), LegalActivity.class));
  }

  @OnClick({2131427593})
  public void onClickPrepaid()
  {
    String str = PhoneNumberUtils.getDisplayPhoneNumber(this.mMobileDigits, this.mMobileCountryIso);
    PaymentWalletConfirmationFragment.show((UberActivity)getActivity(), 10, str);
  }

  @Subscribe
  public void onCreatePaymentProfileResponseEvent(CreatePaymentProfileResponseEvent paramCreatePaymentProfileResponseEvent)
  {
    hideLoadingDialog();
    if (paramCreatePaymentProfileResponseEvent.isSuccess())
    {
      Map localMap = ((Ping)paramCreatePaymentProfileResponseEvent.getModel()).getApiResponse().getData();
      if (localMap != null)
      {
        String str = (String)localMap.get("uuid");
        startActivity(PaymentOtpActivity.newIntent(this.mContext, str));
      }
      this.mBus.post(new PaymentProfileAddedEvent());
      return;
    }
    showToast(paramCreatePaymentProfileResponseEvent.getErrorMessage(getActivity()));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903135, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  void onDialogResult(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 10) && (paramInt2 == -1))
      sendCreatePaymentProfileRequest(this.mEmail, this.mMobileDigits);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (PingUtils.hasClient(localPing))
    {
      Client localClient = localPing.getClient();
      this.mEmail = localClient.getEmail();
      this.mMobileDigits = localClient.getMobileDigits();
      this.mMobileCountryIso = localClient.getMobileCountryIso2();
      updateUI(localClient.getPaymentProfiles());
    }
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558985));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mTextViewOr.setText(getString(2131558979));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.ChoosePaymentFragment
 * JD-Core Version:    0.6.2
 */