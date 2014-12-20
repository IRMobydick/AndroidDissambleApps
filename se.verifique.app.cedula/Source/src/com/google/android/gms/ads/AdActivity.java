package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.db;
import com.google.android.gms.internal.dd;
import com.google.android.gms.internal.hi;

public final class AdActivity extends Activity
{
  private dd a;

  private void a()
  {
    if (this.a != null);
    try
    {
      this.a.j();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not forward setContentViewSet to ad overlay:", localRemoteException);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = db.a(this);
    if (this.a == null)
    {
      hi.e("Could not create ad overlay.");
      finish();
    }
    while (true)
    {
      return;
      try
      {
        this.a.a(paramBundle);
      }
      catch (RemoteException localRemoteException)
      {
        hi.c("Could not forward onCreate to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  protected void onDestroy()
  {
    try
    {
      if (this.a != null)
        this.a.i();
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not forward onDestroy to ad overlay:", localRemoteException);
    }
  }

  protected void onPause()
  {
    try
    {
      if (this.a != null)
        this.a.g();
      super.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Could not forward onPause to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  protected void onRestart()
  {
    super.onRestart();
    try
    {
      if (this.a != null)
        this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Could not forward onRestart to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  protected void onResume()
  {
    super.onResume();
    try
    {
      if (this.a != null)
        this.a.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Could not forward onResume to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      if (this.a != null)
        this.a.b(paramBundle);
      super.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Could not forward onSaveInstanceState to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  protected void onStart()
  {
    super.onStart();
    try
    {
      if (this.a != null)
        this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Could not forward onStart to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  protected void onStop()
  {
    try
    {
      if (this.a != null)
        this.a.h();
      super.onStop();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Could not forward onStop to ad overlay:", localRemoteException);
        finish();
      }
    }
  }

  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a();
  }

  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    a();
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    a();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdActivity
 * JD-Core Version:    0.6.0
 */