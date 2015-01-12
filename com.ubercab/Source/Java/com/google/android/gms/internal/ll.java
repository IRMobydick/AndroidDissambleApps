package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface ll
{
  public static final class a extends ph<a>
  {
    public a[] adE;

    public a()
    {
      lP();
    }

    public void a(pg parampg)
      throws IOException
    {
      if ((this.adE != null) && (this.adE.length > 0))
        for (int i = 0; i < this.adE.length; i++)
        {
          a locala = this.adE[i];
          if (locala != null)
            parampg.a(1, locala);
        }
      super.a(parampg);
    }

    protected int c()
    {
      int i = super.c();
      if ((this.adE != null) && (this.adE.length > 0))
        for (int j = 0; j < this.adE.length; j++)
        {
          a locala = this.adE[j];
          if (locala != null)
            i += pg.c(1, locala);
        }
      return i;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this)
        bool2 = true;
      a locala;
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
        bool3 = pl.equals(this.adE, locala.adE);
        bool2 = false;
      }
      while (!bool3);
      return a(locala);
    }

    public int hashCode()
    {
      return 31 * (527 + pl.hashCode(this.adE)) + qz();
    }

    public a lP()
    {
      this.adE = a.lQ();
      this.awJ = null;
      this.awU = -1;
      return this;
    }

    public a n(pf parampf)
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
        case 10:
        }
        int j = pq.b(parampf, 10);
        if (this.adE == null);
        a[] arrayOfa;
        for (int k = 0; ; k = this.adE.length)
        {
          arrayOfa = new a[j + k];
          if (k != 0)
            System.arraycopy(this.adE, 0, arrayOfa, 0, k);
          while (k < -1 + arrayOfa.length)
          {
            arrayOfa[k] = new a();
            parampf.a(arrayOfa[k]);
            parampf.qi();
            k++;
          }
        }
        arrayOfa[k] = new a();
        parampf.a(arrayOfa[k]);
        this.adE = arrayOfa;
      }
    }

    public static final class a extends ph<a>
    {
      private static volatile a[] adF;
      public String adG;
      public String adH;
      public int viewId;

      public a()
      {
        lR();
      }

      public static a[] lQ()
      {
        if (adF == null);
        synchronized (pl.awT)
        {
          if (adF == null)
            adF = new a[0];
          return adF;
        }
      }

      public void a(pg parampg)
        throws IOException
      {
        if (!this.adG.equals(""))
          parampg.b(1, this.adG);
        if (!this.adH.equals(""))
          parampg.b(2, this.adH);
        if (this.viewId != 0)
          parampg.s(3, this.viewId);
        super.a(parampg);
      }

      protected int c()
      {
        int i = super.c();
        if (!this.adG.equals(""))
          i += pg.j(1, this.adG);
        if (!this.adH.equals(""))
          i += pg.j(2, this.adH);
        if (this.viewId != 0)
          i += pg.u(3, this.viewId);
        return i;
      }

      public boolean equals(Object paramObject)
      {
        boolean bool2;
        if (paramObject == this)
          bool2 = true;
        a locala;
        label47: 
        do
        {
          String str2;
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
            if (this.adG != null)
              break;
            str2 = locala.adG;
            bool2 = false;
          }
          while (str2 != null);
          if (this.adH != null)
            break label114;
          str1 = locala.adH;
          bool2 = false;
        }
        while (str1 != null);
        label114: 
        while (this.adH.equals(locala.adH))
        {
          String str1;
          int i = this.viewId;
          int j = locala.viewId;
          bool2 = false;
          if (i != j)
            break;
          return a(locala);
          if (this.adG.equals(locala.adG))
            break label47;
          return false;
        }
        return false;
      }

      public int hashCode()
      {
        int i;
        int j;
        int k;
        if (this.adG == null)
        {
          i = 0;
          j = 31 * (i + 527);
          String str = this.adH;
          k = 0;
          if (str != null)
            break label62;
        }
        while (true)
        {
          return 31 * (31 * (j + k) + this.viewId) + qz();
          i = this.adG.hashCode();
          break;
          label62: k = this.adH.hashCode();
        }
      }

      public a lR()
      {
        this.adG = "";
        this.adH = "";
        this.viewId = 0;
        this.awJ = null;
        this.awU = -1;
        return this;
      }

      public a o(pf parampf)
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
          case 10:
            this.adG = parampf.readString();
            break;
          case 18:
            this.adH = parampf.readString();
            break;
          case 24:
          }
          this.viewId = parampf.ql();
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ll
 * JD-Core Version:    0.6.2
 */