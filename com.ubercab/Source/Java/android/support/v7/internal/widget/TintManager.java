package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.LruCache;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.util.TypedValue;

public class TintManager
{
  private static final ColorFilterLruCache COLOR_FILTER_CACHE;
  private static final int[] CONTAINERS_WITH_TINT_CHILDREN = arrayOfInt5;
  private static final boolean DEBUG;
  static final PorterDuff.Mode DEFAULT_MODE;
  private static final String TAG = TintManager.class.getSimpleName();
  private static final int[] TINT_COLOR_BACKGROUND_MULTIPLY;
  private static final int[] TINT_COLOR_CONTROL_ACTIVATED;
  private static final int[] TINT_COLOR_CONTROL_NORMAL;
  private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  private final Context mContext;
  private ColorStateList mDefaultColorStateList;
  private final Resources mResources;
  private ColorStateList mSwitchThumbStateList;
  private ColorStateList mSwitchTrackStateList;
  private final TypedValue mTypedValue;

  static
  {
    DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    int[] arrayOfInt1 = new int[14];
    arrayOfInt1[0] = R.drawable.abc_ic_ab_back_mtrl_am_alpha;
    arrayOfInt1[1] = R.drawable.abc_ic_go_search_api_mtrl_alpha;
    arrayOfInt1[2] = R.drawable.abc_ic_search_api_mtrl_alpha;
    arrayOfInt1[3] = R.drawable.abc_ic_commit_search_api_mtrl_alpha;
    arrayOfInt1[4] = R.drawable.abc_ic_clear_mtrl_alpha;
    arrayOfInt1[5] = R.drawable.abc_ic_menu_share_mtrl_alpha;
    arrayOfInt1[6] = R.drawable.abc_ic_menu_copy_mtrl_am_alpha;
    arrayOfInt1[7] = R.drawable.abc_ic_menu_cut_mtrl_alpha;
    arrayOfInt1[8] = R.drawable.abc_ic_menu_selectall_mtrl_alpha;
    arrayOfInt1[9] = R.drawable.abc_ic_menu_paste_mtrl_am_alpha;
    arrayOfInt1[10] = R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha;
    arrayOfInt1[11] = R.drawable.abc_ic_voice_search_api_mtrl_alpha;
    arrayOfInt1[12] = R.drawable.abc_textfield_search_default_mtrl_alpha;
    arrayOfInt1[13] = R.drawable.abc_textfield_default_mtrl_alpha;
    TINT_COLOR_CONTROL_NORMAL = arrayOfInt1;
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = R.drawable.abc_textfield_activated_mtrl_alpha;
    arrayOfInt2[1] = R.drawable.abc_textfield_search_activated_mtrl_alpha;
    arrayOfInt2[2] = R.drawable.abc_cab_background_top_mtrl_alpha;
    TINT_COLOR_CONTROL_ACTIVATED = arrayOfInt2;
    int[] arrayOfInt3 = new int[3];
    arrayOfInt3[0] = R.drawable.abc_popup_background_mtrl_mult;
    arrayOfInt3[1] = R.drawable.abc_cab_background_internal_bg;
    arrayOfInt3[2] = R.drawable.abc_menu_hardkey_panel_mtrl_mult;
    TINT_COLOR_BACKGROUND_MULTIPLY = arrayOfInt3;
    int[] arrayOfInt4 = new int[6];
    arrayOfInt4[0] = R.drawable.abc_edit_text_material;
    arrayOfInt4[1] = R.drawable.abc_tab_indicator_material;
    arrayOfInt4[2] = R.drawable.abc_textfield_search_material;
    arrayOfInt4[3] = R.drawable.abc_spinner_mtrl_am_alpha;
    arrayOfInt4[4] = R.drawable.abc_btn_check_material;
    arrayOfInt4[5] = R.drawable.abc_btn_radio_material;
    TINT_COLOR_CONTROL_STATE_LIST = arrayOfInt4;
    int[] arrayOfInt5 = new int[1];
    arrayOfInt5[0] = R.drawable.abc_cab_background_top_material;
  }

  public TintManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mResources = new TintResources(paramContext.getResources(), this);
    this.mTypedValue = new TypedValue();
  }

  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
      if (paramArrayOfInt[j] == paramInt)
        return true;
    return false;
  }

  private ColorStateList getDefaultColorStateList()
  {
    if (this.mDefaultColorStateList == null)
    {
      int i = getThemeAttrColor(R.attr.colorControlNormal);
      int j = getThemeAttrColor(R.attr.colorControlActivated);
      int[][] arrayOfInt = new int[7][];
      int[] arrayOfInt1 = new int[7];
      arrayOfInt[0] = { -16842910 };
      arrayOfInt1[0] = getDisabledThemeAttrColor(R.attr.colorControlNormal);
      int k = 0 + 1;
      arrayOfInt[k] = { 16842908 };
      arrayOfInt1[k] = j;
      int m = k + 1;
      arrayOfInt[m] = { 16843518 };
      arrayOfInt1[m] = j;
      int n = m + 1;
      arrayOfInt[n] = { 16842919 };
      arrayOfInt1[n] = j;
      int i1 = n + 1;
      arrayOfInt[i1] = { 16842912 };
      arrayOfInt1[i1] = j;
      int i2 = i1 + 1;
      arrayOfInt[i2] = { 16842913 };
      arrayOfInt1[i2] = j;
      int i3 = i2 + 1;
      arrayOfInt[i3] = new int[0];
      arrayOfInt1[i3] = i;
      (i3 + 1);
      this.mDefaultColorStateList = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.mDefaultColorStateList;
  }

  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    if (isInTintList(paramInt))
      return new TintManager(paramContext).getDrawable(paramInt);
    return ContextCompat.getDrawable(paramContext, paramInt);
  }

  private ColorStateList getSwitchThumbColorStateList()
  {
    if (this.mSwitchThumbStateList == null)
    {
      int[][] arrayOfInt = new int[3][];
      int[] arrayOfInt1 = new int[3];
      arrayOfInt[0] = { -16842910 };
      arrayOfInt1[0] = getDisabledThemeAttrColor(R.attr.colorSwitchThumbNormal);
      int i = 0 + 1;
      arrayOfInt[i] = { 16842912 };
      arrayOfInt1[i] = getThemeAttrColor(R.attr.colorControlActivated);
      int j = i + 1;
      arrayOfInt[j] = new int[0];
      arrayOfInt1[j] = getThemeAttrColor(R.attr.colorSwitchThumbNormal);
      (j + 1);
      this.mSwitchThumbStateList = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.mSwitchThumbStateList;
  }

  private ColorStateList getSwitchTrackColorStateList()
  {
    if (this.mSwitchTrackStateList == null)
    {
      int[][] arrayOfInt = new int[3][];
      int[] arrayOfInt1 = new int[3];
      arrayOfInt[0] = { -16842910 };
      arrayOfInt1[0] = getThemeAttrColor(16842800, 0.1F);
      int i = 0 + 1;
      arrayOfInt[i] = { 16842912 };
      arrayOfInt1[i] = getThemeAttrColor(R.attr.colorControlActivated, 0.3F);
      int j = i + 1;
      arrayOfInt[j] = new int[0];
      arrayOfInt1[j] = getThemeAttrColor(16842800, 0.3F);
      (j + 1);
      this.mSwitchTrackStateList = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.mSwitchTrackStateList;
  }

  private static boolean isInTintList(int paramInt)
  {
    return (arrayContains(TINT_COLOR_BACKGROUND_MULTIPLY, paramInt)) || (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt)) || (arrayContains(TINT_COLOR_CONTROL_ACTIVATED, paramInt)) || (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) || (arrayContains(CONTAINERS_WITH_TINT_CHILDREN, paramInt));
  }

  int getDisabledThemeAttrColor(int paramInt)
  {
    this.mContext.getTheme().resolveAttribute(16842803, this.mTypedValue, true);
    return getThemeAttrColor(paramInt, this.mTypedValue.getFloat());
  }

  public Drawable getDrawable(int paramInt)
  {
    Object localObject = ContextCompat.getDrawable(this.mContext, paramInt);
    if (localObject != null)
    {
      if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt))
        localObject = new TintDrawableWrapper((Drawable)localObject, getDefaultColorStateList());
    }
    else
      return localObject;
    if (paramInt == R.drawable.abc_switch_track_mtrl_alpha)
      return new TintDrawableWrapper((Drawable)localObject, getSwitchTrackColorStateList());
    if (paramInt == R.drawable.abc_switch_thumb_material)
      return new TintDrawableWrapper((Drawable)localObject, getSwitchThumbColorStateList(), PorterDuff.Mode.MULTIPLY);
    if (arrayContains(CONTAINERS_WITH_TINT_CHILDREN, paramInt))
      return this.mResources.getDrawable(paramInt);
    tintDrawable(paramInt, (Drawable)localObject);
    return localObject;
  }

  int getThemeAttrColor(int paramInt)
  {
    if (this.mContext.getTheme().resolveAttribute(paramInt, this.mTypedValue, true))
    {
      if ((this.mTypedValue.type >= 16) && (this.mTypedValue.type <= 31))
        return this.mTypedValue.data;
      if (this.mTypedValue.type == 3)
        return this.mResources.getColor(this.mTypedValue.resourceId);
    }
    return 0;
  }

  int getThemeAttrColor(int paramInt, float paramFloat)
  {
    int i = getThemeAttrColor(paramInt);
    int j = Color.alpha(i);
    return 0xFFFFFF & i | Math.round(paramFloat * j) << 24;
  }

  void tintDrawable(int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = null;
    int i = -1;
    int k;
    int m;
    if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt))
    {
      k = R.attr.colorControlNormal;
      m = 1;
    }
    while (true)
    {
      if (m != 0)
      {
        if (localMode == null)
          localMode = DEFAULT_MODE;
        int n = getThemeAttrColor(k);
        PorterDuffColorFilter localPorterDuffColorFilter = COLOR_FILTER_CACHE.get(n, localMode);
        if (localPorterDuffColorFilter == null)
        {
          localPorterDuffColorFilter = new PorterDuffColorFilter(n, localMode);
          COLOR_FILTER_CACHE.put(n, localMode, localPorterDuffColorFilter);
        }
        paramDrawable.setColorFilter(localPorterDuffColorFilter);
        if (i != -1)
          paramDrawable.setAlpha(i);
      }
      return;
      if (arrayContains(TINT_COLOR_CONTROL_ACTIVATED, paramInt))
      {
        k = R.attr.colorControlActivated;
        m = 1;
        localMode = null;
      }
      else if (arrayContains(TINT_COLOR_BACKGROUND_MULTIPLY, paramInt))
      {
        k = 16842801;
        m = 1;
        localMode = PorterDuff.Mode.MULTIPLY;
      }
      else
      {
        int j = R.drawable.abc_list_divider_mtrl_alpha;
        k = 0;
        m = 0;
        localMode = null;
        if (paramInt == j)
        {
          k = 16842800;
          m = 1;
          i = Math.round(40.799999F);
          localMode = null;
        }
      }
    }
  }

  private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter>
  {
    public ColorFilterLruCache(int paramInt)
    {
      super();
    }

    private static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
    {
      return 31 * (paramInt + 31) + paramMode.hashCode();
    }

    PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)get(Integer.valueOf(generateCacheKey(paramInt, paramMode)));
    }

    PorterDuffColorFilter put(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)put(Integer.valueOf(generateCacheKey(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintManager
 * JD-Core Version:    0.6.2
 */