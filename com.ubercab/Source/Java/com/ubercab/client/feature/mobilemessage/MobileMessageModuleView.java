package com.ubercab.client.feature.mobilemessage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.ubercab.client.core.model.MobileMessageModule;
import java.util.HashSet;
import java.util.Set;

public class MobileMessageModuleView extends LinearLayout
  implements MobileMessageModuleContentView.Listener
{
  private final Set<Integer> mListReadyPages = new HashSet();
  private Listener mListener;
  private String mMessageId;
  private MobileMessageModule mModule;

  public MobileMessageModuleView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MobileMessageModuleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MobileMessageModuleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
  }

  MobileMessageModuleContentView createContentView(Context paramContext)
  {
    return new MobileMessageModuleContentView(getContext());
  }

  public String getMessageId()
  {
    return this.mMessageId;
  }

  public void loadModule(String paramString, MobileMessageModule paramMobileMessageModule, Object paramObject)
  {
    this.mMessageId = paramString;
    this.mModule = paramMobileMessageModule;
    this.mListReadyPages.clear();
    removeAllViews();
    for (int i = 0; i < paramMobileMessageModule.getPageCount(); i++)
    {
      MobileMessageModuleContentView localMobileMessageModuleContentView = createContentView(getContext());
      localMobileMessageModuleContentView.loadContent(paramMobileMessageModule, i, paramObject);
      localMobileMessageModuleContentView.setListener(this);
      addView(localMobileMessageModuleContentView, new LinearLayout.LayoutParams(-1, -2));
    }
  }

  public void onPageReadyForDisplay(int paramInt)
  {
    this.mListReadyPages.add(Integer.valueOf(paramInt));
    if ((this.mListReadyPages.size() == this.mModule.getPageCount()) && (this.mListener != null))
      this.mListener.onReadyForDisplay();
  }

  public void onUrlClicked(String paramString)
  {
    if (this.mListener != null)
      this.mListener.onUrlClicked(paramString);
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public static abstract interface Listener
  {
    public abstract void onReadyForDisplay();

    public abstract void onUrlClicked(String paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.MobileMessageModuleView
 * JD-Core Version:    0.6.2
 */