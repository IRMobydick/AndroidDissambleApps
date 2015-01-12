package com.paypal.android.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bl
{
  private static final Map a = Collections.unmodifiableMap(localHashMap);
  private static Pattern b = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");
  private static HashMap c = new HashMap();

  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("px", Integer.valueOf(0));
    localHashMap.put("dip", Integer.valueOf(1));
    localHashMap.put("dp", Integer.valueOf(1));
    localHashMap.put("sp", Integer.valueOf(2));
    localHashMap.put("pt", Integer.valueOf(3));
    localHashMap.put("in", Integer.valueOf(4));
    localHashMap.put("mm", Integer.valueOf(5));
  }

  public static int a(String paramString, Context paramContext)
  {
    if (paramString == null)
      return 0;
    return (int)b(paramString, paramContext);
  }

  public static Bitmap a(String paramString, Context paramContext, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (paramContext != null);
    for (localOptions.inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi; ; localOptions.inTargetDensity = 160)
    {
      localOptions.inDensity = 240;
      localOptions.inScaled = false;
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
  }

  public static SpannableString a(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new UnderlineSpan(), 0, paramString.length(), 0);
    return localSpannableString;
  }

  public static View a(LinearLayout paramLinearLayout)
  {
    return a(paramLinearLayout, "12dip", "12dip");
  }

  public static View a(LinearLayout paramLinearLayout, String paramString1, String paramString2)
  {
    View localView = new View(paramLinearLayout.getContext());
    paramLinearLayout.addView(localView);
    a(localView, new ColorDrawable(bk.e));
    a(localView, -1, "1dip");
    b(localView, null, paramString1, null, paramString2);
    return localView;
  }

  public static LinearLayout a(Context paramContext, boolean paramBoolean, int paramInt, LinearLayout paramLinearLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    if (paramInt != 0)
      localLinearLayout.setId(paramInt);
    paramLinearLayout.addView(localLinearLayout);
    localLinearLayout.setGravity(17);
    localLinearLayout.setOrientation(0);
    a(localLinearLayout, paramBoolean, paramContext);
    a(localLinearLayout, -1, "58dip");
    b(localLinearLayout, null, null, null, "4dip");
    return localLinearLayout;
  }

  public static void a(View paramView)
  {
    b(paramView, "4dip", null, "4dip", null);
  }

  public static void a(View paramView, int paramInt, float paramFloat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLayoutParams;
      localLayoutParams1.gravity = paramInt;
      localLayoutParams1.weight = paramFloat;
    }
  }

  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
  }

  public static void a(View paramView, int paramInt, String paramString)
  {
    a(paramView, paramInt, a(paramString, paramView.getContext()));
  }

  private static void a(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }

  public static void a(View paramView, String paramString, int paramInt)
  {
    a(paramView, a(paramString, paramView.getContext()), -2);
  }

  public static void a(View paramView, String paramString1, String paramString2)
  {
    b(paramView, "4dip", paramString1, "4dip", paramString2);
  }

  public static void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Context localContext = paramView.getContext();
    paramView.setPadding(a(paramString1, localContext), a(paramString2, localContext), a(paramString3, localContext), a(paramString4, localContext));
  }

  public static void a(View paramView, boolean paramBoolean, Context paramContext)
  {
    a(paramView, -1, -2);
    a(paramView, "10dip", "0dip", "10dip", "0dip");
    if (paramBoolean);
    for (Drawable localDrawable = bk.a(paramContext); ; localDrawable = bk.b(paramContext))
    {
      a(paramView, localDrawable);
      paramView.setFocusable(true);
      paramView.setMinimumHeight(a("54dip", paramContext));
      if ((paramView instanceof TextView))
        a((TextView)paramView);
      if (!(paramView instanceof Button))
        paramView.setClickable(true);
      return;
    }
  }

  public static void a(Button paramButton)
  {
    a(paramButton, 17);
  }

  public static void a(Button paramButton, int paramInt)
  {
    a(paramButton, "2dip", "2dip", "2dip", "2dip");
    paramButton.setTypeface(bk.l);
    paramButton.setTextColor(bk.p);
    if (Build.VERSION.SDK_INT < 16)
      paramButton.setBackgroundDrawable(bk.c(paramButton.getContext()));
    while (true)
    {
      paramButton.setAutoLinkMask(15);
      paramButton.setTextSize(14.0F);
      paramButton.setTextColor(bk.p);
      paramButton.setGravity(paramInt);
      return;
      paramButton.setBackground(bk.c(paramButton.getContext()));
    }
  }

  public static void a(TextView paramTextView)
  {
    paramTextView.setGravity(17);
    paramTextView.setTextColor(-1);
    paramTextView.setTextSize(20.0F);
    paramTextView.setTypeface(bk.k);
  }

  public static float b(String paramString, Context paramContext)
  {
    if (paramString == null)
      return 0.0F;
    String str1 = paramString.toLowerCase();
    if (c.containsKey(str1))
      return ((Float)c.get(str1)).floatValue();
    Matcher localMatcher = b.matcher(str1);
    if (!localMatcher.matches())
      throw new NumberFormatException();
    float f1 = Float.parseFloat(localMatcher.group(1));
    String str2 = localMatcher.group(3).toLowerCase();
    Integer localInteger = (Integer)a.get(str2);
    if (localInteger == null)
      localInteger = Integer.valueOf(1);
    float f2 = TypedValue.applyDimension(localInteger.intValue(), f1, paramContext.getResources().getDisplayMetrics());
    c.put(str1, Float.valueOf(f2));
    return f2;
  }

  public static void b(View paramView, String paramString1, String paramString2)
  {
    Context localContext = paramView.getContext();
    a(paramView, a(paramString1, localContext), a(paramString2, localContext));
  }

  public static void b(View paramView, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Context localContext = paramView.getContext();
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(a(paramString1, localContext), a(paramString2, localContext), a(paramString3, localContext), a(paramString4, localContext));
  }

  public static void b(TextView paramTextView)
  {
    paramTextView.setTextColor(bk.i);
    paramTextView.setLinkTextColor(bk.p);
    paramTextView.setTypeface(bk.o);
    paramTextView.setTextSize(13.0F);
    paramTextView.setSingleLine(false);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }

  public static Bitmap c(String paramString, Context paramContext)
  {
    return a(paramString, paramContext, 240);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bl
 * JD-Core Version:    0.6.2
 */