package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.api.VineComment;
import co.vine.android.api.VineEntity;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.util.Util.ProfileImageSize;
import co.vine.android.util.ViewUtil;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.SpanClickListener;
import co.vine.android.widget.StyledClickableSpan;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesSpan;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CommentsAdapter extends BaseAdapter
{
  private static final int SPAN_FLAGS = 33;
  private AppController mAppController;
  private TypefacesSpan mBoldSpan;
  private HashMap<String, Editable> mCommentSbs = new HashMap();
  private ArrayList<VineComment> mComments = new ArrayList();
  private Context mContext;
  private HashMap<Long, Integer> mIdToPositionMap = new HashMap();
  final SpanClickListener mListener;
  final ArrayList<WeakReference<CommentViewHolder>> mViewHolders = new ArrayList();
  private int mVineGreen;

  public CommentsAdapter(Context paramContext, AppController paramAppController, SpanClickListener paramSpanClickListener)
  {
    this.mContext = paramContext;
    this.mBoldSpan = new TypefacesSpan(null, Typefaces.get(paramContext).getContentTypeface(1, 3));
    this.mAppController = paramAppController;
    this.mListener = paramSpanClickListener;
    this.mVineGreen = paramContext.getResources().getColor(2131296413);
  }

  private void rebuildIdToPositionMap()
  {
    this.mIdToPositionMap.clear();
    for (int i = 0; i < this.mComments.size(); i++)
    {
      VineComment localVineComment = (VineComment)this.mComments.get(i);
      this.mIdToPositionMap.put(Long.valueOf(localVineComment.commentId), Integer.valueOf(i));
    }
  }

  public void addMyComment(VineComment paramVineComment)
  {
    this.mComments.add(paramVineComment);
    rebuildIdToPositionMap();
    notifyDataSetChanged();
  }

  public void bindView(View paramView, VineComment paramVineComment)
  {
    CommentViewHolder localCommentViewHolder = (CommentViewHolder)paramView.getTag();
    String str1 = paramVineComment.username;
    String str2 = paramVineComment.comment;
    ArrayList localArrayList = paramVineComment.entities;
    if (str1 == null)
    {
      str1 = "";
      CrashUtil.logException(new VineLoggingException(), "Username is null for " + paramVineComment.commentId, new Object[0]);
    }
    localCommentViewHolder.content.setMovementMethod(LinkMovementMethod.getInstance());
    localCommentViewHolder.timestamp.setText(Util.getRelativeTimeString(this.mContext, paramVineComment.timestamp, false));
    localCommentViewHolder.commentId = String.valueOf(paramVineComment.commentId);
    localCommentViewHolder.userId = paramVineComment.userId;
    Object localObject = (Editable)this.mCommentSbs.get(localCommentViewHolder.commentId);
    if (localObject == null)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
      localObject = localSpannableStringBuilder.append(" ").append(str2);
      this.mCommentSbs.put(localCommentViewHolder.commentId, localObject);
      Util.safeSetSpan((Spannable)localObject, this.mBoldSpan, 0, str1.length(), 33);
      StyledClickableSpan localStyledClickableSpan1 = new StyledClickableSpan(1, Long.valueOf(localCommentViewHolder.userId), this.mListener);
      localStyledClickableSpan1.setColor(this.mVineGreen);
      Util.safeSetSpan((Spannable)localObject, localStyledClickableSpan1, 0, str1.length(), 33);
      if (localArrayList == null);
    }
    label408: label571: 
    while (true)
    {
      VineEntity localVineEntity;
      try
      {
        Util.adjustEntities(localArrayList, (Editable)localObject, 1 + str1.length(), false);
        Iterator localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
        {
          localVineEntity = (VineEntity)localIterator.next();
          if (!localVineEntity.isUserType())
            break label408;
          StyledClickableSpan localStyledClickableSpan2 = new StyledClickableSpan(1, Long.valueOf(localVineEntity.id), this.mListener);
          localStyledClickableSpan2.setColor(this.mVineGreen);
          Util.safeSetSpan((Spannable)localObject, localStyledClickableSpan2, localVineEntity.start, localVineEntity.end, 33);
          continue;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        CrashUtil.logException(localIndexOutOfBoundsException);
      }
      localCommentViewHolder.content.setText((CharSequence)localObject);
      String str3 = paramVineComment.avatarUrl;
      if (Util.isDefaultAvatarUrl(str3))
      {
        Util.safeSetDefaultAvatar(localCommentViewHolder.profileImage, Util.ProfileImageSize.MEDIUM, 0xFF000000 | this.mVineGreen);
        ViewUtil.setBackground(localCommentViewHolder.profileImage, null);
      }
      while (true)
      {
        return;
        if (!localVineEntity.isTagType())
          break label571;
        StyledClickableSpan localStyledClickableSpan3 = new StyledClickableSpan(3, localVineEntity.title, this.mListener);
        localStyledClickableSpan3.setColor(this.mVineGreen);
        Util.safeSetSpan((Spannable)localObject, localStyledClickableSpan3, localVineEntity.start, localVineEntity.end, 33);
        break;
        localCommentViewHolder.profileImage.setColorFilter(null);
        ImageKey localImageKey = new ImageKey(str3, true);
        localCommentViewHolder.imageKey = localImageKey;
        Bitmap localBitmap = this.mAppController.getPhotoBitmap(localImageKey);
        if (localBitmap != null)
        {
          ImageView localImageView = localCommentViewHolder.profileImage;
          RecyclableBitmapDrawable localRecyclableBitmapDrawable = new RecyclableBitmapDrawable(this.mContext.getResources(), localBitmap);
          localImageView.setImageDrawable(localRecyclableBitmapDrawable);
          continue;
        }
        ViewUtil.setBackground(localCommentViewHolder.profileImage, this.mContext.getResources().getDrawable(2130837753));
        localCommentViewHolder.profileImage.setImageDrawable(null);
      }
    }
  }

  public void deleteComment(long paramLong)
  {
    int i = getPositionForId(paramLong);
    this.mComments.remove(i);
    rebuildIdToPositionMap();
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.mComments.size();
  }

  public Object getItem(int paramInt)
  {
    return this.mComments.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return ((VineComment)this.mComments.get(paramInt)).commentId;
  }

  public int getPositionForId(long paramLong)
  {
    if ((this.mIdToPositionMap != null) && (this.mIdToPositionMap.get(Long.valueOf(paramLong)) != null));
    for (int i = ((Integer)this.mIdToPositionMap.get(Long.valueOf(paramLong))).intValue(); ; i = -1)
      return i;
  }

  @Nullable
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = newView();
    bindView(paramView, (VineComment)getItem(paramInt));
    return paramView;
  }

  public void mergeComments(ArrayList<VineComment> paramArrayList)
  {
    this.mComments.addAll(0, paramArrayList);
    rebuildIdToPositionMap();
    notifyDataSetChanged();
  }

  public View newView()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2130903077, null, false);
    CommentViewHolder localCommentViewHolder = new CommentViewHolder();
    localCommentViewHolder.profileImage = ((ImageView)localRelativeLayout.findViewById(2131361915));
    localCommentViewHolder.content = ((TextView)localRelativeLayout.findViewById(2131361889));
    localCommentViewHolder.content.setMovementMethod(LinkMovementMethod.getInstance());
    localCommentViewHolder.timestamp = ((TextView)localRelativeLayout.findViewById(2131361916));
    localRelativeLayout.setTag(localCommentViewHolder);
    this.mViewHolders.add(new WeakReference(localCommentViewHolder));
    return localRelativeLayout;
  }

  public void updateProfileImages(HashMap<ImageKey, UrlImage> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    int i = -1 + this.mViewHolders.size();
    if (i >= 0)
    {
      WeakReference localWeakReference2 = (WeakReference)this.mViewHolders.get(i);
      CommentViewHolder localCommentViewHolder = (CommentViewHolder)localWeakReference2.get();
      if (localCommentViewHolder == null)
        localArrayList.add(localWeakReference2);
      while (true)
      {
        i--;
        break;
        if (localCommentViewHolder.imageKey == null)
          continue;
        UrlImage localUrlImage = (UrlImage)paramHashMap.get(localCommentViewHolder.imageKey);
        if (localUrlImage == null)
          continue;
        localCommentViewHolder.profileImage.setImageDrawable(new RecyclableBitmapDrawable(this.mContext.getResources(), localUrlImage.bitmap));
      }
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference1 = (WeakReference)localIterator.next();
      this.mViewHolders.remove(localWeakReference1);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.CommentsAdapter
 * JD-Core Version:    0.6.0
 */