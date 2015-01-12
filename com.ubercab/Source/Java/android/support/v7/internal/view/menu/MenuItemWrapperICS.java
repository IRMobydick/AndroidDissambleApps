package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends BaseMenuWrapper<MenuItem>
  implements SupportMenuItem
{
  static final String LOG_TAG = "MenuItemWrapper";
  private final boolean mEmulateProviderVisibilityOverride;
  private boolean mLastRequestVisible;
  private Method mSetExclusiveCheckableMethod;

  MenuItemWrapperICS(MenuItem paramMenuItem)
  {
    this(paramMenuItem, true);
  }

  MenuItemWrapperICS(MenuItem paramMenuItem, boolean paramBoolean)
  {
    super(paramMenuItem);
    this.mLastRequestVisible = paramMenuItem.isVisible();
    this.mEmulateProviderVisibilityOverride = paramBoolean;
  }

  final boolean checkActionProviderOverrideVisibility()
  {
    boolean bool1 = this.mLastRequestVisible;
    boolean bool2 = false;
    if (bool1)
    {
      android.support.v4.view.ActionProvider localActionProvider = getSupportActionProvider();
      bool2 = false;
      if (localActionProvider != null)
      {
        boolean bool3 = localActionProvider.overridesItemVisibility();
        bool2 = false;
        if (bool3)
        {
          boolean bool4 = localActionProvider.isVisible();
          bool2 = false;
          if (!bool4)
          {
            wrappedSetVisible(false);
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }

  public boolean collapseActionView()
  {
    return ((MenuItem)this.mWrappedObject).collapseActionView();
  }

  ActionProviderWrapper createActionProviderWrapper(android.support.v4.view.ActionProvider paramActionProvider)
  {
    return new ActionProviderWrapper(paramActionProvider);
  }

  public boolean expandActionView()
  {
    return ((MenuItem)this.mWrappedObject).expandActionView();
  }

  public android.view.ActionProvider getActionProvider()
  {
    return ((MenuItem)this.mWrappedObject).getActionProvider();
  }

  public View getActionView()
  {
    View localView = ((MenuItem)this.mWrappedObject).getActionView();
    if ((localView instanceof CollapsibleActionViewWrapper))
      localView = ((CollapsibleActionViewWrapper)localView).getWrappedView();
    return localView;
  }

  public char getAlphabeticShortcut()
  {
    return ((MenuItem)this.mWrappedObject).getAlphabeticShortcut();
  }

  public int getGroupId()
  {
    return ((MenuItem)this.mWrappedObject).getGroupId();
  }

  public Drawable getIcon()
  {
    return ((MenuItem)this.mWrappedObject).getIcon();
  }

  public Intent getIntent()
  {
    return ((MenuItem)this.mWrappedObject).getIntent();
  }

  public int getItemId()
  {
    return ((MenuItem)this.mWrappedObject).getItemId();
  }

  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((MenuItem)this.mWrappedObject).getMenuInfo();
  }

  public char getNumericShortcut()
  {
    return ((MenuItem)this.mWrappedObject).getNumericShortcut();
  }

  public int getOrder()
  {
    return ((MenuItem)this.mWrappedObject).getOrder();
  }

  public SubMenu getSubMenu()
  {
    return getSubMenuWrapper(((MenuItem)this.mWrappedObject).getSubMenu());
  }

  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    ActionProviderWrapper localActionProviderWrapper = (ActionProviderWrapper)((MenuItem)this.mWrappedObject).getActionProvider();
    if (localActionProviderWrapper != null)
      return localActionProviderWrapper.mInner;
    return null;
  }

  public CharSequence getTitle()
  {
    return ((MenuItem)this.mWrappedObject).getTitle();
  }

  public CharSequence getTitleCondensed()
  {
    return ((MenuItem)this.mWrappedObject).getTitleCondensed();
  }

  public boolean hasSubMenu()
  {
    return ((MenuItem)this.mWrappedObject).hasSubMenu();
  }

  public boolean isActionViewExpanded()
  {
    return ((MenuItem)this.mWrappedObject).isActionViewExpanded();
  }

  public boolean isCheckable()
  {
    return ((MenuItem)this.mWrappedObject).isCheckable();
  }

  public boolean isChecked()
  {
    return ((MenuItem)this.mWrappedObject).isChecked();
  }

  public boolean isEnabled()
  {
    return ((MenuItem)this.mWrappedObject).isEnabled();
  }

  public boolean isVisible()
  {
    return ((MenuItem)this.mWrappedObject).isVisible();
  }

  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    ((MenuItem)this.mWrappedObject).setActionProvider(paramActionProvider);
    if ((paramActionProvider != null) && (this.mEmulateProviderVisibilityOverride))
      checkActionProviderOverrideVisibility();
    return this;
  }

  public MenuItem setActionView(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setActionView(paramInt);
    View localView = ((MenuItem)this.mWrappedObject).getActionView();
    if ((localView instanceof android.support.v7.view.CollapsibleActionView))
      ((MenuItem)this.mWrappedObject).setActionView(new CollapsibleActionViewWrapper(localView));
    return this;
  }

  public MenuItem setActionView(View paramView)
  {
    if ((paramView instanceof android.support.v7.view.CollapsibleActionView))
      paramView = new CollapsibleActionViewWrapper(paramView);
    ((MenuItem)this.mWrappedObject).setActionView(paramView);
    return this;
  }

  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((MenuItem)this.mWrappedObject).setAlphabeticShortcut(paramChar);
    return this;
  }

  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((MenuItem)this.mWrappedObject).setCheckable(paramBoolean);
    return this;
  }

  public MenuItem setChecked(boolean paramBoolean)
  {
    ((MenuItem)this.mWrappedObject).setChecked(paramBoolean);
    return this;
  }

  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((MenuItem)this.mWrappedObject).setEnabled(paramBoolean);
    return this;
  }

  public void setExclusiveCheckable(boolean paramBoolean)
  {
    try
    {
      if (this.mSetExclusiveCheckableMethod == null)
      {
        Class localClass = ((MenuItem)this.mWrappedObject).getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Boolean.TYPE;
        this.mSetExclusiveCheckableMethod = localClass.getDeclaredMethod("setExclusiveCheckable", arrayOfClass);
      }
      Method localMethod = this.mSetExclusiveCheckableMethod;
      Object localObject = this.mWrappedObject;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(localObject, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }

  public MenuItem setIcon(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setIcon(paramInt);
    return this;
  }

  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((MenuItem)this.mWrappedObject).setIcon(paramDrawable);
    return this;
  }

  public MenuItem setIntent(Intent paramIntent)
  {
    ((MenuItem)this.mWrappedObject).setIntent(paramIntent);
    return this;
  }

  public MenuItem setNumericShortcut(char paramChar)
  {
    ((MenuItem)this.mWrappedObject).setNumericShortcut(paramChar);
    return this;
  }

  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    ((MenuItem)this.mWrappedObject).setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }

  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    MenuItem localMenuItem = (MenuItem)this.mWrappedObject;
    if (paramOnMenuItemClickListener != null);
    for (OnMenuItemClickListenerWrapper localOnMenuItemClickListenerWrapper = new OnMenuItemClickListenerWrapper(paramOnMenuItemClickListener); ; localOnMenuItemClickListenerWrapper = null)
    {
      localMenuItem.setOnMenuItemClickListener(localOnMenuItemClickListenerWrapper);
      return this;
    }
  }

  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((MenuItem)this.mWrappedObject).setShortcut(paramChar1, paramChar2);
    return this;
  }

  public void setShowAsAction(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setShowAsAction(paramInt);
  }

  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setShowAsActionFlags(paramInt);
    return this;
  }

  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    MenuItem localMenuItem = (MenuItem)this.mWrappedObject;
    if (paramActionProvider != null);
    for (ActionProviderWrapper localActionProviderWrapper = createActionProviderWrapper(paramActionProvider); ; localActionProviderWrapper = null)
    {
      localMenuItem.setActionProvider(localActionProviderWrapper);
      return this;
    }
  }

  public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    MenuItem localMenuItem = (MenuItem)this.mWrappedObject;
    if (paramOnActionExpandListener != null);
    for (OnActionExpandListenerWrapper localOnActionExpandListenerWrapper = new OnActionExpandListenerWrapper(paramOnActionExpandListener); ; localOnActionExpandListenerWrapper = null)
    {
      localMenuItem.setOnActionExpandListener(localOnActionExpandListenerWrapper);
      return null;
    }
  }

  public MenuItem setTitle(int paramInt)
  {
    ((MenuItem)this.mWrappedObject).setTitle(paramInt);
    return this;
  }

  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((MenuItem)this.mWrappedObject).setTitle(paramCharSequence);
    return this;
  }

  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((MenuItem)this.mWrappedObject).setTitleCondensed(paramCharSequence);
    return this;
  }

  public MenuItem setVisible(boolean paramBoolean)
  {
    if (this.mEmulateProviderVisibilityOverride)
    {
      this.mLastRequestVisible = paramBoolean;
      if (checkActionProviderOverrideVisibility())
        return this;
    }
    return wrappedSetVisible(paramBoolean);
  }

  final MenuItem wrappedSetVisible(boolean paramBoolean)
  {
    return ((MenuItem)this.mWrappedObject).setVisible(paramBoolean);
  }

  class ActionProviderWrapper extends android.view.ActionProvider
  {
    final android.support.v4.view.ActionProvider mInner;

    public ActionProviderWrapper(android.support.v4.view.ActionProvider arg2)
    {
      super();
      this.mInner = localObject;
      if (MenuItemWrapperICS.this.mEmulateProviderVisibilityOverride)
        this.mInner.setVisibilityListener(new ActionProvider.VisibilityListener()
        {
          public void onActionProviderVisibilityChanged(boolean paramAnonymousBoolean)
          {
            if ((MenuItemWrapperICS.ActionProviderWrapper.this.mInner.overridesItemVisibility()) && (MenuItemWrapperICS.this.mLastRequestVisible))
              MenuItemWrapperICS.this.wrappedSetVisible(paramAnonymousBoolean);
          }
        });
    }

    public boolean hasSubMenu()
    {
      return this.mInner.hasSubMenu();
    }

    public View onCreateActionView()
    {
      if (MenuItemWrapperICS.this.mEmulateProviderVisibilityOverride)
        MenuItemWrapperICS.this.checkActionProviderOverrideVisibility();
      return this.mInner.onCreateActionView();
    }

    public boolean onPerformDefaultAction()
    {
      return this.mInner.onPerformDefaultAction();
    }

    public void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(paramSubMenu));
    }
  }

  static class CollapsibleActionViewWrapper extends FrameLayout
    implements android.view.CollapsibleActionView
  {
    final android.support.v7.view.CollapsibleActionView mWrappedView;

    CollapsibleActionViewWrapper(View paramView)
    {
      super();
      this.mWrappedView = ((android.support.v7.view.CollapsibleActionView)paramView);
      addView(paramView);
    }

    View getWrappedView()
    {
      return (View)this.mWrappedView;
    }

    public void onActionViewCollapsed()
    {
      this.mWrappedView.onActionViewCollapsed();
    }

    public void onActionViewExpanded()
    {
      this.mWrappedView.onActionViewExpanded();
    }
  }

  private class OnActionExpandListenerWrapper extends BaseWrapper<MenuItemCompat.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    OnActionExpandListenerWrapper(MenuItemCompat.OnActionExpandListener arg2)
    {
      super();
    }

    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItemCompat.OnActionExpandListener)this.mWrappedObject).onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
    }

    public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItemCompat.OnActionExpandListener)this.mWrappedObject).onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
    }
  }

  private class OnMenuItemClickListenerWrapper extends BaseWrapper<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener arg2)
    {
      super();
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnMenuItemClickListener)this.mWrappedObject).onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS
 * JD-Core Version:    0.6.2
 */