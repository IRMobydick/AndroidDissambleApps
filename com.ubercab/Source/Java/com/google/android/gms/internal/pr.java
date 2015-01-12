package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface pr
{
  public static final class a extends ph<a>
  {
    public String[] axe;
    public String[] axf;
    public int[] axg;

    public a()
    {
      qJ();
    }

    public void a(pg parampg)
      throws IOException
    {
      if ((this.axe != null) && (this.axe.length > 0))
        for (int m = 0; m < this.axe.length; m++)
        {
          String str2 = this.axe[m];
          if (str2 != null)
            parampg.b(1, str2);
        }
      if ((this.axf != null) && (this.axf.length > 0))
        for (int k = 0; k < this.axf.length; k++)
        {
          String str1 = this.axf[k];
          if (str1 != null)
            parampg.b(2, str1);
        }
      if (this.axg != null)
      {
        int i = this.axg.length;
        int j = 0;
        if (i > 0)
          while (j < this.axg.length)
          {
            parampg.s(3, this.axg[j]);
            j++;
          }
      }
      super.a(parampg);
    }

    protected int c()
    {
      int i = 0;
      int j = super.c();
      int i4;
      int i5;
      if ((this.axe != null) && (this.axe.length > 0))
      {
        int i3 = 0;
        i4 = 0;
        i5 = 0;
        while (i3 < this.axe.length)
        {
          String str2 = this.axe[i3];
          if (str2 != null)
          {
            i5++;
            i4 += pg.di(str2);
          }
          i3++;
        }
      }
      for (int k = j + i4 + i5 * 1; ; k = j)
      {
        if ((this.axf != null) && (this.axf.length > 0))
        {
          int n = 0;
          int i1 = 0;
          int i2 = 0;
          while (n < this.axf.length)
          {
            String str1 = this.axf[n];
            if (str1 != null)
            {
              i2++;
              i1 += pg.di(str1);
            }
            n++;
          }
          k = k + i1 + i2 * 1;
        }
        if ((this.axg != null) && (this.axg.length > 0))
        {
          int m = 0;
          while (i < this.axg.length)
          {
            m += pg.gw(this.axg[i]);
            i++;
          }
          k = k + m + 1 * this.axg.length;
        }
        return k;
      }
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this)
        bool2 = true;
      a locala;
      boolean bool5;
      do
      {
        boolean bool4;
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
            bool3 = pl.equals(this.axe, locala.axe);
            bool2 = false;
          }
          while (!bool3);
          bool4 = pl.equals(this.axf, locala.axf);
          bool2 = false;
        }
        while (!bool4);
        bool5 = pl.equals(this.axg, locala.axg);
        bool2 = false;
      }
      while (!bool5);
      return a(locala);
    }

    public int hashCode()
    {
      return 31 * (31 * (31 * (527 + pl.hashCode(this.axe)) + pl.hashCode(this.axf)) + pl.hashCode(this.axg)) + qz();
    }

    public a qJ()
    {
      this.axe = pq.axb;
      this.axf = pq.axb;
      this.axg = pq.awW;
      this.awJ = null;
      this.awU = -1;
      return this;
    }

    public a v(pf parampf)
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
          int i5 = pq.b(parampf, 10);
          if (this.axe == null);
          String[] arrayOfString2;
          for (int i6 = 0; ; i6 = this.axe.length)
          {
            arrayOfString2 = new String[i5 + i6];
            if (i6 != 0)
              System.arraycopy(this.axe, 0, arrayOfString2, 0, i6);
            while (i6 < -1 + arrayOfString2.length)
            {
              arrayOfString2[i6] = parampf.readString();
              parampf.qi();
              i6++;
            }
          }
          arrayOfString2[i6] = parampf.readString();
          this.axe = arrayOfString2;
          break;
        case 18:
          int i3 = pq.b(parampf, 18);
          if (this.axf == null);
          String[] arrayOfString1;
          for (int i4 = 0; ; i4 = this.axf.length)
          {
            arrayOfString1 = new String[i3 + i4];
            if (i4 != 0)
              System.arraycopy(this.axf, 0, arrayOfString1, 0, i4);
            while (i4 < -1 + arrayOfString1.length)
            {
              arrayOfString1[i4] = parampf.readString();
              parampf.qi();
              i4++;
            }
          }
          arrayOfString1[i4] = parampf.readString();
          this.axf = arrayOfString1;
          break;
        case 24:
          int i1 = pq.b(parampf, 24);
          if (this.axg == null);
          int[] arrayOfInt2;
          for (int i2 = 0; ; i2 = this.axg.length)
          {
            arrayOfInt2 = new int[i1 + i2];
            if (i2 != 0)
              System.arraycopy(this.axg, 0, arrayOfInt2, 0, i2);
            while (i2 < -1 + arrayOfInt2.length)
            {
              arrayOfInt2[i2] = parampf.ql();
              parampf.qi();
              i2++;
            }
          }
          arrayOfInt2[i2] = parampf.ql();
          this.axg = arrayOfInt2;
          break;
        case 26:
        }
        int j = parampf.gp(parampf.qp());
        int k = parampf.getPosition();
        for (int m = 0; parampf.qu() > 0; m++)
          parampf.ql();
        parampf.gr(k);
        if (this.axg == null);
        int[] arrayOfInt1;
        for (int n = 0; ; n = this.axg.length)
        {
          arrayOfInt1 = new int[m + n];
          if (n != 0)
            System.arraycopy(this.axg, 0, arrayOfInt1, 0, n);
          while (n < arrayOfInt1.length)
          {
            arrayOfInt1[n] = parampf.ql();
            n++;
          }
        }
        this.axg = arrayOfInt1;
        parampf.gq(j);
      }
    }
  }

  public static final class b extends ph<b>
  {
    public int axh;
    public String axi;
    public String version;

    public b()
    {
      qK();
    }

    public void a(pg parampg)
      throws IOException
    {
      if (this.axh != 0)
        parampg.s(1, this.axh);
      if (!this.axi.equals(""))
        parampg.b(2, this.axi);
      if (!this.version.equals(""))
        parampg.b(3, this.version);
      super.a(parampg);
    }

    protected int c()
    {
      int i = super.c();
      if (this.axh != 0)
        i += pg.u(1, this.axh);
      if (!this.axi.equals(""))
        i += pg.j(2, this.axi);
      if (!this.version.equals(""))
        i += pg.j(3, this.version);
      return i;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this)
        bool2 = true;
      b localb;
      do
      {
        String str2;
        do
        {
          int i;
          int j;
          do
          {
            boolean bool1;
            do
            {
              return bool2;
              bool1 = paramObject instanceof b;
              bool2 = false;
            }
            while (!bool1);
            localb = (b)paramObject;
            i = this.axh;
            j = localb.axh;
            bool2 = false;
          }
          while (i != j);
          if (this.axi != null)
            break;
          str2 = localb.axi;
          bool2 = false;
        }
        while (str2 != null);
        if (this.version != null)
          break label114;
        str1 = localb.version;
        bool2 = false;
      }
      while (str1 != null);
      label114: 
      while (this.version.equals(localb.version))
      {
        String str1;
        return a(localb);
        if (this.axi.equals(localb.axi))
          break;
        return false;
      }
      return false;
    }

    public int hashCode()
    {
      int i = 31 * (527 + this.axh);
      int j;
      int k;
      int m;
      if (this.axi == null)
      {
        j = 0;
        k = 31 * (j + i);
        String str = this.version;
        m = 0;
        if (str != null)
          break label66;
      }
      while (true)
      {
        return 31 * (k + m) + qz();
        j = this.axi.hashCode();
        break;
        label66: m = this.version.hashCode();
      }
    }

    public b qK()
    {
      this.axh = 0;
      this.axi = "";
      this.version = "";
      this.awJ = null;
      this.awU = -1;
      return this;
    }

    public b w(pf parampf)
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
          int j = parampf.ql();
          switch (j)
          {
          default:
            break;
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10:
          case 11:
          case 12:
          case 13:
          case 14:
          case 15:
          case 16:
          case 17:
          case 18:
          case 19:
          case 20:
          case 21:
          case 22:
          }
          this.axh = j;
          break;
        case 18:
          this.axi = parampf.readString();
          break;
        case 26:
        }
        this.version = parampf.readString();
      }
    }
  }

  public static final class c extends ph<c>
  {
    public long axj;
    public int axk;
    public int axl;
    public boolean axm;
    public pr.d[] axn;
    public pr.b axo;
    public byte[] axp;
    public byte[] axq;
    public byte[] axr;
    public pr.a axs;
    public String axt;
    public String tag;

    public c()
    {
      qL();
    }

    public void a(pg parampg)
      throws IOException
    {
      if (this.axj != 0L)
        parampg.b(1, this.axj);
      if (!this.tag.equals(""))
        parampg.b(2, this.tag);
      if ((this.axn != null) && (this.axn.length > 0))
        for (int i = 0; i < this.axn.length; i++)
        {
          pr.d locald = this.axn[i];
          if (locald != null)
            parampg.a(3, locald);
        }
      if (!Arrays.equals(this.axp, pq.axd))
        parampg.a(6, this.axp);
      if (this.axs != null)
        parampg.a(7, this.axs);
      if (!Arrays.equals(this.axq, pq.axd))
        parampg.a(8, this.axq);
      if (this.axo != null)
        parampg.a(9, this.axo);
      if (this.axm)
        parampg.b(10, this.axm);
      if (this.axk != 0)
        parampg.s(11, this.axk);
      if (this.axl != 0)
        parampg.s(12, this.axl);
      if (!Arrays.equals(this.axr, pq.axd))
        parampg.a(13, this.axr);
      if (!this.axt.equals(""))
        parampg.b(14, this.axt);
      super.a(parampg);
    }

    protected int c()
    {
      int i = super.c();
      if (this.axj != 0L)
        i += pg.d(1, this.axj);
      if (!this.tag.equals(""))
        i += pg.j(2, this.tag);
      if ((this.axn != null) && (this.axn.length > 0))
      {
        int j = i;
        for (int k = 0; k < this.axn.length; k++)
        {
          pr.d locald = this.axn[k];
          if (locald != null)
            j += pg.c(3, locald);
        }
        i = j;
      }
      if (!Arrays.equals(this.axp, pq.axd))
        i += pg.b(6, this.axp);
      if (this.axs != null)
        i += pg.c(7, this.axs);
      if (!Arrays.equals(this.axq, pq.axd))
        i += pg.b(8, this.axq);
      if (this.axo != null)
        i += pg.c(9, this.axo);
      if (this.axm)
        i += pg.c(10, this.axm);
      if (this.axk != 0)
        i += pg.u(11, this.axk);
      if (this.axl != 0)
        i += pg.u(12, this.axl);
      if (!Arrays.equals(this.axr, pq.axd))
        i += pg.b(13, this.axr);
      if (!this.axt.equals(""))
        i += pg.j(14, this.axt);
      return i;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this)
        bool2 = true;
      c localc;
      label174: 
      do
      {
        pr.a locala;
        do
        {
          boolean bool9;
          do
          {
            boolean bool8;
            do
            {
              boolean bool7;
              do
              {
                pr.b localb;
                do
                {
                  boolean bool6;
                  do
                  {
                    boolean bool4;
                    boolean bool5;
                    do
                    {
                      int k;
                      int m;
                      do
                      {
                        int i;
                        int j;
                        do
                        {
                          String str2;
                          do
                          {
                            boolean bool3;
                            do
                            {
                              boolean bool1;
                              do
                              {
                                return bool2;
                                bool1 = paramObject instanceof c;
                                bool2 = false;
                              }
                              while (!bool1);
                              localc = (c)paramObject;
                              bool3 = this.axj < localc.axj;
                              bool2 = false;
                            }
                            while (bool3);
                            if (this.tag != null)
                              break;
                            str2 = localc.tag;
                            bool2 = false;
                          }
                          while (str2 != null);
                          i = this.axk;
                          j = localc.axk;
                          bool2 = false;
                        }
                        while (i != j);
                        k = this.axl;
                        m = localc.axl;
                        bool2 = false;
                      }
                      while (k != m);
                      bool4 = this.axm;
                      bool5 = localc.axm;
                      bool2 = false;
                    }
                    while (bool4 != bool5);
                    bool6 = pl.equals(this.axn, localc.axn);
                    bool2 = false;
                  }
                  while (!bool6);
                  if (this.axo != null)
                    break label303;
                  localb = localc.axo;
                  bool2 = false;
                }
                while (localb != null);
                bool7 = Arrays.equals(this.axp, localc.axp);
                bool2 = false;
              }
              while (!bool7);
              bool8 = Arrays.equals(this.axq, localc.axq);
              bool2 = false;
            }
            while (!bool8);
            bool9 = Arrays.equals(this.axr, localc.axr);
            bool2 = false;
          }
          while (!bool9);
          if (this.axs != null)
            break label320;
          locala = localc.axs;
          bool2 = false;
        }
        while (locala != null);
        if (this.axt != null)
          break label337;
        str1 = localc.axt;
        bool2 = false;
      }
      while (str1 != null);
      label258: label303: label320: label337: 
      while (this.axt.equals(localc.axt))
      {
        String str1;
        return a(localc);
        if (this.tag.equals(localc.tag))
          break;
        return false;
        if (this.axo.equals(localc.axo))
          break label174;
        return false;
        if (this.axs.equals(localc.axs))
          break label258;
        return false;
      }
      return false;
    }

    public int hashCode()
    {
      int i = 31 * (527 + (int)(this.axj ^ this.axj >>> 32));
      int j;
      int m;
      label65: int i1;
      label95: int i3;
      label148: int i4;
      int i5;
      if (this.tag == null)
      {
        j = 0;
        int k = 31 * (31 * (31 * (j + i) + this.axk) + this.axl);
        if (!this.axm)
          break label197;
        m = 1231;
        int n = 31 * (31 * (m + k) + pl.hashCode(this.axn));
        if (this.axo != null)
          break label205;
        i1 = 0;
        int i2 = 31 * (31 * (31 * (31 * (i1 + n) + Arrays.hashCode(this.axp)) + Arrays.hashCode(this.axq)) + Arrays.hashCode(this.axr));
        if (this.axs != null)
          break label217;
        i3 = 0;
        i4 = 31 * (i3 + i2);
        String str = this.axt;
        i5 = 0;
        if (str != null)
          break label229;
      }
      while (true)
      {
        return 31 * (i4 + i5) + qz();
        j = this.tag.hashCode();
        break;
        label197: m = 1237;
        break label65;
        label205: i1 = this.axo.hashCode();
        break label95;
        label217: i3 = this.axs.hashCode();
        break label148;
        label229: i5 = this.axt.hashCode();
      }
    }

    public c qL()
    {
      this.axj = 0L;
      this.tag = "";
      this.axk = 0;
      this.axl = 0;
      this.axm = false;
      this.axn = pr.d.qM();
      this.axo = null;
      this.axp = pq.axd;
      this.axq = pq.axd;
      this.axr = pq.axd;
      this.axs = null;
      this.axt = "";
      this.awJ = null;
      this.awU = -1;
      return this;
    }

    public c x(pf parampf)
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
          this.axj = parampf.qk();
          break;
        case 18:
          this.tag = parampf.readString();
          break;
        case 26:
          int j = pq.b(parampf, 26);
          if (this.axn == null);
          pr.d[] arrayOfd;
          for (int k = 0; ; k = this.axn.length)
          {
            arrayOfd = new pr.d[j + k];
            if (k != 0)
              System.arraycopy(this.axn, 0, arrayOfd, 0, k);
            while (k < -1 + arrayOfd.length)
            {
              arrayOfd[k] = new pr.d();
              parampf.a(arrayOfd[k]);
              parampf.qi();
              k++;
            }
          }
          arrayOfd[k] = new pr.d();
          parampf.a(arrayOfd[k]);
          this.axn = arrayOfd;
          break;
        case 50:
          this.axp = parampf.readBytes();
          break;
        case 58:
          if (this.axs == null)
            this.axs = new pr.a();
          parampf.a(this.axs);
          break;
        case 66:
          this.axq = parampf.readBytes();
          break;
        case 74:
          if (this.axo == null)
            this.axo = new pr.b();
          parampf.a(this.axo);
          break;
        case 80:
          this.axm = parampf.qm();
          break;
        case 88:
          this.axk = parampf.ql();
          break;
        case 96:
          this.axl = parampf.ql();
          break;
        case 106:
          this.axr = parampf.readBytes();
          break;
        case 114:
        }
        this.axt = parampf.readString();
      }
    }
  }

  public static final class d extends ph<d>
  {
    private static volatile d[] axu;
    public String fv;
    public String value;

    public d()
    {
      qN();
    }

    public static d[] qM()
    {
      if (axu == null);
      synchronized (pl.awT)
      {
        if (axu == null)
          axu = new d[0];
        return axu;
      }
    }

    public void a(pg parampg)
      throws IOException
    {
      if (!this.fv.equals(""))
        parampg.b(1, this.fv);
      if (!this.value.equals(""))
        parampg.b(2, this.value);
      super.a(parampg);
    }

    protected int c()
    {
      int i = super.c();
      if (!this.fv.equals(""))
        i += pg.j(1, this.fv);
      if (!this.value.equals(""))
        i += pg.j(2, this.value);
      return i;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this)
        bool2 = true;
      d locald;
      do
      {
        String str2;
        do
        {
          boolean bool1;
          do
          {
            return bool2;
            bool1 = paramObject instanceof d;
            bool2 = false;
          }
          while (!bool1);
          locald = (d)paramObject;
          if (this.fv != null)
            break;
          str2 = locald.fv;
          bool2 = false;
        }
        while (str2 != null);
        if (this.value != null)
          break label92;
        str1 = locald.value;
        bool2 = false;
      }
      while (str1 != null);
      label92: 
      while (this.value.equals(locald.value))
      {
        String str1;
        return a(locald);
        if (this.fv.equals(locald.fv))
          break;
        return false;
      }
      return false;
    }

    public int hashCode()
    {
      int i;
      int j;
      int k;
      if (this.fv == null)
      {
        i = 0;
        j = 31 * (i + 527);
        String str = this.value;
        k = 0;
        if (str != null)
          break label54;
      }
      while (true)
      {
        return 31 * (j + k) + qz();
        i = this.fv.hashCode();
        break;
        label54: k = this.value.hashCode();
      }
    }

    public d qN()
    {
      this.fv = "";
      this.value = "";
      this.awJ = null;
      this.awU = -1;
      return this;
    }

    public d y(pf parampf)
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
          this.fv = parampf.readString();
          break;
        case 18:
        }
        this.value = parampf.readString();
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pr
 * JD-Core Version:    0.6.2
 */