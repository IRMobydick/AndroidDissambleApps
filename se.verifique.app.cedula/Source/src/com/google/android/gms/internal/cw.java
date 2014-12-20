package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.HashMap;
import java.util.Map;

public final class cw extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private final hk a;
  private final MediaController b;
  private final cx c;
  private final VideoView d;
  private long e;
  private String f;

  public cw(Context paramContext, hk paramhk)
  {
    super(paramContext);
    this.a = paramhk;
    this.d = new VideoView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.d, localLayoutParams);
    this.b = new MediaController(paramContext);
    this.c = new cx(this);
    this.c.b();
    this.d.setOnCompletionListener(this);
    this.d.setOnPreparedListener(this);
    this.d.setOnErrorListener(this);
  }

  private static void a(hk paramhk, String paramString)
  {
    a(paramhk, paramString, new HashMap(1));
  }

  public static void a(hk paramhk, String paramString1, String paramString2)
  {
    int i;
    if (paramString2 == null)
    {
      i = 1;
      if (i == 0)
        break label60;
    }
    label60: for (int j = 2; ; j = 3)
    {
      HashMap localHashMap = new HashMap(j);
      localHashMap.put("what", paramString1);
      if (i == 0)
        localHashMap.put("extra", paramString2);
      a(paramhk, "error", localHashMap);
      return;
      i = 0;
      break;
    }
  }

  private static void a(hk paramhk, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put(paramString2, paramString3);
    a(paramhk, paramString1, localHashMap);
  }

  private static void a(hk paramhk, String paramString, Map paramMap)
  {
    paramMap.put("event", paramString);
    paramhk.a("onVideoEvent", paramMap);
  }

  public void a()
  {
    this.c.a();
    this.d.stopPlayback();
  }

  public void a(int paramInt)
  {
    this.d.seekTo(paramInt);
  }

  public void a(MotionEvent paramMotionEvent)
  {
    this.d.dispatchTouchEvent(paramMotionEvent);
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.d.setMediaController(this.b);
    while (true)
    {
      return;
      this.b.hide();
      this.d.setMediaController(null);
    }
  }

  public void b()
  {
    if (!TextUtils.isEmpty(this.f))
      this.d.setVideoPath(this.f);
    while (true)
    {
      return;
      a(this.a, "no_src", null);
    }
  }

  public void c()
  {
    this.d.pause();
  }

  public void d()
  {
    this.d.start();
  }

  public void e()
  {
    long l = this.d.getCurrentPosition();
    if (this.e != l)
    {
      float f1 = (float)l / 1000.0F;
      a(this.a, "timeupdate", "time", String.valueOf(f1));
      this.e = l;
    }
  }

  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a(this.a, "ended");
  }

  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a(this.a, String.valueOf(paramInt1), String.valueOf(paramInt2));
    return true;
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    float f1 = this.d.getDuration() / 1000.0F;
    a(this.a, "canplaythrough", "duration", String.valueOf(f1));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cw
 * JD-Core Version:    0.6.0
 */