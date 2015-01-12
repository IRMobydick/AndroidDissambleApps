package com.ubercab.client.feature.estimate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class RewardPointsFareEstimateFragment extends RiderDialogFragment
{
  private static final String FARE_ESTIMATE_POINTS_RANGE = "fare_estimate_points_range";

  @InjectView(2131427448)
  UberButton mButtonOk;

  @InjectView(2131427446)
  UberTextView mTextViewExplanation;

  @InjectView(2131427444)
  UberTextView mTextViewFare;

  @InjectView(2131427445)
  UberTextView mTextViewMembershipRewards;

  @InjectView(2131427447)
  UberTextView mTextViewMessage;

  @InjectView(2131427443)
  UberTextView mTextViewTitle;

  public static RewardPointsFareEstimateFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fare_estimate_points_range", paramString);
    RewardPointsFareEstimateFragment localRewardPointsFareEstimateFragment = new RewardPointsFareEstimateFragment();
    localRewardPointsFareEstimateFragment.setArguments(localBundle);
    return localRewardPointsFareEstimateFragment;
  }

  @OnClick({2131427448})
  public void onClickButtonOk()
  {
    dismiss();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(1, 0);
    setCancelable(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903079, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.mTextViewFare.setText(localBundle.getString("fare_estimate_points_range"));
    this.mTextViewTitle.setText(getString(2131558852));
    this.mTextViewMembershipRewards.setText(getString(2131558925));
    this.mTextViewExplanation.setText(getString(2131558857));
    this.mTextViewMessage.setText(getString(2131558854));
    this.mButtonOk.setText(getString(2131558973));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.RewardPointsFareEstimateFragment
 * JD-Core Version:    0.6.2
 */