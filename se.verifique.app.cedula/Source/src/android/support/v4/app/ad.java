package android.support.v4.app;

import android.support.v4.c.a;
import android.support.v4.c.c;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ad extends ab
{
  static boolean a = false;
  final c b = new c();
  final c c = new c();
  final String d;
  h e;
  boolean f;
  boolean g;

  ad(String paramString, h paramh, boolean paramBoolean)
  {
    this.d = paramString;
    this.e = paramh;
    this.f = paramBoolean;
  }

  void a(h paramh)
  {
    this.e = paramh;
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    if (this.b.a() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      String str2 = paramString + "    ";
      for (int j = 0; j < this.b.a(); j++)
      {
        ae localae2 = (ae)this.b.b(j);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.b.a(j));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localae2.toString());
        localae2.a(str2, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
    if (this.c.a() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      String str1 = paramString + "    ";
      while (i < this.c.a())
      {
        ae localae1 = (ae)this.c.b(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.c.a(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localae1.toString());
        localae1.a(str1, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i++;
      }
    }
  }

  public boolean a()
  {
    int i = this.b.a();
    int j = 0;
    int k = 0;
    if (j < i)
    {
      ae localae = (ae)this.b.b(j);
      if ((localae.h) && (!localae.f));
      for (int m = 1; ; m = 0)
      {
        k |= m;
        j++;
        break;
      }
    }
    return k;
  }

  void b()
  {
    if (a)
      Log.v("LoaderManager", "Starting in " + this);
    if (this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      this.f = true;
      for (int i = -1 + this.b.a(); i >= 0; i--)
        ((ae)this.b.b(i)).a();
    }
  }

  void c()
  {
    if (a)
      Log.v("LoaderManager", "Stopping in " + this);
    if (!this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      for (int i = -1 + this.b.a(); i >= 0; i--)
        ((ae)this.b.b(i)).e();
      this.f = false;
    }
  }

  void d()
  {
    if (a)
      Log.v("LoaderManager", "Retaining in " + this);
    if (!this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      this.g = true;
      this.f = false;
      for (int i = -1 + this.b.a(); i >= 0; i--)
        ((ae)this.b.b(i)).b();
    }
  }

  void e()
  {
    if (this.g)
    {
      if (a)
        Log.v("LoaderManager", "Finished Retaining in " + this);
      this.g = false;
      for (int i = -1 + this.b.a(); i >= 0; i--)
        ((ae)this.b.b(i)).c();
    }
  }

  void f()
  {
    for (int i = -1 + this.b.a(); i >= 0; i--)
      ((ae)this.b.b(i)).k = true;
  }

  void g()
  {
    for (int i = -1 + this.b.a(); i >= 0; i--)
      ((ae)this.b.b(i)).d();
  }

  void h()
  {
    if (!this.g)
    {
      if (a)
        Log.v("LoaderManager", "Destroying Active in " + this);
      for (int j = -1 + this.b.a(); j >= 0; j--)
        ((ae)this.b.b(j)).f();
      this.b.b();
    }
    if (a)
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    for (int i = -1 + this.c.a(); i >= 0; i--)
      ((ae)this.c.b(i)).f();
    this.c.b();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    a.a(this.e, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ad
 * JD-Core Version:    0.6.0
 */