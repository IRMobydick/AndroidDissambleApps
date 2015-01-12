package com.ubercab.client.feature.mobilemessage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.crashlytics.android.Crashlytics;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPopupWindow;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.core.model.MobileMessageModule;
import com.ubercab.client.core.ui.AnimationListenerAdapter;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.feature.trip.slider.VehicleTextBitmap;
import com.ubercab.client.feature.trip.slider.VehicleTextBitmapsEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsEvent;
import com.ubercab.library.metrics.analytics.AnalyticsEvent.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class MobileMessagePopupWindow extends RiderPopupWindow
  implements MobileMessageModuleView.Listener
{
  private static final long DURATION_ANIMATIONS_MILLIS_FAST = 300L;
  private static final long DURATION_ANIMATIONS_MILLIS_SLOW = 450L;

  @Inject
  AnalyticsClient mAnalyticsClient;
  boolean mDismissable = false;

  @InjectView(2131427503)
  MobileMessageDraggableLayout mLayoutModules;
  int mLoadedModulesCount = 0;
  MobileMessage mMessage;

  @Inject
  MobileMessageManager mMobileMessageManager;
  MobileMessageNativeUrlManager mNativeUrlManager;

  @Inject
  PingProvider mPingProvider;
  FrameLayout mPopupFrameView;
  boolean mShowingInProgress = false;
  Map<String, VehicleTextBitmap> mVehicleTextBitmaps;

  public MobileMessagePopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.mNativeUrlManager = new MobileMessageNativeUrlManager(paramActivity);
    this.mPopupFrameView = ((FrameLayout)LayoutInflater.from(getActivity()).inflate(2130903098, null, false));
    ButterKnife.inject(this, this.mPopupFrameView);
    setContentView(this.mPopupFrameView);
    setAnimationStyle(2131624196);
    setWidth(-1);
    setHeight(-1);
    this.mLayoutModules.setVisibility(8);
    this.mPopupFrameView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MobileMessagePopupWindow.this.closePopup();
      }
    });
    this.mLayoutModules.setOnSwipeListner(new MobileMessageDraggableLayout.OnSwipeListener()
    {
      public void onClickOutside()
      {
        MobileMessagePopupWindow.this.closePopup(true, true);
      }

      public void onSwipeDown()
      {
        MobileMessagePopupWindow.this.closePopup(false, true);
      }

      public void onSwipeUp()
      {
        MobileMessagePopupWindow.this.closePopup(false, true);
      }
    });
  }

  private View buildModuleView(String paramString, MobileMessageModule paramMobileMessageModule)
  {
    MobileMessageModuleView localMobileMessageModuleView = new MobileMessageModuleView(getActivity());
    localMobileMessageModuleView.setListener(this);
    localMobileMessageModuleView.loadModule(paramString, paramMobileMessageModule, this.mPingProvider.get());
    return localMobileMessageModuleView;
  }

  private void clearLayoutModulesAndFadeOut()
  {
    this.mLayoutModules.setVisibility(8);
    this.mLayoutModules.removeAllViews();
    dismiss();
  }

  private void closePopup(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.mDismissable)
      return;
    if (paramBoolean2)
      sendDismissAnalyticsEvent();
    this.mDismissable = false;
    this.mShowingInProgress = false;
    if (this.mMessage != null)
      this.mMobileMessageManager.setMobileMessageSeen(this.mMessage);
    this.mMessage = null;
    if (paramBoolean1)
    {
      messageSlideOut();
      return;
    }
    clearLayoutModulesAndFadeOut();
  }

  private void messageSlideOut()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new AnimationListenerAdapter()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        MobileMessagePopupWindow.this.clearLayoutModulesAndFadeOut();
      }
    });
    this.mLayoutModules.startAnimation(localTranslateAnimation);
  }

  private void sendDismissAnalyticsEvent()
  {
    AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent.Builder("tap").setName(RiderEvents.Tap.MOBILE_MESSAGE_DISMISS).setValue(this.mMessage.getId()).build();
    this.mAnalyticsClient.addEvent(localAnalyticsEvent);
  }

  private void sendImpressionAnalyticsEvent()
  {
    AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent.Builder("impression").setName(RiderEvents.Impression.MOBILE_MESSAGE).setValue(this.mMessage.getId()).build();
    this.mAnalyticsClient.addEvent(localAnalyticsEvent);
  }

  private void showFullscreen()
  {
    showAtLocation(getActivity().getWindow().getDecorView(), 48, 0, 0);
  }

  private void showVehicleIndicator()
  {
    if ((this.mMessage != null) && (this.mVehicleTextBitmaps != null) && (this.mVehicleTextBitmaps.size() > 0) && (this.mMessage.getVehicleViewId() != null))
    {
      VehicleTextBitmap localVehicleTextBitmap = (VehicleTextBitmap)this.mVehicleTextBitmaps.get(this.mMessage.getVehicleViewId());
      if (localVehicleTextBitmap != null)
      {
        VehicleTextDrawView localVehicleTextDrawView = new VehicleTextDrawView(getActivity(), localVehicleTextBitmap);
        this.mPopupFrameView.addView(localVehicleTextDrawView, 0);
        this.mPopupFrameView.invalidate();
      }
    }
  }

  private void slideInMessage()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(450L);
    localTranslateAnimation.setStartOffset(300L);
    localTranslateAnimation.setAnimationListener(new AnimationListenerAdapter()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        MobileMessagePopupWindow.this.mDismissable = true;
        MobileMessagePopupWindow.this.mShowingInProgress = false;
      }
    });
    this.mLayoutModules.startAnimation(localTranslateAnimation);
    this.mLayoutModules.setVisibility(0);
  }

  public void closePopup()
  {
    closePopup(true, true);
  }

  public void dismiss()
  {
    this.mShowingInProgress = false;
    super.dismiss();
  }

  public boolean isShowingInProgress()
  {
    return this.mShowingInProgress;
  }

  public void onReadyForDisplay()
  {
    this.mLoadedModulesCount = (1 + this.mLoadedModulesCount);
    if ((this.mLoadedModulesCount >= this.mMessage.getModules().size()) && (AndroidUtils.isWindowValid(getActivity().getWindow())))
    {
      showFullscreen();
      slideInMessage();
      showVehicleIndicator();
      sendImpressionAnalyticsEvent();
    }
  }

  public void onUrlClicked(String paramString)
  {
    if (this.mMessage == null);
    while (true)
    {
      return;
      if (!paramString.startsWith("native://"))
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        getActivity().startActivity(localIntent);
        return;
      }
      for (String str : paramString.split("&&"))
      {
        NativeUriHandler localNativeUriHandler = this.mNativeUrlManager.getHandler(str);
        if (localNativeUriHandler != null)
        {
          HandlerResult localHandlerResult = localNativeUriHandler.handle(getActivity(), this.mMessage, str);
          if (localHandlerResult.shouldSendAnalytics())
            this.mAnalyticsClient.addEvent(localHandlerResult.getAnalyticsEvent());
          if (localHandlerResult.isDismissMessage())
            closePopup(true, false);
          if (!localHandlerResult.isSuccess())
            Crashlytics.log("Could not handle [" + str + "] in mobile message");
        }
      }
    }
  }

  @Subscribe
  public void onVehicleViewPositionEvent(VehicleTextBitmapsEvent paramVehicleTextBitmapsEvent)
  {
    this.mVehicleTextBitmaps = paramVehicleTextBitmapsEvent.getVehicleTextBitmapMap();
  }

  void setNativeUrlManager(MobileMessageNativeUrlManager paramMobileMessageNativeUrlManager)
  {
    this.mNativeUrlManager = paramMobileMessageNativeUrlManager;
  }

  public boolean showMobileMessage(MobileMessage paramMobileMessage)
  {
    if ((paramMobileMessage != null) && (paramMobileMessage.equals(this.mMessage)));
    do
    {
      return false;
      this.mMessage = paramMobileMessage;
      this.mLayoutModules.removeAllViews();
      this.mLoadedModulesCount = 0;
    }
    while (paramMobileMessage == null);
    this.mShowingInProgress = true;
    this.mDismissable = false;
    Iterator localIterator = paramMobileMessage.getModules().iterator();
    while (localIterator.hasNext())
    {
      MobileMessageModule localMobileMessageModule = (MobileMessageModule)localIterator.next();
      this.mLayoutModules.addView(buildModuleView(paramMobileMessage.getId(), localMobileMessageModule));
    }
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.MobileMessagePopupWindow
 * JD-Core Version:    0.6.2
 */