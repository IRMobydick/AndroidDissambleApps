package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

final class oi
  implements jd, Runnable
{
  private final List a = new Vector();
  private final CountDownLatch b = new CountDownLatch(1);
  private final AtomicReference c = new AtomicReference();
  private oj d;

  public oi(oj paramoj)
  {
    this.d = paramoj;
    if (hh.b())
      gt.a(this);
    while (true)
    {
      return;
      run();
    }
  }

  private void a()
  {
    try
    {
      this.b.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        hi.c("Interrupted during GADSignals creation.", localInterruptedException);
    }
  }

  private void b()
  {
    if (this.a.isEmpty());
    while (true)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object[] arrayOfObject = (Object[])localIterator.next();
        if (arrayOfObject.length == 1)
        {
          ((Runnable)this.c.get()).a((MotionEvent)arrayOfObject[0]);
          continue;
        }
        if (arrayOfObject.length != 3)
          continue;
        ((Runnable)this.c.get()).a(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
      }
    }
  }

  public String a(Context paramContext)
  {
    a();
    if (this.c.get() != null)
      b();
    for (String str = ((Runnable)this.c.get()).a(paramContext); ; str = "")
      return str;
  }

  public String a(Context paramContext, String paramString)
  {
    a();
    if (this.c.get() != null)
      b();
    for (String str = ((Runnable)this.c.get()).a(paramContext, paramString); ; str = "")
      return str;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    jd localjd = (Runnable)this.c.get();
    if (localjd != null)
    {
      b();
      localjd.a(paramInt1, paramInt2, paramInt3);
    }
    while (true)
    {
      return;
      List localList = this.a;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramInt3);
      localList.add(arrayOfObject);
    }
  }

  public void a(MotionEvent paramMotionEvent)
  {
    jd localjd = (Runnable)this.c.get();
    if (localjd != null)
    {
      b();
      localjd.a(paramMotionEvent);
    }
    while (true)
    {
      return;
      List localList = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramMotionEvent;
      localList.add(arrayOfObject);
    }
  }

  public String b(Context paramContext)
  {
    a();
    if (this.c.get() != null)
      b();
    for (String str = ((Runnable)this.c.get()).b(paramContext); ; str = "")
      return str;
  }

  public void run()
  {
    try
    {
      this.c.set(mm.a(this.d.e.c, this.d.c));
      return;
    }
    finally
    {
      this.b.countDown();
      this.d = null;
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oi
 * JD-Core Version:    0.6.0
 */