package com.ubercab.library.metrics.analytics.logging;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.ubercab.common.collect.EvictingQueue;
import com.ubercab.library.metrics.analytics.Analytics;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import java.util.Map;

public class AnalyticsEventListActivity extends ListActivity
{
  private ListView mListView;
  private Object[] mLoggedEvents;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mLoggedEvents = Analytics.getInstance().getAnalyticsClient().getLoggedEvents().toArray();
    setListAdapter(new ListAdapter(null));
  }

  private class ListAdapter extends BaseAdapter
  {
    private ListAdapter()
    {
    }

    public int getCount()
    {
      return AnalyticsEventListActivity.this.mLoggedEvents.length;
    }

    public Map<String, Object> getItem(int paramInt)
    {
      return (Map)AnalyticsEventListActivity.this.mLoggedEvents[paramInt];
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
        paramView = AnalyticsEventListActivity.this.getLayoutInflater().inflate(17367044, paramViewGroup, false);
      TextView localTextView1 = (TextView)paramView.findViewById(16908308);
      TextView localTextView2 = (TextView)paramView.findViewById(16908309);
      Map localMap = getItem(paramInt);
      localTextView1.setText(localMap.get("name").toString());
      localTextView2.setText(localMap.get("type").toString());
      return paramView;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.analytics.logging.AnalyticsEventListActivity
 * JD-Core Version:    0.6.2
 */