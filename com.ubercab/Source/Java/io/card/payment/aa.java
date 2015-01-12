package io.card.payment;

import android.text.Editable;
import android.text.Spanned;

class aa
  implements ag
{
  private String a;

  public boolean a()
  {
    return (this.a != null) && (this.a.length() > 0);
  }

  public void afterTextChanged(Editable paramEditable)
  {
    this.a = paramEditable.toString().trim();
  }

  public final String b()
  {
    return this.a;
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public final boolean c()
  {
    return a();
  }

  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    return null;
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.aa
 * JD-Core Version:    0.6.2
 */