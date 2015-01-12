package com.ubercab.client.core.app;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class NetworkErrorFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, NetworkErrorFragment paramNetworkErrorFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427708, "field 'mButtonRetry' and method 'onClickButtonRetry'");
    paramNetworkErrorFragment.mButtonRetry = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonRetry();
      }
    });
    paramNetworkErrorFragment.mLayoutButtons = ((LinearLayout)paramFinder.findRequiredView(paramObject, 2131427707, "field 'mLayoutButtons'"));
    paramNetworkErrorFragment.mProgressBarRetrying = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427706, "field 'mProgressBarRetrying'"));
    paramNetworkErrorFragment.mTextViewDescription = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427705, "field 'mTextViewDescription'"));
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427709, "field 'mTextViewSignOut' and method 'onClickButtonSignOut'");
    paramNetworkErrorFragment.mTextViewSignOut = ((UberTextView)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonSignOut();
      }
    });
    paramNetworkErrorFragment.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427704, "field 'mTextViewTitle'"));
  }

  public static void reset(NetworkErrorFragment paramNetworkErrorFragment)
  {
    paramNetworkErrorFragment.mButtonRetry = null;
    paramNetworkErrorFragment.mLayoutButtons = null;
    paramNetworkErrorFragment.mProgressBarRetrying = null;
    paramNetworkErrorFragment.mTextViewDescription = null;
    paramNetworkErrorFragment.mTextViewSignOut = null;
    paramNetworkErrorFragment.mTextViewTitle = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.NetworkErrorFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */