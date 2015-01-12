package com.ubercab.client.feature.employeeupgrade;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class EmployeeUpgradeFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, EmployeeUpgradeFragment paramEmployeeUpgradeFragment, Object paramObject)
  {
    paramEmployeeUpgradeFragment.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427927, "field 'mTextViewTitle'"));
    paramEmployeeUpgradeFragment.mTextViewSubtitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427430, "field 'mTextViewSubtitle'"));
    paramEmployeeUpgradeFragment.mTextViewChangelog = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427431, "field 'mTextViewChangelog'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427432, "field 'mButtonSkip' and method 'skipTapped'");
    paramEmployeeUpgradeFragment.mButtonSkip = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.skipTapped();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427433, "field 'mButtonUpdate' and method 'updateTapped'");
    paramEmployeeUpgradeFragment.mButtonUpdate = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.updateTapped();
      }
    });
  }

  public static void reset(EmployeeUpgradeFragment paramEmployeeUpgradeFragment)
  {
    paramEmployeeUpgradeFragment.mTextViewTitle = null;
    paramEmployeeUpgradeFragment.mTextViewSubtitle = null;
    paramEmployeeUpgradeFragment.mTextViewChangelog = null;
    paramEmployeeUpgradeFragment.mButtonSkip = null;
    paramEmployeeUpgradeFragment.mButtonUpdate = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */