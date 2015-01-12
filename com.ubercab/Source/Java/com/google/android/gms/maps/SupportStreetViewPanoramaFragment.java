package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportStreetViewPanoramaFragment extends Fragment
{
  private StreetViewPanorama ajh;
  private final b ajv = new b(this);

  public static SupportStreetViewPanoramaFragment newInstance()
  {
    return new SupportStreetViewPanoramaFragment();
  }

  public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    SupportStreetViewPanoramaFragment localSupportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("StreetViewPanoramaOptions", paramStreetViewPanoramaOptions);
    localSupportStreetViewPanoramaFragment.setArguments(localBundle);
    return localSupportStreetViewPanoramaFragment;
  }

  public final StreetViewPanorama getStreetViewPanorama()
  {
    IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate = mD();
    if (localIStreetViewPanoramaFragmentDelegate == null);
    while (true)
    {
      return null;
      try
      {
        IStreetViewPanoramaDelegate localIStreetViewPanoramaDelegate = localIStreetViewPanoramaFragmentDelegate.getStreetViewPanorama();
        if (localIStreetViewPanoramaDelegate == null)
          continue;
        if ((this.ajh == null) || (this.ajh.mC().asBinder() != localIStreetViewPanoramaDelegate.asBinder()))
          this.ajh = new StreetViewPanorama(localIStreetViewPanoramaDelegate);
        return this.ajh;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }

  protected IStreetViewPanoramaFragmentDelegate mD()
  {
    this.ajv.mA();
    if (this.ajv.it() == null)
      return null;
    return ((a)this.ajv.it()).mD();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
    super.onActivityCreated(paramBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b.a(this.ajv, paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ajv.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.ajv.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  public void onDestroy()
  {
    this.ajv.onDestroy();
    super.onDestroy();
  }

  public void onDestroyView()
  {
    this.ajv.onDestroyView();
    super.onDestroyView();
  }

  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    b.a(this.ajv, paramActivity);
    Bundle localBundle = new Bundle();
    this.ajv.onInflate(paramActivity, localBundle, paramBundle);
  }

  public void onLowMemory()
  {
    this.ajv.onLowMemory();
    super.onLowMemory();
  }

  public void onPause()
  {
    this.ajv.onPause();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    this.ajv.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
    super.onSaveInstanceState(paramBundle);
    this.ajv.onSaveInstanceState(paramBundle);
  }

  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }

  static class a
    implements LifecycleDelegate
  {
    private final Fragment Lt;
    private final IStreetViewPanoramaFragmentDelegate aji;

    public a(Fragment paramFragment, IStreetViewPanoramaFragmentDelegate paramIStreetViewPanoramaFragmentDelegate)
    {
      this.aji = ((IStreetViewPanoramaFragmentDelegate)o.i(paramIStreetViewPanoramaFragmentDelegate));
      this.Lt = ((Fragment)o.i(paramFragment));
    }

    public IStreetViewPanoramaFragmentDelegate mD()
    {
      return this.aji;
    }

    public void onCreate(Bundle paramBundle)
    {
      if (paramBundle == null);
      try
      {
        paramBundle = new Bundle();
        Bundle localBundle = this.Lt.getArguments();
        if ((localBundle != null) && (localBundle.containsKey("StreetViewPanoramaOptions")))
          t.a(paramBundle, "StreetViewPanoramaOptions", localBundle.getParcelable("StreetViewPanoramaOptions"));
        this.aji.onCreate(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        d locald = this.aji.onCreateView(e.k(paramLayoutInflater), e.k(paramViewGroup), paramBundle);
        return (View)e.f(locald);
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onDestroy()
    {
      try
      {
        this.aji.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onDestroyView()
    {
      try
      {
        this.aji.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      try
      {
        this.aji.onInflate(e.k(paramActivity), null, paramBundle2);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onLowMemory()
    {
      try
      {
        this.aji.onLowMemory();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onPause()
    {
      try
      {
        this.aji.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onResume()
    {
      try
      {
        this.aji.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.aji.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }
  }

  static class b extends a<SupportStreetViewPanoramaFragment.a>
  {
    private final Fragment Lt;
    protected f<SupportStreetViewPanoramaFragment.a> aiT;
    private Activity nr;

    b(Fragment paramFragment)
    {
      this.Lt = paramFragment;
    }

    private void setActivity(Activity paramActivity)
    {
      this.nr = paramActivity;
      mA();
    }

    protected void a(f<SupportStreetViewPanoramaFragment.a> paramf)
    {
      this.aiT = paramf;
      mA();
    }

    public void mA()
    {
      if ((this.nr != null) && (this.aiT != null) && (it() == null));
      try
      {
        MapsInitializer.initialize(this.nr);
        IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate = u.S(this.nr).k(e.k(this.nr));
        this.aiT.a(new SupportStreetViewPanoramaFragment.a(this.Lt, localIStreetViewPanoramaFragmentDelegate));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.SupportStreetViewPanoramaFragment
 * JD-Core Version:    0.6.2
 */