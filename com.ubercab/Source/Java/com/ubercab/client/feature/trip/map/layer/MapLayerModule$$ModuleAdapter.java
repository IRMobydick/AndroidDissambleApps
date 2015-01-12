package com.ubercab.client.feature.trip.map.layer;

import android.content.Context;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.client.core.vendor.google.network.DirectionsClient;
import com.ubercab.client.feature.trip.map.MapPolylineStyle;
import com.ubercab.library.map.UberBitmapDescriptorFactory;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberMarkerOptions;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

public final class MapLayerModule$$ModuleAdapter extends ModuleAdapter<MapLayerModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = { "members/com.ubercab.client.feature.trip.map.layer.directions.DirectionsMapLayer", "members/com.ubercab.client.feature.trip.map.layer.pins.LocationPinsMapLayer", "members/com.ubercab.client.feature.trip.map.layer.route.MultiLegRouteMapLayer", "members/com.ubercab.client.feature.trip.map.layer.route.SingleLegRouteMapLayer", "members/com.ubercab.client.feature.trip.map.layer.vehicles.VehiclesMapLayer" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public MapLayerModule$$ModuleAdapter()
  {
    super(MapLayerModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, false);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, MapLayerModule paramMapLayerModule)
  {
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.map.UberMarkerOptions", new ProvideUberMarkerOptionsProvidesAdapter(paramMapLayerModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.map.UberMap", new ProvideMapProvidesAdapter(paramMapLayerModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.vendor.google.network.DirectionsClient", new ProvideDirectionsClientProvidesAdapter(paramMapLayerModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.map.UberBitmapDescriptorFactory", new ProvideUberBitmapDescriptorFactoryProvidesAdapter(paramMapLayerModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.trip.map.MapPolylineStyle", new ProvideMapPolylineStyleProvidesAdapter(paramMapLayerModule));
  }

  public static final class ProvideDirectionsClientProvidesAdapter extends ProvidesBinding<DirectionsClient>
    implements Provider<DirectionsClient>
  {
    private Binding<Bus> bus;
    private final MapLayerModule module;
    private Binding<OkHttpClient> okHttpClient;

    public ProvideDirectionsClientProvidesAdapter(MapLayerModule paramMapLayerModule)
    {
      super(true, "com.ubercab.client.feature.trip.map.layer.MapLayerModule", "provideDirectionsClient");
      this.module = paramMapLayerModule;
      setLibrary(false);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", MapLayerModule.class, getClass().getClassLoader());
      this.okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", MapLayerModule.class, getClass().getClassLoader());
    }

    public DirectionsClient get()
    {
      return this.module.provideDirectionsClient((Bus)this.bus.get(), (OkHttpClient)this.okHttpClient.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.okHttpClient);
    }
  }

  public static final class ProvideMapPolylineStyleProvidesAdapter extends ProvidesBinding<MapPolylineStyle>
    implements Provider<MapPolylineStyle>
  {
    private Binding<Context> context;
    private final MapLayerModule module;

    public ProvideMapPolylineStyleProvidesAdapter(MapLayerModule paramMapLayerModule)
    {
      super(true, "com.ubercab.client.feature.trip.map.layer.MapLayerModule", "provideMapPolylineStyle");
      this.module = paramMapLayerModule;
      setLibrary(false);
    }

    public void attach(Linker paramLinker)
    {
      this.context = paramLinker.requestBinding("android.content.Context", MapLayerModule.class, getClass().getClassLoader());
    }

    public MapPolylineStyle get()
    {
      return this.module.provideMapPolylineStyle((Context)this.context.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.context);
    }
  }

  public static final class ProvideMapProvidesAdapter extends ProvidesBinding<UberMap>
    implements Provider<UberMap>
  {
    private final MapLayerModule module;

    public ProvideMapProvidesAdapter(MapLayerModule paramMapLayerModule)
    {
      super(true, "com.ubercab.client.feature.trip.map.layer.MapLayerModule", "provideMap");
      this.module = paramMapLayerModule;
      setLibrary(false);
    }

    public UberMap get()
    {
      return this.module.provideMap();
    }
  }

  public static final class ProvideUberBitmapDescriptorFactoryProvidesAdapter extends ProvidesBinding<UberBitmapDescriptorFactory>
    implements Provider<UberBitmapDescriptorFactory>
  {
    private final MapLayerModule module;

    public ProvideUberBitmapDescriptorFactoryProvidesAdapter(MapLayerModule paramMapLayerModule)
    {
      super(true, "com.ubercab.client.feature.trip.map.layer.MapLayerModule", "provideUberBitmapDescriptorFactory");
      this.module = paramMapLayerModule;
      setLibrary(false);
    }

    public UberBitmapDescriptorFactory get()
    {
      return this.module.provideUberBitmapDescriptorFactory();
    }
  }

  public static final class ProvideUberMarkerOptionsProvidesAdapter extends ProvidesBinding<UberMarkerOptions>
    implements Provider<UberMarkerOptions>
  {
    private final MapLayerModule module;

    public ProvideUberMarkerOptionsProvidesAdapter(MapLayerModule paramMapLayerModule)
    {
      super(false, "com.ubercab.client.feature.trip.map.layer.MapLayerModule", "provideUberMarkerOptions");
      this.module = paramMapLayerModule;
      setLibrary(false);
    }

    public UberMarkerOptions get()
    {
      return this.module.provideUberMarkerOptions();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.MapLayerModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */