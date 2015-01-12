package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.RewardsEnrollmentUpdateResponseEvent;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class RewardInfoFragment extends RiderFragment
{
  private static final String ARG_CARD_NUMBER = "card_number";
  private static final String ARG_IS_EARN_ONLY = "is_earn_only";
  private static final String ARG_PAYMENT_PROFILE_ID = "payment_profile_id";

  @Inject
  ActionBar mActionBar;

  @InjectView(2131427604)
  UberButton mButtonEnrollMe;
  private String mCardNumber;
  private boolean mIsEarnOnly;
  private String mPaymentProfileId;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427928)
  UberTextView mTextViewActionRequired;

  @InjectView(2131427615)
  UberTextView mTextViewNotRightNow;

  @InjectView(2131427613)
  UberTextView mTextViewRewardInfo;

  @InjectView(2131427608)
  UberTextView mTextViewRewardLink;

  @InjectView(2131427607)
  UberTextView mTextViewRewardRestrictions;

  public static RewardInfoFragment newInstance(String paramString1, String paramString2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payment_profile_id", paramString1);
    localBundle.putString("card_number", paramString2);
    localBundle.putBoolean("is_earn_only", paramBoolean);
    RewardInfoFragment localRewardInfoFragment = new RewardInfoFragment();
    localRewardInfoFragment.setArguments(localBundle);
    return localRewardInfoFragment;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mActionBar.setDisplayHomeAsUpEnabled(true);
    this.mActionBar.setTitle(getString(2131558881).toUpperCase());
  }

  @OnClick({2131427604})
  public void onClickEnrollMe()
  {
    this.mRiderClient.updateRewardData(this.mPaymentProfileId, Boolean.valueOf(true), null);
  }

  @OnClick({2131427615})
  public void onClickNotRightNow()
  {
    this.mRiderClient.updateRewardData(this.mPaymentProfileId, Boolean.valueOf(false), null);
    getActivity().finish();
  }

  @OnClick({2131427614})
  public void onClickTerms()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(2131559117))));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mPaymentProfileId = localBundle.getString("payment_profile_id");
      this.mCardNumber = localBundle.getString("card_number");
      this.mIsEarnOnly = localBundle.getBoolean("is_earn_only");
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903138, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onRewardsEnrollmentUpdateResponse(RewardsEnrollmentUpdateResponseEvent paramRewardsEnrollmentUpdateResponseEvent)
  {
    if (paramRewardsEnrollmentUpdateResponseEvent.isSuccess())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.mCardNumber;
      showToast(getString(2131558843, arrayOfObject));
      getActivity().finish();
      return;
    }
    showToast(getString(2131558842));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mTextViewActionRequired.setText(getString(2131558421));
    UberTextView localUberTextView = this.mTextViewRewardInfo;
    Object[] arrayOfObject2;
    if (this.mIsEarnOnly)
    {
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.mCardNumber;
    }
    Object[] arrayOfObject1;
    for (String str = getString(2131558838, arrayOfObject2); ; str = getString(2131558839, arrayOfObject1))
    {
      localUberTextView.setText(str);
      this.mTextViewRewardRestrictions.setText(getString(2131559037));
      this.mTextViewRewardLink.setText(getString(2131559118));
      this.mButtonEnrollMe.setText(getString(2131558834));
      this.mTextViewNotRightNow.setText(getString(2131558945));
      return;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.mCardNumber;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.RewardInfoFragment
 * JD-Core Version:    0.6.2
 */