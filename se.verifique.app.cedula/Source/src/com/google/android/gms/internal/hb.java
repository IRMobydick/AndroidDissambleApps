package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class hb
{
  private final Context a;
  private String b;
  private final float c;
  private float d;
  private float e;
  private float f;
  private int g = 0;

  public hb(Context paramContext)
  {
    this.a = paramContext;
    this.c = paramContext.getResources().getDisplayMetrics().density;
  }

  public hb(Context paramContext, String paramString)
  {
    this(paramContext);
    this.b = paramString;
  }

  private void a()
  {
    String str1;
    if (!TextUtils.isEmpty(this.b))
    {
      Uri localUri = new Uri.Builder().encodedQuery(this.b).build();
      StringBuilder localStringBuilder = new StringBuilder();
      Map localMap = gw.a(localUri);
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append(str2).append(" = ").append((String)localMap.get(str2)).append("\n\n");
      }
      str1 = localStringBuilder.toString().trim();
      if (TextUtils.isEmpty(str1));
    }
    while (true)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.a);
      localBuilder.setMessage(str1);
      localBuilder.setTitle("Ad Information");
      localBuilder.setPositiveButton("Share", new hc(this, str1));
      localBuilder.setNegativeButton("Close", new hd(this));
      localBuilder.create().show();
      return;
      str1 = "No debug information";
      continue;
      str1 = "No debug information";
    }
  }

  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      this.g = 0;
      this.d = paramFloat1;
      this.e = paramFloat2;
      this.f = paramFloat2;
    }
    while (true)
    {
      return;
      if (this.g != -1)
      {
        if (paramInt == 2)
        {
          if (paramFloat2 > this.e)
            this.e = paramFloat2;
          while (true)
          {
            if (this.e - this.f <= 30.0F * this.c)
              break label99;
            this.g = -1;
            break;
            if (paramFloat2 >= this.f)
              continue;
            this.f = paramFloat2;
          }
          label99: if ((this.g == 0) || (this.g == 2))
            if (paramFloat1 - this.d >= 50.0F * this.c)
              this.d = paramFloat1;
          for (this.g = (1 + this.g); ; this.g = (1 + this.g))
          {
            do
            {
              if ((this.g != 1) && (this.g != 3))
                break label230;
              if (paramFloat1 <= this.d)
                break;
              this.d = paramFloat1;
              break;
            }
            while (((this.g != 1) && (this.g != 3)) || (paramFloat1 - this.d > -50.0F * this.c));
            this.d = paramFloat1;
          }
          label230: if ((this.g != 2) || (paramFloat1 >= this.d))
            continue;
          this.d = paramFloat1;
          continue;
        }
        if ((paramInt != 1) || (this.g != 4))
          continue;
        a();
        continue;
      }
    }
  }

  public void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getHistorySize();
    for (int j = 0; j < i; j++)
      a(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, j), paramMotionEvent.getHistoricalY(0, j));
    a(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hb
 * JD-Core Version:    0.6.0
 */