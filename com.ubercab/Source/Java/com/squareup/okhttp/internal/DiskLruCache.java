package com.squareup.okhttp.internal;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;

public final class DiskLruCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream()
  {
    public void write(int paramAnonymousInt)
      throws IOException
    {
    }
  };
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.this.journalWriter == null)
          return;
      }
      try
      {
        DiskLruCache.this.trimToSize();
        if (DiskLruCache.this.journalRebuildRequired())
        {
          DiskLruCache.this.rebuildJournal();
          DiskLruCache.access$402(DiskLruCache.this, 0);
        }
        return;
        localObject = finally;
        throw localObject;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
    }
  };
  private final File directory;
  final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true));
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  private BufferedSink journalWriter;
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  private long nextSequenceNumber = 0L;
  private int redundantOpCount;
  private long size = 0L;
  private final int valueCount;

  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
  }

  private void checkNotClosed()
  {
    if (this.journalWriter == null)
      throw new IllegalStateException("cache is closed");
  }

  private void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    Entry localEntry;
    try
    {
      localEntry = paramEditor.entry;
      if (localEntry.currentEditor != paramEditor)
        throw new IllegalStateException();
    }
    finally
    {
    }
    if ((paramBoolean) && (!localEntry.readable))
      for (int j = 0; j < this.valueCount; j++)
      {
        if (paramEditor.written[j] == 0)
        {
          paramEditor.abort();
          throw new IllegalStateException("Newly created entry didn't create value for index " + j);
        }
        if (!localEntry.getDirtyFile(j).exists())
        {
          paramEditor.abort();
          return;
        }
      }
    for (int i = 0; ; i++)
      if (i < this.valueCount)
      {
        File localFile1 = localEntry.getDirtyFile(i);
        if (paramBoolean)
        {
          if (localFile1.exists())
          {
            File localFile2 = localEntry.getCleanFile(i);
            localFile1.renameTo(localFile2);
            long l2 = localEntry.lengths[i];
            long l3 = localFile2.length();
            localEntry.lengths[i] = l3;
            this.size = (l3 + (this.size - l2));
          }
        }
        else
          deleteIfExists(localFile1);
      }
      else
      {
        this.redundantOpCount = (1 + this.redundantOpCount);
        Entry.access$702(localEntry, null);
        if ((paramBoolean | localEntry.readable))
        {
          Entry.access$602(localEntry, true);
          this.journalWriter.writeUtf8("CLEAN").writeByte(32);
          this.journalWriter.writeUtf8(localEntry.key);
          this.journalWriter.writeUtf8(localEntry.getLengths());
          this.journalWriter.writeByte(10);
          if (paramBoolean)
          {
            long l1 = this.nextSequenceNumber;
            this.nextSequenceNumber = (1L + l1);
            Entry.access$1202(localEntry, l1);
          }
        }
        while (true)
        {
          this.journalWriter.flush();
          if ((this.size <= this.maxSize) && (!journalRebuildRequired()))
            break;
          this.executorService.execute(this.cleanupRunnable);
          break;
          this.lruEntries.remove(localEntry.key);
          this.journalWriter.writeUtf8("REMOVE").writeByte(32);
          this.journalWriter.writeUtf8(localEntry.key);
          this.journalWriter.writeByte(10);
        }
      }
  }

  private static void deleteIfExists(File paramFile)
    throws IOException
  {
    if ((!paramFile.delete()) && (paramFile.exists()))
      throw new IOException("failed to delete " + paramFile);
  }

  private Editor edit(String paramString, long paramLong)
    throws IOException
  {
    while (true)
    {
      Entry localEntry;
      Editor localEditor1;
      try
      {
        checkNotClosed();
        validateKey(paramString);
        localEntry = (Entry)this.lruEntries.get(paramString);
        if (paramLong != -1L)
        {
          localEditor1 = null;
          if (localEntry != null)
          {
            long l = localEntry.sequenceNumber;
            boolean bool = l < paramLong;
            localEditor1 = null;
            if (!bool);
          }
          else
          {
            return localEditor1;
          }
        }
        if (localEntry == null)
        {
          localEntry = new Entry(paramString, null);
          this.lruEntries.put(paramString, localEntry);
          localEditor1 = new Editor(localEntry, null);
          Entry.access$702(localEntry, localEditor1);
          this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(paramString).writeByte(10);
          this.journalWriter.flush();
          continue;
        }
      }
      finally
      {
      }
      Editor localEditor2 = localEntry.currentEditor;
      if (localEditor2 != null)
        localEditor1 = null;
    }
  }

  private static String inputStreamToString(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      Buffer localBuffer = new Buffer();
      localBuffer.writeAll(Okio.source(paramInputStream));
      String str = localBuffer.readUtf8();
      return str;
    }
    finally
    {
      Util.closeQuietly(paramInputStream);
    }
  }

  private boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }

  public static DiskLruCache open(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0");
    File localFile1 = new File(paramFile, "journal.bkp");
    File localFile2;
    if (localFile1.exists())
    {
      localFile2 = new File(paramFile, "journal");
      if (!localFile2.exists())
        break label139;
      localFile1.delete();
    }
    while (true)
    {
      DiskLruCache localDiskLruCache1 = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
      if (localDiskLruCache1.journalFile.exists())
        try
        {
          localDiskLruCache1.readJournal();
          localDiskLruCache1.processJournal();
          localDiskLruCache1.journalWriter = Okio.buffer(Okio.sink(new FileOutputStream(localDiskLruCache1.journalFile, true)));
          return localDiskLruCache1;
          label139: renameTo(localFile1, localFile2, false);
        }
        catch (IOException localIOException)
        {
          Platform.get().logW("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
          localDiskLruCache1.delete();
        }
    }
    paramFile.mkdirs();
    DiskLruCache localDiskLruCache2 = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
    localDiskLruCache2.rebuildJournal();
    return localDiskLruCache2;
  }

  private void processJournal()
    throws IOException
  {
    deleteIfExists(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      if (localEntry.currentEditor == null)
      {
        for (int j = 0; j < this.valueCount; j++)
          this.size += localEntry.lengths[j];
      }
      else
      {
        Entry.access$702(localEntry, null);
        for (int i = 0; i < this.valueCount; i++)
        {
          deleteIfExists(localEntry.getCleanFile(i));
          deleteIfExists(localEntry.getDirtyFile(i));
        }
        localIterator.remove();
      }
    }
  }

  // ERROR //
  private void readJournal()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 136	com/squareup/okhttp/internal/DiskLruCache:journalFile	Ljava/io/File;
    //   4: invokestatic 440	okio/Okio:source	(Ljava/io/File;)Lokio/Source;
    //   7: invokestatic 443	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   10: astore_1
    //   11: aload_1
    //   12: invokeinterface 448 1 0
    //   17: astore_3
    //   18: aload_1
    //   19: invokeinterface 448 1 0
    //   24: astore 4
    //   26: aload_1
    //   27: invokeinterface 448 1 0
    //   32: astore 5
    //   34: aload_1
    //   35: invokeinterface 448 1 0
    //   40: astore 6
    //   42: aload_1
    //   43: invokeinterface 448 1 0
    //   48: astore 7
    //   50: ldc 29
    //   52: aload_3
    //   53: invokevirtual 454	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +54 -> 110
    //   59: ldc 38
    //   61: aload 4
    //   63: invokevirtual 454	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifeq +44 -> 110
    //   69: aload_0
    //   70: getfield 129	com/squareup/okhttp/internal/DiskLruCache:appVersion	I
    //   73: invokestatic 459	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   76: aload 5
    //   78: invokevirtual 454	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +29 -> 110
    //   84: aload_0
    //   85: getfield 142	com/squareup/okhttp/internal/DiskLruCache:valueCount	I
    //   88: invokestatic 459	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   91: aload 6
    //   93: invokevirtual 454	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifeq +14 -> 110
    //   99: ldc_w 461
    //   102: aload 7
    //   104: invokevirtual 454	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +77 -> 184
    //   110: new 151	java/io/IOException
    //   113: dup
    //   114: new 225	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 463
    //   124: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_3
    //   128: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 465
    //   134: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 4
    //   139: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 465
    //   145: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 6
    //   150: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 465
    //   156: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 7
    //   161: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 467
    //   167: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokespecial 314	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: astore_2
    //   178: aload_1
    //   179: invokestatic 356	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   182: aload_2
    //   183: athrow
    //   184: iconst_0
    //   185: istore 8
    //   187: aload_0
    //   188: aload_1
    //   189: invokeinterface 448 1 0
    //   194: invokespecial 470	com/squareup/okhttp/internal/DiskLruCache:readJournalLine	(Ljava/lang/String;)V
    //   197: iinc 8 1
    //   200: goto -13 -> 187
    //   203: astore 9
    //   205: aload_0
    //   206: iload 8
    //   208: aload_0
    //   209: getfield 90	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   212: invokevirtual 359	java/util/LinkedHashMap:size	()I
    //   215: isub
    //   216: putfield 191	com/squareup/okhttp/internal/DiskLruCache:redundantOpCount	I
    //   219: aload_1
    //   220: invokestatic 356	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   223: return
    //
    // Exception table:
    //   from	to	target	type
    //   11	110	177	finally
    //   110	177	177	finally
    //   187	197	177	finally
    //   205	219	177	finally
    //   187	197	203	java/io/EOFException
  }

  private void readJournalLine(String paramString)
    throws IOException
  {
    int i = paramString.indexOf(' ');
    if (i == -1)
      throw new IOException("unexpected journal line: " + paramString);
    int j = i + 1;
    int k = paramString.indexOf(' ', j);
    String str;
    if (k == -1)
    {
      str = paramString.substring(j);
      if ((i != "REMOVE".length()) || (!paramString.startsWith("REMOVE")))
        break label104;
      this.lruEntries.remove(str);
    }
    label104: 
    do
    {
      return;
      str = paramString.substring(j, k);
      Entry localEntry = (Entry)this.lruEntries.get(str);
      if (localEntry == null)
      {
        localEntry = new Entry(str, null);
        this.lruEntries.put(str, localEntry);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        String[] arrayOfString = paramString.substring(k + 1).split(" ");
        Entry.access$602(localEntry, true);
        Entry.access$702(localEntry, null);
        localEntry.setLengths(arrayOfString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        Entry.access$702(localEntry, new Editor(localEntry, null));
        return;
      }
    }
    while ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ")));
    throw new IOException("unexpected journal line: " + paramString);
  }

  private void rebuildJournal()
    throws IOException
  {
    BufferedSink localBufferedSink;
    while (true)
    {
      Entry localEntry;
      try
      {
        if (this.journalWriter != null)
          this.journalWriter.close();
        localBufferedSink = Okio.buffer(Okio.sink(new FileOutputStream(this.journalFileTmp)));
        try
        {
          localBufferedSink.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
          localBufferedSink.writeUtf8("1").writeByte(10);
          localBufferedSink.writeUtf8(Integer.toString(this.appVersion)).writeByte(10);
          localBufferedSink.writeUtf8(Integer.toString(this.valueCount)).writeByte(10);
          localBufferedSink.writeByte(10);
          Iterator localIterator = this.lruEntries.values().iterator();
          if (!localIterator.hasNext())
            break;
          localEntry = (Entry)localIterator.next();
          if (localEntry.currentEditor != null)
          {
            localBufferedSink.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink.writeUtf8(localEntry.key);
            localBufferedSink.writeByte(10);
            continue;
          }
        }
        finally
        {
          localBufferedSink.close();
        }
      }
      finally
      {
      }
      localBufferedSink.writeUtf8("CLEAN").writeByte(32);
      localBufferedSink.writeUtf8(localEntry.key);
      localBufferedSink.writeUtf8(localEntry.getLengths());
      localBufferedSink.writeByte(10);
    }
    localBufferedSink.close();
    if (this.journalFile.exists())
      renameTo(this.journalFile, this.journalFileBackup, true);
    renameTo(this.journalFileTmp, this.journalFile, false);
    this.journalFileBackup.delete();
    this.journalWriter = Okio.buffer(Okio.sink(new FileOutputStream(this.journalFile, true)));
  }

  private static void renameTo(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
      deleteIfExists(paramFile2);
    if (!paramFile1.renameTo(paramFile2))
      throw new IOException();
  }

  private void trimToSize()
    throws IOException
  {
    while (this.size > this.maxSize)
      remove((String)((Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
  }

  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches())
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
  }

  public void close()
    throws IOException
  {
    while (true)
    {
      int j;
      try
      {
        BufferedSink localBufferedSink = this.journalWriter;
        if (localBufferedSink == null)
          return;
        Object[] arrayOfObject = this.lruEntries.values().toArray();
        int i = arrayOfObject.length;
        j = 0;
        if (j < i)
        {
          Entry localEntry = (Entry)arrayOfObject[j];
          if (localEntry.currentEditor != null)
            localEntry.currentEditor.abort();
        }
        else
        {
          trimToSize();
          this.journalWriter.close();
          this.journalWriter = null;
          continue;
        }
      }
      finally
      {
      }
      j++;
    }
  }

  public void delete()
    throws IOException
  {
    close();
    Util.deleteContents(this.directory);
  }

  public Editor edit(String paramString)
    throws IOException
  {
    return edit(paramString, -1L);
  }

  public void flush()
    throws IOException
  {
    try
    {
      checkNotClosed();
      trimToSize();
      this.journalWriter.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Snapshot get(String paramString)
    throws IOException
  {
    try
    {
      checkNotClosed();
      validateKey(paramString);
      Entry localEntry = (Entry)this.lruEntries.get(paramString);
      Snapshot localSnapshot = null;
      if (localEntry == null);
      while (true)
      {
        return localSnapshot;
        boolean bool = localEntry.readable;
        localSnapshot = null;
        if (bool)
        {
          InputStream[] arrayOfInputStream = new InputStream[this.valueCount];
          int i = 0;
          while (true)
          {
            int j;
            int k;
            try
            {
              if (i >= this.valueCount)
                break label144;
              arrayOfInputStream[i] = new FileInputStream(localEntry.getCleanFile(i));
              i++;
              continue;
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              j = 0;
              k = this.valueCount;
              localSnapshot = null;
            }
            if (j >= k)
              break;
            InputStream localInputStream = arrayOfInputStream[j];
            localSnapshot = null;
            if (localInputStream == null)
              break;
            Util.closeQuietly(arrayOfInputStream[j]);
            j++;
          }
          label144: this.redundantOpCount = (1 + this.redundantOpCount);
          this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(paramString).writeByte(10);
          if (journalRebuildRequired())
            this.executorService.execute(this.cleanupRunnable);
          localSnapshot = new Snapshot(paramString, localEntry.sequenceNumber, arrayOfInputStream, localEntry.lengths, null);
        }
      }
    }
    finally
    {
    }
  }

  public File getDirectory()
  {
    return this.directory;
  }

  public long getMaxSize()
  {
    try
    {
      long l = this.maxSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isClosed()
  {
    return this.journalWriter == null;
  }

  public boolean remove(String paramString)
    throws IOException
  {
    try
    {
      checkNotClosed();
      validateKey(paramString);
      Entry localEntry = (Entry)this.lruEntries.get(paramString);
      if (localEntry != null)
      {
        Editor localEditor = localEntry.currentEditor;
        if (localEditor == null)
          break label46;
      }
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        label46: for (int i = 0; i < this.valueCount; i++)
        {
          deleteIfExists(localEntry.getCleanFile(i));
          this.size -= localEntry.lengths[i];
          localEntry.lengths[i] = 0L;
        }
        this.redundantOpCount = (1 + this.redundantOpCount);
        this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramString).writeByte(10);
        this.lruEntries.remove(paramString);
        if (journalRebuildRequired())
          this.executorService.execute(this.cleanupRunnable);
      }
    }
    finally
    {
    }
  }

  public void setMaxSize(long paramLong)
  {
    try
    {
      this.maxSize = paramLong;
      this.executorService.execute(this.cleanupRunnable);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long size()
  {
    try
    {
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final class Editor
  {
    private boolean committed;
    private final DiskLruCache.Entry entry;
    private boolean hasErrors;
    private final boolean[] written;

    private Editor(DiskLruCache.Entry arg2)
    {
      DiskLruCache.Entry localEntry;
      this.entry = localEntry;
      if (DiskLruCache.Entry.access$600(localEntry));
      for (boolean[] arrayOfBoolean = null; ; arrayOfBoolean = new boolean[DiskLruCache.this.valueCount])
      {
        this.written = arrayOfBoolean;
        return;
      }
    }

    public void abort()
      throws IOException
    {
      DiskLruCache.this.completeEdit(this, false);
    }

    public void abortUnlessCommitted()
    {
      if (!this.committed);
      try
      {
        abort();
        return;
      }
      catch (IOException localIOException)
      {
      }
    }

    public void commit()
      throws IOException
    {
      if (this.hasErrors)
      {
        DiskLruCache.this.completeEdit(this, false);
        DiskLruCache.this.remove(DiskLruCache.Entry.access$1100(this.entry));
      }
      while (true)
      {
        this.committed = true;
        return;
        DiskLruCache.this.completeEdit(this, true);
      }
    }

    public String getString(int paramInt)
      throws IOException
    {
      InputStream localInputStream = newInputStream(paramInt);
      if (localInputStream != null)
        return DiskLruCache.inputStreamToString(localInputStream);
      return null;
    }

    public InputStream newInputStream(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.Entry.access$700(this.entry) != this)
          throw new IllegalStateException();
      }
      if (!DiskLruCache.Entry.access$600(this.entry))
        return null;
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.entry.getCleanFile(paramInt));
        return localFileInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
      }
      return null;
    }

    public OutputStream newOutputStream(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.Entry.access$700(this.entry) != this)
          throw new IllegalStateException();
      }
      if (!DiskLruCache.Entry.access$600(this.entry))
        this.written[paramInt] = true;
      File localFile = this.entry.getDirtyFile(paramInt);
      try
      {
        localFileOutputStream = new FileOutputStream(localFile);
        FaultHidingOutputStream localFaultHidingOutputStream = new FaultHidingOutputStream(localFileOutputStream, null);
        return localFaultHidingOutputStream;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        while (true)
        {
          FileOutputStream localFileOutputStream;
          DiskLruCache.this.directory.mkdirs();
          try
          {
            localFileOutputStream = new FileOutputStream(localFile);
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            OutputStream localOutputStream = DiskLruCache.NULL_OUTPUT_STREAM;
            return localOutputStream;
          }
        }
      }
    }

    public void set(int paramInt, String paramString)
      throws IOException
    {
      BufferedSink localBufferedSink = Okio.buffer(Okio.sink(newOutputStream(paramInt)));
      localBufferedSink.writeUtf8(paramString);
      localBufferedSink.close();
    }

    private class FaultHidingOutputStream extends FilterOutputStream
    {
      private FaultHidingOutputStream(OutputStream arg2)
      {
        super();
      }

      public void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          DiskLruCache.Editor.access$2302(DiskLruCache.Editor.this, true);
        }
      }

      public void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          DiskLruCache.Editor.access$2302(DiskLruCache.Editor.this, true);
        }
      }

      public void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          DiskLruCache.Editor.access$2302(DiskLruCache.Editor.this, true);
        }
      }

      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException localIOException)
        {
          DiskLruCache.Editor.access$2302(DiskLruCache.Editor.this, true);
        }
      }
    }
  }

  private final class Entry
  {
    private DiskLruCache.Editor currentEditor;
    private final String key;
    private final long[] lengths;
    private boolean readable;
    private long sequenceNumber;

    private Entry(String arg2)
    {
      Object localObject;
      this.key = localObject;
      this.lengths = new long[DiskLruCache.this.valueCount];
    }

    private IOException invalidLengths(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }

    private void setLengths(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != DiskLruCache.this.valueCount)
        throw invalidLengths(paramArrayOfString);
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.lengths[i] = Long.parseLong(paramArrayOfString[i]);
          i++;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw invalidLengths(paramArrayOfString);
      }
    }

    public File getCleanFile(int paramInt)
    {
      return new File(DiskLruCache.this.directory, this.key + "." + paramInt);
    }

    public File getDirtyFile(int paramInt)
    {
      return new File(DiskLruCache.this.directory, this.key + "." + paramInt + ".tmp");
    }

    public String getLengths()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (long l : this.lengths)
        localStringBuilder.append(' ').append(l);
      return localStringBuilder.toString();
    }
  }

  public final class Snapshot
    implements Closeable
  {
    private final InputStream[] ins;
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;

    private Snapshot(String paramLong, long arg3, InputStream[] paramArrayOfLong, long[] arg6)
    {
      this.key = paramLong;
      this.sequenceNumber = ???;
      this.ins = paramArrayOfLong;
      Object localObject;
      this.lengths = localObject;
    }

    public void close()
    {
      InputStream[] arrayOfInputStream = this.ins;
      int i = arrayOfInputStream.length;
      for (int j = 0; j < i; j++)
        Util.closeQuietly(arrayOfInputStream[j]);
    }

    public DiskLruCache.Editor edit()
      throws IOException
    {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }

    public InputStream getInputStream(int paramInt)
    {
      return this.ins[paramInt];
    }

    public long getLength(int paramInt)
    {
      return this.lengths[paramInt];
    }

    public String getString(int paramInt)
      throws IOException
    {
      return DiskLruCache.inputStreamToString(getInputStream(paramInt));
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache
 * JD-Core Version:    0.6.2
 */