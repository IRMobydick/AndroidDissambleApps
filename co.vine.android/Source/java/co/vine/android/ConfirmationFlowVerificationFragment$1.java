package co.vine.android;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

class ConfirmationFlowVerificationFragment$1
  implements TextWatcher
{
  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(this.val$confirmationBox.getText()))
      ConfirmationFlowVerificationFragment.access$100(this.this$0, true);
    while (true)
    {
      return;
      ConfirmationFlowVerificationFragment.access$100(this.this$0, false);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConfirmationFlowVerificationFragment.1
 * JD-Core Version:    0.6.0
 */