package com.ubercab.client.core.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;
import com.ubercab.library.util.PhoneNumberUtils;
import timber.log.Timber;

public final class ContactsUtil
{
  private static final String[] CONTACT_PROJECTION = { "_id", "data1", "display_name", "photo_thumb_uri" };

  public static Contact createFromCursor(Cursor paramCursor)
  {
    Contact localContact;
    if (paramCursor == null)
      localContact = null;
    String str;
    do
    {
      return localContact;
      localContact = new Contact(null);
      Contact.access$102(localContact, paramCursor.getInt(paramCursor.getColumnIndex("data2")));
      Contact.access$202(localContact, paramCursor.getString(paramCursor.getColumnIndex("data3")));
      Contact.access$302(localContact, paramCursor.getString(paramCursor.getColumnIndex("data1")));
      Contact.access$402(localContact, paramCursor.getString(paramCursor.getColumnIndex("display_name")));
      str = paramCursor.getString(paramCursor.getColumnIndex("photo_thumb_uri"));
    }
    while (TextUtils.isEmpty(str));
    Contact.access$502(localContact, Uri.parse(str));
    return localContact;
  }

  public static Contact getContactWithPhoneNumber(Context paramContext, String paramString)
  {
    Contact localContact;
    if (paramContext == null)
      localContact = null;
    while (true)
    {
      return localContact;
      Cursor localCursor = null;
      String str1 = "data1 = ?";
      try
      {
        String[] arrayOfString = { paramString };
        if (Build.VERSION.SDK_INT >= 16)
        {
          str1 = "data1 = ? OR data4 = ?";
          arrayOfString = new String[2];
          arrayOfString[0] = paramString;
          arrayOfString[1] = PhoneNumberUtils.getE164PhoneNumber(paramString, null);
        }
        localCursor = paramContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, CONTACT_PROJECTION, str1, arrayOfString, null);
        int i = localCursor.getCount();
        if (i == 0)
          return null;
        localCursor.moveToFirst();
        String str2 = localCursor.getString(localCursor.getColumnIndex("data1"));
        String str3 = localCursor.getString(localCursor.getColumnIndex("display_name"));
        String str4 = localCursor.getString(localCursor.getColumnIndex("photo_thumb_uri"));
        localContact = new Contact(null);
        Contact.access$302(localContact, str2);
        Contact.access$402(localContact, str3);
        if (!TextUtils.isEmpty(str4))
          Contact.access$502(localContact, Uri.parse(str4));
        return localContact;
      }
      catch (Exception localException)
      {
        Timber.e(localException, "Could not find contact with phone number %s", new Object[] { paramString });
        return null;
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
  }

  public static String getTypeOrLabel(Context paramContext, Contact paramContact)
  {
    if (paramContact == null)
      return "";
    if (paramContact.getType() == 0)
      return paramContact.getLabel();
    if (paramContext == null)
      return "";
    return paramContext.getString(ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(paramContact.getType()));
  }

  public static final class Contact
  {
    private String mDisplayName;
    private String mLabel;
    private String mNumber;
    private Uri mThumbnailUri;
    private int mType;

    public String getDisplayName()
    {
      return this.mDisplayName;
    }

    public String getLabel()
    {
      return this.mLabel;
    }

    public String getNumber()
    {
      return this.mNumber;
    }

    public Uri getThumbnailUri()
    {
      return this.mThumbnailUri;
    }

    public int getType()
    {
      return this.mType;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.ContactsUtil
 * JD-Core Version:    0.6.2
 */