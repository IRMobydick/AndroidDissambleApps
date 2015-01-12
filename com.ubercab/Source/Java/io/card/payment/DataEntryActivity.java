package io.card.payment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DateKeyListener;
import android.text.method.DigitsKeyListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public final class DataEntryActivity extends Activity
  implements TextWatcher
{
  private int a = 1;
  private int b = 100;
  private TextView c;
  private EditText d;
  private ag e;
  private EditText f;
  private ag g;
  private EditText h;
  private ag i;
  private EditText j;
  private ag k;
  private ImageView l;
  private Button m;
  private Button n;
  private CreditCard o;
  private boolean p;
  private String q;
  private final String r = getClass().getName();
  private boolean s;

  private void a()
  {
    if (this.o == null)
      this.o = new CreditCard();
    if (this.f != null)
    {
      this.o.expiryMonth = ((V)this.g).a;
      this.o.expiryYear = ((V)this.g).b;
    }
    CreditCard localCreditCard = new CreditCard(this.e.b(), this.o.expiryMonth, this.o.expiryYear, this.i.b(), this.k.b());
    Intent localIntent = new Intent();
    localIntent.putExtra("io.card.payment.scanResult", localCreditCard);
    setResult(CardIOActivity.RESULT_CARD_INFO, localIntent);
    finish();
  }

  private EditText b()
  {
    int i2;
    for (int i1 = 100; ; i1 = i2)
    {
      i2 = i1 + 1;
      EditText localEditText = (EditText)findViewById(i1);
      if (localEditText != null)
      {
        if ((localEditText.getText().length() == 0) && (localEditText.requestFocus()))
          return localEditText;
      }
      else
        return null;
    }
  }

  private void c()
  {
    Button localButton = this.m;
    if ((this.e.a()) && (this.g.a()) && (this.i.a()) && (this.k.a()));
    for (boolean bool = true; ; bool = false)
    {
      localButton.setEnabled(bool);
      if ((this.p) && (this.e.a()) && (this.g.a()) && (this.i.a()) && (this.k.a()))
        a();
      return;
    }
  }

  public final void afterTextChanged(Editable paramEditable)
  {
    String str;
    if ((this.d != null) && (paramEditable == this.d.getText()))
      if (this.e.c())
        if (!this.e.a())
        {
          this.d.setTextColor(l.d);
          if (this.h != null)
          {
            CardType localCardType = CardType.fromCardNumber(this.e.b().toString());
            W localW = (W)this.i;
            int i1 = localCardType.cvvLength();
            localW.a = i1;
            EditText localEditText = this.h;
            if (i1 != 4)
              break label147;
            str = "1234";
            label115: localEditText.setHint(str);
          }
        }
    while (true)
    {
      c();
      return;
      b();
      break;
      this.d.setTextColor(-12303292);
      break;
      label147: str = "123";
      break label115;
      if ((this.f != null) && (paramEditable == this.f.getText()))
      {
        if (this.g.c())
        {
          if (!this.g.a())
            this.f.setTextColor(l.d);
          else
            b();
        }
        else
          this.f.setTextColor(-12303292);
      }
      else if ((this.h != null) && (paramEditable == this.h.getText()))
      {
        if (this.i.c())
        {
          if (!this.i.a())
            this.h.setTextColor(l.d);
          else
            b();
        }
        else
          this.h.setTextColor(-12303292);
      }
      else if ((this.j != null) && (paramEditable == this.j.getText()))
        if (this.k.c())
        {
          if (!this.k.a())
            this.j.setTextColor(l.d);
          else
            b();
        }
        else
          this.j.setTextColor(-12303292);
    }
  }

  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  protected final void onCreate(Bundle paramBundle)
  {
    if (f.d())
    {
      setTheme(16973934);
      if (!f.d())
        break label69;
    }
    Bundle localBundle;
    label69: for (String str1 = "12dip"; ; str1 = "2dip")
    {
      this.q = str1;
      super.onCreate(paramBundle);
      localBundle = getIntent().getExtras();
      if (localBundle != null)
        break label75;
      throw new IllegalStateException("Didn't find any extras!");
      setTheme(16973836);
      break;
    }
    label75: an.a(getIntent());
    this.s = localBundle.getBoolean("io.card.payment.intentSenderIsPayPal");
    int i1 = m.a("4dip", this);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    localRelativeLayout.setBackgroundColor(l.c);
    ScrollView localScrollView = new ScrollView(this);
    int i2 = this.a;
    this.a = (i2 + 1);
    localScrollView.setId(i2);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams1.addRule(10);
    localRelativeLayout.addView(localScrollView, localLayoutParams1);
    LinearLayout localLinearLayout1 = new LinearLayout(this);
    localLinearLayout1.setOrientation(1);
    localScrollView.addView(localLinearLayout1, -1, -1);
    LinearLayout localLinearLayout2 = new LinearLayout(this);
    localLinearLayout2.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
    this.o = ((CreditCard)localBundle.getParcelable("io.card.payment.scanResult"));
    this.p = localBundle.getBoolean("debug_autoAcceptResult");
    LinearLayout localLinearLayout4;
    LinearLayout.LayoutParams localLayoutParams3;
    int i4;
    label440: String str2;
    label652: label794: label804: String str3;
    label1107: String str4;
    label1116: label1127: String str5;
    if (this.o != null)
    {
      this.e = new O(this.o.cardNumber);
      this.l = new ImageView(this);
      LinearLayout.LayoutParams localLayoutParams10 = new LinearLayout.LayoutParams(-1, -2);
      this.l.setPadding(0, 0, 0, i1);
      localLayoutParams10.weight = 1.0F;
      this.l.setImageBitmap(CardIOActivity.a);
      localLinearLayout2.addView(this.l, localLayoutParams10);
      m.b(this.l, null, null, null, "8dip");
      localLinearLayout4 = new LinearLayout(this);
      localLayoutParams3 = new LinearLayout.LayoutParams(-1, -2);
      m.a(localLinearLayout4, null, "4dip", null, null);
      localLinearLayout4.setOrientation(0);
      boolean bool1 = localBundle.getBoolean("io.card.payment.requireExpiry");
      boolean bool2 = localBundle.getBoolean("io.card.payment.requireCVV");
      if ((!localBundle.getBoolean("io.card.payment.requireZip")) && (!localBundle.getBoolean("io.card.payment.requirePostalCode")))
        break label2130;
      i4 = 1;
      if (!bool1)
        break label2156;
      LinearLayout localLinearLayout5 = new LinearLayout(this);
      LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(0, -1, 1.0F);
      localLinearLayout5.setOrientation(1);
      TextView localTextView2 = new TextView(this);
      localTextView2.setTextColor(l.e);
      localTextView2.setText(an.a(ao.k));
      m.a(localTextView2, this.q, null, null, null);
      localLinearLayout5.addView(localTextView2, -2, -2);
      EditText localEditText3 = new EditText(this);
      this.f = localEditText3;
      EditText localEditText4 = this.f;
      int i5 = this.b;
      this.b = (i5 + 1);
      localEditText4.setId(i5);
      this.f.setMaxLines(1);
      this.f.setImeOptions(6);
      this.f.setTextAppearance(getApplicationContext(), 16842816);
      this.f.setInputType(3);
      this.f.setHint(an.a(ao.n));
      if (this.o == null)
        break label2136;
      this.g = new V(this.o.expiryMonth, this.o.expiryYear);
      if (this.g.c())
      {
        this.f.setText(this.g.b());
        if (!this.g.a())
          this.f.setTextColor(l.d);
      }
      this.f.addTextChangedListener(this.g);
      this.f.addTextChangedListener(this);
      EditText localEditText5 = this.f;
      InputFilter[] arrayOfInputFilter2 = new InputFilter[2];
      arrayOfInputFilter2[0] = new DateKeyListener();
      arrayOfInputFilter2[1] = this.g;
      localEditText5.setFilters(arrayOfInputFilter2);
      localLinearLayout5.addView(this.f, -1, -2);
      localLinearLayout4.addView(localLinearLayout5, localLayoutParams4);
      if ((!bool2) && (i4 == 0))
        break label2150;
      str2 = "4dip";
      m.b(localLinearLayout5, null, null, str2, null);
      if (!bool2)
        break label2182;
      LinearLayout localLinearLayout6 = new LinearLayout(this);
      LinearLayout.LayoutParams localLayoutParams5 = new LinearLayout.LayoutParams(0, -1, 1.0F);
      localLinearLayout6.setOrientation(1);
      TextView localTextView3 = new TextView(this);
      localTextView3.setTextColor(l.e);
      m.a(localTextView3, this.q, null, null, null);
      localTextView3.setText(an.a(ao.i));
      localLinearLayout6.addView(localTextView3, -2, -2);
      this.h = new EditText(this);
      EditText localEditText6 = this.h;
      int i6 = this.b;
      this.b = (i6 + 1);
      localEditText6.setId(i6);
      this.h.setMaxLines(1);
      this.h.setImeOptions(6);
      this.h.setTextAppearance(getApplicationContext(), 16842816);
      this.h.setInputType(3);
      this.h.setHint("123");
      int i7 = 4;
      if (this.o != null)
        i7 = CardType.fromCardNumber(this.e.b()).cvvLength();
      W localW = new W(i7);
      this.i = localW;
      EditText localEditText7 = this.h;
      InputFilter[] arrayOfInputFilter3 = new InputFilter[2];
      arrayOfInputFilter3[0] = new DigitsKeyListener();
      arrayOfInputFilter3[1] = this.i;
      localEditText7.setFilters(arrayOfInputFilter3);
      this.h.addTextChangedListener(this.i);
      this.h.addTextChangedListener(this);
      localLinearLayout6.addView(this.h, -1, -2);
      localLinearLayout4.addView(localLinearLayout6, localLayoutParams5);
      if (!bool1)
        break label2170;
      str3 = "4dip";
      if (i4 == 0)
        break label2176;
      str4 = "4dip";
      m.b(localLinearLayout6, str3, null, str4, null);
      if (i4 == 0)
        break label2202;
      LinearLayout localLinearLayout7 = new LinearLayout(this);
      LinearLayout.LayoutParams localLayoutParams6 = new LinearLayout.LayoutParams(0, -1, 1.0F);
      localLinearLayout7.setOrientation(1);
      TextView localTextView4 = new TextView(this);
      localTextView4.setTextColor(l.e);
      m.a(localTextView4, this.q, null, null, null);
      localTextView4.setText(an.a(ao.j));
      localLinearLayout7.addView(localTextView4, -2, -2);
      this.j = new EditText(this);
      EditText localEditText8 = this.j;
      int i8 = this.b;
      this.b = (i8 + 1);
      localEditText8.setId(i8);
      this.j.setMaxLines(1);
      this.j.setImeOptions(6);
      this.j.setTextAppearance(getApplicationContext(), 16842816);
      this.j.setInputType(1);
      this.k = new Z();
      this.j.addTextChangedListener(this.k);
      this.j.addTextChangedListener(this);
      localLinearLayout7.addView(this.j, -1, -2);
      localLinearLayout4.addView(localLinearLayout7, localLayoutParams6);
      if ((!bool1) && (!bool2))
        break label2196;
      str5 = "4dip";
      label1355: m.b(localLinearLayout7, str5, null, null, null);
    }
    while (true)
    {
      localLinearLayout2.addView(localLinearLayout4, localLayoutParams3);
      localLinearLayout1.addView(localLinearLayout2, localLayoutParams2);
      m.b(localLinearLayout2, "16dip", "20dip", "16dip", "20dip");
      LinearLayout localLinearLayout8 = new LinearLayout(this);
      int i9 = this.a;
      this.a = (i9 + 1);
      localLinearLayout8.setId(i9);
      RelativeLayout.LayoutParams localLayoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams7.addRule(12);
      localLinearLayout8.setPadding(0, i1, 0, 0);
      localLinearLayout8.setBackgroundColor(0);
      localLayoutParams1.addRule(2, localLinearLayout8.getId());
      this.m = new Button(this);
      LinearLayout.LayoutParams localLayoutParams8 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      this.m.setText(an.a(ao.h));
      this.m.setOnClickListener(new S(this));
      this.m.setEnabled(false);
      localLinearLayout8.addView(this.m, localLayoutParams8);
      m.a(this.m, true, this);
      m.a(this.m, "5dip", null, "5dip", null);
      m.b(this.m, "8dip", "8dip", "4dip", "8dip");
      this.m.setTextSize(16.0F);
      this.n = new Button(this);
      LinearLayout.LayoutParams localLayoutParams9 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      this.n.setText(an.a(ao.b));
      this.n.setOnClickListener(new T(this));
      localLinearLayout8.addView(this.n, localLayoutParams9);
      m.a(this.n, false, this);
      m.a(this.n, "5dip", null, "5dip", null);
      m.b(this.n, "4dip", "8dip", "8dip", "8dip");
      this.n.setTextSize(16.0F);
      localRelativeLayout.addView(localLinearLayout8, localLayoutParams7);
      if (f.c())
        requestWindowFeature(8);
      setContentView(localRelativeLayout);
      boolean bool3 = this.s;
      BitmapDrawable localBitmapDrawable = null;
      if (bool3)
      {
        Bitmap localBitmap = m.a("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCNDMzRTRFQ0M2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCNDMzRTRFREM2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkI0MzNFNEVBQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkI0MzNFNEVCQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Eyd0MQAABoFJREFUeNrMWl1M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", this, 240);
        localBitmapDrawable = new BitmapDrawable(getResources(), localBitmap);
      }
      f.a(this, this.c, an.a(ao.s), "card.io - ", localBitmapDrawable);
      return;
      this.c = new TextView(this);
      this.c.setTextSize(24.0F);
      this.c.setTextColor(l.a);
      localLinearLayout2.addView(this.c);
      m.a(this.c, null, null, null, "8dip");
      m.a(this.c, -2, -2);
      LinearLayout localLinearLayout3 = new LinearLayout(this);
      localLinearLayout3.setOrientation(1);
      m.a(localLinearLayout3, null, "4dip", null, "4dip");
      TextView localTextView1 = new TextView(this);
      m.a(localTextView1, this.q, null, null, null);
      localTextView1.setText(an.a(ao.r));
      localTextView1.setTextColor(l.e);
      localLinearLayout3.addView(localTextView1, -2, -2);
      this.d = new EditText(this);
      EditText localEditText1 = this.d;
      int i3 = this.b;
      this.b = (i3 + 1);
      localEditText1.setId(i3);
      this.d.setMaxLines(1);
      this.d.setImeOptions(6);
      this.d.setTextAppearance(getApplicationContext(), 16842816);
      this.d.setInputType(3);
      this.d.setHint("1234 5678 1234 5678");
      this.e = new O();
      this.d.addTextChangedListener(this.e);
      this.d.addTextChangedListener(this);
      EditText localEditText2 = this.d;
      InputFilter[] arrayOfInputFilter1 = new InputFilter[2];
      arrayOfInputFilter1[0] = new DigitsKeyListener();
      arrayOfInputFilter1[1] = this.e;
      localEditText2.setFilters(arrayOfInputFilter1);
      localLinearLayout3.addView(this.d, -1, -2);
      localLinearLayout2.addView(localLinearLayout3, -1, -1);
      break;
      label2130: i4 = 0;
      break label440;
      label2136: this.g = new V();
      break label652;
      label2150: str2 = null;
      break label794;
      label2156: this.g = new b();
      break label804;
      label2170: str3 = null;
      break label1107;
      label2176: str4 = null;
      break label1116;
      label2182: this.i = new b();
      break label1127;
      label2196: str5 = null;
      break label1355;
      label2202: this.k = new b();
    }
  }

  protected final void onResume()
  {
    super.onResume();
    getWindow().setFlags(0, 1024);
    c();
    if ((this.d == null) && (this.f != null) && (!this.g.a()))
      this.f.requestFocus();
    while (true)
    {
      if ((this.d != null) || (this.f != null) || (this.h != null) || (this.j != null))
        getWindow().setSoftInputMode(5);
      return;
      b();
    }
  }

  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.DataEntryActivity
 * JD-Core Version:    0.6.2
 */