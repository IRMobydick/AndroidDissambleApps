package com.ubercab.client.feature.trip.map;

import dagger.internal.BindingsGroup;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

public final class MapModule$$ModuleAdapter extends ModuleAdapter<MapModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = { "members/com.ubercab.client.feature.trip.map.MapFragment" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public MapModule$$ModuleAdapter()
  {
    super(MapModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, false);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, MapModule paramMapModule)
  {
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.trip.map.MapCameraStateManager", new ProvideMapCameraStateManagerProvidesAdapter(paramMapModule));
  }

  public static final class ProvideMapCameraStateManagerProvidesAdapter extends ProvidesBinding<MapCameraStateManager>
    implements Provider<MapCameraStateManager>
  {
    private final MapModule module;

    public ProvideMapCameraStateManagerProvidesAdapter(MapModule paramMapModule)
    {
      super(true, "com.ubercab.client.feature.trip.map.MapModule", "provideMapCameraStateManager");
      this.module = paramMapModule;
      setLibrary(false);
    }

    public MapCameraStateManager get()
    {
      return this.module.provideMapCameraStateManager();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */