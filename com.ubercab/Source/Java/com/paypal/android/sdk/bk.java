package com.paypal.android.sdk;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.DisplayMetrics;

public final class bk
{
  private static int A;
  private static int B;
  private static int C;
  private static int D;
  private static int E;
  public static final int a;
  public static final Drawable b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  public static final Typeface k;
  public static final Typeface l;
  public static final Typeface m;
  public static final Typeface n;
  public static final Typeface o;
  public static final ColorStateList p = new ColorStateList(arrayOfInt, arrayOfInt1);
  private static int[] q = { 16842919, 16842910 };
  private static int[] r = { 16842910 };
  private static int[] s = { -16842910 };
  private static int[] t = { 16842908 };
  private static int u;
  private static int v;
  private static int w;
  private static int x;
  private static int y;
  private static int z;

  static
  {
    a = Color.parseColor("#003087");
    u = Color.parseColor("#aa003087");
    v = Color.parseColor("#009CDE");
    b = new ColorDrawable(Color.parseColor("#55a0cc"));
    c = Color.parseColor("#f5f5f5");
    d = Color.parseColor("#c4dceb");
    w = a;
    x = u;
    y = v;
    z = Color.parseColor("#c5ddeb");
    A = Color.parseColor("#717074");
    B = Color.parseColor("#aa717074");
    C = Color.parseColor("#5a5a5d");
    D = Color.parseColor("#f5f5f5");
    e = Color.parseColor("#e5e5e5");
    Color.parseColor("#333333");
    E = Color.parseColor("#515151");
    f = Color.parseColor("#797979");
    Color.parseColor("#b32317");
    g = E;
    h = E;
    i = E;
    j = f;
    Typeface.create("sans-serif-light", 0);
    k = Typeface.create("sans-serif-light", 0);
    l = Typeface.create("sans-serif-light", 0);
    Typeface.create("sans-serif-bold", 0);
    m = Typeface.create("sans-serif-light", 0);
    n = Typeface.create("sans-serif", 0);
    o = Typeface.create("sans-serif-light", 0);
    int[][] arrayOfInt = new int[2][];
    arrayOfInt[0] = q;
    arrayOfInt[1] = r;
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = y;
    arrayOfInt1[1] = w;
  }

  private static Drawable a(int paramInt, float paramFloat)
  {
    Drawable[] arrayOfDrawable = new Drawable[2];
    arrayOfDrawable[0] = new ColorDrawable(paramInt);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RectShape());
    localShapeDrawable.getPaint().setStrokeWidth(2.0F * paramFloat);
    localShapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
    localShapeDrawable.getPaint().setColor(c);
    arrayOfDrawable[1] = localShapeDrawable;
    return new LayerDrawable(arrayOfDrawable);
  }

  private static Drawable a(int paramInt1, int paramInt2, float paramFloat)
  {
    Drawable[] arrayOfDrawable = new Drawable[3];
    arrayOfDrawable[0] = new ColorDrawable(paramInt1);
    ShapeDrawable localShapeDrawable1 = new ShapeDrawable(new RectShape());
    localShapeDrawable1.getPaint().setStrokeWidth(2.0F * paramFloat);
    localShapeDrawable1.getPaint().setStyle(Paint.Style.STROKE);
    localShapeDrawable1.getPaint().setColor(c);
    arrayOfDrawable[1] = localShapeDrawable1;
    ShapeDrawable localShapeDrawable2 = new ShapeDrawable(new RectShape());
    localShapeDrawable2.getPaint().setStrokeWidth(paramFloat);
    localShapeDrawable2.getPaint().setStyle(Paint.Style.STROKE);
    localShapeDrawable2.getPaint().setColor(paramInt2);
    arrayOfDrawable[2] = localShapeDrawable2;
    return new LayerDrawable(arrayOfDrawable);
  }

  public static Drawable a(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(q, new ColorDrawable(y));
    localStateListDrawable.addState(s, new ColorDrawable(z));
    localStateListDrawable.addState(t, a(w, x, d(paramContext)));
    localStateListDrawable.addState(r, a(w, d(paramContext)));
    return localStateListDrawable;
  }

  public static Drawable b(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(q, new ColorDrawable(C));
    localStateListDrawable.addState(s, new ColorDrawable(D));
    localStateListDrawable.addState(t, a(A, B, d(paramContext)));
    localStateListDrawable.addState(r, a(A, d(paramContext)));
    return localStateListDrawable;
  }

  protected static Drawable c(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(t, a(0, x, d(paramContext)));
    localStateListDrawable.addState(r, new ColorDrawable(0));
    return localStateListDrawable;
  }

  private static float d(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density * (bl.b("4dip", paramContext) / 2.0F);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bk
 * JD-Core Version:    0.6.2
 */