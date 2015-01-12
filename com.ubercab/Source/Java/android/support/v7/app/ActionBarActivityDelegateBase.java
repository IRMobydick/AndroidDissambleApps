package android.support.v7.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.app.ToolbarActionBar;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.support.v7.internal.view.StandaloneActionMode;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.DecorContentParent;
import android.support.v7.internal.widget.FitWindowsViewGroup;
import android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.support.v7.internal.widget.ProgressBarCompat;
import android.support.v7.internal.widget.TintCheckBox;
import android.support.v7.internal.widget.TintCheckedTextView;
import android.support.v7.internal.widget.TintEditText;
import android.support.v7.internal.widget.TintRadioButton;
import android.support.v7.internal.widget.TintSpinner;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

class ActionBarActivityDelegateBase extends ActionBarActivityDelegate
  implements MenuBuilder.Callback
{
  private static final String TAG = "ActionBarActivityDelegateBase";
  private ActionMenuPresenterCallback mActionMenuPresenterCallback;
  ActionMode mActionMode;
  PopupWindow mActionModePopup;
  ActionBarContextView mActionModeView;
  private boolean mClosingActionMenu;
  private DecorContentParent mDecorContentParent;
  private boolean mEnableDefaultActionBarUp;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private int mInvalidatePanelMenuFeatures;
  private boolean mInvalidatePanelMenuPosted;
  private final Runnable mInvalidatePanelMenuRunnable = new Runnable()
  {
    public void run()
    {
      if ((0x1 & ActionBarActivityDelegateBase.this.mInvalidatePanelMenuFeatures) != 0)
        ActionBarActivityDelegateBase.this.doInvalidatePanelMenu(0);
      if ((0x100 & ActionBarActivityDelegateBase.this.mInvalidatePanelMenuFeatures) != 0)
        ActionBarActivityDelegateBase.this.doInvalidatePanelMenu(8);
      ActionBarActivityDelegateBase.access$202(ActionBarActivityDelegateBase.this, false);
      ActionBarActivityDelegateBase.access$002(ActionBarActivityDelegateBase.this, 0);
    }
  };
  private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  private PanelFeatureState[] mPanels;
  private PanelFeatureState mPreparedPanel;
  Runnable mShowActionModePopup;
  private View mStatusGuard;
  private ViewGroup mSubDecor;
  private boolean mSubDecorInstalled;
  private Rect mTempRect1;
  private Rect mTempRect2;
  private CharSequence mTitleToSet;
  private ListMenuPresenter mToolbarListMenuPresenter;
  private ViewGroup mWindowDecor;

  ActionBarActivityDelegateBase(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }

  private void applyFixedSizeWindow()
  {
    TypedArray localTypedArray = this.mActivity.obtainStyledAttributes(R.styleable.Theme);
    boolean bool1 = localTypedArray.hasValue(R.styleable.Theme_windowFixedWidthMajor);
    TypedValue localTypedValue1 = null;
    if (bool1)
    {
      localTypedValue1 = null;
      if (0 == 0)
        localTypedValue1 = new TypedValue();
      localTypedArray.getValue(R.styleable.Theme_windowFixedWidthMajor, localTypedValue1);
    }
    boolean bool2 = localTypedArray.hasValue(R.styleable.Theme_windowFixedWidthMinor);
    TypedValue localTypedValue2 = null;
    if (bool2)
    {
      localTypedValue2 = null;
      if (0 == 0)
        localTypedValue2 = new TypedValue();
      localTypedArray.getValue(R.styleable.Theme_windowFixedWidthMinor, localTypedValue2);
    }
    boolean bool3 = localTypedArray.hasValue(R.styleable.Theme_windowFixedHeightMajor);
    TypedValue localTypedValue3 = null;
    if (bool3)
    {
      localTypedValue3 = null;
      if (0 == 0)
        localTypedValue3 = new TypedValue();
      localTypedArray.getValue(R.styleable.Theme_windowFixedHeightMajor, localTypedValue3);
    }
    boolean bool4 = localTypedArray.hasValue(R.styleable.Theme_windowFixedHeightMinor);
    TypedValue localTypedValue4 = null;
    if (bool4)
    {
      localTypedValue4 = null;
      if (0 == 0)
        localTypedValue4 = new TypedValue();
      localTypedArray.getValue(R.styleable.Theme_windowFixedHeightMinor, localTypedValue4);
    }
    DisplayMetrics localDisplayMetrics = this.mActivity.getResources().getDisplayMetrics();
    int i;
    int j;
    int k;
    TypedValue localTypedValue5;
    label220: label252: TypedValue localTypedValue6;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      i = 1;
      j = -1;
      k = -1;
      if (i == 0)
        break label330;
      localTypedValue5 = localTypedValue2;
      if ((localTypedValue5 != null) && (localTypedValue5.type != 0))
      {
        if (localTypedValue5.type != 5)
          break label336;
        j = (int)localTypedValue5.getDimension(localDisplayMetrics);
      }
      if (i == 0)
        break label369;
      localTypedValue6 = localTypedValue3;
      label261: if ((localTypedValue6 != null) && (localTypedValue6.type != 0))
      {
        if (localTypedValue6.type != 5)
          break label376;
        k = (int)localTypedValue6.getDimension(localDisplayMetrics);
      }
    }
    while (true)
    {
      if ((j != -1) || (k != -1))
        this.mActivity.getWindow().setLayout(j, k);
      localTypedArray.recycle();
      return;
      i = 0;
      break;
      label330: localTypedValue5 = localTypedValue1;
      break label220;
      label336: if (localTypedValue5.type != 6)
        break label252;
      j = (int)localTypedValue5.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
      break label252;
      label369: localTypedValue6 = localTypedValue4;
      break label261;
      label376: if (localTypedValue6.type == 6)
        k = (int)localTypedValue6.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
    }
  }

  private void callOnPanelClosed(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    if (paramMenu == null)
    {
      if ((paramPanelFeatureState == null) && (paramInt >= 0) && (paramInt < this.mPanels.length))
        paramPanelFeatureState = this.mPanels[paramInt];
      if (paramPanelFeatureState != null)
        paramMenu = paramPanelFeatureState.menu;
    }
    if ((paramPanelFeatureState != null) && (!paramPanelFeatureState.isOpen))
      return;
    getWindowCallback().onPanelClosed(paramInt, paramMenu);
  }

  private void checkCloseActionMenu(MenuBuilder paramMenuBuilder)
  {
    if (this.mClosingActionMenu)
      return;
    this.mClosingActionMenu = true;
    this.mDecorContentParent.dismissPopups();
    WindowCallback localWindowCallback = getWindowCallback();
    if ((localWindowCallback != null) && (!isDestroyed()))
      localWindowCallback.onPanelClosed(8, paramMenuBuilder);
    this.mClosingActionMenu = false;
  }

  private void closePanel(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.featureId == 0) && (this.mDecorContentParent != null) && (this.mDecorContentParent.isOverflowMenuShowing()))
      checkCloseActionMenu(paramPanelFeatureState.menu);
    do
    {
      return;
      if ((paramPanelFeatureState.isOpen) && (paramBoolean))
        callOnPanelClosed(paramPanelFeatureState.featureId, paramPanelFeatureState, null);
      paramPanelFeatureState.isPrepared = false;
      paramPanelFeatureState.isHandled = false;
      paramPanelFeatureState.isOpen = false;
      paramPanelFeatureState.shownPanelView = null;
      paramPanelFeatureState.refreshDecorView = true;
    }
    while (this.mPreparedPanel != paramPanelFeatureState);
    this.mPreparedPanel = null;
  }

  private void doInvalidatePanelMenu(int paramInt)
  {
    PanelFeatureState localPanelFeatureState1 = getPanelState(paramInt, true);
    if (localPanelFeatureState1.menu != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState1.menu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0)
        localPanelFeatureState1.frozenActionViewState = localBundle;
      localPanelFeatureState1.menu.stopDispatchingItemsChanged();
      localPanelFeatureState1.menu.clear();
    }
    localPanelFeatureState1.refreshMenuContent = true;
    localPanelFeatureState1.refreshDecorView = true;
    if (((paramInt == 8) || (paramInt == 0)) && (this.mDecorContentParent != null))
    {
      PanelFeatureState localPanelFeatureState2 = getPanelState(0, false);
      if (localPanelFeatureState2 != null)
      {
        localPanelFeatureState2.isPrepared = false;
        preparePanel(localPanelFeatureState2, null);
      }
    }
  }

  private void ensureToolbarListMenuPresenter()
  {
    TypedValue localTypedValue;
    ActionBarActivity localActionBarActivity;
    if (this.mToolbarListMenuPresenter == null)
    {
      localTypedValue = new TypedValue();
      this.mActivity.getTheme().resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      localActionBarActivity = this.mActivity;
      if (localTypedValue.resourceId == 0)
        break label74;
    }
    label74: for (int i = localTypedValue.resourceId; ; i = R.style.Theme_AppCompat_CompactMenu)
    {
      this.mToolbarListMenuPresenter = new ListMenuPresenter(new ContextThemeWrapper(localActionBarActivity, i), R.layout.abc_list_menu_item_layout);
      return;
    }
  }

  private PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.mPanels;
    int i;
    if (arrayOfPanelFeatureState != null)
      i = arrayOfPanelFeatureState.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label55;
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.menu == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
    }
    label55: return null;
  }

  private ProgressBarCompat getCircularProgressBar()
  {
    ProgressBarCompat localProgressBarCompat = (ProgressBarCompat)this.mActivity.findViewById(R.id.progress_circular);
    if (localProgressBarCompat != null)
      localProgressBarCompat.setVisibility(4);
    return localProgressBarCompat;
  }

  private ProgressBarCompat getHorizontalProgressBar()
  {
    ProgressBarCompat localProgressBarCompat = (ProgressBarCompat)this.mActivity.findViewById(R.id.progress_horizontal);
    if (localProgressBarCompat != null)
      localProgressBarCompat.setVisibility(4);
    return localProgressBarCompat;
  }

  private PanelFeatureState getPanelState(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.mPanels;
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      PanelFeatureState[] arrayOfPanelFeatureState = new PanelFeatureState[paramInt + 1];
      if (localObject != null)
        System.arraycopy(localObject, 0, arrayOfPanelFeatureState, 0, localObject.length);
      localObject = arrayOfPanelFeatureState;
      this.mPanels = arrayOfPanelFeatureState;
    }
    PanelFeatureState localPanelFeatureState = localObject[paramInt];
    if (localPanelFeatureState == null)
    {
      localPanelFeatureState = new PanelFeatureState(paramInt);
      localObject[paramInt] = localPanelFeatureState;
    }
    return localPanelFeatureState;
  }

  private void hideProgressBars(ProgressBarCompat paramProgressBarCompat1, ProgressBarCompat paramProgressBarCompat2)
  {
    if ((this.mFeatureIndeterminateProgress) && (paramProgressBarCompat2.getVisibility() == 0))
      paramProgressBarCompat2.setVisibility(4);
    if ((this.mFeatureProgress) && (paramProgressBarCompat1.getVisibility() == 0))
      paramProgressBarCompat1.setVisibility(4);
  }

  private boolean initializePanelContent(PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.menu == null);
    do
    {
      return false;
      if (this.mPanelMenuPresenterCallback == null)
        this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(null);
      paramPanelFeatureState.shownPanelView = ((View)paramPanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback));
    }
    while (paramPanelFeatureState.shownPanelView == null);
    return true;
  }

  private void initializePanelDecor(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.decorView = this.mWindowDecor;
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
  }

  private boolean initializePanelMenu(PanelFeatureState paramPanelFeatureState)
  {
    Object localObject = this.mActivity;
    TypedValue localTypedValue;
    Resources.Theme localTheme1;
    Resources.Theme localTheme2;
    if (((paramPanelFeatureState.featureId == 0) || (paramPanelFeatureState.featureId == 8)) && (this.mDecorContentParent != null))
    {
      localTypedValue = new TypedValue();
      localTheme1 = ((Context)localObject).getTheme();
      localTheme1.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      if (localTypedValue.resourceId == 0)
        break label188;
      localTheme2 = ((Context)localObject).getResources().newTheme();
      localTheme2.setTo(localTheme1);
      localTheme2.applyStyle(localTypedValue.resourceId, true);
      localTheme2.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
    }
    while (true)
    {
      if (localTypedValue.resourceId != 0)
      {
        if (localTheme2 == null)
        {
          localTheme2 = ((Context)localObject).getResources().newTheme();
          localTheme2.setTo(localTheme1);
        }
        localTheme2.applyStyle(localTypedValue.resourceId, true);
      }
      if (localTheme2 != null)
      {
        ContextThemeWrapper localContextThemeWrapper = new ContextThemeWrapper((Context)localObject, 0);
        localContextThemeWrapper.getTheme().setTo(localTheme2);
        localObject = localContextThemeWrapper;
      }
      MenuBuilder localMenuBuilder = new MenuBuilder((Context)localObject);
      localMenuBuilder.setCallback(this);
      paramPanelFeatureState.setMenu(localMenuBuilder);
      return true;
      label188: localTheme1.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      localTheme2 = null;
    }
  }

  private void invalidatePanelMenu(int paramInt)
  {
    this.mInvalidatePanelMenuFeatures |= 1 << paramInt;
    if ((!this.mInvalidatePanelMenuPosted) && (this.mWindowDecor != null))
    {
      ViewCompat.postOnAnimation(this.mWindowDecor, this.mInvalidatePanelMenuRunnable);
      this.mInvalidatePanelMenuPosted = true;
    }
  }

  private void openPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 0) && (this.mDecorContentParent != null) && (this.mDecorContentParent.canShowOverflowMenu()) && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mActivity))))
    {
      this.mDecorContentParent.showOverflowMenu();
      return;
    }
    openPanel(getPanelState(paramInt, true), paramKeyEvent);
  }

  private void openPanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if ((paramPanelFeatureState.isOpen) || (isDestroyed()));
    label108: label114: label118: label120: 
    do
    {
      do
        while (true)
        {
          return;
          int i;
          if (paramPanelFeatureState.featureId == 0)
          {
            ActionBarActivity localActionBarActivity = this.mActivity;
            if ((0xF & localActionBarActivity.getResources().getConfiguration().screenLayout) != 4)
              break label108;
            i = 1;
            if (localActionBarActivity.getApplicationInfo().targetSdkVersion < 11)
              break label114;
          }
          for (int j = 1; ; j = 0)
          {
            if ((i != 0) && (j != 0))
              break label118;
            WindowCallback localWindowCallback = getWindowCallback();
            if ((localWindowCallback == null) || (localWindowCallback.onMenuOpened(paramPanelFeatureState.featureId, paramPanelFeatureState.menu)))
              break label120;
            closePanel(paramPanelFeatureState, true);
            return;
            i = 0;
            break;
          }
        }
      while (!preparePanel(paramPanelFeatureState, paramKeyEvent));
      if ((paramPanelFeatureState.decorView == null) || (paramPanelFeatureState.refreshDecorView))
        initializePanelDecor(paramPanelFeatureState);
    }
    while ((!initializePanelContent(paramPanelFeatureState)) || (!paramPanelFeatureState.hasPanelItems()));
    paramPanelFeatureState.isHandled = false;
    paramPanelFeatureState.isOpen = true;
  }

  private boolean preparePanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (isDestroyed())
      return false;
    if (paramPanelFeatureState.isPrepared)
      return true;
    if ((this.mPreparedPanel != null) && (this.mPreparedPanel != paramPanelFeatureState))
      closePanel(this.mPreparedPanel, false);
    if ((paramPanelFeatureState.featureId == 0) || (paramPanelFeatureState.featureId == 8));
    for (int i = 1; ; i = 0)
    {
      if ((i != 0) && (this.mDecorContentParent != null))
        this.mDecorContentParent.setMenuPrepared();
      if ((paramPanelFeatureState.menu != null) && (!paramPanelFeatureState.refreshMenuContent))
        break label233;
      if ((paramPanelFeatureState.menu == null) && ((!initializePanelMenu(paramPanelFeatureState)) || (paramPanelFeatureState.menu == null)))
        break;
      if ((i != 0) && (this.mDecorContentParent != null))
      {
        if (this.mActionMenuPresenterCallback == null)
          this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(null);
        this.mDecorContentParent.setMenu(paramPanelFeatureState.menu, this.mActionMenuPresenterCallback);
      }
      paramPanelFeatureState.menu.stopDispatchingItemsChanged();
      if (getWindowCallback().onCreatePanelMenu(paramPanelFeatureState.featureId, paramPanelFeatureState.menu))
        break label228;
      paramPanelFeatureState.setMenu(null);
      if ((i == 0) || (this.mDecorContentParent == null))
        break;
      this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
      return false;
    }
    label228: paramPanelFeatureState.refreshMenuContent = false;
    label233: paramPanelFeatureState.menu.stopDispatchingItemsChanged();
    if (paramPanelFeatureState.frozenActionViewState != null)
    {
      paramPanelFeatureState.menu.restoreActionViewStates(paramPanelFeatureState.frozenActionViewState);
      paramPanelFeatureState.frozenActionViewState = null;
    }
    if (!getWindowCallback().onPreparePanel(0, null, paramPanelFeatureState.menu))
    {
      if ((i != 0) && (this.mDecorContentParent != null))
        this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
      paramPanelFeatureState.menu.startDispatchingItemsChanged();
      return false;
    }
    int j;
    if (paramKeyEvent != null)
    {
      j = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(j).getKeyboardType() == 1)
        break label387;
    }
    label387: for (boolean bool = true; ; bool = false)
    {
      paramPanelFeatureState.qwertyMode = bool;
      paramPanelFeatureState.menu.setQwertyMode(paramPanelFeatureState.qwertyMode);
      paramPanelFeatureState.menu.startDispatchingItemsChanged();
      paramPanelFeatureState.isPrepared = true;
      paramPanelFeatureState.isHandled = false;
      this.mPreparedPanel = paramPanelFeatureState;
      return true;
      j = -1;
      break;
    }
  }

  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((this.mDecorContentParent != null) && (this.mDecorContentParent.canShowOverflowMenu()) && ((!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mActivity))) || (this.mDecorContentParent.isOverflowMenuShowPending())))
    {
      WindowCallback localWindowCallback = getWindowCallback();
      if ((!this.mDecorContentParent.isOverflowMenuShowing()) || (!paramBoolean))
        if ((localWindowCallback != null) && (!isDestroyed()))
        {
          if ((this.mInvalidatePanelMenuPosted) && ((0x1 & this.mInvalidatePanelMenuFeatures) != 0))
          {
            this.mWindowDecor.removeCallbacks(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuRunnable.run();
          }
          PanelFeatureState localPanelFeatureState2 = getPanelState(0, true);
          if ((localPanelFeatureState2.menu != null) && (!localPanelFeatureState2.refreshMenuContent) && (localWindowCallback.onPreparePanel(0, null, localPanelFeatureState2.menu)))
          {
            localWindowCallback.onMenuOpened(8, localPanelFeatureState2.menu);
            this.mDecorContentParent.showOverflowMenu();
          }
        }
      do
      {
        return;
        this.mDecorContentParent.hideOverflowMenu();
      }
      while (isDestroyed());
      PanelFeatureState localPanelFeatureState3 = getPanelState(0, true);
      this.mActivity.onPanelClosed(8, localPanelFeatureState3.menu);
      return;
    }
    PanelFeatureState localPanelFeatureState1 = getPanelState(0, true);
    localPanelFeatureState1.refreshDecorView = true;
    closePanel(localPanelFeatureState1, false);
    openPanel(localPanelFeatureState1, null);
  }

  private void showProgressBars(ProgressBarCompat paramProgressBarCompat1, ProgressBarCompat paramProgressBarCompat2)
  {
    if ((this.mFeatureIndeterminateProgress) && (paramProgressBarCompat2.getVisibility() == 4))
      paramProgressBarCompat2.setVisibility(0);
    if ((this.mFeatureProgress) && (paramProgressBarCompat1.getProgress() < 10000))
      paramProgressBarCompat1.setVisibility(0);
  }

  private void updateProgressBars(int paramInt)
  {
    ProgressBarCompat localProgressBarCompat1 = getCircularProgressBar();
    ProgressBarCompat localProgressBarCompat2 = getHorizontalProgressBar();
    int j;
    if (paramInt == -1)
      if (this.mFeatureProgress)
      {
        int i = localProgressBarCompat2.getProgress();
        if ((localProgressBarCompat2.isIndeterminate()) || (i < 10000))
        {
          j = 0;
          localProgressBarCompat2.setVisibility(j);
        }
      }
      else if (this.mFeatureIndeterminateProgress)
      {
        localProgressBarCompat1.setVisibility(0);
      }
    label104: 
    do
    {
      do
      {
        return;
        j = 4;
        break;
        if (paramInt != -2)
          break label104;
        if (this.mFeatureProgress)
          localProgressBarCompat2.setVisibility(8);
      }
      while (!this.mFeatureIndeterminateProgress);
      localProgressBarCompat1.setVisibility(8);
      return;
      if (paramInt == -3)
      {
        localProgressBarCompat2.setIndeterminate(true);
        return;
      }
      if (paramInt == -4)
      {
        localProgressBarCompat2.setIndeterminate(false);
        return;
      }
    }
    while ((paramInt < 0) || (paramInt > 10000));
    localProgressBarCompat2.setProgress(paramInt + 0);
    if (paramInt < 10000)
    {
      showProgressBars(localProgressBarCompat2, localProgressBarCompat1);
      return;
    }
    hideProgressBars(localProgressBarCompat2, localProgressBarCompat1);
  }

  private int updateStatusGuard(int paramInt)
  {
    ActionBarContextView localActionBarContextView = this.mActionModeView;
    int i = 0;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int m;
    if (localActionBarContextView != null)
    {
      boolean bool = this.mActionModeView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams;
      i = 0;
      if (bool)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
        if (!this.mActionModeView.isShown())
          break label325;
        if (this.mTempRect1 == null)
        {
          this.mTempRect1 = new Rect();
          this.mTempRect2 = new Rect();
        }
        Rect localRect1 = this.mTempRect1;
        Rect localRect2 = this.mTempRect2;
        localRect1.set(0, paramInt, 0, 0);
        ViewUtils.computeFitSystemWindows(this.mSubDecor, localRect1, localRect2);
        if (localRect2.top != 0)
          break label278;
        n = paramInt;
        int i1 = localMarginLayoutParams.topMargin;
        m = 0;
        if (i1 != n)
        {
          m = 1;
          localMarginLayoutParams.topMargin = paramInt;
          if (this.mStatusGuard != null)
            break label284;
          this.mStatusGuard = new View(this.mActivity);
          this.mStatusGuard.setBackgroundColor(this.mActivity.getResources().getColor(R.color.abc_input_method_navigation_guard));
          this.mSubDecor.addView(this.mStatusGuard, -1, new ViewGroup.LayoutParams(-1, paramInt));
        }
        label213: if (this.mStatusGuard == null)
          break label320;
        i = 1;
        label222: if ((!this.mOverlayActionMode) && (i != 0))
          paramInt = 0;
        label235: if (m != 0)
          this.mActionModeView.setLayoutParams(localMarginLayoutParams);
      }
    }
    View localView;
    int j;
    if (this.mStatusGuard != null)
    {
      localView = this.mStatusGuard;
      j = 0;
      if (i == 0)
        break label356;
    }
    while (true)
    {
      localView.setVisibility(j);
      return paramInt;
      label278: n = 0;
      break;
      label284: ViewGroup.LayoutParams localLayoutParams = this.mStatusGuard.getLayoutParams();
      if (localLayoutParams.height == paramInt)
        break label213;
      localLayoutParams.height = paramInt;
      this.mStatusGuard.setLayoutParams(localLayoutParams);
      break label213;
      label320: i = 0;
      break label222;
      label325: int k = localMarginLayoutParams.topMargin;
      m = 0;
      i = 0;
      if (k == 0)
        break label235;
      m = 1;
      localMarginLayoutParams.topMargin = 0;
      i = 0;
      break label235;
      label356: j = 8;
    }
  }

  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)this.mActivity.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.mActivity.onSupportContentChanged();
  }

  public ActionBar createSupportActionBar()
  {
    ensureSubDecor();
    WindowDecorActionBar localWindowDecorActionBar = new WindowDecorActionBar(this.mActivity, this.mOverlayActionBar);
    localWindowDecorActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
    return localWindowDecorActionBar;
  }

  View createView(String paramString, @NonNull AttributeSet paramAttributeSet)
  {
    int i;
    if (Build.VERSION.SDK_INT < 21)
    {
      i = -1;
      switch (paramString.hashCode())
      {
      default:
      case 1666676343:
      case -339785223:
      case 1601505219:
      case 776382189:
      case -1455429095:
      }
    }
    while (true)
      switch (i)
      {
      default:
        return null;
        if (paramString.equals("EditText"))
        {
          i = 0;
          continue;
          if (paramString.equals("Spinner"))
          {
            i = 1;
            continue;
            if (paramString.equals("CheckBox"))
            {
              i = 2;
              continue;
              if (paramString.equals("RadioButton"))
              {
                i = 3;
                continue;
                if (paramString.equals("CheckedTextView"))
                  i = 4;
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    return new TintEditText(this.mActivity, paramAttributeSet);
    return new TintSpinner(this.mActivity, paramAttributeSet);
    return new TintCheckBox(this.mActivity, paramAttributeSet);
    return new TintRadioButton(this.mActivity, paramAttributeSet);
    return new TintCheckedTextView(this.mActivity, paramAttributeSet);
  }

  final void ensureSubDecor()
  {
    Object localObject;
    if (!this.mSubDecorInstalled)
    {
      if (!this.mHasActionBar)
        break label318;
      TypedValue localTypedValue = new TypedValue();
      this.mActivity.getTheme().resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      if (localTypedValue.resourceId == 0)
        break label310;
      localObject = new ContextThemeWrapper(this.mActivity, localTypedValue.resourceId);
      this.mSubDecor = ((ViewGroup)LayoutInflater.from((Context)localObject).inflate(R.layout.abc_screen_toolbar, null));
      this.mDecorContentParent = ((DecorContentParent)this.mSubDecor.findViewById(R.id.decor_content_parent));
      this.mDecorContentParent.setWindowCallback(getWindowCallback());
      if (this.mOverlayActionBar)
        this.mDecorContentParent.initFeature(9);
      if (this.mFeatureProgress)
        this.mDecorContentParent.initFeature(2);
      if (this.mFeatureIndeterminateProgress)
        this.mDecorContentParent.initFeature(5);
    }
    while (true)
    {
      ViewUtils.makeOptionalFitsSystemWindows(this.mSubDecor);
      this.mActivity.superSetContentView(this.mSubDecor);
      View localView = this.mActivity.findViewById(16908290);
      localView.setId(-1);
      this.mActivity.findViewById(R.id.action_bar_activity_content).setId(16908290);
      if ((localView instanceof FrameLayout))
        ((FrameLayout)localView).setForeground(null);
      if ((this.mTitleToSet != null) && (this.mDecorContentParent != null))
      {
        this.mDecorContentParent.setWindowTitle(this.mTitleToSet);
        this.mTitleToSet = null;
      }
      applyFixedSizeWindow();
      onSubDecorInstalled();
      this.mSubDecorInstalled = true;
      PanelFeatureState localPanelFeatureState = getPanelState(0, false);
      if ((!isDestroyed()) && ((localPanelFeatureState == null) || (localPanelFeatureState.menu == null)))
        invalidatePanelMenu(8);
      return;
      label310: localObject = this.mActivity;
      break;
      label318: if (this.mOverlayActionMode);
      for (this.mSubDecor = ((ViewGroup)LayoutInflater.from(this.mActivity).inflate(R.layout.abc_screen_simple_overlay_action_mode, null)); ; this.mSubDecor = ((ViewGroup)LayoutInflater.from(this.mActivity).inflate(R.layout.abc_screen_simple, null)))
      {
        if (Build.VERSION.SDK_INT < 21)
          break label396;
        ViewCompat.setOnApplyWindowInsetsListener(this.mSubDecor, new OnApplyWindowInsetsListener()
        {
          public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
          {
            int i = paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop();
            int j = ActionBarActivityDelegateBase.this.updateStatusGuard(i);
            if (i != j)
              paramAnonymousWindowInsetsCompat = paramAnonymousWindowInsetsCompat.replaceSystemWindowInsets(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), j, paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
            return paramAnonymousWindowInsetsCompat;
          }
        });
        break;
      }
      label396: ((FitWindowsViewGroup)this.mSubDecor).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener()
      {
        public void onFitSystemWindows(Rect paramAnonymousRect)
        {
          paramAnonymousRect.top = ActionBarActivityDelegateBase.this.updateStatusGuard(paramAnonymousRect.top);
        }
      });
    }
  }

  int getHomeAsUpIndicatorAttrId()
  {
    return R.attr.homeAsUpIndicator;
  }

  public boolean onBackPressed()
  {
    if (this.mActionMode != null)
      this.mActionMode.finish();
    ActionBar localActionBar;
    do
    {
      return true;
      localActionBar = getSupportActionBar();
    }
    while ((localActionBar != null) && (localActionBar.collapseActionView()));
    return false;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mHasActionBar) && (this.mSubDecorInstalled))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null)
        localActionBar.onConfigurationChanged(paramConfiguration);
    }
  }

  public void onContentChanged()
  {
  }

  void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mWindowDecor = ((ViewGroup)this.mActivity.getWindow().getDecorView());
    ActionBar localActionBar;
    if (NavUtils.getParentActivityName(this.mActivity) != null)
    {
      localActionBar = getSupportActionBar();
      if (localActionBar == null)
        this.mEnableDefaultActionBarUp = true;
    }
    else
    {
      return;
    }
    localActionBar.setDefaultDisplayHomeAsUpEnabled(true);
  }

  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt != 0)
      return getWindowCallback().onCreatePanelMenu(paramInt, paramMenu);
    return false;
  }

  public View onCreatePanelView(int paramInt)
  {
    ActionMode localActionMode = this.mActionMode;
    View localView = null;
    if (localActionMode == null)
    {
      WindowCallback localWindowCallback = getWindowCallback();
      localView = null;
      if (localWindowCallback != null)
        localView = localWindowCallback.onCreatePanelView(paramInt);
      if ((localView == null) && (this.mToolbarListMenuPresenter == null))
      {
        PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
        openPanel(localPanelFeatureState, null);
        if (localPanelFeatureState.isOpen)
          localView = localPanelFeatureState.shownPanelView;
      }
    }
    return localView;
  }

  boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return onKeyShortcut(paramInt, paramKeyEvent);
  }

  boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.mPreparedPanel != null) && (performPanelShortcut(this.mPreparedPanel, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)))
      if (this.mPreparedPanel != null)
        this.mPreparedPanel.isHandled = true;
    boolean bool;
    do
    {
      return true;
      if (this.mPreparedPanel != null)
        break;
      PanelFeatureState localPanelFeatureState = getPanelState(0, true);
      preparePanel(localPanelFeatureState, paramKeyEvent);
      bool = performPanelShortcut(localPanelFeatureState, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      localPanelFeatureState.isPrepared = false;
    }
    while (bool);
    return false;
  }

  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    WindowCallback localWindowCallback = getWindowCallback();
    if ((localWindowCallback != null) && (!isDestroyed()))
    {
      PanelFeatureState localPanelFeatureState = findMenuPanel(paramMenuBuilder.getRootMenu());
      if (localPanelFeatureState != null)
        return localWindowCallback.onMenuItemSelected(localPanelFeatureState.featureId, paramMenuItem);
    }
    return false;
  }

  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(paramMenuBuilder, true);
  }

  boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    if (paramInt == 8)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null)
        localActionBar.dispatchMenuVisibilityChanged(true);
      return true;
    }
    return this.mActivity.superOnMenuOpened(paramInt, paramMenu);
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, false);
    if (localPanelFeatureState != null)
      closePanel(localPanelFeatureState, false);
    if (paramInt == 8)
    {
      localActionBar = getSupportActionBar();
      if (localActionBar != null)
        localActionBar.dispatchMenuVisibilityChanged(false);
    }
    while (isDestroyed())
    {
      ActionBar localActionBar;
      return;
    }
    this.mActivity.superOnPanelClosed(paramInt, paramMenu);
  }

  public void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
      localActionBar.setShowHideAnimationEnabled(true);
  }

  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt != 0)
      return getWindowCallback().onPreparePanel(paramInt, paramView, paramMenu);
    return false;
  }

  public void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
      localActionBar.setShowHideAnimationEnabled(false);
  }

  void onSubDecorInstalled()
  {
  }

  public void onTitleChanged(CharSequence paramCharSequence)
  {
    if (this.mDecorContentParent != null)
    {
      this.mDecorContentParent.setWindowTitle(paramCharSequence);
      return;
    }
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setWindowTitle(paramCharSequence);
      return;
    }
    this.mTitleToSet = paramCharSequence;
  }

  final boolean performPanelShortcut(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1;
    if (paramKeyEvent.isSystem())
      bool1 = false;
    do
    {
      return bool1;
      if (!paramPanelFeatureState.isPrepared)
      {
        boolean bool2 = preparePanel(paramPanelFeatureState, paramKeyEvent);
        bool1 = false;
        if (!bool2);
      }
      else
      {
        MenuBuilder localMenuBuilder = paramPanelFeatureState.menu;
        bool1 = false;
        if (localMenuBuilder != null)
          bool1 = paramPanelFeatureState.menu.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    while ((!bool1) || ((paramInt2 & 0x1) != 0) || (this.mDecorContentParent != null));
    closePanel(paramPanelFeatureState, true);
    return bool1;
  }

  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    this.mActivity.getLayoutInflater().inflate(paramInt, localViewGroup);
    this.mActivity.onSupportContentChanged();
  }

  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.mActivity.onSupportContentChanged();
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.mActivity.onSupportContentChanged();
  }

  void setSupportActionBar(Toolbar paramToolbar)
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof WindowDecorActionBar))
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    if ((localActionBar instanceof ToolbarActionBar))
      ((ToolbarActionBar)localActionBar).setListMenuPresenter(null);
    ToolbarActionBar localToolbarActionBar = new ToolbarActionBar(paramToolbar, this.mActivity.getTitle(), this.mActivity.getWindow(), this.mDefaultWindowCallback);
    ensureToolbarListMenuPresenter();
    localToolbarActionBar.setListMenuPresenter(this.mToolbarListMenuPresenter);
    setSupportActionBar(localToolbarActionBar);
    setWindowCallback(localToolbarActionBar.getWrappedWindowCallback());
    localToolbarActionBar.invalidateOptionsMenu();
  }

  void setSupportProgress(int paramInt)
  {
    updateProgressBars(paramInt + 0);
  }

  void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = -3; ; i = -4)
    {
      updateProgressBars(i);
      return;
    }
  }

  void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = -1; ; i = -2)
    {
      updateProgressBars(i);
      return;
    }
  }

  void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = -1; ; i = -2)
    {
      updateProgressBars(i);
      return;
    }
  }

  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null)
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    if (this.mActionMode != null)
      this.mActionMode.finish();
    ActionModeCallbackWrapper localActionModeCallbackWrapper = new ActionModeCallbackWrapper(paramCallback);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.mActionMode = localActionBar.startActionMode(localActionModeCallbackWrapper);
      if (this.mActionMode != null)
        this.mActivity.onSupportActionModeStarted(this.mActionMode);
    }
    if (this.mActionMode == null)
      this.mActionMode = startSupportActionModeFromWindow(localActionModeCallbackWrapper);
    return this.mActionMode;
  }

  ActionMode startSupportActionModeFromWindow(ActionMode.Callback paramCallback)
  {
    if (this.mActionMode != null)
      this.mActionMode.finish();
    ActionModeCallbackWrapper localActionModeCallbackWrapper = new ActionModeCallbackWrapper(paramCallback);
    Context localContext = getActionBarThemedContext();
    boolean bool;
    if (this.mActionModeView == null)
    {
      if (this.mIsFloating)
      {
        this.mActionModeView = new ActionBarContextView(localContext);
        this.mActionModePopup = new PopupWindow(localContext, null, R.attr.actionModePopupWindowStyle);
        this.mActionModePopup.setContentView(this.mActionModeView);
        this.mActionModePopup.setWidth(-1);
        TypedValue localTypedValue = new TypedValue();
        this.mActivity.getTheme().resolveAttribute(R.attr.actionBarSize, localTypedValue, true);
        int i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, this.mActivity.getResources().getDisplayMetrics());
        this.mActionModeView.setContentHeight(i);
        this.mActionModePopup.setHeight(-2);
        this.mShowActionModePopup = new Runnable()
        {
          public void run()
          {
            ActionBarActivityDelegateBase.this.mActionModePopup.showAtLocation(ActionBarActivityDelegateBase.this.mActionModeView, 55, 0, 0);
          }
        };
      }
    }
    else if (this.mActionModeView != null)
    {
      this.mActionModeView.killMode();
      ActionBarContextView localActionBarContextView = this.mActionModeView;
      if (this.mActionModePopup != null)
        break label386;
      bool = true;
      label196: StandaloneActionMode localStandaloneActionMode = new StandaloneActionMode(localContext, localActionBarContextView, localActionModeCallbackWrapper, bool);
      if (!paramCallback.onCreateActionMode(localStandaloneActionMode, localStandaloneActionMode.getMenu()))
        break label392;
      localStandaloneActionMode.invalidate();
      this.mActionModeView.initForMode(localStandaloneActionMode);
      this.mActionModeView.setVisibility(0);
      this.mActionMode = localStandaloneActionMode;
      if (this.mActionModePopup != null)
        this.mActivity.getWindow().getDecorView().post(this.mShowActionModePopup);
      this.mActionModeView.sendAccessibilityEvent(32);
      if (this.mActionModeView.getParent() != null)
        ViewCompat.requestApplyInsets((View)this.mActionModeView.getParent());
    }
    while (true)
    {
      if ((this.mActionMode != null) && (this.mActivity != null))
        this.mActivity.onSupportActionModeStarted(this.mActionMode);
      return this.mActionMode;
      ViewStubCompat localViewStubCompat = (ViewStubCompat)this.mActivity.findViewById(R.id.action_mode_bar_stub);
      if (localViewStubCompat == null)
        break;
      localViewStubCompat.setLayoutInflater(LayoutInflater.from(localContext));
      this.mActionModeView = ((ActionBarContextView)localViewStubCompat.inflate());
      break;
      label386: bool = false;
      break label196;
      label392: this.mActionMode = null;
    }
  }

  public void supportInvalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.invalidateOptionsMenu()))
      return;
    invalidatePanelMenu(0);
  }

  public boolean supportRequestWindowFeature(int paramInt)
  {
    switch (paramInt)
    {
    case 3:
    case 4:
    case 6:
    case 7:
    default:
      return this.mActivity.requestWindowFeature(paramInt);
    case 8:
      this.mHasActionBar = true;
      return true;
    case 9:
      this.mOverlayActionBar = true;
      return true;
    case 10:
      this.mOverlayActionMode = true;
      return true;
    case 2:
      this.mFeatureProgress = true;
      return true;
    case 5:
    }
    this.mFeatureIndeterminateProgress = true;
    return true;
  }

  private final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private ActionMenuPresenterCallback()
    {
    }

    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      ActionBarActivityDelegateBase.this.checkCloseActionMenu(paramMenuBuilder);
    }

    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      WindowCallback localWindowCallback = ActionBarActivityDelegateBase.this.getWindowCallback();
      if (localWindowCallback != null)
        localWindowCallback.onMenuOpened(8, paramMenuBuilder);
      return true;
    }
  }

  private class ActionModeCallbackWrapper
    implements ActionMode.Callback
  {
    private ActionMode.Callback mWrapped;

    public ActionModeCallbackWrapper(ActionMode.Callback arg2)
    {
      Object localObject;
      this.mWrapped = localObject;
    }

    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }

    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }

    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.mWrapped.onDestroyActionMode(paramActionMode);
      if (ActionBarActivityDelegateBase.this.mActionModePopup != null)
      {
        ActionBarActivityDelegateBase.this.mActivity.getWindow().getDecorView().removeCallbacks(ActionBarActivityDelegateBase.this.mShowActionModePopup);
        ActionBarActivityDelegateBase.this.mActionModePopup.dismiss();
      }
      while (true)
      {
        if (ActionBarActivityDelegateBase.this.mActionModeView != null)
          ActionBarActivityDelegateBase.this.mActionModeView.removeAllViews();
        if (ActionBarActivityDelegateBase.this.mActivity != null);
        try
        {
          ActionBarActivityDelegateBase.this.mActivity.onSupportActionModeFinished(ActionBarActivityDelegateBase.this.mActionMode);
          label101: ActionBarActivityDelegateBase.this.mActionMode = null;
          return;
          if (ActionBarActivityDelegateBase.this.mActionModeView == null)
            continue;
          ActionBarActivityDelegateBase.this.mActionModeView.setVisibility(8);
          if (ActionBarActivityDelegateBase.this.mActionModeView.getParent() == null)
            continue;
          ViewCompat.requestApplyInsets((View)ActionBarActivityDelegateBase.this.mActionModeView.getParent());
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          break label101;
        }
      }
    }

    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }

  private static final class PanelFeatureState
  {
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    Bundle frozenMenuState;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;

    PanelFeatureState(int paramInt)
    {
      this.featureId = paramInt;
      this.refreshDecorView = false;
    }

    void applyFrozenState()
    {
      if ((this.menu != null) && (this.frozenMenuState != null))
      {
        this.menu.restorePresenterStates(this.frozenMenuState);
        this.frozenMenuState = null;
      }
    }

    public void clearMenuPresenters()
    {
      if (this.menu != null)
        this.menu.removeMenuPresenter(this.listMenuPresenter);
      this.listMenuPresenter = null;
    }

    MenuView getListMenuView(MenuPresenter.Callback paramCallback)
    {
      if (this.menu == null)
        return null;
      if (this.listMenuPresenter == null)
      {
        this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
        this.listMenuPresenter.setCallback(paramCallback);
        this.menu.addMenuPresenter(this.listMenuPresenter);
      }
      return this.listMenuPresenter.getMenuView(this.decorView);
    }

    public boolean hasPanelItems()
    {
      if (this.shownPanelView == null);
      while (this.listMenuPresenter.getAdapter().getCount() <= 0)
        return false;
      return true;
    }

    void onRestoreInstanceState(Parcelable paramParcelable)
    {
      SavedState localSavedState = (SavedState)paramParcelable;
      this.featureId = localSavedState.featureId;
      this.wasLastOpen = localSavedState.isOpen;
      this.frozenMenuState = localSavedState.menuState;
      this.shownPanelView = null;
      this.decorView = null;
    }

    Parcelable onSaveInstanceState()
    {
      SavedState localSavedState = new SavedState(null);
      localSavedState.featureId = this.featureId;
      localSavedState.isOpen = this.isOpen;
      if (this.menu != null)
      {
        localSavedState.menuState = new Bundle();
        this.menu.savePresenterStates(localSavedState.menuState);
      }
      return localSavedState;
    }

    void setMenu(MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder == this.menu);
      do
      {
        return;
        if (this.menu != null)
          this.menu.removeMenuPresenter(this.listMenuPresenter);
        this.menu = paramMenuBuilder;
      }
      while ((paramMenuBuilder == null) || (this.listMenuPresenter == null));
      paramMenuBuilder.addMenuPresenter(this.listMenuPresenter);
    }

    void setStyle(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0)
        localTheme.applyStyle(localTypedValue.resourceId, true);
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0)
        localTheme.applyStyle(localTypedValue.resourceId, true);
      while (true)
      {
        ContextThemeWrapper localContextThemeWrapper = new ContextThemeWrapper(paramContext, 0);
        localContextThemeWrapper.getTheme().setTo(localTheme);
        this.listPresenterContext = localContextThemeWrapper;
        return;
        localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      }
    }

    private static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
      {
        public ActionBarActivityDelegateBase.PanelFeatureState.SavedState createFromParcel(Parcel paramAnonymousParcel)
        {
          return ActionBarActivityDelegateBase.PanelFeatureState.SavedState.readFromParcel(paramAnonymousParcel);
        }

        public ActionBarActivityDelegateBase.PanelFeatureState.SavedState[] newArray(int paramAnonymousInt)
        {
          return new ActionBarActivityDelegateBase.PanelFeatureState.SavedState[paramAnonymousInt];
        }
      };
      int featureId;
      boolean isOpen;
      Bundle menuState;

      private static SavedState readFromParcel(Parcel paramParcel)
      {
        int i = 1;
        SavedState localSavedState = new SavedState();
        localSavedState.featureId = paramParcel.readInt();
        if (paramParcel.readInt() == i);
        while (true)
        {
          localSavedState.isOpen = i;
          if (localSavedState.isOpen)
            localSavedState.menuState = paramParcel.readBundle();
          return localSavedState;
          i = 0;
        }
      }

      public int describeContents()
      {
        return 0;
      }

      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.featureId);
        if (this.isOpen);
        for (int i = 1; ; i = 0)
        {
          paramParcel.writeInt(i);
          if (this.isOpen)
            paramParcel.writeBundle(this.menuState);
          return;
        }
      }
    }
  }

  private final class PanelMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private PanelMenuPresenterCallback()
    {
    }

    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
      if (localMenuBuilder != paramMenuBuilder);
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState;
      for (int i = 1; ; i = 0)
      {
        ActionBarActivityDelegateBase localActionBarActivityDelegateBase = ActionBarActivityDelegateBase.this;
        if (i != 0)
          paramMenuBuilder = localMenuBuilder;
        localPanelFeatureState = localActionBarActivityDelegateBase.findMenuPanel(paramMenuBuilder);
        if (localPanelFeatureState != null)
        {
          if (i == 0)
            break;
          ActionBarActivityDelegateBase.this.callOnPanelClosed(localPanelFeatureState.featureId, localPanelFeatureState, localMenuBuilder);
          ActionBarActivityDelegateBase.this.closePanel(localPanelFeatureState, true);
        }
        return;
      }
      ActionBarActivityDelegateBase.this.mActivity.closeOptionsMenu();
      ActionBarActivityDelegateBase.this.closePanel(localPanelFeatureState, paramBoolean);
    }

    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if ((paramMenuBuilder == null) && (ActionBarActivityDelegateBase.this.mHasActionBar))
      {
        WindowCallback localWindowCallback = ActionBarActivityDelegateBase.this.getWindowCallback();
        if ((localWindowCallback != null) && (!ActionBarActivityDelegateBase.this.isDestroyed()))
          localWindowCallback.onMenuOpened(8, paramMenuBuilder);
      }
      return true;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase
 * JD-Core Version:    0.6.2
 */