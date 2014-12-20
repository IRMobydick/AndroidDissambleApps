package se.verifique.app.cedula;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;
import se.verifique.app.cedula.c.a;
import se.verifique.app.cedula.c.b;
import se.verifique.app.cedula.util.Parametros;

public class n extends Fragment
{
  private b P;

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903058, paramViewGroup, false);
    if (this.P != null)
      ((TextView)localView.findViewById(2131230775)).setText(this.P.b);
    return localView;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (b().containsKey("item_id"))
      this.P = ((b)a.b.get(b().getString("item_id")));
    Parametros.a(c());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.n
 * JD-Core Version:    0.6.0
 */