package dagger.internal;

import java.util.Iterator;
import java.util.List;

public final class ThrowingErrorHandler
  implements Linker.ErrorHandler
{
  public void handleErrors(List<String> paramList)
  {
    if (paramList.isEmpty())
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Errors creating object graph:");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("\n  ").append(str);
    }
    throw new IllegalStateException(localStringBuilder.toString());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.ThrowingErrorHandler
 * JD-Core Version:    0.6.2
 */