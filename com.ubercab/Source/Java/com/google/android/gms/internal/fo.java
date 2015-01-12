package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.o;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public class fo
  implements Callable<fz>
{
  private final Context mContext;
  private final Object mw = new Object();
  private final u pw;
  private final go tX;
  private final ai tY;
  private boolean tZ;
  private int tc;
  private final fz.a tn;
  private List<String> ua;

  public fo(Context paramContext, u paramu, ai paramai, go paramgo, fz.a parama)
  {
    this.mContext = paramContext;
    this.pw = paramu;
    this.tX = paramgo;
    this.tY = paramai;
    this.tn = parama;
    this.tZ = false;
    this.tc = -2;
    this.ua = null;
  }

  private bq.a a(ah paramah, a parama, JSONObject paramJSONObject)
    throws ExecutionException, InterruptedException, JSONException
  {
    if (cH())
      return null;
    String[] arrayOfString = b(paramJSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
    if (arrayOfString == null);
    bq.a locala;
    for (List localList = null; ; localList = Arrays.asList(arrayOfString))
    {
      this.ua = localList;
      locala = parama.a(this, paramJSONObject);
      if (locala != null)
        break;
      gs.T("Failed to retrieve ad assets.");
      return null;
    }
    locala.a(new bq(this.pw, paramah, paramJSONObject));
    return locala;
  }

  private fz a(bq.a parama)
  {
    while (true)
    {
      synchronized (this.mw)
      {
        int i = this.tc;
        if ((parama == null) && (this.tc == -2))
          i = 0;
        if (i != -2)
        {
          locala = null;
          return new fz(this.tn.vv.tx, null, this.tn.vw.qf, i, this.tn.vw.qg, this.ua, this.tn.vw.orientation, this.tn.vw.qj, this.tn.vv.tA, false, null, null, null, null, null, 0L, this.tn.lH, this.tn.vw.tH, this.tn.vs, this.tn.vt, this.tn.vw.tN, this.tn.vp, locala);
        }
      }
      bq.a locala = parama;
    }
  }

  private String[] b(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray == null)
      return null;
    String[] arrayOfString = new String[localJSONArray.length()];
    for (int i = 0; i < localJSONArray.length(); i++)
      arrayOfString[i] = localJSONArray.getString(i);
    return arrayOfString;
  }

  private JSONObject c(final ah paramah)
    throws TimeoutException, JSONException
  {
    if (cH())
      return null;
    final gk localgk = new gk();
    paramah.a("/nativeAdPreProcess", new by()
    {
      public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
      {
        paramah.g("/nativeAdPreProcess");
        try
        {
          String str = (String)paramAnonymousMap.get("success");
          if (!TextUtils.isEmpty(str))
          {
            localgk.a(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          gs.b("Malformed native JSON response.", localJSONException);
          fo.this.s(0);
          o.a(fo.this.cH(), "Unable to set the ad state error!");
          localgk.a(null);
        }
      }
    });
    paramah.a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.tn.vw.tG));
    return (JSONObject)localgk.get();
  }

  private ah cG()
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    if (cH())
      return null;
    ah localah = (ah)this.tY.a(this.mContext, this.tn.vv.lD, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
    localah.a(this.pw, this.pw, this.pw, this.pw, false, this.pw);
    return localah;
  }

  public Future<Drawable> a(JSONObject paramJSONObject, String paramString, final boolean paramBoolean)
    throws JSONException
  {
    JSONObject localJSONObject;
    if (paramBoolean)
    {
      localJSONObject = paramJSONObject.getJSONObject(paramString);
      if (localJSONObject == null)
        localJSONObject = new JSONObject();
      if (!paramBoolean)
        break label71;
    }
    label71: for (String str = localJSONObject.getString("url"); ; str = localJSONObject.optString("url"))
    {
      if (!TextUtils.isEmpty(str))
        break label83;
      a(0, paramBoolean);
      return new gl(null);
      localJSONObject = paramJSONObject.optJSONObject(paramString);
      break;
    }
    label83: return this.tX.a(str, new go.a()
    {
      public Drawable a(InputStream paramAnonymousInputStream)
      {
        try
        {
          byte[] arrayOfByte2 = jy.d(paramAnonymousInputStream);
          arrayOfByte1 = arrayOfByte2;
          if (arrayOfByte1 == null)
          {
            fo.this.a(2, paramBoolean);
            return null;
          }
        }
        catch (IOException localIOException)
        {
          byte[] arrayOfByte1;
          while (true)
            arrayOfByte1 = null;
          Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte1, 0, arrayOfByte1.length);
          if (localBitmap == null)
          {
            fo.this.a(2, paramBoolean);
            return null;
          }
          return new BitmapDrawable(Resources.getSystem(), localBitmap);
        }
      }

      public Drawable cI()
      {
        fo.this.a(2, paramBoolean);
        return null;
      }
    });
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      s(paramInt);
  }

  protected a b(JSONObject paramJSONObject)
    throws JSONException
  {
    if (cH())
      return null;
    String str = paramJSONObject.getString("template_id");
    if ("2".equals(str))
      return new fp();
    if ("1".equals(str))
      return new fq();
    s(0);
    return null;
  }

  public fz cF()
  {
    try
    {
      ah localah = cG();
      JSONObject localJSONObject = c(localah);
      fz localfz = a(a(localah, b(localJSONObject), localJSONObject));
      return localfz;
    }
    catch (JSONException localJSONException)
    {
      gs.d("Malformed native JSON response.", localJSONException);
      if (!this.tZ)
        s(0);
      return a(null);
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
        gs.d("Timeout when loading native ad.", localTimeoutException);
    }
    catch (InterruptedException localInterruptedException)
    {
      break label47;
    }
    catch (ExecutionException localExecutionException)
    {
      break label47;
    }
    catch (CancellationException localCancellationException)
    {
      label47: break label47;
    }
  }

  public boolean cH()
  {
    synchronized (this.mw)
    {
      boolean bool = this.tZ;
      return bool;
    }
  }

  public void s(int paramInt)
  {
    synchronized (this.mw)
    {
      this.tZ = true;
      this.tc = paramInt;
      return;
    }
  }

  public static abstract interface a<T extends bq.a>
  {
    public abstract T a(fo paramfo, JSONObject paramJSONObject)
      throws JSONException, InterruptedException, ExecutionException;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fo
 * JD-Core Version:    0.6.2
 */