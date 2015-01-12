package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface d
{
  public static final class a extends ph<a>
  {
    private static volatile a[] gu;
    public String gA;
    public long gB;
    public boolean gC;
    public a[] gD;
    public int[] gE;
    public boolean gF;
    public String gv;
    public a[] gw;
    public a[] gx;
    public a[] gy;
    public String gz;
    public int type;

    public a()
    {
      s();
    }

    public static a[] r()
    {
      if (gu == null);
      synchronized (pl.awT)
      {
        if (gu == null)
          gu = new a[0];
        return gu;
      }
    }

    public void a(pg parampg)
      throws IOException
    {
      parampg.s(1, this.type);
      if (!this.gv.equals(""))
        parampg.b(2, this.gv);
      if ((this.gw != null) && (this.gw.length > 0))
        for (int i1 = 0; i1 < this.gw.length; i1++)
        {
          a locala4 = this.gw[i1];
          if (locala4 != null)
            parampg.a(3, locala4);
        }
      if ((this.gx != null) && (this.gx.length > 0))
        for (int n = 0; n < this.gx.length; n++)
        {
          a locala3 = this.gx[n];
          if (locala3 != null)
            parampg.a(4, locala3);
        }
      if ((this.gy != null) && (this.gy.length > 0))
        for (int m = 0; m < this.gy.length; m++)
        {
          a locala2 = this.gy[m];
          if (locala2 != null)
            parampg.a(5, locala2);
        }
      if (!this.gz.equals(""))
        parampg.b(6, this.gz);
      if (!this.gA.equals(""))
        parampg.b(7, this.gA);
      if (this.gB != 0L)
        parampg.b(8, this.gB);
      if (this.gF)
        parampg.b(9, this.gF);
      if ((this.gE != null) && (this.gE.length > 0))
        for (int k = 0; k < this.gE.length; k++)
          parampg.s(10, this.gE[k]);
      if (this.gD != null)
      {
        int i = this.gD.length;
        int j = 0;
        if (i > 0)
          while (j < this.gD.length)
          {
            a locala1 = this.gD[j];
            if (locala1 != null)
              parampg.a(11, locala1);
            j++;
          }
      }
      if (this.gC)
        parampg.b(12, this.gC);
      super.a(parampg);
    }

    protected int c()
    {
      int i = super.c() + pg.u(1, this.type);
      if (!this.gv.equals(""))
        i += pg.j(2, this.gv);
      if ((this.gw != null) && (this.gw.length > 0))
      {
        int i5 = i;
        for (int i6 = 0; i6 < this.gw.length; i6++)
        {
          a locala4 = this.gw[i6];
          if (locala4 != null)
            i5 += pg.c(3, locala4);
        }
        i = i5;
      }
      if ((this.gx != null) && (this.gx.length > 0))
      {
        int i3 = i;
        for (int i4 = 0; i4 < this.gx.length; i4++)
        {
          a locala3 = this.gx[i4];
          if (locala3 != null)
            i3 += pg.c(4, locala3);
        }
        i = i3;
      }
      if ((this.gy != null) && (this.gy.length > 0))
      {
        int i1 = i;
        for (int i2 = 0; i2 < this.gy.length; i2++)
        {
          a locala2 = this.gy[i2];
          if (locala2 != null)
            i1 += pg.c(5, locala2);
        }
        i = i1;
      }
      if (!this.gz.equals(""))
        i += pg.j(6, this.gz);
      if (!this.gA.equals(""))
        i += pg.j(7, this.gA);
      if (this.gB != 0L)
        i += pg.d(8, this.gB);
      if (this.gF)
        i += pg.c(9, this.gF);
      if ((this.gE != null) && (this.gE.length > 0))
      {
        int m = 0;
        int n = 0;
        while (m < this.gE.length)
        {
          n += pg.gw(this.gE[m]);
          m++;
        }
        i = i + n + 1 * this.gE.length;
      }
      if (this.gD != null)
      {
        int j = this.gD.length;
        int k = 0;
        if (j > 0)
          while (k < this.gD.length)
          {
            a locala1 = this.gD[k];
            if (locala1 != null)
              i += pg.c(11, locala1);
            k++;
          }
      }
      if (this.gC)
        i += pg.c(12, this.gC);
      return i;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this)
        bool2 = true;
      a locala;
      label69: 
      do
      {
        String str2;
        do
        {
          boolean bool5;
          do
          {
            boolean bool4;
            do
            {
              boolean bool3;
              do
              {
                String str3;
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
                      bool1 = paramObject instanceof a;
                      bool2 = false;
                    }
                    while (!bool1);
                    locala = (a)paramObject;
                    i = this.type;
                    j = locala.type;
                    bool2 = false;
                  }
                  while (i != j);
                  if (this.gv != null)
                    break;
                  str3 = locala.gv;
                  bool2 = false;
                }
                while (str3 != null);
                bool3 = pl.equals(this.gw, locala.gw);
                bool2 = false;
              }
              while (!bool3);
              bool4 = pl.equals(this.gx, locala.gx);
              bool2 = false;
            }
            while (!bool4);
            bool5 = pl.equals(this.gy, locala.gy);
            bool2 = false;
          }
          while (!bool5);
          if (this.gz != null)
            break label303;
          str2 = locala.gz;
          bool2 = false;
        }
        while (str2 != null);
        if (this.gA != null)
          break label320;
        str1 = locala.gA;
        bool2 = false;
      }
      while (str1 != null);
      label153: label303: label320: 
      while (this.gA.equals(locala.gA))
      {
        String str1;
        boolean bool6 = this.gB < locala.gB;
        bool2 = false;
        if (bool6)
          break;
        boolean bool7 = this.gC;
        boolean bool8 = locala.gC;
        bool2 = false;
        if (bool7 != bool8)
          break;
        boolean bool9 = pl.equals(this.gD, locala.gD);
        bool2 = false;
        if (!bool9)
          break;
        boolean bool10 = pl.equals(this.gE, locala.gE);
        bool2 = false;
        if (!bool10)
          break;
        boolean bool11 = this.gF;
        boolean bool12 = locala.gF;
        bool2 = false;
        if (bool11 != bool12)
          break;
        return a(locala);
        if (this.gv.equals(locala.gv))
          break label69;
        return false;
        if (this.gz.equals(locala.gz))
          break label153;
        return false;
      }
      return false;
    }

    public int hashCode()
    {
      int i = 1231;
      int j = 31 * (527 + this.type);
      int k;
      int n;
      label76: int i2;
      label100: int i4;
      label137: int i5;
      if (this.gv == null)
      {
        k = 0;
        int m = 31 * (31 * (31 * (31 * (k + j) + pl.hashCode(this.gw)) + pl.hashCode(this.gx)) + pl.hashCode(this.gy));
        if (this.gz != null)
          break label200;
        n = 0;
        int i1 = 31 * (n + m);
        String str = this.gA;
        i2 = 0;
        if (str != null)
          break label212;
        int i3 = 31 * (31 * (i1 + i2) + (int)(this.gB ^ this.gB >>> 32));
        if (!this.gC)
          break label224;
        i4 = i;
        i5 = 31 * (31 * (31 * (i4 + i3) + pl.hashCode(this.gD)) + pl.hashCode(this.gE));
        if (!this.gF)
          break label232;
      }
      while (true)
      {
        return 31 * (i5 + i) + qz();
        k = this.gv.hashCode();
        break;
        label200: n = this.gz.hashCode();
        break label76;
        label212: i2 = this.gA.hashCode();
        break label100;
        label224: i4 = 1237;
        break label137;
        label232: i = 1237;
      }
    }

    public a l(pf parampf)
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
          int i17 = parampf.ql();
          switch (i17)
          {
          default:
            break;
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          }
          this.type = i17;
          break;
        case 18:
          this.gv = parampf.readString();
          break;
        case 26:
          int i15 = pq.b(parampf, 26);
          if (this.gw == null);
          a[] arrayOfa4;
          for (int i16 = 0; ; i16 = this.gw.length)
          {
            arrayOfa4 = new a[i15 + i16];
            if (i16 != 0)
              System.arraycopy(this.gw, 0, arrayOfa4, 0, i16);
            while (i16 < -1 + arrayOfa4.length)
            {
              arrayOfa4[i16] = new a();
              parampf.a(arrayOfa4[i16]);
              parampf.qi();
              i16++;
            }
          }
          arrayOfa4[i16] = new a();
          parampf.a(arrayOfa4[i16]);
          this.gw = arrayOfa4;
          break;
        case 34:
          int i13 = pq.b(parampf, 34);
          if (this.gx == null);
          a[] arrayOfa3;
          for (int i14 = 0; ; i14 = this.gx.length)
          {
            arrayOfa3 = new a[i13 + i14];
            if (i14 != 0)
              System.arraycopy(this.gx, 0, arrayOfa3, 0, i14);
            while (i14 < -1 + arrayOfa3.length)
            {
              arrayOfa3[i14] = new a();
              parampf.a(arrayOfa3[i14]);
              parampf.qi();
              i14++;
            }
          }
          arrayOfa3[i14] = new a();
          parampf.a(arrayOfa3[i14]);
          this.gx = arrayOfa3;
          break;
        case 42:
          int i11 = pq.b(parampf, 42);
          if (this.gy == null);
          a[] arrayOfa2;
          for (int i12 = 0; ; i12 = this.gy.length)
          {
            arrayOfa2 = new a[i11 + i12];
            if (i12 != 0)
              System.arraycopy(this.gy, 0, arrayOfa2, 0, i12);
            while (i12 < -1 + arrayOfa2.length)
            {
              arrayOfa2[i12] = new a();
              parampf.a(arrayOfa2[i12]);
              parampf.qi();
              i12++;
            }
          }
          arrayOfa2[i12] = new a();
          parampf.a(arrayOfa2[i12]);
          this.gy = arrayOfa2;
          break;
        case 50:
          this.gz = parampf.readString();
          break;
        case 58:
          this.gA = parampf.readString();
          break;
        case 64:
          this.gB = parampf.qk();
          break;
        case 72:
          this.gF = parampf.qm();
          break;
        case 80:
          int i5 = pq.b(parampf, 80);
          int[] arrayOfInt2 = new int[i5];
          int i6 = 0;
          int i7 = 0;
          if (i6 < i5)
          {
            if (i6 != 0)
              parampf.qi();
            int i9 = parampf.ql();
            int i10;
            switch (i9)
            {
            default:
              i10 = i7;
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
            }
            while (true)
            {
              i6++;
              i7 = i10;
              break;
              i10 = i7 + 1;
              arrayOfInt2[i7] = i9;
            }
          }
          if (i7 == 0)
            continue;
          if (this.gE == null);
          for (int i8 = 0; ; i8 = this.gE.length)
          {
            if ((i8 != 0) || (i7 != arrayOfInt2.length))
              break label849;
            this.gE = arrayOfInt2;
            break;
          }
          int[] arrayOfInt3 = new int[i8 + i7];
          if (i8 != 0)
            System.arraycopy(this.gE, 0, arrayOfInt3, 0, i8);
          System.arraycopy(arrayOfInt2, 0, arrayOfInt3, i8, i7);
          this.gE = arrayOfInt3;
          break;
        case 82:
          int m = parampf.gp(parampf.qp());
          int n = parampf.getPosition();
          int i1 = 0;
          while (parampf.qu() > 0)
            switch (parampf.ql())
            {
            default:
              break;
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
              i1++;
            }
          if (i1 != 0)
          {
            parampf.gr(n);
            if (this.gE == null);
            int[] arrayOfInt1;
            for (int i2 = 0; ; i2 = this.gE.length)
            {
              arrayOfInt1 = new int[i1 + i2];
              if (i2 != 0)
                System.arraycopy(this.gE, 0, arrayOfInt1, 0, i2);
              while (parampf.qu() > 0)
              {
                int i3 = parampf.ql();
                switch (i3)
                {
                default:
                  break;
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
                  int i4 = i2 + 1;
                  arrayOfInt1[i2] = i3;
                  i2 = i4;
                }
              }
            }
            this.gE = arrayOfInt1;
          }
          parampf.gq(m);
          break;
        case 90:
          label849: int j = pq.b(parampf, 90);
          if (this.gD == null);
          a[] arrayOfa1;
          for (int k = 0; ; k = this.gD.length)
          {
            arrayOfa1 = new a[j + k];
            if (k != 0)
              System.arraycopy(this.gD, 0, arrayOfa1, 0, k);
            while (k < -1 + arrayOfa1.length)
            {
              arrayOfa1[k] = new a();
              parampf.a(arrayOfa1[k]);
              parampf.qi();
              k++;
            }
          }
          arrayOfa1[k] = new a();
          parampf.a(arrayOfa1[k]);
          this.gD = arrayOfa1;
          break;
        case 96:
        }
        this.gC = parampf.qm();
      }
    }

    public a s()
    {
      this.type = 1;
      this.gv = "";
      this.gw = r();
      this.gx = r();
      this.gy = r();
      this.gz = "";
      this.gA = "";
      this.gB = 0L;
      this.gC = false;
      this.gD = r();
      this.gE = pq.awW;
      this.gF = false;
      this.awJ = null;
      this.awU = -1;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.d
 * JD-Core Version:    0.6.2
 */