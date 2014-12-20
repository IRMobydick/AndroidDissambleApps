package se.verifique.app.cedula;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.TextView;
import com.google.b.a.a.p;
import se.verifique.app.cedula.util.Parametros;

public class EscribirPlacaActivity extends Activity
{
  private m a = null;
  private String b;
  private EditText c;
  private View d;
  private View e;
  private TextView f;

  @TargetApi(13)
  private void a(boolean paramBoolean)
  {
    int i = 8;
    int j = 0;
    if (Build.VERSION.SDK_INT >= 13)
    {
      int n = getResources().getInteger(17694720);
      this.e.setVisibility(0);
      ViewPropertyAnimator localViewPropertyAnimator1 = this.e.animate().setDuration(n);
      ViewPropertyAnimator localViewPropertyAnimator2;
      if (paramBoolean)
      {
        int i1 = 1;
        localViewPropertyAnimator1.alpha(i1).setListener(new k(this, paramBoolean));
        this.d.setVisibility(0);
        localViewPropertyAnimator2 = this.d.animate().setDuration(n);
        if (!paramBoolean)
          break label129;
      }
      while (true)
      {
        localViewPropertyAnimator2.alpha(j).setListener(new l(this, paramBoolean));
        return;
        int i2 = 0;
        break;
        label129: int k = 1;
      }
    }
    View localView1 = this.e;
    int m;
    label147: View localView2;
    if (paramBoolean)
    {
      m = 0;
      localView1.setVisibility(m);
      localView2 = this.d;
      if (!paramBoolean)
        break label179;
    }
    while (true)
    {
      localView2.setVisibility(i);
      break;
      m = i;
      break label147;
      label179: i = 0;
    }
  }

  public void a()
  {
    if (this.a != null)
      return;
    this.c.setError(null);
    this.b = this.c.getText().toString();
    EditText localEditText;
    if (TextUtils.isEmpty(this.b))
    {
      this.c.setError(getString(2131165335));
      localEditText = this.c;
    }
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        localEditText.requestFocus();
        break;
      }
      this.f.setText(2131165331);
      a(true);
      this.a = new m(this);
      m localm = this.a;
      Void[] arrayOfVoid = new Void[1];
      arrayOfVoid[0] = null;
      localm.execute(arrayOfVoid);
      break;
      localEditText = null;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    this.c = ((EditText)findViewById(2131230765));
    this.c.setText(this.b);
    this.d = findViewById(2131230762);
    this.e = findViewById(2131230760);
    this.f = ((TextView)findViewById(2131230761));
    findViewById(2131230764).setOnClickListener(new j(this));
    Parametros.a(this);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131492865, paramMenu);
    return true;
  }

  public void onStart()
  {
    super.onStart();
    p.a(this).a(this);
  }

  public void onStop()
  {
    super.onStop();
    p.a(this).b(this);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.EscribirPlacaActivity
 * JD-Core Version:    0.6.0
 */