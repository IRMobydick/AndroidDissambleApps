package com.ubercab.client.feature.music;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.ui.UberButton;
import javax.inject.Inject;

public class LinkMusicProviderFragment extends RiderFragment
{
  private static final int REQUEST_CODE_SPOTIFY_AUTH = 1;
  private static final String SPOTIFY_ID = "spotify";

  @Inject
  ActionBar mActionBar;

  @InjectView(2131427520)
  UberButton mButtonLinkProvider;

  @Inject
  RiderClient mRiderClient;

  static Fragment newInstance()
  {
    return new LinkMusicProviderFragment();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Activity localActivity;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("com.ubercab.AUTHORIZATION_CODE");
      this.mRiderClient.createThirdPartyIdentity("spotify", str);
      localActivity = getActivity();
      if (0 == 0)
        break label69;
      startActivity(new Intent(localActivity, MusicProviderOfferActivity.class));
    }
    while (true)
    {
      localActivity.finish();
      return;
      label69: startActivity(new Intent(localActivity, SpotifyInterstitialActivity.class));
    }
  }

  @OnClick({2131427520})
  public void onClickLinkProvider()
  {
    startActivityForResult(new Intent(getActivity(), MusicProviderAuthorizationActivity.class), 1);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActionBar.setTitle(getString(2131558435).toUpperCase());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903107, paramViewGroup, false);
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
    this.mButtonLinkProvider.setText(getString(2131558518, new Object[] { "Spotify" }));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.LinkMusicProviderFragment
 * JD-Core Version:    0.6.2
 */