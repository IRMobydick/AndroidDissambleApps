package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.ApiResponse;
import com.ubercab.client.core.model.EmployeeUpgrade;
import com.ubercab.client.core.model.Ping;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EmployeeUpgradeResponseEvent extends CnApiResponseEvent
{
  private static final String DEFAULT_EMPLOYEE_UPGRADE_BRANCH = "master";
  private static final String KEY_DOWNLOAD_URL = "downloadURL";
  private static final String KEY_RELEASE_NOTES = "releaseNotesHTML";
  private static final String KEY_VERSION = "version";
  private Map<String, EmployeeUpgrade> mEmployeeUpgrades;

  public EmployeeUpgradeResponseEvent(Ping paramPing, Response paramResponse)
  {
    super(paramPing, paramResponse);
    this.mEmployeeUpgrades = new HashMap();
    Map localMap1 = paramPing.getApiResponse().getData();
    if (localMap1 == null);
    label170: 
    while (true)
    {
      return;
      Iterator localIterator = localMap1.keySet().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          break label170;
        String str1 = (String)localIterator.next();
        Map localMap2 = (Map)localMap1.get(str1);
        if (localMap2 == null)
          break;
        String str2 = (String)localMap2.get("downloadURL");
        String str3 = (String)localMap2.get("version");
        String str4 = (String)localMap2.get("releaseNotesHTML");
        if ((str2 == null) || (str3 == null) || (str4 == null))
          break;
        EmployeeUpgrade localEmployeeUpgrade = new EmployeeUpgrade(str2, str3, str4);
        this.mEmployeeUpgrades.put(str1, localEmployeeUpgrade);
      }
    }
  }

  public EmployeeUpgradeResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }

  public EmployeeUpgrade getDefaultEmployeeUpgrade()
  {
    return (EmployeeUpgrade)this.mEmployeeUpgrades.get("master");
  }

  public Map<String, EmployeeUpgrade> getEmployeeUpgrades()
  {
    return this.mEmployeeUpgrades;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.EmployeeUpgradeResponseEvent
 * JD-Core Version:    0.6.2
 */