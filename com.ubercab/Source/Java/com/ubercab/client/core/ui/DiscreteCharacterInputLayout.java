package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.FontUtils;
import com.ubercab.ui.TextWatcherAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiscreteCharacterInputLayout extends LinearLayout
{
  private static final String EMPTY = "";
  private static final int ERASE_INCORRECT_CHARACTERS_DELAY_MS = 500;
  private static final int STATUS_FAILURE = 1;
  private static final int STATUS_SUCCESS;
  private List<EditText> mCharacterTextViews;
  private String mExpectedString;
  private int mFocusedIndex;
  private Handler mHandler = new Handler();
  private Map<Character, Integer> mImageReplacements;
  private List<ImageView> mImageViews;
  private List<InputCompleteListener> mInputCompleteListeners = new CopyOnWriteArrayList();
  private SparseArray<Character> mReplacementIndices = new SparseArray();

  public DiscreteCharacterInputLayout(Context paramContext)
  {
    super(paramContext);
  }

  public DiscreteCharacterInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public DiscreteCharacterInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    UberApplication.get(paramContext).inject(this);
  }

  private void addCharacterView(String paramString)
  {
    EditText localEditText = new EditText(getContext());
    localEditText.setHintTextColor(getResources().getColor(2131296343));
    localEditText.setTextColor(getResources().getColor(2131296330));
    localEditText.setTypeface(FontUtils.getTypefaceFromResource(getContext(), 2131559277));
    localEditText.setTextSize(getResources().getDimensionPixelSize(2131361989));
    InputFilter[] arrayOfInputFilter = new InputFilter[1];
    arrayOfInputFilter[0] = new InputFilter.LengthFilter(1);
    localEditText.setFilters(arrayOfInputFilter);
    localEditText.setInputType(2);
    localEditText.addTextChangedListener(new TextWatcherAdapter()
    {
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() != 1);
        while (true)
        {
          return;
          if (DiscreteCharacterInputLayout.this.mFocusedIndex < -1 + DiscreteCharacterInputLayout.this.mCharacterTextViews.size())
          {
            DiscreteCharacterInputLayout.this.enableViewAtIndex(1 + DiscreteCharacterInputLayout.this.mFocusedIndex);
            return;
          }
          switch (DiscreteCharacterInputLayout.this.evaluate())
          {
          default:
            return;
          case 0:
            Iterator localIterator2 = DiscreteCharacterInputLayout.this.mInputCompleteListeners.iterator();
            while (localIterator2.hasNext())
              ((DiscreteCharacterInputLayout.InputCompleteListener)localIterator2.next()).onInputSuccess();
          case 1:
          }
          DiscreteCharacterInputLayout.this.mHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              DiscreteCharacterInputLayout.this.eraseAllText();
            }
          }
          , 500L);
          Iterator localIterator1 = DiscreteCharacterInputLayout.this.mInputCompleteListeners.iterator();
          while (localIterator1.hasNext())
            ((DiscreteCharacterInputLayout.InputCompleteListener)localIterator1.next()).onInputFail();
        }
      }
    });
    localEditText.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        Editable localEditable = ((EditText)DiscreteCharacterInputLayout.this.mCharacterTextViews.get(DiscreteCharacterInputLayout.this.mFocusedIndex)).getText();
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 67) && (DiscreteCharacterInputLayout.this.mFocusedIndex > 0) && (localEditable.length() == 0))
        {
          DiscreteCharacterInputLayout.this.enableViewAtIndex(-1 + DiscreteCharacterInputLayout.this.mFocusedIndex);
          ((EditText)DiscreteCharacterInputLayout.this.mCharacterTextViews.get(DiscreteCharacterInputLayout.this.mFocusedIndex)).setText("");
          return true;
        }
        return false;
      }
    });
    if (paramString != null)
      localEditText.setHint(paramString);
    addView(localEditText);
    this.mCharacterTextViews.add(localEditText);
  }

  private void addImageView(int paramInt)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(paramInt);
    localImageView.setBaselineAlignBottom(true);
    int i = getResources().getDimensionPixelSize(2131361970);
    localImageView.setPadding(i, 0, i, 0);
    addView(localImageView);
    this.mImageViews.add(localImageView);
  }

  private void enableViewAtIndex(int paramInt)
  {
    int i = 0;
    if (i < this.mCharacterTextViews.size())
    {
      EditText localEditText = (EditText)this.mCharacterTextViews.get(i);
      if (paramInt == i)
      {
        localEditText.setFocusableInTouchMode(true);
        localEditText.requestFocus();
      }
      while (true)
      {
        i++;
        break;
        localEditText.clearFocus();
        localEditText.setFocusableInTouchMode(false);
      }
    }
    this.mFocusedIndex = paramInt;
  }

  private void eraseAllText()
  {
    if ((this.mCharacterTextViews == null) || (this.mCharacterTextViews.isEmpty()))
      return;
    Iterator localIterator = this.mCharacterTextViews.iterator();
    while (localIterator.hasNext())
      ((EditText)localIterator.next()).setText("");
    enableViewAtIndex(0);
  }

  private int evaluate()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    if ((i < this.mExpectedString.length()) && (j < this.mCharacterTextViews.size()))
    {
      if (this.mReplacementIndices.get(i) != null)
        localStringBuilder.append(this.mReplacementIndices.get(i));
      while (true)
      {
        i++;
        break;
        localStringBuilder.append(((EditText)this.mCharacterTextViews.get(j)).getText());
        j++;
      }
    }
    if (localStringBuilder.toString().equals(this.mExpectedString))
      return 0;
    return 1;
  }

  private void initializeViews()
  {
    this.mCharacterTextViews = new ArrayList();
    this.mImageViews = new ArrayList();
    char[] arrayOfChar = this.mExpectedString.toCharArray();
    int i = 0;
    if (i < arrayOfChar.length)
    {
      char c = arrayOfChar[i];
      if (this.mImageReplacements.containsKey(Character.valueOf(c)))
      {
        this.mReplacementIndices.append(i, Character.valueOf(c));
        addImageView(((Integer)this.mImageReplacements.get(Character.valueOf(c))).intValue());
      }
      while (true)
      {
        i++;
        break;
        addCharacterView(String.valueOf(c));
      }
    }
    enableViewAtIndex(0);
    KeyboardUtils.showKeyboard(getContext());
  }

  public void addInputListener(InputCompleteListener paramInputCompleteListener)
  {
    this.mInputCompleteListeners.add(paramInputCompleteListener);
  }

  public void initializeValues(String paramString, Map<Character, Integer> paramMap)
  {
    if (paramString != null)
    {
      this.mExpectedString = paramString;
      this.mImageReplacements = paramMap;
    }
    initializeViews();
  }

  public void removeInputListener(InputCompleteListener paramInputCompleteListener)
  {
    this.mInputCompleteListeners.remove(paramInputCompleteListener);
  }

  public static abstract interface InputCompleteListener
  {
    public abstract void onInputFail();

    public abstract void onInputSuccess();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.DiscreteCharacterInputLayout
 * JD-Core Version:    0.6.2
 */