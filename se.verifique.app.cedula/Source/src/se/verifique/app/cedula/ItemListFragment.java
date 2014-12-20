package se.verifique.app.cedula;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.y;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;
import se.verifique.app.cedula.c.a;
import se.verifique.app.cedula.c.b;
import se.verifique.app.cedula.util.Parametros;

public class ItemListFragment extends y
{
  private static p Z = new o();
  private p X = Z;
  private int Y = -1;

  private void a(int paramInt)
  {
    if (paramInt == -1)
      y().setItemChecked(this.Y, false);
    while (true)
    {
      this.Y = paramInt;
      return;
      y().setItemChecked(paramInt, true);
    }
  }

  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (!(paramActivity instanceof p))
      throw new IllegalStateException("Activity must implement fragment's callbacks.");
    this.X = ((p)paramActivity);
  }

  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("activated_position")))
      a(paramBundle.getInt("activated_position"));
  }

  public void a(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramListView, paramView, paramInt, paramLong);
    this.X.b_(((b)a.a.get(paramInt)).a);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    a(new ArrayAdapter(c(), 17367062, 16908308, a.a));
    Parametros.a(c());
  }

  public void g(Bundle paramBundle)
  {
    super.g(paramBundle);
    if (this.Y != -1)
      paramBundle.putInt("activated_position", this.Y);
  }

  public void n()
  {
    super.n();
    this.X = Z;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.ItemListFragment
 * JD-Core Version:    0.6.0
 */