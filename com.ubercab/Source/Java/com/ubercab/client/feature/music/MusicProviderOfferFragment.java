package com.ubercab.client.feature.music;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ubercab.library.app.UberFragment;

public class MusicProviderOfferFragment extends UberFragment
{
  static Fragment newInstance()
  {
    return new MusicProviderOfferFragment();
  }

  @OnClick({2131427522})
  public void onClickLinkProvider()
  {
    Activity localActivity = getActivity();
    startActivity(new Intent(localActivity, SpotifyInterstitialActivity.class));
    localActivity.finish();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903109, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderOfferFragment
 * JD-Core Version:    0.6.2
 */