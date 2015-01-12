package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.AutoCompleteTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChipEditText extends AutoCompleteTextView
{
  private static final Set<String> DELIMITERS = new HashSet(Arrays.asList(new String[] { ",", "\n" }));
  private static final String THREAD_NAME = "chip_creator";
  private Adapter mAdapter;
  private float mChipHeight;
  private Collection<Chip> mCollectionChipsCache;
  private Handler mHandlerRequest;
  private Handler mHandlerResult = new ResultsHandler(this, null);
  private Listener mListener;
  private int mMaxChips = -1;

  public ChipEditText(Context paramContext)
  {
    this(paramContext, null);
  }

  public ChipEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }

  public ChipEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChipHeight = paramContext.getResources().getDimension(2131361846);
    setGravity(19);
    InputFilter[] arrayOfInputFilter = new InputFilter[1];
    arrayOfInputFilter[0] = new ChipInputFilter(null);
    setFilters(arrayOfInputFilter);
  }

  private void appendChip(Chip paramChip)
  {
    if (paramChip == null)
      return;
    ChipSpanBuilder localChipSpanBuilder = new ChipSpanBuilder(null);
    ChipSpan[] arrayOfChipSpan = (ChipSpan[])getText().getSpans(0, getText().length(), ChipSpan.class);
    int i = arrayOfChipSpan.length;
    for (int j = 0; j < i; j++)
      localChipSpanBuilder.appendChipSpan(arrayOfChipSpan[j]);
    if (findChipByContentDescription(paramChip.getContentDescription()) == null)
      localChipSpanBuilder.appendChipSpan(drawChip(paramChip));
    setText(localChipSpanBuilder);
    setSelection(getText().length());
  }

  private ChipSpan drawChip(Chip paramChip)
  {
    if (this.mAdapter == null)
      throw new IllegalStateException("Adapter is required to draw a chip");
    Bitmap localBitmap = this.mAdapter.drawChip(paramChip, (int)this.mChipHeight);
    if (localBitmap == null)
      return null;
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), localBitmap);
    localBitmapDrawable.setBounds(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    return new ChipSpan(paramChip, localBitmapDrawable);
  }

  private int getLastSpanEnd()
  {
    Editable localEditable = getText();
    ChipSpan[] arrayOfChipSpan = (ChipSpan[])localEditable.getSpans(0, localEditable.length(), ChipSpan.class);
    if (arrayOfChipSpan.length == 0)
      return 0;
    return localEditable.getSpanEnd(arrayOfChipSpan[(-1 + arrayOfChipSpan.length)]);
  }

  public boolean addChip(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mMaxChips == -1) || (getChips().size() >= this.mMaxChips))
      return false;
    if (this.mHandlerRequest == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("chip_creator", 10);
      localHandlerThread.start();
      this.mHandlerRequest = new ChipCreatorThreadHandler(localHandlerThread.getLooper(), this, null);
    }
    Message localMessage = this.mHandlerRequest.obtainMessage();
    localMessage.obj = paramString;
    localMessage.sendToTarget();
    return true;
  }

  public boolean commitPendingText()
  {
    return addChip(getPendingText());
  }

  public boolean enoughToFilter()
  {
    return getPendingText().length() >= getThreshold();
  }

  public Chip findChipByContentDescription(String paramString)
  {
    if (paramString == null)
      return null;
    Iterator localIterator = getChips().iterator();
    while (localIterator.hasNext())
    {
      Chip localChip = (Chip)localIterator.next();
      if (localChip.getContentDescription().equals(paramString))
        return localChip;
    }
    return null;
  }

  public Chip findChipByText(String paramString)
  {
    if (paramString == null)
      return null;
    Iterator localIterator = getChips().iterator();
    while (localIterator.hasNext())
    {
      Chip localChip = (Chip)localIterator.next();
      if (localChip.getText().equals(paramString))
        return localChip;
    }
    return null;
  }

  public Collection<Chip> getChips()
  {
    if (this.mCollectionChipsCache == null)
    {
      ArrayList localArrayList = new ArrayList();
      ChipSpan[] arrayOfChipSpan = (ChipSpan[])getText().getSpans(0, getText().length(), ChipSpan.class);
      int i = arrayOfChipSpan.length;
      for (int j = 0; j < i; j++)
        localArrayList.add(arrayOfChipSpan[j].getChip());
      this.mCollectionChipsCache = localArrayList;
    }
    return this.mCollectionChipsCache;
  }

  public int getMaxChips()
  {
    return this.mMaxChips;
  }

  public String getPendingText()
  {
    return getText().toString().substring(getLastSpanEnd());
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mHandlerRequest != null)
    {
      this.mHandlerRequest.getLooper().quit();
      this.mHandlerRequest = null;
    }
  }

  public void onEditorAction(int paramInt)
  {
    super.onEditorAction(paramInt);
    if (paramInt == 6)
      commitPendingText();
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
      commitPendingText();
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    ChipSpanBuilder localChipSpanBuilder = new ChipSpanBuilder(null);
    Chip[] arrayOfChip = localSavedState.mChips;
    int i = arrayOfChip.length;
    for (int j = 0; j < i; j++)
      localChipSpanBuilder.appendChipSpan(drawChip(arrayOfChip[j]));
    localChipSpanBuilder.append(localSavedState.mPendingText);
    setText(localChipSpanBuilder);
    setSelection(getText().length());
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Collection localCollection = getChips();
    SavedState.access$302(localSavedState, (Chip[])localCollection.toArray(new Chip[localCollection.size()]));
    SavedState.access$402(localSavedState, getPendingText());
    return localSavedState;
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCollectionChipsCache = null;
    if (this.mListener != null)
      this.mListener.onChipsChanged(getChips());
  }

  protected void performFiltering(CharSequence paramCharSequence, int paramInt)
  {
    super.performFiltering(getPendingText(), paramInt);
  }

  public void removeChip(Chip paramChip)
  {
    if (paramChip == null);
    while (!getChips().contains(paramChip))
      return;
    ChipSpanBuilder localChipSpanBuilder = new ChipSpanBuilder(null);
    for (ChipSpan localChipSpan : (ChipSpan[])getText().getSpans(0, getText().length(), ChipSpan.class))
      if (localChipSpan.getChip() != paramChip)
        localChipSpanBuilder.appendChipSpan(localChipSpan);
    setText(localChipSpanBuilder);
    setSelection(getText().length());
  }

  protected void replaceText(CharSequence paramCharSequence)
  {
    super.clearComposingText();
    if (paramCharSequence == null)
      return;
    addChip(paramCharSequence.toString());
  }

  public void setChipAdapter(Adapter paramAdapter)
  {
    this.mAdapter = paramAdapter;
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public void setMaxChips(int paramInt)
  {
    this.mMaxChips = paramInt;
  }

  public static abstract interface Adapter
  {
    public abstract ChipEditText.Chip createChipInBackground(String paramString);

    public abstract Bitmap drawChip(ChipEditText.Chip paramChip, int paramInt);
  }

  public static class Chip
    implements Parcelable
  {
    public static final Parcelable.Creator<Chip> CREATOR = new Parcelable.Creator()
    {
      public ChipEditText.Chip createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ChipEditText.Chip(paramAnonymousParcel.readString(), paramAnonymousParcel.readBundle(), paramAnonymousParcel.readString());
      }

      public ChipEditText.Chip[] newArray(int paramAnonymousInt)
      {
        return new ChipEditText.Chip[paramAnonymousInt];
      }
    };
    private String mContentDescription;
    private Bundle mData;
    private String mText;

    public Chip(String paramString1, Bundle paramBundle, String paramString2)
    {
      this.mData = paramBundle;
      this.mText = paramString1;
      this.mContentDescription = paramString2;
    }

    public int describeContents()
    {
      return 0;
    }

    public String getContentDescription()
    {
      return this.mContentDescription;
    }

    public Bundle getData()
    {
      return this.mData;
    }

    public String getText()
    {
      return this.mText;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mText);
      paramParcel.writeBundle(this.mData);
      paramParcel.writeString(this.mContentDescription);
    }
  }

  private static final class ChipCreatorThreadHandler extends Handler
  {
    private WeakReference<ChipEditText> mChipEditText;

    private ChipCreatorThreadHandler(Looper paramLooper, ChipEditText paramChipEditText)
    {
      super();
      this.mChipEditText = new WeakReference(paramChipEditText);
    }

    public void handleMessage(Message paramMessage)
    {
      String str = (String)paramMessage.obj;
      ChipEditText localChipEditText = (ChipEditText)this.mChipEditText.get();
      if (localChipEditText == null)
        return;
      ChipEditText.Chip localChip = localChipEditText.mAdapter.createChipInBackground(str);
      Message localMessage = localChipEditText.mHandlerResult.obtainMessage();
      localMessage.obj = localChip;
      localMessage.sendToTarget();
    }
  }

  private class ChipInputFilter
    implements InputFilter
  {
    private boolean mDisabled = false;

    private ChipInputFilter()
    {
    }

    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if (this.mDisabled)
        return null;
      if ((paramSpanned.length() == 0) || ((paramSpanned.length() > 0) && (paramInt3 == 0) && (paramInt4 == paramSpanned.length())))
        return null;
      if ((paramInt1 == 0) && (paramInt2 == 0));
      for (int i = 1; (ChipEditText.this.mMaxChips >= 0) && (ChipEditText.this.getChips().size() >= ChipEditText.this.mMaxChips) && (i == 0); i = 0)
        return "";
      if (ChipEditText.DELIMITERS.contains(paramCharSequence.toString()))
      {
        if (ChipEditText.this.getPendingText().length() != 0)
          ChipEditText.this.commitPendingText();
        return "";
      }
      if (i != 0)
      {
        ChipEditText.ChipSpan[] arrayOfChipSpan = (ChipEditText.ChipSpan[])paramSpanned.getSpans(paramInt3, paramInt4, ChipEditText.ChipSpan.class);
        if (arrayOfChipSpan.length > 0)
        {
          this.mDisabled = true;
          ChipEditText.this.removeChip(arrayOfChipSpan[0].getChip());
          this.mDisabled = false;
          return "";
        }
        return null;
      }
      if ((paramInt3 == paramSpanned.length()) || (paramInt4 >= ChipEditText.this.getLastSpanEnd()))
        return null;
      this.mDisabled = true;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpanned);
      localSpannableStringBuilder.append(paramCharSequence.subSequence(paramInt1, paramInt2));
      ChipEditText.this.setText(localSpannableStringBuilder);
      ChipEditText.this.setSelection(localSpannableStringBuilder.length());
      this.mDisabled = false;
      return "";
    }
  }

  private static class ChipSpan extends ImageSpan
  {
    private ChipEditText.Chip mChip;

    public ChipSpan(ChipEditText.Chip paramChip, Drawable paramDrawable)
    {
      super(1);
      this.mChip = paramChip;
    }

    public ChipEditText.Chip getChip()
    {
      return this.mChip;
    }
  }

  private static class ChipSpanBuilder extends SpannableStringBuilder
  {
    public void appendChipSpan(ChipEditText.ChipSpan paramChipSpan)
    {
      String str = paramChipSpan.getChip().getContentDescription() + ", ";
      int i = length();
      int j = i + str.length();
      append(str);
      setSpan(paramChipSpan, i, j, 33);
    }
  }

  public static abstract interface Listener
  {
    public abstract void onChipsChanged(Collection<ChipEditText.Chip> paramCollection);
  }

  private static final class ResultsHandler extends Handler
  {
    private WeakReference<ChipEditText> mChipEditText;

    private ResultsHandler(ChipEditText paramChipEditText)
    {
      this.mChipEditText = new WeakReference(paramChipEditText);
    }

    public void handleMessage(Message paramMessage)
    {
      ChipEditText.Chip localChip = (ChipEditText.Chip)paramMessage.obj;
      ChipEditText localChipEditText = (ChipEditText)this.mChipEditText.get();
      if (localChipEditText != null)
        localChipEditText.appendChip(localChip);
    }
  }

  public static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ChipEditText.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ChipEditText.SavedState(paramAnonymousParcel);
      }

      public ChipEditText.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ChipEditText.SavedState[paramAnonymousInt];
      }
    };
    private ChipEditText.Chip[] mChips;
    private String mPendingText;

    public SavedState(Parcel paramParcel)
    {
      super();
      Parcelable[] arrayOfParcelable = paramParcel.readParcelableArray(ChipEditText.Chip.class.getClassLoader());
      this.mChips = ((ChipEditText.Chip[])Arrays.copyOf(arrayOfParcelable, arrayOfParcelable.length, [Lcom.ubercab.client.core.ui.ChipEditText.Chip.class));
      this.mPendingText = paramParcel.readString();
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelableArray(this.mChips, 0);
      paramParcel.writeString(this.mPendingText);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.ChipEditText
 * JD-Core Version:    0.6.2
 */