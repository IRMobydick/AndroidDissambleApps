package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.a.a;
import com.google.android.gms.location.b;
import com.google.android.gms.location.c;
import com.google.android.gms.location.d;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.g;
import com.google.android.gms.maps.model.i;
import java.util.ArrayList;
import java.util.List;

public abstract interface lx extends IInterface
{
  public abstract void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void a(PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void a(PendingIntent paramPendingIntent, lw paramlw, String paramString)
    throws RemoteException;

  public abstract void a(Location paramLocation, int paramInt)
    throws RemoteException;

  public abstract void a(lw paramlw, String paramString)
    throws RemoteException;

  public abstract void a(ma paramma, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void a(ma paramma, a parama)
    throws RemoteException;

  public abstract void a(mh parammh, mx parammx, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void a(mj parammj, mx parammx, mv parammv)
    throws RemoteException;

  public abstract void a(ml paramml, mx parammx)
    throws RemoteException;

  public abstract void a(mn parammn, mx parammx, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void a(mr parammr, mx parammx, mv parammv)
    throws RemoteException;

  public abstract void a(mt parammt, LatLngBounds paramLatLngBounds, List<String> paramList, mx parammx, mv parammv)
    throws RemoteException;

  public abstract void a(mx parammx, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void a(LocationRequest paramLocationRequest, a parama)
    throws RemoteException;

  public abstract void a(LocationRequest paramLocationRequest, a parama, String paramString)
    throws RemoteException;

  public abstract void a(a parama)
    throws RemoteException;

  public abstract void a(LatLng paramLatLng, mj parammj, mx parammx, mv parammv)
    throws RemoteException;

  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, mj parammj, mx parammx, mv parammv)
    throws RemoteException;

  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, mj parammj, mx parammx, mv parammv)
    throws RemoteException;

  public abstract void a(String paramString, mx parammx, mv parammv)
    throws RemoteException;

  public abstract void a(String paramString, LatLngBounds paramLatLngBounds, mf parammf, mx parammx, mv parammv)
    throws RemoteException;

  public abstract void a(List<mc> paramList, PendingIntent paramPendingIntent, lw paramlw, String paramString)
    throws RemoteException;

  public abstract void a(String[] paramArrayOfString, lw paramlw, String paramString)
    throws RemoteException;

  public abstract void b(mx parammx, PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void b(String paramString, mx parammx, mv parammv)
    throws RemoteException;

  public abstract Location bW(String paramString)
    throws RemoteException;

  public abstract c bX(String paramString)
    throws RemoteException;

  public abstract Location lV()
    throws RemoteException;

  public abstract IBinder lW()
    throws RemoteException;

  public abstract IBinder lX()
    throws RemoteException;

  public abstract void removeActivityUpdates(PendingIntent paramPendingIntent)
    throws RemoteException;

  public abstract void setMockLocation(Location paramLocation)
    throws RemoteException;

  public abstract void setMockMode(boolean paramBoolean)
    throws RemoteException;

  public static abstract class a extends Binder
    implements lx
  {
    public static lx aK(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if ((localIInterface != null) && ((localIInterface instanceof lx)))
        return (lx)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ArrayList localArrayList2 = paramParcel1.createTypedArrayList(mc.CREATOR);
        if (paramParcel1.readInt() != 0);
        for (PendingIntent localPendingIntent11 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent11 = null)
        {
          a(localArrayList2, localPendingIntent11, lw.a.aJ(paramParcel1.readStrongBinder()), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0);
        for (PendingIntent localPendingIntent10 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent10 = null)
        {
          a(localPendingIntent10, lw.a.aJ(paramParcel1.readStrongBinder()), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(paramParcel1.createStringArray(), lw.a.aJ(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(lw.a.aJ(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        long l = paramParcel1.readLong();
        boolean bool2;
        if (paramParcel1.readInt() != 0)
        {
          bool2 = true;
          if (paramParcel1.readInt() == 0)
            break label564;
        }
        for (PendingIntent localPendingIntent9 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent9 = null)
        {
          a(l, bool2, localPendingIntent9);
          paramParcel2.writeNoException();
          return true;
          bool2 = false;
          break;
        }
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0);
        for (PendingIntent localPendingIntent8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent8 = null)
        {
          removeActivityUpdates(localPendingIntent8);
          paramParcel2.writeNoException();
          return true;
        }
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        Location localLocation4 = lV();
        paramParcel2.writeNoException();
        if (localLocation4 != null)
        {
          paramParcel2.writeInt(1);
          localLocation4.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        int i8 = paramParcel1.readInt();
        LocationRequest localLocationRequest3 = null;
        if (i8 != 0)
          localLocationRequest3 = LocationRequest.CREATOR.cs(paramParcel1);
        a(localLocationRequest3, a.a.aI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        int i7 = paramParcel1.readInt();
        LocationRequest localLocationRequest2 = null;
        if (i7 != 0)
          localLocationRequest2 = LocationRequest.CREATOR.cs(paramParcel1);
        a(localLocationRequest2, a.a.aI(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LocationRequest localLocationRequest1;
        if (paramParcel1.readInt() != 0)
        {
          localLocationRequest1 = LocationRequest.CREATOR.cs(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label820;
        }
        for (PendingIntent localPendingIntent7 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent7 = null)
        {
          a(localLocationRequest1, localPendingIntent7);
          paramParcel2.writeNoException();
          return true;
          localLocationRequest1 = null;
          break;
        }
      case 52:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        int i6 = paramParcel1.readInt();
        ma localma2 = null;
        if (i6 != 0)
          localma2 = ma.CREATOR.cv(paramParcel1);
        a(localma2, a.a.aI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 53:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ma localma1;
        if (paramParcel1.readInt() != 0)
        {
          localma1 = ma.CREATOR.cv(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label937;
        }
        for (PendingIntent localPendingIntent6 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent6 = null)
        {
          a(localma1, localPendingIntent6);
          paramParcel2.writeNoException();
          return true;
          localma1 = null;
          break;
        }
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(a.a.aI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0);
        for (PendingIntent localPendingIntent5 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent5 = null)
        {
          a(localPendingIntent5);
          paramParcel2.writeNoException();
          return true;
        }
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        int i5 = paramParcel1.readInt();
        boolean bool1 = false;
        if (i5 != 0)
          bool1 = true;
        setMockMode(bool1);
        paramParcel2.writeNoException();
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0);
        for (Location localLocation3 = (Location)Location.CREATOR.createFromParcel(paramParcel1); ; localLocation3 = null)
        {
          setMockLocation(localLocation3);
          paramParcel2.writeNoException();
          return true;
        }
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLngBounds localLatLngBounds4;
        int i4;
        mj localmj4;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds4 = LatLngBounds.CREATOR.cL(paramParcel1);
          i4 = paramParcel1.readInt();
          if (paramParcel1.readInt() == 0)
            break label1182;
          localmj4 = mj.CREATOR.cz(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1188;
        }
        for (mx localmx14 = mx.CREATOR.cF(paramParcel1); ; localmx14 = null)
        {
          a(localLatLngBounds4, i4, localmj4, localmx14, mv.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localLatLngBounds4 = null;
          break;
          localmj4 = null;
          break label1135;
        }
      case 47:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLngBounds localLatLngBounds3;
        int i2;
        String str4;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds3 = LatLngBounds.CREATOR.cL(paramParcel1);
          i2 = paramParcel1.readInt();
          str4 = paramParcel1.readString();
          if (paramParcel1.readInt() == 0)
            break label1300;
        }
        for (mj localmj3 = mj.CREATOR.cz(paramParcel1); ; localmj3 = null)
        {
          int i3 = paramParcel1.readInt();
          mx localmx13 = null;
          if (i3 != 0)
            localmx13 = mx.CREATOR.cF(paramParcel1);
          a(localLatLngBounds3, i2, str4, localmj3, localmx13, mv.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localLatLngBounds3 = null;
          break;
        }
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str3 = paramParcel1.readString();
        int i1 = paramParcel1.readInt();
        mx localmx12 = null;
        if (i1 != 0)
          localmx12 = mx.CREATOR.cF(paramParcel1);
        a(str3, localmx12, mv.a.aM(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLng localLatLng;
        if (paramParcel1.readInt() != 0)
        {
          localLatLng = LatLng.CREATOR.cM(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1452;
        }
        for (mj localmj2 = mj.CREATOR.cz(paramParcel1); ; localmj2 = null)
        {
          int n = paramParcel1.readInt();
          mx localmx11 = null;
          if (n != 0)
            localmx11 = mx.CREATOR.cF(paramParcel1);
          a(localLatLng, localmj2, localmx11, mv.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localLatLng = null;
          break;
        }
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0);
        for (mj localmj1 = mj.CREATOR.cz(paramParcel1); ; localmj1 = null)
        {
          int m = paramParcel1.readInt();
          mx localmx10 = null;
          if (m != 0)
            localmx10 = mx.CREATOR.cF(paramParcel1);
          a(localmj1, localmx10, mv.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 42:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str2 = paramParcel1.readString();
        int k = paramParcel1.readInt();
        mx localmx9 = null;
        if (k != 0)
          localmx9 = mx.CREATOR.cF(paramParcel1);
        b(str2, localmx9, mv.a.aM(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 50:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        mt localmt;
        LatLngBounds localLatLngBounds2;
        ArrayList localArrayList1;
        if (paramParcel1.readInt() != 0)
        {
          localmt = mt.CREATOR.cE(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1677;
          localLatLngBounds2 = LatLngBounds.CREATOR.cL(paramParcel1);
          localArrayList1 = paramParcel1.createStringArrayList();
          if (paramParcel1.readInt() == 0)
            break label1683;
        }
        for (mx localmx8 = mx.CREATOR.cF(paramParcel1); ; localmx8 = null)
        {
          a(localmt, localLatLngBounds2, localArrayList1, localmx8, mv.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localmt = null;
          break;
          localLatLngBounds2 = null;
          break label1624;
        }
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        mn localmn;
        mx localmx7;
        if (paramParcel1.readInt() != 0)
        {
          localmn = mn.CREATOR.cB(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1770;
          localmx7 = mx.CREATOR.cF(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1776;
        }
        for (PendingIntent localPendingIntent4 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent4 = null)
        {
          a(localmn, localmx7, localPendingIntent4);
          paramParcel2.writeNoException();
          return true;
          localmn = null;
          break;
          localmx7 = null;
          break label1727;
        }
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        mx localmx6;
        if (paramParcel1.readInt() != 0)
        {
          localmx6 = mx.CREATOR.cF(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1845;
        }
        for (PendingIntent localPendingIntent3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent3 = null)
        {
          a(localmx6, localPendingIntent3);
          paramParcel2.writeNoException();
          return true;
          localmx6 = null;
          break;
        }
      case 48:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        mh localmh;
        mx localmx5;
        if (paramParcel1.readInt() != 0)
        {
          localmh = mh.CREATOR.cy(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1932;
          localmx5 = mx.CREATOR.cF(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label1938;
        }
        for (PendingIntent localPendingIntent2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent2 = null)
        {
          a(localmh, localmx5, localPendingIntent2);
          paramParcel2.writeNoException();
          return true;
          localmh = null;
          break;
          localmx5 = null;
          break label1889;
        }
      case 49:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        mx localmx4;
        if (paramParcel1.readInt() != 0)
        {
          localmx4 = mx.CREATOR.cF(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label2007;
        }
        for (PendingIntent localPendingIntent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1); ; localPendingIntent1 = null)
        {
          b(localmx4, localPendingIntent1);
          paramParcel2.writeNoException();
          return true;
          localmx4 = null;
          break;
        }
      case 55:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str1 = paramParcel1.readString();
        LatLngBounds localLatLngBounds1;
        mf localmf;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds1 = LatLngBounds.CREATOR.cL(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label2104;
          localmf = mf.CREATOR.cx(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label2110;
        }
        for (mx localmx3 = mx.CREATOR.cF(paramParcel1); ; localmx3 = null)
        {
          a(str1, localLatLngBounds1, localmf, localmx3, mv.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localLatLngBounds1 = null;
          break;
          localmf = null;
          break label2057;
        }
      case 46:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0);
        for (mr localmr = (mr)mr.CREATOR.createFromParcel(paramParcel1); ; localmr = null)
        {
          int j = paramParcel1.readInt();
          mx localmx2 = null;
          if (j != 0)
            localmx2 = mx.CREATOR.cF(paramParcel1);
          a(localmr, localmx2, mv.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        Location localLocation2 = bW(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localLocation2 != null)
        {
          paramParcel2.writeInt(1);
          localLocation2.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 25:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0);
        for (ml localml = ml.CREATOR.cA(paramParcel1); ; localml = null)
        {
          int i = paramParcel1.readInt();
          mx localmx1 = null;
          if (i != 0)
            localmx1 = mx.CREATOR.cF(paramParcel1);
          a(localml, localmx1);
          return true;
        }
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0);
        for (Location localLocation1 = (Location)Location.CREATOR.createFromParcel(paramParcel1); ; localLocation1 = null)
        {
          a(localLocation1, paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 34:
        label1677: label1683: paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        label1932: label1938: c localc = bX(paramParcel1.readString());
        label2057: paramParcel2.writeNoException();
        if (localc != null)
        {
          paramParcel2.writeInt(1);
          localc.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 51:
        label564: label1135: label1776: paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        label820: label1624: label1770: IBinder localIBinder2 = lW();
        label937: label1452: label1727: label1889: paramParcel2.writeNoException();
        label1182: label1188: label1845: label2007: paramParcel2.writeStrongBinder(localIBinder2);
        label1300: label2104: label2110: return true;
      case 54:
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      IBinder localIBinder1 = lX();
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(localIBinder1);
      return true;
    }

    private static class a
      implements lx
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          localParcel1.writeLong(paramLong);
          if (paramBoolean)
          {
            localParcel1.writeInt(i);
            if (paramPendingIntent == null)
              break label94;
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            i = 0;
            break;
            label94: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(11, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(PendingIntent paramPendingIntent, lw paramlw, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramlw != null)
              {
                localIBinder = paramlw.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.lb.transact(2, localParcel1, localParcel2, 0);
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

      public void a(Location paramLocation, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramLocation != null)
          {
            localParcel1.writeInt(1);
            paramLocation.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt);
            this.lb.transact(26, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(lw paramlw, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramlw != null);
          for (IBinder localIBinder = paramlw.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.lb.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(ma paramma, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramma != null)
            {
              localParcel1.writeInt(1);
              paramma.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(53, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void a(ma paramma, a parama)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramma != null)
            {
              localParcel1.writeInt(1);
              paramma.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                localIBinder = parama.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(52, localParcel1, localParcel2, 0);
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

      public void a(mh parammh, mx parammx, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammh != null)
            {
              localParcel1.writeInt(1);
              parammh.writeToParcel(localParcel1, 0);
              if (parammx != null)
              {
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (paramPendingIntent == null)
                  break label134;
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(48, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label134: localParcel1.writeInt(0);
        }
      }

      public void a(mj parammj, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammj != null)
            {
              localParcel1.writeInt(1);
              parammj.writeToParcel(localParcel1, 0);
              if (parammx != null)
              {
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (parammv == null)
                  break label136;
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(17, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label136: IBinder localIBinder = null;
        }
      }

      public void a(ml paramml, mx parammx)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramml != null)
            {
              localParcel.writeInt(1);
              paramml.writeToParcel(localParcel, 0);
              if (parammx != null)
              {
                localParcel.writeInt(1);
                parammx.writeToParcel(localParcel, 0);
                this.lb.transact(25, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void a(mn parammn, mx parammx, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammn != null)
            {
              localParcel1.writeInt(1);
              parammn.writeToParcel(localParcel1, 0);
              if (parammx != null)
              {
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (paramPendingIntent == null)
                  break label134;
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(18, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label134: localParcel1.writeInt(0);
        }
      }

      public void a(mr parammr, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammr != null)
            {
              localParcel1.writeInt(1);
              parammr.writeToParcel(localParcel1, 0);
              if (parammx != null)
              {
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (parammv == null)
                  break label136;
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(46, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label136: IBinder localIBinder = null;
        }
      }

      public void a(mt parammt, LatLngBounds paramLatLngBounds, List<String> paramList, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammt != null)
            {
              localParcel1.writeInt(1);
              parammt.writeToParcel(localParcel1, 0);
              if (paramLatLngBounds != null)
              {
                localParcel1.writeInt(1);
                paramLatLngBounds.writeToParcel(localParcel1, 0);
                localParcel1.writeStringList(paramList);
                if (parammx == null)
                  break label163;
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (parammv == null)
                  break label172;
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(50, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label163: localParcel1.writeInt(0);
          continue;
          label172: IBinder localIBinder = null;
        }
      }

      public void a(mx parammx, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammx != null)
            {
              localParcel1.writeInt(1);
              parammx.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(9, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void a(LocationRequest paramLocationRequest, a parama)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                localIBinder = parama.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(8, localParcel1, localParcel2, 0);
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

      public void a(LocationRequest paramLocationRequest, a parama, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                localIBinder = parama.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.lb.transact(20, localParcel1, localParcel2, 0);
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

      public void a(a parama)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (parama != null);
          for (IBinder localIBinder = parama.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(LatLng paramLatLng, mj parammj, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLng != null)
            {
              localParcel1.writeInt(1);
              paramLatLng.writeToParcel(localParcel1, 0);
              if (parammj != null)
              {
                localParcel1.writeInt(1);
                parammj.writeToParcel(localParcel1, 0);
                if (parammx == null)
                  break label155;
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (parammv == null)
                  break label164;
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(16, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label155: localParcel1.writeInt(0);
          continue;
          label164: IBinder localIBinder = null;
        }
      }

      public void a(LatLngBounds paramLatLngBounds, int paramInt, mj parammj, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              if (parammj != null)
              {
                localParcel1.writeInt(1);
                parammj.writeToParcel(localParcel1, 0);
                if (parammx == null)
                  break label163;
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (parammv == null)
                  break label172;
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(14, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label163: localParcel1.writeInt(0);
          continue;
          label172: IBinder localIBinder = null;
        }
      }

      public void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, mj parammj, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              localParcel1.writeString(paramString);
              if (parammj != null)
              {
                localParcel1.writeInt(1);
                parammj.writeToParcel(localParcel1, 0);
                if (parammx == null)
                  break label171;
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (parammv == null)
                  break label180;
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(47, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label171: localParcel1.writeInt(0);
          continue;
          label180: IBinder localIBinder = null;
        }
      }

      public void a(String paramString, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (parammx != null)
            {
              localParcel1.writeInt(1);
              parammx.writeToParcel(localParcel1, 0);
              if (parammv != null)
              {
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(15, localParcel1, localParcel2, 0);
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

      public void a(String paramString, LatLngBounds paramLatLngBounds, mf parammf, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              if (parammf != null)
              {
                localParcel1.writeInt(1);
                parammf.writeToParcel(localParcel1, 0);
                if (parammx == null)
                  break label163;
                localParcel1.writeInt(1);
                parammx.writeToParcel(localParcel1, 0);
                if (parammv == null)
                  break label172;
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(55, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
          continue;
          label163: localParcel1.writeInt(0);
          continue;
          label172: IBinder localIBinder = null;
        }
      }

      public void a(List<mc> paramList, PendingIntent paramPendingIntent, lw paramlw, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeTypedList(paramList);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramlw != null)
              {
                localIBinder = paramlw.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.lb.transact(1, localParcel1, localParcel2, 0);
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

      public void a(String[] paramArrayOfString, lw paramlw, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          localParcel1.writeStringArray(paramArrayOfString);
          if (paramlw != null);
          for (IBinder localIBinder = paramlw.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.lb.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void b(mx parammx, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammx != null)
            {
              localParcel1.writeInt(1);
              parammx.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(49, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void b(String paramString, mx parammx, mv parammv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (parammx != null)
            {
              localParcel1.writeInt(1);
              parammx.writeToParcel(localParcel1, 0);
              if (parammv != null)
              {
                localIBinder = parammv.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(42, localParcel1, localParcel2, 0);
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

      public Location bW(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          localParcel1.writeString(paramString);
          this.lb.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localLocation = (Location)Location.CREATOR.createFromParcel(localParcel2);
            return localLocation;
          }
          Location localLocation = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public c bX(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          localParcel1.writeString(paramString);
          this.lb.transact(34, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            c localc2 = c.CREATOR.ct(localParcel2);
            localc1 = localc2;
            return localc1;
          }
          c localc1 = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Location lV()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          this.lb.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localLocation = (Location)Location.CREATOR.createFromParcel(localParcel2);
            return localLocation;
          }
          Location localLocation = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IBinder lW()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          this.lb.transact(51, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IBinder localIBinder = localParcel2.readStrongBinder();
          return localIBinder;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IBinder lX()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          this.lb.transact(54, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IBinder localIBinder = localParcel2.readStrongBinder();
          return localIBinder;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void removeActivityUpdates(PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setMockLocation(Location paramLocation)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramLocation != null)
          {
            localParcel1.writeInt(1);
            paramLocation.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(13, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setMockMode(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lx
 * JD-Core Version:    0.6.2
 */