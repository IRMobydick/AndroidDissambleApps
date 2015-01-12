package android.support.v7.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

@TargetApi(11)
public class SupportActionModeWrapper extends android.view.ActionMode
{
  final MenuInflater mInflater;
  final android.support.v7.view.ActionMode mWrappedObject;

  public SupportActionModeWrapper(Context paramContext, android.support.v7.view.ActionMode paramActionMode)
  {
    this.mWrappedObject = paramActionMode;
    this.mInflater = new SupportMenuInflater(paramContext);
  }

  public void finish()
  {
    this.mWrappedObject.finish();
  }

  public View getCustomView()
  {
    return this.mWrappedObject.getCustomView();
  }

  public Menu getMenu()
  {
    return MenuWrapperFactory.createMenuWrapper(this.mWrappedObject.getMenu());
  }

  public MenuInflater getMenuInflater()
  {
    return this.mInflater;
  }

  public CharSequence getSubtitle()
  {
    return this.mWrappedObject.getSubtitle();
  }

  public Object getTag()
  {
    return this.mWrappedObject.getTag();
  }

  public CharSequence getTitle()
  {
    return this.mWrappedObject.getTitle();
  }

  public boolean getTitleOptionalHint()
  {
    return this.mWrappedObject.getTitleOptionalHint();
  }

  public void invalidate()
  {
    this.mWrappedObject.invalidate();
  }

  public boolean isTitleOptional()
  {
    return this.mWrappedObject.isTitleOptional();
  }

  public void setCustomView(View paramView)
  {
    this.mWrappedObject.setCustomView(paramView);
  }

  public void setSubtitle(int paramInt)
  {
    this.mWrappedObject.setSubtitle(paramInt);
  }

  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setSubtitle(paramCharSequence);
  }

  public void setTag(Object paramObject)
  {
    this.mWrappedObject.setTag(paramObject);
  }

  public void setTitle(int paramInt)
  {
    this.mWrappedObject.setTitle(paramInt);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setTitle(paramCharSequence);
  }

  public void setTitleOptionalHint(boolean paramBoolean)
  {
    this.mWrappedObject.setTitleOptionalHint(paramBoolean);
  }

  public static class CallbackWrapper
    implements android.support.v7.view.ActionMode.Callback
  {
    final SimpleArrayMap<android.support.v7.view.ActionMode, SupportActionModeWrapper> mActionModes;
    final Context mContext;
    final android.view.ActionMode.Callback mWrappedCallback;

    public CallbackWrapper(Context paramContext, android.view.ActionMode.Callback paramCallback)
    {
      this.mContext = paramContext;
      this.mWrappedCallback = paramCallback;
      this.mActionModes = new SimpleArrayMap();
    }

    private android.view.ActionMode getActionModeWrapper(android.support.v7.view.ActionMode paramActionMode)
    {
      SupportActionModeWrapper localSupportActionModeWrapper1 = (SupportActionModeWrapper)this.mActionModes.get(paramActionMode);
      if (localSupportActionModeWrapper1 != null)
        return localSupportActionModeWrapper1;
      SupportActionModeWrapper localSupportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, paramActionMode);
      this.mActionModes.put(paramActionMode, localSupportActionModeWrapper2);
      return localSupportActionModeWrapper2;
    }

    public boolean onActionItemClicked(android.support.v7.view.ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuItemWrapper(paramMenuItem));
    }

    public boolean onCreateActionMode(android.support.v7.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuWrapper(paramMenu));
    }

    public void onDestroyActionMode(android.support.v7.view.ActionMode paramActionMode)
    {
      this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(paramActionMode));
    }

    public boolean onPrepareActionMode(android.support.v7.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuWrapper(paramMenu));
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportActionModeWrapper
 * JD-Core Version:    0.6.2
 */