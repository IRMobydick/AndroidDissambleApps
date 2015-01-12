package com.ubercab.client.feature.trip.slider;

import android.text.TextUtils;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

class VehicleViewGroup
{
  static final GroupingStrategy SLIDER_STRATEGY_STACKED_DEFAULT = GroupingStrategy.PARENTS;
  private final String mGroupId;
  private Map<String, NearbyVehicle> mNearbyVehicles;
  private final GroupingStrategy mStrategy;
  private final List<VehicleView> mVehicleViews = new CopyOnWriteArrayList();

  VehicleViewGroup(String paramString, GroupingStrategy paramGroupingStrategy)
  {
    this.mGroupId = paramString;
    this.mStrategy = paramGroupingStrategy;
  }

  private boolean checkBelongsToGroup(VehicleView paramVehicleView)
  {
    switch (4.$SwitchMap$com$ubercab$client$feature$trip$slider$VehicleViewGroup$GroupingStrategy[this.mStrategy.ordinal()])
    {
    default:
    case 1:
    case 2:
      do
      {
        return false;
        return this.mGroupId.equals(paramVehicleView.getId());
      }
      while ((!this.mGroupId.equals(paramVehicleView.getId())) && (!this.mGroupId.equals(paramVehicleView.getParentId())));
      return true;
    case 3:
    }
    return this.mGroupId.equals(paramVehicleView.getGroupId());
  }

  protected static List<VehicleViewGroup> createGroups(List<String> paramList, Map<String, VehicleView> paramMap, Map<String, NearbyVehicle> paramMap1, GroupingStrategy paramGroupingStrategy)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
      localArrayList.add(paramMap.get((String)localIterator1.next()));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      VehicleView localVehicleView = (VehicleView)localIterator2.next();
      String str = extractGroupKey(paramGroupingStrategy, localVehicleView, paramMap);
      if (!localLinkedHashMap.containsKey(str))
        localLinkedHashMap.put(str, new VehicleViewGroup(str, paramGroupingStrategy));
      VehicleViewGroup localVehicleViewGroup = (VehicleViewGroup)localLinkedHashMap.get(str);
      localVehicleViewGroup.addVehicleView(localVehicleView);
      localVehicleViewGroup.setNearbyVehicles(paramMap1);
    }
    return new ArrayList(localLinkedHashMap.values());
  }

  protected static GroupingStrategy deriveGroupingStrategy(String paramString)
  {
    if (paramString == null)
      return GroupingStrategy.NONE;
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1897640665:
    case 2022204538:
    case 1442898095:
    }
    while (true)
      switch (i)
      {
      default:
        return GroupingStrategy.NONE;
        if (paramString.equals("stacked"))
        {
          i = 0;
          continue;
          if (paramString.equals("stacked_use_parent"))
          {
            i = 1;
            continue;
            if (paramString.equals("stacked_use_group"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    return SLIDER_STRATEGY_STACKED_DEFAULT;
    return GroupingStrategy.PARENTS;
    return GroupingStrategy.GROUPS;
  }

  protected static String extractGroupKey(GroupingStrategy paramGroupingStrategy, VehicleView paramVehicleView, Map<String, VehicleView> paramMap)
  {
    switch (4.$SwitchMap$com$ubercab$client$feature$trip$slider$VehicleViewGroup$GroupingStrategy[paramGroupingStrategy.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unknown strategy: " + paramGroupingStrategy);
    case 1:
      return paramVehicleView.getId();
    case 2:
      String str = paramVehicleView.getParentId();
      if ((TextUtils.isEmpty(str)) || (!paramMap.containsKey(str)))
        str = paramVehicleView.getId();
      paramVehicleView.setGroupId(str);
      return str;
    case 3:
    }
    return paramVehicleView.getGroupId();
  }

  static List<VehicleViewGroup> extractVehicleViewGroups(Ping paramPing)
  {
    Object localObject1 = paramPing.getCity().getVehicleViewsOrder();
    if (localObject1 == null)
      localObject1 = new ArrayList();
    Map localMap = paramPing.getNearbyVehicles();
    Object localObject2 = paramPing.getCity().getVehicleViews();
    if (localObject2 == null)
      localObject2 = new HashMap();
    RiderAppConfig localRiderAppConfig = paramPing.getAppConfig().getRiderConfig();
    if (localRiderAppConfig == null);
    for (String str = null; ; str = localRiderAppConfig.getSliderStyle())
      return createGroups((List)localObject1, (Map)localObject2, localMap, deriveGroupingStrategy(str));
  }

  private Predicate<VehicleView> findVehiclePredicate(final String paramString)
  {
    return new Predicate()
    {
      public boolean apply(VehicleView paramAnonymousVehicleView)
      {
        return paramAnonymousVehicleView.getId().equals(paramString);
      }
    };
  }

  void addVehicleView(VehicleView paramVehicleView)
  {
    if (!checkBelongsToGroup(paramVehicleView))
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramVehicleView.getId();
      arrayOfObject[1] = paramVehicleView.getGroupId();
      arrayOfObject[2] = this.mGroupId;
      arrayOfObject[3] = this.mStrategy;
      throw new IllegalArgumentException(String.format("[%s / %s] does not belong in %s for %s", arrayOfObject));
    }
    if ((GroupingStrategy.PARENTS == this.mStrategy) && (this.mGroupId.equals(paramVehicleView.getId())))
    {
      this.mVehicleViews.add(0, paramVehicleView);
      return;
    }
    this.mVehicleViews.add(paramVehicleView);
  }

  VehicleView findVehicleView(String paramString)
  {
    return (VehicleView)Iterables.tryFind(this.mVehicleViews, findVehiclePredicate(paramString)).orNull();
  }

  public String getDescription()
  {
    VehicleView localVehicleView = getPrimary();
    if ((this.mVehicleViews == null) || (this.mVehicleViews.isEmpty()))
      return null;
    if (this.mStrategy != GroupingStrategy.GROUPS)
      return localVehicleView.getDescription();
    return localVehicleView.getGroupDisplayName();
  }

  public VehicleView getPrimary()
  {
    switch (4.$SwitchMap$com$ubercab$client$feature$trip$slider$VehicleViewGroup$GroupingStrategy[this.mStrategy.ordinal()])
    {
    default:
      return findVehicleView(this.mGroupId);
    case 3:
    }
    if ((this.mVehicleViews == null) || (this.mVehicleViews.isEmpty()))
      return null;
    return (VehicleView)this.mVehicleViews.get(0);
  }

  public String getPrimaryVehicleId()
  {
    return getPrimary().getId();
  }

  List<VehicleView> getVehicleViews()
  {
    return this.mVehicleViews;
  }

  boolean hasMultiple()
  {
    return this.mVehicleViews.size() > 1;
  }

  boolean hasVehicleView(String paramString)
  {
    return Iterables.any(this.mVehicleViews, findVehiclePredicate(paramString));
  }

  public int indexOfVehicle(String paramString)
  {
    return Iterables.indexOf(this.mVehicleViews, findVehiclePredicate(paramString));
  }

  boolean isAvailable()
  {
    return Iterables.any(this.mVehicleViews, new Predicate()
    {
      public boolean apply(VehicleView paramAnonymousVehicleView)
      {
        return VehicleViewGroup.this.isVehicleViewAvailable(paramAnonymousVehicleView.getId());
      }
    });
  }

  boolean isSurging()
  {
    return Iterables.all(this.mVehicleViews, new Predicate()
    {
      public boolean apply(VehicleView paramAnonymousVehicleView)
      {
        return paramAnonymousVehicleView.isSurging();
      }
    });
  }

  boolean isVehicleViewAvailable(String paramString)
  {
    NearbyVehicle localNearbyVehicle = (NearbyVehicle)this.mNearbyVehicles.get(paramString);
    return (localNearbyVehicle != null) && (localNearbyVehicle.getVehiclePaths() != null) && (!localNearbyVehicle.getVehiclePaths().isEmpty());
  }

  void setNearbyVehicles(Map<String, NearbyVehicle> paramMap)
  {
    this.mNearbyVehicles = paramMap;
  }

  static enum GroupingStrategy
  {
    static
    {
      NONE = new GroupingStrategy("NONE", 2);
      GroupingStrategy[] arrayOfGroupingStrategy = new GroupingStrategy[3];
      arrayOfGroupingStrategy[0] = GROUPS;
      arrayOfGroupingStrategy[1] = PARENTS;
      arrayOfGroupingStrategy[2] = NONE;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleViewGroup
 * JD-Core Version:    0.6.2
 */