package co.vine.android;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ContactsPickerAdapter extends ArrayAdapter<ContactEntry>
{
  private static final int STATE_REGULAR = 2;
  private static final int STATE_SECTIONED = 1;
  private static final int STATE_UNKNOWN;
  private final ContactsRecipientPickerFragment mFragment;
  private int[] mRowHeaderStates;
  private SparseArray<WeakReference<ContactsPickerViewHolder>> mViewHolders;

  public ContactsPickerAdapter(ContactsRecipientPickerFragment paramContactsRecipientPickerFragment)
  {
    super(paramContactsRecipientPickerFragment.getActivity(), 0);
    this.mFragment = paramContactsRecipientPickerFragment;
    this.mViewHolders = new SparseArray();
  }

  private Integer getSelectionState(ContactEntry paramContactEntry)
  {
    int i = 1;
    Set localSet = paramContactEntry.valueMimeMap.keySet();
    boolean bool1 = false;
    boolean bool2 = false;
    Iterator localIterator = localSet.iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      String str = (String)localIterator.next();
      int j = ((Integer)paramContactEntry.valueMimeMap.get(str)).intValue();
      if ((!bool1) && (j == i))
        bool1 = this.mFragment.isRecipientSelected(VineRecipient.fromEmail(paramContactEntry.displayName, -1L, str, 0L));
      if ((bool2) || (j != 2))
        continue;
      bool2 = this.mFragment.isRecipientSelected(VineRecipient.fromPhone(paramContactEntry.displayName, -1L, str, 0L));
    }
    while ((!bool1) || (!bool2));
    if (bool1);
    while (true)
    {
      if (bool2)
        i |= 2;
      return Integer.valueOf(i);
      i = 0;
    }
  }

  private void invalidateHolderSelectors(ContactEntry paramContactEntry, ContactsPickerViewHolder paramContactsPickerViewHolder)
  {
    Integer localInteger = getSelectionState(paramContactEntry);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      if ((i & 0x1) == 0)
        break label53;
      paramContactsPickerViewHolder.emailIndicator.setSelected(true);
      label31: if ((i & 0x2) == 0)
        break label64;
      paramContactsPickerViewHolder.phoneIndicator.setSelected(true);
    }
    while (true)
    {
      return;
      i = 0;
      break;
      label53: paramContactsPickerViewHolder.emailIndicator.setSelected(false);
      break label31;
      label64: paramContactsPickerViewHolder.phoneIndicator.setSelected(false);
    }
  }

  public void addAll(Collection<? extends ContactEntry> paramCollection)
  {
    super.addAll(paramCollection);
    this.mRowHeaderStates = new int[paramCollection.size()];
  }

  public long getItemId(int paramInt)
  {
    ContactEntry localContactEntry = (ContactEntry)getItem(paramInt);
    long l;
    if (localContactEntry != null)
      l = localContactEntry.contactId;
    while (true)
    {
      return l;
      l = 0L;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    ContactsPickerViewHolder localContactsPickerViewHolder;
    ContactEntry localContactEntry;
    int j;
    label88: int k;
    label101: int m;
    label129: int n;
    label151: label235: View localView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(getContext()).inflate(2130903180, paramViewGroup, false);
      localContactsPickerViewHolder = new ContactsPickerViewHolder(paramView);
      paramView.setTag(localContactsPickerViewHolder);
      this.mViewHolders.put(paramInt, new WeakReference(localContactsPickerViewHolder));
      localContactEntry = (ContactEntry)getItem(paramInt);
      boolean bool = showSeparator(paramInt, localContactEntry);
      if ((0x1 & localContactEntry.typeFlag) == 0)
        break label293;
      j = 1;
      if ((0x2 & localContactEntry.typeFlag) == 0)
        break label299;
      k = 1;
      localContactsPickerViewHolder.username.setText(localContactEntry.displayName);
      ImageView localImageView1 = localContactsPickerViewHolder.emailIndicator;
      if (j == 0)
        break label305;
      m = 0;
      localImageView1.setVisibility(m);
      ImageView localImageView2 = localContactsPickerViewHolder.phoneIndicator;
      if (k == 0)
        break label312;
      n = 0;
      localImageView2.setVisibility(n);
      localContactsPickerViewHolder.contactId = localContactEntry.contactId;
      invalidateHolderSelectors(localContactEntry, localContactsPickerViewHolder);
      if (!bool)
        break label359;
      localContactsPickerViewHolder.separator.setVisibility(0);
      if (localContactEntry.alternateName == null)
        break label319;
      TextView localTextView2 = localContactsPickerViewHolder.separator;
      char[] arrayOfChar2 = new char[1];
      arrayOfChar2[0] = localContactEntry.alternateName.toUpperCase().charAt(0);
      localTextView2.setText(arrayOfChar2, 0, 1);
      if (paramInt + 1 < getCount())
      {
        localView = localContactsPickerViewHolder.divider;
        if (!showSeparator(paramInt + 1, (ContactEntry)getItem(paramInt + 1)))
          break label372;
      }
    }
    while (true)
    {
      localView.setVisibility(i);
      return paramView;
      localContactsPickerViewHolder = (ContactsPickerViewHolder)paramView.getTag();
      break;
      label293: j = 0;
      break label88;
      label299: k = 0;
      break label101;
      label305: m = i;
      break label129;
      label312: n = i;
      break label151;
      label319: TextView localTextView1 = localContactsPickerViewHolder.separator;
      char[] arrayOfChar1 = new char[1];
      arrayOfChar1[0] = localContactEntry.displayName.toUpperCase().charAt(0);
      localTextView1.setText(arrayOfChar1, 0, 1);
      break label235;
      label359: localContactsPickerViewHolder.separator.setVisibility(i);
      break label235;
      label372: i = 0;
    }
  }

  public void onRecipientItemAdded(ContactEntry paramContactEntry, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.mViewHolders.size();
    int j = 0;
    if (j < i)
    {
      ContactsPickerViewHolder localContactsPickerViewHolder = (ContactsPickerViewHolder)((WeakReference)this.mViewHolders.valueAt(j)).get();
      if (localContactsPickerViewHolder == null)
        localArrayList.add(Integer.valueOf(this.mViewHolders.keyAt(j)));
      while (true)
      {
        j++;
        break;
        if (localContactsPickerViewHolder.contactId != paramContactEntry.contactId)
          continue;
        if ((paramInt & 0x1) != 0)
        {
          localContactsPickerViewHolder.emailIndicator.setSelected(true);
          continue;
        }
        if ((paramInt & 0x2) == 0)
          continue;
        localContactsPickerViewHolder.phoneIndicator.setSelected(true);
      }
    }
    int k = localArrayList.size();
    for (int m = 0; m < k; m++)
      this.mViewHolders.remove(((Integer)localArrayList.get(m)).intValue());
  }

  public void onRecipientItemRemoved(ContactEntry paramContactEntry, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.mViewHolders.size();
    int j = 0;
    if (j < i)
    {
      ContactsPickerViewHolder localContactsPickerViewHolder = (ContactsPickerViewHolder)((WeakReference)this.mViewHolders.valueAt(j)).get();
      if (localContactsPickerViewHolder == null)
        localArrayList.add(Integer.valueOf(this.mViewHolders.keyAt(j)));
      while (true)
      {
        j++;
        break;
        if (localContactsPickerViewHolder.contactId != paramContactEntry.contactId)
          continue;
        invalidateHolderSelectors(paramContactEntry, localContactsPickerViewHolder);
      }
    }
    int k = localArrayList.size();
    for (int m = 0; m < k; m++)
      this.mViewHolders.remove(((Integer)localArrayList.get(m)).intValue());
  }

  public boolean showSeparator(int paramInt, ContactEntry paramContactEntry)
  {
    int i = 0;
    int[] arrayOfInt;
    switch (this.mRowHeaderStates[paramInt])
    {
    default:
      if (paramInt != 0)
        break;
      i = 1;
      arrayOfInt = this.mRowHeaderStates;
      if (i == 0);
    case 1:
    case 2:
    }
    for (int j = 1; ; j = 2)
    {
      arrayOfInt[paramInt] = j;
      while (true)
      {
        return i;
        i = 1;
        continue;
        i = 0;
      }
      ContactEntry localContactEntry = (ContactEntry)getItem(paramInt - 1);
      if ((localContactEntry.alternateName != null) && (paramContactEntry.alternateName != null))
      {
        if (localContactEntry.alternateName.toLowerCase().charAt(0) == paramContactEntry.alternateName.toLowerCase().charAt(0))
          break;
        i = 1;
        break;
      }
      if (localContactEntry.displayName.toLowerCase().charAt(0) == paramContactEntry.displayName.toLowerCase().charAt(0))
        break;
      i = 1;
      break;
    }
  }

  public static class ContactsPickerViewHolder
  {
    public long contactId;
    public View divider;
    public ImageView emailIndicator;
    public ImageView phoneIndicator;
    public int position;
    public TextView separator;
    public TextView username;

    public ContactsPickerViewHolder(View paramView)
    {
      this.emailIndicator = ((ImageView)paramView.findViewById(2131362105));
      this.phoneIndicator = ((ImageView)paramView.findViewById(2131362104));
      this.separator = ((TextView)paramView.findViewById(2131362251));
      this.username = ((TextView)paramView.findViewById(2131362106));
      this.divider = paramView.findViewById(2131361888);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ContactsPickerAdapter
 * JD-Core Version:    0.6.0
 */