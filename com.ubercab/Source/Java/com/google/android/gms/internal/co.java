package com.google.android.gms.internal;

@ez
public final class co extends cv.a
{
  private final Object mw = new Object();
  private cq.a qm;
  private cn qn;

  public void a(cn paramcn)
  {
    synchronized (this.mw)
    {
      this.qn = paramcn;
      return;
    }
  }

  public void a(cq.a parama)
  {
    synchronized (this.mw)
    {
      this.qm = parama;
      return;
    }
  }

  public void onAdClicked()
  {
    synchronized (this.mw)
    {
      if (this.qn != null)
        this.qn.ae();
      return;
    }
  }

  public void onAdClosed()
  {
    synchronized (this.mw)
    {
      if (this.qn != null)
        this.qn.af();
      return;
    }
  }

  public void onAdFailedToLoad(int paramInt)
  {
    while (true)
    {
      synchronized (this.mw)
      {
        if (this.qm != null)
        {
          if (paramInt == 3)
          {
            i = 1;
            this.qm.j(i);
            this.qm = null;
          }
        }
        else
          return;
      }
      int i = 2;
    }
  }

  public void onAdLeftApplication()
  {
    synchronized (this.mw)
    {
      if (this.qn != null)
        this.qn.ag();
      return;
    }
  }

  public void onAdLoaded()
  {
    synchronized (this.mw)
    {
      if (this.qm != null)
      {
        this.qm.j(0);
        this.qm = null;
        return;
      }
      if (this.qn != null)
        this.qn.ai();
      return;
    }
  }

  public void onAdOpened()
  {
    synchronized (this.mw)
    {
      if (this.qn != null)
        this.qn.ah();
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.co
 * JD-Core Version:    0.6.2
 */