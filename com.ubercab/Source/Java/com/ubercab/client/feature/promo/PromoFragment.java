package com.ubercab.client.feature.promo;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.Window.Callback;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import butterknife.Optional;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.ApiResponse;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.ApplyPromoResponseEvent;
import com.ubercab.client.feature.promo.event.PromoCodeAcceptedConfirmedEvent;
import com.ubercab.library.app.UberActivity;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.ConfirmDialogFragment;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import java.util.Map;
import javax.inject.Inject;

public class PromoFragment extends RiderDialogFragment
{
  static final int REQUEST_CODE_CONFIRM_PROMO = 1321;
  public static final String TAG = PromoFragment.class.getName();

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  Bus mBus;

  @InjectView(2131427673)
  UberButton mButtonApply;

  @InjectView(2131427672)
  UberEditText mEditTextCode;

  @InjectView(2131427674)
  ProgressBar mProgressBarLoading;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427671)
  ViewGroup mViewGroupContent;
  private WindowCallbackWrapper mWindowCallbackWrapper;

  private void hideKeyboard()
  {
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextCode);
  }

  public static PromoFragment newInstance()
  {
    return new PromoFragment();
  }

  private void setLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mProgressBarLoading.setVisibility(0);
      this.mViewGroupContent.setVisibility(4);
      return;
    }
    this.mViewGroupContent.setVisibility(0);
    this.mProgressBarLoading.setVisibility(4);
  }

  private void showKeyboard()
  {
    KeyboardUtils.showKeyboard(getActivity(), this.mEditTextCode);
  }

  void applyPromo(boolean paramBoolean)
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PROMO_CODE_SUBMIT);
    String str = this.mEditTextCode.getText().toString();
    if (TextUtils.isEmpty(str))
      return;
    setLoading(true);
    this.mEditTextCode.setError(null);
    this.mRiderClient.applyPromo(str, paramBoolean);
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.PROMO_CODE_ENTER;
  }

  @Subscribe
  public void onApplyPromoResponse(ApplyPromoResponseEvent paramApplyPromoResponseEvent)
  {
    setLoading(false);
    if (paramApplyPromoResponseEvent.hasNetworkError())
      return;
    if (paramApplyPromoResponseEvent.hasPromoConfirmation())
    {
      ConfirmDialogFragment.show((UberActivity)getActivity(), 1321, null, paramApplyPromoResponseEvent.getConfirmationMessage(), paramApplyPromoResponseEvent.getConfirmText(), paramApplyPromoResponseEvent.getDenyText());
      return;
    }
    final String str1 = paramApplyPromoResponseEvent.getErrorMessage();
    if (!TextUtils.isEmpty(str1))
    {
      this.mEditTextCode.postDelayed(new Runnable()
      {
        public void run()
        {
          PromoFragment.this.mEditTextCode.setError(str1);
        }
      }
      , getResources().getInteger(17694720));
      return;
    }
    this.mEditTextCode.setError(null);
    this.mEditTextCode.setText(null);
    Map localMap = ((Ping)paramApplyPromoResponseEvent.getModel()).getApiResponse().getData();
    String str2 = null;
    if (localMap != null)
      str2 = (String)localMap.get("description");
    new AlertDialog.Builder(getActivity()).setMessage(str2).setTitle(getString(2131559014)).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        PromoFragment.this.hideKeyboard();
        PromoFragment.this.mBus.post(new PromoCodeAcceptedConfirmedEvent());
      }
    }).show();
  }

  @OnClick({2131427673})
  public void onClickApply()
  {
    applyPromo(false);
  }

  @OnClick({2131427675})
  @Optional
  public void onClickCancel()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PROMO_CODE_CANCEL);
    hideKeyboard();
    dismiss();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(1, 16973942);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView;
    if (getDialog() == null)
      localView = paramLayoutInflater.inflate(2130903159, paramViewGroup, false);
    while (true)
    {
      ButterKnife.inject(this, localView);
      return localView;
      localView = paramLayoutInflater.inflate(2130903160, paramViewGroup, false);
      Window localWindow = getActivity().getWindow();
      this.mWindowCallbackWrapper = new WindowCallbackWrapper(localWindow.getCallback())
      {
        public void onWindowFocusChanged(boolean paramAnonymousBoolean)
        {
          if ((!paramAnonymousBoolean) && (PromoFragment.this.mEditTextCode != null) && (PromoFragment.this.mEditTextCode.hasFocus()))
            PromoFragment.this.showKeyboard();
        }
      };
      localWindow.setCallback(this.mWindowCallbackWrapper);
    }
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.mWindowCallbackWrapper != null)
      getActivity().getWindow().setCallback(this.mWindowCallbackWrapper.getOriginalCallback());
    ButterKnife.reset(this);
  }

  @OnEditorAction({2131427672})
  public boolean onEditorActionCode()
  {
    applyPromo(false);
    return true;
  }

  public void onPause()
  {
    super.onPause();
    hideKeyboard();
  }

  public void onResume()
  {
    super.onResume();
    this.mEditTextCode.requestFocus();
  }

  public void onStop()
  {
    KeyboardUtils.hideKeyboard(getActivity());
    super.onStop();
  }

  @OnTextChanged({2131427672})
  public void onTextChangedPromo(CharSequence paramCharSequence)
  {
    UberButton localUberButton = this.mButtonApply;
    if (!TextUtils.isEmpty(this.mEditTextCode.getText()));
    for (boolean bool = true; ; bool = false)
    {
      localUberButton.setEnabled(bool);
      return;
    }
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.mEditTextCode.setHint(getString(2131558844));
    this.mButtonApply.setText(getString(2131558450));
    UberButton localUberButton = this.mButtonApply;
    if (!TextUtils.isEmpty(this.mEditTextCode.getText()));
    for (boolean bool = true; ; bool = false)
    {
      localUberButton.setEnabled(bool);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.promo.PromoFragment
 * JD-Core Version:    0.6.2
 */