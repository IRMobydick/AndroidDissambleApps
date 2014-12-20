package se.verifique.app.cedula;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.TextView;
import com.google.b.a.a.p;
import se.verifique.app.cedula.util.Parametros;

public class EscribirCedulaActivity extends Activity
{
  private h a = null;
  private EscribirCedulaActivity b = this;
  private String c;
  private EditText d;
  private View e;
  private View f;
  private TextView g;

  @TargetApi(13)
  private void a(boolean paramBoolean)
  {
    int i = 8;
    int j = 0;
    if (Build.VERSION.SDK_INT >= 13)
    {
      int n = getResources().getInteger(17694720);
      this.f.setVisibility(0);
      ViewPropertyAnimator localViewPropertyAnimator1 = this.f.animate().setDuration(n);
      ViewPropertyAnimator localViewPropertyAnimator2;
      if (paramBoolean)
      {
        int i1 = 1;
        localViewPropertyAnimator1.alpha(i1).setListener(new e(this, paramBoolean));
        this.e.setVisibility(0);
        localViewPropertyAnimator2 = this.e.animate().setDuration(n);
        if (!paramBoolean)
          break label129;
      }
      while (true)
      {
        localViewPropertyAnimator2.alpha(j).setListener(new f(this, paramBoolean));
        return;
        int i2 = 0;
        break;
        label129: int k = 1;
      }
    }
    View localView1 = this.f;
    int m;
    label147: View localView2;
    if (paramBoolean)
    {
      m = 0;
      localView1.setVisibility(m);
      localView2 = this.e;
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
    this.d.setError(null);
    this.c = this.d.getText().toString();
    EditText localEditText;
    if (TextUtils.isEmpty(this.c))
    {
      this.d.setError(getString(2131165335));
      localEditText = this.d;
    }
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        localEditText.requestFocus();
        break;
      }
      this.g.setText(2131165331);
      a(true);
      this.a = new h(this);
      h localh = this.a;
      Void[] arrayOfVoid = new Void[1];
      arrayOfVoid[0] = null;
      localh.execute(arrayOfVoid);
      break;
      localEditText = null;
    }
  }

  public void a(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Noticia");
    if (("VFQ-TO".equals(paramString)) || ("ERROR".equals(paramString)))
      localBuilder.setMessage(getResources().getString(2131165273));
    while (true)
    {
      localBuilder.setCancelable(false);
      localBuilder.setPositiveButton("OK", new g(this));
      localBuilder.create().show();
      return;
      localBuilder.setMessage(paramString);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903045);
    this.c = getIntent().getStringExtra("se.verifique.app.cedula.extra.escribircedula");
    this.d = ((EditText)findViewById(2131230763));
    this.d.setText(this.c);
    this.e = findViewById(2131230762);
    this.f = findViewById(2131230760);
    this.g = ((TextView)findViewById(2131230761));
    findViewById(2131230764).setOnClickListener(new d(this));
    Parametros.a(this);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
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
 * Qualified Name:     se.verifique.app.cedula.EscribirCedulaActivity
 * JD-Core Version:    0.6.0
 */