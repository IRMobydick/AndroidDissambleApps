package uk.co.chrisjenx.calligraphy;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.HashMap;
import java.util.Map;

class CalligraphyFactory
  implements LayoutInflater.Factory
{
  private static final String ACTION_BAR_SUBTITLE = "action_bar_subtitle";
  private static final String ACTION_BAR_TITLE = "action_bar_title";
  private static final String[] sClassPrefixList = { "android.widget.", "android.webkit." };
  private static final Map<Class<? extends TextView>, Integer> sStyles = new HashMap()
  {
  };
  private final LayoutInflater.Factory factory;
  private final int mAttributeId;

  public CalligraphyFactory(LayoutInflater.Factory paramFactory, int paramInt)
  {
    this.factory = paramFactory;
    this.mAttributeId = paramInt;
  }

  protected static int[] getStyleForTextView(View paramView)
  {
    int[] arrayOfInt = { -1, -1 };
    if (matchesResourceIdName(paramView, "action_bar_title"))
    {
      arrayOfInt[0] = 16843470;
      arrayOfInt[1] = 16843512;
      if (arrayOfInt[0] == -1)
        if (!sStyles.containsKey(paramView.getClass()))
          break label100;
    }
    label100: for (int i = ((Integer)sStyles.get(paramView.getClass())).intValue(); ; i = 16842804)
    {
      arrayOfInt[0] = i;
      return arrayOfInt;
      if (!matchesResourceIdName(paramView, "action_bar_subtitle"))
        break;
      arrayOfInt[0] = 16843470;
      arrayOfInt[1] = 16843513;
      break;
    }
  }

  protected static boolean matchesResourceIdName(View paramView, String paramString)
  {
    if (paramView.getId() == -1)
      return false;
    return paramView.getResources().getResourceEntryName(paramView.getId()).equalsIgnoreCase(paramString);
  }

  protected View createViewOrFailQuietly(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView;
    if (paramString.contains("."))
    {
      localView = createViewOrFailQuietly(paramString, null, paramContext, paramAttributeSet);
      return localView;
    }
    String[] arrayOfString = sClassPrefixList;
    int i = arrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label67;
      localView = createViewOrFailQuietly(paramString, arrayOfString[j], paramContext, paramAttributeSet);
      if (localView != null)
        break;
    }
    label67: return null;
  }

  protected View createViewOrFailQuietly(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet)
  {
    try
    {
      View localView = LayoutInflater.from(paramContext).createView(paramString1, paramString2, paramAttributeSet);
      return localView;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    boolean bool = paramContext instanceof LayoutInflater.Factory;
    View localView = null;
    if (bool)
      localView = ((LayoutInflater.Factory)paramContext).onCreateView(paramString, paramContext, paramAttributeSet);
    if ((this.factory != null) && (localView == null))
      localView = this.factory.onCreateView(paramString, paramContext, paramAttributeSet);
    if (localView == null)
      localView = createViewOrFailQuietly(paramString, paramContext, paramAttributeSet);
    if (localView != null)
      onViewCreated(localView, paramString, paramContext, paramAttributeSet);
    return localView;
  }

  protected void onViewCreated(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int[] arrayOfInt;
    if ((paramView instanceof TextView))
    {
      str = CalligraphyUtils.pullFontPathFromView(paramContext, paramAttributeSet, this.mAttributeId);
      if (TextUtils.isEmpty(str))
        str = CalligraphyUtils.pullFontPathFromStyle(paramContext, paramAttributeSet, this.mAttributeId);
      if (TextUtils.isEmpty(str))
        str = CalligraphyUtils.pullFontPathFromTextAppearance(paramContext, paramAttributeSet, this.mAttributeId);
      if (TextUtils.isEmpty(str))
      {
        arrayOfInt = getStyleForTextView(paramView);
        if (arrayOfInt[1] == -1)
          break label143;
      }
    }
    label143: for (String str = CalligraphyUtils.pullFontPathFromTheme(paramContext, arrayOfInt[0], arrayOfInt[1], this.mAttributeId); ; str = CalligraphyUtils.pullFontPathFromTheme(paramContext, arrayOfInt[0], this.mAttributeId))
    {
      boolean bool1;
      if (!matchesResourceIdName(paramView, "action_bar_title"))
      {
        boolean bool2 = matchesResourceIdName(paramView, "action_bar_subtitle");
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
      CalligraphyUtils.applyFontToTextView(paramContext, (TextView)paramView, CalligraphyConfig.get(), str, bool1);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyFactory
 * JD-Core Version:    0.6.2
 */