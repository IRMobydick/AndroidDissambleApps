package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class Action<T>
{
  boolean cancelled;
  final Drawable errorDrawable;
  final int errorResId;
  final String key;
  final boolean noFade;
  final Picasso picasso;
  final Request request;
  final boolean skipCache;
  final WeakReference<T> target;
  boolean willReplay;

  Action(Picasso paramPicasso, T paramT, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Drawable paramDrawable, String paramString)
  {
    this.picasso = paramPicasso;
    this.request = paramRequest;
    this.target = new RequestWeakReference(this, paramT, paramPicasso.referenceQueue);
    this.skipCache = paramBoolean1;
    this.noFade = paramBoolean2;
    this.errorResId = paramInt;
    this.errorDrawable = paramDrawable;
    this.key = paramString;
  }

  void cancel()
  {
    this.cancelled = true;
  }

  abstract void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom);

  abstract void error();

  String getKey()
  {
    return this.key;
  }

  Picasso getPicasso()
  {
    return this.picasso;
  }

  Request getRequest()
  {
    return this.request;
  }

  T getTarget()
  {
    return this.target.get();
  }

  boolean isCancelled()
  {
    return this.cancelled;
  }

  boolean willReplay()
  {
    return this.willReplay;
  }

  static class RequestWeakReference<T> extends WeakReference<T>
  {
    final Action action;

    public RequestWeakReference(Action paramAction, T paramT, ReferenceQueue<? super T> paramReferenceQueue)
    {
      super(paramReferenceQueue);
      this.action = paramAction;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Action
 * JD-Core Version:    0.6.2
 */