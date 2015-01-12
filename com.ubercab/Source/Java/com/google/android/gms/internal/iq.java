package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class iq extends ii
{
  private static final long Hb = TimeUnit.HOURS.toMillis(24L);
  private static final long Hc = TimeUnit.HOURS.toMillis(24L);
  private static final long Hd = TimeUnit.HOURS.toMillis(24L);
  private static final long He = TimeUnit.SECONDS.toMillis(1L);
  private static final String NAMESPACE = ik.aG("com.google.cast.media");
  private long Hf;
  private MediaStatus Hg;
  private final it Hh = new it(Hc);
  private final it Hi;
  private final it Hj;
  private final it Hk;
  private final it Hl;
  private final it Hm;
  private final it Hn;
  private final it Ho;
  private final it Hp;
  private final it Hq;
  private final List<it> Hr = new ArrayList();
  private final Runnable Hs = new a(null);
  private boolean Ht;
  private final Handler mHandler = new Handler(Looper.getMainLooper());

  public iq()
  {
    this(null);
  }

  public iq(String paramString)
  {
    super(NAMESPACE, "MediaControlChannel", paramString);
    this.Hr.add(this.Hh);
    this.Hi = new it(Hb);
    this.Hr.add(this.Hi);
    this.Hj = new it(Hb);
    this.Hr.add(this.Hj);
    this.Hk = new it(Hb);
    this.Hr.add(this.Hk);
    this.Hl = new it(Hd);
    this.Hr.add(this.Hl);
    this.Hm = new it(Hb);
    this.Hr.add(this.Hm);
    this.Hn = new it(Hb);
    this.Hr.add(this.Hn);
    this.Ho = new it(Hb);
    this.Hr.add(this.Ho);
    this.Hp = new it(Hb);
    this.Hr.add(this.Hp);
    this.Hq = new it(Hb);
    this.Hr.add(this.Hq);
    fT();
  }

  private void H(boolean paramBoolean)
  {
    if (this.Ht != paramBoolean)
    {
      this.Ht = paramBoolean;
      if (paramBoolean)
        this.mHandler.postDelayed(this.Hs, He);
    }
    else
    {
      return;
    }
    this.mHandler.removeCallbacks(this.Hs);
  }

  private void a(long paramLong, JSONObject paramJSONObject)
    throws JSONException
  {
    int i = 1;
    boolean bool = this.Hh.p(paramLong);
    int j;
    if ((this.Hl.fV()) && (!this.Hl.p(paramLong)))
    {
      j = i;
      if (((!this.Hm.fV()) || (this.Hm.p(paramLong))) && ((!this.Hn.fV()) || (this.Hn.p(paramLong))))
        break label227;
      label80: if (j == 0)
        break label249;
    }
    label227: label249: for (int k = 2; ; k = 0)
    {
      if (i != 0)
        k |= 1;
      if ((bool) || (this.Hg == null))
      {
        this.Hg = new MediaStatus(paramJSONObject);
        this.Hf = SystemClock.elapsedRealtime();
      }
      for (int m = 7; ; m = this.Hg.a(paramJSONObject, k))
      {
        if ((m & 0x1) != 0)
        {
          this.Hf = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((m & 0x2) != 0)
        {
          this.Hf = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((m & 0x4) != 0)
          onMetadataUpdated();
        Iterator localIterator = this.Hr.iterator();
        while (localIterator.hasNext())
          ((it)localIterator.next()).d(paramLong, 0);
        j = 0;
        break;
        i = 0;
        break label80;
      }
      return;
    }
  }

  private void fT()
  {
    H(false);
    this.Hf = 0L;
    this.Hg = null;
    this.Hh.clear();
    this.Hl.clear();
    this.Hm.clear();
  }

  public long a(is paramis)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fz();
    this.Ho.a(l, paramis);
    H(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "GET_STATUS");
      if (this.Hg != null)
        localJSONObject.put("mediaSessionId", this.Hg.fw());
      label65: a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label65;
    }
  }

  public long a(is paramis, double paramDouble, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble)))
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    JSONObject localJSONObject1 = new JSONObject();
    long l = fz();
    this.Hm.a(l, paramis);
    H(true);
    try
    {
      localJSONObject1.put("requestId", l);
      localJSONObject1.put("type", "SET_VOLUME");
      localJSONObject1.put("mediaSessionId", fw());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("level", paramDouble);
      localJSONObject1.put("volume", localJSONObject2);
      if (paramJSONObject != null)
        localJSONObject1.put("customData", paramJSONObject);
      label151: a(localJSONObject1.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label151;
    }
  }

  public long a(is paramis, long paramLong, int paramInt, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fz();
    this.Hl.a(l, paramis);
    H(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SEEK");
      localJSONObject.put("mediaSessionId", fw());
      localJSONObject.put("currentTime", ik.o(paramLong));
      if (paramInt == 1)
        localJSONObject.put("resumeState", "PLAYBACK_START");
      while (true)
      {
        if (paramJSONObject != null)
          localJSONObject.put("customData", paramJSONObject);
        label110: a(localJSONObject.toString(), l, null);
        return l;
        if (paramInt == 2)
          localJSONObject.put("resumeState", "PLAYBACK_PAUSE");
      }
    }
    catch (JSONException localJSONException)
    {
      break label110;
    }
  }

  public long a(is paramis, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, long[] paramArrayOfLong, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fz();
    this.Hh.a(l, paramis);
    H(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "LOAD");
      localJSONObject.put("media", paramMediaInfo.bK());
      localJSONObject.put("autoplay", paramBoolean);
      localJSONObject.put("currentTime", ik.o(paramLong));
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
      {
        JSONArray localJSONArray = new JSONArray();
        for (int i = 0; i < paramArrayOfLong.length; i++)
          localJSONArray.put(i, paramArrayOfLong[i]);
        localJSONObject.put("activeTrackIds", localJSONArray);
      }
      if (paramJSONObject != null)
        localJSONObject.put("customData", paramJSONObject);
      label165: a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label165;
    }
  }

  public long a(is paramis, TextTrackStyle paramTextTrackStyle)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fz();
    this.Hq.a(l, paramis);
    H(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      if (paramTextTrackStyle != null)
        localJSONObject.put("textTrackStyle", paramTextTrackStyle.bK());
      localJSONObject.put("mediaSessionId", fw());
      label75: a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label75;
    }
  }

  public long a(is paramis, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fz();
    this.Hi.a(l, paramis);
    H(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PAUSE");
      localJSONObject.put("mediaSessionId", fw());
      if (paramJSONObject != null)
        localJSONObject.put("customData", paramJSONObject);
      label72: a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label72;
    }
  }

  public long a(is paramis, boolean paramBoolean, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject1 = new JSONObject();
    long l = fz();
    this.Hn.a(l, paramis);
    H(true);
    try
    {
      localJSONObject1.put("requestId", l);
      localJSONObject1.put("type", "SET_VOLUME");
      localJSONObject1.put("mediaSessionId", fw());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("muted", paramBoolean);
      localJSONObject1.put("volume", localJSONObject2);
      if (paramJSONObject != null)
        localJSONObject1.put("customData", paramJSONObject);
      label107: a(localJSONObject1.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label107;
    }
  }

  public long a(is paramis, long[] paramArrayOfLong)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fz();
    this.Hp.a(l, paramis);
    H(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      localJSONObject.put("mediaSessionId", fw());
      JSONArray localJSONArray = new JSONArray();
      for (int i = 0; i < paramArrayOfLong.length; i++)
        localJSONArray.put(i, paramArrayOfLong[i]);
      localJSONObject.put("activeTrackIds", localJSONArray);
      label106: a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label106;
    }
  }

  public final void aD(String paramString)
  {
    this.Go.b("message received: %s", new Object[] { paramString });
    JSONObject localJSONObject1;
    String str;
    long l;
    try
    {
      localJSONObject1 = new JSONObject(paramString);
      str = localJSONObject1.getString("type");
      l = localJSONObject1.optLong("requestId", -1L);
      if (str.equals("MEDIA_STATUS"))
      {
        JSONArray localJSONArray = localJSONObject1.getJSONArray("status");
        if (localJSONArray.length() > 0)
        {
          a(l, localJSONArray.getJSONObject(0));
          return;
        }
        this.Hg = null;
        onStatusUpdated();
        onMetadataUpdated();
        this.Ho.d(l, 0);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      ip localip = this.Go;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localJSONException.getMessage();
      arrayOfObject[1] = paramString;
      localip.d("Message is malformed (%s); ignoring: %s", arrayOfObject);
      return;
    }
    if (str.equals("INVALID_PLAYER_STATE"))
    {
      this.Go.d("received unexpected error: Invalid Player State.", new Object[0]);
      JSONObject localJSONObject5 = localJSONObject1.optJSONObject("customData");
      Iterator localIterator2 = this.Hr.iterator();
      while (localIterator2.hasNext())
        ((it)localIterator2.next()).b(l, 2100, localJSONObject5);
    }
    if (str.equals("LOAD_FAILED"))
    {
      JSONObject localJSONObject4 = localJSONObject1.optJSONObject("customData");
      this.Hh.b(l, 2100, localJSONObject4);
      return;
    }
    if (str.equals("LOAD_CANCELLED"))
    {
      JSONObject localJSONObject3 = localJSONObject1.optJSONObject("customData");
      this.Hh.b(l, 2101, localJSONObject3);
      return;
    }
    if (str.equals("INVALID_REQUEST"))
    {
      this.Go.d("received unexpected error: Invalid Request.", new Object[0]);
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("customData");
      Iterator localIterator1 = this.Hr.iterator();
      while (localIterator1.hasNext())
        ((it)localIterator1.next()).b(l, 2100, localJSONObject2);
    }
  }

  public long b(is paramis, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fz();
    this.Hk.a(l, paramis);
    H(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "STOP");
      localJSONObject.put("mediaSessionId", fw());
      if (paramJSONObject != null)
        localJSONObject.put("customData", paramJSONObject);
      label72: a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label72;
    }
  }

  public void b(long paramLong, int paramInt)
  {
    Iterator localIterator = this.Hr.iterator();
    while (localIterator.hasNext())
      ((it)localIterator.next()).d(paramLong, paramInt);
  }

  public long c(is paramis, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fz();
    this.Hj.a(l, paramis);
    H(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PLAY");
      localJSONObject.put("mediaSessionId", fw());
      if (paramJSONObject != null)
        localJSONObject.put("customData", paramJSONObject);
      label72: a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label72;
    }
  }

  public void fA()
  {
    fT();
  }

  public long fw()
    throws IllegalStateException
  {
    if (this.Hg == null)
      throw new IllegalStateException("No current media session");
    return this.Hg.fw();
  }

  public long getApproximateStreamPosition()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo == null);
    while (this.Hf == 0L)
      return 0L;
    double d = this.Hg.getPlaybackRate();
    long l1 = this.Hg.getStreamPosition();
    int i = this.Hg.getPlayerState();
    if ((d == 0.0D) || (i != 2))
      return l1;
    long l2 = SystemClock.elapsedRealtime() - this.Hf;
    if (l2 < 0L);
    for (long l3 = 0L; ; l3 = l2)
    {
      if (l3 == 0L)
        return l1;
      long l4 = localMediaInfo.getStreamDuration();
      long l5 = l1 + ()(d * l3);
      if ((l4 > 0L) && (l5 > l4));
      while (true)
      {
        return l4;
        if (l5 < 0L)
          l4 = 0L;
        else
          l4 = l5;
      }
    }
  }

  public MediaInfo getMediaInfo()
  {
    if (this.Hg == null)
      return null;
    return this.Hg.getMediaInfo();
  }

  public MediaStatus getMediaStatus()
  {
    return this.Hg;
  }

  public long getStreamDuration()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo != null)
      return localMediaInfo.getStreamDuration();
    return 0L;
  }

  protected void onMetadataUpdated()
  {
  }

  protected void onStatusUpdated()
  {
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      boolean bool1 = false;
      iq.a(iq.this, false);
      long l = SystemClock.elapsedRealtime();
      Iterator localIterator1 = iq.a(iq.this).iterator();
      while (localIterator1.hasNext())
        ((it)localIterator1.next()).e(l, 2102);
      while (true)
      {
        synchronized (it.Hz)
        {
          Iterator localIterator2 = iq.a(iq.this).iterator();
          if (localIterator2.hasNext())
          {
            if (((it)localIterator2.next()).fV())
            {
              bool2 = true;
              break label137;
            }
          }
          else
          {
            iq.b(iq.this, bool1);
            return;
          }
        }
        boolean bool2 = bool1;
        label137: bool1 = bool2;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iq
 * JD-Core Version:    0.6.2
 */