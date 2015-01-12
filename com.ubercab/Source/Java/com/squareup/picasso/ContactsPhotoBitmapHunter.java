package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import java.io.IOException;
import java.io.InputStream;

class ContactsPhotoBitmapHunter extends BitmapHunter
{
  private static final int ID_CONTACT = 3;
  private static final int ID_DISPLAY_PHOTO = 4;
  private static final int ID_LOOKUP = 1;
  private static final int ID_THUMBNAIL = 2;
  private static final UriMatcher matcher = new UriMatcher(-1);
  final Context context;

  static
  {
    matcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    matcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
    matcher.addURI("com.android.contacts", "contacts/#/photo", 2);
    matcher.addURI("com.android.contacts", "contacts/#", 3);
    matcher.addURI("com.android.contacts", "display_photo/#", 4);
  }

  ContactsPhotoBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    this.context = paramContext;
  }

  private Bitmap decodeStream(InputStream paramInputStream, Request paramRequest)
    throws IOException
  {
    if (paramInputStream == null)
      return null;
    BitmapFactory.Options localOptions = createBitmapOptions(paramRequest);
    InputStream localInputStream;
    if (requiresInSampleSize(localOptions))
      localInputStream = getInputStream();
    try
    {
      BitmapFactory.decodeStream(localInputStream, null, localOptions);
      Utils.closeQuietly(localInputStream);
      calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, localOptions);
      return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    }
    finally
    {
      Utils.closeQuietly(localInputStream);
    }
  }

  private InputStream getInputStream()
    throws IOException
  {
    ContentResolver localContentResolver = this.context.getContentResolver();
    Uri localUri = getData().uri;
    switch (matcher.match(localUri))
    {
    default:
      throw new IllegalStateException("Invalid uri: " + localUri);
    case 1:
      localUri = ContactsContract.Contacts.lookupContact(localContentResolver, localUri);
      if (localUri == null)
        return null;
    case 3:
      if (Build.VERSION.SDK_INT < 14)
        return ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, localUri);
      return ContactPhotoStreamIcs.get(localContentResolver, localUri);
    case 2:
    case 4:
    }
    return localContentResolver.openInputStream(localUri);
  }

  Bitmap decode(Request paramRequest)
    throws IOException
  {
    InputStream localInputStream = null;
    try
    {
      localInputStream = getInputStream();
      Bitmap localBitmap = decodeStream(localInputStream, paramRequest);
      return localBitmap;
    }
    finally
    {
      Utils.closeQuietly(localInputStream);
    }
  }

  Picasso.LoadedFrom getLoadedFrom()
  {
    return Picasso.LoadedFrom.DISK;
  }

  @TargetApi(14)
  private static class ContactPhotoStreamIcs
  {
    static InputStream get(ContentResolver paramContentResolver, Uri paramUri)
    {
      return ContactsContract.Contacts.openContactPhotoInputStream(paramContentResolver, paramUri, true);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ContactsPhotoBitmapHunter
 * JD-Core Version:    0.6.2
 */