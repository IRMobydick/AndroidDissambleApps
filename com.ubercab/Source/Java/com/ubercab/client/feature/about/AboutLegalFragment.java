package com.ubercab.client.feature.about;

import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.ui.SimpleListItem;
import com.ubercab.client.core.ui.SimpleSectionAdapter;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.legal.LegalFragment;
import com.ubercab.library.util.LocationUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

public class AboutLegalFragment extends LegalFragment
{
  private boolean mHasOtherLicenses;
  private boolean mIsZeroTolerance;

  @Inject
  RiderLocationProvider mLocationProvider;

  public static AboutLegalFragment newInstance()
  {
    return new AboutLegalFragment();
  }

  protected List<SimpleListItem> getListItems()
  {
    ArrayList localArrayList = new ArrayList();
    SimpleListItem[] arrayOfSimpleListItem = new SimpleListItem[4];
    arrayOfSimpleListItem[0] = new SimpleListItem(0, getString(2131558525));
    arrayOfSimpleListItem[1] = new SimpleListItem(1, getString(2131559108));
    arrayOfSimpleListItem[2] = new SimpleListItem(2, getString(2131559012));
    arrayOfSimpleListItem[3] = new SimpleListItem(3, getString(2131559075));
    localArrayList.addAll(Arrays.asList(arrayOfSimpleListItem));
    if (this.mHasOtherLicenses)
      localArrayList.add(new SimpleListItem(4, getString(2131558980)));
    if (this.mIsZeroTolerance)
      localArrayList.add(new SimpleListItem(5, getString(2131559354)));
    return localArrayList;
  }

  protected void initializeDisplay()
  {
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    boolean bool1;
    if ((PingUtils.hasTrip(localPing)) && (localPing.getTrip().getIsZeroTolerance()))
    {
      bool1 = true;
      RiderLocation localRiderLocation = this.mLocationProvider.getDeviceLocation();
      if ((!LocationUtils.isInCalifornia(localRiderLocation)) && (!LocationUtils.isInJapan(localRiderLocation)))
        break label85;
    }
    label85: for (boolean bool2 = true; ; bool2 = false)
    {
      if ((this.mAdapterLegal.isEmpty()) || (this.mHasOtherLicenses != bool2) || (this.mIsZeroTolerance != bool1))
        break label91;
      return;
      bool1 = false;
      break;
    }
    label91: this.mHasOtherLicenses = bool2;
    this.mIsZeroTolerance = bool1;
    setupUI();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.AboutLegalFragment
 * JD-Core Version:    0.6.2
 */