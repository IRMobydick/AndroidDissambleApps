package com.ubercab.client.feature.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.MusicProvider;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.util.PingUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MusicProviderAdapter extends BaseAdapter
{
  private final Bus mBus;
  private final LayoutInflater mLayoutInflater;
  private final List<MusicProvider> mProviders;

  public MusicProviderAdapter(Context paramContext, Bus paramBus, List<MusicProvider> paramList)
  {
    this.mBus = paramBus;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mProviders = paramList;
  }

  private View createView(MusicProvider paramMusicProvider, ViewGroup paramViewGroup)
  {
    View localView = this.mLayoutInflater.inflate(2130903157, paramViewGroup, false);
    localView.setTag(new ViewHolder(paramMusicProvider, localView));
    return localView;
  }

  public int getCount()
  {
    return this.mProviders.size();
  }

  public Object getItem(int paramInt)
  {
    return this.mProviders.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return ((MusicProvider)this.mProviders.get(paramInt)).hashCode();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MusicProvider localMusicProvider = (MusicProvider)getItem(paramInt);
    if (paramView == null)
      paramView = createView(localMusicProvider, paramViewGroup);
    ((ViewHolder)paramView.getTag()).update(localMusicProvider);
    return paramView;
  }

  public void update(Ping paramPing)
  {
    if (PingUtils.hasClient(paramPing))
    {
      Map localMap = paramPing.getClient().getThirdPartyIdentities();
      if (localMap != null)
      {
        Set localSet = localMap.keySet();
        Iterator localIterator = this.mProviders.iterator();
        while (localIterator.hasNext())
        {
          MusicProvider localMusicProvider = (MusicProvider)localIterator.next();
          localMusicProvider.setLinked(localSet.contains(localMusicProvider.getId()));
        }
        notifyDataSetChanged();
      }
    }
  }

  class ViewHolder
  {
    private MusicProvider mMusicProvider;

    @InjectView(2131427669)
    TextView mTextViewStatus;

    ViewHolder(MusicProvider paramView, View arg3)
    {
      this.mMusicProvider = paramView;
      View localView;
      ButterKnife.inject(this, localView);
      update(this.mMusicProvider);
    }

    @OnClick({2131427668})
    public void onClickProvider()
    {
      MusicProviderAdapter.this.mBus.post(new MusicProviderSelectedEvent(this.mMusicProvider));
    }

    void update(MusicProvider paramMusicProvider)
    {
      this.mMusicProvider = paramMusicProvider;
      String str1 = this.mMusicProvider.getName();
      this.mTextViewStatus.setText(str1);
      Context localContext = this.mTextViewStatus.getContext();
      boolean bool = this.mMusicProvider.isLinked();
      if (bool);
      for (String str2 = localContext.getString(2131558419, new Object[] { str1 }); ; str2 = localContext.getString(2131558516, new Object[] { str1 }))
      {
        this.mTextViewStatus.setText(str2);
        this.mTextViewStatus.setSelected(bool);
        return;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderAdapter
 * JD-Core Version:    0.6.2
 */