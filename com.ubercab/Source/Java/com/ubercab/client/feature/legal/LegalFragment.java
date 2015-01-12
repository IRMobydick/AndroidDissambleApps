package com.ubercab.client.feature.legal;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.ui.SimpleListItem;
import com.ubercab.client.core.ui.SimpleSectionAdapter;
import com.ubercab.client.core.util.UrlUtils;
import com.ubercab.client.feature.about.event.SelectOtherEvent;
import com.ubercab.client.feature.about.event.SelectWebViewEvent;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import java.util.List;
import javax.inject.Inject;

public abstract class LegalFragment extends RiderFragment
{
  protected static final int ITEM_COPYRIGHT = 0;
  protected static final int ITEM_OTHER = 4;
  protected static final int ITEM_PRIVACY = 2;
  protected static final int ITEM_SOFTWARE = 3;
  protected static final int ITEM_TERMS = 1;
  protected static final int ITEM_ZERO_TOLERANCE = 5;

  @Inject
  ActionBar mActionBar;
  protected SimpleSectionAdapter mAdapterLegal;

  @Inject
  Bus mBus;

  @InjectView(2131427478)
  ListView mListView;

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.LEGAL;
  }

  protected abstract List<SimpleListItem> getListItems();

  protected void initializeDisplay()
  {
    setupUI();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903090, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    ButterKnife.reset(this);
  }

  @OnItemClick({2131427478})
  public void onItemClickLegal(int paramInt)
  {
    switch (this.mAdapterLegal.getItem(paramInt).getId())
    {
    default:
      return;
    case 0:
      String str7 = getString(2131558525);
      String str8 = UrlUtils.localizeUrl("https://www.uber.com/legal/%s/copyright?plain=true");
      this.mBus.post(new SelectWebViewEvent(str7, str8));
      return;
    case 1:
      String str5 = getString(2131559107);
      String str6 = UrlUtils.localizeUrl("https://www.uber.com/legal/%s/terms?plain=true");
      RiderEvents.Impression localImpression2 = RiderEvents.Impression.TERMS_AND_CONDITIONS;
      this.mBus.post(new SelectWebViewEvent(str5, str6, localImpression2));
      return;
    case 2:
      String str3 = getString(2131559012);
      String str4 = UrlUtils.localizeUrl("https://www.uber.com/legal/%s/privacy?plain=true");
      RiderEvents.Impression localImpression1 = RiderEvents.Impression.PRIVACY_POLICY;
      this.mBus.post(new SelectWebViewEvent(str3, str4, localImpression1));
      return;
    case 3:
      String str2 = getString(2131559075);
      this.mBus.post(new SelectWebViewEvent(str2, "file:///android_asset/licenses/licenses.html"));
      return;
    case 4:
      this.mBus.post(new SelectOtherEvent());
      return;
    case 5:
    }
    String str1 = getString(2131559355);
    this.mBus.post(new SelectWebViewEvent(str1, "https://www.uber.com/report-issue"));
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558906));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mAdapterLegal = new SimpleSectionAdapter(getActivity());
    this.mListView.setAdapter(this.mAdapterLegal);
    this.mListView.setDrawSelectorOnTop(true);
    this.mListView.setDivider(null);
    this.mListView.setDividerHeight(0);
    this.mActionBar.setDisplayHomeAsUpEnabled(true);
    initializeDisplay();
  }

  protected void setupUI()
  {
    List localList = getListItems();
    if ((!this.mAdapterLegal.isEmpty()) || (localList == null) || (localList.isEmpty()))
      return;
    this.mAdapterLegal.update(localList);
    this.mAdapterLegal.notifyDataSetChanged();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.legal.LegalFragment
 * JD-Core Version:    0.6.2
 */