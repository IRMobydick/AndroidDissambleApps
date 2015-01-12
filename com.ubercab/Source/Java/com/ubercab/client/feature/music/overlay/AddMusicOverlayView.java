package com.ubercab.client.feature.music.overlay;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.library.app.UberApplication;
import javax.inject.Inject;

public class AddMusicOverlayView extends RelativeLayout
{

  @Inject
  SessionPreferences mSessionPreferences;

  public AddMusicOverlayView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AddMusicOverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AddMusicOverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      UberApplication.get(paramContext).inject(this);
  }

  @OnClick({2131427527})
  void onClickMusicOverlay()
  {
    setVisibility(8);
    this.mSessionPreferences.setAddMusicDismissed(true);
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.overlay.AddMusicOverlayView
 * JD-Core Version:    0.6.2
 */