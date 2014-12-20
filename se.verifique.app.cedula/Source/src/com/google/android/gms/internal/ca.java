package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;

class ca
  implements by
{
  private IBinder a;

  ca(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public a a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      a locala = b.a(localParcel2.readStrongBinder());
      return locala;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public void a(a parama, ai paramai, String paramString, cb paramcb)
  {
    IBinder localIBinder1 = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      IBinder localIBinder2;
      if (parama != null)
      {
        localIBinder2 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        if (paramai == null)
          break label121;
        localParcel1.writeInt(1);
        paramai.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeString(paramString);
        if (paramcb != null)
          localIBinder1 = paramcb.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        this.a.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder2 = null;
        break;
        label121: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public void a(a parama, ai paramai, String paramString1, String paramString2, cb paramcb)
  {
    IBinder localIBinder1 = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      IBinder localIBinder2;
      if (parama != null)
      {
        localIBinder2 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        if (paramai == null)
          break label129;
        localParcel1.writeInt(1);
        paramai.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramcb != null)
          localIBinder1 = paramcb.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        this.a.transact(7, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder2 = null;
        break;
        label129: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public void a(a parama, al paramal, ai paramai, String paramString, cb paramcb)
  {
    IBinder localIBinder1 = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (parama == null)
          continue;
        IBinder localIBinder2 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        if (paramal == null)
          continue;
        localParcel1.writeInt(1);
        paramal.writeToParcel(localParcel1, 0);
        if (paramai != null)
        {
          localParcel1.writeInt(1);
          paramai.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString);
          if (paramcb == null)
            continue;
          localIBinder1 = paramcb.asBinder();
          localParcel1.writeStrongBinder(localIBinder1);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localIBinder2 = null;
          continue;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
    }
  }

  public void a(a parama, al paramal, ai paramai, String paramString1, String paramString2, cb paramcb)
  {
    IBinder localIBinder1 = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if (parama == null)
          continue;
        IBinder localIBinder2 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        if (paramal == null)
          continue;
        localParcel1.writeInt(1);
        paramal.writeToParcel(localParcel1, 0);
        if (paramai != null)
        {
          localParcel1.writeInt(1);
          paramai.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if (paramcb == null)
            continue;
          localIBinder1 = paramcb.asBinder();
          localParcel1.writeStrongBinder(localIBinder1);
          this.a.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localIBinder2 = null;
          continue;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
    }
  }

  public IBinder asBinder()
  {
    return this.a;
  }

  public void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public void c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public void d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public void e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      this.a.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ca
 * JD-Core Version:    0.6.0
 */