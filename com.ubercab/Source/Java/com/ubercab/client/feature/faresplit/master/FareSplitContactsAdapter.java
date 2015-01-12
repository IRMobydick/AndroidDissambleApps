package com.ubercab.client.feature.faresplit.master;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.ui.ChipEditText.Chip;
import com.ubercab.client.core.util.ContactsUtil;
import com.ubercab.library.util.PhoneNumberUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class FareSplitContactsAdapter extends CursorAdapter
  implements FilterQueryProvider
{
  private static final String[] PROJECTION = { "_id", "data1", "data2", "data3", "display_name", "photo_thumb_uri" };
  private static final String SORT_ORDER = "display_name, data1";
  private Collection<String> mCollectionChipNumbers = new HashSet();
  private Collection<String> mCollectionClientNumbers = new HashSet();
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private boolean mShowCheckboxes;

  public FareSplitContactsAdapter(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, false);
    this.mContext = paramContext;
    this.mShowCheckboxes = paramBoolean;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    setFilterQueryProvider(this);
    getFilter().filter(null);
  }

  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("data1"));
    String str2 = PhoneNumberUtils.getE164PhoneNumber(str1, null);
    if ((this.mCollectionClientNumbers.contains(str2)) || (this.mCollectionChipNumbers.contains(str1)));
    for (boolean bool = true; ; bool = false)
    {
      ((FareSplitContactViewHolder)paramView.getTag()).update(ContactsUtil.createFromCursor(paramCursor), bool);
      return;
    }
  }

  public CharSequence convertToString(Cursor paramCursor)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("data1"));
  }

  public boolean isEnabled(int paramInt)
  {
    Cursor localCursor = (Cursor)getItem(paramInt);
    String str = PhoneNumberUtils.getE164PhoneNumber(localCursor.getString(localCursor.getColumnIndex("data1")), null);
    return !this.mCollectionClientNumbers.contains(str);
  }

  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    View localView = this.mLayoutInflater.inflate(2130903087, paramViewGroup, false);
    localView.setTag(new FareSplitContactViewHolder(localView, this.mShowCheckboxes));
    return localView;
  }

  public Cursor runQuery(CharSequence paramCharSequence)
  {
    Uri localUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    if (!TextUtils.isEmpty(paramCharSequence))
      localUri = ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI.buildUpon().appendPath(paramCharSequence.toString()).build();
    return this.mContext.getContentResolver().query(localUri, PROJECTION, null, null, "display_name, data1");
  }

  public void setChips(Collection<ChipEditText.Chip> paramCollection)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localHashSet.add(((ChipEditText.Chip)localIterator.next()).getText());
    this.mCollectionChipNumbers = localHashSet;
    notifyDataSetChanged();
  }

  public void update(Ping paramPing)
  {
    this.mCollectionClientNumbers = paramPing.getFareSplit().getClientE164Numbers();
    notifyDataSetChanged();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitContactsAdapter
 * JD-Core Version:    0.6.2
 */