package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.plus.internal.g;

public final class PlusOneButton extends FrameLayout
{
  public static final int ANNOTATION_BUBBLE = 1;
  public static final int ANNOTATION_INLINE = 2;
  public static final int ANNOTATION_NONE = 0;
  public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
  public static final int SIZE_MEDIUM = 1;
  public static final int SIZE_SMALL = 0;
  public static final int SIZE_STANDARD = 3;
  public static final int SIZE_TALL = 2;
  private View all;
  private int alm;
  private int aln;
  private OnPlusOneClickListener alo;
  private int mSize;
  private String uR;

  public PlusOneButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public PlusOneButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mSize = getSize(paramContext, paramAttributeSet);
    this.alm = getAnnotation(paramContext, paramAttributeSet);
    this.aln = -1;
    G(getContext());
    if (isInEditMode());
  }

  private void G(Context paramContext)
  {
    if (this.all != null)
      removeView(this.all);
    this.all = g.a(paramContext, this.mSize, this.alm, this.uR, this.aln);
    setOnPlusOneClickListener(this.alo);
    addView(this.all);
  }

  protected static int getAnnotation(Context paramContext, AttributeSet paramAttributeSet)
  {
    String str = r.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    int i;
    if ("INLINE".equalsIgnoreCase(str))
      i = 2;
    boolean bool;
    do
    {
      return i;
      bool = "NONE".equalsIgnoreCase(str);
      i = 0;
    }
    while (bool);
    return 1;
  }

  protected static int getSize(Context paramContext, AttributeSet paramAttributeSet)
  {
    String str = r.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if ("SMALL".equalsIgnoreCase(str))
      return 0;
    if ("MEDIUM".equalsIgnoreCase(str))
      return 1;
    if ("TALL".equalsIgnoreCase(str))
      return 2;
    return 3;
  }

  public void initialize(String paramString, int paramInt)
  {
    o.a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
    this.uR = paramString;
    this.aln = paramInt;
    G(getContext());
  }

  public void initialize(String paramString, OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.uR = paramString;
    this.aln = 0;
    G(getContext());
    setOnPlusOneClickListener(paramOnPlusOneClickListener);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.all.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.all;
    measureChild(localView, paramInt1, paramInt2);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }

  public void setAnnotation(int paramInt)
  {
    this.alm = paramInt;
    G(getContext());
  }

  public void setOnPlusOneClickListener(OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.alo = paramOnPlusOneClickListener;
    this.all.setOnClickListener(new DefaultOnPlusOneClickListener(paramOnPlusOneClickListener));
  }

  public void setSize(int paramInt)
  {
    this.mSize = paramInt;
    G(getContext());
  }

  protected class DefaultOnPlusOneClickListener
    implements View.OnClickListener, PlusOneButton.OnPlusOneClickListener
  {
    private final PlusOneButton.OnPlusOneClickListener alp;

    public DefaultOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener arg2)
    {
      Object localObject;
      this.alp = localObject;
    }

    public void onClick(View paramView)
    {
      Intent localIntent = (Intent)PlusOneButton.a(PlusOneButton.this).getTag();
      if (this.alp != null)
      {
        this.alp.onPlusOneClick(localIntent);
        return;
      }
      onPlusOneClick(localIntent);
    }

    public void onPlusOneClick(Intent paramIntent)
    {
      Context localContext = PlusOneButton.this.getContext();
      if (((localContext instanceof Activity)) && (paramIntent != null))
        ((Activity)localContext).startActivityForResult(paramIntent, PlusOneButton.b(PlusOneButton.this));
    }
  }

  public static abstract interface OnPlusOneClickListener
  {
    public abstract void onPlusOneClick(Intent paramIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.PlusOneButton
 * JD-Core Version:    0.6.2
 */