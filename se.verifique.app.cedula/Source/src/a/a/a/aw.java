package a.a.a;

import java.io.PrintWriter;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class aw
{
  private static final ax[] K;
  protected ay A;
  protected int B;
  protected Stack C;
  protected int D;
  protected cr E;
  protected aa F;
  protected boolean G;
  protected boolean H;
  protected cn I;
  protected ay J;
  private List L;
  protected co a;
  protected PrintWriter b;
  protected short c;
  protected short d;
  protected short e;
  protected short f;
  protected short g;
  protected short h;
  protected int i;
  protected int j;
  protected boolean k;
  protected boolean l;
  protected boolean m;
  protected boolean n;
  protected boolean o;
  protected boolean p;
  protected short q;
  protected int r;
  protected boolean s;
  protected int t;
  protected int u;
  protected short v;
  protected ay w;
  protected byte[] x;
  protected int y;
  protected int z;

  static
  {
    ax[] arrayOfax = new ax[11];
    arrayOfax[0] = new ax("HTML 4.01", "XHTML 1.0 Strict", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", 4);
    arrayOfax[1] = new ax("HTML 4.01 Transitional", "XHTML 1.0 Transitional", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd", 8);
    arrayOfax[2] = new ax("HTML 4.01 Frameset", "XHTML 1.0 Frameset", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd", 16);
    arrayOfax[3] = new ax("HTML 4.0", "XHTML 1.0 Strict", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", 4);
    arrayOfax[4] = new ax("HTML 4.0 Transitional", "XHTML 1.0 Transitional", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd", 8);
    arrayOfax[5] = new ax("HTML 4.0 Frameset", "XHTML 1.0 Frameset", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd", 16);
    arrayOfax[6] = new ax("HTML 3.2", "XHTML 1.0 Transitional", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd", 2);
    arrayOfax[7] = new ax("HTML 3.2 Final", "XHTML 1.0 Transitional", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd", 2);
    arrayOfax[8] = new ax("HTML 3.2 Draft", "XHTML 1.0 Transitional", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd", 2);
    arrayOfax[9] = new ax("HTML 2.0", "XHTML 1.0 Strict", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", 1);
    arrayOfax[10] = new ax("HTML 4.01", "XHTML 1.1", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", 1024);
    K = arrayOfax;
  }

  public aw(co paramco, aa paramaa, cn paramcn)
  {
    this.I = paramcn;
    this.a = paramco;
    this.i = 1;
    this.j = 1;
    this.v = 0;
    this.q = 3551;
    this.r = 0;
    this.B = -1;
    this.C = new Stack();
    this.F = paramaa;
    this.L = new Vector();
  }

  public static boolean c(String paramString)
  {
    int i1 = 1;
    if (!do.e(paramString.charAt(0)))
      i1 = 0;
    while (true)
    {
      return i1;
      int i2 = i1;
      while (true)
        if (i2 < paramString.length())
        {
          if (do.f(paramString.charAt(i2)))
          {
            i2 += 1;
            continue;
          }
        }
        else
          break;
      i1 = 0;
    }
  }

  public ay a()
  {
    ay localay = new ay();
    this.L.add(localay);
    return localay;
  }

  public ay a(ay paramay)
  {
    ay localay = paramay.a(false);
    this.L.add(localay);
    for (b localb = localay.o; ; localb = localb.a)
    {
      if (localb == null)
        return localay;
      if (localb.c != null)
        this.L.add(localb.c);
      if (localb.d == null)
        continue;
      this.L.add(localb.d);
    }
  }

  public ay a(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ay localay = new ay(paramShort, paramArrayOfByte, paramInt1, paramInt2);
    this.L.add(localay);
    return localay;
  }

  public ay a(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    ay localay = new ay(paramShort, paramArrayOfByte, paramInt1, paramInt2, paramString, this.F.ap);
    this.L.add(localay);
    return localay;
  }

  public b a(b paramb)
  {
    b localb1 = (b)paramb.clone();
    for (b localb2 = localb1; ; localb2 = localb2.a)
    {
      if (localb2 == null)
        return localb1;
      if (localb2.c != null)
        this.L.add(localb2.c);
      if (localb2.d == null)
        continue;
      this.L.add(localb2.d);
    }
  }

  public b a(boolean[] paramArrayOfBoolean)
  {
    int[] arrayOfInt = new int[1];
    ay[] arrayOfay1 = new ay[1];
    ay[] arrayOfay2 = new ay[1];
    Object localObject = null;
    while (true)
    {
      if (c());
      String str1;
      do
      {
        return localObject;
        str1 = a(paramArrayOfBoolean, arrayOfay1, arrayOfay2);
        if (str1 != null)
          break label101;
        if (arrayOfay1[0] == null)
          continue;
        localObject = new b((b)localObject, null, arrayOfay1[0], null, 0, null, null);
        break;
      }
      while (arrayOfay2[0] == null);
      localObject = new b((b)localObject, null, null, arrayOfay2[0], 0, null, null);
      continue;
      label101: String str2 = a(str1, false, paramArrayOfBoolean, arrayOfInt);
      if ((str1 != null) && (c(str1)))
      {
        b localb2 = new b((b)localObject, null, null, null, arrayOfInt[0], str1, str2);
        localb2.b = y.a().a(localb2);
        localObject = localb2;
        continue;
      }
      b localb1 = new b(null, null, null, null, 0, str1, str2);
      if (str2 != null)
      {
        this.I.a(this, this.w, localb1, 51);
        continue;
      }
      if (do.b(str1) == 34)
      {
        this.I.a(this, this.w, localb1, 58);
        continue;
      }
      this.I.a(this, this.w, localb1, 48);
    }
  }

  public String a(String paramString, boolean paramBoolean, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = 1;
    int i3 = 0;
    paramArrayOfInt[0] = 34;
    if (this.F.Z)
      i2 = 0;
    int i4 = this.a.c();
    if (i4 == -1)
      this.a.a(i4);
    String str;
    while (true)
    {
      if ((i4 == 61) || (i4 == 34) || (i4 == 39))
        break label107;
      this.a.a(i4);
      str = null;
      return str;
      if (do.c((char)i4))
        break;
    }
    label107: int i5 = this.a.c();
    label136: label154: int i6;
    int i7;
    int i8;
    label166: int i9;
    if (i5 == -1)
    {
      this.a.a(i5);
      if ((i5 != 34) && (i5 != 39))
        break label461;
      i3 = i5;
      i6 = 0;
      i7 = this.z;
      i8 = 0;
      i9 = this.a.c();
      if (i9 != -1)
        break label544;
      this.I.a(this, this.w, null, 36);
      this.a.a(i9);
    }
    label210: int i13;
    int i15;
    label373: int i14;
    label401: label422: label435: label461: int i19;
    while (true)
    {
      if ((i6 > 10) && (i1 != 0) && (i2 != 0) && (!y.a().c(paramString)) && ((!y.a().b(paramString)) || (!"javascript:".equals(do.a(this.x, i7, 11)))) && (!"<xml ".equals(do.a(this.x, i7, 5))))
        this.I.b(this, null, null, 16);
      i13 = this.z - i7;
      this.z = i7;
      if ((i13 <= 0) && (i3 == 0))
        break label1101;
      if (i2 == 0)
        break label1116;
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "alt";
      arrayOfString[1] = "title";
      arrayOfString[2] = "value";
      arrayOfString[3] = "prompt";
      if (do.a(arrayOfString, paramString))
        break label1116;
      i15 = i13;
      if (do.c((char)this.x[(-1 + (i7 + i15))]))
        break label1086;
      i13 = i15;
      i14 = i7;
      if ((do.c((char)this.x[i14])) && (i14 < i13))
        break label1092;
      str = do.a(this.x, i14, i13);
      if (i3 == 0)
        break label1107;
      paramArrayOfInt[0] = i3;
      break;
      if (do.c((char)i5))
        break label107;
      break label136;
      if (i5 == 60)
      {
        int i20 = this.z;
        b(i5);
        paramArrayOfInt[0] = k();
        int i21 = this.z - i20;
        this.z = i20;
        if (i21 > 0)
        {
          str = do.a(this.x, i20, i21);
          break;
        }
        str = null;
        break;
      }
      this.a.a(i5);
      break label154;
      label544: if (i3 != 0)
        break label807;
      if (i9 == 62)
      {
        this.a.a(i9);
        continue;
      }
      if ((i9 == 34) || (i9 == 39))
      {
        this.I.a(this, this.w, null, 59);
        int i18 = this.a.c();
        if (i18 == 62)
        {
          b(i9);
          this.a.a(i18);
          continue;
        }
        this.a.a(i18);
      }
      if (i9 == 60)
      {
        this.a.a(i9);
        this.a.a(62);
        this.I.a(this, this.w, null, 52);
        continue;
      }
      if (i9 != 47)
        break label1130;
      i19 = this.a.c();
      if ((i19 != 62) || (y.a().b(paramString)))
        break label748;
      paramArrayOfBoolean[0] = true;
      this.a.a(i19);
    }
    label748: this.a.a(i19);
    int i11 = i1;
    int i12 = 47;
    while (true)
    {
      if (i12 == 38)
      {
        if ("id".equalsIgnoreCase(paramString))
        {
          this.I.a(this, null, null, 67);
          i8 = i12;
          i1 = i11;
          break label166;
          label807: if (i9 == i3)
            break label210;
          if (i9 == 13)
          {
            int i17 = this.a.c();
            if (i17 != 10)
              this.a.a(i17);
            i9 = 10;
          }
          if ((i9 == 10) || (i9 == 60) || (i9 == 62))
            i6++;
          if (i9 == 62)
          {
            int i16 = i9;
            i11 = 1;
            i12 = i16;
            continue;
          }
        }
        else
        {
          b(i12);
          a(0);
          i8 = i12;
          i1 = i11;
          break label166;
        }
      }
      else
      {
        if (i12 == 92)
        {
          i12 = this.a.c();
          if (i12 != 10)
          {
            this.a.a(i12);
            i12 = 92;
          }
        }
        if (do.c((char)i12))
        {
          if (i3 == 0)
          {
            i1 = i11;
            break label210;
          }
          if (i2 != 0)
          {
            if ((i12 == 10) && (y.a().b(paramString)))
            {
              this.I.a(this, this.w, null, 65);
              i8 = i12;
              i1 = i11;
              break label166;
            }
            i12 = 32;
            if (i8 == 32)
            {
              i8 = i12;
              i1 = i11;
              break label166;
            }
          }
        }
        else if ((!paramBoolean) || (!do.h((char)i12)));
        for (i8 = do.i((char)i12); ; i8 = i12)
        {
          b(i8);
          i1 = i11;
          break label166;
          label1086: i15--;
          break label373;
          label1092: i14++;
          i13--;
          break label401;
          label1101: str = null;
          break label435;
          label1107: paramArrayOfInt[0] = 34;
          break;
          label1116: i14 = i7;
          break label422;
        }
      }
      label1130: int i10 = i9;
      i11 = i1;
      i12 = i10;
    }
  }

  public String a(boolean[] paramArrayOfBoolean, ay[] paramArrayOfay1, ay[] paramArrayOfay2)
  {
    Object localObject = null;
    paramArrayOfay1[0] = null;
    paramArrayOfay2[0] = null;
    int i1 = this.a.c();
    label51: label69: int i2;
    int i3;
    label79: label104: int i4;
    if (i1 == 47)
    {
      int i8 = this.a.c();
      if (i8 == 62)
      {
        paramArrayOfBoolean[0] = true;
        return localObject;
      }
      this.a.a(i8);
      i1 = 47;
      i2 = this.z;
      i3 = i1;
      if ((i1 != 61) && (i1 != 62))
        break label357;
      this.a.a(i1);
      i4 = this.z - i2;
      if (i4 <= 0)
        break label499;
    }
    label357: label499: for (String str = do.a(this.x, i2, i4); ; str = null)
    {
      this.z = i2;
      localObject = str;
      break label51;
      if (i1 == 62)
        break label51;
      if (i1 == 60)
      {
        int i7 = this.a.c();
        if (i7 == 37)
        {
          paramArrayOfay1[0] = i();
          break label51;
        }
        if (i7 == 63)
        {
          paramArrayOfay2[0] = j();
          break label51;
        }
        this.a.a(i7);
        if (this.v != 13)
          this.a.a(60);
        this.I.a(this, this.w, null, 52);
        break label51;
      }
      if (i1 == 61)
      {
        this.I.a(this, this.w, null, 69);
        break;
      }
      if ((i1 == 34) || (i1 == 39))
      {
        this.I.a(this, this.w, null, 59);
        break;
      }
      if (i1 == -1)
      {
        this.I.a(this, this.w, null, 36);
        this.a.a(i1);
        break label51;
      }
      if (do.c((char)i1))
        break;
      break label69;
      if ((i1 == 60) || (i1 == -1))
      {
        this.a.a(i1);
        break label104;
      }
      if ((i3 == 45) && ((i1 == 34) || (i1 == 39)))
      {
        this.z = (-1 + this.z);
        this.a.a(i1);
        break label104;
      }
      if (do.c((char)i1))
        break label104;
      if ((!this.F.o) && (do.h((char)i1)))
        i1 = do.i((char)i1);
      b(i1);
      int i5 = this.a.c();
      int i6 = i1;
      i1 = i5;
      i3 = i6;
      break label79;
    }
  }

  public void a(byte paramByte)
  {
    if (this.z > 0)
      this.x[(-1 + this.z)] = paramByte;
  }

  public void a(int paramInt)
  {
    if (1 + this.z >= this.y);
    while (true)
    {
      if (1 + this.z < this.y)
      {
        byte[] arrayOfByte2 = this.x;
        this.x = new byte[this.y];
        if (arrayOfByte2 != null)
        {
          System.arraycopy(arrayOfByte2, 0, this.x, 0, arrayOfByte2.length);
          a(arrayOfByte2, this.x);
        }
        byte[] arrayOfByte1 = this.x;
        int i1 = this.z;
        this.z = (i1 + 1);
        arrayOfByte1[i1] = (byte)paramInt;
        this.x[this.z] = 0;
        return;
      }
      if (this.y == 0)
      {
        this.y = 8192;
        continue;
      }
      this.y = (2 * this.y);
    }
  }

  public void a(ay paramay, String paramString)
  {
    ay localay = paramay.p;
    b localb1;
    if ((localay == null) || (localay.m == this.F.ap.b))
      if (localay != null)
      {
        localb1 = localay.o;
        label36: if (localb1 != null)
          break label85;
        label41: if (localb1 == null)
          break label109;
        if (!localb1.g.equals(paramString))
        {
          this.I.a(this, localay, null, 33);
          localb1.g = paramString;
        }
      }
    while (true)
    {
      return;
      localay = localay.c;
      break;
      label85: if (localb1.f.equals("xmlns"))
        break label41;
      localb1 = localb1.a;
      break label36;
      label109: b localb2 = new b(localay.o, null, 34, "xmlns", paramString);
      localb2.b = y.a().a(localb2);
      localay.o = localb2;
    }
  }

  public void a(String paramString)
  {
    int i1 = paramString.length();
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        return;
      b(paramString.charAt(i2));
    }
  }

  void a(String paramString, int paramInt)
  {
    int i1 = paramString.length();
    if (i1 < paramInt)
      paramInt = i1;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= paramInt)
        return;
      b(paramString.charAt(i2));
    }
  }

  public void a(short paramShort)
  {
    short s1 = 1;
    int i1 = 0;
    int i2 = -1 + this.z;
    int i3 = -1 + this.a.a();
    short s2 = s1;
    int i4 = this.a.c();
    int i5;
    label51: String str;
    int i6;
    int i7;
    if (i4 == -1)
    {
      i5 = 0;
      str = do.a(this.x, i2, this.z - i2);
      if (("&apos".equals(str)) && (!this.F.p) && (!this.p) && (!this.F.q))
        this.I.a(this, 5, str, 39);
      i6 = au.a().b(str);
      if ((i6 > 0) && ((i6 < 256) || (i4 == 59)))
        break label490;
      this.i = this.a.b();
      this.j = i3;
      if (this.z <= i2 + 1)
        break label474;
      if ((i6 < 128) || (i6 > 159))
        break label455;
      if (!"WIN1252".equals(this.F.ao))
        break label420;
      i7 = aq.a(i6);
    }
    while (true)
    {
      label219: if (i7 != 0)
        s1 = 0;
      if (i4 != 59)
        this.I.a(this, 2, str, i4);
      this.I.a(this, (short)(s1 | 0x52), i6);
      if (i7 != 0)
      {
        this.z = i2;
        b(i7);
        label278: if (i1 != 0)
          b(59);
      }
      while (true)
      {
        return;
        if (i4 == 59)
        {
          i5 = s1;
          break label51;
        }
        if ((s2 != 0) && (i4 == 35))
        {
          if ((!this.F.am) || ("BIG5".equals(this.F.b())) || ("SHIFTJIS".equals(this.F.b())))
          {
            this.a.a(i4);
            continue;
          }
          b(i4);
          s2 = 0;
          break;
        }
        if (do.f((char)i4))
        {
          b(i4);
          s2 = 0;
          break;
        }
        this.a.a(i4);
        i5 = 0;
        break label51;
        label420: if (!"MACROMAN".equals(this.F.ao))
          break label613;
        i7 = aq.b(i6);
        break label219;
        this.z = i2;
        break label278;
        label455: this.I.a(this, 3, str, i6);
        i1 = i5;
        break label278;
        label474: this.I.a(this, 4, str, i6);
      }
      label490: if (i4 != 59)
      {
        this.i = this.a.b();
        this.j = i3;
        this.I.a(this, s1, str, i4);
      }
      this.z = i2;
      if ((i6 == 160) && (do.a(paramShort & 0x2)));
      for (int i8 = 32; ; i8 = i6)
      {
        b(i8);
        if ((i8 != 38) || (this.F.I))
          break;
        b(97);
        b(109);
        b(112);
        b(59);
        break;
      }
      label613: i7 = 0;
    }
  }

  protected void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.L.size())
        return;
      ay localay = (ay)this.L.get(i1);
      if (localay.g != paramArrayOfByte1)
        continue;
      localay.g = paramArrayOfByte2;
    }
  }

  public ay b()
  {
    ay localay = a();
    localay.g = this.x;
    localay.e = this.z;
    b(10);
    localay.f = this.z;
    return localay;
  }

  public ay b(String paramString)
  {
    ay localay = a(5, this.x, this.t, this.u, paramString);
    localay.j = true;
    return localay;
  }

  public ay b(short paramShort)
  {
    boolean[] arrayOfBoolean = new boolean[1];
    Object localObject1 = null;
    ay localay;
    if ((this.l) && ((this.w.h != 4) || ((this.B == -1) && (this.A == null))))
    {
      this.l = false;
      localay = this.w;
    }
    label51: int i1;
    int i2;
    label132: int i3;
    int i4;
    label336: label982: short s1;
    while (true)
    {
      return localay;
      if ((this.B != -1) || (this.A != null))
      {
        localay = l();
        continue;
      }
      this.i = this.a.b();
      this.j = this.a.a();
      this.k = false;
      this.t = this.z;
      this.u = this.z;
      i1 = 0;
      i2 = 0;
      while (true)
      {
        i3 = this.a.c();
        if (i3 == -1)
        {
          if (this.v != 0)
            break label3980;
          this.u = this.z;
          if (this.u <= this.t)
            break label4065;
          this.a.a(i3);
          if (this.x[(-1 + this.z)] == 32)
          {
            this.z = (-1 + this.z);
            this.u = this.z;
          }
          this.w = a(4, this.x, this.t, this.u);
          localay = this.w;
          break;
        }
        if ((this.m) && (paramShort != 0))
          b(32);
        if ((this.m) && (!do.a(paramShort & 0x0)))
        {
          this.k = true;
          this.m = false;
        }
        if (i3 != 13)
          break label4098;
        int i28 = this.a.c();
        if (i28 != 10)
          this.a.a(i28);
        i4 = 10;
        b(i4);
        switch (this.v)
        {
        case 7:
        default:
          break;
        case 0:
          if ((do.c((char)i4)) && (paramShort == 0) && (this.z == 1 + this.t))
          {
            this.z = (-1 + this.z);
            this.k = false;
            this.i = this.a.b();
            this.j = this.a.a();
            continue;
          }
          if (i4 == 60)
          {
            this.v = 1;
            continue;
          }
          if (do.c((char)i4))
          {
            if (this.k)
            {
              if ((paramShort == 2) || (paramShort == 3))
                continue;
              this.z = (-1 + this.z);
              this.i = this.a.b();
              this.j = this.a.a();
              continue;
            }
            this.k = true;
            if ((paramShort == 2) || (paramShort == 3) || (i4 == 32))
              continue;
            a(32);
            continue;
          }
          if ((i4 == 38) && (paramShort != 3))
            a(paramShort);
          if (paramShort == 0)
            paramShort = 1;
          this.k = false;
          break;
        case 1:
          if (i4 == 47)
          {
            int i27 = this.a.c();
            if (i27 == -1)
            {
              this.a.a(i27);
              continue;
            }
            b(i27);
            if (do.e((char)i27))
            {
              this.z = (-3 + this.z);
              this.u = this.z;
              this.a.a(i27);
              this.v = 2;
              this.x[this.z] = 0;
              this.j = (-2 + this.j);
              if (this.u <= this.t)
                continue;
              if ((paramShort == 0) && (this.x[(-1 + this.z)] == 32))
              {
                this.z = (-1 + this.z);
                this.u = this.z;
              }
              this.w = a(4, this.x, this.t, this.u);
              localay = this.w;
              break label51;
            }
            this.k = false;
            this.v = 0;
            continue;
          }
          if (paramShort == 3)
          {
            this.k = false;
            this.v = 0;
            continue;
          }
          if (i4 == 33)
          {
            int i23 = this.a.c();
            int i26;
            if (i23 == 45)
            {
              if (this.a.c() == 45)
              {
                this.v = 4;
                this.z = (-2 + this.z);
                this.u = this.z;
                if (this.u > this.t)
                {
                  this.w = a(4, this.x, this.t, this.u);
                  localay = this.w;
                  break label51;
                }
                this.t = this.z;
                continue;
              }
              this.I.a(this, null, null, 29);
              i26 = this.a.c();
              if (i26 != 62)
                break label1312;
            }
            while (true)
            {
              this.z = (-2 + this.z);
              this.x[this.z] = 0;
              this.v = 0;
              break label132;
              if ((i23 == 100) || (i23 == 68))
              {
                this.v = 5;
                this.z = (-2 + this.z);
                this.u = this.z;
                paramShort = 0;
                label1069: int i24 = this.a.c();
                if ((i24 == -1) || (i24 == 62))
                  this.a.a(i24);
                while (true)
                {
                  if (this.u <= this.t)
                    break label1217;
                  this.w = a(4, this.x, this.t, this.u);
                  localay = this.w;
                  break;
                  if (!do.c((char)i24))
                    break label1069;
                  int i25;
                  do
                  {
                    i25 = this.a.c();
                    if ((i25 != -1) && (i25 != 62))
                      continue;
                    this.a.a(i25);
                    break;
                  }
                  while (do.c((char)i25));
                  this.a.a(i25);
                }
                label1217: this.t = this.z;
                break label132;
              }
              if (i23 != 91)
                break label982;
              this.z = (-2 + this.z);
              this.v = 9;
              this.u = this.z;
              if (this.u > this.t)
              {
                this.w = a(4, this.x, this.t, this.u);
                localay = this.w;
                break;
              }
              this.t = this.z;
              break label132;
              label1312: if (i26 != -1)
                break label982;
              this.a.a(i26);
            }
          }
          if (i4 == 63)
          {
            this.z = (-2 + this.z);
            this.v = 6;
            this.u = this.z;
            if (this.u > this.t)
            {
              this.w = a(4, this.x, this.t, this.u);
              localay = this.w;
              break label51;
            }
            this.t = this.z;
            continue;
          }
          if (i4 == 37)
          {
            this.z = (-2 + this.z);
            this.v = 10;
            this.u = this.z;
            if (this.u > this.t)
            {
              this.w = a(4, this.x, this.t, this.u);
              localay = this.w;
              break label51;
            }
            this.t = this.z;
            continue;
          }
          if (i4 == 35)
          {
            this.z = (-2 + this.z);
            this.v = 11;
            this.u = this.z;
            if (this.u > this.t)
            {
              this.w = a(4, this.x, this.t, this.u);
              localay = this.w;
              break label51;
            }
            this.t = this.z;
            continue;
          }
          if (do.e((char)i4))
          {
            this.a.a(i4);
            this.z = (-2 + this.z);
            this.u = this.z;
            this.v = 3;
            if (this.u <= this.t)
              continue;
            this.w = a(4, this.x, this.t, this.u);
            localay = this.w;
            break label51;
          }
          this.v = 0;
          this.k = false;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 10:
        case 11:
        case 12:
        case 13:
        case 9:
        case 8:
        }
      }
      this.t = (-1 + this.z);
      this.j = (-2 + this.j);
      int i20 = d();
      this.w = a(6, this.x, this.t, this.u, do.a(this.x, this.t, this.u - this.t));
      this.z = this.t;
      this.u = this.t;
      int i22;
      for (int i21 = i20; ; i22 = this.a.c())
      {
        if (do.c(i21))
          continue;
        if (i21 != -1)
          break label1831;
        this.a.a(i21);
        this.I.a(this, this.w, null, 52);
        break;
      }
      label1831: if (i22 != 62)
      {
        this.a.a(i22);
        this.I.a(this, this.w, null, 52);
      }
      this.v = 0;
      this.k = false;
      localay = this.w;
      continue;
      this.t = (-1 + this.z);
      int i17 = d();
      arrayOfBoolean[0] = false;
      if (arrayOfBoolean[0] != 0)
      {
        s1 = 7;
        label1914: this.w = a(s1, this.x, this.t, this.u, do.a(this.x, this.t, this.u - this.t));
        if (i17 == 62)
          break label4105;
        if (i17 != 47)
          break;
        this.a.a(i17);
      }
    }
    label4098: label4105: for (b localb = a(arrayOfBoolean); ; localb = null)
    {
      if (arrayOfBoolean[0] != 0)
        this.w.h = 7;
      this.w.o = localb;
      this.z = this.t;
      this.u = this.t;
      int i18;
      if (((paramShort != 2) || (p(this.w))) && ((this.w.i()) || (this.w.m == this.F.ap.D)))
      {
        i18 = this.a.c();
        if (i18 == 13)
        {
          int i19 = this.a.c();
          if (i19 != 10)
            this.a.a(i19);
          label2121: this.k = true;
          label2126: this.v = 0;
          if (this.w.m != null)
            break label2207;
          this.I.b(this, null, this.w, 22);
        }
      }
      label2207: 
      do
      {
        localay = this.w;
        break;
        s1 = 5;
        break label1914;
        if ((i18 == 10) || (i18 == 12))
          break label2121;
        this.a.a(i18);
        break label2121;
        this.k = false;
        break label2126;
      }
      while (this.F.o);
      c(this.w.m.b);
      if (do.a(0x1C0 & this.w.m.b))
      {
        if ((this.F.v) && (this.w.m != this.F.ap.S) && (this.w.m != this.F.ap.T))
          this.I.a(this, null, this.w, 21);
      }
      else
      {
        label2316: if (this.w.m.a() == null)
          break label2388;
        this.w.m.a().a(this, this.w);
      }
      while (true)
      {
        this.w.b(this);
        break;
        if (this.F.v)
          break label2316;
        this.I.a(this, null, this.w, 21);
        break label2316;
        label2388: this.w.a(this);
      }
      if (i4 != 45)
        break label132;
      int i13 = this.a.c();
      b(i13);
      if (i13 != 45)
        break label132;
      while (true)
      {
        int i14 = this.a.c();
        if (i14 == 62)
        {
          if (i2 != 0)
            this.I.a(this, null, null, 29);
          this.u = (-2 + this.z);
          this.x[this.z] = 0;
          this.v = 0;
          this.k = false;
          this.w = a(2, this.x, this.t, this.u);
          int i16 = this.a.c();
          if (i16 == 13)
          {
            i16 = this.a.c();
            if (i16 != 10)
              this.w.k = true;
          }
          if (i16 == 10)
            this.w.k = true;
          while (true)
          {
            localay = this.w;
            break;
            this.a.a(i16);
          }
        }
        if (i2 == 0)
        {
          this.i = this.a.b();
          this.j = (-3 + this.a.a());
        }
        int i15 = i2 + 1;
        if (this.F.B)
          this.x[(-2 + this.z)] = 61;
        b(i14);
        if (i14 != 45)
        {
          this.x[(-2 + this.z)] = 61;
          i2 = i15;
          break label132;
          label2729: int i12;
          if (do.c((char)i4))
          {
            if (this.k)
              this.z = (-1 + this.z);
            this.k = true;
            if (i1 == 0)
              break label2771;
            if (i4 != 93)
              break label4084;
            i12 = 0;
          }
          while (true)
          {
            if (i12 == 0)
            {
              if (i4 != 62)
              {
                i1 = i12;
                break label132;
                this.k = false;
                break label2729;
                label2771: if (i4 == 91)
                {
                  i12 = 1;
                  continue;
                }
              }
              else
              {
                this.z = (-1 + this.z);
                this.u = this.z;
                this.x[this.z] = 0;
                this.v = 0;
                this.k = false;
                this.w = a(1, this.x, this.t, this.u);
                this.r = d(this.w);
                localay = this.w;
                break;
                if ((this.z - this.t == 3) && (do.a(this.x, this.t, 3).equals("php")))
                {
                  this.v = 12;
                  break label132;
                }
                if ((this.z - this.t == 4) && (do.a(this.x, this.t, 3).equals("xml")) && (do.c((char)this.x[(3 + this.t)])))
                {
                  this.v = 13;
                  localObject1 = null;
                  break label132;
                }
                if (this.F.R)
                {
                  if (i4 != 63)
                    break label132;
                  i4 = this.a.c();
                  if (i4 == -1)
                  {
                    this.I.a(this, null, null, 36);
                    this.a.a(i4);
                    break label132;
                  }
                  b(i4);
                }
                if (i4 != 62)
                  break label132;
                this.z = (-1 + this.z);
                this.u = this.z;
                this.x[this.z] = 0;
                this.v = 0;
                this.k = false;
                this.w = a(3, this.x, this.t, this.u);
                localay = this.w;
                break;
                if (i4 != 37)
                  break label132;
                int i11 = this.a.c();
                if (i11 != 62)
                {
                  this.a.a(i11);
                  break label132;
                }
                this.z = (-1 + this.z);
                this.u = this.z;
                this.x[this.z] = 0;
                this.v = 0;
                this.k = false;
                this.w = a(10, this.x, this.t, this.u);
                localay = this.w;
                break;
                if (i4 != 35)
                  break label132;
                int i10 = this.a.c();
                if (i10 != 62)
                {
                  this.a.a(i10);
                  break label132;
                }
                this.z = (-1 + this.z);
                this.u = this.z;
                this.x[this.z] = 0;
                this.v = 0;
                this.k = false;
                this.w = a(11, this.x, this.t, this.u);
                localay = this.w;
                break;
                if (i4 != 63)
                  break label132;
                int i9 = this.a.c();
                if (i9 != 62)
                {
                  this.a.a(i9);
                  break label132;
                }
                this.z = (-1 + this.z);
                this.u = this.z;
                this.x[this.z] = 0;
                this.v = 0;
                this.k = false;
                this.w = a(12, this.x, this.t, this.u);
                localay = this.w;
                break;
                if ((do.c((char)i4)) && (i4 != 63))
                  break label132;
                Object localObject2;
                if (i4 != 63)
                {
                  ay[] arrayOfay1 = new ay[1];
                  ay[] arrayOfay2 = new ay[1];
                  localObject2 = new b();
                  int[] arrayOfInt = new int[1];
                  arrayOfBoolean[0] = false;
                  this.a.a(i4);
                  String str = a(arrayOfBoolean, arrayOfay1, arrayOfay2);
                  ((b)localObject2).f = str;
                  ((b)localObject2).g = a(str, true, arrayOfBoolean, arrayOfInt);
                  ((b)localObject2).e = arrayOfInt[0];
                  ((b)localObject2).a = localObject1;
                }
                while (true)
                {
                  int i8 = this.a.c();
                  if (i8 != 62)
                  {
                    this.a.a(i8);
                    localObject1 = localObject2;
                    break label132;
                  }
                  this.z = (-1 + this.z);
                  this.u = this.t;
                  this.x[this.u] = 0;
                  this.v = 0;
                  this.k = false;
                  this.w = a(13, this.x, this.t, this.u);
                  this.w.o = ((b)localObject2);
                  localay = this.w;
                  break;
                  if ((i4 == 91) && (this.z == 6 + this.t) && (do.a(this.x, this.t, 6).equals("CDATA[")))
                  {
                    this.v = 8;
                    this.z = (-6 + this.z);
                    break label132;
                  }
                  if (i4 != 93)
                    break label132;
                  int i7 = this.a.c();
                  if (i7 != 62)
                  {
                    this.a.a(i7);
                    break label132;
                  }
                  this.z = (-1 + this.z);
                  this.u = this.z;
                  this.x[this.z] = 0;
                  this.v = 0;
                  this.k = false;
                  this.w = a(9, this.x, this.t, this.u);
                  localay = this.w;
                  break;
                  if (i4 != 93)
                    break label132;
                  int i5 = this.a.c();
                  if (i5 != 93)
                  {
                    this.a.a(i5);
                    break label132;
                  }
                  int i6 = this.a.c();
                  if (i6 != 62)
                  {
                    this.a.a(i6);
                    break label132;
                  }
                  this.z = (-1 + this.z);
                  this.u = this.z;
                  this.x[this.z] = 0;
                  this.v = 0;
                  this.k = false;
                  this.w = a(8, this.x, this.t, this.u);
                  localay = this.w;
                  break;
                  label3980: if (this.v == 4)
                  {
                    if (i3 == -1)
                      this.I.a(this, null, null, 29);
                    this.u = this.z;
                    this.x[this.z] = 0;
                    this.v = 0;
                    this.k = false;
                    this.w = a(2, this.x, this.t, this.u);
                    localay = this.w;
                    break;
                  }
                  label4065: localay = null;
                  break;
                  localObject2 = localObject1;
                }
              }
            }
            else
            {
              i1 = i12;
              break label132;
            }
            label4084: i12 = i1;
          }
        }
        i2 = i15;
      }
      i4 = i3;
      break label336;
    }
  }

  public void b(int paramInt)
  {
    if (((this.F.p) || (this.F.q)) && ((paramInt < 32) || (paramInt > 55295)) && (paramInt != 9) && (paramInt != 10) && (paramInt != 13) && ((paramInt < 57344) || (paramInt > 65533)) && ((paramInt < 65536) || (paramInt > 1114111)));
    while (true)
    {
      return;
      int[] arrayOfInt = new int[1];
      byte[] arrayOfByte = new byte[10];
      if (aq.a(paramInt, arrayOfByte, null, arrayOfInt))
      {
        arrayOfByte[0] = -17;
        arrayOfByte[1] = -65;
        arrayOfByte[2] = -67;
        arrayOfInt[0] = 3;
      }
      for (int i1 = 0; i1 < arrayOfInt[0]; i1++)
        a(arrayOfByte[i1]);
    }
  }

  public boolean b(ay paramay)
  {
    int i1 = 0;
    ay localay1 = paramay.c(this.F.ap);
    String str;
    if (localay1 != null)
      str = "HTML Tidy for Java (vers. " + cn.a + "), see jtidy.sourceforge.net";
    for (ay localay2 = localay1.p; ; localay2 = localay2.c)
    {
      if (localay2 == null)
      {
        ay localay3 = b("meta");
        localay3.a("content", str);
        localay3.a("name", "generator");
        localay1.b(localay3);
        i1 = 1;
      }
      while (true)
      {
        return i1;
        if (localay2.m != this.F.ap.i)
          break;
        b localb1 = localay2.a("name");
        if ((localb1 == null) || (localb1.g == null) || (!"generator".equalsIgnoreCase(localb1.g)))
          break;
        b localb2 = localay2.a("content");
        if ((localb2 == null) || (localb2.g == null) || (localb2.g.length() < 9) || (!"HTML Tidy".equalsIgnoreCase(localb2.g.substring(0, 9))))
          break;
        localb2.g = str;
      }
    }
  }

  void c(int paramInt)
  {
    this.q &= (paramInt | 0x1C0);
  }

  public boolean c()
  {
    return this.a.d();
  }

  public boolean c(ay paramay)
  {
    int i1 = paramay.f - paramay.e;
    String str = do.a(this.x, paramay.e, i1);
    if ((do.a("SYSTEM", str, str.length())) || (do.a("PUBLIC", str, str.length())) || (do.a("//DTD", str, str.length())) || (do.a("//W3C", str, str.length())) || (do.a("//EN", str, str.length())));
    for (int i2 = 0; ; i2 = 1)
      return i2;
  }

  public char d()
  {
    int i1 = this.x[this.t];
    if ((!this.F.o) && (do.h((char)i1)))
    {
      int i3 = do.i((char)i1);
      this.x[this.t] = (byte)i3;
    }
    while (true)
    {
      int i2 = this.a.c();
      if (i2 == -1);
      do
      {
        this.u = this.z;
        return (char)i2;
      }
      while (!do.f((char)i2));
      if ((!this.F.o) && (do.h((char)i2)))
        i2 = do.i((char)i2);
      b(i2);
    }
  }

  public short d(ay paramay)
  {
    if (!"html ".equalsIgnoreCase(do.a(this.x, paramay.e, 5)));
    String str1;
    for (int i4 = 0; ; i4 = 0)
    {
      return i4;
      if (!c(paramay))
        this.I.a(this, paramay, null, 37);
      str1 = do.a(this.x, 5 + paramay.e, 7);
      if (!"SYSTEM ".equalsIgnoreCase(str1))
        break;
      if (str1.substring(0, 6).equals("SYSTEM"))
        continue;
      System.arraycopy(do.a("SYSTEM"), 0, this.x, 5 + paramay.e, 6);
    }
    if ("PUBLIC ".equalsIgnoreCase(str1))
      if (!str1.substring(0, 6).equals("PUBLIC"))
        System.arraycopy(do.a("PUBLIC "), 0, this.x, 5 + paramay.e, 6);
    label165: label178: label476: for (int i1 = paramay.e; ; i1++)
    {
      if (i1 >= paramay.f);
      String str3;
      label248: 
      do
        while (true)
        {
          i4 = 0;
          break;
          this.s = true;
          break label165;
          if (this.x[i1] != 34)
            break label476;
          String str2 = do.a(this.x, i1 + 1, 12);
          str3 = do.a(this.x, i1 + 1, 13);
          if (!str2.equals("-//W3C//DTD "))
            break label365;
          int i5 = i1 + 13;
          int i6;
          String str6;
          int i7;
          if ((i5 >= paramay.f) || (this.x[i5] == 47))
          {
            i6 = -13 + (i5 - i1);
            str6 = do.a(this.x, i1 + 13, i6);
            i7 = 1;
          }
          while (true)
          {
            if (i7 >= K.length)
              break label363;
            String str7 = K[i7].a;
            if ((i6 == str7.length()) && (str7.equals(str6)))
            {
              i4 = K[i7].d;
              break;
              i5++;
              break label248;
            }
            i7 += 1;
          }
        }
      while (!str3.equals("-//IETF//DTD "));
      label363: label365: for (int i2 = i1 + 14; ; i2++)
      {
        if ((i2 < paramay.f) && (this.x[i2] != 47))
          continue;
        int i3 = -14 + (i2 - i1);
        String str4 = do.a(this.x, i1 + 14, i3);
        String str5 = K[0].a;
        if ((i3 != str5.length()) || (!str5.equals(str4)))
          break label178;
        i4 = K[0].d;
        break;
      }
    }
  }

  ay e(ay paramay)
  {
    Object localObject = null;
    ay localay1 = paramay.b(this.F.ap);
    if (localay1 == null)
      return localObject;
    ay localay2 = a();
    localay2.a(1);
    localay2.c = localay1;
    localay2.a = paramay;
    localay2.b = null;
    if (localay1 == paramay.p)
    {
      paramay.p.b = localay2;
      paramay.p = localay2;
      localay2.b = null;
    }
    while (true)
    {
      localay1.b = localay2;
      localObject = localay2;
      break;
      localay2.b = localay1.b;
      localay2.b.c = localay2;
    }
  }

  public short e()
  {
    int i1;
    if (do.a(0x1 & this.q))
      i1 = 1;
    while (true)
    {
      return i1;
      if ((!(this.F.p | this.F.o | this.p)) && (do.a(0x2 & this.q)))
      {
        i1 = 2;
        continue;
      }
      if (do.a(0x400 & this.q))
      {
        i1 = 1024;
        continue;
      }
      if (do.a(0x4 & this.q))
      {
        i1 = 4;
        continue;
      }
      if (do.a(0x8 & this.q))
      {
        i1 = 8;
        continue;
      }
      if (do.a(0x10 & this.q))
      {
        i1 = 16;
        continue;
      }
      i1 = 0;
    }
  }

  public String f()
  {
    int i1 = g();
    for (int i2 = 0; ; i2++)
    {
      String str;
      if (i2 >= K.length)
        str = null;
      while (true)
      {
        return str;
        if (i1 != K[i2].d)
          break;
        if (this.p)
        {
          str = K[i2].b;
          continue;
        }
        str = K[i2].a;
      }
    }
  }

  public boolean f(ay paramay)
  {
    String str1 = null;
    int i1 = 0;
    String str2 = " ";
    String str3 = "";
    ay localay1 = paramay.a();
    a(paramay, "http://www.w3.org/1999/xhtml");
    if (this.F.d == 0)
    {
      if (localay1 != null)
        ay.a(localay1);
      i1 = 1;
      return i1;
    }
    if (this.F.d == 1)
      if (do.a(0x4 & this.q))
      {
        str2 = "-//W3C//DTD XHTML 1.0 Strict//EN";
        str3 = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd";
      }
    while (true)
    {
      label85: String str7;
      String str4;
      if ((this.F.d == 4) && (this.F.g != null))
      {
        str7 = this.F.g;
        str4 = "";
      }
      for (String str5 = str7; ; str5 = str2)
      {
        if (str5 == null)
          break label628;
        int i2;
        Object localObject;
        if (localay1 != null)
        {
          if ((!this.F.q) && (!this.F.p))
            break label609;
          int i4 = 1 + (localay1.f - localay1.e);
          String str6 = do.a(this.x, localay1.e, i4);
          int i5 = str6.indexOf('[');
          if (i5 < 0)
            break label609;
          int i6 = str6.substring(i5).indexOf(']');
          if (i6 < 0)
            break label609;
          i2 = i6 + 1;
          str1 = str6.substring(i5);
          localObject = localay1;
        }
        while (true)
        {
          label236: this.t = this.z;
          this.u = this.z;
          a("html PUBLIC ");
          if (str5.charAt(0) == '"')
          {
            a(str5);
            label276: if ((this.F.b == 0) || (6 + str4.length() < this.F.b))
              break label599;
            a("\n\"");
          }
          while (true)
          {
            a(str4);
            a("\"");
            if ((i2 > 0) && (str1 != null))
            {
              b(32);
              a(str1, i2);
            }
            this.u = this.z;
            int i3 = this.u - this.t;
            ((ay)localObject).g = new byte[i3];
            System.arraycopy(this.x, this.t, ((ay)localObject).g, 0, i3);
            ((ay)localObject).e = 0;
            ((ay)localObject).f = i3;
            break;
            if (do.a(0x10 & this.q))
            {
              str2 = "-//W3C//DTD XHTML 1.0 Frameset//EN";
              str3 = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd";
              break label85;
            }
            if (do.a(0x1A & this.q))
            {
              str2 = "-//W3C//DTD XHTML 1.0 Transitional//EN";
              str3 = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd";
              break label85;
            }
            if (do.a(0x400 & this.q))
            {
              str2 = "-//W3C//DTD XHTML 1.1//EN";
              str3 = "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd";
              break label85;
            }
            str3 = "";
            if (localay1 == null)
              break label630;
            ay.a(localay1);
            str2 = null;
            break label85;
            if (this.F.d == 2)
            {
              str2 = "-//W3C//DTD XHTML 1.0 Strict//EN";
              str3 = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd";
              break label85;
            }
            if (this.F.d != 3)
              break label85;
            str2 = "-//W3C//DTD XHTML 1.0 Transitional//EN";
            str3 = "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd";
            break label85;
            ay localay2 = e(paramay);
            if (localay2 == null)
              break;
            localObject = localay2;
            i2 = 0;
            break label236;
            a("\"");
            a(str5);
            a("\"");
            break label276;
            label599: a(" \"");
          }
          label609: i2 = 0;
          localObject = localay1;
        }
        str4 = str3;
      }
      label628: break;
      label630: str2 = null;
    }
  }

  public short g()
  {
    int i1 = 1;
    switch (this.r)
    {
    default:
      this.i = i1;
      this.j = i1;
      this.I.a(this, null, null, 28);
      i1 = e();
    case 0:
    case 1:
    case 2:
    case 4:
    case 8:
    case 16:
    case 1024:
    }
    while (true)
    {
      return i1;
      i1 = e();
      continue;
      if (!do.a(0x1 & this.q))
        break;
      continue;
      if (!do.a(0x2 & this.q))
        break;
      i1 = 2;
      continue;
      if (!do.a(0x4 & this.q))
        break;
      i1 = 4;
      continue;
      if (!do.a(0x8 & this.q))
        break;
      i1 = 8;
      continue;
      if (!do.a(0x10 & this.q))
        break;
      i1 = 16;
      continue;
      if (!do.a(0x400 & this.q))
        break;
      i1 = 1024;
    }
  }

  public boolean g(ay paramay)
  {
    int i1 = 0;
    if (this.s)
      this.I.a(this, null, null, 35);
    ay localay1 = paramay.a();
    if (this.F.d == 0)
    {
      if (localay1 != null)
        ay.a(localay1);
      i1 = 1;
    }
    label641: label647: label654: 
    while (true)
    {
      return i1;
      if (this.F.p)
      {
        i1 = 1;
        continue;
      }
      ay localay2;
      int i2;
      if (this.F.d == 2)
      {
        ay.a(localay1);
        localay2 = null;
        i2 = 4;
      }
      while (true)
      {
        label86: if (i2 == 0)
          break label654;
        if ((this.F.p) || (this.F.o) || (this.p))
        {
          if (localay2 != null)
            ay.a(localay2);
          a(paramay, "http://www.w3.org/1999/xhtml");
        }
        if (localay2 == null)
        {
          localay2 = e(paramay);
          if (localay2 == null)
            break;
        }
        this.t = this.z;
        this.u = this.z;
        a("html PUBLIC ");
        if ((this.F.d == 4) && (this.F.g != null) && (this.F.g.length() > 0))
          if (this.F.g.charAt(0) == '"')
            a(this.F.g);
        while (true)
        {
          this.u = this.z;
          int i4 = this.u - this.t;
          localay2.g = new byte[i4];
          System.arraycopy(this.x, this.t, localay2.g, 0, i4);
          localay2.e = 0;
          localay2.f = i4;
          i1 = 1;
          break;
          if (this.F.d == 3)
          {
            ay.a(localay1);
            localay2 = null;
            i2 = 8;
            break label86;
          }
          if (this.F.d != 1)
            break label647;
          if (localay1 != null)
          {
            if (this.r == 0)
              break;
            switch (this.r)
            {
            case 0:
            default:
            case 1:
            case 2:
            case 4:
            case 8:
            case 16:
            case 1024:
            }
          }
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      i2 = e();
                      localay2 = localay1;
                      break;
                    }
                    while (!do.a(0x1 & this.q));
                    i1 = 1;
                    break;
                  }
                  while (!do.a(0x2 & this.q));
                  i1 = 1;
                  break;
                }
                while (!do.a(0x4 & this.q));
                i1 = 1;
                break;
              }
              while (!do.a(0x8 & this.q));
              i1 = 1;
              break;
            }
            while (!do.a(0x10 & this.q));
            i1 = 1;
            break;
          }
          while (!do.a(0x400 & this.q));
          i1 = 1;
          break;
          a("\"");
          a(this.F.g);
          a("\"");
          continue;
          if (i2 != 1)
            break label582;
          a("\"-//IETF//DTD HTML 2.0//EN\"");
        }
        label582: a("\"-//W3C//DTD ");
        for (int i3 = 0; ; i3++)
        {
          if (i3 >= K.length);
          while (true)
          {
            a("//EN\"");
            break;
            if (i2 != K[i3].d)
              break label641;
            a(K[i3].a);
          }
        }
        i2 = 4;
        localay2 = localay1;
      }
    }
  }

  public void h()
  {
    this.l = true;
  }

  public boolean h(ay paramay)
  {
    ay localay;
    if ((paramay.p != null) && (paramay.p.h == 13))
      localay = paramay.p;
    while (true)
    {
      b localb = localay.a("version");
      if ((localay.a("encoding") == null) && (!"UTF8".equals(this.F.c())))
      {
        if ("ISO8859_1".equals(this.F.c()))
          localay.a("encoding", "iso-8859-1");
        if ("ISO2022".equals(this.F.c()))
          localay.a("encoding", "iso-2022");
      }
      if (localb == null)
        localay.a("version", "1.0");
      return true;
      localay = a(13, this.x, 0, 0);
      localay.c = paramay.p;
      if (paramay.p != null)
      {
        paramay.p.b = localay;
        localay.c = paramay.p;
      }
      paramay.p = localay;
    }
  }

  public ay i()
  {
    ay localay = null;
    this.t = this.z;
    int i1 = this.a.c();
    if (i1 == -1);
    while (true)
    {
      this.z = (-2 + this.z);
      this.u = this.z;
      if (this.u > this.t)
        localay = a(10, this.x, this.t, this.u);
      this.t = this.u;
      return localay;
      b(i1);
      if (i1 != 37)
        break;
      int i2 = this.a.c();
      if (i2 == -1)
        continue;
      b(i2);
      if (i2 != 62)
        break;
    }
  }

  public ay i(ay paramay)
  {
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    if (paramay.a("src") != null)
    {
      i1 = 1;
      this.i = this.a.b();
      this.j = this.a.a();
      this.k = false;
      this.t = this.z;
      this.u = this.z;
      i2 = 1;
      i3 = 0;
      i4 = 0;
      i5 = 0;
    }
    label70: int i6;
    label110: 
    do
    {
      while (true)
      {
        i6 = this.a.c();
        if (i6 == -1)
        {
          if (i2 == 0)
            break label902;
          int i10 = this.u;
          this.t = i10;
          this.z = i10;
          if (i6 == -1)
            this.I.b(this, paramay, null, 6);
        }
        int i13;
        for (ay localay = a(4, this.x, this.t, this.u); ; localay = null)
        {
          return localay;
          i1 = 0;
          break;
          b(i6);
          this.u = this.z;
          if (i3 != 0)
            break label494;
          if (i6 != 60)
          {
            if ((i2 == 0) || (do.c((char)i6)))
              break label70;
            i2 = 0;
            break label70;
          }
          i13 = this.a.c();
          if (!do.e((char)i13))
            break label302;
          if ((i1 == 0) || (i2 == 0) || (paramay.m != this.F.ap.Z))
            break label281;
          this.z = this.t;
          this.a.a(i13);
          this.a.a(60);
        }
        b(i13);
        i5 = -1 + this.z;
        i3 = 1;
        continue;
        if (i13 == 47)
        {
          b(i13);
          int i16 = this.a.c();
          if (!do.e((char)i16))
          {
            this.a.a(i16);
            continue;
          }
          this.a.a(i16);
          i5 = this.z;
          i3 = 2;
          continue;
        }
        if (i13 == 92)
        {
          b(i13);
          int i14 = this.a.c();
          if (i14 != 47)
          {
            this.a.a(i14);
            continue;
          }
          b(i14);
          int i15 = this.a.c();
          if (!do.e((char)i15))
          {
            this.a.a(i15);
            continue;
          }
          this.a.a(i15);
          i5 = this.z;
          i3 = 2;
          continue;
        }
        this.a.a(i13);
      }
      if (i3 != 1)
        break label551;
    }
    while (do.e((char)i6));
    label281: label302: label494: if (paramay.n.equalsIgnoreCase(do.a(this.x, i5, paramay.n.length())));
    for (int i12 = i4 + 1; ; i12 = i4)
    {
      i4 = i12;
      i3 = 0;
      break;
      label551: if ((i3 != 2) || (do.e((char)i6)))
        break;
      boolean bool = paramay.n.equalsIgnoreCase(do.a(this.x, i5, paramay.n.length()));
      if ((i2 != 0) && (!bool))
        for (int i11 = -1 + this.z; ; i11--)
        {
          if (i11 < i5)
          {
            this.a.a(47);
            this.a.a(60);
            break;
          }
          this.a.a(this.x[i11]);
        }
      int i7;
      if (bool)
      {
        i7 = i4 - 1;
        if (i4 <= 0)
          for (int i9 = -1 + this.z; ; i9--)
          {
            if (i9 < i5)
            {
              this.a.a(47);
              this.a.a(60);
              this.z -= 2 + (this.z - i5);
              break;
            }
            this.a.a(this.x[i9]);
          }
      }
      else
      {
        i7 = i4;
      }
      if (this.x[(i5 - 2)] != 92)
      {
        this.i = this.a.b();
        this.j = this.a.a();
        this.j = (-3 + this.j);
        this.I.b(this, null, null, 32);
        if (!paramay.h());
      }
      for (int i8 = this.z; ; i8--)
      {
        if (i8 <= i5 - 1)
        {
          this.x[(i5 - 1)] = 92;
          this.z = (1 + this.z);
          i4 = i7;
          i3 = 0;
          break;
        }
        this.x[i8] = this.x[(i8 - 1)];
      }
      label902: this.u = this.z;
      break label110;
    }
  }

  public ay j()
  {
    ay localay = null;
    this.t = this.z;
    int i1 = this.a.c();
    if (i1 == -1);
    while (true)
    {
      this.z = (-2 + this.z);
      this.u = this.z;
      if (this.u > this.t)
        localay = a(12, this.x, this.t, this.u);
      this.t = this.u;
      return localay;
      b(i1);
      if (i1 != 63)
        break;
      int i2 = this.a.c();
      if (i2 == -1)
        continue;
      b(i2);
      if (i2 != 62)
        break;
    }
  }

  public void j(ay paramay)
  {
    if (paramay.j);
    while (true)
    {
      return;
      if ((paramay.m != null) && (do.a(0x10 & paramay.m.c)) && (!do.a(0x800 & paramay.m.c)) && ((paramay.m == this.F.ap.U) || (!l(paramay))))
      {
        av localav = new av();
        localav.a = paramay.m;
        localav.b = paramay.n;
        if (paramay.o != null)
          localav.c = a(paramay.o);
        this.C.push(localav);
        continue;
      }
    }
  }

  public int k()
  {
    int i1 = 0;
    int i2 = this.a.c();
    b(i2);
    int i3;
    int i4;
    if ((i2 == 37) || (i2 == 63) || (i2 == 64))
    {
      i3 = 1;
      i4 = 34;
    }
    while (true)
    {
      int i5 = this.a.c();
      if (i5 == -1);
      do
        while (true)
        {
          i1 = i4;
          return i1;
          if (i5 != 62)
            break;
          if (i3 != 0)
          {
            b(i5);
            continue;
          }
          this.a.a(i5);
        }
      while ((i3 == 0) && (do.c((char)i5)));
      b(i5);
      if (i5 == 34)
      {
        int i7;
        do
        {
          i7 = this.a.c();
          if (c())
          {
            this.I.a(this, this.w, null, 36);
            this.a.a(i7);
            break;
          }
          if (i7 == 62)
          {
            this.a.a(i7);
            this.I.a(this, this.w, null, 52);
            break;
          }
          b(i7);
        }
        while (i7 != 34);
        i4 = 39;
        continue;
      }
      if (i5 != 39)
        continue;
      int i6;
      do
      {
        i6 = this.a.c();
        if (c())
        {
          this.I.a(this, this.w, null, 36);
          this.a.a(i6);
          break;
        }
        if (i6 == 62)
        {
          this.a.a(i6);
          this.I.a(this, this.w, null, 52);
          break;
        }
        b(i6);
      }
      while (i6 != 39);
      continue;
      i3 = 0;
      i4 = 34;
    }
  }

  public void k(ay paramay)
  {
    if (paramay != null)
      if (paramay.m != null);
    while (true)
    {
      return;
      if ((do.a(0x10 & paramay.m.c)) && (!do.a(0x800 & paramay.m.c)))
      {
        if (paramay.m == this.F.ap.E)
        {
          label62: if (this.C.size() <= 0);
          while (true)
          {
            if (this.B < this.C.size())
              break label122;
            this.B = -1;
            break;
            if (((av)this.C.pop()).a != this.F.ap.E)
              break label62;
          }
          label122: continue;
        }
        if (this.C.size() <= 0)
          continue;
        ((av)this.C.pop());
        if (this.B < this.C.size())
          continue;
        this.B = -1;
        continue;
      }
    }
  }

  public ay l()
  {
    Object localObject;
    if (this.B == -1)
    {
      localObject = this.A;
      this.A = null;
      return localObject;
    }
    if (this.A == null)
    {
      this.i = this.a.b();
      this.j = this.a.a();
    }
    ay localay = a(5, this.x, this.t, this.u);
    localay.j = true;
    av localav = (av)this.C.elementAt(this.B);
    localay.n = localav.b;
    localay.m = localav.a;
    if (localav.c != null)
      localay.o = a(localav.c);
    int i1 = 1 + this.B;
    if (i1 < this.C.size());
    for (this.B = i1; ; this.B = -1)
    {
      localObject = localay;
      break;
    }
  }

  public boolean l(ay paramay)
  {
    for (int i1 = -1 + this.C.size(); ; i1--)
    {
      if (i1 < 0);
      for (int i2 = 0; ; i2 = 1)
      {
        return i2;
        if (((av)this.C.elementAt(i1)).a != paramay.m)
          break;
      }
    }
  }

  public int m(ay paramay)
  {
    int i1 = this.C.size() - this.D;
    if (i1 > 0)
    {
      this.B = this.D;
      this.A = paramay;
    }
    return i1;
  }

  public void m()
  {
    this.B = -1;
    this.A = null;
  }

  public boolean n(ay paramay)
  {
    int i1 = 1;
    if (paramay.h == 4);
    while (true)
    {
      return i1;
      if (paramay.p != null)
      {
        i1 = 0;
        continue;
      }
      if ((paramay.m == this.F.ap.E) && (paramay.o != null))
      {
        i1 = 0;
        continue;
      }
      if ((paramay.m == this.F.ap.q) && (!this.F.A))
      {
        i1 = 0;
        continue;
      }
      if (paramay.m == null)
      {
        i1 = 0;
        continue;
      }
      if (do.a(0x200 & paramay.m.c))
      {
        i1 = 0;
        continue;
      }
      if (do.a(0x1 & paramay.m.c))
      {
        i1 = 0;
        continue;
      }
      if (paramay.m == this.F.ap.ag)
      {
        i1 = 0;
        continue;
      }
      if (paramay.m == this.F.ap.ah)
      {
        i1 = 0;
        continue;
      }
      if ((paramay.m == this.F.ap.Z) && (paramay.a("src") != null))
      {
        i1 = 0;
        continue;
      }
      if (paramay.m == this.F.ap.j)
      {
        i1 = 0;
        continue;
      }
      if (paramay.m == this.F.ap.g)
      {
        i1 = 0;
        continue;
      }
      if ((paramay.a("id") == null) && (paramay.a("name") == null))
        continue;
      i1 = 0;
    }
  }

  public void o(ay paramay)
  {
    b localb1 = paramay.a("name");
    b localb2 = paramay.a("id");
    if (localb1 != null)
    {
      if (localb2 == null)
        break label58;
      if ((localb2.g != null) && (!localb2.g.equals(localb1.g)))
        this.I.a(this, paramay, localb1, 60);
    }
    while (true)
    {
      return;
      label58: if (this.F.p)
      {
        paramay.a("id", localb1.g);
        continue;
      }
    }
  }

  protected boolean p(ay paramay)
  {
    int i1 = 1;
    if (paramay.m == this.F.ap.q);
    while (true)
    {
      return i1;
      if ((paramay.m != null) && (paramay.m != this.F.ap.q) && (do.a(0x100010 & paramay.m.c)))
        continue;
      i1 = 0;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.aw
 * JD-Core Version:    0.6.0
 */