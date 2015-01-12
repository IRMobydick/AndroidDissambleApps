package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface ol
{
  public static final class a extends ph<a>
  {
    public long asr;
    public c.j ass;
    public c.f gs;

    public a()
    {
      pL();
    }

    public static a l(byte[] paramArrayOfByte)
      throws pm
    {
      return (a)pn.a(new a(), paramArrayOfByte);
    }

    public void a(pg parampg)
      throws IOException
    {
      parampg.b(1, this.asr);
      if (this.gs != null)
        parampg.a(2, this.gs);
      if (this.ass != null)
        parampg.a(3, this.ass);
      super.a(parampg);
    }

    protected int c()
    {
      int i = super.c() + pg.d(1, this.asr);
      if (this.gs != null)
        i += pg.c(2, this.gs);
      if (this.ass != null)
        i += pg.c(3, this.ass);
      return i;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this)
        bool2 = true;
      a locala;
      do
      {
        c.f localf;
        do
        {
          boolean bool3;
          do
          {
            boolean bool1;
            do
            {
              return bool2;
              bool1 = paramObject instanceof a;
              bool2 = false;
            }
            while (!bool1);
            locala = (a)paramObject;
            bool3 = this.asr < locala.asr;
            bool2 = false;
          }
          while (bool3);
          if (this.gs != null)
            break;
          localf = locala.gs;
          bool2 = false;
        }
        while (localf != null);
        if (this.ass != null)
          break label111;
        localj = locala.ass;
        bool2 = false;
      }
      while (localj != null);
      label111: 
      while (this.ass.equals(locala.ass))
      {
        c.j localj;
        return a(locala);
        if (this.gs.equals(locala.gs))
          break;
        return false;
      }
      return false;
    }

    public int hashCode()
    {
      int i = 31 * (527 + (int)(this.asr ^ this.asr >>> 32));
      int j;
      int k;
      int m;
      if (this.gs == null)
      {
        j = 0;
        k = 31 * (j + i);
        c.j localj = this.ass;
        m = 0;
        if (localj != null)
          break label75;
      }
      while (true)
      {
        return 31 * (k + m) + qz();
        j = this.gs.hashCode();
        break;
        label75: m = this.ass.hashCode();
      }
    }

    public a p(pf parampf)
      throws IOException
    {
      while (true)
      {
        int i = parampf.qi();
        switch (i)
        {
        default:
          if (a(parampf, i))
            continue;
        case 0:
          return this;
        case 8:
          this.asr = parampf.qk();
          break;
        case 18:
          if (this.gs == null)
            this.gs = new c.f();
          parampf.a(this.gs);
          break;
        case 26:
        }
        if (this.ass == null)
          this.ass = new c.j();
        parampf.a(this.ass);
      }
    }

    public a pL()
    {
      this.asr = 0L;
      this.gs = null;
      this.ass = null;
      this.awJ = null;
      this.awU = -1;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ol
 * JD-Core Version:    0.6.2
 */