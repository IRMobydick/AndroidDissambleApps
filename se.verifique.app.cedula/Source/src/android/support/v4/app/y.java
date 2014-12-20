package android.support.v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class y extends Fragment
{
  ListAdapter P;
  ListView Q;
  View R;
  TextView S;
  View T;
  View U;
  CharSequence V;
  boolean W;
  private final Handler X = new Handler();
  private final Runnable Y = new z(this);
  private final AdapterView.OnItemClickListener Z = new aa(this);

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    z();
    if (this.T == null)
      throw new IllegalStateException("Can't be used with a custom content view");
    if (this.W == paramBoolean1)
      return;
    this.W = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.T.startAnimation(AnimationUtils.loadAnimation(c(), 17432577));
        this.U.startAnimation(AnimationUtils.loadAnimation(c(), 17432576));
      }
      while (true)
      {
        this.T.setVisibility(8);
        this.U.setVisibility(0);
        break;
        this.T.clearAnimation();
        this.U.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.T.startAnimation(AnimationUtils.loadAnimation(c(), 17432576));
      this.U.startAnimation(AnimationUtils.loadAnimation(c(), 17432577));
    }
    while (true)
    {
      this.T.setVisibility(0);
      this.U.setVisibility(8);
      break;
      this.T.clearAnimation();
      this.U.clearAnimation();
    }
  }

  private void z()
  {
    if (this.Q != null)
      return;
    View localView1 = f();
    if (localView1 == null)
      throw new IllegalStateException("Content view not yet created");
    if ((localView1 instanceof ListView))
    {
      this.Q = ((ListView)localView1);
      label42: this.W = true;
      this.Q.setOnItemClickListener(this.Z);
      if (this.P == null)
        break label258;
      ListAdapter localListAdapter = this.P;
      this.P = null;
      a(localListAdapter);
    }
    while (true)
    {
      this.X.post(this.Y);
      break;
      this.S = ((TextView)localView1.findViewById(16711681));
      if (this.S == null)
        this.R = localView1.findViewById(16908292);
      View localView2;
      while (true)
      {
        this.T = localView1.findViewById(16711682);
        this.U = localView1.findViewById(16711683);
        localView2 = localView1.findViewById(16908298);
        if ((localView2 instanceof ListView))
          break;
        if (localView2 == null)
        {
          throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
          this.S.setVisibility(8);
          continue;
        }
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      }
      this.Q = ((ListView)localView2);
      if (this.R != null)
      {
        this.Q.setEmptyView(this.R);
        break label42;
      }
      if (this.V == null)
        break label42;
      this.S.setText(this.V);
      this.Q.setEmptyView(this.S);
      break label42;
      label258: if (this.T == null)
        continue;
      a(false, false);
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    h localh = c();
    FrameLayout localFrameLayout1 = new FrameLayout(localh);
    LinearLayout localLinearLayout = new LinearLayout(localh);
    localLinearLayout.setId(16711682);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setVisibility(8);
    localLinearLayout.setGravity(17);
    localLinearLayout.addView(new ProgressBar(localh, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
    localFrameLayout1.addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
    FrameLayout localFrameLayout2 = new FrameLayout(localh);
    localFrameLayout2.setId(16711683);
    TextView localTextView = new TextView(c());
    localTextView.setId(16711681);
    localTextView.setGravity(17);
    localFrameLayout2.addView(localTextView, new FrameLayout.LayoutParams(-1, -1));
    ListView localListView = new ListView(c());
    localListView.setId(16908298);
    localListView.setDrawSelectorOnTop(false);
    localFrameLayout2.addView(localListView, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout1.addView(localFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return localFrameLayout1;
  }

  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    z();
  }

  public void a(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    if (this.P != null);
    for (int i = 1; ; i = 0)
    {
      this.P = paramListAdapter;
      if (this.Q != null)
      {
        this.Q.setAdapter(paramListAdapter);
        if ((!this.W) && (i == 0))
        {
          if (f().getWindowToken() != null)
            bool = true;
          a(true, bool);
        }
      }
      return;
    }
  }

  public void a(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
  }

  public void k()
  {
    this.X.removeCallbacks(this.Y);
    this.Q = null;
    this.W = false;
    this.U = null;
    this.T = null;
    this.R = null;
    this.S = null;
    super.k();
  }

  public ListView y()
  {
    z();
    return this.Q;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.y
 * JD-Core Version:    0.6.0
 */