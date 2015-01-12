package com.ubercab.client.feature.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.ShareEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.ui.RiderGridView;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class ShareFragment extends RiderFragment
  implements View.OnClickListener
{
  private IntentAdapter mAdapterIntents;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @InjectView(2131427700)
  RiderGridView mGridViewIntents;

  @Inject
  LayoutInflater mLayoutInflater;
  private FooterViewHolder mViewHolderFooter;
  private HeaderViewHolder mViewHolderHeader;

  public void onClick(View paramView)
  {
    if (paramView == this.mViewHolderFooter.mView)
    {
      this.mAdapterIntents.showAll();
      this.mGridViewIntents.removeFooterView(paramView);
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903167, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @OnItemClick({2131427700})
  public void onItemClickIntentGridView(int paramInt)
  {
    LabeledIntent localLabeledIntent = (LabeledIntent)this.mGridViewIntents.getItemAtPosition(paramInt);
    CharSequence localCharSequence;
    if (localLabeledIntent != null)
    {
      localLabeledIntent.setFlags(268435456);
      startActivity(new Intent(localLabeledIntent));
      localCharSequence = localLabeledIntent.getNonLocalizedLabel();
      if (localCharSequence != null)
        break label63;
    }
    label63: for (String str = "Unknown"; ; str = localCharSequence.toString())
    {
      this.mAnalyticsManager.shareEvent().shareNative(str);
      return;
    }
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Client localClient = paramPingEvent.getPing().getClient();
    this.mViewHolderHeader.update(localClient);
    if (this.mAdapterIntents == null)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localClient.getPromotion();
      String str1 = getString(2131559063, arrayOfObject1);
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = localClient.getReferralCode();
      arrayOfObject2[1] = localClient.getPromotion();
      arrayOfObject2[2] = localClient.getReferralUrl();
      String str2 = getString(2131559062, arrayOfObject2);
      this.mAdapterIntents = new IntentAdapter(getActivity(), str1, str2, localClient.getMobileCountryIso2());
      this.mGridViewIntents.setAdapter(this.mAdapterIntents);
      if ((this.mAdapterIntents.getTotalCount() <= 6) && (this.mGridViewIntents.getFooterViewCount() > 0))
        this.mGridViewIntents.removeFooterView(this.mViewHolderFooter.mView);
    }
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    View localView1 = this.mLayoutInflater.inflate(2130903169, this.mGridViewIntents, false);
    this.mViewHolderHeader = new HeaderViewHolder(localView1);
    this.mGridViewIntents.addHeaderView(localView1, null, false);
    View localView2 = this.mLayoutInflater.inflate(2130903168, this.mGridViewIntents, false);
    this.mViewHolderFooter = new FooterViewHolder(localView2, this);
    this.mGridViewIntents.addFooterView(localView2, null, false);
  }

  static class FooterViewHolder
  {

    @InjectView(2131427701)
    UberTextView mTextViewSeeMore;
    private View mView;

    public FooterViewHolder(View paramView, View.OnClickListener paramOnClickListener)
    {
      this.mView = paramView;
      ButterKnife.inject(this, paramView);
      this.mTextViewSeeMore.setText(paramView.getContext().getString(2131559046));
      paramView.setOnClickListener(paramOnClickListener);
    }
  }

  static class HeaderViewHolder
  {
    private final Context mContext;

    @InjectView(2131427703)
    UberTextView mTextViewCode;

    @InjectView(2131427702)
    UberTextView mTextViewDescription;

    @InjectView(2131427928)
    UberTextView mTextViewSectionHeader;

    public HeaderViewHolder(View paramView)
    {
      ButterKnife.inject(this, paramView);
      this.mContext = paramView.getContext();
      this.mTextViewSectionHeader.setText(this.mContext.getString(2131559064));
    }

    public void update(Client paramClient)
    {
      this.mTextViewCode.setText(paramClient.getReferralCode().toUpperCase());
      SpannableString localSpannableString = new SpannableString(paramClient.getPromotion());
      localSpannableString.setSpan(new StyleSpan(1), 0, localSpannableString.length(), 18);
      String str = this.mContext.getString(2131559059, new Object[] { localSpannableString });
      this.mTextViewDescription.setText(str);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.share.ShareFragment
 * JD-Core Version:    0.6.2
 */