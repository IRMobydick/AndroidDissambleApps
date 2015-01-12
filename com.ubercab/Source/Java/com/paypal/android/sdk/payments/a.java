package com.paypal.android.sdk.payments;

class a
{
  private static final String a = a.class.getSimpleName();
  private Z b;
  private Object c;
  private V d;

  private void b(V paramV)
  {
    paramV.a(this.c);
    this.c = null;
    b();
  }

  final void a()
  {
    if (this.d != null)
    {
      b(this.d);
      return;
    }
  }

  final void a(V paramV)
  {
    if (this.c != null)
    {
      b(paramV);
      return;
    }
    if (this.b != null)
    {
      paramV.a(this.b);
      this.b = null;
      b();
      return;
    }
    this.d = paramV;
  }

  final void a(Z paramZ)
  {
    if (this.d != null)
    {
      this.d.a(paramZ);
      return;
    }
    this.b = paramZ;
  }

  final void a(Object paramObject)
  {
    this.c = paramObject;
  }

  final void b()
  {
    this.d = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.a
 * JD-Core Version:    0.6.2
 */