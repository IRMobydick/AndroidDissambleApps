package co.vine.android;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import co.vine.android.widget.PopupEditText.PopupEditTextListener;
import java.util.HashSet;

public class ComposeTokenizer
  implements MultiAutoCompleteTextView.Tokenizer
{
  public static final String TAGS_ADAPTER = "tags_adapter";
  public static final String USERS_ADAPTER = "users_adapter";
  private static final HashSet<Character> mDelimiters;
  private PopupEditText.PopupEditTextListener mCallback;

  static
  {
    HashSet localHashSet = new HashSet(32);
    localHashSet.add(Character.valueOf('\t'));
    localHashSet.add(Character.valueOf('\n'));
    localHashSet.add(Character.valueOf('.'));
    localHashSet.add(Character.valueOf('!'));
    localHashSet.add(Character.valueOf('?'));
    localHashSet.add(Character.valueOf(','));
    localHashSet.add(Character.valueOf(':'));
    localHashSet.add(Character.valueOf(';'));
    localHashSet.add(Character.valueOf('\''));
    localHashSet.add(Character.valueOf('"'));
    localHashSet.add(Character.valueOf('`'));
    localHashSet.add(Character.valueOf('/'));
    localHashSet.add(Character.valueOf('\\'));
    localHashSet.add(Character.valueOf('-'));
    localHashSet.add(Character.valueOf('='));
    localHashSet.add(Character.valueOf('+'));
    localHashSet.add(Character.valueOf('~'));
    localHashSet.add(Character.valueOf('$'));
    localHashSet.add(Character.valueOf('%'));
    localHashSet.add(Character.valueOf('^'));
    localHashSet.add(Character.valueOf('&'));
    localHashSet.add(Character.valueOf('*'));
    localHashSet.add(Character.valueOf('('));
    localHashSet.add(Character.valueOf(')'));
    localHashSet.add(Character.valueOf('['));
    localHashSet.add(Character.valueOf(']'));
    localHashSet.add(Character.valueOf('{'));
    localHashSet.add(Character.valueOf('}'));
    localHashSet.add(Character.valueOf('<'));
    localHashSet.add(Character.valueOf('>'));
    localHashSet.add(Character.valueOf('|'));
    mDelimiters = localHashSet;
  }

  public ComposeTokenizer(PopupEditText.PopupEditTextListener paramPopupEditTextListener)
  {
    this.mCallback = paramPopupEditTextListener;
  }

  public int findTokenEnd(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramInt;
    int j = paramCharSequence.length();
    if (i < j)
      if (!mDelimiters.contains(Character.valueOf(paramCharSequence.charAt(i))));
    while (true)
    {
      return i;
      i++;
      break;
      i = j;
    }
  }

  public int findTokenStart(CharSequence paramCharSequence, int paramInt)
  {
    int i = 1;
    if (paramInt <= 0)
      return paramInt;
    int j = paramInt;
    char c;
    do
    {
      j--;
      c = paramCharSequence.charAt(j);
    }
    while ((j > 0) && (!mDelimiters.contains(Character.valueOf(c))) && (c != '@') && (c != '#'));
    int k;
    if (c == '@')
    {
      k = i;
      label67: if (c != '#')
        break label153;
      label74: if (((k == 0) && (i == 0)) || ((j != 0) && (!mDelimiters.contains(Character.valueOf(paramCharSequence.charAt(j - 1)))) && (paramCharSequence.charAt(j - 1) != ' ')))
        break label156;
      if (k == 0)
        break label158;
      this.mCallback.setPopupAdapter("users_adapter");
    }
    while (true)
    {
      paramInt = j;
      break;
      k = 0;
      break label67;
      label153: i = 0;
      break label74;
      label156: break;
      label158: if (i == 0)
        continue;
      this.mCallback.setPopupAdapter("tags_adapter");
    }
  }

  public CharSequence terminateToken(CharSequence paramCharSequence)
  {
    Object localObject;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = new SpannableString(paramCharSequence + " ");
      TextUtils.copySpansFrom((Spanned)paramCharSequence, 0, paramCharSequence.length(), Object.class, (Spannable)localObject, 0);
    }
    while (true)
    {
      return localObject;
      localObject = paramCharSequence + " ";
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ComposeTokenizer
 * JD-Core Version:    0.6.0
 */