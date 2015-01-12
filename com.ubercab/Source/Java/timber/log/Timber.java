package timber.log;

import android.util.Log;
import android.util.SparseBooleanArray;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Timber
{
  static final List<Tree> FOREST = new CopyOnWriteArrayList();
  static final SparseBooleanArray TAGGED_TREES = new SparseBooleanArray();
  private static final Tree TREE_OF_SOULS = new Tree()
  {
    public void d(String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).d(paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void d(Throwable paramAnonymousThrowable, String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).d(paramAnonymousThrowable, paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void e(String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).e(paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void e(Throwable paramAnonymousThrowable, String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).e(paramAnonymousThrowable, paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void i(String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).i(paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void i(Throwable paramAnonymousThrowable, String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).i(paramAnonymousThrowable, paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void v(String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).v(paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void v(Throwable paramAnonymousThrowable, String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).v(paramAnonymousThrowable, paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void w(String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).w(paramAnonymousString, paramAnonymousArrayOfObject);
    }

    public void w(Throwable paramAnonymousThrowable, String paramAnonymousString, Object[] paramAnonymousArrayOfObject)
    {
      Iterator localIterator = Timber.FOREST.iterator();
      while (localIterator.hasNext())
        ((Timber.Tree)localIterator.next()).w(paramAnonymousThrowable, paramAnonymousString, paramAnonymousArrayOfObject);
    }
  };

  public static void d(String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.d(paramString, paramArrayOfObject);
  }

  public static void d(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.d(paramThrowable, paramString, paramArrayOfObject);
  }

  public static void e(String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.e(paramString, paramArrayOfObject);
  }

  public static void e(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.e(paramThrowable, paramString, paramArrayOfObject);
  }

  public static void i(String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.i(paramString, paramArrayOfObject);
  }

  public static void i(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.i(paramThrowable, paramString, paramArrayOfObject);
  }

  public static void plant(Tree paramTree)
  {
    if ((paramTree instanceof TaggedTree))
      TAGGED_TREES.append(FOREST.size(), true);
    FOREST.add(paramTree);
  }

  public static Tree tag(String paramString)
  {
    int i = 0;
    int j = TAGGED_TREES.size();
    while (i < j)
    {
      ((TaggedTree)FOREST.get(TAGGED_TREES.keyAt(i))).tag(paramString);
      i++;
    }
    return TREE_OF_SOULS;
  }

  public static void uproot(Tree paramTree)
  {
    int i = 0;
    int j = FOREST.size();
    while (i < j)
    {
      if (FOREST.get(i) == paramTree)
      {
        TAGGED_TREES.delete(i);
        FOREST.remove(i);
        return;
      }
      i++;
    }
    throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + paramTree);
  }

  public static void uprootAll()
  {
    TAGGED_TREES.clear();
    FOREST.clear();
  }

  public static void v(String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.v(paramString, paramArrayOfObject);
  }

  public static void v(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.v(paramThrowable, paramString, paramArrayOfObject);
  }

  public static void w(String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.w(paramString, paramArrayOfObject);
  }

  public static void w(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    TREE_OF_SOULS.w(paramThrowable, paramString, paramArrayOfObject);
  }

  public static class DebugTree
    implements Timber.TaggedTree
  {
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("\\$\\d+$");
    private static final ThreadLocal<String> NEXT_TAG = new ThreadLocal();

    private static String createTag()
    {
      String str1 = (String)NEXT_TAG.get();
      if (str1 != null)
      {
        NEXT_TAG.remove();
        return str1;
      }
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      if (arrayOfStackTraceElement.length < 6)
        throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
      String str2 = arrayOfStackTraceElement[5].getClassName();
      Matcher localMatcher = ANONYMOUS_CLASS.matcher(str2);
      if (localMatcher.find())
        str2 = localMatcher.replaceAll("");
      return str2.substring(1 + str2.lastIndexOf('.'));
    }

    static String formatString(String paramString, Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject.length == 0)
        return paramString;
      return String.format(paramString, paramArrayOfObject);
    }

    private void throwShade(int paramInt, String paramString, Throwable paramThrowable)
    {
      String str;
      if ((paramString == null) || (paramString.length() == 0))
        if (paramThrowable != null)
        {
          paramString = Log.getStackTraceString(paramThrowable);
          str = createTag();
          if (paramString.length() >= 4000)
            break label78;
          Log.println(paramInt, str, paramString);
        }
      while (true)
      {
        return;
        if (paramThrowable == null)
          break;
        paramString = paramString + "\n" + Log.getStackTraceString(paramThrowable);
        break;
        label78: String[] arrayOfString = paramString.split("\n");
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
          Log.println(paramInt, str, arrayOfString[j]);
      }
    }

    public void d(String paramString, Object[] paramArrayOfObject)
    {
      throwShade(3, formatString(paramString, paramArrayOfObject), null);
    }

    public void d(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
      throwShade(3, formatString(paramString, paramArrayOfObject), paramThrowable);
    }

    public void e(String paramString, Object[] paramArrayOfObject)
    {
      throwShade(6, formatString(paramString, paramArrayOfObject), null);
    }

    public void e(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
      throwShade(6, formatString(paramString, paramArrayOfObject), paramThrowable);
    }

    public void i(String paramString, Object[] paramArrayOfObject)
    {
      throwShade(4, formatString(paramString, paramArrayOfObject), null);
    }

    public void i(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
      throwShade(4, formatString(paramString, paramArrayOfObject), paramThrowable);
    }

    public void tag(String paramString)
    {
      NEXT_TAG.set(paramString);
    }

    public void v(String paramString, Object[] paramArrayOfObject)
    {
      throwShade(2, formatString(paramString, paramArrayOfObject), null);
    }

    public void v(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
      throwShade(2, formatString(paramString, paramArrayOfObject), paramThrowable);
    }

    public void w(String paramString, Object[] paramArrayOfObject)
    {
      throwShade(5, formatString(paramString, paramArrayOfObject), null);
    }

    public void w(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
      throwShade(5, formatString(paramString, paramArrayOfObject), paramThrowable);
    }
  }

  public static class HollowTree
    implements Timber.Tree
  {
    public void d(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void d(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
    }

    public void e(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void e(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
    }

    public void i(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void i(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
    }

    public void v(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void v(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
    }

    public void w(String paramString, Object[] paramArrayOfObject)
    {
    }

    public void w(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
    }
  }

  public static abstract interface TaggedTree extends Timber.Tree
  {
    public abstract void tag(String paramString);
  }

  public static abstract interface Tree
  {
    public abstract void d(String paramString, Object[] paramArrayOfObject);

    public abstract void d(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject);

    public abstract void e(String paramString, Object[] paramArrayOfObject);

    public abstract void e(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject);

    public abstract void i(String paramString, Object[] paramArrayOfObject);

    public abstract void i(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject);

    public abstract void v(String paramString, Object[] paramArrayOfObject);

    public abstract void v(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject);

    public abstract void w(String paramString, Object[] paramArrayOfObject);

    public abstract void w(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     timber.log.Timber
 * JD-Core Version:    0.6.2
 */