package a.a.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.NumberFormat;

public class bc
{
  private int[] a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  private int g;
  private int h;
  private ay i;
  private aa j;

  public bc(aa paramaa)
  {
    this.j = paramaa;
  }

  private int a(String paramString, int paramInt)
  {
    int k = 0;
    int m = paramString.length();
    if (paramInt + m >= this.b)
    {
      if (paramInt + m >= this.b)
        break label74;
      int[] arrayOfInt = new int[this.b];
      if (this.a != null)
        System.arraycopy(this.a, 0, arrayOfInt, 0, paramInt);
      this.a = arrayOfInt;
    }
    while (true)
    {
      if (k >= m)
      {
        return paramInt + m;
        label74: if (this.b == 0)
        {
          this.b = 256;
          break;
        }
        this.b = (2 * this.b);
        break;
      }
      this.a[(paramInt + k)] = paramString.charAt(k);
      k++;
    }
  }

  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    if (aq.a(paramInt2, paramArrayOfByte, null, arrayOfInt))
    {
      paramArrayOfByte[0] = -17;
      paramArrayOfByte[1] = -65;
      paramArrayOfByte[2] = -67;
      arrayOfInt[0] = 3;
    }
    return paramInt1 + arrayOfInt[0];
  }

  public static int a(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    if (aq.a(arrayOfInt1, do.b(paramArrayOfByte[paramInt]), paramArrayOfByte, null, arrayOfInt2, paramInt + 1))
      arrayOfInt1[0] = 65533;
    paramArrayOfInt[0] = arrayOfInt1[0];
    return -1 + arrayOfInt2[0];
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 + 1 >= this.b);
    while (true)
    {
      if (paramInt2 + 1 < this.b)
      {
        int[] arrayOfInt = new int[this.b];
        if (this.a != null)
          System.arraycopy(this.a, 0, arrayOfInt, 0, paramInt2);
        this.a = arrayOfInt;
        this.a[paramInt2] = paramInt1;
        return;
      }
      if (this.b == 0)
      {
        this.b = 256;
        continue;
      }
      this.b = (2 * this.b);
    }
  }

  private void a(int paramInt, short paramShort)
  {
    int k = 1;
    int m = 0;
    if ((paramInt == 32) && (!do.a(paramShort & 0x17)))
      if (do.a(paramShort & 0x8))
        if ((this.j.F) || (this.j.o))
        {
          int i53 = this.c;
          this.c = (i53 + 1);
          a(38, i53);
          int i54 = this.c;
          this.c = (i54 + 1);
          a(35, i54);
          int i55 = this.c;
          this.c = (i55 + 1);
          a(49, i55);
          int i56 = this.c;
          this.c = (i56 + 1);
          a(54, i56);
          int i57 = this.c;
          this.c = (i57 + 1);
          a(48, i57);
          int i58 = this.c;
          this.c = (i58 + 1);
          a(59, i58);
        }
    while (true)
    {
      return;
      int i59 = this.c;
      this.c = (i59 + 1);
      a(38, i59);
      int i60 = this.c;
      this.c = (i60 + 1);
      a(110, i60);
      int i61 = this.c;
      this.c = (i61 + 1);
      a(98, i61);
      int i62 = this.c;
      this.c = (i62 + 1);
      a(115, i62);
      int i63 = this.c;
      this.c = (i63 + 1);
      a(112, i63);
      int i64 = this.c;
      this.c = (i64 + 1);
      a(59, i64);
      continue;
      this.d = this.c;
      if (do.a(paramShort & 0x12))
      {
        int i52 = this.c;
        this.c = (i52 + 1);
        a(paramInt, i52);
        continue;
      }
      if (!do.a(paramShort & 0x10))
      {
        if (paramInt == 60)
        {
          int i48 = this.c;
          this.c = (i48 + 1);
          a(38, i48);
          int i49 = this.c;
          this.c = (i49 + 1);
          a(108, i49);
          int i50 = this.c;
          this.c = (i50 + 1);
          a(116, i50);
          int i51 = this.c;
          this.c = (i51 + 1);
          a(59, i51);
          continue;
        }
        if (paramInt == 62)
        {
          int i44 = this.c;
          this.c = (i44 + 1);
          a(38, i44);
          int i45 = this.c;
          this.c = (i45 + 1);
          a(103, i45);
          int i46 = this.c;
          this.c = (i46 + 1);
          a(116, i46);
          int i47 = this.c;
          this.c = (i47 + 1);
          a(59, i47);
          continue;
        }
        if ((paramInt == 38) && (this.j.I))
        {
          int i39 = this.c;
          this.c = (i39 + 1);
          a(38, i39);
          int i40 = this.c;
          this.c = (i40 + 1);
          a(97, i40);
          int i41 = this.c;
          this.c = (i41 + 1);
          a(109, i41);
          int i42 = this.c;
          this.c = (i42 + 1);
          a(112, i42);
          int i43 = this.c;
          this.c = (i43 + 1);
          a(59, i43);
          continue;
        }
        if ((paramInt == 34) && (this.j.G))
        {
          int i33 = this.c;
          this.c = (i33 + 1);
          a(38, i33);
          int i34 = this.c;
          this.c = (i34 + 1);
          a(113, i34);
          int i35 = this.c;
          this.c = (i35 + 1);
          a(117, i35);
          int i36 = this.c;
          this.c = (i36 + 1);
          a(111, i36);
          int i37 = this.c;
          this.c = (i37 + 1);
          a(116, i37);
          int i38 = this.c;
          this.c = (i38 + 1);
          a(59, i38);
          continue;
        }
        if ((paramInt == 39) && (this.j.G))
        {
          int i28 = this.c;
          this.c = (i28 + 1);
          a(38, i28);
          int i29 = this.c;
          this.c = (i29 + 1);
          a(35, i29);
          int i30 = this.c;
          this.c = (i30 + 1);
          a(51, i30);
          int i31 = this.c;
          this.c = (i31 + 1);
          a(57, i31);
          int i32 = this.c;
          this.c = (i32 + 1);
          a(59, i32);
          continue;
        }
        if ((paramInt == 160) && (!this.j.at))
        {
          if (this.j.w)
          {
            int i27 = this.c;
            this.c = (i27 + 1);
            a(32, i27);
            continue;
          }
          if (this.j.H)
          {
            int i17 = this.c;
            this.c = (i17 + 1);
            a(38, i17);
            if ((this.j.F) || (this.j.o))
            {
              int i18 = this.c;
              this.c = (i18 + 1);
              a(35, i18);
              int i19 = this.c;
              this.c = (i19 + 1);
              a(49, i19);
              int i20 = this.c;
              this.c = (i20 + 1);
              a(54, i20);
              int i21 = this.c;
              this.c = (i21 + 1);
              a(48, i21);
            }
            while (true)
            {
              int i22 = this.c;
              this.c = (i22 + 1);
              a(59, i22);
              break;
              int i23 = this.c;
              this.c = (i23 + 1);
              a(110, i23);
              int i24 = this.c;
              this.c = (i24 + 1);
              a(98, i24);
              int i25 = this.c;
              this.c = (i25 + 1);
              a(115, i25);
              int i26 = this.c;
              this.c = (i26 + 1);
              a(112, i26);
            }
          }
          int i16 = this.c;
          this.c = (i16 + 1);
          a(paramInt, i16);
          continue;
        }
      }
      if ("UTF8".equals(this.j.c()))
      {
        if ((paramInt < 8192) || (do.a(paramShort & 0x1)))
          break label2069;
        if (((paramInt < 8192) || (paramInt > 8198)) && ((paramInt < 8200) || (paramInt > 8208)) && ((paramInt < 8209) || (paramInt > 8262)) && ((paramInt < 8317) || (paramInt > 8318)) && ((paramInt < 8333) || (paramInt > 8334)) && ((paramInt < 9001) || (paramInt > 9002)) && ((paramInt < 12289) || (paramInt > 12291)) && ((paramInt < 12296) || (paramInt > 12305)) && ((paramInt < 12308) || (paramInt > 12319)) && ((paramInt < 64830) || (paramInt > 64831)) && ((paramInt < 65072) || (paramInt > 65092)) && ((paramInt < 65097) || (paramInt > 65106)) && ((paramInt < 65108) || (paramInt > 65121)) && ((paramInt < 65130) || (paramInt > 65131)) && ((paramInt < 65281) || (paramInt > 65283)) && ((paramInt < 65285) || (paramInt > 65290)) && ((paramInt < 65292) || (paramInt > 65295)) && ((paramInt < 65306) || (paramInt > 65307)) && ((paramInt < 65311) || (paramInt > 65312)) && ((paramInt < 65339) || (paramInt > 65341)) && ((paramInt < 65377) || (paramInt > 65381)))
          break label1701;
        this.d = (2 + this.c);
        if (k != 0)
        {
          if (((paramInt < 8218) || (paramInt > 8220)) && ((paramInt < 8222) || (paramInt > 8223)))
            break label1786;
          this.d = (-1 + this.d);
        }
      }
      label1701: label1786: 
      do
      {
        while (true)
        {
          if ((paramInt != 160) || (!do.a(paramShort & 0x1)))
            break label2253;
          int i12 = this.c;
          this.c = (i12 + 1);
          a(32, i12);
          break;
          switch (paramInt)
          {
          default:
            k = 0;
            break;
          case 12336:
          case 12539:
          case 65123:
          case 65128:
          case 65343:
          case 65371:
          case 65373:
            this.d = (2 + this.c);
            break;
            switch (paramInt)
            {
            default:
              break;
            case 8216:
            case 8249:
            case 8261:
            case 8317:
            case 8333:
            case 9001:
            case 12296:
            case 12298:
            case 12300:
            case 12302:
            case 12304:
            case 12308:
            case 12310:
            case 12312:
            case 12314:
            case 12317:
            case 64830:
            case 65077:
            case 65079:
            case 65081:
            case 65083:
            case 65085:
            case 65087:
            case 65089:
            case 65091:
            case 65113:
            case 65115:
            case 65117:
            case 65288:
            case 65339:
            case 65371:
            case 65378:
              this.d = (-1 + this.d);
            }
          }
        }
        if ("BIG5".equals(this.j.c()))
        {
          int i15 = this.c;
          this.c = (i15 + 1);
          a(paramInt, i15);
          if (((0xFF00 & paramInt) != 41216) || (do.a(paramShort & 0x1)))
            break;
          this.d = this.c;
          if ((paramInt <= 92) || (paramInt >= 173) || ((paramInt & 0x1) != k))
            break;
          this.d = (-1 + this.d);
          break;
        }
        if ((!"SHIFTJIS".equals(this.j.c())) && (!"ISO2022".equals(this.j.c())))
          continue;
        int i13 = this.c;
        this.c = (i13 + 1);
        a(paramInt, i13);
        break;
      }
      while (!this.j.at);
      label2069: int i14 = this.c;
      this.c = (i14 + 1);
      a(paramInt, i14);
      continue;
      label2253: if (((this.j.v) && (this.j.ai)) || ((this.j.w) && (paramInt >= 8211) && (paramInt <= 8222)));
      label2360: String str5;
      switch (paramInt)
      {
      case 8213:
      case 8214:
      case 8215:
      case 8219:
      default:
        if (!"ISO8859_1".equals(this.j.c()))
          break label2655;
        if (paramInt <= 255)
          break label2548;
        if (!this.j.F)
        {
          String str6 = au.a().a((short)paramInt);
          if (str6 == null)
            break;
          str5 = "&" + str6 + ";";
        }
      case 8211:
      case 8212:
      case 8216:
      case 8217:
      case 8218:
      case 8220:
      case 8221:
      case 8222:
      }
      while (m < str5.length())
      {
        int i10 = str5.charAt(m);
        int i11 = this.c;
        this.c = (i11 + 1);
        a(i10, i11);
        m++;
        continue;
        paramInt = 45;
        break label2360;
        paramInt = 39;
        break label2360;
        paramInt = 34;
        break label2360;
        str5 = "&#" + paramInt + ";";
        continue;
        str5 = "&#" + paramInt + ";";
      }
      label2548: if ((paramInt > 126) && (paramInt < 160))
      {
        String str4 = "&#" + paramInt + ";";
        while (m < str4.length())
        {
          int i8 = str4.charAt(m);
          int i9 = this.c;
          this.c = (i9 + 1);
          a(i8, i9);
          m++;
        }
        continue;
      }
      int i7 = this.c;
      this.c = (i7 + 1);
      a(paramInt, i7);
      continue;
      label2655: if (this.j.c().startsWith("UTF"))
      {
        int i6 = this.c;
        this.c = (i6 + 1);
        a(paramInt, i6);
        continue;
      }
      if (this.j.o)
      {
        if ((paramInt > 127) && ("ASCII".equals(this.j.c())))
        {
          String str3 = "&#" + paramInt + ";";
          while (m < str3.length())
          {
            int i4 = str3.charAt(m);
            int i5 = this.c;
            this.c = (i5 + 1);
            a(i4, i5);
            m++;
          }
          continue;
        }
        int i3 = this.c;
        this.c = (i3 + 1);
        a(paramInt, i3);
        continue;
      }
      if (("ASCII".equals(this.j.c())) && ((paramInt > 126) || ((paramInt < 32) && (paramInt != 9))))
      {
        String str1;
        if (!this.j.F)
        {
          String str2 = au.a().a((short)paramInt);
          if (str2 != null)
            str1 = "&" + str2 + ";";
        }
        while (m < str1.length())
        {
          int i1 = str1.charAt(m);
          int i2 = this.c;
          this.c = (i2 + 1);
          a(i1, i2);
          m++;
          continue;
          str1 = "&#" + paramInt + ";";
          continue;
          str1 = "&#" + paramInt + ";";
        }
        continue;
      }
      int n = this.c;
      this.c = (n + 1);
      a(paramInt, n);
    }
  }

  private void a(aw paramaw, az paramaz, short paramShort, int paramInt, ay paramay)
  {
    dj localdj = this.j.ap;
    int k = this.c;
    this.c = (k + 1);
    a(60, k);
    if (paramay.h == 6)
    {
      int i5 = this.c;
      this.c = (i5 + 1);
      a(47, i5);
    }
    String str = paramay.n;
    int m = 0;
    if (m >= str.length())
    {
      b(paramaz, paramInt, paramay, paramay.o);
      if (((this.j.p) || (this.j.q)) && ((paramay.h == 7) || (do.a(0x1 & paramay.m.c))))
      {
        int i2 = this.c;
        this.c = (i2 + 1);
        a(32, i2);
        int i3 = this.c;
        this.c = (i3 + 1);
        a(47, i3);
      }
      int i4 = this.c;
      this.c = (i4 + 1);
      a(62, i4);
      if (((paramay.h == 7) && (!this.j.q)) || (do.a(paramShort & 0x1)))
        break label390;
      if (paramInt + this.c >= this.j.b)
        c(paramaz, paramInt);
      if ((paramInt + this.c < this.j.b) && (!do.a(paramShort & 0x8)) && ((!do.a(0x10 & paramay.m.c)) || (paramay.m == localdj.D)) && (b(paramay)))
        this.d = this.c;
    }
    while (true)
    {
      return;
      int n = do.a(str.charAt(m), this.j.t, this.j.o);
      int i1 = this.c;
      this.c = (i1 + 1);
      a(n, i1);
      m++;
      break;
      label390: b(paramaz, paramInt);
    }
  }

  private void a(az paramaz, int paramInt, aw paramaw, ay paramay)
  {
    boolean bool = this.j.G;
    this.j.G = false;
    if (paramInt + this.c < this.j.b)
      this.d = this.c;
    b(paramaz, paramInt);
    int k = this.c;
    this.c = (k + 1);
    a(60, k);
    int m = this.c;
    this.c = (m + 1);
    a(33, m);
    int n = this.c;
    this.c = (n + 1);
    a(68, n);
    int i1 = this.c;
    this.c = (i1 + 1);
    a(79, i1);
    int i2 = this.c;
    this.c = (i2 + 1);
    a(67, i2);
    int i3 = this.c;
    this.c = (i3 + 1);
    a(84, i3);
    int i4 = this.c;
    this.c = (i4 + 1);
    a(89, i4);
    int i5 = this.c;
    this.c = (i5 + 1);
    a(80, i5);
    int i6 = this.c;
    this.c = (i6 + 1);
    a(69, i6);
    int i7 = this.c;
    this.c = (i7 + 1);
    a(32, i7);
    if (paramInt + this.c < this.j.b)
      this.d = this.c;
    int i8 = paramay.e;
    short s = 0;
    if (i8 >= paramay.f)
    {
      if (this.c < this.j.b)
        this.d = this.c;
      int i12 = this.c;
      this.c = (i12 + 1);
      a(62, i12);
      this.j.G = bool;
      b(paramaz, paramInt);
      return;
    }
    if (paramInt + this.c >= this.j.b)
      c(paramaz, paramInt);
    int i9 = 0xFF & paramay.g[i8];
    label433: int[] arrayOfInt;
    int i10;
    if (do.a(s & 0x10))
    {
      if (i9 == 93)
        s = (short)(s & 0xFFFFFFEF);
      arrayOfInt = new int[1];
      if (i9 <= 127)
        break label519;
      i10 = i8 + a(paramay.g, i8, arrayOfInt);
    }
    for (int i11 = arrayOfInt[0]; ; i11 = i9)
    {
      if (i11 == 10)
        a(paramaz, paramInt);
      while (true)
      {
        i8 = i10 + 1;
        break;
        if (i9 != 91)
          break label433;
        s = (short)(s | 0x10);
        break label433;
        a(i11, s);
      }
      label519: i10 = i8;
    }
  }

  private void a(az paramaz, int paramInt, ay paramay)
  {
    if (this.j.ae);
    while (true)
    {
      return;
      if (paramInt + this.c < this.j.b)
        this.d = this.c;
      int k = this.c;
      this.c = (k + 1);
      a(60, k);
      int m = this.c;
      this.c = (m + 1);
      a(33, m);
      int n = this.c;
      this.c = (n + 1);
      a(45, n);
      int i1 = this.c;
      this.c = (i1 + 1);
      a(45, i1);
      a(paramaz, 2, paramInt, paramay.g, paramay.e, paramay.f);
      int i2 = this.c;
      this.c = (i2 + 1);
      a(45, i2);
      int i3 = this.c;
      this.c = (i3 + 1);
      a(45, i3);
      int i4 = this.c;
      this.c = (i4 + 1);
      a(62, i4);
      if (!paramay.k)
        continue;
      a(paramaz, paramInt);
    }
  }

  private void a(az paramaz, int paramInt, ay paramay, b paramb)
  {
    int k = 0;
    if (this.j.Q)
      a(paramaz, paramInt);
    for (int m = paramInt + this.j.a; ; m = paramInt)
    {
      String str1 = paramb.f;
      if (m + this.c >= this.j.b)
        c(paramaz, m);
      boolean bool;
      if ((!this.j.o) && (!this.j.p) && (paramb.b != null))
        if (y.a().c(str1))
          bool = this.j.K;
      while (true)
      {
        label156: String str2;
        if (m + this.c < this.j.b)
        {
          this.d = this.c;
          int i3 = this.c;
          this.c = (i3 + 1);
          a(32, i3);
          if (k < str1.length())
            break label308;
          if (m + this.c >= this.j.b)
            c(paramaz, m);
          if (paramb.g != null)
            break label436;
          if ((!this.j.o) && (!this.j.p))
            break label370;
          if (!paramb.a())
            break label362;
          str2 = paramb.f;
          label233: a(paramaz, m, str2, paramb.e, true);
        }
        while (true)
        {
          return;
          if ((paramb.b.c()) || (!this.j.J))
            break label458;
          bool = true;
          break;
          b(paramaz, m);
          int n = this.c;
          this.c = (n + 1);
          a(32, n);
          break label156;
          label308: int i1 = do.a(str1.charAt(k), this.j.u, this.j.o);
          int i2 = this.c;
          this.c = (i2 + 1);
          a(i1, i2);
          k++;
          break label156;
          label362: str2 = "";
          break label233;
          label370: if ((!paramb.a()) && (paramay != null) && (!paramay.d()))
          {
            a(paramaz, m, "", paramb.e, true);
            continue;
          }
          if (m + this.c >= this.j.b)
            continue;
          this.d = this.c;
          continue;
          label436: a(paramaz, m, paramb.g, paramb.e, bool);
        }
        label458: bool = false;
      }
    }
  }

  private void a(az paramaz, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[1];
    boolean bool1 = false;
    short s1;
    if (paramBoolean)
    {
      s1 = 4;
      if (paramString == null)
        break label920;
    }
    label396: label663: label920: for (byte[] arrayOfByte = do.a(paramString); ; arrayOfByte = null)
    {
      if ((arrayOfByte != null) && (arrayOfByte.length >= 5) && (arrayOfByte[0] == 60) && ((arrayOfByte[1] == 37) || (arrayOfByte[1] == 64) || (new String(arrayOfByte, 0, 5).equals("<?php"))));
      for (short s2 = s1 | 0x10; ; s2 = s1)
      {
        if (paramInt2 == 0)
          paramInt2 = 34;
        int k = this.c;
        this.c = (k + 1);
        a(61, k);
        label203: int i1;
        if (!this.j.p)
        {
          if (paramInt1 + this.c < this.j.b)
            this.d = this.c;
          if (paramInt1 + this.c >= this.j.b)
            c(paramaz, paramInt1);
          if (paramInt1 + this.c < this.j.b)
            this.d = this.c;
        }
        else
        {
          int m = this.c;
          this.c = (m + 1);
          a(paramInt2, m);
          if (paramString != null)
          {
            this.f = false;
            i1 = 0;
          }
        }
        while (true)
        {
          if (i1 >= arrayOfByte.length)
          {
            this.f = false;
            int n = this.c;
            this.c = (n + 1);
            a(paramInt2, n);
            return;
            s1 = 5;
            break;
            b(paramaz, paramInt1);
            break label203;
          }
          int i2 = 0xFF & arrayOfByte[i1];
          if ((paramBoolean) && (i2 == 32) && (paramInt1 + this.c < this.j.b))
          {
            this.d = this.c;
            bool1 = this.f;
          }
          if ((paramBoolean) && (this.d > 0) && (paramInt1 + this.c >= this.j.b))
            a(paramaz, paramInt1, bool1);
          if (i2 == paramInt2)
          {
            String str;
            if (i2 == 34)
              str = "&quot;";
            for (int i16 = 0; ; i16++)
            {
              if (i16 >= str.length())
              {
                i1++;
                break;
                str = "&#39;";
                break label396;
              }
              int i17 = str.charAt(i16);
              int i18 = this.c;
              this.c = (i18 + 1);
              a(i17, i18);
            }
          }
          if (i2 == 34)
          {
            if (this.j.G)
            {
              int i10 = this.c;
              this.c = (i10 + 1);
              a(38, i10);
              int i11 = this.c;
              this.c = (i11 + 1);
              a(113, i11);
              int i12 = this.c;
              this.c = (i12 + 1);
              a(117, i12);
              int i13 = this.c;
              this.c = (i13 + 1);
              a(111, i13);
              int i14 = this.c;
              this.c = (i14 + 1);
              a(116, i14);
              int i15 = this.c;
              this.c = (i15 + 1);
              a(59, i15);
              label609: if (paramInt2 == 39)
                if (!this.f)
                  break label663;
            }
            for (boolean bool3 = false; ; bool3 = true)
            {
              this.f = bool3;
              i1++;
              break;
              int i9 = this.c;
              this.c = (i9 + 1);
              a(34, i9);
              break label609;
            }
          }
          if (i2 == 39)
          {
            if (this.j.G)
            {
              int i4 = this.c;
              this.c = (i4 + 1);
              a(38, i4);
              int i5 = this.c;
              this.c = (i5 + 1);
              a(35, i5);
              int i6 = this.c;
              this.c = (i6 + 1);
              a(51, i6);
              int i7 = this.c;
              this.c = (i7 + 1);
              a(57, i7);
              int i8 = this.c;
              this.c = (i8 + 1);
              a(59, i8);
              label796: if (paramInt2 == 34)
                if (!this.f)
                  break label850;
            }
            label850: for (boolean bool2 = false; ; bool2 = true)
            {
              this.f = bool2;
              i1++;
              break;
              int i3 = this.c;
              this.c = (i3 + 1);
              a(39, i3);
              break label796;
            }
          }
          if (i2 > 127)
          {
            i1 += a(arrayOfByte, i1, arrayOfInt);
            i2 = arrayOfInt[0];
          }
          i1++;
          if (i2 == 10)
          {
            a(paramaz, paramInt1);
            continue;
          }
          a(i2, s2);
        }
      }
    }
  }

  private void a(az paramaz, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    int m;
    label12: int n;
    int i1;
    if (k >= paramInt)
    {
      m = 0;
      if (m < this.d)
        break label157;
      paramaz.a(32);
      if (paramBoolean)
        paramaz.a(92);
      paramaz.a();
      if (this.c <= this.d)
        break label185;
      if (this.a[this.d] == 32)
        this.d = (1 + this.d);
      n = this.d;
      a(0, this.c);
      i1 = 0;
      label100: this.a[i1] = this.a[n];
      if (this.a[n] != 0)
        break label176;
      this.c -= this.d;
    }
    while (true)
    {
      this.d = 0;
      return;
      paramaz.a(32);
      k++;
      break;
      label157: paramaz.a(this.a[m]);
      m++;
      break label12;
      label176: i1++;
      n++;
      break label100;
      label185: this.c = 0;
    }
  }

  private void a(az paramaz, short paramShort, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    int k = paramInt2;
    if (k >= paramInt3)
      return;
    if (paramInt1 + this.c >= this.j.b)
      c(paramaz, paramInt1);
    int m = 0xFF & paramArrayOfByte[k];
    if (m > 127)
    {
      k += a(paramArrayOfByte, k, arrayOfInt);
      m = arrayOfInt[0];
    }
    if (m == 10)
      a(paramaz, paramInt1);
    while (true)
    {
      k++;
      break;
      a(m, paramShort);
    }
  }

  private void a(String paramString)
  {
    for (int k = 0; ; k++)
    {
      if (k >= paramString.length())
        return;
      int m = paramString.charAt(k);
      int n = this.c;
      this.c = (n + 1);
      a(m, n);
    }
  }

  private void a(short paramShort, int paramInt, ay paramay)
  {
    int k = this.c;
    this.c = (k + 1);
    a(60, k);
    int m = this.c;
    this.c = (m + 1);
    a(47, m);
    String str = paramay.n;
    for (int n = 0; ; n++)
    {
      if (n >= str.length())
      {
        int i3 = this.c;
        this.c = (i3 + 1);
        a(62, i3);
        return;
      }
      int i1 = do.a(str.charAt(n), this.j.t, this.j.o);
      int i2 = this.c;
      this.c = (i2 + 1);
      a(i1, i2);
    }
  }

  static boolean a(aw paramaw, ay paramay)
  {
    int k = 0;
    if (paramay.h != 4);
    while (true)
    {
      return k;
      int m = 1 + (paramay.f - paramay.e);
      int n = do.a(paramay.g, paramay.e, m).indexOf("<![CDATA[");
      if ((n <= -1) || (n > m))
        continue;
      k = 1;
    }
  }

  private void b(az paramaz, int paramInt, ay paramay)
  {
    if (paramInt + this.c < this.j.b)
      this.d = this.c;
    int k = this.c;
    this.c = (k + 1);
    a(60, k);
    int m = this.c;
    this.c = (m + 1);
    a(63, m);
    a(paramaz, 16, paramInt, paramay.g, paramay.e, paramay.f);
    if ((paramay.f <= 0) || (paramay.g[(-1 + paramay.f)] != 63))
    {
      int n = this.c;
      this.c = (n + 1);
      a(63, n);
    }
    int i1 = this.c;
    this.c = (i1 + 1);
    a(62, i1);
    b(paramaz, paramInt);
  }

  private void b(az paramaz, int paramInt, ay paramay, b paramb)
  {
    if ((this.j.p) && (this.j.S) && (bs.a(paramay, this.j.ap)) && (paramay.a("xml:space") == null))
    {
      paramay.a("xml:space", "preserve");
      if (paramb != null)
        paramb = paramay.o;
    }
    if (paramb != null)
    {
      if (paramb.a != null)
        b(paramaz, paramInt, paramay, paramb.a);
      if (paramb.f == null)
        break label145;
      x localx = paramb.b;
      if ((!this.j.z) || ((localx != null) && (!do.a(0x1C0 & localx.d()))))
        a(paramaz, paramInt, paramay, paramb);
    }
    while (true)
    {
      return;
      label145: if (paramb.c != null)
      {
        int m = this.c;
        this.c = (m + 1);
        a(32, m);
        d(paramaz, paramInt, paramb.c);
        continue;
      }
      if (paramb.d == null)
        continue;
      int k = this.c;
      this.c = (k + 1);
      a(32, k);
      f(paramaz, paramInt, paramb.d);
    }
  }

  private static boolean b(ay paramay)
  {
    boolean bool = true;
    if ((paramay == null) || (paramay.m == null) || (!do.a(0x10 & paramay.m.c)));
    while (true)
    {
      return bool;
      ay localay = paramay.b;
      if (localay != null)
      {
        if ((localay.h == 4) && (localay.f > localay.e))
        {
          int k = 0xFF & localay.g[(-1 + localay.f)];
          if ((k == 160) || (k == 32) || (k == 10))
            continue;
        }
        bool = false;
        continue;
      }
      bool = b(paramay.a);
    }
  }

  private int c(aw paramaw, ay paramay)
  {
    int m;
    if ((paramay.h == 4) && (paramay.f > paramay.e))
    {
      m = -1 + paramay.f;
      if (m >= paramay.e)
      {
        int n = 0xFF & paramay.g[m];
        if ((do.a(n)) && ((n == 32) || (n == 9) || (n == 13)));
      }
      else
      {
        if ((m < 0) || (paramay.g[m] != 10))
          break label115;
      }
    }
    label115: for (int k = -1 + (paramay.f - m); ; k = -1)
    {
      return k;
      m--;
      break;
    }
  }

  private void c(az paramaz, int paramInt)
  {
    if (this.d == 0)
      return;
    int k = 0;
    label10: int m;
    label18: int n;
    int i1;
    if (k >= paramInt)
    {
      m = 0;
      if (m < this.d)
        break label168;
      if (this.f)
      {
        paramaz.a(32);
        paramaz.a(92);
      }
      paramaz.a();
      if (this.c <= this.d)
        break label196;
      if (this.a[this.d] == 32)
        this.d = (1 + this.d);
      n = this.d;
      a(0, this.c);
      i1 = 0;
      label109: this.a[i1] = this.a[n];
      if (this.a[n] != 0)
        break label187;
      this.c -= this.d;
    }
    while (true)
    {
      this.d = 0;
      break;
      paramaz.a(32);
      k++;
      break label10;
      label168: paramaz.a(this.a[m]);
      m++;
      break label18;
      label187: i1++;
      n++;
      break label109;
      label196: this.c = 0;
    }
  }

  private void c(az paramaz, int paramInt, ay paramay)
  {
    if (paramInt + this.c < this.j.b)
      this.d = this.c;
    int k = this.c;
    this.c = (k + 1);
    a(60, k);
    int m = this.c;
    this.c = (m + 1);
    a(63, m);
    int n = this.c;
    this.c = (n + 1);
    a(120, n);
    int i1 = this.c;
    this.c = (i1 + 1);
    a(109, i1);
    int i2 = this.c;
    this.c = (i2 + 1);
    a(108, i2);
    b(paramaz, paramInt, paramay, paramay.o);
    if ((paramay.f <= 0) || (paramay.g[(-1 + paramay.f)] != 63))
    {
      int i3 = this.c;
      this.c = (i3 + 1);
      a(63, i3);
    }
    int i4 = this.c;
    this.c = (i4 + 1);
    a(62, i4);
    b(paramaz, paramInt);
  }

  private void c(az paramaz, short paramShort, int paramInt, aw paramaw, ay paramay)
  {
    c(paramay);
    a(paramaw, paramaz, paramShort, 0, paramay);
    b localb;
    String str4;
    String str3;
    String str2;
    String str1;
    boolean bool1;
    if ((paramaw.F.q) && (paramay.p != null))
    {
      localb = paramay.a("type");
      if (localb != null)
        if ("text/javascript".equalsIgnoreCase(localb.g))
        {
          str4 = "//";
          str3 = "";
          boolean bool2 = a(paramaw, paramay.p);
          if (!bool2)
          {
            int i2 = paramaw.F.b;
            paramaw.F.b = 16777215;
            this.c = a(str4, this.c);
            this.c = a("<![CDATA[", this.c);
            this.c = a(str3, this.c);
            b(paramaz, 0);
            paramaw.F.b = i2;
          }
          str2 = str4;
          str1 = str3;
          bool1 = bool2;
        }
    }
    while (true)
    {
      ay localay = paramay.p;
      int k = -1;
      label196: int m;
      if (localay == null)
      {
        if (k < 0)
        {
          b(paramaz, 0);
          k = 0;
        }
        if ((paramaw.F.q) && (paramay.p != null) && (!bool1))
        {
          m = paramaw.F.b;
          paramaw.F.b = 16777215;
          if ((k > 0) && (this.c < k))
            this.c = k;
        }
      }
      for (int n = 0; ; n++)
      {
        if ((k >= 0) || (n >= 0 - k))
        {
          this.c = a(str2, this.c);
          this.c = a("]]>", this.c);
          this.c = a(str1, this.c);
          paramaw.F.b = m;
          b(paramaz, 0);
          a(paramShort, 0, paramay);
          if ((!paramaw.F.l) && (paramay.c != null) && ((paramay.m == null) || (!do.a(0x10 & paramay.m.c))) && (paramay.h == 4))
            a(paramaz, 0);
          a(paramaz, 0);
          return;
          if ("text/css".equalsIgnoreCase(localb.g))
          {
            str4 = "/*";
            str3 = "*/";
            break;
          }
          if (!"text/vbscript".equalsIgnoreCase(localb.g))
            break label559;
          str4 = "'";
          str3 = "";
          break;
          a(paramaz, 0x10 | (0x8 | (paramShort | 0x1)), 0, paramaw, localay);
          if (localay.c == null)
            k = c(paramaw, localay);
          localay = localay.c;
          break label196;
        }
        int i1 = this.c;
        this.c = (i1 + 1);
        a(32, i1);
      }
      label559: str3 = "";
      str4 = "";
      break;
      bool1 = false;
      str1 = "";
      str2 = "";
    }
  }

  private boolean c(ay paramay)
  {
    boolean bool;
    if (paramay.m == this.j.ap.c)
      bool = true;
    while (true)
    {
      return bool;
      if (paramay.a != null)
      {
        bool = c(paramay.a);
        continue;
      }
      bool = false;
    }
  }

  private void d(az paramaz, int paramInt)
  {
    b(paramaz, paramInt);
    a("<center><small>");
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMinimumIntegerDigits(3);
    if (this.g > 1)
    {
      a("<a href=\"slide" + localNumberFormat.format(-1 + this.g) + ".html\">previous</a> | ");
      b(paramaz, paramInt);
      if (this.g >= this.h)
        break label160;
      a("<a href=\"slide001.html\">start</a> | ");
    }
    while (true)
    {
      b(paramaz, paramInt);
      if (this.g < this.h)
        a("<a href=\"slide" + localNumberFormat.format(1 + this.g) + ".html\">next</a>");
      a("</small></center>");
      b(paramaz, paramInt);
      return;
      label160: a("<a href=\"slide001.html\">start</a>");
    }
  }

  private void d(az paramaz, int paramInt, ay paramay)
  {
    int k = this.j.b;
    if ((!this.j.M) || (!this.j.N))
      this.j.b = 16777215;
    int m = this.c;
    this.c = (m + 1);
    a(60, m);
    int n = this.c;
    this.c = (n + 1);
    a(37, n);
    if (this.j.M);
    for (short s = 16; ; s = 2)
    {
      a(paramaz, s, paramInt, paramay.g, paramay.e, paramay.f);
      int i1 = this.c;
      this.c = (i1 + 1);
      a(37, i1);
      int i2 = this.c;
      this.c = (i2 + 1);
      a(62, i2);
      this.j.b = k;
      return;
    }
  }

  private boolean d(ay paramay)
  {
    int k = 0;
    dj localdj = this.j.ap;
    if (!this.j.l);
    while (true)
    {
      return k;
      if (this.j.m)
      {
        if ((paramay.p != null) && (do.a(0x40000 & paramay.m.c)))
        {
          for (ay localay = paramay.p; ; localay = localay.c)
          {
            if (localay == null)
              break label105;
            if ((localay.m == null) || (!do.a(0x8 & localay.m.c)))
              continue;
            k = 1;
            break;
          }
          label105: continue;
        }
        if ((do.a(0x4000 & paramay.m.c)) || (paramay.m == localdj.q) || (paramay.m == localdj.j))
          continue;
      }
      if (do.a(0xC00 & paramay.m.c))
      {
        k = 1;
        continue;
      }
      if (paramay.m == localdj.Q)
      {
        k = 1;
        continue;
      }
      if (do.a(0x10 & paramay.m.c))
        continue;
      k = 1;
    }
  }

  private void e(az paramaz, int paramInt, ay paramay)
  {
    int k = this.j.b;
    if (!this.j.N)
      this.j.b = 16777215;
    int m = this.c;
    this.c = (m + 1);
    a(60, m);
    int n = this.c;
    this.c = (n + 1);
    a(35, n);
    if (this.j.N);
    for (short s = 16; ; s = 2)
    {
      a(paramaz, s, paramInt, paramay.g, paramay.e, paramay.f);
      int i1 = this.c;
      this.c = (i1 + 1);
      a(35, i1);
      int i2 = this.c;
      this.c = (i2 + 1);
      a(62, i2);
      this.j.b = k;
      return;
    }
  }

  private void f(az paramaz, int paramInt, ay paramay)
  {
    int k = this.j.b;
    if (!this.j.O)
      this.j.b = 16777215;
    int m = this.c;
    this.c = (m + 1);
    a(60, m);
    int n = this.c;
    this.c = (n + 1);
    a(63, n);
    if (this.j.O);
    for (short s = 16; ; s = 2)
    {
      a(paramaz, s, paramInt, paramay.g, paramay.e, paramay.f);
      int i1 = this.c;
      this.c = (i1 + 1);
      a(63, i1);
      int i2 = this.c;
      this.c = (i2 + 1);
      a(62, i2);
      this.j.b = k;
      return;
    }
  }

  private void g(az paramaz, int paramInt, ay paramay)
  {
    int k = this.j.b;
    if (!this.j.af);
    for (int m = 0; ; m = paramInt)
    {
      b(paramaz, m);
      this.j.b = 16777215;
      int n = this.c;
      this.c = (n + 1);
      a(60, n);
      int i1 = this.c;
      this.c = (i1 + 1);
      a(33, i1);
      int i2 = this.c;
      this.c = (i2 + 1);
      a(91, i2);
      int i3 = this.c;
      this.c = (i3 + 1);
      a(67, i3);
      int i4 = this.c;
      this.c = (i4 + 1);
      a(68, i4);
      int i5 = this.c;
      this.c = (i5 + 1);
      a(65, i5);
      int i6 = this.c;
      this.c = (i6 + 1);
      a(84, i6);
      int i7 = this.c;
      this.c = (i7 + 1);
      a(65, i7);
      int i8 = this.c;
      this.c = (i8 + 1);
      a(91, i8);
      a(paramaz, 2, m, paramay.g, paramay.e, paramay.f);
      int i9 = this.c;
      this.c = (i9 + 1);
      a(93, i9);
      int i10 = this.c;
      this.c = (i10 + 1);
      a(93, i10);
      int i11 = this.c;
      this.c = (i11 + 1);
      a(62, i11);
      b(paramaz, m);
      this.j.b = k;
      return;
    }
  }

  private void h(az paramaz, int paramInt, ay paramay)
  {
    int k = this.j.b;
    if (!this.j.L)
      this.j.b = 16777215;
    int m = this.c;
    this.c = (m + 1);
    a(60, m);
    int n = this.c;
    this.c = (n + 1);
    a(33, n);
    int i1 = this.c;
    this.c = (i1 + 1);
    a(91, i1);
    if (this.j.L);
    for (short s = 16; ; s = 2)
    {
      a(paramaz, s, paramInt, paramay.g, paramay.e, paramay.f);
      int i2 = this.c;
      this.c = (i2 + 1);
      a(93, i2);
      int i3 = this.c;
      this.c = (i3 + 1);
      a(62, i3);
      this.j.b = k;
      return;
    }
  }

  public int a(ay paramay)
  {
    int k = 1;
    dj localdj = this.j.ap;
    if ((paramay != null) && (paramay.p != null) && (paramay.p.m == localdj.p))
      k = 0;
    if (paramay != null);
    for (ay localay = paramay.p; ; localay = localay.c)
    {
      if (localay == null)
        return k;
      if (localay.m != localdj.p)
        continue;
      k++;
    }
  }

  public void a(aw paramaw, ay paramay, double paramDouble)
  {
    ay localay1 = paramay.c(paramaw.F.ap);
    String str = "blendTrans(Duration=" + new Double(paramDouble).toString() + ")";
    if (localay1 != null)
    {
      ay localay2 = paramaw.b("meta");
      localay2.a("http-equiv", "Page-Enter");
      localay2.a("content", str);
      localay1.b(localay2);
    }
  }

  public void a(az paramaz, int paramInt)
  {
    int k;
    if (this.c > 0)
    {
      if (paramInt + this.c >= this.j.b)
        c(paramaz, paramInt);
      if ((!this.e) || (this.j.Q))
      {
        k = 0;
        if (k < paramInt)
          break label87;
      }
    }
    for (int m = 0; ; m++)
    {
      if (m >= this.c)
      {
        paramaz.a();
        this.c = 0;
        this.d = 0;
        this.e = false;
        return;
        label87: paramaz.a(32);
        k++;
        break;
      }
      paramaz.a(this.a[m]);
    }
  }

  void a(az paramaz, aw paramaw, ay paramay, boolean paramBoolean)
  {
    if (paramay == null);
    ay localay1;
    do
    {
      return;
      localay1 = paramay.a(paramaw.F.ap);
    }
    while (localay1 == null);
    ay localay2 = localay1.p;
    label30: if (localay2 != null)
    {
      if (!paramBoolean)
        break label60;
      b(paramaz, 0, 0, paramaw, localay2);
    }
    while (true)
    {
      localay2 = localay2.c;
      break label30;
      break;
      label60: a(paramaz, 0, 0, paramaw, localay2);
    }
  }

  public void a(az paramaz, short paramShort, int paramInt, aw paramaw)
  {
    dj localdj = this.j.ap;
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMinimumIntegerDigits(3);
    StringBuilder localStringBuilder = new StringBuilder("<div onclick=\"document.location='slide");
    label236: int i13;
    label273: Object localObject1;
    Object localObject2;
    if (this.g < this.h)
    {
      int k = 1 + this.g;
      a(localNumberFormat.format(k) + ".html'\">");
      b(paramaz, paramInt);
      if ((this.i != null) && (this.i.m == localdj.p))
      {
        d(paramaz, paramInt);
        int i7 = this.c;
        this.c = (i7 + 1);
        a(60, i7);
        int i8 = do.a('h', this.j.t, this.j.o);
        int i9 = this.c;
        this.c = (i9 + 1);
        a(i8, i9);
        int i10 = do.a('r', this.j.t, this.j.o);
        int i11 = this.c;
        this.c = (i11 + 1);
        a(i10, i11);
        if (!this.j.p)
          break label504;
        a(" />");
        if (this.j.l)
          b(paramaz, paramInt);
        if (!this.j.l)
          break label529;
        i13 = paramInt + this.j.a;
        a(paramaz, paramShort, i13, paramaw, this.i);
        this.i = this.i.c;
      }
      localObject1 = this.i;
      localObject2 = null;
      if (localObject1 != null)
        break label535;
      label312: this.i = ((ay)localObject1);
      b(paramaz, paramInt);
      a("<br clear=\"all\">");
      b(paramaz, paramInt);
      int i1 = this.c;
      this.c = (i1 + 1);
      a(60, i1);
      int i2 = do.a('h', this.j.t, this.j.o);
      int i3 = this.c;
      this.c = (i3 + 1);
      a(i2, i3);
      int i4 = do.a('r', this.j.t, this.j.o);
      int i5 = this.c;
      this.c = (i5 + 1);
      a(i4, i5);
      if (!this.j.p)
        break label670;
      a(" />");
    }
    while (true)
    {
      if (this.j.l)
        b(paramaz, paramInt);
      d(paramaz, paramInt);
      a("</div>");
      b(paramaz, paramInt);
      return;
      int m = 1;
      break;
      label504: int i12 = this.c;
      this.c = (i12 + 1);
      a(62, i12);
      break label236;
      label529: i13 = paramInt;
      break label273;
      label535: if (((ay)localObject1).m == localdj.p)
        break label312;
      if ((localObject2 != null) && (!this.j.l) && (localObject2.h == 4) && (((ay)localObject1).m != null) && (do.a(0x8 & ((ay)localObject1).m.c)))
      {
        a(paramaz, paramInt);
        a(paramaz, paramInt);
      }
      if (this.j.l);
      for (int n = paramInt + this.j.a; ; n = paramInt)
      {
        a(paramaz, paramShort, n, paramaw, (ay)localObject1);
        ay localay = ((ay)localObject1).c;
        Object localObject3 = localObject1;
        localObject1 = localay;
        localObject2 = localObject3;
        break;
      }
      label670: int i6 = this.c;
      this.c = (i6 + 1);
      a(62, i6);
    }
  }

  public void a(az paramaz, short paramShort, int paramInt, aw paramaw, ay paramay)
  {
    dj localdj = this.j.ap;
    if (paramay == null);
    while (true)
    {
      return;
      if ((paramay.h == 4) || ((paramay.h == 8) && (paramaw.F.al)))
      {
        byte[] arrayOfByte = paramay.g;
        int k = paramay.e;
        int m = paramay.f;
        a(paramaz, paramShort, paramInt, arrayOfByte, k, m);
        continue;
      }
      if (paramay.h == 2)
      {
        a(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 0)
      {
        for (ay localay7 = paramay.p; localay7 != null; localay7 = localay7.c)
          a(paramaz, paramShort, paramInt, paramaw, localay7);
        continue;
      }
      if (paramay.h == 1)
      {
        a(paramaz, paramInt, paramaw, paramay);
        continue;
      }
      if (paramay.h == 3)
      {
        b(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 13)
      {
        c(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 8)
      {
        g(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 9)
      {
        h(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 10)
      {
        d(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 11)
      {
        e(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 12)
      {
        f(paramaz, paramInt, paramay);
        continue;
      }
      if ((do.a(0x1 & paramay.m.c)) || ((paramay.h == 7) && (!this.j.q)))
      {
        if (!do.a(0x10 & paramay.m.c))
          b(paramaz, paramInt);
        if ((paramay.m == localdj.D) && (paramay.b != null) && (paramay.b.m != localdj.D) && (this.j.D))
          a(paramaz, paramInt);
        if ((this.j.v) && (paramay.m == localdj.T))
          a(" ");
        while (true)
        {
          if ((paramay.m != localdj.M) && (paramay.m != localdj.R))
            break label502;
          b(paramaz, paramInt);
          break;
          a(paramaw, paramaz, paramShort, paramInt, paramay);
        }
        label502: if ((paramay.m != localdj.D) && (paramay.m != localdj.l))
          continue;
        a(paramaz, paramInt);
        continue;
      }
      if (paramay.h == 7)
        paramay.h = 5;
      if ((paramay.m != null) && (paramay.m.b() == bs.j))
      {
        b(paramaz, paramInt);
        b(paramaz, 0);
        a(paramaw, paramaz, paramShort, 0, paramay);
        a(paramaz, 0);
        for (ay localay6 = paramay.p; ; localay6 = localay6.c)
        {
          if (localay6 == null)
          {
            b(paramaz, 0);
            a(paramShort, 0, paramay);
            a(paramaz, 0);
            if ((this.j.l) || (paramay.c == null))
              break;
            a(paramaz, 0);
            break;
          }
          a(paramaz, 0x8 | (paramShort | 0x1), 0, paramaw, localay6);
        }
      }
      if ((paramay.m == localdj.Y) || (paramay.m == localdj.Z))
      {
        c(paramaz, 0x10 | (0x8 | (paramShort | 0x1)), paramInt, paramaw, paramay);
        continue;
      }
      if (do.a(0x10 & paramay.m.c))
      {
        if (this.j.v)
        {
          if (paramay.m == localdj.U)
          {
            for (ay localay5 = paramay.p; localay5 != null; localay5 = localay5.c)
              a(paramaz, paramShort, paramInt, paramaw, localay5);
            continue;
          }
          if (paramay.m == localdj.S)
          {
            for (ay localay4 = paramay.p; localay4 != null; localay4 = localay4.c)
              a(paramaz, paramShort | 0x8, paramInt, paramaw, localay4);
            continue;
          }
        }
        a(paramaw, paramaz, paramShort, paramInt, paramay);
        int i3;
        ay localay3;
        if (d(paramay))
        {
          b(paramaz, paramInt);
          i3 = paramInt + this.j.a;
          localay3 = paramay.p;
          label903: if (localay3 == null)
          {
            b(paramaz, i3);
            paramInt = i3 - this.j.a;
            b(paramaz, paramInt);
          }
        }
        while (true)
        {
          a(paramShort, paramInt, paramay);
          break;
          a(paramaz, paramShort, i3, paramaw, localay3);
          localay3 = localay3.c;
          break label903;
          for (ay localay2 = paramay.p; localay2 != null; localay2 = localay2.c)
            a(paramaz, paramShort, paramInt, paramaw, localay2);
        }
      }
      b(paramaz, paramInt);
      if ((this.j.m) && (paramay.b != null))
        a(paramaz, paramInt);
      label1098: int i2;
      if ((!this.j.n) || (paramay.m == null) || (!do.a(0x200000 & paramay.m.c)) || (paramay.o != null))
      {
        a(paramaw, paramaz, paramShort, paramInt, paramay);
        if (d(paramay))
          b(paramaz, paramInt);
      }
      else
      {
        if ((paramay.m != localdj.d) || (!this.j.E))
          break label1383;
        if (!this.j.l)
          break label1377;
        i2 = paramInt + this.j.a;
        label1142: a(paramaz, paramShort, i2, paramaw);
        if ((!d(paramay)) && (((!do.a(0x2 & paramay.m.c)) && (paramay.m != localdj.h) && ((!do.a(0x4 & paramay.m.c)) || (paramay.m == localdj.j))) || (this.j.n)))
          break label1519;
        if (!this.j.l)
          break label1513;
      }
      label1377: label1383: label1513: for (int i1 = paramInt + this.j.a; ; i1 = paramInt)
      {
        b(paramaz, i1);
        if ((this.j.n) && (do.a(0x8000 & paramay.m.c)))
          break;
        a(paramShort, paramInt, paramay);
        if (paramaw.H)
          break;
        a(paramaz, paramInt);
        break;
        if ((!do.a(0x2 & paramay.m.c)) && (paramay.m != localdj.h) && ((!do.a(0x4 & paramay.m.c)) || (paramay.m == localdj.j)))
          break label1098;
        a(paramaz, paramInt);
        break label1098;
        i2 = paramInt;
        break label1142;
        Object localObject1 = paramay.p;
        Object localObject2 = null;
        label1393: if (localObject1 != null)
        {
          if ((localObject2 != null) && (!this.j.l) && (localObject2.h == 4) && (((ay)localObject1).m != null) && (!do.a(0x10 & ((ay)localObject1).m.c)))
            a(paramaz, paramInt);
          if (!d(paramay))
            break label1507;
        }
        for (int n = paramInt + this.j.a; ; n = paramInt)
        {
          a(paramaz, paramShort, n, paramaw, (ay)localObject1);
          ay localay1 = ((ay)localObject1).c;
          Object localObject3 = localObject1;
          localObject1 = localay1;
          localObject2 = localObject3;
          break label1393;
          break;
        }
      }
      label1507: label1519: if ((!this.j.n) || (!do.a(0x8000 & paramay.m.c)))
        a(paramShort, paramInt, paramay);
      a(paramaz, paramInt);
    }
  }

  public void b(aw paramaw, ay paramay)
  {
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMinimumIntegerDigits(3);
    ay localay = paramay.a(paramaw.F.ap);
    this.h = a(localay);
    this.i = localay.p;
    a(paramaw, paramay, 3.0D);
    this.g = 1;
    if (this.g > this.h);
    while (true)
    {
      while (true)
        if (!new File("slide" + localNumberFormat.format(this.g) + ".html").delete())
        {
          return;
          String str = "slide" + localNumberFormat.format(this.g) + ".html";
          try
          {
            FileOutputStream localFileOutputStream = new FileOutputStream(str);
            az localaz = ba.a(this.j, localFileOutputStream);
            a(localaz, 0, 0, paramaw, paramay);
            a(localaz, 0);
            localFileOutputStream.close();
            this.g = (1 + this.g);
          }
          catch (IOException localIOException)
          {
            while (true)
              System.err.println(str + localIOException.toString());
          }
        }
      this.g = (1 + this.g);
    }
  }

  public void b(az paramaz, int paramInt)
  {
    int k;
    if (this.c > 0)
    {
      if (paramInt + this.c >= this.j.b)
        c(paramaz, paramInt);
      if ((!this.e) || (this.j.Q))
      {
        k = 0;
        if (k < paramInt)
          break label87;
      }
    }
    for (int m = 0; ; m++)
    {
      if (m >= this.c)
      {
        paramaz.a();
        this.c = 0;
        this.d = 0;
        this.e = false;
        return;
        label87: paramaz.a(32);
        k++;
        break;
      }
      paramaz.a(this.a[m]);
    }
  }

  public void b(az paramaz, short paramShort, int paramInt, aw paramaw, ay paramay)
  {
    dj localdj = this.j.ap;
    if (paramay == null);
    while (true)
    {
      return;
      if ((paramay.h == 4) || ((paramay.h == 8) && (paramaw.F.al)))
      {
        a(paramaz, paramShort, paramInt, paramay.g, paramay.e, paramay.f);
        continue;
      }
      if (paramay.h == 2)
      {
        b(paramaz, paramInt);
        a(paramaz, 0, paramay);
        b(paramaz, 0);
        continue;
      }
      if (paramay.h == 0)
      {
        for (ay localay3 = paramay.p; localay3 != null; localay3 = localay3.c)
          b(paramaz, paramShort, paramInt, paramaw, localay3);
        continue;
      }
      if (paramay.h == 1)
      {
        a(paramaz, paramInt, paramaw, paramay);
        continue;
      }
      if (paramay.h == 3)
      {
        b(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 13)
      {
        c(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 8)
      {
        g(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 9)
      {
        h(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 10)
      {
        d(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 11)
      {
        e(paramaz, paramInt, paramay);
        continue;
      }
      if (paramay.h == 12)
      {
        f(paramaz, paramInt, paramay);
        continue;
      }
      if ((!do.a(0x1 & paramay.m.c)) && ((paramay.h != 7) || (this.j.q)))
        break;
      b(paramaz, paramInt);
      a(paramaw, paramaz, paramShort, paramInt, paramay);
    }
    int k = 0;
    ay localay1 = paramay.p;
    label377: label382: int m;
    int n;
    int i1;
    if (localay1 == null)
    {
      b(paramaz, paramInt);
      if (!bs.a(paramay, localdj))
        break label508;
      m = 0;
      n = 0;
      i1 = 0;
      label407: a(paramaw, paramaz, paramShort, i1, paramay);
      if ((n == 0) && (paramay.p != null))
        a(paramaz, i1);
    }
    for (ay localay2 = paramay.p; ; localay2 = localay2.c)
    {
      if (localay2 == null)
      {
        if ((n == 0) && (paramay.p != null))
          b(paramaz, m);
        a(paramShort, i1, paramay);
        break;
        if (localay1.h == 4)
        {
          k = 1;
          break label382;
        }
        localay1 = localay1.c;
        break label377;
        label508: if (k != 0)
        {
          m = paramInt;
          n = k;
          i1 = paramInt;
          break label407;
        }
        m = paramInt + this.j.a;
        n = k;
        i1 = paramInt;
        break label407;
      }
      b(paramaz, paramShort, m, paramaw, localay2);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.bc
 * JD-Core Version:    0.6.0
 */