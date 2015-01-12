package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ez
public final class gm
{
  private final Context mContext;
  private int mState = 0;
  private final float ri;
  private String ws;
  private float wt;
  private float wu;
  private float wv;

  public gm(Context paramContext)
  {
    this.mContext = paramContext;
    this.ri = paramContext.getResources().getDisplayMetrics().density;
  }

  public gm(Context paramContext, String paramString)
  {
    this(paramContext);
    this.ws = paramString;
  }

  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      this.mState = 0;
      this.wt = paramFloat1;
      this.wu = paramFloat2;
      this.wv = paramFloat2;
    }
    label24: label224: 
    do
    {
      do
      {
        break label24;
        do
          return;
        while (this.mState == -1);
        if (paramInt != 2)
          break;
        if (paramFloat2 > this.wu)
          this.wu = paramFloat2;
        while (this.wu - this.wv > 30.0F * this.ri)
        {
          this.mState = -1;
          return;
          if (paramFloat2 < this.wv)
            this.wv = paramFloat2;
        }
        if ((this.mState == 0) || (this.mState == 2))
          if (paramFloat1 - this.wt >= 50.0F * this.ri)
            this.wt = paramFloat1;
        for (this.mState = (1 + this.mState); ; this.mState = (1 + this.mState))
        {
          do
          {
            if ((this.mState != 1) && (this.mState != 3))
              break label224;
            if (paramFloat1 <= this.wt)
              break;
            this.wt = paramFloat1;
            return;
          }
          while (((this.mState != 1) && (this.mState != 3)) || (paramFloat1 - this.wt > -50.0F * this.ri));
          this.wt = paramFloat1;
        }
      }
      while ((this.mState != 2) || (paramFloat1 >= this.wt));
      this.wt = paramFloat1;
      return;
    }
    while ((paramInt != 1) || (this.mState != 4));
    showDialog();
  }

  private void showDialog()
  {
    final String str1;
    if (!TextUtils.isEmpty(this.ws))
    {
      Uri localUri = new Uri.Builder().encodedQuery(this.ws).build();
      StringBuilder localStringBuilder = new StringBuilder();
      Map localMap = gj.c(localUri);
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
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
      localBuilder.setMessage(str1);
      localBuilder.setTitle("Ad Information");
      localBuilder.setPositiveButton("Share", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          gm.a(gm.this).startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str1), "Share via"));
        }
      });
      localBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
        }
      });
      localBuilder.create().show();
      return;
      str1 = "No debug information";
      continue;
      str1 = "No debug information";
    }
  }

  public void Q(String paramString)
  {
    this.ws = paramString;
  }

  public void c(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getHistorySize();
    for (int j = 0; j < i; j++)
      a(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, j), paramMotionEvent.getHistoricalY(0, j));
    a(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gm
 * JD-Core Version:    0.6.2
 */