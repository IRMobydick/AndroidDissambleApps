package com.ubercab.client.feature.forceupgrade;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class ForceUpgradeFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ForceUpgradeFragment paramForceUpgradeFragment, Object paramObject)
  {
    paramForceUpgradeFragment.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427475, "field 'mTextViewTitle'"));
    paramForceUpgradeFragment.mTextViewSubtitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427476, "field 'mTextViewSubtitle'"));
    View localView = paramFinder.findRequiredView(paramObject, 2131427477, "field 'mButtonUpdate' and method 'onClickButtonUpdate'");
    paramForceUpgradeFragment.mButtonUpdate = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonUpdate();
      }
    });
  }

  public static void reset(ForceUpgradeFragment paramForceUpgradeFragment)
  {
    paramForceUpgradeFragment.mTextViewTitle = null;
    paramForceUpgradeFragment.mTextViewSubtitle = null;
    paramForceUpgradeFragment.mButtonUpdate = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.forceupgrade.ForceUpgradeFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */