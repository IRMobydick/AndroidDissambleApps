package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class DeferredRequestCreator
  implements ViewTreeObserver.OnPreDrawListener
{
  Callback callback;
  final RequestCreator creator;
  final WeakReference<ImageView> target;

  DeferredRequestCreator(RequestCreator paramRequestCreator, ImageView paramImageView)
  {
    this(paramRequestCreator, paramImageView, null);
  }

  DeferredRequestCreator(RequestCreator paramRequestCreator, ImageView paramImageView, Callback paramCallback)
  {
    this.creator = paramRequestCreator;
    this.target = new WeakReference(paramImageView);
    this.callback = paramCallback;
    paramImageView.getViewTreeObserver().addOnPreDrawListener(this);
  }

  void cancel()
  {
    this.callback = null;
    ImageView localImageView = (ImageView)this.target.get();
    if (localImageView == null);
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = localImageView.getViewTreeObserver();
    }
    while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.removeOnPreDrawListener(this);
  }

  public boolean onPreDraw()
  {
    ImageView localImageView = (ImageView)this.target.get();
    if (localImageView == null);
    ViewTreeObserver localViewTreeObserver;
    int i;
    int j;
    do
    {
      do
      {
        return true;
        localViewTreeObserver = localImageView.getViewTreeObserver();
      }
      while (!localViewTreeObserver.isAlive());
      i = localImageView.getMeasuredWidth();
      j = localImageView.getMeasuredHeight();
    }
    while ((i <= 0) || (j <= 0));
    localViewTreeObserver.removeOnPreDrawListener(this);
    this.creator.unfit().resize(i, j).into(localImageView, this.callback);
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.DeferredRequestCreator
 * JD-Core Version:    0.6.2
 */