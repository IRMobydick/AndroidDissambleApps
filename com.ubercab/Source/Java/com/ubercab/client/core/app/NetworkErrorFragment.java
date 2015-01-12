package com.ubercab.client.core.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.event.SignoutEvent;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.PingClientResponseEvent;
import com.ubercab.client.feature.launch.MagicActivity;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class NetworkErrorFragment extends RiderDialogFragment
{

  @InjectView(2131427708)
  UberButton mButtonRetry;

  @InjectView(2131427707)
  LinearLayout mLayoutButtons;

  @InjectView(2131427706)
  ProgressBar mProgressBarRetrying;

  @Inject
  RiderClient mRiderClient;

  @Inject
  SessionPreferences mSessionPreferences;

  @InjectView(2131427705)
  UberTextView mTextViewDescription;

  @InjectView(2131427709)
  UberTextView mTextViewSignOut;

  @InjectView(2131427704)
  UberTextView mTextViewTitle;

  private CharSequence buildSignOutText()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(getString(2131558979).toUpperCase());
    localSpannableStringBuilder.append(" ");
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(getString(2131558916).toUpperCase());
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131296333)), i, localSpannableStringBuilder.length(), 18);
    return localSpannableStringBuilder;
  }

  @OnClick({2131427708})
  public void onClickButtonRetry()
  {
    if (!this.mSessionPreferences.hasToken())
    {
      dismiss();
      return;
    }
    this.mProgressBarRetrying.setVisibility(0);
    this.mLayoutButtons.setVisibility(4);
    this.mLayoutButtons.postDelayed(new Runnable()
    {
      public void run()
      {
        NetworkErrorFragment.this.mRiderClient.pingClient();
      }
    }
    , getResources().getInteger(17694722));
  }

  @OnClick({2131427709})
  public void onClickButtonSignOut()
  {
    RiderApplication.get(getActivity()).signout();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(1, 0);
    setCancelable(false);
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new Dialog(getActivity(), getTheme())
    {
      public boolean onKeyDown(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getRepeatCount() == 0))
        {
          NetworkErrorFragment.this.getActivity().finish();
          return true;
        }
        return super.onKeyDown(paramAnonymousInt, paramAnonymousKeyEvent);
      }
    };
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903170, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  @Subscribe
  public void onPingClientResponseEvent(PingClientResponseEvent paramPingClientResponseEvent)
  {
    if (!paramPingClientResponseEvent.isSuccess())
    {
      this.mLayoutButtons.setVisibility(0);
      this.mProgressBarRetrying.setVisibility(8);
    }
  }

  @Subscribe
  public void onSignoutEvent(SignoutEvent paramSignoutEvent)
  {
    Intent localIntent = new Intent(getActivity(), MagicActivity.class);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    getActivity().finish();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonRetry.setText(getString(2131559111));
    this.mTextViewTitle.setText(getString(2131558896));
    this.mTextViewDescription.setText(getString(2131558895));
    this.mTextViewSignOut.setText(buildSignOutText());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.NetworkErrorFragment
 * JD-Core Version:    0.6.2
 */