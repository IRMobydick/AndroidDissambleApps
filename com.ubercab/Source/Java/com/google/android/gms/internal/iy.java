package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class iy extends ImageView
{
  private Uri Lj;
  private int Lk;
  private int Ll;
  private a Lm;
  private int Ln;
  private float Lo;

  public void ay(int paramInt)
  {
    this.Lk = paramInt;
  }

  public void g(Uri paramUri)
  {
    this.Lj = paramUri;
  }

  public int gM()
  {
    return this.Lk;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.Lm != null)
      paramCanvas.clipPath(this.Lm.g(getWidth(), getHeight()));
    super.onDraw(paramCanvas);
    if (this.Ll != 0)
      paramCanvas.drawColor(this.Ll);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j;
    int i;
    switch (this.Ln)
    {
    default:
      return;
    case 1:
      j = getMeasuredHeight();
      i = (int)(j * this.Lo);
    case 2:
    }
    while (true)
    {
      setMeasuredDimension(i, j);
      return;
      i = getMeasuredWidth();
      j = (int)(i / this.Lo);
    }
  }

  public static abstract interface a
  {
    public abstract Path g(int paramInt1, int paramInt2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iy
 * JD-Core Version:    0.6.2
 */