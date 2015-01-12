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
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment
{
  private GoogleMap aiR;
  private final b aju = new b(this);

  public static SupportMapFragment newInstance()
  {
    return new SupportMapFragment();
  }

  public static SupportMapFragment newInstance(GoogleMapOptions paramGoogleMapOptions)
  {
    SupportMapFragment localSupportMapFragment = new SupportMapFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramGoogleMapOptions);
    localSupportMapFragment.setArguments(localBundle);
    return localSupportMapFragment;
  }

  public final GoogleMap getMap()
  {
    IMapFragmentDelegate localIMapFragmentDelegate = mz();
    if (localIMapFragmentDelegate == null);
    while (true)
    {
      return null;
      try
      {
        IGoogleMapDelegate localIGoogleMapDelegate = localIMapFragmentDelegate.getMap();
        if (localIGoogleMapDelegate == null)
          continue;
        if ((this.aiR == null) || (this.aiR.mq().asBinder() != localIGoogleMapDelegate.asBinder()))
          this.aiR = new GoogleMap(localIGoogleMapDelegate);
        return this.aiR;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }

  protected IMapFragmentDelegate mz()
  {
    this.aju.mA();
    if (this.aju.it() == null)
      return null;
    return ((a)this.aju.it()).mz();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
    super.onActivityCreated(paramBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b.a(this.aju, paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.aju.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.aju.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  public void onDestroy()
  {
    this.aju.onDestroy();
    super.onDestroy();
  }

  public void onDestroyView()
  {
    this.aju.onDestroyView();
    super.onDestroyView();
  }

  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    b.a(this.aju, paramActivity);
    GoogleMapOptions localGoogleMapOptions = GoogleMapOptions.createFromAttributes(paramActivity, paramAttributeSet);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", localGoogleMapOptions);
    this.aju.onInflate(paramActivity, localBundle, paramBundle);
  }

  public void onLowMemory()
  {
    this.aju.onLowMemory();
    super.onLowMemory();
  }

  public void onPause()
  {
    this.aju.onPause();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    this.aju.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
    super.onSaveInstanceState(paramBundle);
    this.aju.onSaveInstanceState(paramBundle);
  }

  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }

  static class a
    implements LifecycleDelegate
  {
    private final Fragment Lt;
    private final IMapFragmentDelegate aiS;

    public a(Fragment paramFragment, IMapFragmentDelegate paramIMapFragmentDelegate)
    {
      this.aiS = ((IMapFragmentDelegate)o.i(paramIMapFragmentDelegate));
      this.Lt = ((Fragment)o.i(paramFragment));
    }

    public IMapFragmentDelegate mz()
    {
      return this.aiS;
    }

    public void onCreate(Bundle paramBundle)
    {
      if (paramBundle == null);
      try
      {
        paramBundle = new Bundle();
        Bundle localBundle = this.Lt.getArguments();
        if ((localBundle != null) && (localBundle.containsKey("MapOptions")))
          t.a(paramBundle, "MapOptions", localBundle.getParcelable("MapOptions"));
        this.aiS.onCreate(paramBundle);
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
        d locald = this.aiS.onCreateView(e.k(paramLayoutInflater), e.k(paramViewGroup), paramBundle);
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
        this.aiS.onDestroy();
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
        this.aiS.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      GoogleMapOptions localGoogleMapOptions = (GoogleMapOptions)paramBundle1.getParcelable("MapOptions");
      try
      {
        this.aiS.onInflate(e.k(paramActivity), localGoogleMapOptions, paramBundle2);
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
        this.aiS.onLowMemory();
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
        this.aiS.onPause();
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
        this.aiS.onResume();
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
        this.aiS.onSaveInstanceState(paramBundle);
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

  static class b extends a<SupportMapFragment.a>
  {
    private final Fragment Lt;
    protected f<SupportMapFragment.a> aiT;
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

    protected void a(f<SupportMapFragment.a> paramf)
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
        IMapFragmentDelegate localIMapFragmentDelegate = u.S(this.nr).j(e.k(this.nr));
        this.aiT.a(new SupportMapFragment.a(this.Lt, localIMapFragmentDelegate));
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
 * Qualified Name:     com.google.android.gms.maps.SupportMapFragment
 * JD-Core Version:    0.6.2
 */