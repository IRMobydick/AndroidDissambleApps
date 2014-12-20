package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.appcompat.R.attr;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class ListPopupWindow
{
  private static final boolean DEBUG = false;
  private static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int FILL_PARENT = -1;
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private static final String TAG = "ListPopupWindow";
  public static final int WRAP_CONTENT = -2;
  private ListAdapter mAdapter;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  private View mDropDownAnchorView;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  private DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private boolean mForceIgnoreOutsideTouch = false;
  private Handler mHandler = new Handler();
  private final ListSelectorHider mHideSelector = new ListSelectorHider(null);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mLayoutDirection;
  int mListItemExpandMaximum = 2147483647;
  private boolean mModal;
  private DataSetObserver mObserver;
  private PopupWindow mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable(null);
  private final PopupScrollListener mScrollListener = new PopupScrollListener(null);
  private Runnable mShowDropDownRunnable;
  private Rect mTempRect = new Rect();
  private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor(null);

  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }

  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }

  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.mContext = paramContext;
    this.mPopup = new PopupWindow(paramContext, paramAttributeSet, paramInt);
    this.mPopup.setInputMethodMode(1);
  }

  private int buildDropDown()
  {
    int i = 0;
    boolean bool2;
    Object localObject;
    View localView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams2;
    label252: int j;
    if (this.mDropDownList == null)
    {
      Context localContext = this.mContext;
      this.mShowDropDownRunnable = new Runnable()
      {
        public void run()
        {
          View localView = ListPopupWindow.this.getAnchorView();
          if ((localView != null) && (localView.getWindowToken() != null))
            ListPopupWindow.this.show();
        }
      };
      if (!this.mModal)
      {
        bool2 = true;
        this.mDropDownList = new DropDownListView(localContext, bool2);
        if (this.mDropDownListHighlight != null)
          this.mDropDownList.setSelector(this.mDropDownListHighlight);
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
          {
            if (paramInt != -1)
            {
              ListPopupWindow.DropDownListView localDropDownListView = ListPopupWindow.this.mDropDownList;
              if (localDropDownListView != null)
                ListPopupWindow.DropDownListView.access$502(localDropDownListView, false);
            }
          }

          public void onNothingSelected(AdapterView<?> paramAdapterView)
          {
          }
        });
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        if (this.mItemSelectedListener != null)
          this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
        localObject = this.mDropDownList;
        localView2 = this.mPromptView;
        if (localView2 != null)
        {
          localLinearLayout = new LinearLayout(localContext);
          localLinearLayout.setOrientation(1);
          localLayoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        }
        switch (this.mPromptPosition)
        {
        default:
          Log.e("ListPopupWindow", "Invalid hint position " + this.mPromptPosition);
          localView2.measure(View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, -2147483648), 0);
          LinearLayout.LayoutParams localLayoutParams3 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
          i = localView2.getMeasuredHeight() + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin;
          localObject = localLinearLayout;
          this.mPopup.setContentView((View)localObject);
          label309: j = 0;
          Drawable localDrawable = this.mPopup.getBackground();
          if (localDrawable == null)
            break;
          localDrawable.getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (!this.mDropDownVerticalOffsetSet)
            this.mDropDownVerticalOffset = (-this.mTempRect.top);
          label372: if (this.mPopup.getInputMethodMode() != 2);
        case 1:
        case 0:
        }
      }
    }
    int k;
    int m;
    for (boolean bool1 = true; ; bool1 = false)
    {
      k = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, bool1);
      if ((!this.mDropDownAlwaysVisible) && (this.mDropDownHeight != -1))
        break label537;
      m = k + j;
      return m;
      bool2 = false;
      break;
      localLinearLayout.addView((View)localObject, localLayoutParams2);
      localLinearLayout.addView(localView2);
      break label252;
      localLinearLayout.addView(localView2);
      localLinearLayout.addView((View)localObject, localLayoutParams2);
      break label252;
      ((ViewGroup)this.mPopup.getContentView());
      View localView1 = this.mPromptView;
      if (localView1 == null)
        break label309;
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localView1.getLayoutParams();
      i = localView1.getMeasuredHeight() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin;
      break label309;
      this.mTempRect.setEmpty();
      break label372;
    }
    label537: int n;
    switch (this.mDropDownWidth)
    {
    default:
      n = View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
    case -2:
    case -1:
    }
    while (true)
    {
      int i1 = this.mDropDownList.measureHeightOfChildrenCompat(n, 0, -1, k - i, -1);
      if (i1 > 0)
        i += j;
      m = i1 + i;
      break;
      n = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
      continue;
      n = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
    }
  }

  private void removePromptView()
  {
    if (this.mPromptView != null)
    {
      ViewParent localViewParent = this.mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup))
        ((ViewGroup)localViewParent).removeView(this.mPromptView);
    }
  }

  public void clearListSelection()
  {
    DropDownListView localDropDownListView = this.mDropDownList;
    if (localDropDownListView != null)
    {
      DropDownListView.access$502(localDropDownListView, true);
      localDropDownListView.requestLayout();
    }
  }

  public void dismiss()
  {
    this.mPopup.dismiss();
    removePromptView();
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }

  public View getAnchorView()
  {
    return this.mDropDownAnchorView;
  }

  public int getAnimationStyle()
  {
    return this.mPopup.getAnimationStyle();
  }

  public Drawable getBackground()
  {
    return this.mPopup.getBackground();
  }

  public int getHeight()
  {
    return this.mDropDownHeight;
  }

  public int getHorizontalOffset()
  {
    return this.mDropDownHorizontalOffset;
  }

  public int getInputMethodMode()
  {
    return this.mPopup.getInputMethodMode();
  }

  public ListView getListView()
  {
    return this.mDropDownList;
  }

  public int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = localRect.bottom;
    if (paramBoolean)
      i = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    int j = Math.max(i - (arrayOfInt[1] + paramView.getHeight()) - paramInt, paramInt + (arrayOfInt[1] - localRect.top));
    if (this.mPopup.getBackground() != null)
    {
      this.mPopup.getBackground().getPadding(this.mTempRect);
      j -= this.mTempRect.top + this.mTempRect.bottom;
    }
    return j;
  }

  public int getPromptPosition()
  {
    return this.mPromptPosition;
  }

  public Object getSelectedItem()
  {
    if (!isShowing());
    for (Object localObject = null; ; localObject = this.mDropDownList.getSelectedItem())
      return localObject;
  }

  public long getSelectedItemId()
  {
    long l;
    if (!isShowing())
      l = -9223372036854775808L;
    while (true)
    {
      return l;
      l = this.mDropDownList.getSelectedItemId();
    }
  }

  public int getSelectedItemPosition()
  {
    if (!isShowing());
    for (int i = -1; ; i = this.mDropDownList.getSelectedItemPosition())
      return i;
  }

  public View getSelectedView()
  {
    if (!isShowing());
    for (View localView = null; ; localView = this.mDropDownList.getSelectedView())
      return localView;
  }

  public int getSoftInputMode()
  {
    return this.mPopup.getSoftInputMode();
  }

  public int getVerticalOffset()
  {
    if (!this.mDropDownVerticalOffsetSet);
    for (int i = 0; ; i = this.mDropDownVerticalOffset)
      return i;
  }

  public int getWidth()
  {
    return this.mDropDownWidth;
  }

  public boolean isDropDownAlwaysVisible()
  {
    return this.mDropDownAlwaysVisible;
  }

  public boolean isInputMethodNotNeeded()
  {
    if (this.mPopup.getInputMethodMode() == 2);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean isModal()
  {
    return this.mModal;
  }

  public boolean isShowing()
  {
    return this.mPopup.isShowing();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    int k;
    ListAdapter localListAdapter;
    int i1;
    int i2;
    if ((isShowing()) && (paramInt != 62) && ((this.mDropDownList.getSelectedItemPosition() >= 0) || ((paramInt != 66) && (paramInt != 23))))
    {
      k = this.mDropDownList.getSelectedItemPosition();
      if (!this.mPopup.isAboveAnchor())
      {
        int m = i;
        localListAdapter = this.mAdapter;
        i1 = 2147483647;
        i2 = -2147483648;
        if (localListAdapter != null)
        {
          boolean bool = localListAdapter.areAllItemsEnabled();
          if (!bool)
            break label173;
          i1 = 0;
          label96: if (!bool)
            break label187;
          i2 = -1 + localListAdapter.getCount();
        }
        label113: if (((m == 0) || (paramInt != 19) || (k > i1)) && ((m != 0) || (paramInt != 20) || (k < i2)))
          break label210;
        clearListSelection();
        this.mPopup.setInputMethodMode(i);
        show();
      }
    }
    while (true)
    {
      return i;
      int n = 0;
      break;
      label173: i1 = this.mDropDownList.lookForSelectablePosition(0, i);
      break label96;
      label187: i2 = this.mDropDownList.lookForSelectablePosition(-1 + localListAdapter.getCount(), false);
      break label113;
      label210: DropDownListView.access$502(this.mDropDownList, false);
      if (this.mDropDownList.onKeyDown(paramInt, paramKeyEvent))
      {
        this.mPopup.setInputMethodMode(2);
        this.mDropDownList.requestFocusFromTouch();
        show();
        switch (paramInt)
        {
        case 19:
        case 20:
        case 23:
        case 66:
        }
      }
      label322: 
      do
      {
        do
        {
          int j = 0;
          break;
          if ((n == 0) || (paramInt != 20))
            break label322;
        }
        while (k != i2);
        break;
      }
      while ((n != 0) || (paramInt != 19) || (k != i1));
    }
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((isShowing()) && (this.mDropDownList.getSelectedItemPosition() >= 0))
    {
      bool = this.mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if (bool)
        switch (paramInt)
        {
        default:
        case 23:
        case 66:
        }
    }
    while (true)
    {
      return bool;
      dismiss();
      continue;
      bool = false;
    }
  }

  public boolean performItemClick(int paramInt)
  {
    if (isShowing())
      if (this.mItemClickListener != null)
      {
        DropDownListView localDropDownListView = this.mDropDownList;
        View localView = localDropDownListView.getChildAt(paramInt - localDropDownListView.getFirstVisiblePosition());
        ListAdapter localListAdapter = localDropDownListView.getAdapter();
        this.mItemClickListener.onItemClick(localDropDownListView, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
    for (int i = 1; ; i = 0)
      return i;
  }

  public void postShow()
  {
    this.mHandler.post(this.mShowDropDownRunnable);
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null)
      this.mObserver = new PopupDataSetObserver(null);
    while (true)
    {
      this.mAdapter = paramListAdapter;
      if (this.mAdapter != null)
        paramListAdapter.registerDataSetObserver(this.mObserver);
      if (this.mDropDownList != null)
        this.mDropDownList.setAdapter(this.mAdapter);
      return;
      if (this.mAdapter == null)
        continue;
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
    }
  }

  public void setAnchorView(View paramView)
  {
    this.mDropDownAnchorView = paramView;
  }

  public void setAnimationStyle(int paramInt)
  {
    this.mPopup.setAnimationStyle(paramInt);
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mPopup.setBackgroundDrawable(paramDrawable);
  }

  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.mPopup.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.mDropDownWidth = (paramInt + (this.mTempRect.left + this.mTempRect.right));
    }
    while (true)
    {
      return;
      setWidth(paramInt);
    }
  }

  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    this.mDropDownAlwaysVisible = paramBoolean;
  }

  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    this.mForceIgnoreOutsideTouch = paramBoolean;
  }

  public void setHeight(int paramInt)
  {
    this.mDropDownHeight = paramInt;
  }

  public void setHorizontalOffset(int paramInt)
  {
    this.mDropDownHorizontalOffset = paramInt;
  }

  public void setInputMethodMode(int paramInt)
  {
    this.mPopup.setInputMethodMode(paramInt);
  }

  void setListItemExpandMax(int paramInt)
  {
    this.mListItemExpandMaximum = paramInt;
  }

  public void setListSelector(Drawable paramDrawable)
  {
    this.mDropDownListHighlight = paramDrawable;
  }

  public void setModal(boolean paramBoolean)
  {
    this.mModal = true;
    this.mPopup.setFocusable(paramBoolean);
  }

  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }

  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.mItemSelectedListener = paramOnItemSelectedListener;
  }

  public void setPromptPosition(int paramInt)
  {
    this.mPromptPosition = paramInt;
  }

  public void setPromptView(View paramView)
  {
    boolean bool = isShowing();
    if (bool)
      removePromptView();
    this.mPromptView = paramView;
    if (bool)
      show();
  }

  public void setSelection(int paramInt)
  {
    DropDownListView localDropDownListView = this.mDropDownList;
    if ((isShowing()) && (localDropDownListView != null))
    {
      DropDownListView.access$502(localDropDownListView, false);
      localDropDownListView.setSelection(paramInt);
      if (localDropDownListView.getChoiceMode() != 0)
        localDropDownListView.setItemChecked(paramInt, true);
    }
  }

  public void setSoftInputMode(int paramInt)
  {
    this.mPopup.setSoftInputMode(paramInt);
  }

  public void setVerticalOffset(int paramInt)
  {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }

  public void setWidth(int paramInt)
  {
    this.mDropDownWidth = paramInt;
  }

  public void show()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i = -1;
    int j = buildDropDown();
    int k = 0;
    int m = 0;
    boolean bool3 = isInputMethodNotNeeded();
    if (this.mPopup.isShowing())
    {
      int n;
      int i1;
      if (this.mDropDownWidth == i)
      {
        n = -1;
        if (this.mDropDownHeight != i)
          break label217;
        if (!bool3)
          break label172;
        i1 = j;
        label64: if (!bool3)
          break label183;
        PopupWindow localPopupWindow4 = this.mPopup;
        if (this.mDropDownWidth != i)
          break label178;
        label83: localPopupWindow4.setWindowLayoutMode(i, 0);
      }
      while (true)
      {
        PopupWindow localPopupWindow2 = this.mPopup;
        if ((!this.mForceIgnoreOutsideTouch) && (!this.mDropDownAlwaysVisible))
          bool2 = bool1;
        localPopupWindow2.setOutsideTouchable(bool2);
        this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, n, i1);
        return;
        if (this.mDropDownWidth == -2)
        {
          n = getAnchorView().getWidth();
          break;
        }
        n = this.mDropDownWidth;
        break;
        label172: i1 = i;
        break label64;
        label178: i = 0;
        break label83;
        label183: PopupWindow localPopupWindow3 = this.mPopup;
        if (this.mDropDownWidth == i);
        for (int i2 = i; ; i2 = 0)
        {
          localPopupWindow3.setWindowLayoutMode(i2, i);
          break;
        }
        label217: if (this.mDropDownHeight == -2)
        {
          i1 = j;
          continue;
        }
        i1 = this.mDropDownHeight;
      }
    }
    label254: PopupWindow localPopupWindow1;
    if (this.mDropDownWidth == i)
    {
      k = -1;
      if (this.mDropDownHeight != i)
        break label424;
      m = -1;
      label266: this.mPopup.setWindowLayoutMode(k, m);
      localPopupWindow1 = this.mPopup;
      if ((this.mForceIgnoreOutsideTouch) || (this.mDropDownAlwaysVisible))
        break label459;
    }
    while (true)
    {
      localPopupWindow1.setOutsideTouchable(bool1);
      this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
      this.mPopup.showAsDropDown(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
      this.mDropDownList.setSelection(i);
      if ((!this.mModal) || (this.mDropDownList.isInTouchMode()))
        clearListSelection();
      if (this.mModal)
        break;
      this.mHandler.post(this.mHideSelector);
      break;
      if (this.mDropDownWidth == -2)
      {
        this.mPopup.setWidth(getAnchorView().getWidth());
        break label254;
      }
      this.mPopup.setWidth(this.mDropDownWidth);
      break label254;
      label424: if (this.mDropDownHeight == -2)
      {
        this.mPopup.setHeight(j);
        break label266;
      }
      this.mPopup.setHeight(this.mDropDownHeight);
      break label266;
      label459: bool1 = false;
    }
  }

  private static class DropDownListView extends ListView
  {
    public static final int INVALID_POSITION = -1;
    static final int NO_POSITION = -1;
    private static final String TAG = "ListPopupWindow.DropDownListView";
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;

    public DropDownListView(Context paramContext, boolean paramBoolean)
    {
      super(null, R.attr.dropDownListViewStyle);
      this.mHijackFocus = paramBoolean;
      setCacheColorHint(0);
    }

    private int lookForSelectablePosition(int paramInt, boolean paramBoolean)
    {
      int i = -1;
      ListAdapter localListAdapter = getAdapter();
      if ((localListAdapter == null) || (isInTouchMode()));
      while (true)
      {
        return i;
        int j = localListAdapter.getCount();
        if (!getAdapter().areAllItemsEnabled())
        {
          if (paramBoolean)
            for (k = Math.max(0, paramInt); (k < j) && (!localListAdapter.isEnabled(k)); k++);
          for (int k = Math.min(paramInt, j - 1); (k >= 0) && (!localListAdapter.isEnabled(k)); k--);
          if ((k < 0) || (k >= j))
            continue;
          i = k;
          continue;
        }
        if ((paramInt < 0) || (paramInt >= j))
          continue;
        i = paramInt;
      }
    }

    public boolean hasFocus()
    {
      if ((this.mHijackFocus) || (super.hasFocus()));
      for (int i = 1; ; i = 0)
        return i;
    }

    public boolean hasWindowFocus()
    {
      if ((this.mHijackFocus) || (super.hasWindowFocus()));
      for (int i = 1; ; i = 0)
        return i;
    }

    public boolean isFocused()
    {
      if ((this.mHijackFocus) || (super.isFocused()));
      for (int i = 1; ; i = 0)
        return i;
    }

    public boolean isInTouchMode()
    {
      if (((this.mHijackFocus) && (this.mListSelectionHidden)) || (super.isInTouchMode()));
      for (int i = 1; ; i = 0)
        return i;
    }

    final int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      int i = getListPaddingTop();
      int j = getListPaddingBottom();
      getListPaddingLeft();
      getListPaddingRight();
      int k = getDividerHeight();
      Drawable localDrawable = getDivider();
      ListAdapter localListAdapter = getAdapter();
      int i1;
      if (localListAdapter == null)
        i1 = i + j;
      while (true)
      {
        return i1;
        int m = i + j;
        int n;
        label76: View localView;
        int i2;
        int i3;
        if ((k > 0) && (localDrawable != null))
        {
          n = k;
          i1 = 0;
          localView = null;
          i2 = 0;
          i3 = localListAdapter.getCount();
        }
        for (int i4 = 0; ; i4++)
        {
          if (i4 >= i3)
            break label281;
          int i5 = localListAdapter.getItemViewType(i4);
          if (i5 != i2)
          {
            localView = null;
            i2 = i5;
          }
          localView = localListAdapter.getView(i4, localView, this);
          ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
          if ((localLayoutParams != null) && (localLayoutParams.height > 0));
          for (int i6 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824); ; i6 = View.MeasureSpec.makeMeasureSpec(0, 0))
          {
            localView.measure(paramInt1, i6);
            if (i4 > 0)
              m += n;
            m += localView.getMeasuredHeight();
            if (m < paramInt4)
              break label259;
            if ((paramInt5 >= 0) && (i4 > paramInt5) && (i1 > 0) && (m != paramInt4))
              break;
            i1 = paramInt4;
            break;
            n = 0;
            break label76;
          }
          label259: if ((paramInt5 < 0) || (i4 < paramInt5))
            continue;
          i1 = m;
        }
        label281: i1 = m;
      }
    }
  }

  private class ListSelectorHider
    implements Runnable
  {
    private ListSelectorHider()
    {
    }

    public void run()
    {
      ListPopupWindow.this.clearListSelection();
    }
  }

  private class PopupDataSetObserver extends DataSetObserver
  {
    private PopupDataSetObserver()
    {
    }

    public void onChanged()
    {
      if (ListPopupWindow.this.isShowing())
        ListPopupWindow.this.show();
    }

    public void onInvalidated()
    {
      ListPopupWindow.this.dismiss();
    }
  }

  private class PopupScrollListener
    implements AbsListView.OnScrollListener
  {
    private PopupScrollListener()
    {
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.mPopup.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
        ListPopupWindow.this.mResizePopupRunnable.run();
      }
    }
  }

  private class PopupTouchInterceptor
    implements View.OnTouchListener
  {
    private PopupTouchInterceptor()
    {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.mPopup != null) && (ListPopupWindow.this.mPopup.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.mPopup.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.mPopup.getHeight()))
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250L);
      while (true)
      {
        return false;
        if (i != 1)
          continue;
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
      }
    }
  }

  private class ResizePopupRunnable
    implements Runnable
  {
    private ResizePopupRunnable()
    {
    }

    public void run()
    {
      if ((ListPopupWindow.this.mDropDownList != null) && (ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount()) && (ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum))
      {
        ListPopupWindow.this.mPopup.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ListPopupWindow
 * JD-Core Version:    0.6.0
 */