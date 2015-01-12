package com.ubercab.client.feature.about;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class AboutFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AboutFragment paramAboutFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427415, "field 'mListViewAbout' and method 'onItemClickAbout'");
    paramAboutFragment.mListViewAbout = ((ListView)localView);
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        this.val$target.onItemClickAbout(paramAnonymousInt);
      }
    });
    paramAboutFragment.mTextViewVersionNumber = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427416, "field 'mTextViewVersionNumber'"));
  }

  public static void reset(AboutFragment paramAboutFragment)
  {
    paramAboutFragment.mListViewAbout = null;
    paramAboutFragment.mTextViewVersionNumber = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.AboutFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */