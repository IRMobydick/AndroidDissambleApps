package com.ubercab.client.feature.forceupgrade;

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
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.util.RiderUtil;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class ForceUpgradeFragment extends RiderFragment
{
  private static final String FORCE_UPGRADE_URL = "forceUpgradeUrl";

  @InjectView(2131427477)
  UberButton mButtonUpdate;
  private String mForceUpgradeUrl;

  @InjectView(2131427476)
  UberTextView mTextViewSubtitle;

  @InjectView(2131427475)
  UberTextView mTextViewTitle;

  public static ForceUpgradeFragment newInstance(String paramString)
  {
    ForceUpgradeFragment localForceUpgradeFragment = new ForceUpgradeFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("forceUpgradeUrl", paramString);
    localForceUpgradeFragment.setArguments(localBundle);
    return localForceUpgradeFragment;
  }

  @OnClick({2131427477})
  public void onClickButtonUpdate()
  {
    if (this.mForceUpgradeUrl != null)
    {
      getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.mForceUpgradeUrl)));
      return;
    }
    RiderUtil.openGooglePlayStore(getActivity());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(false);
    if (paramBundle != null)
      this.mForceUpgradeUrl = paramBundle.getString("forceUpgradeUrl");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903089, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mTextViewTitle.setText(getString(2131558878));
    this.mTextViewSubtitle.setText(getString(2131558877));
    this.mButtonUpdate.setText(getString(2131559321));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.forceupgrade.ForceUpgradeFragment
 * JD-Core Version:    0.6.2
 */