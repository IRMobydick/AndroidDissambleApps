package com.ubercab.client.feature.music;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.music.event.ConnectToMusicProviderEvent;
import com.ubercab.client.feature.music.event.DownloadAppEvent;
import com.ubercab.client.feature.music.event.OpenAppEvent;
import com.ubercab.library.app.UberApplication;
import java.util.Map;
import javax.inject.Inject;

public class MusicTrayView extends RelativeLayout
{
  private static final String SPOTIFY_ID = "spotify";
  private static final String SPOTIFY_NAME = "Spotify";
  private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";

  @Inject
  Bus mBus;

  @InjectView(2131427531)
  ImageView mImageViewLeft;

  @InjectView(2131427533)
  ImageView mImageViewRight;
  private boolean mIsConnected;

  @InjectView(2131427532)
  TextView mTextViewTray;

  public MusicTrayView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MusicTrayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MusicTrayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      UberApplication.get(paramContext).inject(this);
  }

  @OnClick({2131427530})
  public void onClickMusicTray()
  {
    if (this.mIsConnected)
    {
      if (AndroidUtils.isPackageInstalled(getContext(), "com.spotify.music"))
      {
        this.mBus.post(new OpenAppEvent("com.spotify.music"));
        return;
      }
      this.mBus.post(new DownloadAppEvent("com.spotify.music"));
      return;
    }
    this.mBus.post(new ConnectToMusicProviderEvent());
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }

  public void update(Ping paramPing)
  {
    boolean bool;
    Context localContext;
    if (PingUtils.hasClient(paramPing))
    {
      Map localMap = paramPing.getClient().getThirdPartyIdentities();
      if ((localMap == null) || (!localMap.containsKey("spotify")))
        break label101;
      bool = true;
      this.mIsConnected = bool;
      localContext = getContext();
      if (!this.mIsConnected)
        break label132;
      if (!AndroidUtils.isPackageInstalled(localContext, "com.spotify.music"))
        break label106;
      this.mTextViewTray.setText(localContext.getString(2131558484, new Object[] { "Spotify" }));
    }
    while (true)
    {
      this.mImageViewLeft.setVisibility(8);
      this.mImageViewRight.setVisibility(0);
      return;
      label101: bool = false;
      break;
      label106: this.mTextViewTray.setText(localContext.getString(2131558814, new Object[] { "Spotify" }));
    }
    label132: this.mImageViewLeft.setVisibility(0);
    this.mImageViewRight.setVisibility(8);
    this.mTextViewTray.setText(localContext.getString(2131558519, new Object[] { "Spotify" }));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicTrayView
 * JD-Core Version:    0.6.2
 */