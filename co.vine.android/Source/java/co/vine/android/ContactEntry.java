package co.vine.android;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import java.util.HashMap;

public class ContactEntry
  implements Comparable<ContactEntry>
{
  public static final String[] sProjection;
  public static final String sSelection = "mimetype=? OR mimetype=?";
  public static final String[] sSelectionArgs;
  public static final String sSortOrder = "contact_id ASC ";
  public static final Uri sUri = ContactsContract.Data.CONTENT_URI;
  public String alternateName;
  public long contactId;
  public String displayName;
  public int typeFlag;
  public HashMap<String, Integer> valueMimeMap = new HashMap();

  static
  {
    String[] arrayOfString1 = new String[5];
    arrayOfString1[0] = "contact_id";
    arrayOfString1[1] = "display_name";
    arrayOfString1[2] = "display_name_alt";
    arrayOfString1[3] = "mimetype";
    arrayOfString1[4] = "data1";
    sProjection = arrayOfString1;
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = "vnd.android.cursor.item/email_v2";
    arrayOfString2[1] = "vnd.android.cursor.item/phone_v2";
    sSelectionArgs = arrayOfString2;
  }

  public ContactEntry(Cursor paramCursor)
  {
    this.contactId = paramCursor.getLong(0);
    this.displayName = paramCursor.getString(i);
    this.alternateName = paramCursor.getString(2);
    if ("vnd.android.cursor.item/email_v2".equals(paramCursor.getString(3)));
    while (true)
    {
      this.typeFlag = i;
      return;
      i = 2;
    }
  }

  private int getCompareResult(String paramString1, String paramString2)
  {
    boolean bool1 = Character.isLetter(paramString1.charAt(0));
    boolean bool2 = Character.isLetter(paramString2.charAt(0));
    int i;
    if (((bool1) && (bool2)) || ((!bool1) && (!bool2)))
      i = paramString1.compareTo(paramString2);
    while (true)
    {
      return i;
      if (bool1)
      {
        i = -1;
        continue;
      }
      i = 1;
    }
  }

  public int compareTo(ContactEntry paramContactEntry)
  {
    if ((this.alternateName != null) && (paramContactEntry.alternateName != null));
    for (int i = getCompareResult(this.alternateName.toLowerCase(), paramContactEntry.alternateName.toLowerCase()); ; i = getCompareResult(this.displayName.toLowerCase(), paramContactEntry.displayName.toLowerCase()))
      return i;
  }

  public boolean isSameSection(ContactEntry paramContactEntry)
  {
    int i = 0;
    if ((this.alternateName != null) && (paramContactEntry.alternateName != null))
      if (this.alternateName.toLowerCase().charAt(0) == paramContactEntry.alternateName.toLowerCase().charAt(0))
        break label68;
    while (true)
    {
      return i;
      if (this.displayName.toLowerCase().charAt(0) != paramContactEntry.displayName.toLowerCase().charAt(0))
        continue;
      label68: i = 1;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ContactEntry
 * JD-Core Version:    0.6.0
 */