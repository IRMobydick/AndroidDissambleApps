package uk.co.chrisjenx.calligraphy;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public final class CalligraphyUtils
{
  static void applyFontToTextView(Context paramContext, TextView paramTextView, CalligraphyConfig paramCalligraphyConfig)
  {
    applyFontToTextView(paramContext, paramTextView, paramCalligraphyConfig, false);
  }

  public static void applyFontToTextView(Context paramContext, TextView paramTextView, CalligraphyConfig paramCalligraphyConfig, String paramString)
  {
    applyFontToTextView(paramContext, paramTextView, paramCalligraphyConfig, paramString, false);
  }

  static void applyFontToTextView(Context paramContext, TextView paramTextView, CalligraphyConfig paramCalligraphyConfig, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramTextView == null) || (paramCalligraphyConfig == null));
    while ((!TextUtils.isEmpty(paramString)) && (applyFontToTextView(paramContext, paramTextView, paramString, paramBoolean)))
      return;
    applyFontToTextView(paramContext, paramTextView, paramCalligraphyConfig, paramBoolean);
  }

  static void applyFontToTextView(Context paramContext, TextView paramTextView, CalligraphyConfig paramCalligraphyConfig, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramTextView == null) || (paramCalligraphyConfig == null));
    while (!paramCalligraphyConfig.isFontSet())
      return;
    applyFontToTextView(paramContext, paramTextView, paramCalligraphyConfig.getFontPath(), paramBoolean);
  }

  public static boolean applyFontToTextView(Context paramContext, TextView paramTextView, String paramString)
  {
    return applyFontToTextView(paramContext, paramTextView, paramString, false);
  }

  static boolean applyFontToTextView(Context paramContext, TextView paramTextView, String paramString, boolean paramBoolean)
  {
    if ((paramTextView == null) || (paramContext == null))
      return false;
    return applyFontToTextView(paramTextView, TypefaceUtils.load(paramContext.getAssets(), paramString), paramBoolean);
  }

  public static boolean applyFontToTextView(TextView paramTextView, Typeface paramTypeface)
  {
    return applyFontToTextView(paramTextView, paramTypeface, false);
  }

  public static boolean applyFontToTextView(TextView paramTextView, Typeface paramTypeface, boolean paramBoolean)
  {
    if ((paramTextView == null) || (paramTypeface == null))
      return false;
    paramTextView.setPaintFlags(0x1 | (0x80 | paramTextView.getPaintFlags()));
    paramTextView.setTypeface(paramTypeface);
    if (paramBoolean)
    {
      paramTextView.setText(applyTypefaceSpan(paramTextView.getText(), paramTypeface), TextView.BufferType.SPANNABLE);
      paramTextView.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          CalligraphyUtils.applyTypefaceSpan(paramAnonymousEditable, this.val$typeface);
        }

        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }
      });
    }
    return true;
  }

  public static CharSequence applyTypefaceSpan(CharSequence paramCharSequence, Typeface paramTypeface)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      if (!(paramCharSequence instanceof Spannable))
        paramCharSequence = new SpannableString(paramCharSequence);
      ((Spannable)paramCharSequence).setSpan(TypefaceUtils.getSpan(paramTypeface), 0, paramCharSequence.length(), 33);
    }
    return paramCharSequence;
  }

  // ERROR //
  static String pullFontPathFromStyle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_m1
    //   2: if_icmpne +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: aload_0
    //   8: aload_1
    //   9: iconst_1
    //   10: newarray int
    //   12: dup
    //   13: iconst_0
    //   14: iload_2
    //   15: iastore
    //   16: invokevirtual 121	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnull +33 -> 54
    //   24: aload_3
    //   25: iconst_0
    //   26: invokevirtual 127	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   29: astore 6
    //   31: aload 6
    //   33: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: istore 7
    //   38: iload 7
    //   40: ifne +10 -> 50
    //   43: aload_3
    //   44: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   47: aload 6
    //   49: areturn
    //   50: aload_3
    //   51: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   54: aconst_null
    //   55: areturn
    //   56: astore 5
    //   58: aload_3
    //   59: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   62: goto -8 -> 54
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   71: aload 4
    //   73: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   24	38	56	java/lang/Exception
    //   24	38	65	finally
  }

  // ERROR //
  static String pullFontPathFromTextAppearance(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_m1
    //   2: if_icmpne +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: iconst_m1
    //   8: istore_3
    //   9: aload_0
    //   10: aload_1
    //   11: iconst_1
    //   12: newarray int
    //   14: dup
    //   15: iconst_0
    //   16: ldc 132
    //   18: iastore
    //   19: invokevirtual 121	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +20 -> 46
    //   29: aload 4
    //   31: iconst_0
    //   32: iconst_m1
    //   33: invokevirtual 136	android/content/res/TypedArray:getResourceId	(II)I
    //   36: istore 11
    //   38: iload 11
    //   40: istore_3
    //   41: aload 4
    //   43: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   46: aload_0
    //   47: iload_3
    //   48: iconst_1
    //   49: newarray int
    //   51: dup
    //   52: iconst_0
    //   53: iload_2
    //   54: iastore
    //   55: invokevirtual 139	android/content/Context:obtainStyledAttributes	(I[I)Landroid/content/res/TypedArray;
    //   58: astore 5
    //   60: aload 5
    //   62: ifnull -57 -> 5
    //   65: aload 5
    //   67: iconst_0
    //   68: invokevirtual 127	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 5
    //   75: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   78: aload 8
    //   80: areturn
    //   81: astore 10
    //   83: aload 4
    //   85: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore 9
    //   92: aload 4
    //   94: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   97: aload 9
    //   99: athrow
    //   100: astore 7
    //   102: aload 5
    //   104: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore 6
    //   111: aload 5
    //   113: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   116: aload 6
    //   118: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   29	38	81	java/lang/Exception
    //   29	38	90	finally
    //   65	73	100	java/lang/Exception
    //   65	73	109	finally
  }

  // ERROR //
  static String pullFontPathFromTheme(Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_m1
    //   2: if_icmpeq +8 -> 10
    //   5: iload_2
    //   6: iconst_m1
    //   7: if_icmpne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 145	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   16: astore_3
    //   17: new 147	android/util/TypedValue
    //   20: dup
    //   21: invokespecial 148	android/util/TypedValue:<init>	()V
    //   24: astore 4
    //   26: aload_3
    //   27: iload_1
    //   28: aload 4
    //   30: iconst_1
    //   31: invokevirtual 154	android/content/res/Resources$Theme:resolveAttribute	(ILandroid/util/TypedValue;Z)Z
    //   34: pop
    //   35: aload_3
    //   36: aload 4
    //   38: getfield 158	android/util/TypedValue:resourceId	I
    //   41: iconst_1
    //   42: newarray int
    //   44: dup
    //   45: iconst_0
    //   46: iload_2
    //   47: iastore
    //   48: invokevirtual 159	android/content/res/Resources$Theme:obtainStyledAttributes	(I[I)Landroid/content/res/TypedArray;
    //   51: astore 6
    //   53: aload 6
    //   55: iconst_0
    //   56: invokevirtual 127	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   59: astore 9
    //   61: aload 6
    //   63: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   66: aload 9
    //   68: areturn
    //   69: astore 8
    //   71: aload 6
    //   73: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore 7
    //   80: aload 6
    //   82: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   85: aload 7
    //   87: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   53	61	69	java/lang/Exception
    //   53	61	78	finally
  }

  // ERROR //
  static String pullFontPathFromTheme(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_m1
    //   2: if_icmpeq +8 -> 10
    //   5: iload_3
    //   6: iconst_m1
    //   7: if_icmpne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 145	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   16: astore 4
    //   18: new 147	android/util/TypedValue
    //   21: dup
    //   22: invokespecial 148	android/util/TypedValue:<init>	()V
    //   25: astore 5
    //   27: aload 4
    //   29: iload_1
    //   30: aload 5
    //   32: iconst_1
    //   33: invokevirtual 154	android/content/res/Resources$Theme:resolveAttribute	(ILandroid/util/TypedValue;Z)Z
    //   36: pop
    //   37: aload 4
    //   39: aload 5
    //   41: getfield 158	android/util/TypedValue:resourceId	I
    //   44: iconst_1
    //   45: newarray int
    //   47: dup
    //   48: iconst_0
    //   49: iload_2
    //   50: iastore
    //   51: invokevirtual 159	android/content/res/Resources$Theme:obtainStyledAttributes	(I[I)Landroid/content/res/TypedArray;
    //   54: astore 7
    //   56: aload 7
    //   58: iconst_0
    //   59: iconst_m1
    //   60: invokevirtual 136	android/content/res/TypedArray:getResourceId	(II)I
    //   63: istore 10
    //   65: aload 7
    //   67: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   70: iload 10
    //   72: iconst_m1
    //   73: if_icmpeq -63 -> 10
    //   76: aload_0
    //   77: iload 10
    //   79: iconst_1
    //   80: newarray int
    //   82: dup
    //   83: iconst_0
    //   84: iload_3
    //   85: iastore
    //   86: invokevirtual 139	android/content/Context:obtainStyledAttributes	(I[I)Landroid/content/res/TypedArray;
    //   89: astore 11
    //   91: aload 11
    //   93: ifnull -83 -> 10
    //   96: aload 11
    //   98: iconst_0
    //   99: invokevirtual 127	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   102: astore 14
    //   104: aload 11
    //   106: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   109: aload 14
    //   111: areturn
    //   112: astore 9
    //   114: aload 7
    //   116: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore 8
    //   123: aload 7
    //   125: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   128: aload 8
    //   130: athrow
    //   131: astore 13
    //   133: aload 11
    //   135: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 12
    //   142: aload 11
    //   144: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   147: aload 12
    //   149: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   56	65	112	java/lang/Exception
    //   56	65	121	finally
    //   96	104	131	java/lang/Exception
    //   96	104	140	finally
  }

  static String pullFontPathFromView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    if (paramInt == -1)
      return null;
    String str;
    try
    {
      str = paramContext.getResources().getResourceEntryName(paramInt);
      int i = paramAttributeSet.getAttributeResourceValue(null, str, -1);
      if (i > 0)
        return paramContext.getString(i);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      return null;
    }
    return paramAttributeSet.getAttributeValue(null, str);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyUtils
 * JD-Core Version:    0.6.2
 */