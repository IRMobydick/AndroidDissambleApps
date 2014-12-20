package se.verifique.app.cedula;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.h;
import android.support.v4.app.x;
import android.view.MenuItem;
import se.verifique.app.cedula.util.Parametros;

public class ItemDetailActivity extends h
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    if (paramBundle == null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("item_id", getIntent().getStringExtra("item_id"));
      n localn = new n();
      localn.b(localBundle);
      e().a().a(2131230766, localn).a();
    }
    Parametros.a(this);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
      af.a(this, new Intent(this, PrincipalActivity.class));
    for (boolean bool = true; ; bool = super.onOptionsItemSelected(paramMenuItem))
      return bool;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.ItemDetailActivity
 * JD-Core Version:    0.6.0
 */