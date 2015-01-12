package com.ubercab.client.feature.share;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ubercab.client.core.locale.Regions;
import com.ubercab.common.base.Function;
import com.ubercab.common.collect.ImmutableList.Builder;
import com.ubercab.common.collect.ImmutableMap.Builder;
import com.ubercab.common.collect.Iterables;
import com.ubercab.common.collect.Lists;
import com.ubercab.library.util.StringUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

class IntentAdapter extends BaseAdapter
{
  private static final List<String> DEFAULT_PRIORITY_PACKAGE_NAMES = new ImmutableList.Builder().add("com.google.android.apps.plus").add("com.google.android.gm").add("com.google.android.talk").add("com.facebook.katana").add("com.twitter.android").add("com.android.mms").add("com.facebook.orca").add("com.whatsapp").build();
  public static final int NUM_DISPLAY_PRIORITY_PACKAGES = 6;
  private static Map<Regions, List<String>> PRIORITY_PACKAGE_NAMES_BY_COUNTRY = new ImmutableMap.Builder().put(Regions.CHINA, new ImmutableList.Builder().add("com.tencent.mm").add("com.sina.weibo").build()).put(Regions.JAPAN, new ImmutableList.Builder().add("jp.naver.line.android").build()).put(Regions.TAIWAN, new ImmutableList.Builder().add("jp.naver.line.android").build()).put(Regions.KOREA, new ImmutableList.Builder().add("com.kakao.talk").build()).build();
  private List<LabeledIntent> mAllIntents;
  private List<LabeledIntent> mIntents;
  private LayoutInflater mLayoutInflater;
  private PackageManager mPackageManager;

  IntentAdapter(Context paramContext, final String paramString1, final String paramString2, String paramString3)
  {
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    List localList = this.mPackageManager.queryIntentActivities(localIntent, 0);
    Collections.sort(localList, new ResolveInfoComparator(this.mPackageManager, paramString3));
    this.mAllIntents = Lists.newArrayList(Iterables.transform(localList, new Function()
    {
      public LabeledIntent apply(ResolveInfo paramAnonymousResolveInfo)
      {
        ActivityInfo localActivityInfo = paramAnonymousResolveInfo.activityInfo;
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.SEND");
        localIntent.setType("text/plain");
        localIntent.putExtra("android.intent.extra.SUBJECT", paramString1);
        localIntent.putExtra("android.intent.extra.TEXT", StringUtils.trimPeriod(paramString2));
        localIntent.setComponent(new ComponentName(localActivityInfo.packageName, localActivityInfo.name));
        return new LabeledIntent(localIntent, localActivityInfo.packageName, localActivityInfo.loadLabel(IntentAdapter.this.mPackageManager), paramAnonymousResolveInfo.getIconResource());
      }
    }));
    this.mIntents = this.mAllIntents.subList(0, Math.min(this.mAllIntents.size(), 6));
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.mIntents.size();
  }

  public LabeledIntent getItem(int paramInt)
  {
    return (LabeledIntent)this.mIntents.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getTotalCount()
  {
    return this.mAllIntents.size();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.mLayoutInflater.inflate(2130903172, paramViewGroup, false);
    LabeledIntent localLabeledIntent = getItem(paramInt);
    ((ImageView)paramView.findViewById(2131427711)).setImageDrawable(localLabeledIntent.loadIcon(this.mPackageManager));
    ((TextView)paramView.findViewById(2131427712)).setText(localLabeledIntent.loadLabel(this.mPackageManager));
    return paramView;
  }

  public void showAll()
  {
    this.mIntents = this.mAllIntents;
    notifyDataSetChanged();
  }

  private static class ResolveInfoComparator
    implements Comparator<ResolveInfo>
  {
    private Collator mCollator = Collator.getInstance();
    private List<String> mCountrySpecificPriorityNames;
    private PackageManager mPackageManager;

    public ResolveInfoComparator(PackageManager paramPackageManager, String paramString)
    {
      this.mPackageManager = paramPackageManager;
      this.mCollator.setStrength(0);
      this.mCountrySpecificPriorityNames = new ArrayList(IntentAdapter.DEFAULT_PRIORITY_PACKAGE_NAMES);
      List localList = (List)IntentAdapter.PRIORITY_PACKAGE_NAMES_BY_COUNTRY.get(Regions.fromIso2(paramString));
      if (localList != null)
        this.mCountrySpecificPriorityNames.addAll(0, localList);
    }

    public final int compare(ResolveInfo paramResolveInfo1, ResolveInfo paramResolveInfo2)
    {
      String str1 = paramResolveInfo1.activityInfo.packageName;
      String str2 = paramResolveInfo2.activityInfo.packageName;
      if ((this.mCountrySpecificPriorityNames.contains(str1)) && (this.mCountrySpecificPriorityNames.contains(str2)))
      {
        int i = this.mCountrySpecificPriorityNames.indexOf(str1);
        int j = this.mCountrySpecificPriorityNames.indexOf(str2);
        return Integer.valueOf(i).compareTo(Integer.valueOf(j));
      }
      if ((this.mCountrySpecificPriorityNames.contains(str1)) && (!this.mCountrySpecificPriorityNames.contains(str2)))
        return -1;
      if ((!this.mCountrySpecificPriorityNames.contains(str1)) && (this.mCountrySpecificPriorityNames.contains(str2)))
        return 1;
      Object localObject1 = paramResolveInfo1.loadLabel(this.mPackageManager);
      if (localObject1 == null)
        localObject1 = paramResolveInfo1.activityInfo.name;
      Object localObject2 = paramResolveInfo2.loadLabel(this.mPackageManager);
      if (localObject2 == null)
        localObject2 = paramResolveInfo2.activityInfo.name;
      return this.mCollator.compare(((CharSequence)localObject1).toString(), ((CharSequence)localObject2).toString());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.share.IntentAdapter
 * JD-Core Version:    0.6.2
 */