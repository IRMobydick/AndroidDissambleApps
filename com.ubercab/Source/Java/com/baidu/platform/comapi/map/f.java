package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comjni.map.basemap.a;
import java.util.Iterator;
import java.util.List;

class f extends Handler
{
  f(e parame)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (e.a(this.a) == null)
      break label15;
    while (true)
    {
      label15: return;
      if (((Integer)paramMessage.obj).intValue() == e.b(this.a))
        if (paramMessage.what == 4000)
        {
          Iterator localIterator4 = e.c(this.a).iterator();
          while (localIterator4.hasNext())
          {
            g localg = (g)localIterator4.next();
            int i = paramMessage.arg2;
            Bitmap localBitmap = null;
            if (i == 1)
            {
              int[] arrayOfInt1 = new int[e.d(this.a) * e.e(this.a)];
              int[] arrayOfInt2 = new int[e.d(this.a) * e.e(this.a)];
              int[] arrayOfInt3 = e.a(this.a).a(arrayOfInt1);
              for (int j = 0; j < e.e(this.a); j++)
                for (int k = 0; k < e.d(this.a); k++)
                {
                  int m = arrayOfInt3[(k + j * e.d(this.a))];
                  int n = 0xFF & m >> 16 | (0xFF0000 & m << 16 | m & 0xFF00FF00);
                  arrayOfInt2[(k + (-1 + (e.e(this.a) - j)) * e.d(this.a))] = n;
                }
              localBitmap = Bitmap.createBitmap(arrayOfInt2, e.d(this.a), e.e(this.a), Bitmap.Config.ARGB_8888);
            }
            localg.a(localBitmap);
          }
        }
        else if (paramMessage.what == 39)
        {
          if (paramMessage.arg1 == 100)
            e.f(this.a);
          while ((!e.h(this.a)) && (e.e(this.a) > 0) && (e.d(this.a) > 0) && (this.a.a(0, 0) != null))
          {
            e.a(this.a, true);
            Iterator localIterator3 = e.c(this.a).iterator();
            while (localIterator3.hasNext())
              ((g)localIterator3.next()).b();
            if (paramMessage.arg1 == 200)
              e.g(this.a);
            else if (paramMessage.arg1 == 1)
              this.a.requestRender();
            else if ((paramMessage.arg1 == 0) && (this.a.getRenderMode() != 0))
              this.a.setRenderMode(0);
          }
          Iterator localIterator2 = e.c(this.a).iterator();
          while (localIterator2.hasNext())
            ((g)localIterator2.next()).a();
        }
        else
        {
          if ((paramMessage.what != 41) || ((!e.i(this.a)) && (!e.j(this.a))))
            break;
          Iterator localIterator1 = e.c(this.a).iterator();
          while (localIterator1.hasNext())
            ((g)localIterator1.next()).b(this.a.m());
        }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.map.f
 * JD-Core Version:    0.6.2
 */