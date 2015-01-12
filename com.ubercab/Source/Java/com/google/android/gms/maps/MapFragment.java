package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
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

public class MapFragment extends Fragment
{
  private final b aiQ = new b(this);
  private GoogleMap aiR;

  public static MapFragment newInstance()
  {
    return new MapFragment();
  }

  public static MapFragment newInstance(GoogleMapOptions paramGoogleMapOptions)
  {
    MapFragment localMapFragment = new MapFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramGoogleMapOptions);
    localMapFragment.setArguments(localBundle);
    return localMapFragment;
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
    this.aiQ.mA();
    if (this.aiQ.it() == null)
      return null;
    return ((a)this.aiQ.it()).mz();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    super.onActivityCreated(paramBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b.a(this.aiQ, paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.aiQ.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.aiQ.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  public void onDestroy()
  {
    this.aiQ.onDestroy();
    super.onDestroy();
  }

  public void onDestroyView()
  {
    this.aiQ.onDestroyView();
    super.onDestroyView();
  }

  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    b.a(this.aiQ, paramActivity);
    GoogleMapOptions localGoogleMapOptions = GoogleMapOptions.createFromAttributes(paramActivity, paramAttributeSet);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", localGoogleMapOptions);
    this.aiQ.onInflate(paramActivity, localBundle, paramBundle);
  }

  public void onLowMemory()
  {
    this.aiQ.onLowMemory();
    super.onLowMemory();
  }

  public void onPause()
  {
    this.aiQ.onPause();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    this.aiQ.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    super.onSaveInstanceState(paramBundle);
    this.aiQ.onSaveInstanceState(paramBundle);
  }

  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }

  static class a
    implements LifecycleDelegate
  {
    private final Fragment Sj;
    private final IMapFragmentDelegate aiS;

    public a(Fragment paramFragment, IMapFragmentDelegate paramIMapFragmentDelegate)
    {
      this.aiS = ((IMapFragmentDelegate)o.i(paramIMapFragmentDelegate));
      this.Sj = ((Fragment)o.i(paramFragment));
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
        Bundle localBundle = this.Sj.getArguments();
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

  static class b extends a<MapFragment.a>
  {
    private final Fragment Sj;
    protected f<MapFragment.a> aiT;
    private Activity nr;

    b(Fragment paramFragment)
    {
      this.Sj = paramFragment;
    }

    private void setActivity(Activity paramActivity)
    {
      this.nr = paramActivity;
      mA();
    }

    protected void a(f<MapFragment.a> paramf)
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
        this.aiT.a(new MapFragment.a(this.Sj, localIMapFragmentDelegate));
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
 * Qualified Name:     com.google.android.gms.maps.MapFragment
 * JD-Core Version:    0.6.2
 */