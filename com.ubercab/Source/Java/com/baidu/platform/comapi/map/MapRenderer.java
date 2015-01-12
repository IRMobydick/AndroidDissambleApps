package com.baidu.platform.comapi.map;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MapRenderer
  implements GLSurfaceView.Renderer
{
  private static final String d = MapRenderer.class.getSimpleName();
  public int a;
  public int b;
  public int c;
  private int e;
  private a f;
  private final WeakReference<GLSurfaceView> g;

  public MapRenderer(WeakReference<GLSurfaceView> paramWeakReference, a parama)
  {
    this.f = parama;
    this.g = paramWeakReference;
  }

  private void a(GL10 paramGL10)
  {
    paramGL10.glClear(16640);
    paramGL10.glClearColor(0.85F, 0.8F, 0.8F, 0.0F);
  }

  private boolean a()
  {
    return this.e != 0;
  }

  private static native void nativeInit(int paramInt);

  private static native int nativeRender(int paramInt);

  private static native void nativeResize(int paramInt1, int paramInt2, int paramInt3);

  public void a(int paramInt)
  {
    this.e = paramInt;
  }

  public void onDrawFrame(GL10 paramGL10)
  {
    if (!a())
      a(paramGL10);
    GLSurfaceView localGLSurfaceView;
    do
    {
      int i;
      do
      {
        return;
        if (this.c <= 1)
        {
          nativeResize(this.e, this.a, this.b);
          this.c = (1 + this.c);
        }
        this.f.p();
        i = nativeRender(this.e);
        localGLSurfaceView = (GLSurfaceView)this.g.get();
      }
      while (localGLSurfaceView == null);
      if (i == 1)
      {
        localGLSurfaceView.requestRender();
        return;
      }
    }
    while (localGLSurfaceView.getRenderMode() == 0);
    localGLSurfaceView.setRenderMode(0);
  }

  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.e != 0)
      nativeResize(this.e, paramInt1, paramInt2);
  }

  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    nativeInit(this.e);
    if (!a())
      return;
    this.f.p();
  }

  public static abstract interface a
  {
    public abstract void p();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.map.MapRenderer
 * JD-Core Version:    0.6.2
 */