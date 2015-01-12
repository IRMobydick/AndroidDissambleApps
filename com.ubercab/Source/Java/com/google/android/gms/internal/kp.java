package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.b;
import com.google.android.gms.fitness.request.e;
import com.google.android.gms.fitness.request.j;
import com.google.android.gms.fitness.request.m;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.fitness.request.q;
import com.google.android.gms.fitness.request.u;
import com.google.android.gms.fitness.request.w;
import com.google.android.gms.fitness.request.y;

public abstract interface kp extends IInterface
{
  public abstract void a(DataDeleteRequest paramDataDeleteRequest, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(DataReadRequest paramDataReadRequest, km paramkm, String paramString)
    throws RemoteException;

  public abstract void a(DataSourcesRequest paramDataSourcesRequest, kn paramkn, String paramString)
    throws RemoteException;

  public abstract void a(DataTypeCreateRequest paramDataTypeCreateRequest, ko paramko, String paramString)
    throws RemoteException;

  public abstract void a(SessionInsertRequest paramSessionInsertRequest, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(SessionReadRequest paramSessionReadRequest, kr paramkr, String paramString)
    throws RemoteException;

  public abstract void a(StartBleScanRequest paramStartBleScanRequest, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(aa paramaa, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(ad paramad, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(af paramaf, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(ah paramah, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(aj paramaj, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(b paramb, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(e parame, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(j paramj, ko paramko, String paramString)
    throws RemoteException;

  public abstract void a(m paramm, kq paramkq, String paramString)
    throws RemoteException;

  public abstract void a(o paramo, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(q paramq, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(u paramu, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(w paramw, kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(y paramy, ks paramks, String paramString)
    throws RemoteException;

  public abstract void a(kt paramkt, String paramString)
    throws RemoteException;

  public abstract void a(lf paramlf, String paramString)
    throws RemoteException;

  public abstract void b(kt paramkt, String paramString)
    throws RemoteException;

  public static abstract class a extends Binder
    implements kp
  {
    public static kp as(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
      if ((localIInterface != null) && ((localIInterface instanceof kp)))
        return (kp)localIInterface;
      return new a(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i16 = paramParcel1.readInt();
        DataSourcesRequest localDataSourcesRequest = null;
        if (i16 != 0)
          localDataSourcesRequest = (DataSourcesRequest)DataSourcesRequest.CREATOR.createFromParcel(paramParcel1);
        a(localDataSourcesRequest, kn.a.aq(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i15 = paramParcel1.readInt();
        o localo = null;
        if (i15 != 0)
          localo = (o)o.CREATOR.createFromParcel(paramParcel1);
        a(localo, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i14 = paramParcel1.readInt();
        q localq = null;
        if (i14 != 0)
          localq = (q)q.CREATOR.createFromParcel(paramParcel1);
        a(localq, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i13 = paramParcel1.readInt();
        af localaf = null;
        if (i13 != 0)
          localaf = (af)af.CREATOR.createFromParcel(paramParcel1);
        a(localaf, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i12 = paramParcel1.readInt();
        aj localaj = null;
        if (i12 != 0)
          localaj = (aj)aj.CREATOR.createFromParcel(paramParcel1);
        a(localaj, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i11 = paramParcel1.readInt();
        m localm = null;
        if (i11 != 0)
          localm = (m)m.CREATOR.createFromParcel(paramParcel1);
        a(localm, kq.a.at(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i10 = paramParcel1.readInt();
        e locale = null;
        if (i10 != 0)
          locale = (e)e.CREATOR.createFromParcel(paramParcel1);
        a(locale, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i9 = paramParcel1.readInt();
        DataDeleteRequest localDataDeleteRequest = null;
        if (i9 != 0)
          localDataDeleteRequest = (DataDeleteRequest)DataDeleteRequest.CREATOR.createFromParcel(paramParcel1);
        a(localDataDeleteRequest, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i8 = paramParcel1.readInt();
        DataTypeCreateRequest localDataTypeCreateRequest = null;
        if (i8 != 0)
          localDataTypeCreateRequest = (DataTypeCreateRequest)DataTypeCreateRequest.CREATOR.createFromParcel(paramParcel1);
        a(localDataTypeCreateRequest, ko.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i7 = paramParcel1.readInt();
        j localj = null;
        if (i7 != 0)
          localj = (j)j.CREATOR.createFromParcel(paramParcel1);
        a(localj, ko.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i6 = paramParcel1.readInt();
        DataReadRequest localDataReadRequest = null;
        if (i6 != 0)
          localDataReadRequest = (DataReadRequest)DataReadRequest.CREATOR.createFromParcel(paramParcel1);
        a(localDataReadRequest, km.a.ap(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i5 = paramParcel1.readInt();
        SessionInsertRequest localSessionInsertRequest = null;
        if (i5 != 0)
          localSessionInsertRequest = (SessionInsertRequest)SessionInsertRequest.CREATOR.createFromParcel(paramParcel1);
        a(localSessionInsertRequest, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i4 = paramParcel1.readInt();
        SessionReadRequest localSessionReadRequest = null;
        if (i4 != 0)
          localSessionReadRequest = (SessionReadRequest)SessionReadRequest.CREATOR.createFromParcel(paramParcel1);
        a(localSessionReadRequest, kr.a.au(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i3 = paramParcel1.readInt();
        w localw = null;
        if (i3 != 0)
          localw = (w)w.CREATOR.createFromParcel(paramParcel1);
        a(localw, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i2 = paramParcel1.readInt();
        y localy = null;
        if (i2 != 0)
          localy = (y)y.CREATOR.createFromParcel(paramParcel1);
        a(localy, ks.a.av(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i1 = paramParcel1.readInt();
        StartBleScanRequest localStartBleScanRequest = null;
        if (i1 != 0)
          localStartBleScanRequest = (StartBleScanRequest)StartBleScanRequest.CREATOR.createFromParcel(paramParcel1);
        a(localStartBleScanRequest, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int n = paramParcel1.readInt();
        ad localad = null;
        if (n != 0)
          localad = (ad)ad.CREATOR.createFromParcel(paramParcel1);
        a(localad, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int m = paramParcel1.readInt();
        b localb = null;
        if (m != 0)
          localb = (b)b.CREATOR.createFromParcel(paramParcel1);
        a(localb, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int k = paramParcel1.readInt();
        ah localah = null;
        if (k != 0)
          localah = (ah)ah.CREATOR.createFromParcel(paramParcel1);
        a(localah, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int j = paramParcel1.readInt();
        u localu = null;
        if (j != 0)
          localu = (u)u.CREATOR.createFromParcel(paramParcel1);
        a(localu, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        int i = paramParcel1.readInt();
        aa localaa = null;
        if (i != 0)
          localaa = (aa)aa.CREATOR.createFromParcel(paramParcel1);
        a(localaa, kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        a(kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
        b(kt.a.aw(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 24:
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
      a(lf.a.ax(paramParcel1.readStrongBinder()), paramParcel1.readString());
      return true;
    }

    private static class a
      implements kp
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(DataDeleteRequest paramDataDeleteRequest, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            if (paramDataDeleteRequest != null)
            {
              localParcel1.writeInt(1);
              paramDataDeleteRequest.writeToParcel(localParcel1, 0);
              if (paramkt != null)
              {
                localIBinder = paramkt.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.lb.transact(19, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          IBinder localIBinder = null;
        }
      }

      public void a(DataReadRequest paramDataReadRequest, km paramkm, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramDataReadRequest != null)
          {
            localParcel.writeInt(1);
            paramDataReadRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkm != null)
              localIBinder = paramkm.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(8, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(DataSourcesRequest paramDataSourcesRequest, kn paramkn, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramDataSourcesRequest != null)
          {
            localParcel.writeInt(1);
            paramDataSourcesRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkn != null)
              localIBinder = paramkn.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(1, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(DataTypeCreateRequest paramDataTypeCreateRequest, ko paramko, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramDataTypeCreateRequest != null)
          {
            localParcel.writeInt(1);
            paramDataTypeCreateRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramko != null)
              localIBinder = paramko.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(13, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(SessionInsertRequest paramSessionInsertRequest, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramSessionInsertRequest != null)
          {
            localParcel.writeInt(1);
            paramSessionInsertRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(9, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(SessionReadRequest paramSessionReadRequest, kr paramkr, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramSessionReadRequest != null)
          {
            localParcel.writeInt(1);
            paramSessionReadRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkr != null)
              localIBinder = paramkr.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(10, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(StartBleScanRequest paramStartBleScanRequest, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramStartBleScanRequest != null)
          {
            localParcel.writeInt(1);
            paramStartBleScanRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(15, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(aa paramaa, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramaa != null)
          {
            localParcel.writeInt(1);
            paramaa.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(21, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(ad paramad, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramad != null)
          {
            localParcel.writeInt(1);
            paramad.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(16, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(af paramaf, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramaf != null)
          {
            localParcel.writeInt(1);
            paramaf.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(4, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(ah paramah, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramah != null)
          {
            localParcel.writeInt(1);
            paramah.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(18, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(aj paramaj, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramaj != null)
          {
            localParcel.writeInt(1);
            paramaj.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(5, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(b paramb, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramb != null)
          {
            localParcel.writeInt(1);
            paramb.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(17, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(e parame, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (parame != null)
          {
            localParcel.writeInt(1);
            parame.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(7, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(j paramj, ko paramko, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramj != null)
          {
            localParcel.writeInt(1);
            paramj.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramko != null)
              localIBinder = paramko.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(14, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(m paramm, kq paramkq, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramm != null)
          {
            localParcel.writeInt(1);
            paramm.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkq != null)
              localIBinder = paramkq.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(6, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(o paramo, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramo != null)
          {
            localParcel.writeInt(1);
            paramo.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(2, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(q paramq, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramq != null)
          {
            localParcel.writeInt(1);
            paramq.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(3, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(u paramu, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramu != null)
          {
            localParcel.writeInt(1);
            paramu.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(20, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(w paramw, kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramw != null)
          {
            localParcel.writeInt(1);
            paramw.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramkt != null)
              localIBinder = paramkt.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(11, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(y paramy, ks paramks, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          if (paramy != null)
          {
            localParcel.writeInt(1);
            paramy.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramks != null)
              localIBinder = paramks.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.writeString(paramString);
            this.lb.transact(12, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          IBinder localIBinder = null;
          if (paramkt != null)
            localIBinder = paramkt.asBinder();
          localParcel.writeStrongBinder(localIBinder);
          localParcel.writeString(paramString);
          this.lb.transact(22, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(lf paramlf, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          IBinder localIBinder = null;
          if (paramlf != null)
            localIBinder = paramlf.asBinder();
          localParcel.writeStrongBinder(localIBinder);
          localParcel.writeString(paramString);
          this.lb.transact(24, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void b(kt paramkt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
          IBinder localIBinder = null;
          if (paramkt != null)
            localIBinder = paramkt.asBinder();
          localParcel.writeStrongBinder(localIBinder);
          localParcel.writeString(paramString);
          this.lb.transact(23, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kp
 * JD-Core Version:    0.6.2
 */