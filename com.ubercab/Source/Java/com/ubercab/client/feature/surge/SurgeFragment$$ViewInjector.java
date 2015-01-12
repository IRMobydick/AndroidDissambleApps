package com.ubercab.client.feature.surge;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.DiscreteCharacterInputLayout;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class SurgeFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SurgeFragment paramSurgeFragment, Object paramObject)
  {
    View localView1 = paramFinder.findOptionalView(paramObject, 2131427796);
    paramSurgeFragment.mAcceptButton = ((UberButton)localView1);
    if (localView1 != null)
      localView1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          this.val$target.onAcceptClick();
        }
      });
    paramSurgeFragment.mAndOrText = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427841));
    paramSurgeFragment.mSobrietyMyFare = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427800));
    paramSurgeFragment.mSurgeRationaleTextView = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427793));
    paramSurgeFragment.mRateExpirationTextView = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427798));
    paramSurgeFragment.mSafeRidesFeeModule = ((LinearLayout)paramFinder.findOptionalView(paramObject, 2131427843));
    View localView2 = paramFinder.findOptionalView(paramObject, 2131427797);
    paramSurgeFragment.mNotificationButton = ((UberButton)localView2);
    if (localView2 != null)
      localView2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          this.val$target.onSurgeNotificationClick();
        }
      });
    paramSurgeFragment.mSafeRidesFee = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427844));
    paramSurgeFragment.mMultiplierTextView = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427845));
    paramSurgeFragment.mMinimumFareTextView = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427839));
    paramSurgeFragment.mSobrietyNormalRate = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427802));
    paramSurgeFragment.mMinuteFareTextView = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427840));
    paramSurgeFragment.mSobrietyInstructions = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427799));
    paramSurgeFragment.mDistanceFareTextView = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427842));
    paramSurgeFragment.mMultiplierRateTextView = ((UberTextView)paramFinder.findOptionalView(paramObject, 2131427846));
    paramSurgeFragment.mSobrietyMultiplierLayout = ((DiscreteCharacterInputLayout)paramFinder.findOptionalView(paramObject, 2131427801));
  }

  public static void reset(SurgeFragment paramSurgeFragment)
  {
    paramSurgeFragment.mAcceptButton = null;
    paramSurgeFragment.mAndOrText = null;
    paramSurgeFragment.mSobrietyMyFare = null;
    paramSurgeFragment.mSurgeRationaleTextView = null;
    paramSurgeFragment.mRateExpirationTextView = null;
    paramSurgeFragment.mSafeRidesFeeModule = null;
    paramSurgeFragment.mNotificationButton = null;
    paramSurgeFragment.mSafeRidesFee = null;
    paramSurgeFragment.mMultiplierTextView = null;
    paramSurgeFragment.mMinimumFareTextView = null;
    paramSurgeFragment.mSobrietyNormalRate = null;
    paramSurgeFragment.mMinuteFareTextView = null;
    paramSurgeFragment.mSobrietyInstructions = null;
    paramSurgeFragment.mDistanceFareTextView = null;
    paramSurgeFragment.mMultiplierRateTextView = null;
    paramSurgeFragment.mSobrietyMultiplierLayout = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.surge.SurgeFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */