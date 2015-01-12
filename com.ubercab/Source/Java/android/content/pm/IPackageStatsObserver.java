package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IPackageStatsObserver extends IInterface
{
  public abstract void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IPackageStatsObserver
  {
    private static final String DESCRIPTOR = "android.content.pm.IPackageStatsObserver";
    static final int TRANSACTION_onGetStatsCompleted = 1;

    public Stub()
    {
      attachInterface(this, "android.content.pm.IPackageStatsObserver");
    }

    public static IPackageStatsObserver asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.content.pm.IPackageStatsObserver");
      if ((localIInterface != null) && ((localIInterface instanceof IPackageStatsObserver)))
        return (IPackageStatsObserver)localIInterface;
      return new Proxy(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("android.content.pm.IPackageStatsObserver");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("android.content.pm.IPackageStatsObserver");
      PackageStats localPackageStats;
      if (paramParcel1.readInt() != 0)
      {
        localPackageStats = (PackageStats)PackageStats.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label99;
      }
      label99: for (boolean bool = true; ; bool = false)
      {
        onGetStatsCompleted(localPackageStats, bool);
        return true;
        localPackageStats = null;
        break;
      }
    }

    private static class Proxy
      implements IPackageStatsObserver
    {
      private IBinder mRemote;

      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.mRemote;
      }

      public String getInterfaceDescriptor()
      {
        return "android.content.pm.IPackageStatsObserver";
      }

      public void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("android.content.pm.IPackageStatsObserver");
            if (paramPackageStats != null)
            {
              localParcel.writeInt(1);
              paramPackageStats.writeToParcel(localParcel, 0);
              break label85;
              localParcel.writeInt(i);
              this.mRemote.transact(1, localParcel, null, 1);
            }
            else
            {
              localParcel.writeInt(0);
            }
          }
          finally
          {
            localParcel.recycle();
          }
          label85: 
          while (!paramBoolean)
          {
            i = 0;
            break;
          }
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.content.pm.IPackageStatsObserver
 * JD-Core Version:    0.6.2
 */