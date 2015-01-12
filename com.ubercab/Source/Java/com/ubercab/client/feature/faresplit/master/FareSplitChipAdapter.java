package com.ubercab.client.feature.faresplit.master;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RecentFareSplitter;
import com.ubercab.client.core.ui.ChipEditText.Chip;
import com.ubercab.client.core.ui.ContactChipAdapter;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.util.PhoneNumberUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.inject.Inject;

public class FareSplitChipAdapter extends ContactChipAdapter
{
  private Collection<RecentFareSplitter> mListRecents;

  @Inject
  Picasso mPicasso;

  public FareSplitChipAdapter(Context paramContext)
  {
    super(paramContext);
    UberApplication.get(paramContext).inject(this);
    this.mListRecents = new ArrayList();
  }

  private Bitmap downloadBitmap(String paramString)
  {
    try
    {
      Bitmap localBitmap = this.mPicasso.load(paramString).get();
      return localBitmap;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  private RecentFareSplitter findByPhoneNumber(String paramString)
  {
    Iterator localIterator = this.mListRecents.iterator();
    while (localIterator.hasNext())
    {
      RecentFareSplitter localRecentFareSplitter = (RecentFareSplitter)localIterator.next();
      String str1 = localRecentFareSplitter.getMobileDigits();
      String str2 = localRecentFareSplitter.getMobileCountryIso2();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (PhoneNumberUtils.getE164PhoneNumber(str1, str2).equalsIgnoreCase(paramString)))
        return localRecentFareSplitter;
    }
    return null;
  }

  public ChipEditText.Chip createChipInBackground(String paramString)
  {
    RecentFareSplitter localRecentFareSplitter = findByPhoneNumber(paramString);
    if (localRecentFareSplitter == null)
      return super.createChipInBackground(paramString);
    boolean bool = TextUtils.isEmpty(localRecentFareSplitter.getPictureUrl());
    Bitmap localBitmap = null;
    if (!bool)
      localBitmap = downloadBitmap(localRecentFareSplitter.getPictureUrl());
    String str1 = localRecentFareSplitter.getName();
    Bundle localBundle = new Bundle();
    localBundle.putString("name", str1);
    localBundle.putString("number", paramString);
    localBundle.putParcelable("photo", localBitmap);
    String str2 = "";
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString)))
      str2 = String.format("%s (%s)", new Object[] { str1, paramString });
    while (true)
    {
      return new ChipEditText.Chip(paramString, localBundle, str2);
      if (!TextUtils.isEmpty(paramString))
        str2 = paramString;
    }
  }

  public void update(Ping paramPing)
  {
    if (paramPing == null)
    {
      this.mListRecents = new ArrayList();
      return;
    }
    this.mListRecents = paramPing.getClient().getRecentFareSplitters();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitChipAdapter
 * JD-Core Version:    0.6.2
 */