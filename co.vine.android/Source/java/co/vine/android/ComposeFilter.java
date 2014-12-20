package co.vine.android;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import co.vine.android.provider.VineSuggestionsProvider;
import co.vine.android.widget.PopupEditText.PopupEditTextListener;

public class ComposeFilter extends Filter
{
  private Activity mActivity;
  private PopupEditText.PopupEditTextListener mCallback;
  private long mUserId;

  public ComposeFilter(PopupEditText.PopupEditTextListener paramPopupEditTextListener, long paramLong)
  {
    this.mActivity = ((Fragment)paramPopupEditTextListener).getActivity();
    this.mCallback = paramPopupEditTextListener;
    this.mUserId = paramLong;
  }

  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    String str;
    Uri localUri;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      CharSequence localCharSequence = paramCharSequence.subSequence(1, paramCharSequence.length());
      if (localCharSequence.length() <= 0)
        break label120;
      str = localCharSequence.toString();
      if (!paramCharSequence.toString().startsWith("@"))
        break label126;
      localUri = ContentUris.withAppendedId(VineSuggestionsProvider.USERS_URI, this.mUserId);
    }
    while (true)
    {
      if (localUri != null)
      {
        Cursor localCursor = this.mActivity.getContentResolver().query(localUri, null, str, null, null);
        if (localCursor != null)
        {
          localFilterResults.count = localCursor.getCount();
          localFilterResults.values = localCursor;
        }
      }
      return localFilterResults;
      label120: str = null;
      break;
      label126: if (paramCharSequence.toString().startsWith("#"))
      {
        localUri = VineSuggestionsProvider.TAGS_URI;
        continue;
      }
      localUri = null;
    }
  }

  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    CursorAdapter localCursorAdapter = this.mCallback.getPopupAdapter();
    Cursor localCursor1 = localCursorAdapter.getCursor();
    if (localCursor1 != null)
      this.mActivity.stopManagingCursor(localCursor1);
    Cursor localCursor2 = (Cursor)paramFilterResults.values;
    if (localCursor2 != null)
      this.mActivity.startManagingCursor(localCursor2);
    localCursorAdapter.changeCursor(localCursor2);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ComposeFilter
 * JD-Core Version:    0.6.0
 */