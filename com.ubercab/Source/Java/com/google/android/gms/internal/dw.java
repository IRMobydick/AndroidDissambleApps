package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.Method;

@ez
public class dw
{
  private final Context mContext;
  private Object sk;

  public dw(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public Bundle a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Class localClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
      Class[] arrayOfClass = new Class[5];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = String.class;
      arrayOfClass[2] = String.class;
      arrayOfClass[3] = String.class;
      arrayOfClass[4] = String.class;
      Method localMethod = localClass.getDeclaredMethod("getBuyIntent", arrayOfClass);
      Object localObject = localClass.cast(this.sk);
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = Integer.valueOf(3);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = "inapp";
      arrayOfObject[4] = paramString3;
      Bundle localBundle = (Bundle)localMethod.invoke(localObject, arrayOfObject);
      return localBundle;
    }
    catch (Exception localException)
    {
      gs.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", localException);
    }
    return null;
  }

  public int c(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = String.class;
      arrayOfClass[2] = String.class;
      Method localMethod = localClass.getDeclaredMethod("consumePurchase", arrayOfClass);
      Object localObject = localClass.cast(this.sk);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(3);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      int i = ((Integer)localMethod.invoke(localObject, arrayOfObject)).intValue();
      return i;
    }
    catch (Exception localException)
    {
      gs.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", localException);
    }
    return 5;
  }

  public Bundle d(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = String.class;
      arrayOfClass[2] = String.class;
      arrayOfClass[3] = String.class;
      Method localMethod = localClass.getDeclaredMethod("getPurchases", arrayOfClass);
      Object localObject = localClass.cast(this.sk);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(3);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = "inapp";
      arrayOfObject[3] = paramString2;
      Bundle localBundle = (Bundle)localMethod.invoke(localObject, arrayOfObject);
      return localBundle;
    }
    catch (Exception localException)
    {
      gs.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", localException);
    }
    return null;
  }

  public void destroy()
  {
    this.sk = null;
  }

  public void r(IBinder paramIBinder)
  {
    try
    {
      this.sk = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { paramIBinder });
      return;
    }
    catch (Exception localException)
    {
      gs.W("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dw
 * JD-Core Version:    0.6.2
 */