package retrofit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class RequestInterceptorTape
  implements RequestInterceptor.RequestFacade, RequestInterceptor
{
  private final List<CommandWithParams> tape = new ArrayList();

  public void addEncodedPathParam(String paramString1, String paramString2)
  {
    this.tape.add(new CommandWithParams(Command.ADD_ENCODED_PATH_PARAM, paramString1, paramString2));
  }

  public void addEncodedQueryParam(String paramString1, String paramString2)
  {
    this.tape.add(new CommandWithParams(Command.ADD_ENCODED_QUERY_PARAM, paramString1, paramString2));
  }

  public void addHeader(String paramString1, String paramString2)
  {
    this.tape.add(new CommandWithParams(Command.ADD_HEADER, paramString1, paramString2));
  }

  public void addPathParam(String paramString1, String paramString2)
  {
    this.tape.add(new CommandWithParams(Command.ADD_PATH_PARAM, paramString1, paramString2));
  }

  public void addQueryParam(String paramString1, String paramString2)
  {
    this.tape.add(new CommandWithParams(Command.ADD_QUERY_PARAM, paramString1, paramString2));
  }

  public void intercept(RequestInterceptor.RequestFacade paramRequestFacade)
  {
    Iterator localIterator = this.tape.iterator();
    while (localIterator.hasNext())
    {
      CommandWithParams localCommandWithParams = (CommandWithParams)localIterator.next();
      localCommandWithParams.command.intercept(paramRequestFacade, localCommandWithParams.name, localCommandWithParams.value);
    }
  }

  private static abstract enum Command
  {
    static
    {
      // Byte code:
      //   0: new 17	retrofit/RequestInterceptorTape$Command$1
      //   3: dup
      //   4: ldc 18
      //   6: iconst_0
      //   7: invokespecial 22	retrofit/RequestInterceptorTape$Command$1:<init>	(Ljava/lang/String;I)V
      //   10: putstatic 24	retrofit/RequestInterceptorTape$Command:ADD_HEADER	Lretrofit/RequestInterceptorTape$Command;
      //   13: new 26	retrofit/RequestInterceptorTape$Command$2
      //   16: dup
      //   17: ldc 27
      //   19: iconst_1
      //   20: invokespecial 28	retrofit/RequestInterceptorTape$Command$2:<init>	(Ljava/lang/String;I)V
      //   23: putstatic 30	retrofit/RequestInterceptorTape$Command:ADD_PATH_PARAM	Lretrofit/RequestInterceptorTape$Command;
      //   26: new 32	retrofit/RequestInterceptorTape$Command$3
      //   29: dup
      //   30: ldc 33
      //   32: iconst_2
      //   33: invokespecial 34	retrofit/RequestInterceptorTape$Command$3:<init>	(Ljava/lang/String;I)V
      //   36: putstatic 36	retrofit/RequestInterceptorTape$Command:ADD_ENCODED_PATH_PARAM	Lretrofit/RequestInterceptorTape$Command;
      //   39: new 38	retrofit/RequestInterceptorTape$Command$4
      //   42: dup
      //   43: ldc 39
      //   45: iconst_3
      //   46: invokespecial 40	retrofit/RequestInterceptorTape$Command$4:<init>	(Ljava/lang/String;I)V
      //   49: putstatic 42	retrofit/RequestInterceptorTape$Command:ADD_QUERY_PARAM	Lretrofit/RequestInterceptorTape$Command;
      //   52: new 44	retrofit/RequestInterceptorTape$Command$5
      //   55: dup
      //   56: ldc 45
      //   58: iconst_4
      //   59: invokespecial 46	retrofit/RequestInterceptorTape$Command$5:<init>	(Ljava/lang/String;I)V
      //   62: putstatic 48	retrofit/RequestInterceptorTape$Command:ADD_ENCODED_QUERY_PARAM	Lretrofit/RequestInterceptorTape$Command;
      //   65: iconst_5
      //   66: anewarray 2	retrofit/RequestInterceptorTape$Command
      //   69: astore_0
      //   70: aload_0
      //   71: iconst_0
      //   72: getstatic 24	retrofit/RequestInterceptorTape$Command:ADD_HEADER	Lretrofit/RequestInterceptorTape$Command;
      //   75: aastore
      //   76: aload_0
      //   77: iconst_1
      //   78: getstatic 30	retrofit/RequestInterceptorTape$Command:ADD_PATH_PARAM	Lretrofit/RequestInterceptorTape$Command;
      //   81: aastore
      //   82: aload_0
      //   83: iconst_2
      //   84: getstatic 36	retrofit/RequestInterceptorTape$Command:ADD_ENCODED_PATH_PARAM	Lretrofit/RequestInterceptorTape$Command;
      //   87: aastore
      //   88: aload_0
      //   89: iconst_3
      //   90: getstatic 42	retrofit/RequestInterceptorTape$Command:ADD_QUERY_PARAM	Lretrofit/RequestInterceptorTape$Command;
      //   93: aastore
      //   94: aload_0
      //   95: iconst_4
      //   96: getstatic 48	retrofit/RequestInterceptorTape$Command:ADD_ENCODED_QUERY_PARAM	Lretrofit/RequestInterceptorTape$Command;
      //   99: aastore
      //   100: aload_0
      //   101: putstatic 50	retrofit/RequestInterceptorTape$Command:$VALUES	[Lretrofit/RequestInterceptorTape$Command;
      //   104: return
    }

    abstract void intercept(RequestInterceptor.RequestFacade paramRequestFacade, String paramString1, String paramString2);
  }

  private static final class CommandWithParams
  {
    final RequestInterceptorTape.Command command;
    final String name;
    final String value;

    CommandWithParams(RequestInterceptorTape.Command paramCommand, String paramString1, String paramString2)
    {
      this.command = paramCommand;
      this.name = paramString1;
      this.value = paramString2;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.RequestInterceptorTape
 * JD-Core Version:    0.6.2
 */