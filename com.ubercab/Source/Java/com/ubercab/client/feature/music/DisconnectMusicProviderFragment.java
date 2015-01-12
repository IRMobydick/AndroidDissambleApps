package com.ubercab.client.feature.music;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.ubercab.library.app.UberFragment;
import com.ubercab.ui.UberButton;
import javax.inject.Inject;

public class DisconnectMusicProviderFragment extends UberFragment
{
  private static final String ARG_PROVIDER_NAME = "provider_name";

  @Inject
  Bus mBus;

  @InjectView(2131427513)
  UberButton mButtonDisconnect;

  @InjectView(2131427512)
  TextView mTextViewName;

  static Fragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("provider_name", paramString);
    DisconnectMusicProviderFragment localDisconnectMusicProviderFragment = new DisconnectMusicProviderFragment();
    localDisconnectMusicProviderFragment.setArguments(localBundle);
    return localDisconnectMusicProviderFragment;
  }

  @OnClick({2131427513})
  public void onClickDisconnect()
  {
    this.mBus.post(new DisconnectMusicProviderEvent());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903104, paramViewGroup, false);
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
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      String str = localBundle.getString("provider_name");
      this.mButtonDisconnect.setText(getString(2131558812, new Object[] { str }));
      this.mTextViewName.setText(str);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.DisconnectMusicProviderFragment
 * JD-Core Version:    0.6.2
 */