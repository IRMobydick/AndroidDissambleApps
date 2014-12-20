package co.vine.android;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;

class ContactsRecipientPickerFragment$FilterRunnable
  implements Runnable
{
  private String mQuery;

  public ContactsRecipientPickerFragment$FilterRunnable(ContactsRecipientPickerFragment paramContactsRecipientPickerFragment, String paramString)
  {
    this.mQuery = paramString;
  }

  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("filter", this.mQuery);
    this.this$0.getLoaderManager().restartLoader(1, localBundle, this.this$0);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ContactsRecipientPickerFragment.FilterRunnable
 * JD-Core Version:    0.6.0
 */