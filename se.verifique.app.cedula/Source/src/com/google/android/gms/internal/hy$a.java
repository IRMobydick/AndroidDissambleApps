package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;

public class hy$a
  implements SafeParcelable
{
  public static final le i = new le();
  protected final int a;
  protected final boolean b;
  protected final int c;
  protected final boolean d;
  protected final String e;
  protected final int f;
  protected final Class g;
  protected final String h;
  private final int j;
  private ib k;
  private ld l;

  hy$a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ht paramht)
  {
    this.j = paramInt1;
    this.a = paramInt2;
    this.b = paramBoolean1;
    this.c = paramInt3;
    this.d = paramBoolean2;
    this.e = paramString1;
    this.f = paramInt4;
    if (paramString2 == null)
    {
      this.g = null;
      this.h = null;
      if (paramht != null)
        break label84;
    }
    label84: for (this.l = null; ; this.l = paramht.c())
    {
      return;
      this.g = ie.class;
      this.h = paramString2;
      break;
    }
  }

  protected hy$a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class paramClass, ld paramld)
  {
    this.j = 1;
    this.a = paramInt1;
    this.b = paramBoolean1;
    this.c = paramInt2;
    this.d = paramBoolean2;
    this.e = paramString;
    this.f = paramInt3;
    this.g = paramClass;
    if (paramClass == null);
    for (this.h = null; ; this.h = paramClass.getCanonicalName())
    {
      this.l = paramld;
      return;
    }
  }

  public static a a(String paramString, int paramInt)
  {
    return new a(0, false, 0, false, paramString, paramInt, null, null);
  }

  public static a a(String paramString, int paramInt, ld paramld, boolean paramBoolean)
  {
    return new a(paramld.c(), paramBoolean, paramld.d(), false, paramString, paramInt, null, paramld);
  }

  public static a a(String paramString, int paramInt, Class paramClass)
  {
    return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
  }

  public static a b(String paramString, int paramInt)
  {
    return new a(4, false, 4, false, paramString, paramInt, null, null);
  }

  public static a b(String paramString, int paramInt, Class paramClass)
  {
    return new a(11, true, 11, true, paramString, paramInt, paramClass, null);
  }

  public static a c(String paramString, int paramInt)
  {
    return new a(6, false, 6, false, paramString, paramInt, null, null);
  }

  public static a d(String paramString, int paramInt)
  {
    return new a(7, false, 7, false, paramString, paramInt, null, null);
  }

  public static a e(String paramString, int paramInt)
  {
    return new a(7, true, 7, true, paramString, paramInt, null, null);
  }

  public int a()
  {
    return this.j;
  }

  public Object a(Object paramObject)
  {
    return this.l.a(paramObject);
  }

  public void a(ib paramib)
  {
    this.k = paramib;
  }

  public int b()
  {
    return this.a;
  }

  public boolean c()
  {
    return this.b;
  }

  public int d()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    return this.d;
  }

  public String f()
  {
    return this.e;
  }

  public int g()
  {
    return this.f;
  }

  public Class h()
  {
    return this.g;
  }

  String i()
  {
    if (this.h == null);
    for (String str = null; ; str = this.h)
      return str;
  }

  public boolean j()
  {
    if (this.l != null);
    for (int m = 1; ; m = 0)
      return m;
  }

  ht k()
  {
    if (this.l == null);
    for (ht localht = null; ; localht = ht.a(this.l))
      return localht;
  }

  public HashMap l()
  {
    kx.a(this.h);
    kx.a(this.k);
    return this.k.a(this.h);
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Field\n");
    localStringBuilder1.append("            versionCode=").append(this.j).append('\n');
    localStringBuilder1.append("                 typeIn=").append(this.a).append('\n');
    localStringBuilder1.append("            typeInArray=").append(this.b).append('\n');
    localStringBuilder1.append("                typeOut=").append(this.c).append('\n');
    localStringBuilder1.append("           typeOutArray=").append(this.d).append('\n');
    localStringBuilder1.append("        outputFieldName=").append(this.e).append('\n');
    localStringBuilder1.append("      safeParcelFieldId=").append(this.f).append('\n');
    localStringBuilder1.append("       concreteTypeName=").append(i()).append('\n');
    if (h() != null)
      localStringBuilder1.append("     concreteType.class=").append(h().getCanonicalName()).append('\n');
    StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
    if (this.l == null);
    for (String str = "null"; ; str = this.l.getClass().getCanonicalName())
    {
      localStringBuilder2.append(str).append('\n');
      return localStringBuilder1.toString();
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    le.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hy.a
 * JD-Core Version:    0.6.0
 */